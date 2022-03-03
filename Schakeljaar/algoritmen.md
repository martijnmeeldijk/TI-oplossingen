# Algoritmen



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

<img src="img/image-20220216094826507.png" alt="image-20220216094826507" style="zoom:50%;" />

Kind roteren naar bover zijn ouder, deelboom van het kind wordt de deelboom van de voormalige ouder. De kost van één rotatie is $O(1)$.



Om de boom te fixen, kunnen we ook **recoloren**. We moeten dit doen wanneer een rode knoop rode kinderen heeft na een toevoegoperatie (double red).





<img src="img/image-20220216100828842.png" alt="image-20220216100828842" style="zoom:50%;" />

<img src="img/image-20220216100932945.png" alt="image-20220216100932945" style="zoom:50%;" />

<img src="img/image-20220216101108475.png" alt="image-20220216101108475" style="zoom:50%;" />

<img src="img/image-20220216101217905.png" alt="image-20220216101217905" style="zoom:50%;" />