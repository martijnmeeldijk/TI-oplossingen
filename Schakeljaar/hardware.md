# Examenvragen computerhardware

In dit document doe ik mijn best om een zo goed mogelijk antwoord te geven op de examenvragen van computerhardware



## Vraag 1

> **Welke zijn de onderdelen van een CPU (pagina 55-56)? Geef een korte beschrijving van wat een datapad is en op welke manier instructies er op uitgevoerd worden. (pagina 56-58) Wat wordt er bedoeld met een CISC-architectuur? (pagina 60-61)**



<img src="img/image-20211130154912940.png" alt="image-20211130154912940" width="50%;" />

* Bus: verbindt alle componenten (een verzameling van parallelle draden)
* Control unit: haalt instructies uit het hoofdgeheugen en ondervindt hun type
* ALU (arithmetic logic unit): doet bewerkingen zoals optellingen, boolean AND die nodig zijn om instructies uit te voeren
* Registers: kleine geheugens met hoge snelheid waarin je bepaalde informatie en tijdelijke resultaten kunt opslaan. Elk register kan één getal bevatten. Ze zijn super snel, want ze zitten in de CPU
  * Program counter (PC): een register dat wijst naar de volgende instructie die moet worden opgehaald uit het hoofdgeheugen (bevelenteller in het nederlands denk ik)
  * Instruction register (IR): bevat de instructie die momenteel wordt uitgevoerd
  * Er zijn ook nog andere registers, sommige meer 'general purpose', andere hebben een specifieker nut, andere worden gerbuikt door het besturingssysteem om de computer te besturen.

**Datapad**

(ik veronderstel dat hij *data path* bedoelt)

Oke ik ben dom, hij heeft het gewoon vertaald. Ik dacht dat hij het engelse woord *pad* bedoelde.

<img src="img/image-20211130160405610.png" alt="image-20211130160405610" width="50%;" />

Het *data path* bestaat typisch uit de **registers**, de **ALU** en meerdere bussen die de onderdelen verbinden. De registers zijn verbonden met 2 **ALU input registers** (A en B). Daar wordt de input voor de ALU bijgehouden terwijl de ALU nog met iets anders bezig is. Nadat er een bewerking is uitgevoerd wordt het resultaat opgeslagen in het **ALU output register**. Dit resultaat kan dan weer opgeslagen worden in één van de registers. 

**Op welke manier kunnen er instructies op uitgevoerd worden?**

Volgens de **fetch-decode-execute** cyclus:

1. Fetch volgende instructie uit het geheugen naar de instruction register
2. Verander de program counter zodat hij wijst naar de volgende instructie
3. Bepaalt het type van de instructie die zonet is opgehaald
4. Als de instructie een *word* uit het geheugen nodig heeft, bepaal waar die zich bevindt
5. Haal de *word* op en steek ze (indien nodig) in een CPU register
6. Voer de instructie uit
7. Ga terug naar stap 1 en begin met de uitvoer van de volgende instructie

**CISC Architectuur**

CISC: complex instruction set computer

Doordat er telkens krachtigere computers nodig waren, waren er ook telkens krachtigere instructies nodig. Een CISC architectuur kan typisch met een instructie meerdere low-level operaties uitvoeren. Bovendien probeerden wetenschappers met RISC het gat tussen high-level programmeertalen en wat de machines konden kleiner te maken. CISC is de tegenhanger van RISC, waar ik het ongetwijfeld nog over ga hebben. 



## Vraag 2

> **Wat is de achterliggende gedachte bij een RISC-architectuur? (pagina 62-63) Aan welke voorwaarden moeten instructies voldoen en waarom moeten ze aan die voorwaarden voldoen? (pagina 63-65) Beschrijf hoe een klassieke 5-traps RICS-pipeline functioneert.(pagina 66-67) Hoe werd de pipeline bij de Pentium CPU geïmplementeerd? (pagina 68)**



**RISC**

= reduced instruction set computer

De gedachte is om instructies zo klein mogelijk te maken, minder lettend op de tijd om één instructie uit te voeren. De focus lag meer op zo veel mogelijk instructies te starten per seconde, wat heel goed bleek te zijn voor performance. 

**Aan welke voorwaarden moeten instructies voldoen? En waarom?**

* Alle instructies worden rechtstreeks uitgevoerd door de hardware, zodat ze niet moeten omgezet worden naar microinstructies. Dit zorgt voor hogere snelheid
* Maximaliseer de hoeveelheid instructies die gestart worden (ze kunnen dan vaak parallel worden uitgevoerd)
* Instructies moeten gemakkelijk zijn om te decoderen. (Weten hoeveel resources een instructie nodig heeft is belangrijk. Als je dit gemakkelijker kan maken door instructies regelmatiger en kleiner te maken, is dat veel beter voor de performance)
* Alleen *loads* en *stores* mogen aan het geheugen komen (want normaal geheugen is traag)
* Er moeten ruim genoeg registers zijn (want normaal geheugen is traag) 



**5-stage RISC pipeline**

<img src="img/image-20211130163909905.png" alt="image-20211130163909905" width="50%;" />

Het ophalen van een instructie duurt vaak het langst, dus zou het nuttig zijn als we de volgende instructie al kunnen ophalen, terwijl de vorige nog wordt uitgevoerd. 

1. Haalt instructie uit het geheugen en steekt ze in een buffer tot hij nodig is

2. Decodeert de instructie, bepaalt zijn type en operanden die hij nodig heeft

3. Zoekt een haalt de operanden op 

4. Voert de effectieve instructie uit, typisch door de operanden door het datapad te sluizen

5. Schrijft het resultaat terug naar het juiste register

   

> **Hoe werd de pipeline bij de Pentium CPU geïmplementeerd?**

<img src="img/image-20211130165938373.png" alt="image-20211130165938373" width="50%;" />

Vrij gelaijkaardig aan deze figuur. De verdeling van het werk tussen stap 2 en 3 was lichtjes anders. De hoofdpipeline (**u pipeline**) kon een arbitraire pentiuminstructie uitvoeren, de tweede pipeline (**v pipeline**) kan alleen simpele integerinstructies uitvoeren. Er waren regels die bepaalden of een bepaald paar instructies compatiebel was om in parallel uitgevoerd te worden. Was dit niet het geval, dan werd de eerste uitgevoerd (in de u pipeline) en werd de tweede bijgehouden en gepaard met de volgende instructie. 

Zo konden compilers voor pentium programmas compileren die tot 2 keer zo snel waren als oudere compilers. 



## Vraag 3

> Wat is het verschil tussen een GPU en een vector processor? Leg uit hoe ze beide functioneren. Wat streven ze allebei na? Wat wordt er bedoeld met een multiprocessor en met een multicomputer? (pagina 69-73)
>

**GPU**

Maakt gebruik van SIMD (Single instruction stream multiple data stream). Een GPU moet heel vaak dezelfde simpele operaties uitvoeren (pixels, textures enzo). Elke instructie wordt op meerdere SIMD processors uitgevoerd. Hierdoor kan een GPU vele malen meer (simpele) instructies per seconde uitvoeren dan een klassieke CPU.

// TODO vector processor



## Vraag 4

> Wat is BCD-codering? (pagina 74) Wat is het verschil tussen big endian notatie en little endian notatie. Geef een voorbeeld waarbij je illustreert dat wanneer beide architecturen gegevens met elkaar zouden uitwisselen het omdraaien van de bytes niet werkt. (pagina 76-78, zie voorbeeld les)



**BCD** = binary coded decimal

Een decimaal getal in binaire voorstelling geschreven

| Little Endian               | Big Endian                  |
| --------------------------- | --------------------------- |
| Gebruikt door intel         | Gebruikt door IBM           |
| De kleinste byte komt eerst | De grootste byte komt eerst |

Een mooi plaatje ter illustratie:

<img src="https://images.squarespace-cdn.com/content/v1/549dcda5e4b0a47d0ae1db1e/1490746414666-EM74IA60AFM16OEH9G22/image-asset.png" alt="SEG-Y Rev 2 again: little-endian is legal! — Agile" width="50%;" />



> Geef een voorbeeld waarbij je illustreert dat wanneer beide architecturen gegevens met elkaar zouden uitwisselen het omdraaien van de bytes niet werkt.

Een simpel voorbeeld uit het boek. Als je bij deze figuur kijkt, is (c) het resultaat van bytes van big naar little endian te sturen. Je kan niet zomaar aan het antwoord (d) geraken door alle bits om te draaien.

![image-20211215181555462](img/image-20211215181555462.png)

## Vraag 5

> **Beschrijf kort het idee achter cache-geheugens. Op basis van welk principe dragen cache geheugens bij tot prestatieverbeteringen? Geef enkele voorbeelden (minstens drie) om dit te verduidelijken. Welke mogelijkheden zijn er om cache-geheugens te voorzien en welk verband is er met de Harvard architectuur? (pagina 82-85…)**

We willen in een pc snel en groot geheugen, dat is in de realiteit niet mogelijk. Je moet kiezen, ofwel snel, ofwel groot. De oplossing is klein, snel geheugen combineren met groot, traag geheugen. 

**Het localiteitsprincipe**

Als een programma een stuk geheugen opvraagt is de kans groot het volgende stuk geheugen dat hij nodig heeft daarbij in de buurt ligt. Als er dus iets wordt opgevraagd uit het grote, trage geheugen gaan we ook al een aantal aanliggende geheugenvelden in de cache stoppen, want de kans is groot dat we ze later toch nodig hebben.



> **Op basis van welk principe dragen cache geheugens bij tot prestatieverbeteringen? Geef enkele voorbeelden (minstens drie) om dit te verduidelijken.**

1. We printen de letters van een string uit. De letters staan achtereenvolgend in het geheugen. Wanneer een letter ophalen, zetten we een bepaald aantal volgende letters in de cache. Aangezien uitlezen uit het cachegeheugen sneller is, loopt ons programma nu sneller.
2. We hebben een programma dat manipulaties uitvoert op een matrix. In plaats van elke keer opnieuw een getalletje uit het geheugen uit te lezen, kunnen we beter al een deel (of de gehele) matrix in de cache stoppen. De kans is groot dat we niet één getal uit de matrix nodig hebben.
3. Cachegeheugens komen niet alleen voor in processoren. Stel je voor, het is een gezellige avond en je hebt zin om heel de avond lang naar Taylor Swift te luisteren. Wanneer je het eerste liedje opzet, zal Spotify al een aantal volgende liedjes klaarzetten zodat je ononderbroken naar je favoriete artiest kunt luisteren. (neem deze misschien met een korrel zout, ik denk dat misschien caching en buffering ofzo door elkaar haal, maar het principe is hetzelfde)



> **Welke mogelijkheden zijn er om cache-geheugens te voorzien en welk verband is er met de Harvard architectuur?**

* Unified cache: instructies en data gebruiken dezelfde cache
* Split cache: instructies en data hebben ieder hun eigen cache = **Harvard Architectuur**
  * dit is nuttig bij gepipelinede CPUs, waar het programma instructies uitvoert en op hetzelfde moment data ophaalt

## Vraag 6

> **Hoe is een sector van een harde schijf opgebouwd? (zie extern pdf-document)Wat wordt er in termen van een harde schijf bedoeld met heads, cylinders en sectors? (pagina 88- 89) Wat is het voordeel om sporen onder te verdelen in zones? (pagina 90) Wat zijn de twee belangrijkste eigenschappen die bijdragen tot de performantie van een harde schijf? (pagina 89) Bespreek**

<img src="img/image-20211215184931520.png" alt="image-20211215184931520" width="50%;" />

* SYNC: synchronisatiebits
* IAM (index adress markering): geeft aan dat er sectoren volgen
* IDAM (ID adres markering): geeft aan dat het volgende veld een id is
* ID: 4 bytes die de sector identificeren (kop, cylinder, sector, sectorvlag)
* CRC (Cyclic redundancy check): basically een modulo van de voorgaande velden die wordt gebruikt om te checken of er niets kapot is
* GAP 2: geeft tijd om CRC te verifiëren
* DAM (data adres markering): toont dat er data komt
* Data: de data (512 bytes)
* CRC (deze keer van de data)
* GAP 3: het aantal en grootte van bitcellen in de sector kan variëren, dus we laten wat extra ruimte voor de zekerheid
* GAP 4: duidt het einde van het spoor aan

**Heads**

Het kopje dat de data van de magneetschijf uitleest

**Cylinders**

Een harde schijf bestaat uit meerdere lagen van schijven. De koppen bewegen allemaal tegelijk (ze zitten aan elkaar vast). Een cylinder is gewoon de doorsnede van alle laagjes op een bepaalde straal. 

<img src="img/image-20211215185954534.png" alt="image-20211215185954534" width="33%;" />

**Sectors**

Een schijf wordt opgedeeld in blokjes data, sectors genaamd. Deze zijn typisch 512 bytes.



> **Wat is het voordeel om sporen onder te verdelen in zones?**

Vroeger had je een bepaald aantal sectoren over de omtrek van de schijf. Naarmate je dichter naar het midden van de schijf ging, werden die natuurlijk veel denser. Dat is niet handig, want ge gebruikt de schijf niet optimaal. Door de schijf te verdelen in zones, en als je van binnen naar buiten gaat op de schijf, het aantal sectoren per zone te laten toenemen, maak je beter gebruik van de schijf om er zo veel mogelijk foto's van je lelijke kinderen op te kunnen krijgen.



> **Wat zijn de twee belangrijkste eigenschappen die bijdragen tot de performantie van een harde schijf? (pagina 89) Bespreek**

* Seek: de tijd die het duurt om de arm naar de juiste positie te verplaatsen (5-10 ms)
* Rotational latency: de tijd dat het duurt om de schijf naar de juiste positie te draaien (3-6 ms)

Een sector (512 bytes) uitlezen duurt typisch (volgens het boek dat al een aantal jaar oud is) 3.5 μs. Het is dus belangrijk om de seek en rotational latency zo laag mogelijk te maken



## Vraag 7

> **De IDE-interface kende lange tijd een beperking op schijfcapaciteiten tot 504 MB. Leg uit hoe dit komt (zie slides). Hoe heeft men dit opgelost en wat is momenteel de maximum schijfcapaciteit en leg uit hoe men tot dat getal komt? (zie les) Wat was de maximumoverdrachtsnelheid van deze interface (zie les)? Wat is de opvolger van de IDE/ATA-interface? (pagina 91-92)**

IDE = integrated drive electronics

Waarom 504 MB? Toen was dit astronomisch groot. Met 4 bits voor de head (dus max 16 heads), 6 bits voor de sector (max 63 sectors) en 10 bits voor de cylinder (max 1024 cylinders). Dat komt uit op 1032192 sectors, ofwel 504 megabytes. De reden dat er maar 63 sectoren kunnen zijn is mogelijks door een programmeur, die het een grappig vond om de sector indices vanaf 1 te laten starten. 

//TODO hoe hebben ze dat opgelost



> **Wat is de opvolger van de IDE/ATA-interface?**

Hierna kwam **EIDE** (extended IDE) met support voor LBA's (Logical block addressing). Ze gingen gewoon elke sector een nummer geven en dan moet de controller van de harde schijf dat maar weten om te zetten in head, cylinder en sector adressen. De limiet hier was dan 128GB. 



## Vraag 8

> **SCSI, voor wat staat het en wat zijn de belangrijkste verschillen met de IDE-interface? In welke grootteorde liggen de overdrachtsnelheden die men via de SCSI-interface haalt? Wat is de moderne opvolger van de SCSI-interface? (pagina 92-94, zie les)**

**SCSI** (uitgesproken als scuzzy): Small computer system interface

SCSI is niet alleen een hard-disk interface, maar een bus waarop een SCSI controller en tot 7 (of 15 voor wide scsi) apparaten kunnen aangesloten worden (CD-ROM, scanners, ...) Elk apparaat heeft 2 aansluitingen (input en output). Bovendien is SCSI veel sneller.

SCSI gaat ongeveer van 5 - 640 MB/sec. Pittig snel dus.

> **Wat is de moderne opvolger van de SCSI-interface? **

**RAID** (redundant array of inexpensive disks). Sowieso in één van de volgende vragen meer uitleg hierover.



## Vraag 9

> Uit wat zijn SSD’s opgebouwd? Wat zijn de belangrijkste verschillen tussen harde schrijven en SSD’s? Wat zijn de voor- en nadelen van beide opslagmedia? (pagina 97-99 en slides)

**Uit wat zijn SSD’s opgebouwd?**

Uit vele solid state flash memory cellen. De flash cel is bedacht door een slimme man die had ontdekt dat kapotte transistors vast kunnen blijven steken op een 0 of een 1. Kort uitgelegd, de flash cel is een aangepaste transistor die zijn lading behoudt, zelfs als er geen stroom meer is in het systeem.

**Wat zijn de belangrijkste verschillen tussen harde schrijven en SSD’s? Wat zijn de voor- en nadelen van beide opslagmedia?**

| SSD                                                          | Harde schijf                 |
| ------------------------------------------------------------ | ---------------------------- |
| Twee tot drie keer sneller                                   | typisch 100MB/sec            |
| 3 dollar / GB (toen, nu al minder)                           | Goedkoper (een paar cent/GB) |
| Een cel kan typisch maar 100.000 writes aan, dus er wordt aan *wear leveling*\* gedaan om hem zo lang mogelijk mee te laten gaan | Verslijt minder snel         |
| Geen bewegende onderdelen                                    | Wel bewegende onderdelen     |

\* *wear leveling*: Er wordt een map bijgehouden van alle logische blokken van de schijf, wanneer er nieuwe data wordt weggeschreven, wordt de data weggeschreven naar de minst gebruikte blokken van de schijf. Zo kunnen we hem zo lang mogelijk mee laten gaan.

**Extra**

Sommige SSDs hebben *multilevel flash cells*. Dit betekent dat de lading in één flashcel meer dan 2 ladingsniveaus kan bevatten. Er wordt dan een sequentie van stroompjes met toenemend voltage aangebracht om te bepalen welke lading de cel bevat. Een typische multilevel cel kan vier ladingsniveaus bevatten. Waardoor er dus twee bits per cel kunnen opgeslagen worden.



## Vraag 10

> Waarvoor staat RAID? Waarom werd RAID bedacht en wat is de tegenhanger van RAID? Vermeld zeker en vast de verschillen tussen beide en ook hun voor- en nadelen. Bespreek de algemene werking van RAID. RAID-0, RAID-1, RAID-2, RAID-3, RAID-4 en  RAID-5 zijn allen implementaties van RAID. Bespreek per implementatie of deze nog gebruikt wordt, hoeveel schijven er minimum vereist zijn en hoe het werkt. Wat wordt er bij RAID-4 bedoeld met de schrijfstraf? Veronderstel dat je RAID-3 gebruikt met 4 schijven en dat de derde schijf crasht. Hoe kan je de data op de gecrashte schijf reconstrueren? (pagina 94-97)

**Waarvoor staat RAID?**

*Redundant array of inexpensive disks*: de 'i' kan ook staan voor independant. Omdat mensen vonden dat de disks ook wel duur konden zijn.



**Waarom werd RAID bedacht en wat is de tegenhanger van RAID? **

Disk snelheid ging niet zo snel vooruit als CPU snelheid. Dus men had het idee om parallel processing te gebruiken om I/O te versnellen. Buiten snellere processing zorgt RAID ook voor hogere betrouwbaarheid en fouttolerantie.

Tegenhanger: **SLED** (Single Large Expensive Disk)

Alhoewel RAID leuk is, heb je wel meer overhead, dus minder effectief bruikbare schijfruimte. SLED is ook gewoon simpeler.



**Bespreek de algemene werking van RAID. RAID-0, RAID-1, RAID-2, RAID-3, RAID-4 en  RAID-5 zijn allen implementaties van RAID. Bespreek per implementatie of deze nog gebruikt wordt, hoeveel schijven er minimum vereist zijn en hoe het werkt.**

| RAID-niveau                                                  | Werking                                                      | Min.  Drives |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------ |
| <img src="img/image-20211227105750378.png" alt="image-20211227105750378" style="zoom: 50%;" /> | De data wordt opgedeeld in strips van een bepaald aantal sectoren, verdeeld over $n$ schijven. Dit noemt men **striping**. Is minder reliable dan 1 schrijf, want je hebt $n$ keer zo veel kans dat er een schijf kapot gaat en je alles kwijt bent. Maar het werkt goed als je grote hoeveelheden data in één keer nodig hebt. Wordt niet echt veel gebruikt. | 1            |
| <img src="img/image-20211227110140806.png" alt="image-20211227110140806" style="zoom: 50%;" /> | Zelfde als RAID-0, alleen wordt alles verdubbeld. Write performance is hetzelfde als op 1 schijf, maar read kan tot 2 keer zo snel gaan. Goeie fault tolerance, want als een schijf kapot gaat, kun je hem gewoon vervangen en alle data terugzetten. (wikipedia zegt dat RAID-1 geen striping gebruikt). Wordt wel vaak gebruikt. | 2            |
| ![image-20211227114023672](img/image-20211227114023672.png)  | Alle schijven worden rotationeel gesynchroniseerd (wordt daarom niet vaak gebruikt). Als we dan bijvoorbeeld onze data in nibbles van 4 bits opsplitsen en 3 bits hamming code toevoegen, kunnen we woorden van 7 bits verdelen over 7 schijven. Er is enorm veel overhead, dus dit is alleen nuttig met heel veel schijven. Is duur en moeilijk te implementeren, dus wordt niet vaak gebruikt. | 3            |
| ![image-20211227114035779](img/image-20211227114035779.png)  | Simpelere versie van RAID-2. We hebben een aantal schijven, op de laatste schijf staat een pariteitsbit voor elk woord (verdeeld over de vorige schijven). Als er een schijf wegvalt, kunnen we d.m.v. de laatste schijf met pariteitsbits de data herstellen. (omdat we weten op welke positie die bits stonden). Heeft hoge data rates, maar kan niet goed veel kleine I/O operaties afhandelen. Wordt ook niet vaak gebruikt. | 3            |
| ![image-20211227114047132](img/image-20211227114047132.png)  | Werkt weer met strips. Er wordt per laag een laag met pariteitsbits per strip bijgehouden op een aparte schijf. Als één sector wordt aangepast, moeten alle schijven opnieuw gelezen worden om de pariteitsbits te herberekenen. (= bottleneck en wordt niet vaak gebruikt hierdoor) | 3            |
| ![image-20211227114059825](img/image-20211227114059825.png)  | Deze bottleneck wordt weggewerkt in RAID-5, door de pariteitsbits te verdelen over alle  schijven. Het enige probleem is dat het nu zeer complex is om de data van een weggevallen schijf te herconstrueren. Is één van de meest gebruikte vormen van RAID. | 3            |

**Wat wordt er bij RAID-4 bedoeld met de schrijfstraf?** 

Elke kleine update heeft 2 reads en 2 writes nodig. De oude data en oude pariteitsdata lezen, waaruit met de nieuwe data de nieuwe pariteitsdata berekend kan worden. (dit is een kleine optimalisatie op elke keer alle schijven lezen voor de pariteit, maar nog steeds best traag). //TODO dit effe fact-checken



**Veronderstel dat je RAID-3 gebruikt met 4 schijven en dat de derde schijf crasht. Hoe kan je de data op de gecrashte schijf reconstrueren?**

De bits zijn verdeeld over 3 schijven, met een pariteitsbit op de 4de. Stel je voor dat we 010 hebben als data. Dan is de pariteitsbit 1 (want we hebben een oneven aantal 1-bits). De 3de schijf valt weg, dus nu hebben we 01X als data. Omdat de pariteitsbit gelijk is aan 1, weten we dat op X en nul moest staat. Dit proces wordt dan doorlopen voor elk woord.



## Vraag 11

> Wat is een I/O-bus? Welke zijn de componenten waaruit ieder device bestaat? Geef elke stap in het communicatieproces tussen CPU en harde schijf bij het opvragen van een sector. Wie vraagt wat aan wie en hoe wordt de transactie beëindigd? Wat is de taak van de busarbiter en hoe worden prioriteiten over de devices verdeeld? (pagina 108-110)

**Wat is een I/O-bus?**

De I/O bus is een deel van een computer dat input- en outputapparaten verbindt met de CPU. 

**Welke zijn de componenten waaruit ieder device bestaat?**

Elk apparaat bestaat uit een *controller* en het *I/O apparaat* zelf. 

**Geef elke stap in het communicatieproces tussen CPU en harde schijf bij het opvragen van een sector. Wie vraagt wat aan wie en hoe wordt de transactie beëindigd?**

De CPU stuurt een commando naar de *disk controller*, die dan *seeks* en andere bevelen aan de schijf geeft. Wanneer het juiste spoor en de juiste sector gevonden zijn, begint de schijf de data in een stream naar de controller te sturen. De controller breekt de bitstream in aparte *units* en schrijft elke unit naar het geheugen. Als de controller dit doet zonder tussenkomst van de CPU wordt dit *DMA* (Direct Memory Access genoemd). Wanneer de overdracht klaar is, stuurt de controller een interrupt naar de CPU. De CPU stopt hetgene waar hij mee bezig is en start een *interrupt handler* om te controleren op errors, extra actie te ondernemen wanneer nodig en ten slotte, door te geven aan het besturingssysteem dat de I/O opdracht voltooid is.

**Wat is de taak van de busarbiter en hoe worden prioriteiten over de devices verdeeld?**

De *bus arbiter* beslist welk apparaat gebruik mag maken van de I/O bus. Als de CPU en een I/O apparaat tegelijk de bus willen gebruiken, krijgt het I/O apparaat meestal voorrang, want schijven en andere bewegende apparaten kunnen niet zomaar stilgelegd worden.



## Vraag 12

> Na verloop van tijd is men overgeschakeld naar systemen met meerdere bussen, waarom heeft men een meer “lokale” bus toegevoegd? Bespreek kort de werking van PCI/PCIe. Wat zijn de voornaamste redenen dat men tegenwoordig overschakelt van parallelle naar seriële bussen? (pagina 111-112)

**Na verloop van tijd is men overgeschakeld naar systemen met meerdere bussen, waarom heeft men een meer “lokale” bus toegevoegd?**

De CPU heeft een eigen *lokale bus* om met de geheugencontroller te praten. Zo hoeft CPU memory traffic niet over de PCI bus te gaan.

**Bespreek kort de werking van PCI/PCIe.** 

<img src="img/image-20211227225857201.png" alt="image-20211227225857201" style="zoom:33%;" />

Bij de **PCI** (Peripheral component interconnect) bus worden de andere apparaten dan de CPU worden rechtstreeks op de PCI bus aangesloten

**PCIe** (-express) is eigenlijk totaal anders dan PCI. Het is eigenlijk helemaal geen bus meer, maar een point-to-point netwerk van seriële verbindingen dat gebruik maakt van *packet switching*. (meer zoals het internet dan een traditionele bus). Een apparaat kan tot 32 lijnen (*lanes*) hebben. Deze lijnen zijn niet synchroon (zie volgende paragraaf waarom dit belangrijk is). 

**Wat zijn de voornaamste redenen dat men tegenwoordig overschakelt van parallelle naar seriële bussen?**

Je zou denken dat een 64-bit brede verbinding sneller is dan eentje van 1 bit. Door verschillen in de tijd die de 64 bits erover doen  om te verplaatsen, *skew* genaamd, moeten er lage snelheden gebruikt worden. Bij een seriële verbindingen veel hogere snelheden gebruikt worden die meer dan compenseren voor het verlies aan parallellisme. (denk aan PCIe 3.0 -> 16GB/sec)



## Vraag 13

> Bespreek de werking van een laser-printer. Wat is de taak van de embedded CPU? Hoe gaat men grijstinten afdrukken? Bespreek grondig wat het probleem is bij het afdrukken van kleuren? (pagina 122-125)

**Bespreek de werking van een laser-printer.**

<img src="img/image-20211227231850781.png" alt="image-20211227231850781" style="zoom:50%;" />

De trommel (drum) wordt voor elke paginacyclus tot 1000 volt geladen en bedekt met photosensitief materiaal. Op de trommel worden lijn per lijn kleine stukjes ontladen door een laser die op een achthoekige spiegel wordt gereflecteerd. Wanneer de trommel verder draait, komt elke lijn voorbij de toner, waar de stukjes die nog geladen zijn een speciaal zwart poeder aantrekken. De trommel rolt verder en de lijn met poeder wordt tegen het papier gedrukt. Dan wordt de trommel ontladen en schoongemaakt. Hierna begint de cyclus opnieuw.

**Wat is de taak van de embedded CPU?**

De *embedded CPU* neemt commando's aan die de te printen pagina's beschijven (in tegenstelling tot voorgemaakte bitmaps van de CPU van de computer). Deze worden gegeven in gespecialiseerde programmeertalen zoals PCL of PDF. 

**Hoe gaat men grijstinten afdrukken? **

<img src="img/image-20211227233733899.png" alt="image-20211227233733899" style="zoom:50%;" />

Men maakt gebruik van **halftoning**. Een afbeelding wordt opgesplitst in *halftone cells*, typisch 6x6 pixels. Door deze dan maar deels op te vullen met zwarte pixels, zien onze ogen ze als grijstinten.



**Bespreek grondig wat het probleem is bij het afdrukken van kleuren?**

Het boek geeft hier 4 mooie puntjes die verduidelijken dat het niet triviaal is om iets dat er goed uitziet op een monitor mooi geprint te krijgen.

1. Kleurenmonitors gebruiken lichtstralen, maar printers moeten het doen met het licht dat van het blad reflecteert.
2. Monitors hebben 256 intensiteiten per kleur, maar printers moeten *halftone* gebruiken.
3. Monitors hebben een donkere achtergrond, papier een lichte.
4. De RGB *gamut*\* en de *CMYK*\* gamut van een printer zijn verschillend

\**gamut*: de complete verzameling van kleuren die een printer kan printen of een monitor kan tonen

\**CMYK*: Cyan, magenta, yellow en black (key)

 

## Vraag 28

> Geef zoveel mogelijk eigenschappen/kenmerken van de i7-CPU (algemeen, uitbereidingsmogelijkheden, warmteproblematiek, interruptmechanismes, energieconsumptie,..). (pagina 201-206)

**Algemeen** 

* Backwards compatible met 8088
* 64-bit registers
* Nieuwe instructies voor cryptografische bewerkingen
* multicore CPU (2 tot 6 of meer in de toekomst)
* Cores zijn hyperthreaded (meerdere hardware threads kunnen tegelijk actief zijn)
* Kan tot 4 instructies in één keer uitvoeren
* 3 cacheniveaus: 
  * L1 (32KB instruction, 32KB data)
  * L2 (256KB unified)
  * L3 (4-15MB unified, gedeeld door alle cores)
  * Elke core heeft zijn eigen L1 en L2, dus kan het soms dat er oude (*stale*) waarden inzitten. Daarom doet elke core aan *snooping* (op de memory bus luisteren en pakken als er iets voorbij komt dat hij heeft)

**Uitbereidingsmogelijkheden**

* Er is ruimte voorzien voor meer dan 6 cores
  * Kunnen via de *QPI* (Quick Path Interconnect) port aangesloten worden

**Warmteproblematiek**

* Verbruikt 17- 150 Watt, ongeveer even veel als een gloeilamp, warmte wordt beperkt door:
  * Warmtegeleidende verpakking en koeling
  * Kan in *sleep mode* gezet worden (zijn 5 gradaties in, waar dan tussenin sommige functies zoals snooping nog aan blijven)
  * *Thermal throttling* wordt gebruikt als de andere koelsystemen niet genoeg zijn en er snel warmte weg moet
    * CPU alleen elke *n*de klokcyclus laten draaien
* Kan volgens het boek gebruikt worden als *camp stove* 

**Interruptmechanismes**

* Kan interrupts op dezelfde manier gebruiken als de 8088 (backwards compatibility)
* Kan een nieuw systeem, genaamd *APIC* (Advanced programmable interrupt controller) gebruiken.

**Energieconsumptie**

* 17- 150 watt, niet handig bij apparaten met batterijen
