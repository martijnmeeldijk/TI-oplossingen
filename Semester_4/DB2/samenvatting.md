# Databanken 2

<!--ts--> 

<!--te-->

## 1. Introductie

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



## 2. Indexen & Optimalisaties

### Wat is een index?

Bertels zegt allemaal shit, maar hij kan niet effe uitleggen wat een index nu eigenlijk is. 

> Een index is een soort **lookup table**. De zoekmachine van je databank gebruikt deze om sneller dingen te vinden in je databank. Je kan het vergelijken met de index achteraan in een boek. 

**Voordeel**: index versnelt verwerking 

**Nadeel**: index neemt opslagruimte & elke mutatie vraagt aanpassing van index waardoor de verwerking vertraagt



### Soorten indexen

> Wie weet is dit nuttig, het komt rechtstreeks uit de slides
>

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



