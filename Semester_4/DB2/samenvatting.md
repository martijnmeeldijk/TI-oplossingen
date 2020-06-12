# Databanken 2

<!--ts-->
   * [Databanken 2](#databanken-2)
      * [1. Introductie](#1-introductie)
      * [2. Indexen &amp; Optimalisaties](#2-indexen--optimalisaties)
         * [Wat is een index?](#wat-is-een-index)
         * [Soorten indexen](#soorten-indexen)

<!-- Added by: martijn, at: Thu Jun 11 15:06:52 CEST 2020 -->

<!--te-->

# 1. Introductie

Een beetje herhaling van vorig jaar. Hoe maak je een databank, hoe schrijf je queries, hoe doe je een insert, ...

```sql
SELECT [ ALL | DISTINCT [ ON ( expression [, ...] ) ] ]
 [ * | expression [ [ AS ] output_name ] [, ...] ]
 [ FROM from_item [, ...] ]
 [ WHERE condition ]
 [ GROUP BY grouping_element [, ...] ]
 [ HAVING condition [, ...] ]
 [ WINDOW window_name AS ( window_definition ) [, ...] ]
 [ { UNION | INTERSECT | EXCEPT } [ ALL | DISTINCT ] select ]
 [ ORDER BY expression [ ASC | DESC | USING operator ] [ NULLS { FIRST |
 LAST } ] [, ...] ]
 [ OFFSET start [ ROW | ROWS ] ]
 [ FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } ONLY ]
```

Grouping elements van **group by**

```sql
( )
expression
( expression [, ...] )
ROLLUP ( { expression | ( expression [, ...] ) } [, ...] )
CUBE ( { expression | ( expression [, ...] ) } [, ...] )
GROUPING SETS ( grouping_element [, ...] )
```

Similar to

```sql
'abc' SIMILAR TO '%(b|d)%' 
```

deze shit ook

> BETWEEN – WHERE x between 1 and 100 
>
> OVERLAPS – WHERE (datum1,datum2) OVERLAPS (datumA, datumB) 
>
> IS NULL – WHERE x IS NULL --gebruik niet x=null 
>
> NOT (ontkenning)

transacties:

```plsql
begin; sql code; commit ;
begin; sql code; rollback;
start transaction; sql code; commit ;
start transaction; sql code; rollback;
```



# 2. Indexen & Optimalisaties



## Indexen

### Wat is een index?

Bertels zegt allemaal shit, maar hij kan niet effe uitleggen wat een index nu eigenlijk is. 

> Een index is een soort **lookup table**. De zoekmachine van je databank gebruikt deze om sneller dingen te vinden in je databank. Je kan het vergelijken met de index achteraan in een boek. 

**Voordeel**: index versnelt verwerking 

**Nadeel**: index neemt opslagruimte & elke mutatie vraagt aanpassing van index waardoor de verwerking vertraagt

:warning: een index can ook ineens corrupt worden blijkbaar. Dan krijg je ineens rare resultaten uit je query. Om het te fixen moet je je databank herindexeren.



### Soorten indexen

> Wie weet is dit nuttig, het komt rechtstreeks uit de slides



**Speciale indexvormen**

Multi-tabelindex : = index op kolommen in meerdere tabellen 

Virtuele-kolomindex : = index op een expressie 

Selectieve index = index op een gedeelte van de rijen 

Hash-index = index op basis van het adres op de pagina 

Bitmapindex = interessant als er veel dubbele waardes zijn



**Nieuwere indexvormen**

Standaard gebruik je een b-tree om een index aan te maken, er zijn ook andere manieren:

**GIN** (Generalized Inverted Index):

* Interessant bij veel dubbele waarden
* Er worden meerdere opzoekwaarden tegelijk aangemaakt (handig voor rij, tekst, json,..)
* Efficiënt bij dubbels, meerdere opzoekwaarden per veld; alternatief voor B-tree

**GiST** (Generalized Search Tree)

* template voor verschillende index schema’s
* Voor “clusters” volgens een afstandsmaat
* Bv vergelijken van intervallen, GIS, bevat, dichtste buren, tekst
* veel mogelijkheden, minder performant

**SP-GiST** (space-partitioned GiST)

* niet overlappende GiST

**BRIN**

* voor grote geclusterde tabellen
* bevat, grote geclusterde data, kleine index maar ook niet heel sterk



## Optimalisaties

Je kan die snelheid en kostprijs en nog allemaal andere leuke dingen over je query zien als je `EXPLAIN`  `EXPLAIN ANALYZE` voor je query zet.

Hoe kan je je queries nu zo efficient mogelijk maken?



**Een paar vuistregels:**

1. Vermijd de `OR`-operator

   > Dan wordt de index niet gebruikt. Je kan hem vervangen door een conditie met `IN` of door 2 selects met `UNION`.
   >
   > ```sql
   > where spelersnr in (15, 29, 55)
   > ```

2. Geen onnodig gebruik van `UNION`

   > Door `UNION` overloop je dezelfde tabel meerdere keren. Herformuleer je query en stop al je al je voorwaarden in één `SELECT` (indien mogelijk).

3. Vermijd de `NOT`-operator

   > `NOT` gebruikt ook de index niet. Herformuleer je code zodat hij alleen de vergelijkingsoperatoren gebruikt (<, >, =, ...)

4. Isoleer kolommen in condities

   > ik zal het schetsen met een voorbeeld
   >
   > ```sql
   > wherejaartoe + 10 = 1990 --omdat je die 10 erbij optelt wordt de index niet gebruikt
   > where jaartoe = 1980 --doe dit
   > ```

5. Gebruik de `BETWEEN`-operator

   > Want `AND` gebruikt de index meestal niet
   >
   > ```sql
   > where jaartoe >= 1985 and jaartoe <= 1990 --niet zo goed
   > where jaartoe between 1985 and 1990 --beter
   > ```

6. `LIKE` : index wordt niet gebruikt als patroon begint met % of _

7. Redundante condities bij joins

   > Om SQL te verplichten om een bepaald pad te kiezen
   >
   > ```sql
   > where boetes.spelersnr = spelers.spelersnr 
   > 	and boetes.spelersnr = 44
   > 	
   > where boetes.spelersnr = spelers.spelersnr --het is minder mooi, maar blijkbaar wel sneller
   > 	and boetes.spelersnr = 44 and spelers.spelersnr = 44 
   > ```

8. Vermijd de `HAVING`-component

   > `HAVING` gebruikt de index niet. Probeer indien mogelijk zo veel mogelijk condities in de `WHERE` te steken.

9. Maak de `SELECT`-component zo compact mogelijk

   > * Onnodige kolommen weglaten uit SELECT
   > * Bij gecorreleerde subquery met exists gebruik je best één expressie bestaande uit één constante, zie hieronder.
   >
   > ```sql
   > select spelersnr, naam
   >  from spelers
   >  where exists (select ‘1’
   >  		from boetes
   >  		where boetes.spelersnr = spelers.spelersnr)
   > ```

10. Vermijd `DISTINCT`

    > Je kan het vaak weglaten. `DISTINCT` verlengt de verwerkingstijd.

11. Gebruik de `ALL`-optie bij set operatoren

    > Zonder `ALL` is het trager omdat de data gesorteerd moet worden om alle dubbels eruit te halen.
    >
    > ```sql
    > Select naam, voorletters
    > from spelers
    > where spelersnr = 10
    > union all
    > select naam, voorletters
    > from spelers
    > where spelersnr = 18
    > ```

12. Kies outer-joins boven `UNION`

    > `UNION` verlengt de verwerkingstijd. 

13. Vermijd datatype-conversies

14. Zet de grootste tabel als laatste

15. Vermijd `ANY`- en `ALL`-operatoren

    > `ANY` en `ALL` gebruiken de index niet.
    >
    > ```sql
    > select spelersnr, naam, geb_datum
    > from spelers
    > where geb_datum <= all (select geb_datum from spelers)
    > --kan je omvormen naar
    > select spelersnr, naam, geb_datum
    > from spelers
    > where geb_datum = (select min(geb_datum) from spelers)
    > ```
    >
    > je kan ze vervangen door `min` of `max`.



# 3. Explain

Oh mijn fucking god *03_1_explain.pdf* is echt een teringzooi. Ik ga dit effe skippen want ik kan het niet aan.



## Dedection and benchmarking

### Statistieken

Er is een tool, genaamd **pg_stat_statements** waarmee je statistieken van je databank kan bekijken.

Als je hem wilt gebruiken moet je dit doen (in postgresql.conf):

```sql
# postgresql.conf
shared_preload_libraries = 'pg_stat_statements'
pg_stat_statements.max = 10000
pg_stat_statements.track = all
--- en dan 
CREATE EXTENSION pg_stat_statements; -- in elke databank waar je het wilt gebruiken
```

### Benchmarking

Je kan **pgbench** gebruiken om je databank te benchmarken.

```sql
pgbench -i probeer
```

https://www.postgresql.org/docs/current/static/pgstatstatements.html 

https://www.postgresql.org/docs/current/static/pgbench.html



# 4. Limiting result sets & lateral

## Limiting result sets

Deze slides zijn ook weer heel onduidelijk, maar ik zal m'n best doen om het uit te leggen. Het doel van deze les is niet echt duidelijk in de slides. Het is heel simpel. We hebben een query, maar we willen maar een deel van de uitvoer tonen. Dit kan je met `OFFSET` en `FETCH`.

```sql
SELECT
FROM
..
ORDER BY
OFFSET start { ROW | ROWS }
FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } ONLY
```

Stel je voor dat je alleen het derde tot het vijfde resultaat wilt tonen? 

Dan kan je bijvoorbeeld dit doen:

```sql
SELECT playernumber, name, birth_date
FROM players p
ORDER by birth_date DESC
OFFSET 2 ROWS
FETCH FIRST 3 ROWS ONLY;
```



## Lateral joins

```sql
SELECT
*,
(SELECT
sum(verblijfsduur),
variance(verblijfsduur)
FROM bezoeken b2
WHERE b2.reisnr = r1.reisnr
)
FROM reizen r1;
ERROR: subquery must return only one column
```



```sql
SELECT *
FROM reizen r1 LEFT JOIN LATERAL
(SELECT
sum(verblijfsduur),
variance(verblijfsduur)
FROM bezoeken b2
WHERE b2.reisnr = r1.reisnr
) AS sub ON true;
```

