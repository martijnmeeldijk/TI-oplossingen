# Oplossingen SQL-Dropbox (DB2)

## Inhoud

\* [Oplossingen SQL-Dropbox (DB2)](#oplossingen-sql-dropbox-db2)

   \* [Subq 2 verbreding](#subq-2-verbreding)

   \* [Optim](#optim)

   \* [Vensters](#vensters)

   \* [Joins Extra](#joins-extra)

   \* [Extra 4](#extra-4)

   \* [Extra 5](#extra-5)

   \* [Venster XML](#venster-xml)

   \* [JSON](#json)

## Subq 2 verbreding

Geef de diameter van het grootste hemellichaam dat bezocht is op de vroegste reis waar klantnr 126 niet op meegegaan is.

```sql
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

```sql
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

```sql
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
Maak een lijst van klanten die meer dan 2 keer een reis gemaakt hebben waarbij er geen bezoek was aan Jupiter.
```sql
SELECT klantnr, naam || ' ' || vnaam as klantnaam, COUNT(reisnr) aantalreizen
FROM deelnames INNER JOIN klanten USING(klantnr)
WHERE NOT EXISTS (
	SELECT reisnr
	FROM bezoeken
	WHERE objectnaam = 'Jupiter'
	AND deelnames.reisnr = bezoeken.reisnr
) 
GROUP BY klantnr, klantnaam
HAVING COUNT(reisnr) > 2
```
Geef de klantnr voor de klant met het meeste bezoeken aan de maan. Geef ook het aantal bezoeken.
Gebruik geen limit of top.
```sql
SELECT klantnr, COUNT(aantalbezoeken) AS count
FROM deelnames JOIN (
	SELECT reisnr, volgnr
	FROM bezoeken
	WHERE objectnaam = 'Maan'
	GROUP BY reisnr, volgnr) AS aantalbezoeken USING (reisnr)
GROUP BY klantnr
HAVING COUNT(reisnr) > 3 --coole oplossing man
```

> de manier waar je het syteem niet cheezet

```sql
select k.klantnr, aantalbezoeken.count
from klanten k inner join (
	select deelnames.klantnr, count(deelnames.klantnr)
	from deelnames inner join bezoeken on (deelnames.reisnr = bezoeken.reisnr)
	where bezoeken.objectnaam = 'Maan'
	group by deelnames.klantnr
	) as aantalbezoeken using(klantnr)
where aantalbezoeken.count >= all(select count(deelnames.klantnr)
	from deelnames inner join bezoeken on (deelnames.reisnr = bezoeken.reisnr)
	where bezoeken.objectnaam = 'Maan'
	group by klantnr)
```



## Optim

Geef een lijst met het spelersnummer en de naam van de speler die in Rijswijk wonen en die in 1980 een boete gekregen hebben van 25 euro. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "(cost=2.37..2.37 rows=1 width=68)".

```sql
select s.spelersnr, s.naam
from spelers s inner join boetes b using(spelersnr)
where s.plaats = 'Rijswijk' and b.bedrag=25 and extract(year from b.datum) = 1980
order by 1,2
```

Geef de naam en het spelersnummer van de spelers die ooit penningmeester geweest zijn van de club, die bovendien ooit een boete betaald hebben van meer dan 75 euro, en die ooit een wedstrijd gewonnen hebben met meer dan 2 sets verschil. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "Unique (cost=100.38..100.54 rows=21 width=68)".

```sql
select s.naam, s.spelersnr
from spelers s inner join boetes b on(b.spelersnr = s.spelersnr)
inner join bestuursleden be on (be.spelersnr = s.spelersnr)
where b.bedrag>75 and extract(year from b.datum) = 1980 and be.functie = 'Penningmeester'
order by 1,2
```

Geef van elke speler het spelersnr, de naam en het verschil tussen zijn of haar jaar van toetreding en het gemiddeld jaar van toetreding. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "Sort (cost=33.16..33.66 rows=200 width=86)"

```sql
select s.spelersnr, s.naam, s.voorletters, (s.jaartoe - (select avg(spelers.jaartoe) from spelers)) as verschil
from spelers s 
order by 1,2,3,4
```

Je kan per speler berekenen hoeveel boetes die speler heeft gehad en wat het totaalbedrag per speler is. Pas nu deze querie aan zodat per verschillend aantal boetes wordt getoond hoe vaak dit aantal boetes voorkwam. Sorteer van voor naar achter.
Probeer gelijk of beter te doen dan "Sort (cost=46.39..46.89 rows=200 width=8)".
```sql
SELECT b1.aantalboetes AS a, COUNT(spelersnr)
FROM (SELECT spelersnr, COUNT(*) AS aantalboetes FROM boetes GROUP BY spelersnr) AS b1
GROUP BY b1.aantalboetes
ORDER BY 1,2
```

```sql
select count as a, count(count)
from (select spelersnr, count(*) from boetes  group by spelersnr) as a
group by count
order by 1,2 --je kan alle namen weglaten, zodat het moeilijker is om te verbeteren
```

Geef van alle spelers het verschil tussen het jaar van toetreding en het geboortejaar, maar geef alleen die spelers waarvan dat verschil groter is dan 20. Sorteer van voor naar achter.
Probeer zo goed of beter te doen dan "Sort (cost=17.20..17.37 rows=67 width=90)"

```sql
select spelersnr, naam, voorletters, toetredingsleeftijd
from (select spelersnr, naam, voorletters,  jaartoe - extract(year from geb_datum) as toetredingsleeftijd from spelers) as a
where toetredingsleeftijd > 20
order by 1, 2, 3, 4
```

```sql
select spelersnr, naam, voorletters, jaartoe - extract(year from geb_datum) as toetredingsleeftijd
from spelers
where (jaartoe - extract(year from geb_datum) ) > 20
order by 1,2,3,4 --het kan zonder subquery, de cost is wel exact hetzelfde
```

Geef alle spelers die alfabetisch (dus naam en voorletters, in deze volgorde) voor speler 8 staan. Sorteer van voor naar achter.
Probeer zo goed of beter te doen dan "Sort (cost=24.31..24.47 rows=67 width=88)"

```sql
select spelersnr, naam, voorletters, geb_datum
from (select spelersnr, naam, voorletters, geb_datum, ROW_NUMBER () OVER (ORDER BY naam, voorletters)
from spelers) as b
where ROW_NUMBER < (select ROW_NUMBER
		    from (select spelersnr, naam, voorletters, geb_datum, ROW_NUMBER () OVER ( ORDER BY naam, voorletters)
			  from spelers) as bb
		    where bb.spelersnr = 8)
order by 1, 2 ,3 , 4
```

> Goed geprobeerd, maar het kan makkelijker: als je twee strings met '<' vergelijkt in postgres wordt de uitkomst bepaald door hun alphabetische positie (het is ook efficiënter)

```sql
select spelersnr, naam, voorletters, geb_datum
from spelers 
where naam || voorletters < (select naam || voorletters from spelers where spelersnr = 8 )
order by 1,2,3,4
```



## Vensters

Geef per reis incrementeel de totale verblijfsduur volgens de volgorde waarin de hemelobjecten bezocht worden. Geef ook de totale verblijfsduur van alle reizen om alles in perspectief te zettten.
Sorteer op reisnr, volgnr, objectnaam, verblijfsduur, de volgende kolommen.

```sql
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
Hoe lang was het geleden dat er nog een reis vertrokken was?
Geef daarnaast de totale reisduur per jaar incrementeel in de tijd (hier genaamd jaar_duur).
Sorteer op reisnr en de andere kolommen.

```sql

select  reisnr, lag(reisnr) OVER w1 as vorig_reisnr, vertrekdatum, vertrekdatum - lag(vertrekdatum) over w1 as tussen_tijd,
reisduur, extract(year from vertrekdatum) as jaar, sum(reisduur) over w2 as jaar_duur
from reizen
window w1 as (order by vertrekdatum), 
	w2 as (partition by extract(year from vertrekdatum)order by vertrekdatum)
order by 1
```

> ik had het gedaan zonder die windows echt te definieren (bedankt, nu heb ik iets bijgeleerd)

```plsql
select reisnr, lag(reisnr) over (order by vertrekdatum) as vorig_reisnr, 
vertrekdatum, 
vertrekdatum - lag(vertrekdatum) over (order by vertrekdatum) as tussen_tijd,
reisduur,
extract(year from vertrekdatum) as jaar,
sum(reisduur) over (partition by extract(year from vertrekdatum) order by vertrekdatum ) as jaar_duur
from reizen
order by 1,2,3,4,5,6,7
```



## Joins Extra

Hoeveel kilometers heeft iedereen in totaal gevlogen tot nu toe en hoeveel hebben ze hier in totaal voor betaald. Vermits we de posities van de planeten niet kennen, mag je de afstanden van de hemelobjecten direct gebruiken. Geef het totaal gespendeerde bedrag, de afgelegde kilometers, de prijs per kilometer en datum van hun laatste vlucht van al hun persoonlijke reizen. In het geval dat iemand niet op reis is geweest of geen kilometers gedaan heeft, toon je de boodschap 'veel geld voor niks of niet op reis geweest’ in de kolom prijs_per_kilometer.
Sorteer van voor naar achter.

```sql
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


Geef de volledige frequentietabel voor de diameters van de hemelobjecten (frequentie: hoeveel ojecten zijn er met de gegeven diameter, cumulatieve Frequentie, relatieve frequentie, Relatieve cumulatieve frequentie). Let op de datatypes en de precisie, gebruik CAST, rond niet af. Sorteer op diameter.
```sql
select diameter, 
       count(diameter) as f, sum(count(diameter)) over w1 as cf,
       to_char(float8 (count(diameter)*100::float / (select count(diameter)  from hemelobjecten)), 'FM99.00') as rf,
       to_char( float8 (sum(count(diameter)) over(order by diameter)*100::float / (select count(diameter)  from hemelobjecten)),
       'FM990.90')  as crf
from hemelobjecten
group by diameter
window w1 as ( order by diameter)
order by 1
```

Geef voor elke reis het aantal klanten waarvan de naam niet met een 'G' begint en waarvan de periode van de geboortedatum van de klant tot de vertrekdatum van de reis overlapt met de huidige datum en 50 jaar verder (gebruik hiervoor de gepaste operator: OVERLAPS).
Indien er op de reis hemelobjecten worden bezocht waarvan de tweede letter van het hemelobject voorkomt in de naam van het hemelobject waarvan dit bezocht hemelobject een satelliet is, dan wordt deze reis genegeerd.
Sorteer op reisnr.

```sql
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

```sql
select h.objectnaam, 
	(select count(distinct reizen.reisnr) from reizen
	 inner join bezoeken using(reisnr)
	 where bezoeken.objectnaam = h.objectnaam)
	
from hemelobjecten h

where h.objectnaam like 'Mars' or h.objectnaam like 'Maan'

order by 1,2
```

Maak een lijst van de mensen die Mars wel bezocht hebben maar Io nog niet. Sorteer van voor naar achter.

```sql
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

```sql
select h.objectnaam, 
	(select count(distinct reizen.reisnr) from reizen
	 inner join bezoeken using(reisnr)
	 where bezoeken.objectnaam = h.objectnaam)
	
from hemelobjecten h

where h.objectnaam like 'Mars' or h.objectnaam like 'Maan'

order by 1,2
```
Geef de klant die het meest op de maan is geweest (+het aantal). Sorteer van voor naar achter.
```plsql
select klantnr, count(objectnaam)
from deelnames d inner join bezoeken b on(b.reisnr = d.reisnr)
where b.objectnaam = 'Maan'
group by klantnr
order by 2 desc
FETCH FIRST ROW ONLY --je kan ook 'LIMIT 1' doen
```
Maak een lijst met die mensen die meer dan 2 maal een reis ondernomen hebben waarin men geen enkele satelliet van Jupiter bezoekt !. Sorteer van voor naar achter.

```sql
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

> andere manier

```sql
select k.klantnr, k.naam || k.vnaam as "volledige naam", count(klantnr) as "aantal ondernomen reizen"
from klanten k inner join deelnames using(klantnr)
where reisnr not in
(
	select distinct reisnr from reizen
	inner join bezoeken b using(reisnr)
	inner join hemelobjecten h on (h.objectnaam = b.objectnaam and satellietvan = 'Jupiter')
) 
group by 1,2
having count(klantnr) >2
order by 1,2,3
```



## Extra 5

Geef de nummers van de wedstrijden gespeeld door een speler waarvan de naam begint met een B of D. Sorteer van voor naar achter.

```sql
select wedstrijdnr
from spelers s inner join wedstrijden 
using(spelersnr)
where s.naam like 'B%' or s.naam like 'D%'
order by 1
```

Geef van elke speler die minstens 1 wedstrijd gewonnen heeft voor team nr 1 en voor wie in totaal meer dan 100 euro aan boete betaald is, het spelersnummer, zijn naam, woonplaats en het totale boetebedrag. Sorteer van voor naar achter.

```sql
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

```sql
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

```sql
select geslacht, naam, plaats
from boetes b left outer join teams t using (spelersnr)
inner join spelers using (spelersnr)
where teamnr is null
group by spelersnr, geslacht, naam, plaats
order by 1,2,3
```
Geef de twee laagste bondnrs terug. (tip: dwz er zijn dus minder dan 2 bondsnr die kleiner zijn) Sorteer van voor naar achter.
```sql
select s.bondsnr
from spelers s
where s.bondsnr is not null and ((select count(bondsnr) from spelers s1 where s1.bondsnr < s.bondsnr) =1
or (select count(bondsnr) from spelers s1 where s1.bondsnr < s.bondsnr) =0 )
group by s.bondsnr 
order by 1
```

> Kan beetje korter (Het voorbeeld hierboven is een beetje gehardcoded. Als je nu de 10 laagste bondnummers zou willen, moeten daar nog 8 condities bij.)

```sql
select b.bondsnr 
from spelers b
where 2 > (select count(bondsnr) from spelers where bondsnr < b.bondsnr) and b.bondsnr is not null
order by 1
```

Geef van elke speler die enkel wedstrijden gewonnen heeft voor team nr 1 en voor wie in totaal meer dan 100 euro aan boete betaald is, het spelersnummer, zijn naam, woonplaats en het totale boetebedrag.
Dit resultaat moet aflopend geordend worden op het totale boetebedrag. Sorteer van voor naar achter.
```sql
select spelersnr, naam, plaats, sum(distinct bedrag)
from boetes
inner join wedstrijden using(spelersnr)
inner join spelers using(spelersnr)
where teamnr = 1
and gewonnen > verloren
group by spelersnr, naam, plaats
having sum(distinct bedrag) > 100
order by 1,2,3,4
```

> je kan het ook met een subquery (is ook een klein beetje efficiënter) ik denk dat dat komt doordat je geen joins doet

```sql
select spelersnr, naam, plaats, sum(bedrag)
from spelers inner join boetes using(spelersnr)
where spelersnr in (
	select spelersnr from wedstrijden
	where teamnr = 1 and gewonnen > verloren
)
group by 1,2,3
having sum(bedrag) > 100
```



## Venster XML

Geef alle klanten waarbij de voorlaatste letter van de naam 1 van de letters uit het woord 'azerty' is.
Gebruik geen OR operator, maar een andere ISO sql operator voor het vergelijken van patronen, sorteer van voor naar achter.
```sql
SELECT klantnr, naam, vnaam, geboortedatum
FROM klanten
WHERE naam SIMILAR TO '%(a|z|e|r|t|y)_'
ORDER BY 1,2,3,4
```


Geef voor elke een klant een overzicht aan uitgaven. Hoe? Geef voor elke klant een cumulatie overzicht van prijs van de reizen waar hij aan deelgenomen heeft. De volgorde, waarin er wordt cumulatief wordt opgeteld, wordt bepaald door de vertrekdatum van de reis. Sorteer van voor naar achter.
Tip: vergelijk deze uitvoer met de uitvoer van een query die een gesorteerd overzicht geeft van de klanten en hun deelnames aan reizen.

```sql
select k.klantnr, r.reisnr, sum(r.prijs)
OVER(partition by
k.klantnr
	 order by r.vertrekdatum rows between unbounded
preceding and current row
	) 
from klanten k
left outer join deelnames d on(d.klantnr = k.klantnr)
inner join reizen r on(r.reisnr = d.reisnr)

order by 1,2,3
```

Geef enkel de 2 voorlaatste reizen terug. De positie van reizen wordt bepaalt door het reisnummer.
Ter vergelijking, als je de getallen 1 t/m 10 neemt,
dan is dit 8 en 9. Sorteer van voor naar achter.
Gebruik enkel ISO sql.
```sql
select *
from (	select reisnr, vertrekdatum, reisduur, prijs
	from reizen
	order by reisnr desc
	offset 1 row
	fetch first 2 rows only ) t --is dit iso?
order by reisnr
```

> het hoofdstuk heet vensters XML, dus hier is een oplossing met vensters

```sql
select reisnr, vertrekdatum, reisduur, prijs
from reizen r 
inner join 
	(select row_number() OVER( ORDER BY reisnr desc), reisnr from reizen
	) as goeie using(reisnr)
where goeie.row_number between 2 and 3
order by 1,2,3,4
```

Toon in xmlformaat de objectnamen, afstand en diameter voor objecten die rond Neptunus draaien. Geef als eerste kolom de commentaar maan. Sorteer van voor naar achter.
Tip: XML is gebaseerd op het datatype text.

```sql
SELECT xmlcomment('maan')::text, xmlforest(objectnaam, afstand, diameter)::text
from hemelobjecten
where satellietvan like 'Neptunus'
order by 1,2
```

Geef alle klanten waarbij de 1 van de middenste letters van de naam uit het woord 'qwerty' komt.
Gebruik geen OR operator, sorteer van voor naar achter.
```sql
SELECT klantnr, naam, vnaam, geboortedatum
FROM klanten
WHERE naam SIMILAR TO '%(q|w|e|r|t|y)%'
ORDER BY 1,2,3,4
```


## JSON

Gebruik JSON instructies. Genereer startende van een heterogene array de volgende output: [1, 2, "3", 4, 5]
```sql
select * from json_build_array(1,2,'3',4,5)
```

Gebruik JSON instructies. Selecteer in onderstaande json string '{"a":[1,2,3],"b":[4,5,6]}' het tweede object

```sql
SELECT '{"a":[1,2,3],"b":[4,5,6]}'::json->'b'
```

Gebruik JSON instructies. Expandeer het buitenste JSON object uit de string '{"a":"foo", "b":"bar"}'.
(dit staat letterlijk in de slides)
```sql
SELECT *
 FROM json_each('{"a":"foo", "b":"bar"}')
```

Gebruik JSON instructies. Selecteer in onderstaande json string '{"1":[1,2,3],"2":[4,5,6]}' het tweede object
```sql
 select '{"1":[1,2,3],"2":[4,5,6]}'::json->'2'
```


Gebruik JSON instructies. Selecteer in onderstaande json string '{"1":[1,2,3],"2":[4,5,6]}' het eerste object
```sql
select '{"1":[1,2,3],"2":[4,5,6]}'::json->'1'
```

Gebruik JSON instructies. Selecteer in onderstaande json string '[{"1":"2"},{"4":"5"}]' het eerste object
```sql
SELECT  '[{"1":"2"},{"4":"5"}]'::json->>0
```

Gebruik JSON instructies. Selecteer in onderstaande json string '[{"1":"2"},{"4":"5"}]' het tweede object
```postgreSQL
SELECT '[{"1":"2"},{"4":"5"}]'::json -> 1
```

Gebruik JSON instructies. Selecteer uit onderstaande json string '{"a": {"b":{"c": "foo"}, "c":{"5":"6"}}}' het element "6"
```sql
SELECT '{"a": {"b":{"c": "foo"}, "c":{"5":"6"}}}'::json->'a'->'c'->'5'
```

Gebruik JSON instructies. Selecteer uit onderstaande json string '{"a": {"b":{"c": "foo"}, "c":{"5":"6"}}}' het element "{"c": "foo"}"
```sql
SELECT '{"a": {"b":{"c": "foo"}, "c":{"5":"6"}}}'::json->'a'->'b'
```

> je kan ook het pad meegeven

```sql
select '{"a": {"b":{"c": "foo"}, "c":{"5":"6"}}}'::json#>'{a,b}'
```

Gebruik JSON instructies. Selecteer in onderstaande json string '[{"1":"2"},{"4":"5"},"6"]' het derde object
```sql
select '[{"1":"2"},{"4":"5"},"6"]'::json -> 2
```
