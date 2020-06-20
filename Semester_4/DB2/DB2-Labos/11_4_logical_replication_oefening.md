---
typora-copy-images-to: ./img
---

# Logical replication

de oefening staat onderaan in *11_4_logical_replication_oefening.pdf*



## Oefening voor elke student

> Voorwaarde om de oefening te kunnen maken:
>
>  Je gebruiker moet het attribuut REPLICATION hebben, dit kan je instellen op fuji in de databank administration via:
>

```
SELECT user_administration.get_replication();
```

Je moet op deze server zijn:

<img src="img/image-20200517151411425.png" alt="image-20200517151411425" width="50%" />

en dan je query tool openen op de databank *administration*

Opdat het werkt moet je eerst een lokale kopie hebben van het schema **chinook** in db2. Kopieer niet de data, alleen het schema. (dit kan je instellen)

[Zo doe je dat](hoe_maak_ik_een_lokale_databank.md)

> Schrijf je in op de publicatie db2_pub op machine fuji.ucll.be poort 51920. Dit is een andere server dan databanken.ucll.be.
>

Syntax:

```
CREATE SUBSCRIPTION subscription_name
    CONNECTION 'conninfo'
    PUBLICATION publication_name [, ...]
    [ WITH ( subscription_parameter [= value] [, ... ] ) ]
```

```
CREATE SUBSCRIPTION db2_sub_[naam]
CONNECTION 'dbname=db2 host=fuji.ucll.be user=[rnummer]
 port=51920 password=***** sslmode=require' PUBLICATION db2_pub;
```

dit maakt een subscription voor **chinook**

doe dit op **fuji** om te checken of het heeft gewerkt

```
SELECT * FROM pg_replication_slots ;
```

Output:

![image-20200519160704840](img/image-20200519160704840.png)



Als je nu iets insert op db2/chinook zou het normaal ook op je lokale kopie van chinook moeten komen.