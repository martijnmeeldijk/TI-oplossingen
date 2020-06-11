# Databanken 2



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

