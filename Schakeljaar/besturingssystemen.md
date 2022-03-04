# Besturingssystemen



# Hoofdstuk 1

## Vraag 1

> Wat is het verschil tussen symmetrische en asymmetrische multiprocessing? (p15)

Bij **assymmetrische multiprocessing** wordt de kernel van het besturingssysteem altijd uitgevoerd op een bepaalde **master** processor. Hij is verantwoordelijk voor scheduling en heeft volledige controle over het geheugen. 

Dit heeft als gevolg dat de andere processoren enkel gebruikersprogrammas en hulpprogrammas kunnen uitvoeren. Als één van deze processoren dan een dienst nodig heeft (I/O ofzo), zal hij een request moeten sturen naar de master. De master is dus de **bottleneck** in dit systeem, maar voor deze benadering zijn echter weining aanpassingen nodig aan het besturingssysteem indien deze al multitasking voor één processor ondersteunt.



We kunnen op twee manieren doen aan **symmetrische multiprocessing**:

1. De kernel opbouwen uit **meerdere processen** of threads. Dan kunnen ze verdeeld worden over de verschillende processoren. 
2. Elke processor een **volledige kopie** van het besturingsssysteem laten uitvoeren. (is wel iets complexer omtrent communicatie en synchronisatie)

Bij symmetrische multiprocessing kan de kernel dus uitgevoerd worden **op elke processor**. De complexiteit is hoger en deze werkwijze vraagt meer van ons systeem, waarvoor we in ruil wel hogere fouttolerantie en betere uitbreidingsmogelijkheden krijgen.

## Vraag 2

> Wat moet je voorzien om op een Unix-systeem Windows applicaties te kunnen uitvoeren? p12

Een virtuele machine.

(hij zegt niet dat ik het moet uitleggen, maar laten we eerlijk zijn. Ik ga dat waarschijnlijk toch wel doen want ik ben een dikke neurt)

## Vraag 3

> Bespreek hoe je op Windows een Unix-applicatie kan uitvoeren? Wat wordt in deze context bedoeld met een subsysteem? 

**Omgevingssubsystemen** zorgen voor interactie met de gebruiker en voorzien een API set waardoor we op Windows toepassingen kunnen ondersteunen die geschreven zijn voor andere besturingssystemen, zoals Unix bijvoorbeeld. Elk subsysteem heeft zijn eigen adresruimte. 

Elk programma dat draait kan maar van één omgevingssubsysteem gebruik maken (het is wel logisch dat een windows programma geen UNIX system calls hoeft te doen hoop ik). Als we een Unix applicatie willen draaien, maken we dus gebruik van het POSIX-subsysteem, waarin de meeste UNIX-compatibele software kan worden gecompileerd en uitgevoerd. De API van ons POSIX-subsysteem wordt dus vertaald om toegang te krijgen tot de Executive.

## Vraag 4

> Geef drie mogelijke ontwerpen van kernels. Bespreek bij elk hun voor- en nadelen en of ze nog gebruikt worden. p22?

* Oude Unix: monolithische kernel
* Moderne Unix: meer modulaire arichitectuur
* Linux: monolithische kernel

// TODO effectief uitleggen

## Vraag 5

> Gegeven onderstaande figuur:

<img src="img/image-20220214160723785.png" alt="image-20220214160723785" style="zoom:50%;" />

> Geef van elke component in de “executive” aan wat de werking ervan is. p20

* I/O-manager: verwerkt I/O-verzoeken en is gelaagd opgebouwd om bijvoorbeeld stuurprogramma's dynamisch te laden
* Cache manager: beheert de schijfcache
* Security reference monitor: controleert alle toegang
* Object Manager: maakt en verwijdert objecten
* Process Manager: beheert proces- en threadobjecten
* Virtual Memory Manager: doet de vertaling tussen fysieke en virtuele geheugenadressen. 
* Windows & Graphics (Vanaf NT 4.0): bevatten de scherminterface en de grafische stuurprogrammas (voor NT 4.0 werden ze in gebruikersmodus uitgevoerd)

//TODO hij legt ze precies niet allemaal uit in de cursus, moet ik die andere er dan ook bijzetten? let me know in the comments and be sure to like and subscribe

# Hoofdstuk 2

 

## Vraag 6

> Wat is het verschil tussen een programma en een proces? 



## Vraag 7

> Waarom is het model met twee procestoestanden actief en niet actief niet interessant? Wat is het probleem dat je hier zal tegenkomen? 



## Vraag 8

> Geef alle toestanden waarin een thread zich kan bevinden? Bespreek wanneer een thread van de ene toestand in de andere zal terechtkomen. 



## Vraag 9

> Voor processen hebben we een model met 7 toestanden, dewelke? Teken het toestandsdiagram en geef aan hoe en wanneer er van toestand zal worden gewisseld. 



## Vraag 10

> Wat wordt er bedoeld met het procesbeeld? Geef aan hoe dit er uitziet en beschrijf ook wat er zich in elk deel bevindt. Het PCB mag je hier buiten beschouwing laten. 



## Vraag 11

> De info in het PCB kan je in drie categorieën onderverdelen. Dewelke? Bespreek ook wat er zich zoal in elk deel van het PCB bevindt. 



## Vraag 12

> Welke stappen moet het besturingssysteem ondernemen om een nieuw proces aan te maken? 



## Vraag 13

> Welke opportuniteiten kan het besturingssysteem gebruiken om van proces te wisselen? 



## Vraag 14

> Wat is het verschil tussen een synchrone en asynchrone interrupt? 



## Vraag 15

> Geef een aantal voorbeelden die aanleiding zullen geven tot het wisselen van proces. Geef een aantal voorbeelden die wellicht geen aanleiding zullen geven tot een proceswissel. 



## Vraag 16

> Hoe zal men bij een microkernel-architectuur een systeemaanroep afhandelen? 



## Vraag 17

> Hoe zal men bij een monolithisch kernelontwerp een systeemaanroep afhandelen? 



## Vraag 18

> Waarom hebben software interrupts een veel lagere prioriteit dan hardware interrupts? 



## Vraag 19

> Er wordt steeds gezegd dat wanneer een proces tegen een I/O-bewerking aanloopt, het proces geblokkeerd wordt. Hoe kan het besturingssysteem dat weten? 



## Vraag 20

> Bespreek de stappen bij het afhandelen van een interrupt wanneer de scheduler ervoor opteert om de uitvoering verder te zetten binnen het reeds actieve proces. Wat wordt er hier bedoeld met een moduswissel en een contextwissel? 



## Vraag 21

> Bespreek de stappen bij het afhandelen van een interrupt wanneer de scheduler ervoor opteert om de uitvoering niet verder te zetten binnen het reeds actieve proces. Welke stappen zijn nodig om een proceswissel door te voeren. 



## Vraag 22

> Wat zijn de nadelen van een procesloze kernel? Welke delen van een Unix- en een Windows kernel zijn procesloos? 



## Vraag 23

> Hoe wordt er van binnen een Unix besturingssysteem doorgaans van proces gewisseld? Hoe komt het dat dit vrij efficiënt verloopt? 



## Vraag 24

> Hoe wordt er binnen een microkernelgeoriënteerd besturingssysteem van proces gewisseld? Wat zijn hier de voor- en nadelen? 



## Vraag 25

> Wat is de definitie van een proces en de definitie van een thread? 



## Vraag 26

> Geef het procesbeeld van een multithreaded proces met drie threads. Welke delen worden er over de grenzen van een thread gedeeld. 



## Vraag 27

> Geef voor- en nadelen van multithreading. Welke zijn de mogelijke implementaties (enkel vernoemen volstaat)? 



## Vraag 28

> Wat zijn de voor- en nadelen met user level threading? 



## Vraag 29

> Wat zijn de voor- en nadelen van kernel level threading? 



## Vraag 30

> Wat is het verschil tussen coöperatieve- en preempted multitasking?



## Vraag 31

> Geef het procestoestandsdiagram van een klassiek Unix besturingssysteem. Waarom is dit niet geschikt voor realtime-applicaties? 



## Vraag 32

> Uit welke drie delen bestaat een proces in een Windows besturingssysteem? Benoem ze en bespreek waarvoor ze dienen. 



## Vraag 33

> Geef het toestandsdiagram van een Windows thread? Bespreek de toestanden en de mogelijke overgangen. 



## Vraag 34

> Geef het toestandsdiagram van een besturingssysteem dat gebruikmaakt van user level threads en een lichtgewichtproces. Wat zijn de verschillende toestanden en de mogelijke overgangen?



## Vraag 35

> Bespreek onderstaande figuur. Hoe worden de verschillende componenten aan elkaar gekoppeld.

<img src="img/image-20220214162043154.png" alt="image-20220214162043154" style="zoom:50%;" />



## Vraag 36

> Bespreek elke gegeven situatie en geef ook aan waar ze ideaal voor geschikt zijn, m.a.w. waar en wanneer zullen ze worden gebruikt

<img src="img/image-20220214162104691.png" alt="image-20220214162104691" style="zoom:50%;" />



# Hoofdstuk 3 (labo)

## Vraag 37

> Waarom krijg je bij het schrijven van data naar een filedescriptor die geopend werd met de O_SYNCvlag een heel trage verwerkingssnelheid (2 redenen)? 



Antwoord van the man himself:

> Wanneer je de vlag niet meegeeft zal een proceswissel niet steeds noodzakelijk zijn. Het proces roept via een software-interrupt de systeemaanroep aan, er treedt een modewissel en contextwissel op (cfr. de CPU-registers worden, in Linux althans, op de kernelstack bewaard) en de code van de systeemaanroep wordt in kernelmode uitgevoerd. Zonder de O_SYNC-vlag leidt dit veelal tot een zuivere geheugenoperatie door het wegschrijven van 1 of meerdere bytes van de user-buffer naar de kernel-buffer. De tijd die hiervoor nodig is is zeer beperkt en na de systeemaanroep is een proceswissel dus niet steeds aan de orde. Wanneer de kernelbuffer echter vol komt, moet er een I/O-operatie gestart worden en zal het gebruikersproces moeten worden geblokkeerd tot wanneer alle bytes uit de userbuffer werden gekopieerd. 
>
> Bij het zetten van de O_SYNC-vlag heb je dus naast meer I/O-operaties ook steeds een extra proceswissel wat het vertragend effect nog versterkt. Iedere write-systeemaanroep wordt verplicht om een I/O-operatie te starten en het bijhorende proces te blokkeren tot wanneer de bijhorende I/O-interrupt het geblokkeerde proces deblokkeert.



## Vraag 38

> Wat zijn de voor- en nadelen van (kernel/user) buffering? In de kernel wordt er default gebruikgemaakt van buffering en in het gebruikersprogramma stel je het zelf in. Bemerk dat wanneer je opeenvolgende schrijfopdrachten doet met slechts 1 byte, je per definitie geen buffering gebruikt. 



Antwoord van the man himself:

> Buffering beperkt het aantal I/O-opdrachten naar de schijf. De blokgroottes die naar schijf worden geschreven zijn niet bepalend voor de schijfprestaties, het aantal lees/schrijfoperaties per seconde (IOPS ook wel eye-ops uitgesproken, bij een klassieke magnetische disk een hondertal, bij een solid state schijf veel meer maar dan nog) daarentegen wel. Dus meer lees- of schrijfopdrachten beperkt de snelheid van het computersysteem in zijn geheel (i.e. veel meer processen in geblokkeerde toestand die aan het wachten zijn op een I/O-interrupt, ook het oplossen van paginafouten verloopt trager). 
>
> Buffering zorgt dat lees/schrijfopdrachten plaatsvinden op een geheugenbuffer en wanneer die dreigt vol te lopen zal het OS die moeten flushen. Er wordt dus van heel veel kleine I/O-opdrachten één grote I/O-opdracht gemaakt die dan daadwerkelijk naar schijf zal worden geschreven. 
>
> Het nadeel is wel dat je ten eerste geheugen zal moeten toekennen om die buffers te voorzien en twee dat er ook wel wat werkt kruipt in het constant in de gaten houden van de buffergrootte zodat die tijdig kan worden leeggemaakt (bij schrijven) of opgevuld (bij lezen). Buffering vereist ook complexe algoritmes die de buffers op juiste moment moeten aanvullen of leegmaken.



## Vraag 39

> Wanneer zal de systeemaanroep read resulteren in een geblokkeerd proces en wanneer niet. Idem voor een write-systeemaanroep. Geef nog een aantal andere systeemaanroepen die doorgaans een proces zullen blokkeren en dus bijgevolg een proceswissel zullen veroorzaken. 



Antwoord van the man himself:

> Wanneer de buffer net moeten worden opgevuld, zal het OS het proces moeten blokkeren tot wanneer de achterliggende I/O-opdracht de buffer terug aangevuld heeft. Wanneer de buffer nog voldoende gevuld is zal het OS onmiddellijk de leesopdracht kunnen beantwoorden zonder te moeten wisselen van proces. 
>
> waitpid en bv. write (bij een volle buffer die moet geflusht worden) zijn voorbeelden van systeemaanroepen die een geblokkeerd proces en dus een proceswissel zullen veroorzaken.

## Vraag 40

> Geef een kort C-codefragment waarmee je een zombie-proces aanmaakt. Wanneer een proces een zombieproces wordt, welk deel van het proces houdt de kernel dan nog in het geheugen bij en waarom? 



Antwoord van the man himself:

```c
int main(){
  int pid;
  if ( (pid=fork()) < 0){
    perror(argv[0]);
    exit(1);
  }
  else if (pid == 0){
    //child
    exit(0);
  }
  //parent
  sleep(60);
  //niet wachten, geen waitpid dus
}
```

> Wanneer een proces klaar is komt het in Unix in de status zombie terecht vooraleer het wordt afgebroken. Het proces kan echter uitsluitend worden afgebroken wanneer de parent zijn exitstatus leest. Doet de parent dit niet, wordt het proces niet volledig beëindigd en blijft het in de toestand zombie. Als de parent zelf beëindigd wordt, wordt het kind naast een zombie ook een orphan dat geadopteerd wordt door het init-proces. Het init-proces zal de exit-status van het kind lezen waardoor vervolgens ook het kindproces kan worden ontmanteld. 
>
> De exit-status van een proces wordt in Linux bijgehouden in het PCB (process control block) dat dus zolang het in de status “zombie” vertoefd in het geheugen blijft. 
>
> Bij een daemon-proces zal je dus bij het niet correct lezen van de exit-statussen van de kinderen een ganse waslijst met zombie-processen maken die op zich 0% CPU tijd krijgen (dus geen probleem voor de scheduler) en ook 0% geheugen toegewezen krijgen. Iedere zombie neemt wel een plaats in de globale procestabel in beslag en bovendien blijft de volledige procesbesturingsinformatie achter in het geheugen! Dit is dus niet onschuldig!



## Vraag 41

> Na de systeemaanroep fork kan de uitvoering worden verdergezet in ofwel het kind ofwel de ouder. In welke van de twee zal de uitvoering hoogstwaarschijnlijk worden verdergezet en waarom? Wanneer zal dit niet het geval zijn? 



Antwoord van the man himself:

> Wanneer je een systeemaanroep uitvoert komt na de uitvoering ervan in kernelmode de scheduler (ook in kernelmode) aan bod om te kijken of er door de interrupt-afhandeling geen meer prioritaire processen werden gedeblokkeerd. Wanneer er na de systeemaanroep geen andere I/O-interrupts werden afgehandeld die processen deblokkeren met een hogere prioriteit zal de uitvoering gewoon worden verdergezet in het proces dat aan zet was voor de onderbreking, de parent dus. Er is slechts één manier waarbij het kind als eerste aan bod zou kunnen komen en dat is dat bij het aanroepen van de systeemaanroep alle toegewezen tijd door de parent werd opgebruikt. Dan en enkel dan zal het kind als eerste aan bod komen.

## Vraag 42

> Linux kent geen fork-systeemaanroep. Hoe komt het dat je hem wel kan gebruiken? 



Antwoord van the man himself:

> Linux gebruikt de glibc-POSIX API. Die staat in voor de vertaling van courante Unixsysteemaanroepen naar Linux-specifieke systeemaanroepen.

## Vraag 43

> In welke situatie maak je gebruik van een named pipe en kan je dus geen unnamed pipe gebruiken? 



Antwoord van the man himself:

> Unamed pipes of anonieme pipes kan je uitsluitend gebruiken voor IPC (interprocescommunicatie) tussen processen met verwantschap (ouder, kind, broer, kleinkind,…). Bij processen zonder verwantschap moet je gebruikmaken van een named pipe, i.e. een object op het bestandssysteem dat je een naam moet geven (vandaar ook de naam).

## Vraag 44

> Zijn POSIX-threads (of pthreads genoemd) kernel level threads of user level threads? Hoe kom je tot dit besluit?



Antwoord van the man himself:

> Linux kent uitsluitend tasks en maakt eigenlijk geen onderscheid tussen threads en processen. Bij het gebruik van POSIX-threads merk je op dat er achter de schermen een clone-systeemaanroep wordt gebruikt en waar dus een nieuw proces mee wordt aangemaakt waarbij alles gedeeld wordt behalve dan de userstack. Ook wanneer je kijkt met de opdracht top -H zie je hier twee processen staan waarbij het dus eerder aanleunt bij de definitie van kernelthreads dan bij de definitie van user level threads. Ter info bij user level threads is het besturingssysteem niet op de hoogte van het gebruik van threads. De scheduler kan dus onmogelijk een user level thread voor uitvoering selecteren. Alle beheer van user level threads komt dus terecht bij de applicatie zelf. Het proces moet dus de nodige code bevatten om zelf te switchen tussen threads. Blokkeert één user level thread op een I/O-bewerking, dan blokkeert het volledige proces. Ook al kunnen andere threads binnen dat proces wel verder doen. 

# Hoofdstuk 4



## Vraag 45

> Aan welke vier randvoorwaarden moet ieder geheugenbeheersysteem voldoen? 



## Vraag 46

> Bespreek de werking van vaste partitionering (vaste grootte en verschillende grootte). Wat zijn de voor- en nadelen van dit systeem? Hoe zal het besturingssysteem procesbeelden gaan plaatsen in een systeem met vaste partitionering. 



## Vraag 47

> Bespreek de werking van dynamische partitionering. Wat zijn de voor- en nadelen? Welke zijn de verschillende plaatsingsalgoritmen en bespreek de werking en functie van elk algoritme. 



## Vraag 48

> Hoe gebeurt adresvertaling bij dynamische partitionering? 



## Vraag 49

> Bij dynamische partitionering kan je voor het geheugengebruik een bitmap of een gelinkte lijst bijhouden (maak een schets)? Hoe gebeurt dit en wat zijn de voor- en nadelen van beide systemen? 



## Vraag 50

> Bespreek de werking van paginering (zonder virtueel geheugen). Wat is het verschil tussen paginering en vaste partitionering? Hoe gebeurt de adresvertaling bij paginering (maak een schets)? 



## Vraag 51

> Bespreek de werking van segmentatie (zonder virtueel geheugen)? Wat is het verschil tussen dynamische partitionering en segmentatie? Waarom wordt dit model voor de gebruiker bewust zichtbaar wordt gehouden. Geef een voorbeeld waar je handig gebruik kan maken van segmenten. Hoe gebeurt de adresvertaling bij segmentatie (maak een schets)? 



## Vraag 52

> Bespreek de stappen die moeten ondernomen worden wanneer bij adresvertaling wordt vastgesteld dat een deel van het proces zich niet in het geheugen bevindt? 



## Vraag 53

> Wat zijn de drie voordelen van het gebruik van virtueel geheugen? Wat is het nadeel van het gebruik van virtueel geheugen? 



## Vraag 54

> Welke twee parameters moet het besturingssysteem in de gaten houden om te zien of er bij het gebruik van virtueel geheugen te veel dan wel te weinig paginafouten optreden? Wat wordt er bedoeld met “thrashing”? Hoe kan het besturingssysteem oordeelkundig inschatten welke pagina’s in de toekomst nodig zullen zijn en welke niet? 



## Vraag 55

> Welke extra zaken moeten er bij paginering in de paginatabel worden bijgehouden om paginering te kunnen doen in een systeem dat virtueel geheugen gebruikt. Hoe gebeurt de adresvertaling bij paginaring met virtueel geheugen (maak een schets)? 



## Vraag 56

> Welke parameters pleiten voor kleine paginagroottes en welke voor grote paginagroottes? 





# Labo

### Deel 1

1. Welke toetsencombinatie heb je nodig om een runnend programma (een proces dus) te onderbreken? 

`ctrl + C`

2. Hoe kan je een runnend programma pauzeren? (Het hervatten van een programma zullen we later zien) 

`ctrl + Z`

3. Wanneer een programma vraagt om gegevens in te typen, met welke toetsencombinatie kan je dan aangeven dat de invoer stopt? 

`ctrl + D`

4. Wanneer je op de commandolijn een aantal woorden intikt, hoe kan je dan het laatste woord verwijderen?

`ctrl + W`

5. In een shell kan je aan “auto completion” doen door gebruik te maken van de tab-toets. Tik de letters “les” in, en tik vervolgens op de tab-toets. Je merkt dat er automatisch less verschijnt. Nu kan het zijn dat er nog opdrachten zijn die met less beginnen. Tik nogmaals op de tab-toets om te kijken welke opdrachten er met less beginnen. Een ander handigheidje is “reverse search” om eerder ingetypte commando’s te suggereren tijdens het typen. Gebruik hiervoor “CTRL+r”.

### Deel 2

1. Met de opdracht man kan je alle info over een welbepaalde opdracht achterhalen. Zo zal de opdracht “man ls” de info tonen van de ls-opdracht. Man toont de informatie a.d.h.v. een pager, een programma dat de informatie niet alleen op het scherm toont maar dat ook gebruikersinteractie toelaat. Zo kan je scrollen, zoeken naar bepaalde woorden, etc. Standaard is de pager ingesteld op het commando less. Dit betekent dat wanneer je wil weten hoe je voorwaarts moet zoeken in een manpagina, je dit moet gaan zoeken bij het commando less en niet bij het commando man. Vraag de manpagina op van het commando less en ga na hoe je een tekst die met less wordt getoond kan afsluiten. Hoe kan je voorwaarts zoeken in een manpagina?

```bash
/zoekopdracht
```

en dan `n` om naar het volgende en `shift + n`om naar het vorige resultaat te gaan.

2. Hoe kan je zorgen dat er bij het zoeken in een manpagina geen rekening wordt gehouden met het verschil tussen hoofd- en kleine letters?

```
volgens google gewoon als je je zoekopdracht in kleine letters intikt
```

3. Bekijk de manpagina van het commando man en ga na hoeveel secties er gekend zijn.

```
13
```

4. Wanneer je de opdracht “man read” intikt krijg je de info te zien van het commando read. Er is echter ook een systeemaanroep read aanwezig. Hoe kan je aan man meegeven dat je niet de info wenst te zien van het commando read maar wel van de systeemaanroep read?

```
//TODO
```

5. Met de opdracht “ls” krijg je van een directory een overzicht van alle bestanden en subdirectories te zien. Wanneer je geen directory opgeeft, wordt de huidige werkdirectory genomen. Wat doen de opties -l en -h?

```bash
ls -l #toont meer details zoals rechten enzo
ls -h #toont hidden files
```

6. Bekijk met “ls /” de inhoud van de hoofddirectory.



7. In punt 5 en 6 heb je gemerkt dat de uitvoer voorzien wordt van kleuren. Zo worden bv. directories in het donkerblauw gekleurd en symbolische links in het lichtblauw. Dit gedrag is te wijten aan het feit dat er voor ls een alias gedefinieerd is die telkens ls vervangt door “ls --color=auto”. Ga met de opdracht “alias” na welke andere aliassen er bestaan. 

```
nog een aantal andere aliassen voor ls en grep met opties
```

8. Met de opdracht “cd” kan je van werkdirectory veranderen. Wanneer je geen directorynaam opgeeft wordt je home-directory de nieuwe werkdirectory. Voer “cd /tmp” uit en keer daarna terug naar je home-directory.

9. Een directory aanmaken kan via de opdracht “mkdir”. Maak in je home-directory een directory aan met als naam ‘c’ waar je toekomstige C-programma’s naartoe kan kopiëren.

10. Een bestand kopiëren gebeurt via de opdracht “cp”. De eerste parameter is de bron, de tweede de bestemming. Een bestand verplaatsen doe je via de opdracht “mv”.



```c
#include <stdio.h>
int main(){
	printf(“Hello ik ben MARTIJN!!!!!!”);
	return 0;
}
```

![image-20220225142420072](img/image-20220225142420072.png)

Static is dus veel groter

 ### Deel 3

programma geschreven met memory leaks ik heb geen zin om het over te type want ik weet niet hoe ik copy paste uit virtualbox

 ### Deel 4



### Deel 7

1. Met welk van de commando’s cp, dd, ln, mktemp, touch en cat kan je vlug een aantal (lege) bestanden aanmaken waarvan de namen als parameters van het commando worden opgegeven?

```
touch
```



2. Wat verschijnt er op het scherm indien je de opdracht head /etc/passwd uitvoert? Zoek nu de verwante opdracht voor het tonen van de laatste lijnen van een bestand. Hoe kan je steeds de laatste lijnen van een bestand op het scherm laten verschijnen wanneer er een ander proces achteraan het bestand lijnen toevoegt?

```bash
$ head /etc/passwd
=> eerste 10 lijnen van de password file

$ tail /etc/passwd

$ tail -f
```



3. Waarvoor dient de optie -rf bij de opdracht rm? Maak met een editor een bestand aan met als naam “-rf”. Hoe kan je het bestand “-rf“ verwijderen?

```bash
r = recursive
f = force

# het lukt mij niet om een bestand genaamd -rf te maken
```



4. Welke opties moet je toevoegen aan het commando wc om enkel de grootte van een bestand te tonen zonder extra informatie?

```bash
# wc -c
```



5. In Bash zijn er ook Bash-builtin opdrachten zoals cd, set, pwd, exec, printf en : waarvoor er geen aparte man-pagina’s beschikbaar zijn. Een overzicht kan je bekomen door man builtin of door de man-pagina van Bash op te vragen. Zoek informatie op over het gebruik van de opdrachten cd, set, pwd, exec, printf en :.

```
oke
```



6. Wat doet het commando sync?

```bash
sync - Synchronize cached writes to persistent storage
```



7. Hoe kan je met het commando dd een afbeelding maken van een USB-pen? Welke device-file heb je hiervoor nodig? Bekijk de uitvoer van de opdracht “fdisk -l”

```bash
$ dd if=/dev/usb/disk/sdX of=/path/to/backup.img bs=4M
# stackoverflow

dd if=/dev/random bs=64 count=1 #dit doorgeven aan od om random 64 bit getal te berekenen

```



8. Hoe kan je met dd een kopie maken van de eerste 512 bytes van de vaste schijf? Bekijk met het commando strings welke tekststrings in die 512 bytes verscholen zitten.

```bash
$ dd if=/dev/sda of=/root/Documents/lol bs=512 count=1
=>
	1+0 records in
	1+0 records out
	512 bytes copied, 0.000303232 s, 1.7 MB/s
	
$ strings lol
=>
  ZRr=
  `|f	
  \|f1
  GRUB 
  Geom
  Hard Disk
  Read
  Error

```



9. Gebruik het commando find om een lijst van bestanden te krijgen die de afgelopen 24u nog werden aangepast.

```bash
$ find / -mtime 1 -ls
```



10. Met het commando wodim kan je van op de opdrachtlijn een CD/DVD-branden. Met het commando genisoimage kan je een ISO-bestand aanmaken. Hoe kan je van de inhoud van de /root directory een ISO-bestand maken? 

```bash
$ genisoimage -D -o root.iso /root

=>
4.68% done, estimate finish Fri Mar  4 13:25:59 2022
  9.36% done, estimate finish Fri Mar  4 13:25:59 2022
 14.02% done, estimate finish Fri Mar  4 13:25:59 2022
 18.69% done, estimate finish Fri Mar  4 13:25:59 2022
 23.37% done, estimate finish Fri Mar  4 13:25:59 2022
 28.04% done, estimate finish Fri Mar  4 13:25:59 2022
 32.70% done, estimate finish Fri Mar  4 13:25:59 2022
 37.38% done, estimate finish Fri Mar  4 13:25:59 2022
 42.06% done, estimate finish Fri Mar  4 13:25:59 2022
 46.73% done, estimate finish Fri Mar  4 13:25:59 2022
 51.39% done, estimate finish Fri Mar  4 13:26:00 2022
 56.07% done, estimate finish Fri Mar  4 13:26:00 2022
 60.73% done, estimate finish Fri Mar  4 13:26:00 2022
 65.41% done, estimate finish Fri Mar  4 13:26:00 2022
 70.08% done, estimate finish Fri Mar  4 13:26:01 2022
 74.75% done, estimate finish Fri Mar  4 13:26:01 2022
 79.42% done, estimate finish Fri Mar  4 13:26:01 2022
 84.10% done, estimate finish Fri Mar  4 13:26:01 2022
 88.78% done, estimate finish Fri Mar  4 13:26:01 2022
 93.44% done, estimate finish Fri Mar  4 13:26:01 2022
 98.11% done, estimate finish Fri Mar  4 13:26:01 2022
Total translation table size: 0
Total rockridge attributes bytes: 0
Total directory bytes: 1132544
Path table size(bytes): 6162
Max brk space used 46a000
107024 extents written (209 MB)

```



11. Bij vraag 10 zal je merken dat de namen van de bestanden/directories werden gewijzigd. Je kunt dit vermijden door de image in Joliet-formaat weg te schrijven.

```bash
$ mount root.iso /mnt #om te lezen
$ cd /mnt
=> 
_a___         _bash_hi  _bash_pr  c       close    _cshrc    desktop   download  _esmtp_q  _local       music     _pki    _ssh     template      _vbox001.pid  videos    _vscode
anaconda.cfg  _bash_lo  _bashrc   _cache  _config  dead.let  document  _esd_aut  _lesshst  martijn.txt  pictures  public  _tcshrc  _vbox000.pid  _vboxcli.pid  _viminfo
# wordt afgeknipt op 8 tekens & alleen lowercase

$ genisoimage -J -D -o root.iso /root # De -J voor Joliet
$ umount /mnt # eerst effe de vorige unmounten
$ mount root.iso /mnt #om te lezen
$ cd /mnt
$ ls 
=> _a___  anaconda-ks.cfg  c  close  dead.letter  Desktop  Documents  Downloads  martijn.txt  Music  Pictures  Public  root.iso  Templates  Videos

# ziet er beter uit

```

Naast reguliere expressies kent Unix ook patterns om een verzameling strings te beschrijven. De mogelijkheden van standaard patterns zijn veel beperkter dan bv. reguliere expressies en  worden gebruikt zowel in opdrachten als in shellscripts. In recente Bash-versies werden deze patterns uitgebreid. Extended pattern matching kan worden aangezet met de opdracht “shopt –s extglob”. Bij het uitvoeren van een commando met een pattern wordt eerst een lijst met bestandsnamen gegenereerd die aan het opgegeven patroon voldoen. Dit wordt meestal “Pathname Expansion” genoemd. Meer uitleg kan je vinden in de man-pagina van Bash onder de rubriek “Pathname Expansion”. Maak voor onderstaande opdrachten de volgende lege bestanden aan: a, b, c, d, e, ab.c, a.b, b.a, b.c, c.d en d.e.



12. Voer de volgende opdrachten uit: 
    1. `dir a*.* ` => `a.b  ab.c`
    2. `dir a* ` => `a  a.b	ab.c`
    3. `dir *a  ` => `a  b.a`
    4. `dir a\* ` => `dir: cannot access 'a*': No such file or directory`
    5. Bemerk een belangrijk verschil met reguliere expressies. Bovendien wijkt de uitvoer af van de uitvoer van dezelfde commando’s in Windows. 



13. Voorspel en controleer de uitvoer van de opdrachten: 

    1. `printf "%s\n"[abcd] ` => `[abcd]`

    2. `printf "%s\n" [!abcd] ` => `e`

    3. `printf "%s\n" [^abcd]` => `e`

    4. `printf "%s\n" [a-d] ` => 

       ```
       a
       b
       c
       d
       ```

    5. `printf "%s\n" [abcd]*[abcd] ` =>

       ```
       a.b
       ab.c
       b.a
       b.c
       c.d
       ```

       



14. Voer de onderstaande commando’s uit. 
    1. `printf "%s\n" [a-e] `
    2. `printf "%s\n" [a/-e] `
    3. `printf "%s\n" [a\-e] `
    4. `printf "%s\n" [!\!]*`
    5. Wat is de bedoeling van het \\-teken in deze opdrachten? Wat gebeurt er indien je het verkeerde /-teken gebruikt? 

```bash
# \ is de escape-character, om de gereserveerde karakters als gewone karakters te kunnen gebruiken
# met / werkt het niet
```



15. Hoe kan je een lijst met bestandsnamen bekomen die precies uit één enkel karakter bestaan? 

```bash
printf "%s\n" ?
```



16. Vraag een lijst met bestandsnamen die uit precies twee karakters bestaan. Vergelijk de uitvoer met die van de vorige opgave.

```bash
$ printf "%s\n" ??
ik heb geen bestanden met twee tekens
```



17. Voer volgende opdrachten uit: 

1. `ls * `
2. `dir * `
3. `printf "%s\n" * `
4. `ls "*" `
5. `printf "%s\n" "*" `

Wat is het subtiele verschil in uitvoer tussen de eerste drie opdrachten? Verklaar dit verschil door nog een aantal bestanden aan te maken en beide commando’s opnieuw uit te voeren. Verklaar het belangrijke verschil tussen de eerste en de vierde opdracht. Verklaar ook de verschillende uitvoer van de twee laatste opdrachten.

```bash
# ls en dir doen zo map: files
# bij printf wordt gewoon alles achter elkaar gekletst

# de eerste toont alle files en folders die de wildcard matchen
# de vierde toont alle files en folders die "*" heten

# Ik heb geen files die "*" heten dus geen uitvoer
```



18. Zorg dat er geen bestanden in de werkdirectory staan waarvan de naam met abc begint. Verklaar dan het verschil in uitvoer tussen volgende opdrachten: 

1. `ls abc* ` => `ls: cannot access 'abc*': No such file or directory`
2. `printf “%s\n” abc* ` => `abc*`



19. Voer de opdracht rm –f ?? uit. Verklaar daarna het verschil in uitvoer tussen volgende opdrachten: 

1. `printf "%s\n" ??? `

   ```
   a.b
   b.a
   b.c
   c.d
   d.e
   ```

   

2. `printf "%s\n" ??e ` => `d.e`

3. `printf "%s\n" ?? ` => `??` (ja alle bestande met twee karakters zijn verwijderd dus daarom vinden we niks)



20. Enigszins verwant aan pathname expansion is de mogelijkheid tot brace expansion. Dergelijke uitdrukkingen bestaan uit een eventuele prefix, gevolgd door een rij strings tussen accolades (gescheiden door komma’s) en afgesloten met een eventuele suffix. Elke string binnen de accolades wordt gecombineerd met een prefix en een suffix. In tegenstelling tot pathname expansions genereert een brace expansion een rij strings, zonder dat gecontroleerd wordt of deze strings met bestaande bestanden overeenkomen. Zowel in de prefix, de elementenstrings of de suffix van een brace expansion kunnen (recursief) andere brace expansions opgenomen worden. 

    Met welke brace expansion kan je alle getallen tussen 0 en 29 (grenzen inbegrepen) als argumenten aan een opdracht (bv. printf) meegeven? Hoe kan je deze brace expansion beknopt schrijven, door bv. een range te gebruiken?



```bash
$ echo {0..29}
```



21. Je kan brace expansions nesten. Genereer de hexadecimale voorstellingen van alle even gehele getallen kleiner dan 256.

```bash
$ printf '%x ' {0..255..2}
```



22. Wanneer het eerste karakter van een string een tilde(~) is, wordt er aan tilde expansion gedaan. Dit wil zeggen dat alle karakters tussen de tilde en de eerste slash beschouwd worden als een gebruikersnaam. Wat verschijnt er op het scherm wanneer je de volgende opdrachten uitvoert: 

1. `echo ~root/ ` => `/root/`
2. `echo ~mail/ ` => `/var/spool/mail/`
3. `echo ~{mail,root}` => `/var/spool/mail   /root`

Wat wordt door de shell het eerst vervangen, de tilde of de accolades?

```bash
De accolades, want anders zou het de derde uitvoer dit zijn:
/root/mail   /root/root
```

