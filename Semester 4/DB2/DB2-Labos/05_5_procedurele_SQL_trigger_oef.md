# Reeks les Triggers

Bekijke voo deze vragen zeker de links die Bertels heeft gegeven

* http://www.phphulp.nl/php/tutorials/3/371/ 
* http://www.phphulp.nl/php/tutorials/3/493/1184/ 
* http://wiki.postgresql.org/wiki/How_to_avoid_overlapping_intervals_with_PostgreSQL 
* http://wiki.postgresql.org/wiki/A_Brief_Real-world_Trigger_Example
*  http://wiki.postgresql.org/wiki/PL/pgSQL_Dynamic_Triggers
*  http://wiki.postgresql.org/wiki/Return_more_than_one_row_of_data_from_PL/pgSQL_functions



deze vond ik ook nuttig: https://www.phphulp.nl/php/tutorial/overig/meer-doen-met-postgresql-1/371/triggers/817/



1. *Schrijf een functie waarbij je zinnige uitvoer probeert terug te geven naar gebruikers wanneer ze gegevens verkeerd/vergeten in voeren in een zelf gekozen tabel en zorg ervoor dat dit vanzelf gecontroleerd wordt.*

(bekijk voor deze vraag zeker de links die bertels heeft gegeven)

ik heb op het 20 jaar oude php forum het volgende gevonden:

```
CREATE OR REPLACE FUNCTION check_reservering() RETURNS TRIGGER AS

BEGIN
  IF( NEW.datum_aankomst > NEW.datum_vertrek ) THEN
    RAISE EXCEPTION ''Aankomstdatum moet voor vertrekdatum liggen'';
  END IF;
  
  RETURN NEW;
END;

LANGUAGE 'plpgsql';
```

```
CREATE TRIGGER trigger_check_reservering
  BEFORE INSERT OR UPDATE
  ON reservering
  FOR EACH ROW
  EXECUTE PROCEDURE check_reservering();
```

Als je die code een beetje aanpast naar een tabel waarop je de trigger wilt, ben ik zeker dat het wel goed zal zijn.

*2. Zorg ervoor dat er een tabel met een simpele statistiek van een tabel van jouw project, namelijk het aantal inserts dat er reeds is op uitgevoerd.*

```
ik heb hiervoor iets vaags gebruikt in postgres: pg_stat_all_tables()
das een functie waarme je statistieken van tabellen kan opvragen.
Dit was niet de bedoeling van de vraag denk ik, maar dat is dan heel spijtig.
```

3. *In welke situaties kan je een trigger schrijven? Bv bij een select die door een gebruiker word uitgevoerd?*

https://www.tutorialspoint.com/postgresql/postgresql_triggers.htm

hier staat het echt letterlijk in

4. *Schrijf een nuttige trigger op je eigen databank.*

```
nuttig is vrij te interpreteren, ik heb een trigger geschreven die een exception gooit: "Andreas mag niet mee" als je Andreas Milants probeert te inserten bij de klanten.
```

