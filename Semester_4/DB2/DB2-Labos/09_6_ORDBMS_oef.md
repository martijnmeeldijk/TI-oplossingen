---
typora-copy-images-to: ./img
---

# (N)R DBMS

## Korte samenvatting

### Termen

Dan moet je misschien de slides niet lezen.

**(O)ODBMS** = object(-oriented) database management system. (Data as objects)

**ORD(BMS)** = object-relational database management system

**OOPL** = Olusegun Obasanjo Presidential Library

bedankt google

oke het betekent Object-oriented Programming Language

**ODL** = Object Definition Language?

**OQL** = Object Query Language

Hoe fukking veel afkortingen kunnen er zijn man.

### ORDBMS

#### Datatypes

CREATE TYPE : creëert datatype

Kenmerken : (van gemaakte types)

* gebruikt waar basis-datatypes gebruikt worden

* hebben geen populatie 

* zijn niet manipuleerbaar met een select 

* heeft een statische inhoud (aantal waarden)

DROP TYPE : verwijdert datatype

Degene die type wil gebruiken, moet machtiging krijgen (een type kan dus een eignaar hebben met bijhorende rechten)

**Casting** : om verschillende datatypes te kunnen vergelijken 

**Destructor** : transformeert zelfgedefinieerd datatype naar basisdatatype 

**Constructor** : transformeert basisdatatype naar zelfgedefinieerd datatype

Je kan ook zelf operatoren definiëren.



**Opaque-datatype**: datatype dat niet afhankelijk is van een basisdatatype

**Named row-datatype**:  groeperen van waarden die logisch bij elkaar horen

vb. 

```
create type adres as (straat char(15) not null, huisnr char(4) , postcode char(6) , plaats char(10) not null) ;
```

**Unnamed row-datatype**: groeperen van waarden die logisch bij elkaar horen zonder een naam te geven

**Getypeerde tabel**: een datatype toekennen aan een tabel

```
CREATE table [name] of [type]
```



**Overerving van datatypes**

=> alle eigenschappen van één datatype worden overgeërfd door een ander (supertype en subtype)

```
CREATE TYPE [type] AS (...) UNDER [supertype] ;
```



**Voordelen van types** : 

* Altijd het juiste datatype bij de refererende sleutel 
* Indien primary keys breed zijn, bespaart het werken met reference-kolommen opslagruimte 
* Bij wijzigen van primary keys wordt geen tijd verloren door het wijzigen van de refererende sleutel 
* Bepaalde selects worden eenvoudiger 

**Nadelen van types** : 

* Bepaalde mutaties zijn moeilijker te definiëren 
* References werken in één richting 
* Bij DB-ontwerp krijgt men meerdere keuzes, dit wordt dus moeilijker 
* References kunnen de integriteit van de gegevens niet bewaken zoals refererende sleutels dat kunnen



**Collecties** : verzameling waardes in één cel

Vb: `setof(char(13))`

**! Tabellen kunnen blijkbaar ook overerven.**

```
create type t_spelers as
(spelersnr smallint not null,
naam char(15) not null,
…
bondsnr char(4))
create type t_oude_spelers as
(vertrokken date not null) under t_spelers
create table spelers of t_spelers
(primary key spelersnr)
create table oude_spelers of t_oude_spelers under spelers
```



**RULES**: bertels zegt niet wat ze zijn, maar wel dit:

Gaan verder dan triggers : SELECT, INSERT, UPDATE, DELETE

```
CREATE RULE "NeKeerIetsAnders" AS
ON SELECT TO wedstrijden
WHERE spelersnr = 7
DO INSTEAD
SELECT 'eerst drie toerkes rond tafel
lopen en dan nog eens
proberen';
```

**ACID**

Atomicity: cf boolean 

Consistency: cf state 

Isolation: cf concurrency 

Durability: cf commit, levensduur en select



**CAP**

Consistency 

Availability 

Partition tolerance



# Oefeningen

## 1. Hoe creëer je op de server van het school zelf een type om bv adressen te bevatten. Gaat dit? 

in de slides:

```
create type adres as (straat char(15) not null, huisnr char(4) , postcode char(6) , plaats char(10) not null) ;
```

Probeer het eens uit

## 2. Hoe maak je in postgresql een rij-object? Moet je dit expliciet doen? Bestaat er zoiets als een collectie in postgresql (analoog aan vector/verzameling)? 

Ja, het staat hierboven.

## 3. Kan je in postgresql een tabel laten overerven van een andere tabel? Zoja, probeer dit op een eigen tabel met een extra attribuut 'omschrijving'. 

staat ook letterlijk in de slides

## 4. Welke drie verschillende soorten queries kan op de tabel(len) uit de vorige vraag uitvoeren? (maw welke data kan je allemaal ondervragen, welke drie mogelijke groepen kan je hierin zien, maak misschien een grafische voorstelling van de tabel+overgeerfde tabel.) Hoe doe je dit in postgresql? 

zie FROM ONLY in de slides

denk ik...

## 5. Schrijf zelf een casting functie die enkel de eerste twee tekens teruggeeft van een waarde. 

Oke ik heb geen zin meer sorry, je moet echt gewoon shit in de slides ctrl+f'en. Deze guide is tering nutteloos.

## 6. Wat zijn de unieke rijnummers in postgresql? Kan je deze in een query gebruiken? 



## 7. Hoe kan je in postgresql een databank maken met de structuur van een reeds bestaande databank? Hoe doe je hetzelfde voor 1 van je eigen gemaakte tabellen? Kan je zowel een kopie maken wat betreft structuur als inhoud? Wat is er mogelijk in postgresql? 



## 8. Waarom staat er nu helaas vaak bij: postgresql? 