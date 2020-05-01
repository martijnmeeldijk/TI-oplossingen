# Oplossingen SQL-Dropbox (DB2)

## Inhoud

\* [Oplossingen SQL-Dropbox (DB2)](#oplossingen-sql-dropbox-db2)

   \* [Subq 2 verbreding](#subq-2-verbreding)

   \* [Optim](#optim)

   \* [Vensters](#vensters)

   \* [Joins Extra](#joins-extra)

   \* [Extra 4](#extra-4)

   \* [Extra 5](#extra-5)

## Subq 2 verbreding

Geef de diameter van het grootste hemellichaam dat bezocht is op de vroegste reis waar klantnr 126 niet op meegegaan is.

```postgreSQL
select  max(h.diameter) as grootste
from hemelobjecten h
inner join bezoeken b on(h.objectnaam = b.objectnaam)
inner join reizen r on (r.reisnr = b.reisnr)
inner join deelnames d on (r.reisnr = d.reisnr)
inner join klanten k on (k.klantnr = d.klantnr)

where k.klantnr != 126 and 0 = (
							select count(*) from reizen 
							where reizen.vertrekdatum < r.vertrekdatum)
```

Geef de deelnemers waarbij hun aantal reizen die ze ondernemen groter is dan alle hemelobjecten (die niet beginnen met de letter 'M') hun aantal keren dat ze bezocht zijn. Of anders geformuleerd:
Geef de deelnemers met meer deelnames dan het grootste aantal bezoeken aan een hemelobject dat niet met de letter 'M' begint (:deze deelnemer meer deelnames heeft dan de "grootste" .. = deze deelnemer heeft meer deelnames dan "alle" ..)
Sorteer op klantnr.

```postgreSQL
select k.klantnr, k.vnaam, k.naam, (select count(*) from deelnames where deelnames.klantnr = k.klantnr) as aantaldeelnames
from klanten k
where (select count(*) from deelnames where deelnames.klantnr = k.klantnr) > all (
	select count(bezoeken.objectnaam) 
	from bezoeken 
	inner join hemelobjecten using(objectnaam) 
	where hemelobjecten.objectnaam not like 'M%'
	group by bezoeken.objectnaam
)
```

Geef alle niet-bezochte hemelobjecten, buiten het grootste hemellichaam.
Sorteer op diameter en objectnaam.

```postgresSQL
select o.objectnaam, o.afstand, o.diameter
from hemelobjecten o
left outer join bezoeken b using(objectnaam)
where b.objectnaam is null

except

select o.objectnaam, o.afstand, o.diameter
from hemelobjecten o
where o.diameter >= all(select hemelobjecten.diameter from hemelobjecten)
order by 3,1
```



## Optim

Geef een lijst met het spelersnummer en de naam van de speler die in Rijswijk wonen en die in 1980 een boete gekregen hebben van 25 euro. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "(cost=2.37..2.37 rows=1 width=68)".

```postgreSQL
select s.spelersnr, s.naam
from spelers s inner join boetes b using(spelersnr)
where s.plaats = 'Rijswijk' and b.bedrag=25 and extract(year from b.datum) = 1980
order by 1,2
```

Geef de naam en het spelersnummer van de spelers die ooit penningmeester geweest zijn van de club, die bovendien ooit een boete betaald hebben van meer dan 75 euro, en die ooit een wedstrijd gewonnen hebben met meer dan 2 sets verschil. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "Unique (cost=100.38..100.54 rows=21 width=68)".

```postgreSQL
select s.naam, s.spelersnr
from spelers s inner join boetes b on(b.spelersnr = s.spelersnr)
inner join bestuursleden be on (be.spelersnr = s.spelersnr)
where b.bedrag>75 and extract(year from b.datum) = 1980 and be.functie = 'Penningmeester'
order by 1,2
```

Geef van elke speler het spelersnr, de naam en het verschil tussen zijn of haar jaar van toetreding en het gemiddeld jaar van toetreding. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "Sort (cost=33.16..33.66 rows=200 width=86)"

```postgreSQL
select s.spelersnr, s.naam, s.voorletters, (s.jaartoe - (select avg(spelers.jaartoe) from spelers)) as verschil
from spelers s 
order by 1,2,3,4
```



## Vensters

Geef per reis incrementeel de totale verblijfsduur volgens de volgorde waarin de hemelobjecten bezocht worden. Geef ook de totale verblijfsduur van alle reizen om alles in perspectief te zettten.
Sorteer op reisnr, volgnr, objectnaam, verblijfsduur, de volgende kolommen.

```postgreSQL
select r.reisnr, b.volgnr, b.objectnaam, b.verblijfsduur, sum(b.verblijfsduur)
OVER(partition by
r.reisnr
	 order by b.volgnr rows between unbounded
preceding and current row
	) as inc_duur, (select sum(bezoeken.verblijfsduur) from bezoeken) as tot_duur
from reizen r
left outer join bezoeken b using(reisnr)

order by 1,2,3,4,5,6
```

## Joins Extra

Hoeveel kilometers heeft iedereen in totaal gevlogen tot nu toe en hoeveel hebben ze hier in totaal voor betaald. Vermits we de posities van de planeten niet kennen, mag je de afstanden van de hemelobjecten direct gebruiken. Geef het totaal gespendeerde bedrag, de afgelegde kilometers, de prijs per kilometer en datum van hun laatste vlucht van al hun persoonlijke reizen. In het geval dat iemand niet op reis is geweest of geen kilometers gedaan heeft, toon je de boodschap 'veel geld voor niks of niet op reis geweest’ in de kolom prijs_per_kilometer.
Sorteer van voor naar achter.

```postgreSQL
select distinct k.klantnr, k.naam || ' ' || k.vnaam as naam, 
	(select sum(reizen.prijs) from klanten
	left outer join deelnames on(klanten.klantnr = deelnames.klantnr)
	inner join reizen on(reizen.reisnr = deelnames.reisnr)
	where k.klantnr = klanten.klantnr) as tot_bedrag,
	
	sum(h.afstand) as tot_afstand,
	
	case when 	(select sum(reizen.prijs) from klanten
				left outer join deelnames on(klanten.klantnr = deelnames.klantnr)
				inner join reizen on(reizen.reisnr = deelnames.reisnr)
				where k.klantnr = klanten.klantnr) = 0
				
				or
				
				sum(h.afstand) = 0
		then	'veel geld voor niks of niet op reis geweest'
		else
				
		((select sum(reizen.prijs) from klanten
		left outer join deelnames on(klanten.klantnr = deelnames.klantnr)
		inner join reizen on(reizen.reisnr = deelnames.reisnr)
		where k.klantnr = klanten.klantnr) / sum(h.afstand))::varchar 
		end
		
		as prijs_per_kilometer,
	
	(select max(reizen.vertrekdatum) from reizen
	 inner join deelnames on(deelnames.reisnr = reizen.reisnr)
	 where deelnames.klantnr = k.klantnr) as laatste_reis_datum
	
from klanten k
left outer join deelnames d on(k.klantnr = d.klantnr)
left outer join reizen r on(r.reisnr = d.reisnr)
left outer join bezoeken b on(b.reisnr = r.reisnr)
left outer join hemelobjecten h on(h.objectnaam = b.objectnaam)

group by 1,2, 3
order by 1,2,3,4,5
```



Geef voor elke reis het aantal klanten waarvan de naam niet met een 'G' begint en waarvan de periode van de geboortedatum van de klant tot de vertrekdatum van de reis overlapt met de huidige datum en 50 jaar verder (gebruik hiervoor de gepaste operator: OVERLAPS).
Indien er op de reis hemelobjecten worden bezocht waarvan de tweede letter van het hemelobject voorkomt in de naam van het hemelobject waarvan dit bezocht hemelobject een satelliet is, dan wordt deze reis genegeerd.
Sorteer op reisnr.

```postgreSQL
select r.reisnr, count(k.klantnr)
from klanten k 
inner join deelnames d on(k.klantnr = d.klantnr)
right outer join reizen r on (r.reisnr = d.reisnr)
where 
	(k.naam not like 'G%' or k.naam is null) 

	and ((k.geboortedatum, r.vertrekdatum)
	overlaps (now(), now()+ interval '50 years'))
	
	and r.reisnr not in (select reizen.reisnr
					from reizen 
					inner join bezoeken on(reizen.reisnr = bezoeken.reisnr)
					inner join hemelobjecten sat on (sat.objectnaam = bezoeken.objectnaam)
					inner join hemelobjecten main  on(sat.satellietvan = main.objectnaam)
					where main.objectnaam LIKE '%' || substring(sat.objectnaam, 2, 1) || '%'  )
	
	
group by r.reisnr
```

(Ik heb hier zo te zien niet gesorteerd, maar ze vragen het wel. Als deze oplossing fout rekent kan je misschien dat proberen)



## Extra 4

Maak een overzicht waarbij je voor de Maan en voor Mars aangeeft hoeveel ruimtereizen één of meer keer de betreffende bestemming bezocht hebben (d.w.z. erop geland zijn). Sorteer van voor naar achter.

```postgreSQL
select h.objectnaam, 
	(select count(distinct reizen.reisnr) from reizen
	 inner join bezoeken using(reisnr)
	 where bezoeken.objectnaam = h.objectnaam)
	
from hemelobjecten h

where h.objectnaam like 'Mars' or h.objectnaam like 'Maan'

order by 1,2
```

Maak een lijst van de mensen die Mars wel bezocht hebben maar Io nog niet. Sorteer van voor naar achter.

```postgreSQL
from klanten k

where k.klantnr not in 
(
	select klanten.klantnr
	from klanten
	inner join deelnames d on (klanten.klantnr = d.klantnr)
	inner join reizen r on (d.reisnr = r.reisnr)
	inner join bezoeken b on (r.reisnr = b.reisnr)
	inner join hemelobjecten h on (h.objectnaam = b.objectnaam)
	where h.objectnaam = 'Io'
)
and
k.klantnr in 
(
	select klanten.klantnr
	from klanten
	inner join deelnames d on (klanten.klantnr = d.klantnr)
	inner join reizen r on (d.reisnr = r.reisnr)
	inner join bezoeken b on (r.reisnr = b.reisnr)
	inner join hemelobjecten h on (h.objectnaam = b.objectnaam)
	where h.objectnaam = 'Mars'
)
```



Maak een overzicht waarbij je voor de Maan en voor Mars aangeeft hoeveel verschillende ruimtereizen er geweest zijn(d.w.z. erop geland zijn is voldoende). En enkel indien er meer dan 1 reis geweest is. Sorteer van voor naar achter

```postgreSQL
select h.objectnaam, 
	(select count(distinct reizen.reisnr) from reizen
	 inner join bezoeken using(reisnr)
	 where bezoeken.objectnaam = h.objectnaam)
	
from hemelobjecten h

where h.objectnaam like 'Mars' or h.objectnaam like 'Maan'

order by 1,2
```
Geef de klant die het meest op de maan is geweest (+het aantal). Sorteer van voor naar achter.
```postgreSQL
select klantnr, count(objectnaam)
from deelnames d inner join bezoeken b on(b.reisnr = d.reisnr)
where b.objectnaam = 'Maan'
group by klantnr
order by 2 desc
FETCH FIRST ROW ONLY
```
Maak een lijst met die mensen die meer dan 2 maal een reis ondernomen hebben waarin men geen enkele satelliet van Jupiter bezoekt !. Sorteer van voor naar achter.

```postgreSQL
select d.klantnr ,k.naam || k.vnaam  as "volledige naam", count(d.reisnr) as "aantal ondernomen reizen"
from deelnames d inner join klanten k on (d.klantnr = k.klantnr)
where d.reisnr not in (
	select r.reisnr from reizen r 
inner join bezoeken b on(r.reisnr = b.reisnr)
where objectnaam  in  
(select objectnaam
from hemelobjecten
where satellietvan = 'Jupiter')
)
group by d.klantnr, k.naam, k.vnaam
having count(d.reisnr)>2
```



## Extra 5

Geef de nummers van de wedstrijden gespeeld door een speler waarvan de naam begint met een B of D. Sorteer van voor naar achter.

```postgreSQL
select wedstrijdnr
from spelers s inner join wedstrijden 
using(spelersnr)
where s.naam like 'B%' or s.naam like 'D%'
order by 1
```

Geef van elke speler die minstens 1 wedstrijd gewonnen heeft voor team nr 1 en voor wie in totaal meer dan 100 euro aan boete betaald is, het spelersnummer, zijn naam, woonplaats en het totale boetebedrag. Sorteer van voor naar achter.

```postgreSQL
select s.spelersnr, s.naam, s.plaats, sum(b.bedrag)
from spelers s
inner join boetes b on (s.spelersnr = b.spelersnr)
where s.spelersnr in (select spelers.spelersnr
					  from spelers inner join wedstrijden using (spelersnr)
					  where gewonnen > verloren and teamnr = 1
					 )
group by 1,2,3
having sum(b.bedrag) > 100 
order by 1,2,3,4
```

Geef alle spelers voor wie meer boetes zijn betaald dan dat ze wedstrijden hebben gespeeld. Sorteer van voor naar achter

```postgreSQL
select s.naam, s.voorletters, s.geb_datum
from spelers s
where (select count(*)
	   from boetes 
	   where boetes.spelersnr = s.spelersnr)
		>
		(select count(*)
	   from wedstrijden 
	   where wedstrijden.spelersnr = s.spelersnr)
order by 1,2,3
```
Geef de spelers (woonplaats, naam, geslacht, in volgorde van hun geslacht en naam) voor wie minstens één boete betaald werd maar die geen aanvoerder zijn van een team. Sorteer van voor naar achter. Geen dubbels.

```postgreSQL
select geslacht, naam, plaats
from boetes b left outer join teams t using (spelersnr)
inner join spelers using (spelersnr)
where teamnr is null
group by spelersnr, geslacht, naam, plaats
order by 1,2,3
```
Geef de twee laagste bondnrs terug. (tip: dwz er zijn dus minder dan 2 bondsnr die kleiner zijn) Sorteer van voor naar achter.
```postgreSQL
select s.bondsnr
from spelers s
where s.bondsnr is not null and ((select count(bondsnr) from spelers s1 where s1.bondsnr < s.bondsnr) =1
or (select count(bondsnr) from spelers s1 where s1.bondsnr < s.bondsnr) =0 )
group by s.bondsnr 
order by 1
```

