# Index, Geolite

## opgave

Welke index kan best toegevoegd worden aan de tabel bezoeken uit ruimtereizen?

Jasper heeft dit geschreven, hij heeft gevraagd of je zijn oplossingen niet letterlijk wilt overnemen.

### oplossing

```sql
-- een samengestelde index voor rerisnr en volgnr
CREATE INDEX comined_index ON bezoeken (reisnr, volgnr);
```

## opgave

Op welke andere kolommen staat een index?
### oplossing

```
Primary key van de tabel (reisnr, volgnr)
```

## opgave

Hoe groot is de tabel bezoeken?
### oplossing

```
24 kb
```

## opgave

Hoe groot is de tabel index?

## oplossing

```
16 kb
```

## opgave

Wat is de structuur van de tabellen?

### oplossing

*   Kolom blocks &rarr; Iprange met een locatie-id
*   Kolom location &rarr; locatie-id met een land en locatie

## opgave

Is er een verband tussen de tabellen?
### oplossing

```
Ja, de location ID
```

## opgave

Op welke velden bestaat een index?
### oplossing

*   Blocks &rarr; IPv4 ranges
*   Location &rarr; location pkey

## opgave

Toon de plaatsinformatie voor locid 244
### oplossing

*  Cost = 0.42 (planning time = 0.068 ms, exec time = 0.034 ms)
*  Gebruikt index


## opgave

Toon alle rijen met cape town
### oplossing

*   Cost = 1000 (planning time = 0.071 ms, exec time = 39, 317 ms)
*   Paralelle sequentiele scan (2 workers)

## Opgave
Wat is caching?
### oplossing
*  Opgeslagen om zaken sneller te kunnen accessen

## Opgave

Hoeveel rijen bevatten de tabellen?

### oplossing

```
890521 rijen
```

## Opgave

Wat is een schema?

### oplossing

```
Een reeks kolommen bij elkaar
```

## Opgave
Kan je meerdere schema's in je zoekpad opgeven?

### oplossing

```
Ja
```

## Opgave
Waar staat waarschijnlijk de server van projektwerk.ucll.be?
### oplossing

```ip
nslookup -> 193.190.138.215
```

```sql
Select *
From blocks inner join location using (locid)
Where iprange >>= '102.190.138.215
```
Leuven, België

## Opgave

Locatie Botnet

### oplossing

*   Vlaams Brabant
*   Leefdaal &rarr; komt het meest voor