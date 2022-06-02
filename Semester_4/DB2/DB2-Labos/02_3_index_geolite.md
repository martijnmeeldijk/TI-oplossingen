# Oefeningen over indexen

**1) Eigen Databank**

*Welke index kan er best worden toegevoegd aan de tabel bezoeken uit ruimtereizen?*

```
Ik heb er een unique index op gegooid (zie slides)
```

*Op welke andere kolommen staat er een index?*

```
Kijk in de sql man (bij pgadmin kan je gewoon op een tabel drukken en de sql code zien)
```

*Hoe groot is de tabel bezoeken fysisch? Hoe groot is de index die je hebt aangemaakt op bezoeken?*

Gebruik dit: 

```sql
SELECT pg_size_pretty(pg_total_relation_size('ruimtereizen.bezoeken'));
```

**2) Geolite**

**2.1) Inleiding**

*Wat is de structuur van de tabellen?* 

```
Komaan dit kan je zelf wel

```

*Is er een verband tussen de tabellen?* 

```
(tip: er zijn geen foreign keys, maar je kan ze wel joinen)
```



Op welke velden bestaat er een index?

```
Kijk in de SQL code, zoals in het vorige deel vermeld
```



**2.2) Index**

*Vergelijk de snelheden van:* 

​	Toon de plaats informatie voor locid 244

​	Toon alle rijen met 'Cape Town' 

```sql
explain analyze
-- jouw shitty query
```

Wat is caching?

```
Typ in google 'database caching' ez pz
```

Hoeveel rijen bevatten de tabellen?

```
(het zijn veel rijen)
Als ge dit ni kunt ga ik u blocken van mijn github
```



**2.3) Opzoeking**

*Wat is een schema?*

```
google ftw

```

*Kan je meerdere schema’s in je zoek pad opgeven?*

```sql
-- Bertels doet dit in de volgende vraag 
SET search_path TO geolite,public;
-- Trek daar maar je conclusie uit
```

*Waar staat waarschijnlijk de server projektwerk.ucll.be?*

```sql
-- Met DiG kan je op linux gemakkelijk het dns record van projektwerk 
-- vinden. Als je hier te tam voor bent: 193.190.138.215

-- ik ga niet alles verklappen he, maar je moet dit doen
where blocks.iprange >>= '193.190.138.215' 
```



**2.4) Botnet**

```
Zelfde als het vorige. Als je toevallig weet hoe deze query kan schrijven zonder vijf keer OR te moeten schijven, mag je dat mij laten weten.
```

**2.5) Optioneel**

*Heb je bruikbare data van een andere botnet aanval?*

```
Kom jongens, gaan we projektwerk.ucll.be DDOS'en? 
```

