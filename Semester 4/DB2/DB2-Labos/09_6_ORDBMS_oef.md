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

! Tabellen kunnen blijkbaar ook overerven.

