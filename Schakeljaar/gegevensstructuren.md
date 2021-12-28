# Gegevensstructuren



## 3 - Containers

Wat is een container? 

Basically een array. We gaan data opslaan zonder key of value ofzo.



### Array

| Operatie                              | Cost           |
| ------------------------------------- | -------------- |
| Element opvragen                      | O(1)           |
| Toevoegen (als we genoeg plek hebben) | O(1)           |
| n elementen toevoegen                 | 3n (gemiddeld) |

> **Amortized efficiency** is a very important concept: instead of looking at a single operation, we look at a sequence of operations and calculate the average efficiency. This is commonly used when an single operation could be slow in some rare situations



### Linked List

| Operatie                | Cost |
| ----------------------- | ---- |
| Eerste element opvragen | O(1) |
| Element verwijderen     | O(1) |
| Element opvragen        | O(n) |



### Stack

| Operatie | Cost |
| -------- | ---- |
| Push     | O(1) |
| Pop      | O(1) |
|          |      |



### Queue

(first in first out)

| Operatie    | Cost |
| ----------- | ---- |
| Toevoegen   | O(1) |
| Verwijderen | O(1) |



### Deque

(double ended queue)

| Operatie    | Cost |
| ----------- | ---- |
| Toevoegen   | O(1) |
| Verwijderen | O(1) |



### Tree

<img src="img/image-20211218201253485.png" alt="image-20211218201253485" style="zoom:50%;" />

Tree traversal 

Iterate (walk) over the data in the tree in a certain order. 

Multiple possible orderings: 

* Depth first: Go all the way down before processing the next sibling 
  * Pre-order: root - left subtree - right subtree = Polish notation
  * In-order: left subtree - root - right subtree 
  * Reverse in-order: right subtree - root - left subtree 
  * Post-order: left subtree - right subtree - root = Reverse polish notation
    * Is nuttig op een stack machine
* Breadth-first: visit every node on a level before going to a lower level 
* Best first: The children have some priority (e.g. Monte Carlo tree search)



### Graph

<img src="img/image-20211218201400055.png" alt="image-20211218201400055" style="zoom:50%;" />

Hoe opslaan?

**Adjacency matrix**: N x N matrix waarbij het gewicht van de verbinding tussen 2 nodes op plaats [node1, node2] staat. Het is wel niet zo efficient om op te slaan.

**Adjacency lists**: Voor elke node een lijst met de buren. Is efficienter voor grafen met weinig verbindingen.





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

