# Optimalisatie oefeningen

*We gebruiken hiervoor de tennis/ruimtereizen databank.*

Jasper heeft dit geschreven, hij heeft gevraagd of je zijn oplossingen niet letterlijk wilt overnemen.

## Opgave
Maak een lijst met alle hemelobjecten waar ons reisbureau nog niet op bezoek geweest is of
gepasseerd is en die een diameter hebben van meer dan 100.000 km. Sorteer de lijst
aflopend volgens de grootte van de diameter
## Oplossing

### Query
```sql
select hemelobjecten.objectnaam, diameter
from hemelobjecten left outer join bezoeken b on hemelobjecten.objectnaam = b.objectnaam
where reisnr is null and diameter > 100000
order by diameter
```

### analyze
```
Sort  (cost=3.12..3.13 rows=1 width=12) (actual time=0.053..0.053 rows=2 loops=1)
  Sort Key: hemelobjecten.diameter
  Sort Method: quicksort  Memory: 25kB
  ->  Hash Right Join  (cost=1.91..3.11 rows=1 width=12) (actual time=0.040..0.043 rows=2 loops=1)
        Hash Cond: ((b.objectnaam)::text = (hemelobjecten.objectnaam)::text)
        Filter: (b.reisnr IS NULL)
        Rows Removed by Filter: 2
        ->  Seq Scan on bezoeken b  (cost=0.00..1.16 rows=16 width=10) (actual time=0.006..0.007 rows=16 loops=1)
        ->  Hash  (cost=1.89..1.89 rows=2 width=12) (actual time=0.021..0.021 rows=3 loops=1)
              Buckets: 1024  Batches: 1  Memory Usage: 9kB
              ->  Seq Scan on hemelobjecten  (cost=0.00..1.89 rows=2 width=12) (actual time=0.010..0.018 rows=3 loops=1)
                    Filter: (diameter > '100000'::numeric)
                    Rows Removed by Filter: 68
Planning Time: 0.178 ms
Execution Time: 0.094 ms

```

## Opgave
Maak een overzicht waarbij je voor de Maan en voor Mars aangeeft hoeveel ruimtereizen
één of meer keer de betreffende bestemming bezocht hebben (d.w.z. erop geland zijn).

## Oplossing

### Query
```sql
select objectnaam, count(distinct reisnr)
from bezoeken where objectnaam = 'Mars' or objectnaam = 'Maan'
group by objectnaam
```

### analyze
```
GroupAggregate  (cost=1.36..1.47 rows=5 width=13) (actual time=0.038..0.041 rows=2 loops=1)
  Group Key: objectnaam
  ->  Sort  (cost=1.36..1.38 rows=8 width=10) (actual time=0.026..0.027 rows=10 loops=1)
        Sort Key: objectnaam
        Sort Method: quicksort  Memory: 25kB
        ->  Seq Scan on bezoeken  (cost=0.00..1.24 rows=8 width=10) (actual time=0.012..0.015 rows=10 loops=1)
              Filter: (((objectnaam)::text = 'Mars'::text) OR ((objectnaam)::text = 'Maan'::text))
              Rows Removed by Filter: 6
Planning Time: 0.092 ms
Execution Time: 0.077 ms

```

## Opgave
Schrijf de instructies die de nuttige indexen op een tabel die je in de probeer databank kan aanmaken.
## Oplossing

### Query
```sql
CREATE INDEX index_name_goes_here on table_goes_here (row, row)
```

## Opgave
Ga na op welke velden er een index is aangemaakt bij de spelers_l of spelers_xl of spelers_xxl tabel.
Hoeveel gegevens zitten er in de door jouw gekozen tabel?
Maak een heel eenvoudige querie waarbij je zoekt op een geïndexeerd veld.
Maak ook een heel eenvoudige querie waarbij je zoekt op een niet-geïndexeeerd veld.
Is er verschil?
## Oplossing

### Query
```sql
-- met index
select *
from spelers_xxl
where spelersnr = 30

-- zonder index 
select *
from spelers_xxl
where spelersnr > 30
```

### analyze
```sql
-- met index
Index Scan using pk_key_spelers_xxl on spelers_xxl  (cost=0.42..8.44 rows=1 width=147) (actual time=0.023..0.024 rows=1 loops=1)
  Index Cond: (spelersnr = 30)
Planning Time: 0.082 ms
Execution Time: 0.044 ms

-- zonder index
Seq Scan on spelers_xxl  (cost=0.00..34723.00 rows=999968 width=147) (actual time=0.009..128.065 rows=999970 loops=1)
  Filter: (spelersnr > 30)
  Rows Removed by Filter: 30
Planning Time: 0.097 ms
Execution Time: 160.154 ms

```

## Opgave
Bereken de kostprijs om al de gegevens van de spelers, spelers_l en spelers_xl en spelers_xxl tabel te tonen.
Wat is verband met de vorige oefening
## Oplossing

### Query
```sql
select spelersnr, naam, voorletters, geb_datum, geslacht, jaartoe, straat, huisnr, postcode, plaats, telefoon, bondsnr
from spelers
union ALL
select spelersnr, naam, voorletters, geb_datum, geslacht, jaartoe, straat, huisnr, postcode, plaats, telefoon, bondsnr
from spelers_l
union ALL
select spelersnr, naam, voorletters, geb_datum, geslacht, jaartoe, straat, huisnr, postcode, plaats, telefoon, bondsnr
from spelers_xl
union ALL
select spelersnr, naam, voorletters, geb_datum, geslacht, jaartoe, straat, huisnr, postcode, plaats, telefoon, bondsnr
from spelers_xxl
union ALL
select spelersnr, naam, voorletters, geb_datum, geslacht, jaartoe, straat, huisnr, postcode, plaats, telefoon, bondsnr
from spelers_xxxl
```

### analyze
```
Append  (cost=0.00..524583.47 rows=11108779 width=274) (actual time=0.009..4350.031 rows=11108744 loops=1)
  ->  Seq Scan on spelers  (cost=0.00..1.14 rows=14 width=82) (actual time=0.008..0.009 rows=14 loops=1)
  ->  Subquery Scan on "*SELECT* 2"  (cost=0.00..368.60 rows=8730 width=137) (actual time=0.007..2.714 rows=8730 loops=1)
        ->  Seq Scan on spelers_l  (cost=0.00..281.30 rows=8730 width=139) (actual time=0.006..1.808 rows=8730 loops=1)
  ->  Subquery Scan on "*SELECT* 3"  (cost=0.00..4223.00 rows=100000 width=137) (actual time=0.006..30.703 rows=100000 loops=1)
        ->  Seq Scan on spelers_xl  (cost=0.00..3223.00 rows=100000 width=139) (actual time=0.005..20.338 rows=100000 loops=1)
  ->  Subquery Scan on "*SELECT* 4"  (cost=0.00..42223.00 rows=1000000 width=137) (actual time=0.010..302.737 rows=1000000 loops=1)
        ->  Seq Scan on spelers_xxl  (cost=0.00..32223.00 rows=1000000 width=139) (actual time=0.009..200.790 rows=1000000 loops=1)
  ->  Subquery Scan on "*SELECT* 5"  (cost=0.00..422223.70 rows=10000035 width=137) (actual time=0.022..3389.630 rows=10000000 loops=1)
        ->  Seq Scan on spelers_xxxl  (cost=0.00..322223.35 rows=10000035 width=139) (actual time=0.020..2357.179 rows=10000000 loops=1)
Planning Time: 0.164 ms
Execution Time: 4710.380 ms

```

## Opgave
Maak een lijst met een overzicht van de reizen en het aantal deelnemers van elke reis.
## Oplossing

### Query
```sql
select reisnr, count(*)
from deelnames
group by reisnr
order by reisnr
```

### analyze
```
Sort  (cost=1.27..1.28 rows=4 width=13) (actual time=0.029..0.029 rows=4 loops=1)
  Sort Key: reisnr
  Sort Method: quicksort  Memory: 25kB
  ->  HashAggregate  (cost=1.19..1.23 rows=4 width=13) (actual time=0.019..0.020 rows=4 loops=1)
        Group Key: reisnr
        ->  Seq Scan on deelnames  (cost=0.00..1.13 rows=13 width=5) (actual time=0.005..0.006 rows=13 loops=1)
Planning Time: 0.067 ms
Execution Time: 0.065 ms

```

## Opgave
Pas de vorige query zodanig aan dat ook de ruimtereizen waarvoor (nog) geen deelnemers zijn ingeschreven, in het overzicht verschijnen.
## Oplossing

### Query
```sql
select reisnr, count(klantnr)
from reizen left outer join deelnames using (reisnr)
group by reisnr
order by reisnr
```

### analyze
```
Sort  (cost=2.52..2.54 rows=6 width=13) (actual time=0.048..0.048 rows=6 loops=1)
  Sort Key: reizen.reisnr
  Sort Method: quicksort  Memory: 25kB
  ->  HashAggregate  (cost=2.39..2.45 rows=6 width=13) (actual time=0.039..0.040 rows=6 loops=1)
        Group Key: reizen.reisnr
        ->  Hash Right Join  (cost=1.14..2.32 rows=13 width=10) (actual time=0.024..0.031 rows=15 loops=1)
              Hash Cond: (deelnames.reisnr = reizen.reisnr)
              ->  Seq Scan on deelnames  (cost=0.00..1.13 rows=13 width=10) (actual time=0.002..0.003 rows=13 loops=1)
              ->  Hash  (cost=1.06..1.06 rows=6 width=5) (actual time=0.009..0.009 rows=6 loops=1)
                    Buckets: 1024  Batches: 1  Memory Usage: 9kB
                    ->  Seq Scan on reizen  (cost=0.00..1.06 rows=6 width=5) (actual time=0.004..0.005 rows=6 loops=1)
Planning Time: 0.156 ms
Execution Time: 0.087 ms

```