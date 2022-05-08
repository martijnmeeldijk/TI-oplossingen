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

## Selection sort

<img src="img/Selection-sort-0.png" alt="Selection Sort (With Code in Python/C++/Java/C)" style="zoom:33%;" />

* Neem het kleinste element van de lijst en zet het vooraan
* Neem het kleinste element van de lijst behalve het eerste element en zet dat op de tweede plek
* Herhaal
* Winst



## Insertion sort

![Recursive Insertion Sort - GeeksforGeeks](img/insertion_sort-recursion.png)

Je gaat eigenlijk de rij element per element af, het element dat je tegenkomt blijf je naar links schuiven zolang het kleiner is dan het element aan zijn linkerkant. Je krijgt dus in elke stap links van het groene blokje en telkens groter wordende gesorteerde deelrij.

//TODO inversies, best case, worst case?



## Orde van toename

$$
n!>> 2^n >> n^{1+\alpha} >> n \log n  >> n^\epsilon >> \log n >> \log \log n >> C
$$



## Stappenplan

  1. Definieer een maat voor de invoergrootte
 2. Definieer je kostenmodel: welke basisoperaties?
 3. Bepaal of uitvoeringstijd afhankelijk is van waarde van de invoer
 4. Stel een sommatie op die uitdrukt hoe vaak de basisoperatie wordt uitgevoerd
 5. Werk deze sommatie uit tot een gesloten uitdrukking, of schat af in asymptotische notatie



# 4 - Analyse van recursieve algoritmen

<img src="img/image-20220501180337873.png" alt="image-20220501180337873" style="zoom:50%;" />



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

