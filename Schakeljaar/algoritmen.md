# Algoritmen

* Theorie: 60%
* Praktijk:
  * Test 30 maart: 20%
  * Test 23 mei: 20%
* Minstens 8/20 op zowel theorie als praktijk



# ------------ Theorie ------------



# 1 - Efficiënte zoekbomen

## Evenwichtige zoekbomen



We willen ervoor zorgen dat bomen niet uit balans geraken:

* Red-black-tree: boom altijd herbalanceren
* Splay trees: maakt reeks opeenvolgende operaties efficient
* Treaps: tree die ook een heap is (gaan we niet verder op in)



## Red-black tree

<img src="img/image-20220216092100188.png" alt="image-20220216092100188" style="zoom:50%;" />

Binaire zoekboom, waarvoor geldt:

1. Elke knoop is rood of zwart
2. De wortel is zwart
3. Elke virtuele knoop (NIL) is zwart
4. Elke rode knoop heeft 2 zwarte kinderen
5. Elk pad van een knoop naar een bladnode in zijn deelboom bevat eenzelfde aantal zwarte knopen

We definiëren het begrip **zwarte hoogte** als het aantal zwarte knopen op het pad naar een bladnode. 

We willen bewijzen dat een red-black tree met wortel $x$ ten minste $2^{ZH(x)} - 1$ interne knopen bevat (met $ZH$ de zwarte hoogte)

<img src="img/image-20220216092535478.png" alt="image-20220216092535478" style="zoom:50%;" />

<img src="img/image-20220216092747047.png" alt="image-20220216092747047" style="zoom:50%;" />



### Zoeken

Zelfde als bij BST, we houden geen rekening met de kleur, dus $O(\log n)$



### Toevoegen

We gaan dus altijd toevoegen als rode knoop. Omdat we dan de zwarte hoogte van de boom niet super hard verkloten. We moeten dan gaan **roteren** om de boom terug geldig te krijgen.

<img src="img/image-20220404153621423.png" alt="image-20220404153621423" style="zoom:50%;" />

We roteren het kind naar bover zijn ouder, de deelboom van het kind wordt de deelboom van de voormalige ouder. De kost van één rotatie is $O(1)$. Om de boom te fixen kunnen we ook **recoloren**. We moeten dit doen wanneer een rode knoop rode kinderen heeft na een toevoegoperatie (double red).

// TODO verschillende gevallen



### Verwijderen

//TODO



# 2 - Meerdimensionale gegevensstructuren

Vaak hebben we nood aan meerdimensionale gegevens. Dit zijn gegevens die meer dan één sleutel bezitten. We modelleren deze gegevens typisch als een meerdimensionaal geometrisch probleem.



## Projectie

<img src="img/image-20220404155056219.png" alt="image-20220404155056219" style="zoom:50%;" />

We houden per dimensie een gegevensstructuur bij waarin de punten gerangschikt zitten volgens deze dimensie. Willen we dan een range van gegevens opzoeken, stellen we dit voor als een hyperrechthoek (in de tekening een balk, in 2 dimensies zou het een gewone rechthoek zijn). We zoeken dan per dimensie alle gegevens die binnen de overeenkomstige zijde van de hyperrechthoek vallen. Dan overlopen we sequentieel de kleinste verzameling om te kijken welke punten binnen onze range zitten. 

Als de punten gelijkmatig verdeeld zijn kunnen we opteren om slechts één dimensie in een gegevensstructuur te steken. Is dit niet het geval, zullen we toch voor elke dimensie een gegevensstructuur aan moeten maken.

//todo performantie? op zich is dit deel niet super belangrijk



## Rasterstructuur

<img src="img/image-20220404160102207.png" alt="image-20220404160102207" style="zoom:50%;" />

We kunnen onze verdelen in vakjes met behulp van een raster. We houden in elk vakje een gelinkte lijst bij van alle punten. Als we dan een range van punten willen vinden in een bepaalde zoekhyperrechthoek, vragen we alle gelinkte lijsten op van de vakjes die overlappen met het zoekgebied. Dan moeten we wel nog elk van die lijsten overlopen om de punten binnen het zoekgebied te vinden. 

Je kan waarschijnlijk wel al ruiken dat een gegevensstructuur van deze aard enkel goed werkt indien de punten die hij bevat ietwat uniform verdeeld zijn. In het slechtste geval kunnen alle punten samengeklit in één rooster zitten, wat ook niet echt bevorderlijk zal werken voor de performantie.

De volgende gegevensstructuren trachtten deze problemen op te lossen.



## Quadtrees



### Point Quadtrees

<img src="img/image-20220404172412643.png" alt="image-20220404172412643" style="zoom: 33%;" />

<img src="img/image-20220404172458381.png" alt="image-20220404172458381" style="zoom:50%;" />



Elke toegevoegde knoop verdeelt het zoekgebied in **vier** (niet noodzakelijk gelijke) **rechthoekige gebieden**. Om te zoeken vertrekken we vanaf de wortel. Dan vergelijken we telkens ons zoekpunt met de vier kinderen en dalen af indien nodig. Als we dan een leeg gebied tegenkomen is het zoekpunt niet aanwezig in de boom.

De vorm van een Point Quadtree is afhankelijk van de toevoegvolgorde. Als elke toevoegvolgorde even waarschijnlijk is, zijn zoeken en toevoegen gemiddeld $O(\log n)$, en in het slechtste geval $O(n)$.

Als de punten op voorhand gekend zijn kan je ervoor zorgen dat het evenwicht in de boom veel beter ligt. Als we alle punten rangschikken op x (bij gelijke x op y), vallen alle punten voor de mediaan in twee deelbomen. De punten erachter vallen dan in de andere twee deelbomen. Zo zal een deelboom nooit meer dan de helft van de punten van zijn ouder bevatten. Deze operatie is wel $O(n\log n)$

Zoek je meerdere punten, doe dit dan recursief. Test bij een knoop of zijn punt in de zoekrechthoek ligt en ga vervolgens verder in de deelbomen die de rechthoek overlappen.





### Point Region Quadtrees

<img src="img/image-20220404173843794.png" alt="image-20220404173843794" style="zoom:50%;" />

Het principe van een PR Quadtree is gelijkaardig aan dat van een gewone Quadtree, met het verschil dat elk gebied altijd in vier gelijke gebieden gesplitst zal worden. Als er een punt wordt toegevoegd zullen we dus telkens het gebied moeten splitsen totdat elk punt zijn eigen vakje heeft. Dit heeft als gevolg dat de structuur, evenals de hoogte van de boom onafhankelijk zijn van de toevoegvolgorde. 



#### Hoogte

De hoogte van een PR Quadtree wordt bepaald door de kleinste afstand tussen twee knopen, aangezien er telkens dieper gesplitst zal moeten worden totdat elk punt zijn eigen vakje heeft.

<img src="img/image-20220404174847533.png" alt="image-20220404174847533" style="float: left; zoom: 33%;" />  



In een gebied met zijde $z$, is de maximale afstand tussen twee punten in een gebied op diepte $d$ gelijk aan $\frac{z \sqrt{2}}{2^d}$











#### Range queries

<img src="img/image-20220404175153842.png" alt="image-20220404175153842" style="zoom:50%;" />

Om een range query te implementeren bij een PR-quadtree, vertrek je vanaf de bovenste knoop. Als de zoekrechthoek overlapt met de cel van de knoop, ga je recursief dieper. Als dit niet het geval is geef je een leeg resultaat terug. Bij een bladknoop kijk je of het individuele punt overlapt met de zoekrechthoek. Als dit het geval is geef je het punt terug.



#### Nadelen

Het grote nadeel aan beide eerder genoemde Quadtrees is dat bij meer dimensies, de hoeveelheid gebruikte pointers exponentieel zal toenemen. Elke node heeft voor $k$ dimensies namelijk $2^k$ pointers. 







### K-D Trees

<img src="img/image-20220404180016275.png" alt="image-20220404180016275" style="zoom:50%;" />

K-D Trees trachten de vertakkingsgraad te beperken door op elk niveau te splitsen volgens één dimensie. Bij het afdalen in de boom zullen we dan typisch alterneren tussen de verschillende dimensies.



#### Range search query

<img src="img/image-20220407111118711.png" alt="image-20220407111118711" style="zoom:33%;" />

Je gaat weer recursief moeten werken per knoop. Als het punt van deze knoop binnen de zoekrechthoek valt, voeg je hem toe aan het resultaat. Als de zoekrechthoek (gedeeltelijk) overlapt met de cel van de knoop, ga je recursief dieper. Is dit niet het geval,  geef je een leeg resultaat terug.



#### Nearest Neighbor

//TODO



# 3 - Analyse van iteratieve algoritmen

## Orde van toename

$$
n!>> 2^n >> n^{1+\alpha} >> n \log n  >> n^\epsilon >> \log n >> \log \log n >> C
$$



## Lussen

**Enkele lus**

```c++
int functie (vector<int>& v){
	int result = 0;
	int n = v.size();
	for (int i = 0; i < n; i++){
		result += (i+1)*v[i];
	}
	return result;
}
```

We loopen $n$ keer. Onze basisoperatie wordt dus $T(n) = n$ keer uitgevoerd.



**Geneste lus**

```c++
int functie(vector<int>& v){
  int result = 0;
    int n = v.size();
    for (int i = 0; i < n; i++){	
      for (int j = 0; j < n; j++){
      	result += v[j];
      }
    }
  return result;
}
```

Deze code doet eigenlijk het zelfde als het vorige blokje code, maar minder efficiënt. We zetten onze code om in een sommatie:
$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{n-1}1
$$
Na wat coole wiskunde krijgen we:
$$
T(n) = \frac{n^2+n}{2}
$$
**Logaritmische uitvoeringstijd**

Als je je teller bijvoorbeeld verdubbeld in plaats van incrementeert, krijg je een logaritmische uitvoeringstijd:

```c++
int functie(vector<int>& v){
  int result = 0;
    int n = v.size();
    for (int i = 0; i <= n; i*=2){	
      for (int j = 0; j < n; j++){
      	result += v[j];
      }
    }
  return result;
}
```

Per iteratie van de buitenste lus, wordt de binnenste lus $n$ keer uitgevoerd. De buitenste lus wordt $K = \lfloor \log n \rfloor$ keer uitgevoerd.
$$
\begin{align}
T(n) &= \sum_{i=1}^{K} \sum_{j=0}^{n-1} 1 \\
&= \sum_{i=1}^{K}n \\ 

&= nK \\
&= n\lfloor \log n \rfloor

\end{align}
$$
De uitvoeringstijd bedraagt $\Theta(n\log n)$.



## Sorteeralgoritmes

### Selection sort

<img src="img/Selection-sort-0.png" alt="Selection Sort (With Code in Python/C++/Java/C)" style="zoom:33%;" />

* Neem het kleinste element van de lijst en zet het vooraan
* Neem het kleinste element van de lijst behalve het eerste element en zet dat op de tweede plek
* Herhaal
* Winst (eigenlijk niet want het is $O(n^2)$)

```c++
void selectionSort(int arr[], int n)
{
    int i, j, min_idx;
 
    // One by one move boundary of
    // unsorted subarray
    for (i = 0; i < n-1; i++)
    {
        // Find the minimum element in
        // unsorted array
        min_idx = i;
        for (j = i+1; j < n; j++)
        if (arr[j] < arr[min_idx])
            min_idx = j;
 
        // Swap the found minimum element
        // with the first element
        swap(&arr[min_idx], &arr[i]);
    }
}
```



### Insertion sort

![Recursive Insertion Sort - GeeksforGeeks](img/insertion_sort-recursion.png)

Je gaat eigenlijk de rij element per element af, het element dat je tegenkomt blijf je naar links schuiven zolang het kleiner is dan het element aan zijn linkerkant. Je krijgt dus in elke stap links van het groene blokje en telkens groter wordende gesorteerde deelrij.

```c++
void insertionSort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;
 
        // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their
        // current position
        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
```

Belangrijk om te weten bij insertion sort, is dat het vrij goed werkt op een tabel die al redelijk goed in volgorde staat. 

#### Efficiëntie

* Buitenste lus wordt $n-1$ keer uitgevoerd.
* Het aantal iteraties van de binnenste lus hangt af van de invoer. We gaan dus onderscheid maken tussen het best, slechtste en gemiddelde geval.

Als we twee elementen $a[i] $ en $ a[j]$ uit de tabel nemen, met $i<j$. Dan vormen deze twee een **inversie** als $a[i] > a[j]$. Een inversie is dus simpelweg **een paar elementen dat op de verkeerde volgorde staat**. Om een beter zicht te krijgen op de performantie van ons algoritme, gaan we het aantal inversies tellen. Afhankelijk van dit aantal, kunnen we een onderscheid maken tussen drie gevallen.

**Slechtste geval**

De rij staat achterstevoren, elk paar elementen vormt een inversie. Dit zijn er $n(n-1)/2$, en is dus het aantal sleutelvergelijkingen. We komen op $\Theta(n^2)$.

**Beste geval**

De tabel staat in volgorde en er zijn geen inversies. We moeten de tabel dus maar één keer $(n-1)$ overlopen: 

**Gemiddeld geval**

We veronderstellen dat elke permutatie van de elementen even waarschijnlijk is. Dan bekomen we $n(n-1)/4$. Dit is nog steeds $\Theta(n^2)$, maar dan met een verborgen factor van $0.5$.



Goed, dit is eigenlijk niet zo belangrijk. Wat insertion sort zo nuttig maakt, is dat zolang het aantal inversies $O(n)$ is. Onze uitvoertijd $\Theta(n)$ zal zijn. Dit is weliswaar alleen het geval wanneer onze rij al bijna helemaal gesorteerd is. We gebruiken insertion sort dus vaak in de laatste fase van efficiëntere algoritmen.



#### Sentinel

Een andere manier om insertion sort een klein beetje sneller is door een **sentinel** (poortwachter) te selecteren. Dit is het kleinste element van de tabel. Door dit element al direct vooraan te zetten, kunnen we de conditie $j>= 0$ uit onze while-lus weghalen. Pas wel op, want als je bijvoorbeeld veel kleine rijen moet sorteren, kan dit juist een negatief effect hebben.







## Stappenplan

  1. Definieer een maat voor de invoergrootte
 2. Definieer je kostenmodel: welke basisoperaties?
 3. Bepaal of uitvoeringstijd afhankelijk is van waarde van de invoer
 4. Stel een sommatie op die uitdrukt hoe vaak de basisoperatie wordt uitgevoerd
 5. Werk deze sommatie uit tot een gesloten uitdrukking, of schat af in asymptotische notatie



# 4 - Analyse van recursieve algoritmen

## Iteratieve methode

```c++
int factorial(int n){
  // basisgeval
  if (n == 0) return 1; 
  //recursie
  else return n*factorial(n–1);
}
```

Het aantal vermenigvuldigingen $T(n)$ is gelijk aan het aantal vermenigvuldigingen voor het berekenen van $(n-1)!$ plus één. We krijgen de volgende recurrente betrekking:
$$
T(n) = \begin{cases}
T(n-1) +1  &\text{ als } n \geq 0 \\
0 &\text{ als } n=0



\end{cases}
$$
We gebruiken **backwards substitution** om deze om te vormen naar een gesloten uitdrukking:
$$
\begin{align}
T(n) &= T(n-1) + 1 \\
&= (T(n-2)+1)+1 = T(n-2)+2 \\
&= T(n-3) + 3 \\
&= \dots \\
&= T(0 +n) \\
&= n
\end{align}
$$
Onze `factorial()` is dus $\Theta(n)$. In dit geval gaan we dus vanaf $T(n)$ omlaag. Je kan ook omhoog gaan. Dit heet dan **forwards substitution**.



## Recursieboom

Beschouw het volgende algoritme:

```c++
int somBinaireRecursie (const vector<T>&v, int start, int stop){
   if (start >= stop) //basisgeval: lege rij
      return 0;
   if (start == (stop – 1)) //basisgeval: 1 element
      return v[start];
   int mid =start +( stop-start)/2;
   return somBinaireRecursie(v, start, mid) + somBinaireRecursie(v, mid, stop );
}
```

We zullen hiervan is een recursieboom maken. We beginnen met het opstellen van een betrekking voor de uitvoeringstijd met als basisoperatie de optelling op de laatste lijn:
$$
T(n) = \begin{cases}
T(\lfloor \frac n 2 \rfloor) + T(\lceil \frac n 2 \rceil) + 1  &\text{ als } n \geq 2 \\
0 &\text{ als } n=0



\end{cases}
$$
We negeren de floor en ceil en verkrijgen:
$$
T(n) = \begin{cases}
2T( \frac n 2 ) + 1  &\text{ als } n \geq 2 \\
0 &\text{ als } n=0

\end{cases}
$$
Nu kunnen we een boom maken. 

<img src="img/image-20220513183754169.png" alt="image-20220513183754169" style="zoom:50%;" />

We moeten we wel nog weten hoe diep hij is. Op elk niveau verdubbelt het aantal elementen in de boom. Als we dus $n$ nemen en hem $h$ keer delen, zullen we een getal tussen $1$ en $2$ krijgen:
$$
1 \leq \frac{n}{2^h} < 2
$$
Met $h$ de hoogte van de boom en $n$ het aantal elementen. We kunnen dit omvormen naar:
$$
h \leq \log n < h+1 \\
h = \lfloor \log n \rfloor
$$
In het slechtste geval is de boom volledig gevuld en kunnen we dus stellen dat $h= \log n$. Onze totale uitvoeringstijd is de som van de uitvoeringstijd in alle knopen.
$$
\begin{align}
T(n) &= 2^0 + 2^1 + 2^2 + \dots + 2^{\log n -1}-1 \\
&= 2^{\log n } -1\\
&= n-1\\
&= O(n)
\end{align}
$$

## Master theorema

Oké, we gaan dit even drastisch versimpelen. Het kadertje hieronder vertelt ons eigenlijk hoe het werk in onze boom verdeeld wordt. Je moet de term $f(n)$ zien als het werk dat in de huidige knoop wordt gedaan en  $aT(n/b)$ zien als het werk dat gedelegeerd wordt naar de kindknopen. 

1. Onze $f(n)$ is klein dus er wordt veel werk naar onder gedelegeerd.
2. Het werk is gelijk verdeeld
3. $f(n)$ is groot en er wordt dus veel werk in de wortel gedaan.



<img src="img/image-20220501180337873.png" alt="image-20220501180337873" style="zoom:50%;" />

Als je dus een recurrente betrekking kan opstellen van je algoritme, kan je d.m.v. dit kadertje een afschatting maken voor de onder- en bovengrens van zijn tijdscomplexiteit.



## Afschattingen van recursiebetrekkingen

**Logaritmische afschatting**
$$
T(n) \leq T(\frac n 2) + c \xRightarrow{\quad} T \text{ is } O(\log n)
$$
**Machten van $n$**
$$
\begin{align}
T(n) \leq c + T(n-1) &\xRightarrow{\quad} T \text{ is } O(n) \\
T(n) \leq cn^\alpha + T(n-1) &\xRightarrow{\quad} T \text{ is } O(n^{\alpha+1}), \alpha > -1\\
T(n) \leq \frac 1 n + T(n-1) &\xRightarrow{\quad} T \text{ is } O(\log n)




\end{align}
$$
**Afschattingen met sommen**

//TODO



# 5 - Decrease-and-conquer

**Verminderen met een constante term**
$$
T(n) = T(n-c) +f(n) 
$$
**Verminderen met een constante factor**
$$
T(n) = T(\frac n b) + f(n)
$$
**Verminderen met een variabele factor**
$$
T(n) = T(\frac n {b_i})
$$

## Verminderen met een constante term

Als je insertion sort recursief implementeert doet hij precies dit.



## Verminderen met een constante factor

//TODO varianten op binair zoeken



## Verminderen met een variabele factor

### Quickselect

#### Pivot



# 6 - Divide-and-conquer en algemene sorteermethodes

## Divide-and-conquer

Als we een algoritme maken volgens het principe van divide-and-conquer, **verdelen** we het probleem in **meerdere onafhankelijke deelproblemen**. Deze zijn allemaal kleinere instanties van het originele probleem. Meestal wordt elk deelprobleem dan gedelegeerd door middel van een recursieve oproep, totdat het probleem zo klein is dat we bij het **basisgeval** terecht komen. We combineren dan de oplossingen van de deelproblemen tot een oplossing voor ons origineel probleem.

### Algoritme van Strassen

Niemand houdt van matrices. Strassen is een simp want zijn algoritme is nieteens goed volgens Simoens.

//TODO



## Algemene sorteermethodes

We beginnen dit hoofdstuk met enkele andere aspecten van sorteren waarmee we rekening willen houden:

* Geheugengebruik

  * We willen weten hoeveel extra geheugen een sorteermethode nodig heeft. Als de hoeveelheid extra geheugen niet afhankelijk is van het aantal elementen, spreken we van **ter plaatse** rangschikken.

* Stabiliteit

  * Als het de volgorde van gegevens met dezelfde sleutels niet verandert, noemen we ons algoritme **stabiel**. Als we bijvoorbeeld een lijst van personen die op naam gesorteerd staat, op leeftijd gaan sorteren, is ons algoritme stabiel als na deze operatie de personen per leeftijd nog steeds alfabetisch gerangschikt staan.

  



## Shellsort

<img src="img/image-20220515164615865.png" alt="image-20220515164615865" style="zoom:50%;" />

Shellsort is simpel. We gaan een rij $k$-sorteren. Dit betekent dat we ervoor zorgen dat als we de rij afgaan in stappen van $k$ groot, de elementen die we tegenkomen in volgorde staan. Dit doen we met insertion sort. Nu nemen we dus telkens een kleinere $k$ totdat we aan $k=1$ zitten. Dit is dan eigenlijk gewone insertion sort, maar omdat de rij al grotendeels gesorteerd is, is het aantal inversies klein.

Shellsort rangschikt **ter plaatse**, maar is **niet stabiel**. Dit komt door het rangschikken van de verschillende deelreeksen. De complexiteit hangt af van de gekozen incrementreeks (dus welke $k$'tjes je gaat kiezen), maar de theoretisch beste reeks is nog niet gevonden. 



## Heapsort

Neem bijvoorbeeld de reeks: `5 2 7 9 4 7`

<img src="img/image-20220515165807977.png" alt="image-20220515165807977" style="zoom:50%;" />

Wat als we nu van onze data een heap maken en hier gewoon telkens het grootste element uit halen? Dat is Heapsort. Een rij omvormen in een heap kost $O(n)$. We moeten dan wel telkens de heapvoorwaarde herstellen. Dit kost in totaal $O(n\log n)$. Dit is dan ook de uitvoeringstijd voor het algoritme. Het fijne aan Heapsort is dat de uitvoeringstijd heel consistent is, het gemiddelde geval wijkt nauwelijks af van het slechtste geval. Het algoritme sorteert **ter plaatse**, maar is spijtig genoeg **niet stabiel** omdat het opbouwen en herschikken van de heap de volgorde van gelijke elementen kan verstoren.



## Mergesort

| Voor                                                        | Na                                                          |
| ----------------------------------------------------------- | ----------------------------------------------------------- |
| ![image-20220515170913069](img/image-20220515170913069.png) | ![image-20220515170926739](img/image-20220515170926739.png) |

Mergesort is een perfect voorbeeld van divide-and-conquer. We verdelen telkens de tabel in twee helften en sorteren elke helft apart. Op het laagste niveau bevat elke deeltabel maar één element, en is dus al gesorteerd. We moeten dus enkel weten hoe we twee reeds gesorteerde rijen moeten samenvoegen, vandaar de naam mergesort.

Samenvoegen van twee gerangschikte tabellen kan heel gemakkelijk. Je vergelijkt van beide tabellen het eerste element en je neemt telkens de kleinste. Hiervoor heb je dus wel extra geheugen nodig, want je moet dat element wel ergens kunnen steken. Kopieer dus één van de twee deeltabellen naar een hulptabel. Als we bij elke samenvoeging bij de linkse deeltabel beginnen, behouden we de volgorde van gelijke sleutels en is het algoritme bijgevolg **stabiel**. Door het extra geheugengebruik rangschikt het wel **niet ter plaatse**.

**Efficientie**
$$
\begin{cases}
2T(\frac n 2) + cn \quad &\text{ if } n>1
\\ 0 \quad &\text{ if } n = 0,1
\end{cases}
$$
 Elke recursieve oproep splitst de rij in twee. Om deze twee samen te voegen hebben we in het slechtste geval $n-1$ sleutelvergelijkingen nodig. In het beste geval maar half zo veel. We schrijven dus gewoon $cn$ met $c$ een onbekende constante. We kunnen op deze recursieve betrekking het mastertheorema toepassen en bekomen:
$$
T(n) = \Theta(\log n \cdot n^{\log_b a}) = \Theta(n\log n)\\
\text{ want } \log_b a = \log _2 2 = 1
$$
**Bottom-up implementatie**

<img src="img/image-20220515181413265.png" alt="image-20220515181413265" style="zoom:50%;" />

Je kan mergesort nog een beetje optimaliseren door in plaats van recursief te dalen, gewoon direct te beginnen bij deelrijen met lengte 1. Deze ga je dan stap voor stap mergen tot grotere rijen. Zo vermijd je de overheid van recursieve oproepen. De efficiëntie is nog steeds $\Theta(n\log n)$.

**Optimalisaties**

Als je een retard beta cuck bent maak je voor elke merge operatie een nieuwe hulptabel aan. Als je een alpha chad bent weet je dat je eigenlijk maar één extra tabel met grootte $n$ moet aanmaken voor mergesort.

<img src="img/image-20220515182530501.png" alt="image-20220515182530501" style="zoom:50%;" />

Je gaat nu gewoon de deelrijen (lengte 2 in het voorbeeld) in de hoofdtabel mergen in de hulptabel waardoor je hem overschrijft. In de volgende stap gebruik je de hulptabel als nieuwe hoofdtabel.

<img src="img/image-20220515182836618.png" alt="image-20220515182836618" style="zoom:50%;" />

Je kan ook nog een kleine optimalisatie doen door te starten met deeltabellen groter dan één element, en deze al te sorteren met insertion sort. 



## Quicksort

![A sort of quick guide to quicksort and Hoare's partitioning scheme in  Javascript | by Mark Sauer-Utley | ITNEXT](img/1*QlYf6-SE1Eq0_V-vKm1vtg.gif)

Om Quicksort even kort samen te vatten zal ik even beginnen met een oversimplificatie, zonder optimalisaties. 

* Neem het eerste element (we noemen dit de pivot)
* Zet alle elementen kleiner dan dat element links ervan
* Zet alle elementen groter dan dat element rechts ervan
* Ga recursief verder in het linkse en rechtse deel 
* Herhaal tot je aan een deelrij van één element komt. Nu is je hele rij gesorteerd

Wat moeten we nu doen om ervoor te zorgen dat de elementen kleiner dan de pivot links staat? En zodat de grotere elementen rechts staan? We hebben in één van de vorige hoofdstukken al Lomuto partitionering besproken. Dit is zeker een mogelijkheid, maar er bestaat een betere methode.



### Partitiemethode van Hoare

<img src="img/image-20220515185242122.png" alt="image-20220515185242122" style="zoom: 33%;" />

We nemen weer ter illustratie het eerste element van de rij als pivot. 

* Laat $i$ en $j$ overeenkomen met de indices van het eerste en het laatste element.
* Schuif $i$ naar rechts tot je een element groter dan de pivot tegenkomt
* Schuif $j$ naar links tot je een element kleiner dan de pivot tegenkomt
* Swap nu de elementen op plaats $i$ en $j$
* Ga verder totdat $i$ en $j$ elkaar kruisen

### Quicksort

Als we deze partitionering nu telkens opnieuw uitvoeren op de deelrijen links en rechts van de pivot, zal uiteindelijk onze rij gesorteerd zijn.

```c++
void quicksort (vector<T>&v, int l, int r){
   // Rangschikt de deelvector v[l..r-1]
   if (l<r-1){
     // Partitie met v[l] als spilelement
     T pivot = v[l]; //Geen T&, geen move!
     int i = l, j = r-1
     while (v[j]>pivot)
       j--;
     while (i<j){
        swap(v[i],v[j]);
        i++;
     		while (v[i]<pivot)
          i++;
        j--;
        while (v[j]>pivot)
          j--;
     }
     // Recursief rangschikken van beide delen
     quicksort (v, l, j+1);
     quicksort (v, j+1, r);
   }
}
void quicksort (vector<T>&v){
     quicksort(v, 0, v.size());
}
```



### Efficiëntie

**Beste geval**

De deelrijen zijn altijd even groot:
$$
\begin{cases}
2T(\frac n 2) + cn \quad &\text{ if } n>1
\\ 0 \quad &\text{ if } n = 0,1
\end{cases}
$$
Dit is dezelfde betrekking als bij Mergesort en dus $T(n) = \Theta(n\log n)$



**Slechtste geval**

Dan bestaat één van de twee deeltabellen telkens uit één element. Dus:
$$
\begin{align}
T(n) &= cn + T(1)+T(n-1)\\
T(n-1) &= c(n-1) + T(1) + T(n-2)\\
 & \space \space\vdots \\
 T(2) &= c(2) + T(1) + T(1)

\end{align}
$$
De uitvoeringstijd is dus de som van al die dingen: $\Theta(n^2)$



### Random keuze van de pivot

//TODO



### Varianten

**Cut-off**

We kunnen de recursie stoppen als de deeltabel kleiner is geworden dan een bepaalde cut-off waarde. Dan zou je oftewel deze kleine deeltabellen ieder sorteren met insertion sort, oftewel insertion soort in één keer de hele tabel laten sorteren. Dit zal zeer efficiënt uitvallen aangezien het aantal inversies laag is.

**Mediaan-van-drie**

Neem het eerste, middelste en het laatste element van de lijst. Sorteer deze 3 ter plaatse. De grootste en de kleinste kunnen als stopelementen dienen, de middelgrootste gebruik je als pivot. We houden deze apart door hem op de voorlaatste plaats in de rij te zetten. Voor de recursieve oproep zetten we de pivot dan nog op zijn definitieve plaats door te swappen. Deze optimalisatie blijkt in de praktijk 5% sneller dan de pivot random kiezen.

**3-way partitioning**

We verdelen de tabel in drie partities. 

* Elementen kleiner dan de pivot
* Elementen gelijk aan de pivot
* Elementen groter dan de pivot

**Dual pivot sort**

//TODO

# 7 - Lineaire sorteermethodes

## Efficiëntie van rangschikken

<img src="img/image-20220515214614947.png" alt="image-20220515214614947" style="zoom:50%;" />

We willen een informatietheoretische ondergrens bepalen voor eender welk sorteeralgoritme op basis van sleutelvergelijkingen. Als we nu bijvoorbeeld een lijst hebben met drie waardes (a, b en c), kunnen we alle mogelijke sequenties van vergelijkingen die een sorteeralgoritme zou uitvoeren in de vorm van een beslissingsboom voorstellen. Elke inwendige knoop is een sleutelvergelijking tussen twee elementen. Elke bladknoop is een mogelijke uitkomst van het algoritme. De bladeren van deze boom bevatten dus alle mogelijke permutaties van indices onze invoerrij. Dit zijn er minstens $n!$, aangezien een sorteeralgoritme via verschillende reeksen sleutelvergelijkingen tot dezelfde permutatie kan komen.

Hoe veel sleutelvergelijkingen heeft een sorteeralgoritme nu nodig in het slechtste geval? En in het gemiddelde geval? We zoeken voor beiden een ondergrens.

**Slechtste geval**

Het slechtste geval is de langste afstand van de wortel naar een blad, dit is per definitie de hoogte van de boom. Om een ondergrens te vinden zoeken we de minimale hoogte van een boom met $n$ bladeren.
$$
\begin{align}
2^{h-1}&<n!\leq2^h \\
h &= \lceil \log n! \rceil \\
h&> \log(\frac n e)^n \quad \text{ *(formule van sterling)} \\
h&>n\log n-n\log e \\
h&= \Omega(n \log n)
\end{align}
$$
**Gemiddeld geval**

Ook $\Omega(n \log n)$ //TODO

## Counting sort

<img src="img/Counting-sort-4_1.png" alt="Counting Sort (With Code in Python/C++/Java/C)" style="zoom: 33%;" />

Counting sort is zeer nuttig om een tabel te sorteren met waarden die binnen een niet al te groot interval vallen, met veel duplicaten. Eerst en vooral hebben we het maximum en minimum van de lijst nodig. Die kunnen we vinden met Quickselect Dan doen we de volgende stappen:

* Maak een frequentietabel van alle waarden, de index van deze tabel komt overeen met de waarde in de originele tabel
* Maak hiervan een cumulatieve frequentietabel (door te overlopen en op te tellen)
  * Elke waarde in de frequentietabel komt nu overeen met de hoogste index (in de originele tabel) van de waarde op deze index in de frequentietabel
* Maak een nieuwe tabel voor je uitkomst
* Nu overloop je de originele tabel van rechts naar links en voor elk element $x$ dat je tegenkomt doe je:
  * Ga naar de index $x$ in de frequentietabel 
  * Zet $x$ op plaats frequentietabel[x] in de uitkomsttabel
  * Decrementeer frequentietabel[x]
* Zo ga je door tot je aan het eerste element van de originele tabel zit

Dit lijkt een beetje omslachtig, maar deze extra stappen zijn nodig zodat het algoritme **stabiel** is, omdat we vaak te maken zullen hebben met duplicaten. Spijtig genoeg rangschikt het algoritme door de extra tabellen **niet ter plaatse**.

Als we $k$ verschillende sleutels hebben en $k = O(n)$, dan is ons algoritme $\Theta(n)$.

## Radix sort

<img src="img/Simplistic-illustration-of-the-steps-performed-in-a-radix-sort-In-this-example-the.png" alt="Simplistic illustration of the steps performed in a radix sort. In this...  | Download Scientific Diagram" style="zoom: 50%;" />

Radix sorteert een rij door elke sleutel **op te splitsen** in afzonderlijke elementen. Zo kan je een getal in cijfers opsplitsen of een string in letters. Elk afzonderlijk element wordt dan gezien als een getal in een talstelsel met een bepaalde radix (bv 26 bij letters). We kunne onze rij nu dus sorteren per afzonderlijk element. Dit doen we met counting sort. Ik zal iets dieper ingaan op de details in de volgende paragrafen.



### LSD Radix sort

We beginnen bij de meest rechtse (de least significant digit) en sorteren de rij op basis van dit 'getal'. Wanneer dit gedaan is gaan we eentje hoger. Enzovoort enzoverder. 

Met radix $m$, aantal cijfers $d$ en is de performantie $O(dn + dm)$. Als je geen poep in je hoofd hebt neem je een kleine radix en radix sort dus $O(dn)$. Lineair dus. 



### MSD Radix sort

We sorteren de rij op basis van het grootste 'getal'. Dan sorteren we recursief alle deelrijen die beginnen met hetzelfde getal op basis van het tweede grootste getal. Dit doen we natuurlijk altijd met counting sort. 



**Complexiteit**

//TODO





## Bucket sort

//TODO



# 8 - Dynamisch programmeren

Dynamisch programmeren is eigenlijk een upgrade van divide-and-conquer. We splitsen problemen op in kleinere **overlappende deelproblemen**. Als we een deelprobleem hebben opgelost, slaan we op de één of andere manier het resultaat op, zodat we in de andere deelproblemen gebruik kunnen maken van dit resultaat. Dit noemt men **memoisatie**. We ruilen dus geheugen voor uitvoeringstijd.

Stel dat we een een algoritme willen schrijven om het $n$-de Fibonaccigetal te berekenen.
$$
\begin{cases}
F_{n-1} + F_{n-2} &\text{ als } n \geq 2 \\
1 &\text{ als } n = 1 \\
0 &\text{ als } n = 0
\end{cases}
$$
Als we nu geen big brain programmeerstrategieën zouden hebben, zouden we dit algoritme recursief kunnen implementeren. Dan laat je bijvoorbeeld het algorime twee recursieve oproepen doen om telkens de vorige twee Fibonaccigetallen te berekenen. Dit is natuurlijk vrij achterlijk, aangezien super veel getallen meerdere keren gaan berekenen. Kijk maar naar het plaatje.

<img src="img/image-20220516112720610.png" alt="image-20220516112720610" style="zoom:50%;" />

Om dit algoritme te verbeteren met dynamisch programmeren, kunnen we dit op twee manieren aanpakken:

* **Top-down**
  * We vertrekken vanuit de wortel van onze recursieboom en kijken welke deelproblemen moeten worden opgelost, zodat we geen onnodige problemen oplossen. We houden ook een memoruimte bij zodat we éénzelfde probleem geen twee keer op moeten lossen.
  * We beginnen bij het grootste getal en werken zo nog steeds naar beneden, maar nu slaan we de deelresultaten $F_i$ (de reeds berekende Fibonaccigetallen) op in een tabel. We kijken dus eerst in de tabel alvorens een getal te berekenen. 

* **Bottom-up**
  * We berekenen alle deeloplossing in een bepaalde volgorde zodat als we bij een bepaald deelprobleem komen, alle onderliggende deelproblemen zijn opgelost. We gaan dus eigenlijk omhoog in een boom.
  * Hier beginnen we onderaan. Elke keer dat we een nieuw getal berekenen houden we de vorige twee getallen bij. Deze implementatie is natuurlijk de meest efficiënte. Dat is ook meestal het geval voor een bottom-up implementatie.



## Stappenplan

1. Karakterisatievan de oplossing
2. Opstellen recursieve betrekking
3. Bepaal waarde van de optimale oplossing
4. Bepaal structuur van de optimale oplossing



Ik denk dat het bij dit hoofdstuk vooral belangrijk is dat je oefeningen maakt. Ik heb een aantal oefeningen van dit hoofdstuk uitgeschreven in C++ met wat tests. https://github.com/martijnmeeldijk/martijn_oef



## Toepassingen

### Optimale binaire zoekboom

Stel je voor. We hebben eer reeks sleutels die op oplopende volgorde zijn gesorteerd. We hebben ook een tabel met een bepaalde reeks sleutels, met voor elke sleutel een zoekfrequentie. Hoe kunnen we nu een binaire boom opstellen die de totale zoektijd voor deze reeks sleutels  minimaliseert?

We hebben dus:

* Een oplopende reeks sleutels: $s_1, s_2, \dots ,s_n$
* Zoekfrequentie $p_i$ voor elke sleutel $s_i$
* Zoekfrequenties $q_0, q_1, \dots , q_n$ 
  * deze liggen ieder in een interval tussen twee sleutels (of op één van de uiteindes): $]-\infty, s_1[, ]s_1,s_2[ , \dots, ]s_n, + \infty[$

We zoeken naar een boomstructuur die de volgende uitdrukking minimaliseert:
$$
\sum_{i=1} ^n (\text{diepte}(s_i) + 1)p_i + \sum_{i=1} ^n (\text{diepte}(b_i) + 1)q_i
$$
Dit is dus de som van alle lengtes van de zoekpaden naar aanwezige en afwezige sleutels.

//TODO



### Longest common subsequence

Neem twee strings. Wat is de langst opeenvolgende sequentie letters die in beide strings voorkomt? Je mag deze sequentie bekomen door uit elke string een aantal letters weg te halen.

We passen het stappenplan toe:

**Karakterisatie van de oplossing**

On probleem heeft een **optimale deelstructuur**. Een optimale oplossing maakt gebruik van optimale oplossingen voor deelproblemen. Beschouw de volgende sequenties.

```pseudocode
LCS('CGTATGC', 'CTGAC') = LCS('CGTATG', 'CTGA') + 'C'
LCS('CGTATG', 'CTGA') = max(LCS('CGTAT', 'CTGA'), LCS('CGTATG', 'CTG'))
```

We kunnen onze LCS uitdrukken in functie van de LCS van de string met één letter minder.

**Opstellen van een recursieve betrekking**
$$
X = \{ x_1, x_2, \dots, x_n\} \quad Y = \{ y_1, y_2, \dots, y_m\}
$$
We stellen de oplossing voor in een matrix $c$. Het element $c[i,j]$ is de waarde van de LCS van de eerste $i$ letters van $X$ en de eerste $j$ letters van $Y$.
$$
c[i, j] = \begin{cases}
0 &\text{ als } i = 0 \text{ of } j=0 \\
c[i-1][j-1] &\text{ als } i > 0 \text{ en } j>0 \text{ en } x_i = y_j \\
max(c[i][j-1], c[i - 1][j]) &\text{ als } i > 0 \text{ en } j>0 \text{ en } x_i \neq y_j
\end{cases}
$$
**Waarde van de optimale oplossing**

De waarden $c[i,j]$ worden dus opgeslagen in een matrix. Om de waarde van een element te berekenen hebben we de waarde links, linksboven en boven nodig. Als we gewoon vanaf het eerste element in de linkerbovenhoek vertrekken en de matrix rij per rij aflopen, kunnen we hem zo vullen met waarden om uiteindelijk rechtsonder de finale waarde te krijgen.

**Opbouw van de optimale oplossing**

We willen niet alleen de lengte van de langste deelsequentie, maar ook de deelsequentie zelf berekenen. We moeten hiervoor een extra tabel bijhouden die onthoudt welke vorige waarde in $c$ we hebben om elke waarde te berekenen. Dit is iets duidelijker met een plaatje erbij.

<img src="img/image-20220516131522425.png" alt="image-20220516131522425" style="zoom:50%;" />

De matrix $b$ wordt hier voorgesteld door de pijltjes. Als we vanaf het element rechtsonder de pijlen volgen, kunnen we zo de longest common substring vinden.

# 9 - Backtracking

## Combinatorische problemen

Bij combinatorische problemen zoeken we naar oplossingen die de vorm hebben van een combinatorisch object zoals een combinatie of een permutatie. Bij een combinatorisch optimalisatieprobleem zoeken we een geldige oplossing met een minimale of maximale waarde. Voor de meeste combinatorische problemen zijn nog geen efficiënte oplossingen gevonden. We moeten dus kandidaat-oplossingen uitproberen. Dit proces kunnen we versnellen dankzij **backtracking**.



## Backtracking

Met backtracking gaan we onze oplossing **incrementeel opbouwen**. Het is belangrijk dat we het dan zo snel mogelijk ontdekken als we ons op een dood spoor bevinden. Als dit het geval is keren we terug op onze stappen. Beschouw het $n$-queens probleem. We willen $n$ koninginnen op een bord plaatsen zodat ze elkaar niet kunnen slaan. Een backtracking oplossing van dit probleem zou er zo uit kunnen zien.

<img src="img/image-20220516133933621.png" alt="image-20220516133933621" style="zoom:50%;" />

Als we op een ongeldige oplossing komen (een x), keren we één stap terug. Als we vast komen te zitten gaan we terug naar boven en proberen we daar verder. Dat is backtracking in een notendop. Als we nu helemaal sicko mode willen gaan en ons algoritme sneller willen maken, zullen we moeten **snoeien**.

### Snoeien

Omdat de grootte van onze boom vreselijk snel toeneemt, willen we het aantal knopen zo veel mogelijk beperken. We moeten onze boom dus snoeien. Hier zijn een aantal verschillende technieken voor:

* **Variabelen ordenen**: we kunnen het aantal knopen beperken door de volgorde waarin variabelen worden toegevoegd te wijzigen. Als je een sudoku wilt oplossen kan je bijvoorbeeld beginnen bij het vakje waar zo weinig mogelijk verschillende cijfers in mogen.
* **Waarden ordenen**: we kunnen de volgorde waarin de mogelijke waarden van een variabele worden uitgeprobeerd veranderen. Dit heeft geen invloed op de grootte van de boom, maar wel op de volgorde dat hij wordt overlopen. Je begint best met een waarde die zo veel mogelijk opties open houdt.
* **Vooruit testen**: wanneer je een waarde toekent aan een variabele, kijk je of er ten minste één mogelijke waarde overblijft voor alle resterende variabelen. Als dit niet het geval is, ga je meteen naar de volgende waarde.
* **Symmetrieën**: deelbomen die dezelfde oplossingen leveren die we al gevonden hebben, kunnen we weglaten.
* **Branch-and-bound**: Als je een voorlopige deeloplossing hebt, maar weet dat de nog toe te wijzen variabelen onmogelijk tot een betere oplossing kunnen leiden dan de huidig beste oplossing, breek je de zoektocht af.





# 10 - Gulzige algoritmen en metaheuristieken

## Gulzige algoritmen

//TODO



## Metaheuristieken

Er zijn een aantal strategieën, afgeleid uit vele probleemspecifieke heuristieken, die algemener toepasbaar blijken. Dit zijn de zogenaamde **metaheuristieken**. Deze strategieën zijn algemene recepten waar jij dan zelf nog de juiste ingrediënten voor moet kiezen. Chili con Carne

Ik heb zin in Chili con Carne. Maar er is geen Chili en ook geen con Carne dus ik ben genaaid. 

Je gaat metaheuristieken meestal gebruiken voor **optimalisatieproblemen**. We zullen er enkele bespreken.

### Lokaal zoeken

Begin van een willekeurige oplossing $s_0$. We definiëren die verzameling van naburige oplossingen $\mathcal N (s_0)$. Dit zijn oplossingen die je verkrijgt door $s_0$ een heel klein beetje aan te passen. We kiezen nu de beste oplossing $s_1$ uit $\mathcal N (s_0)$. Dit proces herhalen we tot we in een **lokaal maximum** terecht komen. Deze procedure heet dus ook **steepest hill climbing**. Belangrijk om te weten is dat dit lokaal maximum niet speciaal de beste oplossing is. Daarom kan je dit proces best nog een paar keer herhalen met andere random startoplossingen.

### Simulated Annealing

Simulated Annealing biedt een oplossing voor het probleem dat zich voordoet bij lokaal zoeken. We zorgen ervoor dat er een bepaalde kans is dat een slechtere oplossing aanvaardt wordt, in de hoop uit **lokale extrema te kunnen ontsnappen** en het globale maximum te vinden.

Stel je voor. We hebben een oplossing $s$ en een iets slechtere oplossing $s'$. We beschikken ook over een functie $f$ om te meten hoe goed een oplossing is. De kans om een slechtere oplossing te aanvaarden hangt af van $f(s) - f(s')$. Hoe groter dit verschil, hoe kleiner de kans dat we de slechtere oplossing aanvaarden.

Nu wordt het leuk. We willen ook dat we in het begin van het zoekproces vaak slechtere oplossingen uitproberen. Naarmate we verder zoeken, willen we die kans verkleinen. Deze kans moet als het ware afkoelen. Neem $T$, we noemen dit de temperatuur. We laten terwijl ons algoritme draait $T$ geleidelijk aan dalen. We kunnen dan bijvoorbeeld de Boltzmann distributie gebruiken om te bereken wat de kans dat we de foute oplossing kiezen moet zijn. 
$$
p(T, s's) = e^{\frac{f(s) - f(s')} T}
$$
Deze geeft dan altijd een waarde tussen $0$ en $1$. Onze kans dus. Naarmate $T$ daalt, zal deze functie een kleinere kans teruggeven. Hoe snel we $T$ laten dalen is een proces van trial en error. Het kans soms ook dat het beter is om $T$ te laten oscilleren.

### Genetische algoritmen

Ik veronderstel dat je al kunt raden van waar genetische algoritmen hun naam krijgen, dus dat zal ik even achterwege laten. Genetische algoritmen houden een populatie van kandidaatoplossingen bij. We gaan herhaaldelijk de populatie uitdunnen door de slechtste oplossingen dood te maken. Welke oplossingen moeten sterven, bepalen we met een bepaalde **fitness functie**. Dan maken we kruisingen tussen de overblijvende oplossingen, door bijvoorbeeld onderdelen te wisselen. We voegen wat willekeurige mutaties toe. Dit is ongeveer hetzelfde als een andere oplossing kiezen uit $\mathcal N (s)$. 

Hoe je dit allemaal in de praktijk kunt toepassen is niet echt duidelijk. Hoe cool ze ook klinken, zijn genetische algoritmen vaak niet zo nuttig. Het wisselen van genen schaalt niet bepaald goed en we moeten voor elke oplossing een mogelijks kostelijke fitness functie evalueren.





# 11 - NP-Complete problemen

### Reductie



### P en NP



### NP-complete problemen





# Examen

Het leek me nog wel nuttig om de vragen vanuit de wooclaps te verzamelen.




**De fysiek verwijderde knoop uit een**
**geldige rood-zwarte boom kan zijn:**

1. Een rode knoop met 2 virtuele
   kindknopen
2. Een rode knoop met 1 echt zwart
   kind, en 1 virtueel kind
3. Een zwarte knoop met 2 virtuele
   kindknopen
4. Een zwarte knoop met 1 echt rood
   kind en 1 virtueel kind
5. Een zwarte knoop met 1 echt zwart
   kind en 1 virtueel kind



**Als ik de zijde van mijn raster vergroot, krijg ik voor dezelfde gegevens (rasterstructuur):**

1. Minder en kortere gelinkte lijsten
2. Meer en kortere gelinkte lijsten
3. Minder en langere gelinkte lijsten
4. Meer en langere gelinkte lijsten



**Welke uitspraken zijn waar voor een Point Quadtree?**

1. het aantal knopen neemt toe volgens $O (n · 2^k)$ (x)
2. het aantal knopen neemt toe volgens $O(k·2^n)$
3. Zoeken en toevoegen zijn $O (n)$ in het slechtste geval (x)
4. Zoeken en toevoegen zijn O (log n) in het slechtste geval



**De hoogte van een Point Reqion Quad Tree hangt rechtstreeks af van (meerdere opties mogelijk):**

1. De invoervolgorde van de gegevens
2. De grootte van de zoekruimte
3. De kortste afstand van elk mogelijk paar punten



**De invoervolgorde heeft effect op de structuur van een k-d tree**

1. Waar
2. Vals



**De invoervolgorde heeft effect op de structuur van een k-d tree**

1. Waar
2. Vals



**Na $n$ punten toegevoegd te hebben is mijn zoekruimte gesplitst in**

1. $lg(n)$ hyperrechthoeken
2. $lg(n + 1) $hyperrechthoeken
3. $n$ hyperrechthoeken
4. $n+1$ hyperrechthoeken
5. $2n$ hyperrechthoeken
6. $2n +1$ hyperrechthoeken



**Hoeveel neemt de uitvoeringstijd toe wanneer de invoergrootte verdubbelt bij een algoritme met uitvoeringstijd $ log_2 n$, respectievelijk $2^n$?**

1. +1 en x2
2. +1 en x4
3. x2 en x2
4. x2 en x4



**Rangschik onderstaande functies in oplopende volgorde van orde van toename**

1. $2^{\sqrt{n}}$
2. $n \log \log n$n
3. $log^2 n$
4. $2\ log n$
5. $\log n$
6. $2 \log^3 n$



**Rangschik onderstaande functies in oplopende volgorde van orde van toename**

1. $\sqrt{n} \log n$
2.  $5\log \log n$
3. $2^n$
4. $n \log^2 n$
5. $2^{\sqrt{n}}$
6. $2 \log n$



**Is $2^{n+1} = O(2^n)$?**

1. Waar
2. Vals



**Is $2^{n+1} = \Omega(2^n)$?**

1. Waar
2. Vals



**Welke van onderstaande betrekkingen zijn juist over $log^3 n$? (meerdere opties mogelijk)**

1. $\log^3 n$ is $O(\log n)$
2. $\log^3 n$ is $\Omega(\log n)$
3. $\log^3 n$ is $\Theta(\log n)$



**Welke operaties neem je op in je kostenmodel?**

```c++
void selection_sort(vector<T> &v){
	int n = v.size()
	for (int i=0; i<n-1; i++){
		int imin = i;
    for (int j=i+1; j<n; j++){
      if (v[j] < v[imin]) imin = j;
    }
  swap(v[i],v[imin]);
  }
}
```

1. Initialiseren van de positie van het minimum
2. Sleutelvergelijking
3. Aanpassen van de positie van ... (niet leesbaar op de wooclap)
4. Swap operatie



**Selection sort rangschikt:**

```c++
void selection_sort(vector<T> &v){
	int n = v.size()
	for (int i=0; i<n-1; i++){
		int imin = i;
    for (int j=i+1; j<n; j++){
      if (v[j] < v[imin]) imin = j;
    }
  swap(v[i],v[imin]);
  }
}
```

1. Ter plaatse en stabiel
2. Ter plaatse maar niet stabiel
3. Niet ter plaatse en stabiel
4. Niet ter plaatse en niet stabiel



**Insertion sort rangschikt**

1. Ter plaatse en stabiel
2. Ter plaatse maar niet stabiel
3. Niet ter plaatse maar stabiel
4. Niet ter plaatse en niet stabiel





**Het beste/slechtste geval voor insertion sort treedt op bij:**

1. reeds oplopend/aflopend gesorteerde invoer
2. reeds aflopend/oplopend gesorteerde invoer
3. reeds oplopend/oplopend gesorteerde invoer
4. reeds aflopend/aflopend gesorteerde invoer





**We starten met n elementen. Wat is de maximale grootte van de deeltabel waarop de recursieve oproep gebeurt?**

1. $\lfloor \frac{n}{2} \rfloor - 1$ 
2. $\lfloor \frac{n}{2} \rfloor $ 
3. $ \frac{n}{2}  - 1$ 
4. $ \frac{n}{2} $ 
5. $\lceil \frac{n}{2} - 1 \rceil $ 
6. $\lceil \frac{n}{2} \rceil $ 



**Flipping pancakes**

Je hebt een stapel van n pannenkoeken, elk van verschillende grootte. Je kan een spatel onder een willekeurige pannenkoek steken, en zo alle pannenkoeken boven de stapel omkeren. Ontwerp een algoritme om met je spatel de pannenkoeken te sorteren volgens grootte, met de grootste pannenkoek op de bodem.



**Welk geval van het master theorema is van toepassing bij mergesort?**

<img src="img/image-20220404205911011.png" alt="image-20220404205911011" style="zoom: 33%;" />

1. Geval 1
2. Geval 2
3. Geval 3





# ------------ Labo's ------------



## Red black trees

De oplossingen staan online, maar ik wou hier toch even iets kleins toevoegen. De `contains()` wordt in de oplossing recursief opgelost, maar het kan ook iteratief.

```c++
bool RedBlackTree::contains(int key)
{
    // Kan blijkbaar ook recursief
    if (root == NULL) {
        return false;
    } else {
        Node* current = root.get();
        while (true) {
            if (current->key == key) {
                return true;
            } else if (current->key < key) {
                if (current->rightChild) {
                    current = current->rightChild.get();
                } else {
                    return false;
                }
            } else {
                if (current->leftChild) {
                    current = current->leftChild.get();
                } else {
                    return false;
                }
            }
        }
    }
}
```

Ik had de `getHeight()` ook een beetje anders gedaan (een beetje slechter denk ik). Misschien heb je er iets aan.

```c++
int RedBlackTree::getHeight()
{
    return getHeight(root.get());
}
int RedBlackTree::getHeight(Node* node)
{
    if (node == NULL) {
        return 0;
    }
    int left = 0;
    int right = 0;
    if (node->leftChild) {
        left = getHeight(node->leftChild.get()) + 1;
    }
    if (node->rightChild) {
        right = getHeight(node->rightChild.get()) + 1;
    }

    return left > right ? left : right;
}
```



## Decrease and conquer

Redelijk straightforward, maar ik heb wel één leuk fenomeen ondervonden:

De eerste manier runde echt zeker 10 keer trager dan de tweede.

```c++
for (auto& testPoint : testData) {

        // TODO calculate error for this testpoint !
        double error;
        updateDistance(testPoint, trainingData);
        location estimate = kNN_location(trainingData, 10);
        error = euclideanDistance(testPoint, estimate);

        errors[nrTestPoint++] = error;

        std::cout << nrTestPoint << ". Error: " << error << " m" << std::endl;
    }
```

```c++
for (auto& testPoint : testData) {

        // TODO calculate error for this testpoint !
        double error;
        updateDistance(testPoint, trainingData);
        std::shuffle(trainingData.begin(), trainingData.end(), rng);
        location estimate = kNN_location(trainingData, 10);
        error = euclideanDistance(testPoint, estimate);

        errors[nrTestPoint++] = error;

        std::cout << nrTestPoint << ". Error: " << error << " m" << std::endl;
    }
```

Hoe zou dat komen? :wink:



## Divide and conquer

Ik heb het een klein beetje anders gedaan dan in de oplossing, moest iemand geïnteresseerd zijn. 

```c++
template <class T>
T sortedVectorMedian(std::vector<T>& v)
{
    std::sort(v.begin(), v.end(), [](T a, T b) -> bool { return a < b; });
    if (v.size() % 2 == 0) {
        return (v[v.size() / 2 - 1] + v[v.size() / 2]) / 2;
    } else
        return v[v.size() / 2];
}

template <class T>
T sortedVectorMedianOffset(std::vector<T>& v, int offset, int n)
{
    if (n % 2 == 0) {
        return (v[n / 2 - 1 + offset] + v[n / 2 + offset]) / 2;
    } else
        return v[n / 2 + offset];
}

template <class T>
T M3(T a, T b, T c)
{
    return a < b ? (a < c ? (b < c ? b : c) : (a < b ? a : b)) : (b < c ? (a < c ? a : c) : (a < b ? a : b));
}
template <class T>
T M4(T a, T b, T c, T d)
{
    T max = std::max(std::max(a, b), std::max(c, d));
    T min = std::min(std::min(a, b), std::min(c, d));

    return (a + b + c + d - max - min) / 2.0f;
}

template <class T>
void printVector(std::vector<T>& v, int offset, int n)
{
    std::cerr << "[";
    for (int i = 0; i < n; i++) {
        std::cerr << v[i + offset] << ", ";
    }

    std::cerr << "]\n";
}

template <class T>
T getMedian(std::vector<T>& branchA, int a_offset, int a_n, std::vector<T>& branchB, int b_offset, int b_n)
{
    T median_a = sortedVectorMedianOffset<T>(branchA, a_offset, a_n);
    T median_b = sortedVectorMedianOffset<T>(branchB, b_offset, b_n);
    if (median_a == median_b) {
        return median_a;
    }
    if (a_n == 0) {
        return median_b;
    }
    if (a_n == 1) {
        T a = branchA[a_offset];
        T b0 = branchB[b_offset + b_n / 2 - 1];
        T b1 = branchB[b_offset + b_n / 2];
        T b2 = branchB[b_offset + b_n / 2 + 1];
        if (b_n % 2 == 0) {

            return M3(a, b0, b1);
        } else {
            return M4(a, b0, b1, b2);
        }
    }
    if (a_n == 2) {
        T a1 = branchA[a_offset];
        T a2 = branchA[a_offset + 1];
        T b0 = branchB[b_offset + b_n / 2 - 2];
        T b1 = branchB[b_offset + b_n / 2 - 1];
        T b2 = branchB[b_offset + b_n / 2];
        T b3 = branchB[b_offset + b_n / 2 + 1];
        if (b_n % 2 == 0) {
            if (a2 < b0) {
                return (b0 + b1) / 2;
            }
            if (a1 > b3) {
                return (b2 + b3) / 2;
            } else {
                return M4(a1, a2, b1, b2);
            }
        } else {
            return M3(a1, a2, b2);
        }
    } else {

        if (median_a < median_b) {
            return getMedian(branchA, a_offset + a_n / 2, a_n - (a_n / 2), branchB, b_offset, b_n - (a_n / 2));
        } else {
            return getMedian(branchA, a_offset, a_n - (a_n / 2), branchB, b_offset + (a_n / 2), b_n - (a_n / 2));
        }
    }
}

template <class T>
T getMedian(std::vector<T>& branchA, std::vector<T>& branchB)
{
    if (branchA.size() < branchB.size()) {
        return getMedian(branchA, 0, branchA.size(), branchB, 0, branchB.size());
    } else {
        return getMedian(branchB, 0, branchB.size(), branchA, 0, branchA.size());
    }
}
```



Ik heb de testklasse ook wat uitgebreid, want die van de lectoren was wel echt matig. Die van mij maakt twee random arrays, met elke keer andere waarden, dus dan kan je deftig je code testen. Ik zou ook de lengtes van de vectoren aanpassen wanneer je je code test.

```c++
TEST_CASE("Final median wage test", "[MedianWage]")
{
    srand(time(NULL));

    std::vector<float> branchAf = { 3, 7, 8, 9, 12, 30, 40, 65 };
    std::vector<float> branchBf = { 5, 8, 10, 20, 32, 64 };

    float median = getMedian<float>(branchAf, branchBf);

    // Generate 10 random numbers by lambda func and fill it in vector
    std::vector<float> vec_a(23);
    std::generate(vec_a.begin(), vec_a.end(), []() {
        return rand() % 100;
    });
    std::sort(vec_a.begin(), vec_a.end());

    std::vector<float> vec_b(22);
    std::generate(vec_b.begin(), vec_b.end(), []() {
        return rand() % 100;
    });
    std::sort(vec_b.begin(), vec_b.end());

    float median2 = getMedian<float>(vec_a, vec_b);
    vec_a.insert(vec_a.end(), vec_b.begin(), vec_b.end());
    std::sort(vec_a.begin(), vec_a.end());
    float computed_median = sortedVectorMedian(vec_a);

    REQUIRE(median == 11.0f);
    REQUIRE(median2 == computed_median);
}

```



## Nuttige dingen voor de test

### nth-element

`std::nth_element` sorteer je lijst gedeeltelijk zodat het n-de element zeker op de juiste plaats staat. Alle elementen die voor het n-de element staan zullen kleiner zijn en alle elementen erna groter.

```c++
auto m = v.begin() + v.size()/2; 
std::nth_element(v.begin(), m, v.end()); // je moet dus 3 iterators meegeven (begin, n-de element, einde)

// je kan als vierde element ook een (lambda) functie meegeven 
std::nth_element(colors.begin(), half, colors.end(), [&dim](Color a, Color b) { return a.compareDim(a, dim, b); });

// want in dit labo kon je niet zomaar kleuren vergelijken met de "<" operator. 
```



### minmax_element

`std::minmax_element` geeft een paar van iterators terug, de eerste wijst naar het kleinste, en de tweede naar het grootste element in de range.

```c++
const auto v = { 3, 9, 1, 4, 2, 5, 9 };
const auto [min, max] = std::minmax_element(begin(v), end(v));
```



### transform

`std::transform` past een functie toe op elk element van een range (niet gegarandeerd in volgorde geloof ik)

```c++
// we maken alle letters uppercase
std::string s("hello");
std::transform(s.begin(), s.end(), s.begin(), [](unsigned char c) -> unsigned char { return std::toupper(c); });

// We steken alle keys van een map in een vector
map<int, string> m = { {1,"foo"}, {42, "bar"}, {7, "baz"} };
vector<int> keys;
std::transform(m.begin(), m.end(), std::back_inserter(keys), getFirst);
// back_inserter is een output iterator die ook een push_back doet in de array die je eraan meegeeft
```



### accumulate

je kan `std::accumulate` gebruiken om bijvoorbeeld het gemiddelde van een vector te berekenen

```c++
double avg1(std::vector<int> const& v) {
    return 1.0 * std::accumulate(v.begin(), v.end(), 0LL) / v.size();
}
// deze is wel voor als je met hele grote getallen werkt, het kan ook simpeler
```



### vector splitsen

Je kan de constructor van een vector twee iterators meegeven (begin, einde). De elementen van begin tot einde worden dan naar de nieuwe vector gekopieerd. Dit kan van pas komen als je recursief een boom moet opbouwen.

```c++
std::vector<int> lines;
// fill
std::size_t const half_size = lines.size() / 2;
std::vector<int> links(lines.begin(), lines.begin() + half_size);
std::vector<int> rechts(lines.begin() + half_size, lines.end());
```



### swap

Om twee elementen te wisselen.

```c++
std::swap(v[0],v[1]);
```



### vectoren samenvoegen

```c++
vector1.insert( vector1.end(), vector2.begin(), vector2.end() );
```

