# Gevorderde Algoritmen



## Inhoud

[TOC]

## Puntenverdeling

* Niet-periodegebonden evaluatie
  * vaardigheidstest op PC (20 % van de eindscore) 
* Periodegebonden evaluatie: 
  * schriftelijk examen (50 % van de eindscore) en vaardigheidstest 
  * op PC (30% van de eindscore) 

Wanneer men minder dan 8/20 heeft voor het schriftelijk examen en/of voor het deelcijfer van • de vaardigheidstesten kan men niet meer slagen voor het geheel van het opleidingsonderdeel.



# Grafen deel 1



## Grafen

Een graaf bestaat uit:

* Een verzameling **knopen** $V_g$ (vertices)
* Een verzameling **takken** $E_g$ (edges)

### Definities

* De **incidentie** van een knoop $v$: $I(v)$, is de verzameling van alle takken die in die knoop toekomen
* De **graad** van een knoop $v$: $\delta (v) = \# I(v)$ is het aantal takken van de graaf die in $v$ toekomen
* De **omgeving** van een **knoop** $v$: $A(v)$, oftewel adjacency is de verzameling van alle buurknopen van $v$
* De **omgeving** van een **tak** $e$  is de verzameling van alle takken van de graaf die een knoop gemeenschappelijk hebben met $e$
* Een **tocht** is gewoon een sequentie van knopen die je overloopt, met mogelijks dezelfde knoop meermaals te bezoeken
* Een **pad** is een tocht waarbij geen enkele knoop herhaald wordt. De begin en eindknoop zijn dus ook verschillend.
* **Een cyclus** is een tocht waarbij de begin- en eindknoop hetzelfde zijn, en bovendien in de weg daartussen elke knoop maar één keer voorkomt.
* Twee knopen zijn **geconnecteerd** als er een pad tussen bestaat. Een graaf is geconnecteerd als dit geldt voor elk paar knopen van de graaf.

### Voorstelling

Een graaf kan je voorstellen op andere manieren dan een tekening, zodat de computer hem kan begrijpen. 

* Als een **opsomming** van knopen en takken
  * Dat ziet er dan zo uit:
  * $V = \{v_1,v_2,v_3\}$
  * $E=\{v_1v_2, v_2v_3\}$
* Aan de hand van **burenlijsten**
  * Voor elke knoop hou je een lijst bij met zijn buren:
  * $v_1: v_2$
  * $v_2: v_1,v_3$
  * $v_3:v_2$

Twee grafen worden **isomorf** als er een bijectie bestaat tussen hun knopenverzamelingen die een bijectie induceert tussen hun takkenverzamelingen. Dit betekent simpelweg dat ze dezelfde graaf zijn, maar anders getekend of met andere labels. Deze grafen zijn isomorf:

<img src="img/algo2/image-20221120115941268.png" alt="image-20221120115941268" style="zoom:50%;" />



### Speciale grafen

Een **boom** is een geconnecteerde graaf die geen cycli bevat. Ik ga even niet uitleggen wat een boom is. 

* Eigenschap: Een boom met $p$ knopen heeft $p-1$ takken
  * //TODO bewijs (moeten we dit kunnen/kennen?)

Een **complete graaf** is een graaf waarbij elke twee verschillende knopen met elkaar verbonden zijn.



### Digrafen

Een gerichte graaf of **digraaf** bestaat uit:

* Een verzameling **knopen**: $V$
* Een verzameling **pijlen**: $A$. Een pijl is een koppel van knopen, waar de volgorde van belang is.

Zo kunnen twee knopen dubbel verbonden zijn, zolang hun pijlen in tegenovergestelde richting lopen.

* De **uit-incidentie** van een knoop $v$, genoteerd als $I(v)$, bevat de pijlen die uit $v$ vertrekken
* De **in-incidentie** $I'(v)$ bevat de pijlen die in $v$ toekomen.

Een **tocht** in een digraaf moet altijd de richting van de pijlen volgen. 

Een **diboom** is een digraaf zonder anti-parallelle pijlen waarvan de onderliggende graaf een boom is. Het is dan wel meestal niet mogelijk om van elke knoop een pad te vinden naar elke andere knoop, waardoor een diboom dus meestal **niet geconnecteerd** is. 

Een **complete digraaf** is een digraaf waarbij elke pijl een anti-parallelle pijl heeft en waarbij de onderliggende graaf een complete graaf vormt. 



## Systematisch zoeken in een graaf

Een diboom wordt een **gewortelde diboom** genoemd als er een knoop bestaat waaruit er naar elke andere knoop een pad bestaat. Deze knoop is dan de **wortel**. 

Een graaf $G'$ is een **opspannende subgraaf** van $G$ als:

* $G'$ is geconnecteerd
* $G$ en $G'$ hebben dezelfde knopenverzameling
* Alle takken van $G'$ behoren ook tot $G$

Als $G'$ ook een boom is, is $G'$ een **opspannende boom** van $G$. 

Een gewortelde diboom $T$ wordt een **opspannende gewortelde diboom** van een graaf $G$ genoemd als de onderliggende graaf van $T$ een opspannende boom van $G$ is. //TODO dit snap ik niet goed



### Breedte-eerst zoeken

Bij breedte eerst zoeken, loop je alle knopen van een graaf af, beginnend bij een gekozen knoop. Vervolgens overloop je eerst alle buren van deze gekozen knoop af. Dan loop je van elk van de buren van de buren af. 

Iets concreter:

* Je hebt je graaf $G$ en je maakt een nieuwe diboom aan. Hieraan voeg je de wortelknoop $r$ (de beginknoop van je zoektocht) toe.
* Overloop alle buren $b_1, b_2, \dots$ van $r$ en voeg ze toe aan de diboom. 
* Herhaal de procedure voor $b_1$, vervolgens voor $b_2, \dots$
* Doe dit verder voor de buren van de buren

**Pros-and-cons**

* Eenvoudig te implementeren
* Het duurt lang voordat je de eerste bladknoop hebt bezocht, en is dus niet handig voor beslissingsproblemen
* Heeft meestal meer geheugenruimte nodig dan DFS, je zal alle gedeeltelijke oplossingen (de niet-bladknopen) moeten opslaan tijdens de uitvoer
* Kan gebruikt worden om de hop-count afstand te bepalen vanuit de wortelknoop. Ook gekend als het algoritme van Moore



### Diepte-eerst zoeken

Dit is het omgekeerde van breedte-eerst zoeken. Je gaat zo snel mogelijk in de diepte:

* Vertrek weer vanaf een gekozen wortel
* Neem zijn eerste buur
* Neem de eerste buur van deze buur
* Wanneer je vast komt te zitten, ga je één niveau omhoog, en neem je dus de volgende buur van de vorige knoop
* Herhaal

Je kan dit algoritme gebruiken om snel na te gaan of een graaf al dan niet geconnecteerd is.

**Pros-and-cons**

* Complexer om te te implementeren dan BFS, omdat je moet terugkrabbelen
* Nuttig voor beslissingsproblemen, omdat je snel bij een bladknoop (en dus een oplossing) komt
* Heeft meestal minder geheugenruimte nodig dan BFS, het volstaat meestal om de boomstructuur en de tot nu toe best gevonden oplossing bij te houden

  

## Minimale opspannende boom

We beginnen met enkele definities:

* Een **gewogen graaf** $G$ is een graaf waarbij elke tak een gewicht is toegekend. Het gewicht van deze graaf is de som van alle takgewichten
* Een **gewicht** $w(e)$ van een tak is een reëel getal dat aangeeft welke 'kost' wordt aangerekend voor het gebruik van deze tak

Een **minimale opspannende boom** van een graaf $G$ is een is een opspannende subgraaf $G'$ met minimaal gewicht. Dit is een optimalisatieprobleem en heeft altijd een opspannende boom als oplossing, zijnde $G'$. Zoals ik het begrijp is deze boom dus een subset van de graaf, die ervoor zorgt dat alles **lusloos** verbonden is, met een **zo laag mogelijk totaal gewicht**. 

//TODO bewijs



Hoe kunnen we nu op een efficiënte manier zo'n minimale opspannende boom vinden op een graaf met positieve gewichten?



### Algoritme van Kruskal

![File:KruskalDemo.gif - Wikimedia Commons](https://upload.wikimedia.org/wikipedia/commons/b/bb/KruskalDemo.gif)

Dit algoritme kan je gebruiken om de minimale opspannende boom van een graaf te vinden. Dit doe je als volgt:

* Neem je graaf zonder takken.
* Neem de kortste tak die twee componenten van je graaf verbindt. Je mag dus geen tak kiezen die delen aan elkaar verbindt die al verbonden zijn in een vorige stap. Voeg deze tak toe aan de graaf.
* Het algoritme is klaar als je geen tak meer vindt.
* Nu heb je de minimale opspannende boom gemaakt. Dit is ook de optimale oplossing.

Nog enkele leuke feitjes. Het algoritme van Kruskal is een gulzig algoritme, omdat we bij elke stap kortzichtig de schijnbaar beste optie nemen. Iemand heeft ook bewezen dat de tijdscomplexiteit van dit algoritme $O(q \log q)$ bedraagt, met $q=(\#E_G)$, zijnde het aantal takken in de graaf $G$.





## Kortste pad

### Afstand in een gewogen graaf

* De **lengte** van een pad in een gewogen graaf is de som van de gewichten van de takken langs dit pad
* De **afstand** tussen twee knopen van een gewogen graaf is de lengte van het kortste pad tussen deze twee knopen



### Algoritme van Dijkstra

Dit algoritme wordt gebruikt om het kortste pad tussen twee knopen $s$ en $q$ in een gewogen graaf te vinden, op voorwaarde dat de takken van de graaf enkel positieve gewichten hebben. Als bijgevolg van de uitvoering van dit algoritme worden ook alle kortste paden vanuit $p$ naar alle andere knopen berekend.

Je kan het algoritme implementeren als volgt. Eerst zullen we een paar variabelen moeten aanmaken

* Een permanente verzameling $P$: deze bevat alle knopen waarvan we al zeker weten dat we de kortste afstand ernaar hebben gevonden. 
* $T$: een verzameling tijdelijke knopen. Van deze knopen weten we nog niet zeker of we de kortste afstand ernaar gevonden hebben
* Voor elke knoop $v$ houden we een label $l(v)$ bij. Dit label bevat de tot nu toe gevonden afstand naar $v$

Dan voeren we het algoritme uit:

* Neem je startknoop $s$ en voeg deze toe aan $T$
* Vanaf hier herhalen
* Neem de knoop $q$ met de het kleinste label $l(q)$ uit $T$. Omdat dit het kleinste label van de knopen in $T$ is, weten we zeker dat dit een optimaal pad is. Steek $q$ dus in $P$, als deze er nog niet in zat.
* Voeg alle buren $b_1, \dots, b_n$ van $q$ toe aan $T$, en update hun labels als volgt $l(b_n) = l(q) + d(b_n, q)$, als deze afstand kleiner is dan het huidige label.
* Uiteindelijk loopt $T$ leeg en is je algoritme klaar

Als kleine optimalisatie kunnen we het algoritme vroegtijdig afbreken wanneer $q$ aan $T$ wordt toegevoegd.



Bewijs: //TODO

Het algoritme van Dijkstra heeft een tijdscomplexiteit van $O(p^2)$, met $p= \#V_G$ (het aantal knopen)



### Andere kortste-padalgoritmen

Hier een kleine opsomming:

* Het **algoritme van Moore** berekent een kortste-padboom van een knoop $s$ naar alle andere knopen in een **niet-gewogen** graaf, en kan uitgebreid worden voor niet-gewogen digrafen.
* Het **algoritme van Dijkstra** berekent een kortste-padboom van een knoop $s$ in een gewogen graaf naar alle andere knopen, maar mag alleen gebruikt worden als de graaf uitsluitend positieve gewichten bevat.
* Het **algoritme van Ford, Bellman en Moore** heeft hetzelfde doel als Dijkstra, maar negatieve gewichten zijn toegestaan.
* Als je alle kortste paden van en naar alle knopen wilt berekenen, is het **algoritme van Floyd** een betere aanpak dan de andere geziene algoritmen, om efficiëntieredenen.



### Begrippen

* De **excentriciteit** van een $v$ is de afstand van $v$ naar de knoop die het verst van $v$ gelegen is
* De **straal** van een gewogen graaf is de minimale excentriciteit van deze graaf
* De **diameter** is de maximale excentriciteit van een graaf



## Vlakke grafen

<img src="https://miro.medium.com/max/1400/1*xlFGI9wu3SmpHRZxG0ndsQ.png" alt="Graph Theory 101: Why all Non-Planar Graphs Contain K₅ or K₃,₃ | by Russell  Lim | Math Simplified | Medium" style="zoom:50%;" />

Een graaf $G$ is een **vlakke graaf** als je hem kan tekenen in een vlak, zonder dat de takken elkaar kruisen. Kennis over vlakke grafen is uitermate nuttig wij de constructie van wegen of spoorwegen, want je wil natuurlijk vaak kruisingen vermijden indien mogelijk.



//TODO sferische voorstelling (ik vond dit momenteel nog niet super belangrijk)



### Vlakke voorstelling van geconnecteerde grafen

* De gebieden, begrensd door de takken van de graaf, noemen we **interne gebieden**
* Het onbegrensd gebied buiten de graaf noemen we het **externe gebied**
* De takken die een gebied begrenzen, vormen samen een **maas (mesh)**. Er zijn dus ook interne en externe mazen. Het aantal mazen in een graaf is altijd gelijk aan het aantal gebieden, behalve bij een ringvormige graaf.

De tweede graaf hierboven bevat 3 interne gebieden en één extern gebied. Het aantal gebieden $g$ van de vlakke voorstelling van een geconnecteerde graaf kan berekend worden met:

* $g = q-p+2$, met $p$ het aantal knopen en $q$ het aantal takken
* //TODO bewijs



### Vlakheidstest

Hoe kunnen we weten of een graaf dan nu een vlakke graaf is? En als we dan weten dat hij vlak is, hoe vinden we dan zijn vlakke voorstelling? Find out in the next episode of martijnsamenvattingen.

Godverdomme nu dacht ik dat we een coole uitleg gingen krijgen, maar ik ging naar de volgende pagina in de cursus en werd begroet met de volgende boodschap: *De precieze werking van dit algoritme ... valt buiten het kader van deze cursus*

<img src="https://media.tenor.com/FznHbwHlar4AAAAd/my-disappointment.gif" alt="Day Ruined GIFs | Tenor" style="zoom:33%;" />



## Kleuren van grafen

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Petersen_graph_3-coloring.svg/1200px-Petersen_graph_3-coloring.svg.png" alt="Graph coloring - Wikipedia" style="zoom: 25%;" />

Een **knoopkleuring** (vertex coloring ... *de traumas van vorig semester komen weer boven*) van een graaf is is het toewijzen van een kleur aan elke knoop, waarbij twee buurknopen altijd een verschillende kleur hebben. Dit is bijvoorbeeld handig bij GSM-netwerken, waarbij aangrenzende masten geen overlappende frequenties mogen gebruiken.

We zijn natuurlijk meestal op zoek naar de optimale knoopkleuring, waarbij we de graaf kleuren met een **minimaal aantal kleuren**. Dit minimale aantal noemen we het **chromatisch getal**.



### Onder- en bovengrens chromatisch getal

We kunnen met onze big brains gemakkelijk afleiden dat we een knoop $v$ met met graad $\delta(v)$ en zijn buren altijd verschillend kunnen kleuren als we over $\delta(v) + 1$ kleuren beschikken. We weten dus dat het chromatisch getal ten hoogste één groter zal zijn dan de hoogste knoopgraad:
$$
\chi(G) \leq 1 + \delta_\text{max}
$$

* Een **kliek **is een complete subgraaf van $G$, die geen deel uitmaakt van een grotere complete subgraaf. Dit komt overeen met een groep mensen waarbij iedereen iedereen kent.
* Het aantal knopen in de grootste kliek in een graaf noemt met het **kliekgetal** $\omega(G)$

Alle knopen in een kliek moeten een verschillende kleur krijgen. Zo vormt het kliekgetal dus een ondergrens voor ons kleurenprobleem.
$$
\omega(G) \leq \chi(G)
$$


### Oplossingsmethode (sequentiële kleuring)

Dit algoritme is een heuristiek, en vindt niet altijd de optimale oplossing. Het is wel een gemakkelijke en efficiënte manier om dit probleem aan te pakken.

* Overloop sequentieel alle knopen $v_1, v_2, \dots ,v_n$
* Ken aan elke knoop $v$ het laagst mogelijke kleurnummer toe. Dit is dus de laagste kleur in je lijst die niet door één van de buurknopen van $v$ wordt gebruikt.



### Het vierkleurenprobleem

Is het mogelijk om met vier kleuren elke mogelijke landkaart in te kleuren zodat buurlanden nooit dezelfde kleur krijgen?

Als we van elk land een knoop maken, met een tak naar elk aangrenzend land, kan je dit probleem omvormen tot een grafenprobleem. Het antwoord op de vraag is 'Ja'. 



### Takkleuringen

Hetzelfde probleem, maar dit keer gaan we takken kleuren, en mogen takken aan dezelfde knoop niet dezelfde kleur krijgen. Je kan dit probleem eenvoudig omvormen naar een knoopkleuringsprobleem.

* Maak van elke tak een knoop
* Verbind alle knopen in de nieuwe graaf waarbij de overeenkomstige takken in de vorige graaf in dezelfde knoop uitkwamen.



## Koppelingen en toewijzingen

### Koppelingen

We hebben een graaf $G$. Een **koppel** zijn simpelweg twee gekozen knopen die met elkaar verbonden zijn. Een deelverzameling $K$ van $E_G$ (de takken van $G$) is een **koppeling** van $G$ als geen takken uit $K$ een knoop gemeenschappelijk hebben. Eén object kan dus niet tegelijkertijd tot meerdere koppels behoren. Het maximale aantal koppels die je kan maken in een graaf noem je de **maximumkoppeling**. Hoe vinden we deze? 

Eerst moeten we weten wat een **K-alternerend pad** nu precies is. Dit is een pad van een graaf met een koppeling $K$ waarvan de takken afwisselend wel en niet tot $K$ behoren. 

* Een koppeling $K$ in $G$ is een maximumkoppeling $\iff$ er bestaat geen groter K-alternerend pad

Een **vergrotend K-alternerend pad** is hetzelfde, maar de begin- en eindknoop vormen geen koppel. 

//TODO bewijs



### Toewijzingen

Een **tweedelige graaf** is een graaf waarvan je de knopenverzameling in twee verzamelingen $V_1$ en $V_2$ kan verdelen op zodanige wijze dat elke tak een knoop van $V_1$ met $V_2$ verbindt. De afbeelding maakt het iets duidelijker. De nummertjes en lettertje zijn niet echt van belang, maar dit is het mooiste plaatje dat ik vond op google. (want onze prof zet om de één of andere vage reden zijn slides niet online)

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Simple_bipartite_graph%3B_two_layers.svg/1200px-Simple_bipartite_graph%3B_two_layers.svg.png" alt="Bipartite graph - Wikipedia" style="zoom:33%;" />

Een koppeling in een tweedelige graaf noemt men een **toewijzing**. Dit wordt iets duidelijker als de de twee delen van de graaf ziet als objecten. Zo kunnen in de graaf hierboven de rode knopen werknemers voorstellen, en de blauwe pisbakken. Nu kunnen we pisbakken toewijzen aan elke werknemer.

In het geval van zo'n graaf is het makkelijker om een vergrotend K-alternerend pad te vinden. Dit doe je zo:

* Neem een niet-gekoppelde knoop $v$
* Construeer vanuit $v$ een boom met alle K-alternerende paden vanuit deze knoop
  * Dit kan met BFS of DFS
  * Je mag stoppen wanneer je een niet-gekoppelde knoop verschillend van je startknoop tegenkomt. Of als je je boom niet meer kan uitbreiden en dus alle uiteinden gekoppelde knopen zijn.
* Als je resulterende boom een uiteinde bevat dat niet gekoppeld is, hebben we een vergrotend K-alternerend pad gevonden. Is dit niet het geval, dan bestaat er geen vergrotend K-alternerend pad met $v$ als eindknoop.
* Herhaal deze procedure voor alle niet-gekoppelde knopen. Als we geen vergrotende K-alternerende paden vinden, dan weten we dat we al over een maximumkoppeling beschikken.



# Grafen deel 2

## Verband tussen 4 boom-constructie algoritmen

Dit deel van het boek is echt waardeloos.





# Strings

## Gegevensstructuren voor Strings



### Digitale zoekbomen

<img src="img/algo2/image-20221121151127248.png" alt="image-20221121151127248" style="zoom:50%;" />

Een **digitale zoekboom** is een gegevensstructuur die je kan gebruiken om sleutels op te slaan. Hier zijn sleutels dan strings van sleutelelementen (bv. een bitstring) en komen altijd uit een eindig alfabet. De **sleutels** bevinden zich in de **knopen**.

| <img src="img/algo2/image-20221121152141740.png" alt="image-20221121152141740" style="zoom: 67%;" /> | <img src="img/algo2/image-20221121152159448.png" alt="image-20221121152159448" style="zoom:50%;" /> |
| ------------------------------------------------------------ | ------------------------------------------------------------ |

Het voorbeeld hierboven maakt het wat duidelijker. Als eerste wordt `A` toegevoegd en komt dus in de wortelknoop. Wanneer we `S` toevoegen, wordt de 0-de bit van `S` beschouwd, deze is 1 en we moeten dus naar rechts. Daar was (toen) nog een vrije plaats, dus hebben we `S` daar neergezet. Hetzelfde voor `E`, maar dan naar links. Je moet dus in elke stap de plek in de sleutel beschouwen die overeenkomt met hoe diep je in de boom zit, en dan ook elke keer kijken of die sleutel overeenkomt met de sleutel van de knoop waar je je bevindt. 



### Binaire tries

<img src="img/algo2/image-20221121154349752.png" alt="image-20221121154349752" style="zoom:50%;" />

Het verschil tussen een **binaire trie** en een digitale zoekboom is dat bij een binaire trie de **sleutels** enkel worden opgeslagen **in de bladeren**. Omdat er in de tussenliggende knopen geen sleutels zitten, moet je in totaal minder sleutelvergelijkingen doen.

Het basisprincipe lijkt op dat van digitale zoekbomen, bij 0 ga je naar links, en bij 1 naar rechts. Je sleutel is **gevonden** als je in een **bladknoop** komt. Als je vast komt te zitten, zit de sleutel niet in de trie.

<img src="img/algo2/image-20221121154654860.png" alt="image-20221121154654860" style="zoom:50%; float:left"  /><img src="img/algo2/image-20221121154847929.png" alt="image-20221121154847929" style="zoom:50%; float:right;" />

Je kan deze gegevensstructuur lichtelijk optimaliseren door overbodige tussenliggende knopen weg te knippen, en enkel een nieuwe splitsing toe te voegen als dit echt nodig is. Dit zie je in de bovenstaande plaatjes. Dit spaart geheugenruimte, maar maakt toevoegen en verwijderen wat complexer. 



### Patriciatries

<img src="img/algo2/image-20221121155520419.png" alt="image-20221121155520419" style="zoom:50%;" />

**Patriciatries** trachten de hierboven aangekaarte problemen te verhelpen. Blijkbaar staat Patricia voor 'Practical Algorithm to Retrieve Information Coded in Alphanumeric'. Cool.

* Elke knoop heeft een getal dat aangeeft met welke bit er vergeleken wordt. Deze index mag naarmate je dieper in de boom gaat nooit kleiner worden.
* Pointers kunnen naar boven wijzen. 
  * Tijdens het zoeken doen we geen sleutelvergelijkingen, pas als een pointer naar boven wordt gevolgd, vergelijken we de te zoeken sleutel met een knoop.

De boom hierboven is het resultaat van het toevoegen van de volgende sleutels:

<img src="img/algo2/image-20221121161342988.png" alt="image-20221121161342988" style="zoom: 67%;" />

Zoals je ziet, is er bijvoorbeeld bij `R` een pointer naar boven. Als de 0de bit 1 is en de 4de ook, is de enige optie `S`. Ik snap wel hoe dit werkt, maar niet hoe je deze boom algoritmisch zou moeten construeren. De slides schieten mij hier tekort. //TODO



### Meerwegstries

<img src="img/algo2/image-20221121161906001.png" alt="image-20221121161906001" style="zoom:50%;" />

Een **meerwegstrie** is een uitbreiding van een gewone trie. Er zijn gewoon meer keuzes per niveau. Dit kan handig zijn, maar je moet wel op een paar dingen letten:

* Als je knopen veel nullpointers bevatten, kan je een gelinkte lijst gebruiken om de kinderen in bij te houden.
* Als we te veel interne knopen hebben, kunnen we symbolen van het alfabet samennemen.



### Ternaire zoekbomen

<img src="img/algo2/image-20221121162227371.png" alt="image-20221121162227371" style="zoom:50%;" />

Bij een **ternaire zoekboom** heeft elke knoop drie deelbomen. Deze splitsen de zoekruimte op in kleiner, gelijk aan of groter dan de voordien bezochte knoop. 

* Belangrijk om te weten is dat als je verder gaat in de **linkse of rechtse** deelboom, je opnieuw **hetzelfde element** van de sleutel gebruikt. 
* Ga je verder in de **middelste** deelboom, gebruik je het **volgende** **element** van de sleutel. 





## Codes

Een **code** is een manier om data op te slaan in een bepaald formaat. Een voorbeeld van een code is ASCII. Er zijn verschillende soorten codes:

* Variabele lengte code
  * Niet elke letter krijgt evenveel bits
  * Dit maakt willekeurige toegang moeilijk
* Prefixcode
  * Geen enkel codewoord is de prefix van een ander codewoord
* Universele code
  * Kan je gebruiken, onafhankelijk van de brontekst die je wilt coderen

We gaan wat verder in op universele codes.



### Elias' Gammacode 

<img src="img/algo2/image-20221121163607074.png" alt="image-20221121163607074" style="zoom:50%;" />

De Elias' $\Gamma$-code wordt volgens Wikipedia gebruikt om getallen te coderen waarvan de bovengrens onbekend is. Door een bepaald aantal 0-bits toe te voegen aan de binaire codering van een getal, kan je weten hoeveel bits je nog moet lezen om het getal correct te lezen.

Ik vind het niet goed uitgelegd in de slides. Het aantal nullen vooraan stellen eigenlijk gewoon de grootte-orde van het te lezen getal voor met een macht van 2. Als je 3 nullen leest, is de 1 die erop volgt gelijk aan $2^3$. 

Om te coderen zet je dus gewoon bij een getal van $n$ bits, $n-1$ nullen vooraan.



### Elias' Deltacode

<img src="img/algo2/image-20221121164634223.png" alt="image-20221121164634223" style="zoom:50%;" />

De Elias' $\Delta$-code steunt eigenlijk verder op het vorige. 

* Neem de binaire representatie van je getal
* Het eerste getal is altijd een 1, deze kan je weglaten
* In plaats van de $n-1$ nullen vooraan te zetten, zet je nu de voorstelling van het getal $n-1$ in gammacode voor je getal
  * Dit is gewoon een kortere manier om $n$ aan te geven

Dan neem je uiteindelijk een klein beetje minder plaats in. 



### Fibonnaci-code

<img src="img/algo2/image-20221121165125574.png" alt="image-20221121165125574" style="zoom:50%;" />

We kunnen elk natuurlijk getal voorstellen als een som van niet-opeenvolgende fibonaccigetallen. De i-de bit in de codering komt dan overeen met het i-de fibonaccigetal. Dit is vrij simpel als je kijkt naar een voorbeeld:

* $0*1+0*2+1*3+0*5+1*8+0*13+0*21+1*34=45$

Op het einde wordt telkens een 1 toegevoegd, want we hebben nooit twee opeenvolgende fibonnacigetallen nodig, dus weten we dat je code hier stopt.



### Huffmancode

Een voorbeeld van een prefixcode met variabele lengte is de **Huffmancode**. Om een bericht met deze code te encoderen moeten we de volgende stappen ondernemen:

* //TODO



### Compressie



### Huffman



## Talen, grammatica's en automaten

