# Oefeningen views, stored procedures en triggers



#### 1. Tellen

*Zoals je misschien herinnerd, kan het tellen van al de rijen soms langs duren. Dus het gebruik van de count() functie. Maak op je lokale databank een tabel met minstens 1 miljoen rijen.*

dit artikel is handig: https://www.citusdata.com/blog/2016/10/12/count-performance/

#### 1.1. View 

*Maak een view waarin de rijen van deze tabel telt. Hoe kan je ervoor zorgen dat deze view niet steeds opnieuw moet worden uitgevoerd, ie de onderliggende code. Maak zo een view aan.*

voorbeeld van een view (van geolite, credits aan Tim en Louis. Wim, wil je alstublieft ons ticket op completed zetten ik heb echt al 5 aanmaningen gestuurd alsjeblieft Wim):

```
drop view if exists locatie;
create view locatie as select locid as locid,
    country as land,
    region as regio,
    postalcode as postcode,
    location as locatie,
    metrocode as metrocode,
    areacode as netnummer
    from location;
```



Om er voor te zorgen dat hij niet de hele tijd zou moeten uitgevoerd worden, zou je een materialized view kunnen gebruiken: https://www.datacamp.com/community/tutorials/materialized-views-postgresql

Lees het artikel ook zeker eens als je views niet echt snapt.



#### 1.2. Trigger

*Schrijf een trigger die bij een toevoeging of verwijdering van een rij in de tabel een teller in teltabel aanpast. Het doel van deze teltabel is het aantal rijen van een andere tabel bij te houden.*

Ik heb in PGadmin een nieuwe table aangemaakt met een kolom voor de naam van de tabel en een kolom met het aantal rijen

Hier is de functie die ik heb gebruikt om te incrementen, decrementen en de triggers aanmaken moet wel lukken als je het vorige labo hebt gedaan.

```
CREATE OR REPLACE FUNCTION increment_count() RETURNS TRIGGER AS
$$
BEGIN
  UPDATE count 
  SET count = count + 1
  WHERE table_name = 'items';
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';
```

#### 1.3. Performantie

*Welk van de 3 bovenstaande methode is het meest performant?* 

*• rechstreeks tellen* 

*• view (optie 1 en 2)* 

*• teltabel (via trigger)*

Denk maar even na.