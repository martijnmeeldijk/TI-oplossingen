# Gegevensstructuren

Onderwerpen uit de slides aangevuld met knowledge uit het boek (als je 70 paginas een boek kunt noemen).

Oke kleine heads-up, op de slides over het examen staat bij de te kennen leerstof:

> Bewijzen of afleidingen die tijdens de les uitgewerkt zijn.

tering

## H1 - Onderwerp en doel

We defineren enkele termen die ons helpen onderscheid te maken tussen verschillende datastructuren

* Containers en woordenboeken

Bij een **container** speelt de sleutel van de gegevens geen rol. Gevens in een container kunnen ofwel opgevraagd worden in een bepaalde volgorde (toevoegvolgorde, prioriteit) of op basis van hun plaats in de structuur. **Woordenboeken** daarentegen ondersteunen operaties zoals zoeken, toevoegen en verwijderen. Woordenboeken laten ook vaak operaties toe die de volgorde van de sleutels gebruiken, op voorwaarde dat er op de één of andere manier een rangorde toegekend wordt aan iedere sleutel.

* Continue en gelinkte datastructuren

Dit slaat op de layout van de datastructuur in het geheugen. Wanneer de data in een continue regio in het geheugen opgeslagen wordt, dan spreken we van een **continue datastructuur**. Denk aan arrays, hashmaps en heaps. Dit soort datastructuur maakt hevig gebruik van ruimtelijke lokaliteit. Spijtig genoeg moet de grootte van deze structuren meestal op voorhand vastgelegd worden. Elk element van een **gelinkte datastructuur** bevat een pointer naar zijn opvolger. Hierdoor hoeven we de grootte van de structuur niet op voorhand vast te leggen.

* Lineaire en niet-lineaire datastructuren

Een andere manier van onderscheid te maken. **Lineaire datastructuren** kunnen grafisch weergegeven worden op een as. Bij **niet-lineaire gegevensstructuren** zoals bomen of grafen is echter een voorstelling in meerdere dimensies nodig.



## H2 - Efficientie van algoritmen

Aangezien het onbegonnen werk is rekening te houden met elke processorarchitectuur, programmeertaal en compiler om de efficiëntie van een algoritme te bepalen, is de exacte tijdsduur van een algoritme berekenen praktisch onmogelijk. We bepalen een schatting van de uitvoeringstijd louter op basis van het algoritme en op $n$ (het aantal gegevens). We beperken on tot drie gevallen:

* **Beste geval** (best-case running time)
  * Niet echt super nuttig. Als we de performantie van een sorteeralgoritme testen is het een beetje nutteloos om te gaan kijken hoe goed het omgaat met al gesorteerde gegevens. 
* **Slechtste geval** (worst-case running time)
  * Het slechtste geval is meestal het belangrijkste. Omdat we weten dat het algoritme gegarandeerd **nooit slechter** zal presteren.
* **Gemiddeld geval** (average-case) running time
  * Is moeilijk te bepalen. Bovendien is de definitie van gemiddeld een beetje vaag. Om dit soort analyse mogelijk te maken moeten er vaak een aantal onrealistische veronderstellingen gemaakt worden.
  * Klein leuk feitje. Als de gemiddelde performantie van een algoritme zeer goed is, maar het slechtste geval vreselijk slecht, dan spreken we van een *Las Vegas* algoritme. Want we nemen het risico.

### Insertion sort

We bepalen als voorbeeld de uitvoeringstijd van `insertion_sort`

```c++
void insertion_sort(vector<T>& v) {
// Stijgend rangschikken
  for(int i = 1 ; i < v.size(); i++) {
  // De eerste i getallen staan reeds in volgorde
    T h = move(v[i]);
    int j = i − 1;
    while (j >= 0 && h < v[j]) {
      v [j + 1] = move(v[j]) ;
      j−−;
    }
    v[j + 1] = move(h) ;
  }
}
```

We splitsen de code op in primitieve operaties en kijken hoe vaak elke operatie wordt uitgevoerd:

<img src="img/image-20220128162608143.png" alt="image-20220128162608143" style="zoom:50%;" />

In het best-case scenario wordt de while-loop dus nooit uitgevoerd. Dit is als ge gegevens in de vector al stijgend gerangschikt zijn. Het slechtste doet zich voor als de vector dalend gerangschikt is, dan zal de while-loop telkens $i$ keer herhaald worden. Je kan dit nu voorstellen als een veelterm van de tweede graad. Kijk maar in de cursus ;) 

 

### Asymptotische benadering

We kunnen de uitvoeringstijd van een algoritme op 3 manieren asymptotisch benaderen. In de tekeningen is $f(n)$ de looptijd van ons algoritme en $g(n)$ een arbitraire functie.

| Asymtotische bovengrens                                      | Asymptotische ondergrens                                     | Asymptotische boven- en ondergrens                           |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![image-20220128163425475](img/image-20220128163425475.png)  | ![image-20220128163445890](img/image-20220128163445890.png)  | ![image-20220128163455525](img/image-20220128163455525.png)  |
| We weten dat voor een grote $n$ de uitvoeringstijd niet sneller zal stijgen dan een bepaalde functie. $O(g(n))$ | We weten dat de uitvoeringstijd minstens zo snel zal stijgen als een bepaalde functie. $\Omega(g(n))$ | Wanneer dezelfde functie zowel een boven als ondergrens voor $f(n)$ vormt. $\Theta(g(n))$ |



### P en NP

Men defineert defineert de verzameling P als alle problemen die oplosbaar zijn in polynomiale tijd. Dus in $O(n^\alpha)$. Problemen waarbij dit niet mogelijk (of alvast nog niet bekend) is, noemen we NP (Nondeterministic Polynomial). Een groot vraagteken is of P en NP gelijk zijn (dus dat alle problemen zouden kunnen opgelost worden in polynomiale tijd). Moest je dit kunnen aantonen kun je blijkbaar 1000 000\$ winnen. Voorlopig gaan we er van uit dat $P \neq NP$.



### Andere criteria

De asymptotische benadering van de uitvoeringstijd is natuurlijk niet het enige belangrijke maatstaf bij de beoordeling van een algoritme. We leven in de echt wereld en moeten rekening houden met een aantal andere zaken:

* Kost van implementeren en testen
* De asymptotische benadering is een *benadering*
  * Constante factoren spelen geen rol in deze benadering, maar in de praktijk wel. In de realiteit zijn twee $O(n)$ algoritmen niet speciaal even snel
  * De benaderingen gelden alleen voor vodoende grote $n$. Soms is een 'slecht' algoritme dus beter voor kleine bewerkingen.
  * Soms is de benadering in het slechtste geval *te slecht* en kan het ons een vertekend beeld geven.
  * We veronderstellen dat elke input even waarschijnlijk is, maar in de realiteit kan je vaak met voorkennis over de data een algoritme een stuk efficiënter maken.
* Soms gebruiken algoritmen te veel geheugen, wat hun voordeel in uitvoeringstijd tenietdoet omdat het geheugen van de computer te klein is.
* Algoritmen kunnen verbazinwekkend verschillende performantie hebben door de geheugenhiërarchie van de computer. Denk aan lokaliteit en caches.
* Parallelle verwerking kan de werktijd van ons algoritme versnellen. Als het aantal verwerkingseenheden samen groeit met $n$ bijvoorbeeld. Denk aan routers in een netwerk.
* Toegang tot het geheugen is een relatief trage operatie. Agoritmen die veel in het geheugen zitten zijn doorgaans trager.

## H3 - Containers

In het eerste hoofdstuk legde ik je het verschil uit tussen een container en een woordenboek. Nu focussen we ons nu dus even op containers. 



### Tabel

Omdat computers nu eenmaal zo werken, moeten we als we gegevens in een tabel (array) opslaan, op voorhand weten hoe groot deze moet zijn. Dit probleem kunnen we (tot kost van de performantie) door een nieuwe tabel te maken wanneer de huidige te klein is. Gewoonlijk maakt men wanneer de array te klein is een nieuwe van twee maal de grootte. De geamorticeerde efficiëntie van deze operatie is nog steeds $0(1)$ aangezien de kost om $n$ elementen $3n$ bedraagt. Zie hieronder voor een beetje meer info. Ik weet nog niet goed of we dit echt moeten kunnen aantonen. Oke het is vorig jaar gevraagd blijkbaar.

| Operatie                              | Cost             |
| ------------------------------------- | ---------------- |
| Element opvragen                      | $O(1)$           |
| Toevoegen (als we genoeg plek hebben) | $O(1)$           |
| n elementen toevoegen                 | $3n$ (gemiddeld) |

> **Amortized efficiency** is a very important concept: instead of looking at a single operation, we look at a sequence of operations and calculate the average efficiency. This is commonly used when an single operation could be slow in some rare situations

Oké, hoe bewijzen we nu dat de geamorticeerde efficiëntie van een element toevoegen aan een dymanische tabel nog steeds gelijk is aan $0(1)$. 
$$
\sum_{i=1}^n t_i = n + \sum_{j=0}^{\lceil log(n)\rceil - 1}2^j < n + 2n = 3n
$$

Met $t_i$ bedoelen we de tijd om de $i$-de toevoegoperatie uit te voeren. $\sum_{i=1}^n t_i$ is dus de tijd die $n$ toevoegoperaties in beslag nemen. We kunnen deze opsplitsen in 2 gevallen. 

* De array is niet vol: de operatie duurt '1' lang
* De array is vol: er staan $i-1$ elementen in de array. Dan verdubbelen we de grootte van de array. Dit moeten we dus elke keer als het aantal elementen in de array een macht van twee is doen. Van daar de :$\sum_{j=0}^{\lceil log(n)\rceil - 1}2^j$ 

Wikipedia:

> For ${\displaystyle r\neq 1}$, the sum of the first *n*+1 terms of a geometric series, up to and including the *r* n term, is:

$$
{\displaystyle a+ar+ar^{2}+ar^{3}+\cdots +ar^{n}=\sum _{k=0}^{n}ar^{k}=a\left({\frac {1-r^{n+1}}{1-r}}\right),}
$$



### Linked List

Bij een gelinkte lijst is elk element toegankelijk, maar niet direct toegankelijk. Als we een bepaald element zoeken, zullen we altijd vanaf de eerste knoop moeten beginnen en de pointer naar zijn opvolger volgen. We hebben natuulijk ook dubbel gelinkte lijsten, maar dat verhaal ken je hopelijk al.

| Operatie                                 | Cost   |
| ---------------------------------------- | ------ |
| Eerste element opvragen                  | $O(1)$ |
| Element verwijderen (dat al gevonden is) | $O(1)$ |
| Element opvragen                         | $O(n)$ |



### Stack

Je kan een stapel implementeren gebruik makende van een tabel, dan heb je wel een stack pointer nodig omdat je de grootte van je tabel niet zomaar bij elke operatie kan gaan zitten aanpassen. Een element verwijderen is dan gewoon je stack pointer een plaatsje terugschuiven. 

Je kan een stack ook perfect implementeren met een gelinkte lijst. Alle operaties blijven dan nog steeds $O(1)$. Bovendien kan je stapel dan ook niet zomaar vol zijn zoals bij een array.

Een stack wordt zeer vaak gebruikt en is handig om gegevens bij te houden waarvoor de volgorde van verwijderen onbelangrijk is.



| Operatie                         | Cost   |
| -------------------------------- | ------ |
| Toevoegen (Push)                 | $O(1)$ |
| Verwijderen (Pop)                | $O(1)$ |
| Testen of hij leeg is            | $O(1)$ |
| Bovenste gegeven opvragen (peek) | $O(1)$ |

Een stack werkt volgens het first in last out principe.

### Queue

Simpelweg een stack met twee pointers. Als we herhaaldelijk elementen toevoegen en verwijderen komen we bij een tabelgebaseerde implementatie wel lichtjes in de problemen. Onze queue schuift dan telkens verder naar het einde van de tabel en zal deze ook snel bereiken. Dit kunnen we oplossen door een ringvormige tabel te gebruiken. Dit betekent simpelweg dat als we de index van het laatste element van de tabel bereiken, de volgende toevoegings- of verwijderingsoperatie we terug uitkomen bij de eerste.

Het is natuulijk ook weer mogelijk om een gelinkte lijst te gebruiken voor de implementatie voor je queue. Dan moet je simpelweg een extra pointer naar het laatste element bijhouden. Als je ook langs de achterkant van de queue elementen wilt verwijderen zal je een dubbelgelinkte lijst nodig hebben.

| Operatie              | Cost   |
| --------------------- | ------ |
| Toevoegen             | $O(1)$ |
| Verwijderen           | $O(1)$ |
| Testen of hij leeg is | $O(1)$ |

Een queue werkt volgens het first in first out principe.

### Deque

Indien je het nog niet wist. Deque staat voor *double ended queue*. Een deque is een combinatie van een stack en een queue. Je kan nu vanvoor en vanachter elementen toevoegen of verwijderen.

| Operatie                                       | Cost   |
| ---------------------------------------------- | ------ |
| Toevoegen                                      | $O(1)$ |
| Verwijderen                                    | $O(1)$ |
| Het boeit eigenlijk, niet alles is toch $O(1)$ |        |



### Boom

<img src="img/image-20211218201253485.png" alt="image-20211218201253485" style="zoom:50%;" />

We defineren een boom simpelweg als een verzameling van **knopen** (nodes of vertices) en **takken** (edges) waarmee de knopen aan elkaar verbonden zijn. De takken hebben geen bepaalde richting, daarenboven is het belangrijk dat er geen lussen mogen bestaan. Een boom heeft ook niet noodzakelijk een wortel.

Verder verklaren zal ik nog enkele termen verduidelijken om de rest van dit onderdeel een beetje verstaanbaarder te maken:

* **Wortel**: het bovenste bolletje, de knoop zonder ouders.
* **Blad**: Eén van de onderste bolletjes. Een knoop zonder kinderen.
* **Deelboom**: je kan elke knoop van een boom zien als een wortel van een nieuwe boom, dit is een deelboom van onze boom
* **Diepte** van een knoop: het aantal takken tussen deze knoop en de wortel.
* **Hoogte** van een knoop: lengte van de langste weg van deze knoop tot een blad.
* **Graad**: het aantal kinderen van een knoop

We focussen ons vooral op binaire bomen, waar elke knoop twee kinderen kan hebben. Er zijn ook andere bomen, maar daar zal ik verder op ingaan moest dat nodig zijn verder in de cursus (niet dus).



#### Voorstelling

Je kan als het aantal knopen vastligt, een boom opslaan in een tabel. Meestal zijn bomen dynamische structuren, dus gaan we gebruik maken van pointers. Een binaire boom heeft typisch naar ieder van zijn kinderen een pointer. Als een boom geen kinderen of maar een deel van het mogelijke kinderen heeft, zullen deze voorgesteld worden door *nullpointers*. Verder kan je ook als er veel kinderen onbreken de knopen in de boom bijvoorbeeld pointers geven naar zijn ouders om sommige algoritmes sneller te maken.

Als we een boom met een variërend aantal gevens willen opslaan, kunnen we best elke knoop een gelinkte lijst van zijn kinderen laten bijhouden. Dit heeft als gevolg dat elke knoop een wijzer bevat naar zijn kind en een wijzer naar zijn rechterbuur. Probeer het je even voor te stellen. De desbetreffende knoop zit in de lijst van zijn ouder, en in een gelinkte lijst duidt elk element zijn opvolger aan. Dus heeft elke knoop ook een wijzer naar zijn rechterbuur.



#### Systematisch overlopen van bomen

<img src="img/image-20220128215720789.png" alt="image-20220128215720789" style="zoom: 50%;" />

Bij tabellen kunnen we gemakkelijk sequentieel alle gegevens in volgorde uitlezen. Spijtig genoeg is dat niet zo simpel bij bomen. De manier waarop we een boom doorlopen hangt af van hoe wij beslissen om de boom te doorlopen. We maken onderscheid tussen drie mogelijke manieren:

* **Depth first**: 
  
  We bekijken de wortel en gaan telkens recursief verder naar beneden. Deze omschijving is een beetje vaag, aangezien er verschillende mogelijkheden zijn. Kijk gewoon naar de naam. We gaan dus altijd direct diep in de boom gaan bij deze manier. We hebben dus een aantal recusief gedefineerde manieren om een boom depth first te doorlopen:
  
  * Pre-order: wortel - linkse deelboom - rechtse deelboom (Polish notation)
    * {1, 2, 4, 5, 8, 9, 3, 6, 7, 10, 11} (bij de boom hierboven)
  * In-order: linkse deelboom - wortel - rechtse deelboom
    * {4, 2, 8, 5, 9, 1, 6, 3, 10, 11, 7}
  * Reverse in-order: rechter deelboom - wortel - linkse deelboom (zegt de cursus precies niks over)
  * Post-order: linkse deelboom - rechtse deelboom - wortel  (Reverse polish notation)
    * {4, 8, 9, 5, 2, 6, 11, 10, 7, 3, 1}
    * Is nuttig op een stack machine blijkbaar
  
* **Breadth-first**: op een gegeven niveau lezen we eerst alle knopen op dat niveau alvorens dieper te gaan. Deze methode maakt geen gebruik van de recusieve eigenschap van de boom. 

* **Best first**: We kennen een bepaalde prioriteit toe aan de kinderen (e.g. Monte Carlo tree search)



### Graaf

<img src="img/image-20211218201400055.png" alt="image-20211218201400055" style="zoom:50%;" />

Een graaf bestaat uit **knopen** (vertices) en **verbindingen** (edges). De knopen stellen objecten voor waartussen verbindingen kunnen bestaan. Meestal mag er maar één verbinding zijn tussen twee knopen. Is dit niet het geval, spreken we van een **multigraaf** hier is het ook toegestaan dat knopen een verbinding hebben met zichzelf. Als verbindingen een bepaalde richting hebben, spreken we van een **gerichte graaf**. Bij een ongerichte graaf stelt de **graad** van een knoop het aantal buren van die knoop voor. Bij gerichte grafen spreken we van een in- en uitgraad. Waarbij de ingraad dan het aantal inkomende verbindingen is en de uitgraad het aantal puisten op de reet van uw moeder.

We kunnen grafen in een computer op twee manieren voorstellen:

**Adjacency matrix** (burenmatrix): een N x N matrix waarbij het gewicht van de verbinding tussen 2 nodes op plaats [node1, node2] staat. Deze manier is zeer efficiënt om snel te testen of er een verbinding bestaat tussen twee knopen, maar neemt spijtig genoeg snel veel geheugen in beslag. We gebruikten deze manier dus best om een *dichte graaf*, met relatief veel verbindingen voor te stellen. Bij een ongerichte graaf komt elke verbinding twee keer voor in de matrix.

**Adjacency lists ** (burenlijsten): Voor elke node houden we een lijst met zijn buren bij. Dit is efficienter voor grafen met weinig verbindingen.





## 4 - Priority queues

Priority queue = een queue die elementen teruggeeft op basis van hun prioriteit.



### Heap

<img src="img/image-20211218214752652.png" alt="image-20211218214752652" style="zoom:50%;" />

Basically een binaire boom waar alle niveaus (behalve soms de laatste) gevuld zijn.

**Max heap**: the value of the parent is larger than (or equal to) the value of the children 

**Min heap**: the value of the parent is smaller than (or equal to) the value of the children

Zo kan je altijd snel het kleinste (of het grootste) element opvragen.



Aantal nodes: tussen $2^{h} - 1$ En $2^{h+1} - 1$ met hoogte $h$ 

dus h =  $\lfloor log(n) \rfloor$

Omdat een heap zo regelmatig is kunnen we die gewoon in een array steken:

* The parent of i is stored at ⌊(i-1)/2⌋ 
* The children of i are stored at 2i+1 and 2i+2



**Elementen toevoegen**

Doen we achteraan de heap. In het slechtste geval moet die dan helemaal naar boven: $O(log(n))$

= bubble up

**Root node verwijderen**

Dan het laatste element op zijn plek zetten en dan bubble down (telkens verwisselen met grootste kind bij max heap): $O(log(n))$

**Heap bouwen door elementen toe te voegen**

$O(n log(n))$ (moeten we dit bewijs kennen ik hoop het niet want hayek)

**Heap opbouwen door kleinere heaps samen te voegen**

$O(n)$



### Merging heaps

Soms willen we twee heaps samenvoegen. Sommige andere soorten heaps zijn hier goed in.



#### Binomial queue

= een set van **binomial trees**

elke boom heeft een vaste vorm:

<img src="img/image-20211218220045165.png" alt="image-20211218220045165" style="zoom:50%;" />

Bij $n$ elementen zijn er dan $log(n)$ bomen nodig, deze bomen volgen allemaal de heap-eigenschap.

**Minimum vinden**: dan moet je alle rootknopen van de bomen vergelijken: $O(log (n))$

Je kan gemakkelijk 2 bomen van dezelfde groote mergen in 1 operatie (boom met de grootste root links):

 <img src="img/image-20211218220532622.png" alt="image-20211218220532622" style="zoom:50%;" />

**2 binomial queues mergen**: alle bomen van dezelfde grootte samenvoegen en herhalen: $O(log(n))$

**minimum verwijderen**: dan valt de boom uit elkaar in kleine boompjes die je moet mergen: $O(log(n))$



#### Pairing heap

Een boom die de heap-eigenschap volgt, maar niet speciaal compleet is.

> Each node stores a pointer to its leftmost child and to its first sibling

<img src="img/image-20211218221059741.png" alt="image-20211218221059741" style="zoom:50%;" />

Als we 2 pairing heaps mergen, zetten we de boom met de grootste root links en omdat elke node een pointer heeft naar zijn buur, kunnen we gemakkelijk alles verzetten.

<img src="img/image-20211218223352628.png" alt="image-20211218223352628" style="zoom: 33%;" />

**Prioriteit van een element verlagen**

Dan kan je de deelboom vanaf dat element afsplitsen en opnieuw mergen.

**De root verwijderen**

//TODO



## 5 - Basic dictionaries

Hier wordt precies niet echt iets nieuws gezegd.

Behalve als je niet weet wat binary search is.



## 6 - Hash Tables



## 7 - Binary Search Trees



## 8 - External data structures





## Mogelijke examenvragen

**Wat zijn de verschillende technieken om collisions op te vangen bij hashtabellen?**

**Toon aan dat bij een binaire zoekboom de voorloper van een knoop met twee kinderen geen rechterkind heeft.**

**Gegeven een zekere toepassing, welke datastructuur zou je gebruiken? Wat zijn de nadelen?**

**Gegeven een binaire zoekboom, voeg een element toe, verwijder een element, geef een mogelijke toevoegvolgorde die in deze boom resulteert.**



### Vragen van vorig jaar

1. Vraag over hashtables waarbij dat je moet toevoegen, verwijderen en rehashen
2. Een vraag waarbij je de 1000 grootste elementen moet gaan opslaan in een datastructuur (heap was hier het beste blijkbaar)
3. Uitleggen wat threaded trees zijn en hoe je moet toevoegen/verwijderen
4. Bewijs dat het verdubbelen van een array geamortiseerd O(1) is



### Voorgaande jaren

2019 en ouder, dus ik weet nog niet of we alles hiervan moeten kennen.

1. Bespreek toevoegen van sleutels bij binaire zoekbomen, en ook bij 'threaded trees'. Wat is de efficiëntie van deze operatie, als de bomen n knopen bevatten? Verklaar (zonder bewijs)
2. Binaire bomen overlopen hoe? En efficiëntie en verband boom en bin boom
3. methodes van open adressering bespreken + performantie (zonder berekening)
4. leg uit "zoeken in een gesorteerde tabel" en wat is de efficiëntie van dit algoritme
5. Leg uit wat een selectieboom is. performantie van toevoegen, verwijderen enz.. En een implementatievoorbeeld.
6. Wat zijn threaded trees? Welke operaties kan men er efficiënt mee uitvoeren? Bijvraag: Is het niet onefficïent dat je al die pointers naar de juiste plaats moet laten wijzen? Antwoord: nee, dit kan gebeuren tijdens de constructie in O(1), dit staat blijkbaar zo in de cursus
7. Bespreek verwijderen van sleutels bij binaire zoekbomen en threaded trees. Efficientie als boom n gegevens bevat. Verklaar.
8. In detail hashtabellen met chaining uitleggen Bijvraag: Er is een andere soort chaining en wat kan je er me over zeggen?
9. Leg de minst efficiënte methode om een heap op te bouwen uit. En geef zijn efficiëntie. 
10. hoe verwijder je een element uit bin. zoekboom en threaded boom? Geef performantie.
11. Bespreek de performantie van open adressering bij hashing.
12. Bespreek performantie van open adressering. (dus ook uitleggen wat dit is, waar dit gebruikt wordt en welke vormen er zijn)
13. Binaire bomen overlopen hoe? Implementatie en efficiëntie en verband boom en bin boom
14. Bespreek de performantie van zoeken in binaire zoekbomen
15. Hoe kan je binaire bomen systematisch overlopen? Hoe wordt dit geïmplementeerd? Wat is de performantie? Wat is de link tussen algemene bomen overlopen en hun binair equivalent?
16. Hoe zoeken in geordende tabellen + efficiëntie
17. Bespreek de performantie van zoeken bij een gerangschikte tabel, zo uitgebreid mogelijk
18. Bespreek hashfuncties zo uitgebreid mogelijk. (Vaste hashfuncties: hashfamilies, wat bij strings groter dan processorwoord? optimalisatie daarvan)
19. Geef de performantie van open adresseren van Hashtabellen. De 3 manieren van testenvergelijken.
20. Heap als prioriteitswachtrij, wat zijn de operaties en verklaar de performantie 
21. Wat zijn threaded trees, bespreek in detail de operaties die ze ondersteuen. Wat is hun performantie.



### 2018

1. Wat is de performantie van de selectie operatie in beste en slechtste geval? (voor elke implementatie afhankelijk van grootte van k, formules bij implementatie van quicksort kunnen opstellen)
2. Bespreek het algoritme van Dijkstra. Wat is de efficiëntie?
3. Bespreek hashfuncties zo uitgebreid mogelijk. (Vaste hashfuncties: hashfamilies, wat bij strings groter dan processorwoord? optimalisatie daarvan)
4. Bespreek mergesort zo uitgebreid mogelijk, verklaar ook de performantie (geen bewijs)
5. Bespreek de performantie van zoeken in binaire zoekbomen
6. Bespreek diepte-eerst zoeken in een graaf (zowel ongericht als gericht), Welke verbindingen zijn er? Verklaar de performantie. Waar wordt het gebruikt (geen details)?
