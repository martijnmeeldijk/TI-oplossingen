# Optimalisatie

1. *Maak een lijst met alle hemelobjecten waar ons reisbureau nog niet op bezoek geweest is of gepasseerd is en die een diameter hebben van meer dan 100.000 km. Sorteer de lijst aflopend volgens de grootte van de diameter*

   

```postgreSQL
-- je kan het
where o.diameter > 100000
and b.objectnaam is null
```



2. *Maak een overzicht waarbij je voor de Maan en voor Mars aangeeft hoeveel ruimtereizen één of meer keer de betreffende bestemming bezocht hebben (d.w.z. erop geland zijn).*

```postgreSQL
--gebruik deze subquery

(select count(distinct reizen.reisnr) from reizen
	 inner join bezoeken using(reisnr)
	 where bezoeken.objectnaam = outer.objectnaam)
```

3. *Schrijf de instructies die de nuttige indexen op een tabel die je in de probeer databank kan aanmaken.*

deze vraag is:

<img src="img/bretels-certified.png" alt="bretels-certified" style="zoom:25%;" />



5. *Ga na op welke velden er een index is aangemaakt bij de spelers_l of spelers_xl of spelers_xxl tabel. Hoeveel gegevens zitten er in de door jouw gekozen tabel? Maak een heel eenvoudige querie waarbij je zoekt op een geïndexeerd veld. Maak ook een heel eenvoudige querie waarbij je zoekt op een niet-geïndexeeerd veld. Is er verschil?*

   Oke, Bertels gaat ook ineens van 3 naar 5. Wat is er mis met 4?????

   ```postgreSQL
   -- spelers_xxl bevat al 1000000 rijen, doe aub geen query op spelers_xxxl behalve als ge -- 10 minuten van uw leven kwijt wilt
   ```

   

Ik zie ook goe geen indexen op eender welk van die tabellen. Ben ik blind? Lemme know.



6. *Bereken de kostprijs om al de gegevens van de spelers, spelers_l en spelers_xl en spelers_xxl tabel te tonen. Wat is verband met de vorige oefening*

   ```
   gebruik 'explain' hiervoor
   ```

7. *Maak een lijst met een overzicht van de reizen en het aantal deelnemers van elke reis.*

   ```
   -- gewoon een paar joins en een count en een group by
   -- dat moet wel lukken
   ```

   

8. *Pas de vorige query zodanig aan dat ook de ruimtereizen waarvoor (nog) geen deelnemers zijn ingeschreven, in het overzicht verschijnen .*

   ```postgreSQL
   --je kan dit oplossen met een gecorreleerde subquery die...
   --oke ik ging een uitleg schrijven maar ik heb geen zin meer. Hier is de query:
   select r.reisnr, 
   	(select count(distinct klanten.klantnr) from klanten
   	inner join deelnames on (deelnames.klantnr = klanten.klantnr)
   	where deelnames.reisnr = r.reisnr) 
   from reizen r
   ```

   
