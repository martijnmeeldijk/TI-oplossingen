# Vragen vorige examens db2



## Juni 2019 - 14/06 8u30

***Mondeling***: ACID. Full form. Leg uit. Verband met NoSQL?

ACID staat voor: Atomicity, Consistency, Isolation, Durability

Atomicity: Alles of niets. Je gerandeerd dat als een transaction enkel door gaat als alle delen van de transactie slagen. Als maar een deel van de transactie slaagt en een deel faalt dan wordt niets van die transactie opgeslagen. 

Consistency: De data is consistent. Alle data volgt de opgelegde regels, en is valide.

Isolation: Elke transaction gebeurt los van andere transactions. Transactions hebben geen impact op elkaar. Een transaction mag bijvoorbeeld geen data lezen van een andere transaction die nog niet klaar is.

Durability: Als een transaction is uitgevoerd blijven de veranderingen bestaan, ook als de database crashed en heropstart. Veranderingen zijn permanent. Als het systeem het bericht stuurt dat een transaction succesvol is uitgevoerd moet deze ook succesvol zijn uitgevoerd. 

Verband NoSQL: NoSQL databanken zijn gemaakt om hoge beschikbaarheid te garanderen. Dit betekent dat ze vaak Consistency en Durability opofferen om dit te garanderen. Ze bieden wel Atomicity.
Ze zijn ook niet altijd gesynchroniseerd, waardoor ze niet altijd consistent zijn. Maar ze komen uiteindelijk wel in sync, dus ze bieden wel deels consistency.

Er zijn uitzonderingen. Sommige NoSQL databank makers zorgen ervoor dat hun databanken wel ACID compliant zijn.



***Theorie***: 

1. Geef conceptueel uitvoering van [Select](https://examenwiki.diana.be/index.php?title=Select&action=edit&redlink=1) statement. 
2. Tijdens Uitnormalizatie moet vreemnde sleutel gebruik maken van primary sleutel. Ja/Nee. Leg uit. 
3. Meerkeuze vraag over Select snelste is. ( keuze tussen select statements met - id, hash, datum)



***Praktijk***: Gegeven db met tabellen bank, in_uitgave, eigenaar, type....

1 a. Schrijf een script die een nieuw kol (bedrag en teken) aanmaakt aan [table](https://examenwiki.diana.be/index.php?title=Table&action=edit&redlink=1) en data toevoegt met betreffende data (maak gebruikt van andere kol in tabel). b. Wat is probleem met zo'n manier van data toevoegen? c. Create view van twee tabellen zonder joins te gebruiken.

\2. Update table(in_uitgave) wanner een uitgave wordt gedaan door 'Griet' (van eigenaar) naar inkomen. a. Geef bericht "This is normal.... bla bla....., bug fixed" wanner update gedaan is. b. Geeft bericht bij insert "are you sure".



## Juni 2018 - 15/06 13u00

***Mondeling***:

Wat zijn de 3 belangrijkste verschillen tussen ORDBMS & OODBMS en leg deze uit. (Met erna een cheeky suprise vraag: gebruiken ze beide SQL? -> OODBMS gebruikt Object query Language)

Op de R schijf zijn een schema en een script te vinden van de databank. Je kan dan je queries opbouwen met pgadmin4.



***Theorie***:

1. Wat is de engelse vertaling van AVG, wat op 25 mei 2018 gestart is?
Nederlands: AVG - Algemene verordening gegevensbescherming

Engels: GDPR - General Data Protection Regulation

Alle data die bedrijven hebben van een individu moeten vernietigd worden indien een individu dat vraagt, en men moet weten welke data wordt opgeslagen alsook toestemming geven.
Deze wet zorgt er ook voor dat de wetgeving over de hele EU hetzelfde is, vroeger had elk land zijn eigen regels en wetgeving, de GDPR normaliseert deze regels over de hele EU.

2. En vallen gegevens van een Europeaan op een Canadese server onder deze wet? (Simpele ja/nee)

Ja. Deze wet is overal geldig.

3. Wat is een groot voordeel & nadeel van indexen? Leg beide uit met 2-3 zinnen.

Voordeel: Indexeren versnelt de verwerking van veel queries. Dit komt omdat de index gebruikt kan worden als een soort "zoek tabel", waardoor de databank sneller weet waar de data die je nodig hebt gevonden kan worden.

Nadeel: Indexes gebruiken veel opslagruimte. Mutaties zorgen ervoor dat de data helemaal opnieuw geindexeerd moet worden.

4. Hoe krijg ik in PostgreSQL de execution time van een query? Leg ook uit wat dit qua informatie geeft.

Met Explain Analyse krijg je de execution time van een query.
Voorbeeld:
      Explain Analyse
      Select *
      From spelers

      Uitvoer: 
         1. Seq Scan on spelers  (cost=0.00..1.14 rows=14 width=82) (actual time=0.006..0.008 rows=14 loops=1)
         2. Planning Time: 0.044 ms
         3. Execution Time: 0.022 ms
 
In tegenstelling tot "Explain" voert Explain Analyse de query volledig uit. Explain geeft een geschatte "cost" van de query, en kijkt hoeveel rijen en kolommen opgezocht moeten worden en probeert daaruit te schatten of het eerdern een zware of lichte query is.

Met Analyse erbij wordt de query uitgevoerd en wordt de tijd gemeten. Eerst wordt een plan gemaakt: "Hoe ga ik deze query uitvoeren" en dan wordt het effectief uitgevoerd.


***Praktijk***:

1. Een vraag met WITH RECURSIVE, deze vraag is soortgelijk aan het voorbeeld met Louis en zonen van de slides, meenemen dus.

2. Een vraag over een function maken die met een loop een aantal inserts doet op een databank. Best te doen met een LOOP in plpgsql.



## Juni 2017 - 12/06 8u30

1. Wat is acid? Wat is het verband met NoSql?

2. Schrijf triggers voor integriteit op een schema

3. Schrijf een recursieve cte op dat schema

4. Wat zijn xml en json in verband met postgresql?



## Juni 2017 - 01/06 8u30

***mondeling***: 

1. wat is referentiële integriteit leg uit, geef grondige voorbeelden.

2. maak een functie die als input een tabelnaam heeft en als output de kollomhoofden en datatype

bv: tabel(k1 text,k2 integer)

```
   output:
   k1 text
   k2 integer
```

3.  Wat is een dirty read ? Geef een voorbeeld hiervan met transaction. Maak ook een view met het gegeven voorbeeld waarbij alle geiten hun nummer en mogelijke aandoening getoond worden.

4.  wat zijn de nadelen van ORDMS + geef telkens een voorbeeld.



## Juni 2017 - 01/06 13u00

***mondeling***: 

uitleggen wat cartesisch product is + voorbeeldquery maken met inner join, en dan vroeg hij op het examen de volgorde van uitvoer van die query + hoeveel rijden er overbleven na de join met using + na de where

***pc en mondeling***:

trigger schrijven voor een tabel "geit" en wanneer ge een geit toevoegt, moet ge voor de insert aan een zelfgemaakte tabel audit toevoegen wat de situatie was voor de insert + ook info naar die audit tabel zetten na de insert

***schriftelijke query***: van de geit tabel de stamboom geven van een geit met CTE

***schriftelijk***: 4 manieren om te beveiligen: staat in de pp's: was grant, view, stored procedures & roles
