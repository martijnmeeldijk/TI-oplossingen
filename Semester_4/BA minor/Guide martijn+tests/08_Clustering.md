---
typora-copy-images-to: ./img

---

# Clustering

In de video van Orange:tm: legt onze lieve vrouw best goed uit hoe je clustering kan toepassen in orange.

Voor de personen die geen zin hebben om de video te kijken:

<img src="img/image-20200510115617683.png" alt="image-20200510115617683" width="50%" />

Dit was zowat het nuttigste.



## 1. Online Retail: What other technique have we seen that might be used to recommend other products to a customer?

Open je *ba_minor_exercises.pdf* maar al. Je kan ook de pdf over clustering lezen, maar die helpt niet echt bij deze oefeningen zo te zien.

Ik denk bij deze vraag aan het vorige labo. Waar ging dat ook alweer over?



## 2. Online Retail: What do you notice when you use Single Linkage?

Je moet zien dat je dit krijgt:

<img src="img/image-20200510135647247.png" alt="image-20200510135647247" width="50%" />

En niet dit:

<img src="img/image-20200510135945484.png" alt="image-20200510135945484" width="50%" />

Dit kan je bekomen door in de *distances* widget *culmuns* te selecteren i.p.v. *rows*.

Je kan ook de *transpose* widget gebruiken. Hoe dat precies allemaal werkt weet ik niet echt. Kijk zeker eens naar *solutions/10__store.ows* in de repo van ba minor.

Oke, nu kan je het op *single linkage* zetten en de vraag beantwoorden.

## 3. Online Retail: You want to recommend four products to someone buying a mug, based on Complete Linkage. Which of the following would NOT be recommended?

Kijk naar de cluster die *mug* bevat. Er zit er duidelijk eentje niet in.

##  4. Zoo: What attribute is left alone until the top level clustering for all linkages (cosine distance)?

Dat kun je ook wel gemakkelijk zien.

Als het hebt gevonden en je afvraagd welk dier het is: zeester

## 5. Zoo: The top 10 clusters, using Spearman distance and average linkage, make sense?

Ik denk van wel, je kan duidelijk verschillende groepen dieren zien.

## 6. Zoo: It makes sense that mammals and birds are on opposite sides when projecting on airborne, milk, and feathers.

Moet je hiervoor zelfs orange openen?

## 7. Zoo: Use k-means to make 4 clusters. Which of the following animals is clustered as a bird, but doesn't have feathers?

Oke dit heeft even geduurd om te begrijpen. Je kan best de oplossing *solutions/10_clustering_zoo.ows* openen. Zet de *K-means* widget op *fixed: 5*

<img src="img/image-20200510152720523.png" alt="image-20200510152720523" width="50%" />

Als je deze settings gebruikt worden alle dieren met veren gemarkeerd met x. Dit geeft niet veel inzicht in de vraag die wordt gesteld, maar we zien wel dat de vogels zich in dit geval waarschijnlijk in cluster `C3` bevinden.

<img src="img/image-20200510153057228.png" alt="image-20200510153057228" width="50%" />

Achter de *scatterplot* heb ik een *select rows* gezet. Met als conditie `cluster is C3` als je nu kijkt zie je dat er één dier tussen zit zonder veren.

Je zou natuurlijk ook nog een conditie kunnen toevoegen, maar dat is niet echt nodig.

## 8. Zoo: Look at the Distribution using the variable cluster and Split by Type. Which type dominates an entire cluster?

Volg dit pad in haar oplossing: *file* -> *k-means* -> *Select columns* -> *Distributions*

Druk bij *distributions* op *Split by:* **type**

Nu zal je het hopelijk wel vinden.

## (mijn) Antwoorden

1. Association Rules
2. Existing cluster adds the next item to form a larger cluster
3. Felt Craft
4. legs = 5
5. True
6. True
7. Tortoise
8. Mammal

:tada: Aight boys we hebben 8/8

