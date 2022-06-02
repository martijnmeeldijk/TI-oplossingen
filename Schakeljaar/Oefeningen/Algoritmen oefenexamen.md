# Algoritmen oefenexamen

## Red-black trees

**Voeg de reeks 12, 13, 14, 15 toe aan onderstaande rood-zwarte boom.**

<img src="img/image-20220530210109720.png" alt="image-20220530210109720" style="zoom:50%;" />



---

**Toon aan dat een rood-zwarte boom ten minste $2^{ZH(x)} - 1$ interne knopen bevat.**





---

**Bewijs dat de hoogte van een red-black tree $O(\log n)$ is.**





---

**Veronderstel dat een sleutel x aan een rood-zwarte boom wordt toegevoegd. Onmiddellijk daarna verwijderen we terug de sleutel x. Veronderstel bottom-up toevoegen en verwijderen. Is de roodzwarte boom na deze 2 operaties identiek aan de originele rood-zwarte boom? Toon deze eigenschap aan, of geef een tegenvoorbeeld.**





## Meerdimensionale gegevensstructuren

**Teken de resulterende PR-Quadtree bij het toevoegen van de volgende punten. Maak ook een tekening in boomvorm. Alle punten vallen binnen [0, 255]**

A(130, 120)

C(90, 200)

D(30, 154)

E(130, 90)







---

**Teken de resulterende KD-tree bij het toevoegen van de volgende punten. Maak ook een tekening in boomvorm. Alle punten vallen binnen [0, 500]**

(29, 414), (410, 105), (87, 255), (47, 94), (227, 38), (344, 323), (92, 317), (192, 393), (327, 452), (326, 373)









---

**Waardoor wordt de hoogte van een PR Quadtree bepaald? Bewijs.**







## Efficiëntie van algoritmen

**Sorteer de volgende functies in aflopende orde van toename.**
$$
 \log \log n \quad C \quad
2^n\quad \log n\quad n! \quad  \quad n^{1+\alpha} \quad n \log n   \quad
 n^\epsilon 
$$



---

**Geef een $\Theta$ afschatting voor het volgende algoritme.**

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



.



---

**Stel een recurrente betrekking op voor het volgende algoritme en vorm om naar een gesloten uitdrukking.**

```c++
int factorial(int n){
  if (n == 0) return 1; 
  else return n*factorial(n–1);
}
```







---

**Gegeven een recursief algoritme dat de som van een tabel berekent door de tabel telkens in 2 te splitsen. **

```c++
int somBinaireRecursie(const vector<T>& v, int start, int stop){
	if(start >= stop) return 0;
  
  if(start == (stop -1)) return v[start];
  
  int mid = start + (stop - start)/2;
  
  return somBinaireRecursie(v, start, mid) + somBinaireRecursie(v, mid, stop);
}
```

**Stel een recurrente betrekking op en geef een afschatting voor de uitvoeringstijd op basis van de invoer $n$**







---

**Wat is de efficiëntie van quickselect in het beste, gemiddelde en slechtste geval?**







## Algemene sorteermethodes



**Wat is de performantie van insertion sort in het slechtste, gemiddelde en beste geval? Waarvoor wordt insertion sort vaak gebruikt en waarom?**





---

**Geef een big O afschatting voor de performantie van heapsort en bewijs.**











---

**Bewijs: Mergesort is $\Theta(n\log n)$**







---

**Wat is de efficiëntie van Quicksort in het beste en slechtste geval? Bewijs.**





---

**Vul in:**

| Sorteeralgoritme | Ter plaatse / Niet ter plaatse | Stabiel / Niet stabiel |
| ---------------- | ------------------------------ | ---------------------- |
| Selection sort   |                                |                        |
| Insertion sort   |                                |                        |
| Shellsort        |                                |                        |
| Heapsort         |                                |                        |
| Mergesort        |                                |                        |
| Quicksort        |                                |                        |
| Counting sort    |                                |                        |
| LSD Radix sort   |                                |                        |
| MSD Radix sort   |                                |                        |
| Bucket sort      |                                |                        |



---

**Toon aan dat rangschikken van n gegevens, enkel op basis van sleutelvergelijking, in het slechtste geval $\Theta(n \log n)$ sleutelvergelijkingen vereist.**






---

**Toon aan dat rangschikken van n gegevens, enkel op basis van sleutelvergelijking, in het gemiddeld geval $\Theta(n \log n)$ sleutelvergelijkingen vereist.**





---

**Stel een betrekking op die de uitvoeringstijd van quicksort met random pivot beschrijft.**





## Backtracking

**Geef 5 snoeitechnieken voor backtracking en leg kort uit.**







## Gulzige algoritmen en metaheuristieken

<img src="img/image-20220520190653796.png" alt="image-20220520190653796" style="zoom:50%;" />

**Gegeven een processor en een bepaalde reeks taken die de processor moet uitvoeren. Elke taak heeft een bepaalde uitvoeringstijd. Bedenk een gulzig algoritme dat de gemiddelde eindtijd van alle taken minimaliseert. Geeft jouw algoritme ook de ideale oplossing? Toon aan.** 







---

**Gegeven een reeks activiteiten met een bepaalde begin- en eindtijd. Bedenk een gulzig algoritme dat ervoor zorgt dat we zo veel mogelijk activiteiten kunnen uitvoeren en bewijs dat dit de ideale oplossing is.**

![image-20220520220127794](img/image-20220520220127794.png)







---

**Welk probleem doet zich voor bij lokaal zoeken. Welke metaheuristiek(en) tracht(en) dit op te lossen. Hoe?**





## NP-complete problemen

**Toon aan dat 3SAT NP-compleet is.**









---

**Toon aan dat set cover NP-compleet is**







---

**Vul aan**:

| Probleem            | Korte beschrijving |
| ------------------- | ------------------ |
| SAT                 |                    |
| 3SAT                |                    |
| Set cover           |                    |
| Hitting set         |                    |
| Set packing         |                    |
| Subset sum          |                    |
| Integer Partition   |                    |
| Bin packing         |                    |
| Knapsack            |                    |
| Vertex cover        |                    |
| Clique              |                    |
| Vertex coloring     |                    |
| Edge coloring       |                    |
| Independent set     |                    |
| Travelling salesman |                    |

