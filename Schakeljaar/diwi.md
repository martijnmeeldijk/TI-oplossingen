# Discrete wiskunde

Deze samenvatting is iets meer low effort sorry. 

## Leerstofoverzicht

* Hoofdstuk 1 – Verzamelingen, relaties & functies
  * Groepen, ringen, velden
  * Bewijzen voor verzamelingen + ... is irrationaal
  * Eigenschappen bewerkingen met verzamelingen
  * Relaties en functies
    * Orderelaties
    * Equivalentierelaties
* Hoofdstuk 2 – Modulorekenen
  * Priemgetallen
    * De Zeef van Eratosthenes
    * Priemontbinding
    * Ggd (uitgebreide euclides + bezout)
  * Rekenen in $\mathbb{Z}_n$
  * Pseudorandom getallen
  * Vergelijkingen oplossen
    * Lineaire congruenties
    * Invers element zoeken
    * Fermat
    * Lineaire diofantische vergelijkingen
    * Stelsels van lineaire congruenties
    * Residutalstelsels
    * Cryptografie
* Hoofdstuk 3 – Eindige velden
  * $\mathbb{Z}_n$ is een veld $\xLeftrightarrow{}$ $n$ is priem bewijs
  * Constructie van eindige velden
  * Voortbrengende veelterm
  * Irreduciebele veelterm
  * Het Galoisveld
  * Rabin test
  * Toepassingen
* Hoofdstuk 4 – Logica
  * Propositionele logica
    * Negatie, disjunctie, ...
    * Nodige en voldoende voorwaarde, Wederzijdse implicatie
    * Precedentieregels
    * Tautologie, contradictie en eventualiteit
  * Boole-algebra’s
    * eigenschappen (bewijzen niet kennen)
  * Vereenvoudigen van logische uitdrukkingen
  * Predikatenlogica
  * Bewijsstrategieën
    * Rechtstreeks bewijs
    * Bewijs door gevallenonderzoek
    * Contrapositie
    * Bewijs uit het ongerijmde
    * Wiskundige inductie

# H1 - Verzamelingen, relaties en functies



## Getalverzamelingen

$\mathbb{Z}$ is een **ring**: gesloten voor +, x en -

$\mathbb{Q}$ is een **veld**: gesloten voor +, -, x, en /

$\mathbb{R}$ is ook een veld.

$\mathbb{C}$ is een algebraïsch gesloten veld: je kan alle veeltermvergelijkingen met één onbekende oplossen



## Bewerkingen met verzamelingen

Een paar nuttige eigenschappen
$$
A \cap (B \cap C) = (A \cap B)\cap C \\\
A \cap (B \cup C) = (A \cap B)\cup (A \cap C) \\\
A \backslash ( B \cap C) = (A \backslash B) \cup (A\backslash C) \\\
(B \cap C)^c = B^c \cup C^c
$$

$$
A \cup (B \cup C) = (A \cup B)\cup C \\\
A \cup (B \cap C) = (A \cup B)\cap (A \cup C) \\\
A \backslash ( B \cup C) = (A \backslash B) \cap (A\backslash C) \\\
(B \cup C)^c = B^c \cap C^c
$$

 **Inclusie en exclusie**
$$
\abs{A \cup B} = \abs{A} +\abs{B} - \abs{A\cap B} \\\
\abs{A \cup B \cup C} = \abs{A} +\abs{B} + \abs{C} - \abs{A\cap B} - \abs{A\cap C} - \abs{B\cap C} + \abs{A \cap B \cap C}
$$

$$
\abs{A_1 \cup A_2 \cap \space... \space A_n } = 
\sum _{i=1}^{n}|A_{i}|-\sum _{1\leqslant i<j\leqslant n}|A_{i}\cap A_{j}|+\sum _{1\leqslant i<j<k\leqslant n}|A_{i}\cap A_{j}\cap A_{k}|-\cdots +(-1)^{n-1}\left|A_{1}\cap \cdots \cap A_{n}\right|
$$



## Relaties en functies

**Functie**: Uit elk element in $A$ vertrekt ten hoogste één pijl naar B

**Totale relatie**: Uit elk element van $A$ vertrekt minstens één pijl

**Partiële relatie**: als niet uit elk element van $A$ een pijl vertrekt

**Totale functie**: uit elk element van $A$ vertrekt exact één pijl (= **afbeelding**)



**Surjectie**: er komt in elk element in $B$ minstens één pijl toe

**Injectie**: er komt in elk element in $B$ hoogstens één pijl toe

**Bijectie**: uit elk element in $A$ vertrekt exact één pijl en er komt in elk element van $B$ exact één pijl toe. (=  totale functie die zowel injectief als surjectief is)



### Bewijzen

(op de simpelst mogelijke manier als geheugensteun)

$\abs{\mathbb{N}} = \abs{\mathbb{Z}}$

Twee veramelingen hebben dezelfde kardinaliteit als er een bijectie tussen bestaat.

Dan maken we een bijectie van $\mathbb{Z}$ naar $\mathbb{N}$: neem $\frac{n}{2}$ als $n$ even is en $-\frac{n-1}{2}$ als $n$ oneven is.

---

$\abs{\mathbb{N}} = \abs{\mathbb{Q}}$

Doe dit:

![Countability of the rationals drawn using TikZ – David Richeson: Division  by Zero](img/screen-shot-2013-04-16-at-9-23-14-pm.png)

Als je de getallen die je al hebt gehad overslaat, is deze relatie een bijectie.

---

$\mathbb{R}$ is overaftelbaar

Het volstaat om te bewijzen dat $[0, 1]$ overaftelbaar is.

![Irregular Webcomic! #2292](img/annot2292b.png)

Je maakt dus een nieuw getal waarvan de eerste decimaal verschillend is van de eerste de decimaal van het eerste getal, de tweede van de tweede, etc.

Dan kan je altijd een nieuw getal vinden dat nog niet in je lijst staat.



## Orderelaties

Een relatie is een (partiële) orderelatie als hij aan de volgende voorwaarden voldoet:

* Reflexiviteit: elk element heeft een relatie met zichzelf.
* Antisymmetrie: als $x$ een relatie heeft met $y$, en $y$ dezelfde relatie heeft met $x$, is $x$ gelijk aan $y$. 
* Transitiviteit: als $x$ een relatie heeft met $y$ , en $y$ met $z$. Dan heeft $x$ een relatie met $z$.

Een relatie is een **totale orderelatie** als hij nog aan een vierde eigenschap voldoet:

* Voor alle $x$ en $y$ is er een relatie tussen $x$ en $y$ of tussen $y$ en $x$ (of beide)

Een **strikte orderelatie** is antireflexief i.p.v. reflexief:

* Antireflexiviteit: er zijn geen elementen die een relatie met zichzelf hebben.



Voorbeeld van de cursus:

De relatie $\leq$ in $\mathbb{N}$ is een totale orderelatie, want twee elementen kunnen steeds vergeleken en geordend worden. (hiermee valt de eigenschap van antisymmetrie ook iets beter te begrijpen)



## Equivalentierelaties

Een relatie is een **equivalentierelatie** als als hij aan de volgende voorwaarden voldoet

* Reflexiviteit: elk element heeft een relatie met zichzelf.
* Symmetrie: als $x$ een relatie heeft met $y$ heeft y $y$ dezelfde relatie heeft met $x$.
* Transitiviteit: als $x$ een relatie heeft met $y$ , en $y$ met $z$. Dan heeft $x$ een relatie met $z$.

Het verschil met een orderelatie is de symmetrie.



Voorbeeld uit de cursus:

De relatie 'heeft dezelfde absolute waarde' is een equivalentierelatie. De relatie 'is gehuwd met' is geen equivalentierelatie (niet reflexief)



# H2 - Modulorekenen

De Zeef van Eratosthenes?

### Fundamentele stelling van de rekenkunde

Elk geheel getal groter dan 1 kan op een unieke manier geschreven worden als een product van priemgetallen
$$
{\displaystyle n=p_{1}^{n_{1}}p_{2}^{n_{2}}\cdots p_{k}^{n_{k}}=\prod _{i=1}^{k}p_{i}^{n_{i}}}
$$
Het aantal delers van $n$:
$$
{\displaystyle (n_1 + 1).(n_2+1). ..(n_k+1)=\prod _{i=1}^{k}(n_i + 1)}
$$


ggd en kgv ga ik hier niet opschrijven, maak gewoon de oefeningen. 



## Rekenen in $\mathbb{Z}_n$

### Rekenregels

Kort samengevat. Je mag bij alle bewerkingen waarvan je een modulo moet nemen de modulo van het tussenresultaat nemen om het rekenwerk te vergemakkelijken.

Voorbeeld:

(204.1028) mod 32 = ((204 mod 32) . (1038 mod 32)) mod 32 

= (12.14) mod 32 = 168 mod 32 = 8



### Pseudorandom getallen genereren

Met de **lineaire conguentiemethode**

gebruikt 4 getallen:

* Modulus: $m$
* Factor: $a$
* Increment: $c$
* Seed: $x_0$

Dan kunnen we pseudorandom getallen genereren met:
$$
x_{i+1} = (a.x_i + c) \mod m \quad \quad (i \in \mathbb{N})
$$
Een **Lehmer pseudorandomgenerator** heeft als $m$ een priemgetal of een macht van een priemgetal, $c=0$, $ggd(m, x_0) = 1$ en $a$ is geen nuldeler van $\mathbb{Z}_m$.

* Neem je $m = 2^k$, met $k > 2$. Dan is de maximale periode $\frac{m}{4}$. Als $a \stackrel{8}{=} \pm3$ dan is de periode gelijk aan $\frac{m}{4}$.

* Heeft maximale periode ($m-1$) indien $m$ priem is en $a$ een generator is voor $\mathbb{Z}_m$. ($a, a^2, a^3, ...$ doorloopt alle elementen van $\mathbb{Z}_m$, behalve natuurlijk 0). 



**Hull-dobell theorema**. De periode van een pseudorandom generator is maximaal en gelijk aan m als.

* $c \neq 0$

* $ggd(c,m)=1$

* $a-1$ is deelbaar door alle priemfactoren van $m$

* $a-1$ is deelbaar door 4 als $m$ deelbaar is door 4

  

  :warning: Let op bij de de laatste voorwaarde hier. Als het tweede deel van de voorwaarde niet voldaan is, hoeft het eerste deel ook niet voldaan te zijn (wat het leven soms wel een stuk makkelijker maakt).



## Elementaire vergelijklingen bij modulorekenen

Vergelijkingen van de vorm $a + x \stackrel{n}{=} b$.

<img src="img/image-20211230102625351.png" alt="image-20211230102625351" style="zoom: 33%;" /> 





## Lineaire congruenties

Vergelijkingen van de vorm: <img src="img/image-20211230102700381.png" alt="image-20211230102700381" style="zoom:33%;" />

Voor een gegeven getal $x$: zoek diens multiplicatief inverse $y$ zodat:<img src="img/image-20211230102737088.png" alt="image-20211230102737088" style="zoom:33%;" />

We willen bewijzen dat er maar één getal getal bestaat waarvoor dit geldt. We kunnen bewijzen dat er ten minste één is, en dat er ten hoogste één is:

<u>Ten minste één:</u>

<img src="img/image-20211230103350568.png" alt="image-20211230103350568" style="zoom:33%;" /> 

<u>Ten hoogste één:</u>

<img src="img/image-20211230103421078.png" alt="image-20211230103421078" style="zoom:33%;" /> 



### Zoeken van een invers element

We nemen bijvoorbeeld $5$ mod $13$. We zoeken een inverse $x$ zodat $x.5$ mod $13 = 1$.

Via het uitgebreide algoritme van Euclides vinden we: $ggd(5, 13) = 1 = 8 ⋅ 5 − 3 ⋅ 13$

De gezochte inverse is dus $8$ mod $13$



### Kleine stelling van Fermat

<img src="img/image-20211230104447846.png" alt="image-20211230104447846" style="zoom:33%;" /> 

<img src="img/image-20211230104459363.png" alt="image-20211230104459363" style="zoom:33%;" /> (Beide leden vermenigvuldigen met $a$)

<img src="img/image-20211230104516963.png" alt="image-20211230104516963" style="zoom:33%;" /> 

<img src="img/image-20211230104529205.png" alt="image-20211230104529205" style="zoom:33%;" /> 

<img src="img/image-20211230104739343.png" alt="image-20211230104739343" style="zoom: 33%;" /> Bij de 3de stap valt $a.x$ weg want $a.x = 1$ (inverse)



### Oplossen lineaire congruenties

<img src="img/image-20211230105336158.png" alt="image-20211230105336158" style="zoom:33%;" /> 

**Bewijs**

<img src="img/image-20211230105359235.png" alt="image-20211230105359235" style="zoom:33%;" /> 

<img src="img/image-20211230105413840.png" alt="image-20211230105413840" style="zoom:33%;" /> 

<img src="img/image-20211230105432353.png" alt="image-20211230105432353" style="zoom:33%;" /> 



## Lineaire diofantische vergelijkingen

Een lineaire diofantische vergelijking in twee onbekenden $x, y$ ∈ ℤ is van de vorm
$$
ax + by = c
$$
met $a, b, c$ ∈ ℤ

Het is dus een vergelijking waarvoor we **enkel gehele oplossingen** zoeken:

<img src="img/image-20211230105820660.png" alt="image-20211230105820660" style="zoom:33%;" /> 

Voorveeld:

<img src="img/image-20211230115332364.png" alt="image-20211230115332364" style="zoom:33%;" /> 

## Stelsels van lineaire congruenties

Het stelsel:

<img src="img/image-20211230105955640.png" alt="image-20211230105955640" style="zoom:33%;" />

<img src="img/image-20211230110017882.png" alt="image-20211230110017882" style="zoom:33%;" /> 

**<u>Bewijs</u>**

<img src="img/image-20211230110054684.png" alt="image-20211230110054684" style="zoom:33%;" /> 

<img src="img/image-20211230110114139.png" alt="image-20211230110114139" style="zoom:33%;" /> 

<img src="img/image-20211230110136385.png" alt="image-20211230110136385" style="zoom:33%;" /> 

<img src="img/image-20211230110156792.png" alt="image-20211230110156792" style="zoom:33%;" /> 



### Residutalstelsels

<img src="img/image-20211230114046546.png" alt="image-20211230114046546" style="zoom:33%;" /> 





# H3 - Eindige velden

$\mathbb{Z}_n$ is een veld $\xLeftrightarrow{}$ $n$ is priem

<img src="img/image-20211230114453641.png" alt="image-20211230114453641" style="zoom: 33%;" /> 

Klein beetje uitleg bij het tweede deel:

*Niet triviaal*: dan zijn ze niet 1 of het getal zelf

$p$ en $q$ zijn allbei een element van $\mathbb{Z}_n$. Als $\mathbb{Z}_n$ een veld is, hebben $p$ en $q$ dus allebei een inverse (definitie van een veld). Dit (ont)bewijzen we uit het ongerijmde door gewoon te zeggen dat $p$ wel een inverse heeft in $\mathbb{Z}_n$. $p.x + k.x = 1$ de linker kant is deelbaar door $p$, want $k = p.q$. De rechterkant is dus ook deelbaar door $p$. 1 is dus deelbaar door $p$. We hadden gezegd dat $p$ niet triviaal is. Hier heb je dan een contradictie waarmee de stelling bewezen is.



## Een eindig veld maken

Om de één of andere reden willen we een eindig veld van orde  $q = p^k$ maken. 



<img src="img/image-20211230120131330.png" alt="image-20211230120131330" style="zoom:33%;" /> 



### Voortbrengende veelterm

<img src="img/image-20211230120712852.png" alt="image-20211230120712852" style="zoom:33%;" /> 

Je kan elke veelterm monisch maken door hem te vermenigvuldigen met de inverse van de coëfficiënt van de hoogstegraadsterm.

### Irreducibele veelterm

<img src="img/image-20211230120957698.png" alt="image-20211230120957698" style="zoom:33%;" /> 



### Het Galoisveld van orde $q=p^k$

<img src="img/image-20211230121212340.png" alt="image-20211230121212340" style="zoom:33%;" /> 

<img src="img/image-20211230121241770.png" alt="image-20211230121241770" style="zoom:33%;" /> 

Hoe kunnen we nu die irreducibele veelteerm vinden?

<img src="img/image-20211230121523161.png" alt="image-20211230121523161" style="zoom:33%;" /> 



### Rabin test voor ondeelbaarheid

<img src="img/image-20211230122002265.png" alt="image-20211230122002265" style="zoom:33%;" /> 

<img src="img/image-20211230122059900.png" alt="image-20211230122059900" style="zoom:33%;" /> 

### Eenvoudige rabin test 

<img src="img/image-20211230122323456.png" alt="image-20211230122323456" style="zoom:33%;" /> 

<img src="img/image-20211230122338220.png" alt="image-20211230122338220" style="zoom:33%;" /> 



### BCH codes

<img src="img/image-20211230122404601.png" alt="image-20211230122404601" style="zoom:33%;" /> 

Hier is ooit een examenvraag over geweest





# H4 - Logica

| Naam                                                         | Waarheidstabel                                               |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Negatie (not)                                                | <img src="img/image-20211230122540376.png" alt="image-20211230122540376" style="zoom:33%;" /> |
| Disjunctie (or)                                              | <img src="img/image-20211230122559011.png" alt="image-20211230122559011" style="zoom:33%;" /> |
| Exclusieve disjunctie (xor)                                  | <img src="img/image-20211230122619972.png" alt="image-20211230122619972" style="zoom:33%;" /> |
| Conjunctie (and)                                             | <img src="img/image-20211230122646571.png" alt="image-20211230122646571" style="zoom:33%;" /> |
| Implicatie ($p$ is nodige voorwaarde, $q$ is vodoende voorwaarde) | <img src="img/image-20211230122704866.png" alt="image-20211230122704866" style="zoom:33%;" /> |
| Wederzijdse implicatie                                       | <img src="img/image-20211230122821949.png" alt="image-20211230122821949" style="zoom:33%;" /> |
|                                                              |                                                              |



### Regels

1. Haakjes hebben voorrang 
2. Alle ¬ evalueren 
3. Daarna ∨, ∧ en ⊕ 
4. Tot slot ⇒ en ⇔



### Tautologie, contradictie, eventualiteit

**Tautologie** 

Een propositie die altijd waar is, ongeacht de waarden van de gebruikte logische variabelen Bijv. **p ∨ ¬p** is altijd waar, onafhankelijk van **p**

**Contradictie** 

Een propositie die altijd vals is, ongeacht de waarden van de gebruikte logische variabelen Bijv. **p ∧ ¬p** is altijd vals, onafhankelijk van **p**

**Eventualiteit** 

Een propositie die geen tautologie of contradictie is Bijv. **¬p** kan waar of vals zijn, afhankelijk van **p**



### Logische equivalentie

<img src="img/image-20211230123148202.png" alt="image-20211230123148202" style="zoom:33%;" /> 



## Boole algebras

Bij alle oefeningen hierover staat dat ze niet te kennen zijn dus ik ga dit effe overslaan



## Vereenvoudigen van logische uitdrukkingen

<img src="img/image-20211230133823555.png" alt="image-20211230133823555" style="zoom:33%;" /> 



## Predikatenlogica

<img src="img/image-20211230133950904.png" alt="image-20211230133950904" style="zoom:33%;" /> 

elke propositie is een predikaat, niet elk predikaat is een propositie



## Kwantificatie

<img src="img/image-20211230134111004.png" alt="image-20211230134111004" style="zoom:33%;" /> 

<img src="img/image-20211230134155097.png" alt="image-20211230134155097" style="zoom:33%;" /> 

<img src="img/image-20211230134212525.png" alt="image-20211230134212525" style="zoom:33%;" /> 

<img src="img/image-20211230134305035.png" alt="image-20211230134305035" style="zoom:33%;" /> 



## Bewijsstrategieën



### Inductie en deductie

**Deductieve redenering** (van groot naar klein)

Vanuit een algemene stelling komt men tot een meer specifiek besluit Bijvoorbeeld: Uit “Het is altijd mooi weer aan de zee” volgt “Het is morgen mooi weer aan de zee” 

**Inductieve redenering** (van klein naar groot)

Vanuit een of meerdere bijzonder gevallen trekt men algemene besluiten Bijvoorbeeld: Experimenten in de natuurkunde, scheikunde… leiden tot ‘wetmatigheden’

Eigenlijk is alleen deductie wiskundig correct



### Rechtstreeks bewijs

Te bewijzen: p ⇒ q

We zetten gewoon p om totdat we aan q komen



### Bewijs door gevallenonderzoek

We splitsen het probleem op in alle mogelijke gevallen 

<img src="img/image-20211230134722744.png" alt="image-20211230134722744" style="zoom:33%;" /> 

### Contrapositie

<img src="img/image-20211230134842479.png" alt="image-20211230134842479" style="zoom:33%;" /> 



### Bewijs uit het ongerijmde

<img src="img/image-20211230135037124.png" alt="image-20211230135037124" style="zoom:33%;" /> 



### Wiskundige inductie

<img src="img/image-20211230135304666.png" alt="image-20211230135304666" style="zoom:33%;" /> 





# To do

hammingafstand

private key encryptie

$\mathbb{Z}_n$ is een veld $\xleftrightarrow{}$ $n$ is priem



# Mogelijke examenvragen

(mijn persoonlijke mening en op basis van vorige examens)

* H1
  * Theorie
    * Bewijzen (over)aftelbaarheid: Boek stelling 1.5 voor $\mathbb{R}$, pagina 19 voor $\mathbb{Q}$
  * Oefeningen
    * Bewijs dat $\sqrt{n}$ (ir)rationaal is. (Stelling 1.1 in het boek voor $\sqrt{2}$)
    * Iets creatiefs met kardinaliteit
    * Fundamentele stellen van de rekenkunde toepassen
    * Relaties toepassen (dus weten wanneer je welke hebt)
* H2
  * Theorie
    * Bewijs (stelling 2.13): Als $ggd(a,n) = 1$ bestaat er 1 getal $x$ waarvoor: $a.x\stackrel{n}{=} 1 \stackrel{n}{=} x.a$
    * Bewijs (stelling 2.15): Voor positief getal $a$ en priemgetal $p$: $a^p \stackrel{p}{=} a$ (gebruik fermat)
    * Bewijs (stelling 2.17): Het aantal oplossingen x ∈ {0, 1, 2, . . . , n − 1} van de lineaire congruentie $a.x \stackrel{n}{=} b$
    * Bewijs (stelling 2.18): Oplossing lineaire diomfantische vergelijking.
    * Bewijs (stelling 2.19):  Chinese reststelling
  * Oefeningen
    * Periode pseudorandomgenerator
    * Stelsel van lineaire conguenties oplossen (chinese reststelling)
    * Lineaire diomfantische vergelijking oplossen (sowieso iets met briefjes en muntjes ofzo)
    * Kleine stelling van Fermat toepassen
* H3
  * Theorie
    * Bewijs (3.1): $\mathbb{Z}_n$ is een veld $\xLeftrightarrow{}$ $n$ is priem 
    * Bewijs (3.5): Alternatieve Rabin test (telt dit als een bewijs?)
  * Oefeningen
    * Aantonen dat (voortbrengende) veelterm irreduciebel is in een Galoisveld
    * Bewerkingen in Galoisvelden
    * Zech-log tabel opstellen voor Galoisveld met gegeven voortbrengende veelterm
    * Iets met BCH of Hamming afstand
* H4
  * Theorie
    * Al die benamingen goed kennen (predikaat, propositie, tautologie, conjunctie, ...)
  * Oefeningen
    * Logische uitdrukking vereenvoudigen (precedentieregels goed kennen)
    * Bewijsstrategieën toepassen





# Examen

Hier wat dingen die ik zeker wil onthouden voor het examen.



## Lineaire congruenties oplossen

$a.x \stackrel{n}{=} b$

* Kijk of je a, b of n kan delen door een gemeenschappelijke deler
* Zoek de ggd(a, n), als je b daar niet door kan delen houdt het verhaal op en zijn er geen oplossingen
* Je hebt nu al de ggd(a, n) gezeocht, nu kan je de bezoutcoefficienten gebruiken om de inverse van a te berekenen en beide leden ermee te vermenigvuldigen. Bada bing bada boom opgelost.

## Stelsels van lineaire congruenties oplossen

<img src="img/image-20211230110054684.png" alt="image-20211230110054684" style="zoom:33%;" />

<img src="img/image-20211230110114139.png" alt="image-20211230110114139" style="zoom:33%;" />

## Diofantische vergelijkingen oplossen

$a.x + b.y = c$

* Ggd(a, b) = deler van c: herleid
* Ggd(a, b) = geen deler van c: geen oplossingen
* Ggd(a, b) = 1: oneindig veel oplossingen

Dan kan je omzetten naar $a.x \stackrel{n}{=} b$, deze oplossen naar $x$ en invullen in de originele vergelijking (niet vergeten dat de oplossing van de lineaire congruentie $x + t.n$ is)



## Bewijzen

<img src="img/image-20220126215912865.png" alt="image-20220126215912865" style="zoom: 33%;" />

---

<img src="img/image-20220126220014423.png" alt="image-20220126220014423" style="zoom:33%;" />

---

<img src="img/image-20220126220148678.png" alt="image-20220126220148678" style="zoom:33%;" />

1. constructie oplossing
2. oplossing is uniek

---

<img src="img/image-20220126220223287.png" alt="image-20220126220223287" style="zoom:33%;" />

---

<img src="img/image-20220126220255138.png" alt="image-20220126220255138" style="zoom:33%;" />



## Vanbuiten leren

Deductieve redenering

```
van algemene stelling -> kleiner #ok
```

<details><summary>Antwoord</summary><small>Vanuit een algemene stelling komt men tot een meer specifiek besluit
Bijvoorbeeld:
Uit “Het is altijd mooi weer aan de zee” volgt “Het is morgen mooi weer aan de zee”</small></details>

Inductieve redenering

```
van beperkte voorbeelden veralgemenen #ok
```

<details><summary>Antwoord</summary><small>Vanuit een of meerdere bijzonder gevallen trekt men algemene besluiten
Bijvoorbeeld:
Experimenten in de natuurkunde, scheikunde… leiden tot ‘wetmatigheden’</small></details>

Eigenschappen partiele orderelatie

```
transitief, reflexief, symmetrie #nok
# antisymmetrie als x -> y en y -> x dan x = y
```

<details><summary>Antwoord</summary><small>reflexifiteit, anti-symmetrie, transitiviteit</small></details>

Eigenschappen equivalentierelatie

```
transitief, reflexief, symmetrisch #ok
```

<details><summary>Antwoord</summary><small>reflexief, symmetrie, transitief</small></details>

Eigenschappen totale orderelatie

```
partiele + als x,y in R, x -> y, of y->x #nok
```

<details><summary>Antwoord</summary><small>partiele orderelatie + voor alle x en y is er in een richting een pijl</small></details>

Strikte orderelatie

``` 
(x,x) valt weg #antireflexief # nok
```

<details><summary>Antwoord</summary><small>antireflexief -> (x,x) valt weg</small></details>

Verschil functie totale functie, afbeelding, partiele functie

```
functie -> uit elke vertrekt hoogstens 1 #nok
totale -> uit elke exact 1 = afbeelding
# partiele functie -> niet uit elk element 1 pijl (maar wel nog steeds functie) 
```

<details><summary>Antwoord</summary><small>functie: uit elk element ten hoogste 1 pijl<br>
  totale functie/afbeelding: uit elk element exact 1 pijl<br>
  partiele functie: niet uit elk element 1 pijl</small></details>

Surjectie, injectie, bijectie

```
surjectie -> in elke komt minstens 1 toe #ok
injecti -> in elke komt hoogstens 1 toe
bijectie -> totale functie die injectief en surjectief is (1 op 1)
```

<details><summary>Antwoord</summary><small>surjectie: in elk element komt minstens 1 pijl toe<br>
  injectie: in elk element komt hoogstens 1 pijl toe<br>
  bijectie: totale functie die injectief en surjectief is (1 op 1)</small></details>

# Python oefeningen

## H2

### Oef 2

```python
import math
n=int(input("Geef n:"))

getallen = [i for i in range(0,n)]

grens = int(math.sqrt(n))
k = 2
p = getallen[k]
while p <= grens:
    for i in range(2*p,n,p):        
        getallen[i] = -1    
    k +=1
    while getallen[k] ==  -1:
        k +=1
    p = getallen[k]
priem = [g for g in getallen if g!=-1]
priem = priem[2:]
print(priem)
print("grootste is ", priem[-1])


```

### Oef 3

```python
n = int(input("n="))
p = 2
while n!=1:
    if n%p == 0:
       print(p, end=" ")
       n = n//p  #gehele deling
    else:
        p +=1
        
```

### Oef 6

```python
n = 100000
#eerste manier is de juiste, want heel weinig berekeningen
deler = 5
tel = 0
while deler<=n:
    aantal = n//deler  #aantal getallen deelbaar door deler
    tel += aantal
    deler *=5
print(str(n)+"!", "heeft",tel,"nullen achteraan" )

#tweede manier - minder snel
tel5 = 0
for g in range(1, n+1):
    k = g
    #tel hoeveel keer dit getal deelbaar is door 5
    while k%5 == 0:
        tel5 +=1
        k=k/5
print ("factor 5 komt ",tel5," keer")

#derde manier berekent eerst de faculteit als groot getal
fac=1
for g in range(1, n+1):
    fac *=g
facs = str(fac) #zet om naar string
tel0 = 0
p = len(facs)-1
while facs[p]=='0':
    tel0 +=1
    p -=1
print(str(n)+"!", "heeft",tel0,"nullen achteraan")
```

### Oef 7

```python
def priemontbinding(n:int) ->list:
    delers = []
    for p in range(2, n//2+1):
        while n%p == 0 :
            delers.append(p)
            n //=p
    return delers

def teldelers_priem(n: int) -> int:
    delers = priemontbinding(n)    
    pmachten ={} #dictionary
    for d in delers:
        pmachten[d] = delers.count(d)
    prod = 1
    for v in pmachten.values():
        prod *= (v+1)
    return prod

n = 10*10*10*10*10
print("priemontbinding:", priemontbinding(n))
print("teldelers via priemontbinding:", teldelers_priem(n))

#Slecht alternatief: delers opsommen
def teldelers(n:int )->int:
    tel = 1 #n is deler van zichzelf
    
    for d in range(1, n//2+1):
        if n%d ==0:
            tel += 1
    return tel 


print("\nTellen is niet echt efficient, maar wel correct:")
print(n,"heeft", teldelers(n), "delers")

```

### Oef 11

```python
#a en b worden verondersteld positief te zijn
def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1

#tweede methode - direct q keer aftrekken zoals je op papier zou doen
def euclid2(a:int , b:int ) -> int:
        u_1 = 1
        v_1 = 0
        u_2 = 0
        v_2 = 1
        while min(a,b) !=0:
            if a > b:
                q = a//b
                a -= q*b
                u_1 -= q*u_2
                v_1 -= q*v_2
            else:
                q = b//a
                b -= q*a
                u_2 -= q*u_1
                v_2 -= q*v_1
        #hier moet je zorgen dat je de juiste waarden teruggeeft - extra controle nodig!
        if a==0:
            return b, u_2,v_2
        return a, u_1,v_1   
    
#a = int(input("a="))
#b = int(input("b="))
a= 255
b= 1025
a=100007
b=100000007
a=3
b=17
ggd, u, v = euclid(a,b)
print(f"{ggd} = {u}*{a} + {v}*{b} = {u*a+v*b}")

ggd, u, v = euclid2(a,b)
print(f"{ggd} = {u}*{a} + {v}*{b} = {u*a+v*b}")

```

### Oef 10

```python
def ggd(a:int , b:int ) -> int:
    while a != b:
        if a > b:
            a -= b
        else:
            b -= a                
    return a

def ggd_recursief(a:int , b:int ) -> int:
    if a > b:
        return ggd_recursief(a-b,b)
    elif a<b:
        return ggd_recursief(a, b-a)      
    return a

def ggd2(a:int , b:int ) -> int:
    while b !=0:
        q = a//b
        r = a - q*b
        a = b
        b = r
    return a

def ggd2_recursief(a:int , b:int ) -> int:
    if b !=0:
        q = a//b
        r = a - q*b
        return ggd2_recursief(b,r)
    return a


#a = int(input("a="))
#b = int(input("b="))
a=336
b= 1768
print(f"ggd({a},{b})={ggd(a,b)}")
print(f"ggd({a},{b})={ggd_recursief(a,b)}")

print(f"ggd({a},{b})={ggd2(a,b)}")
print(f"ggd({a},{b})={ggd2_recursief(a,b)}")
```

### oef 12 

```python
n = 2020
t1 = n//4 #aantal keer deelbaar door 4
t2 = n//100 #aantal keer deelbaar door 100
t3 = n//400 #aantal keer deelbaar door 400
totaal = t1 - t2 + t3
print("aantal schrikkeljaren:",totaal)

gem = (n*365 + totaal)/n
print(f'gemiddelde lengte {gem:.3f}')

tel=0
for jaar in range(1,n+1):
    if jaar%4 == 0:
        if jaar%100 != 0 or jaar%400 ==0:
            tel+=1
print("controle",tel)
```

### oef 13

```python
def periode(a:int, m:int, c:int, x0:int)->int:
   getallen=[x0%m]
   x = (a*x0 + c) % m
   while not (x in getallen):
      getallen.append(x)
      x = (a*x + c) % m
   #print("x=",x)
   #print(getallen)
   periode = len(getallen) - getallen.index(x) 
   return periode

# SNELLERE VERSIE (dictionary)
def periode2(a:int, m:int, c:int, x0:int)->int:
   getallen={x0%m:0}
   x = (a*x0 + c) % m
   i = 1
   while not (x in getallen):
      getallen[x] = i
      x = (a*x + c) % m
      i+=1
   #print("x=",x)
   #print(getallen)
   periode = i - getallen[x] 
   return periode


a = 5 #periode is 3 enkel xO, 3 en 8 worden gegenereerd
#a = 2 # periode is 5 enkel x0,3,9,1,5 worden gegenereerd 
c = 3 #ggd(c,m)=1 is goede keuze
m = 10000

x0 = 2
p = periode(a, m, c, x0)
print(f"a = {a}, m = {m} , c = {c} , x0 = {x0} -> periode = {p}")

a = 11 # a-1 is deelbaar door 2 en 5 de priemfactoren van 10
p = periode2(a, m, c, x0)
print(f"a = {a}, m = {m} , c = {c} , x0 = {x0} -> periode = {p}")

a=2
m=8
c=4
x0=3
p = periode2(a, m, c, x0)
print(f"a = {a}, m = {m} , c = {c} , x0 = {x0} -> periode = {p}")

```

### oef 14

```python
def periode(a:int, m:int, c:int, x0:int)->int:
   getallen=[x0%m]
   x = (a*x0 + c) % m
   while not (x in getallen):
      getallen.append(x)
      x = (a*x + c) % m
   periode = len(getallen) - getallen.index(x) 
   return periode

def periode2(a:int, m:int, c:int, x0:int)->int:
   getallen = {x0%m: 0}
   x = (a*x0 + c) % m
   i = 1
   while not (x in getallen):
      getallen[x] = i
      x = (a*x + c) % m
      i += 1
   periode = i - getallen[x]
   return periode

a = 3 #ggd(a,m)= 1 
m = 20 

periodes =[]
for c in range(m):
    for x0 in range(m): 
        p = periode(a, m, c, x0)
        if periodes.count(p)==0:
            periodes.append(p)
            print("periode is",p, "voor c =",c,"en x0 =",x0)
```

### Oef 15

```python
#controleer of je alle getallen kan genereren met de formule
def periode1(a:int, m:int, c:int, x0:int)->int:
   getallen=[x0%m]
   x = (a*x0 + c) % m
   while not (x in getallen):
      getallen.append(x)
      x = (a*x + c) % m
   periode = len(getallen) - getallen.index(x) 
   return periode

def periode(a:int, m:int, c:int, x0:int)->int:
   getallen = {x0%m: 0}
   x = (a*x0 + c) % m
   i = 1
   while not (x in getallen):
      getallen[x] = i
      x = (a*x + c) % m
      i += 1
   periode = i - getallen[x]
   return periode

def generator(a:int, m:int) -> bool:
    x = a
    k = 1
    while x!=1:
        k+=1
        x = x*a % m
    return k==(m-1)


#Lehmer stelling 2.11
m = 19
m = 1013
m = 7001 
m = 99971 
m = 2**31 - 1

c = 0
x0 = int(input("geef x0:"))
while x0%m==0:
    x0 = int(input("Foute startwaarde - geef x0:"))

#zoek een generator
for a in range(2,m): #a=1 is niet zinvol als c=0
    print ('a=',a)
    if generator(a,m):
        print(a," -> goede generator voor m =", m)
        break

#zoek de periode
for a in range(2,m): #a=1 is niet zinvol als c=0
    p = periode(a, m, 0, x0)  #c=0  
    print("a =",a,"-> de periode is",p)
    if p==m-1:
        print(" -> goede generator voor m =", m)
        break
    

```

### Oef 16

```python
#controleer Lehmer voor 2^5 stelling 2.10 
def periode(a:int, m:int, c:int, x0:int)->int:
   getallen=[x0%m]
   x = (a*x0 + c) % m
   while not (x in getallen):
      getallen.append(x)
      x = (a*x + c) % m
   periode = len(getallen) - getallen.index(x) 
   return periode

k = int(input("k="))
m = 2**k

print("m = ", m, "periode =?",m//4)
x0 = int(input("geef x0:"))

maxperiode = 1   
for a in range(2,m): #a=1 is niet zinvol als c=0
    p = periode(a, m, 0, x0)  #c=0 
    if p > maxperiode:
        maxperiode = p        

print("m =",m,"-> de maximale periode is",maxperiode)
    
        
```

### Oef 17

```python
#controleer de voorwaarden van Hull-Dobell en ga na dat de periode exact m is
#Hull-Dobell 
def periode(a:int, m:int, c:int, x0:int)->int:
   getallen=[x0%m]
   x = (a*x0 + c) % m
   while not (x in getallen):
      getallen.append(x)
      x = (a*x + c) % m
   periode = len(getallen) - getallen.index(x) 
   return periode

def ggd(a:int , b:int ) -> int:
    while b !=0:
        q = a//b
        r = a - q*b
        a = b
        b = r
    return a

def priemdelers(n:int) ->list:
    delers = set() #set gebruikt, elke deler 1 keer
    for p in range(2, n//2+1):
        while n%p == 0 :
            delers.add(p)
            n //=p
    return delers

c = int(input("c="))
m = int(input("m="))
a = int(input("a="))

ok = c!=0
print("\nc =",c,"niet gelijk aan 0")

gd = ggd(m,c)
ok = ok and (gd==1)
print("ggd(m,c) =", gd)

priemen = priemdelers(m)
print("m =", m, "heeft priemdelers", priemen)

if m%4 == 0:
    priemen.add(4)  #moet ook gecontroleerd worden
    
for p in priemen:
    if (a-1) % p == 0:
        print("\ta-1 is deelbaar door", p)
    else:
        print("\ta-1 is NIET deelbaar door", p)
        ok = False
    
if ok:
    print("\nalle voorwaarden zijn voldaan")
else:
    print("\nniet alle voorwaarden zijn voldaan")       

p = periode(a, m, c, 0)  #x0=0

if p==m:
    print("periode is",m,"-> maximaal")
else:
    print("periode is", m, "niet maximaal")

```

### Oef 18

```python
#controleer of je alle getallen kan genereren met de formule
#Hull-Dobell speciaal
def periode(a:int, m:int, c:int, x0:int)->int:
    getallen=[x0%m]
    x = (a*x0 + c) % m
    while not (x in getallen):
       getallen.append(x)
       x = (a*x + c) % m
    periode = len(getallen) - getallen.index(x) 
    return periode

k = int(input("k ="))
m = 2**k
l = int(input("l ="))
a = 2**l+1 # a-1 is deelbaar door alle delers van m is oke
c = int(input("c ="))

print("m=",m,"a=",  a)
ok = c!=0 and c%2 != 0

if ok:
    print("voorwaarde op c is voldaan: c is niet 0 en ggd(c,m)=1")

if k>= 2: #m is deelbaar door 4
    if l<2:
        print("voorwaarde 4 | a niet voldaan")
        ok = False
if ok:
    print("Alle voorwaarden voldaan - periode is ", m)

p = periode(a, m, c, 0) #x0 = 0
print("periode is",p)

```

### Oef 20

```python
#ggd m en a en inverse van a tov m
def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1


print("bepaal de inverse van a modulo m:")
m = int(input("m = "))
a = int(input("a = "))
d, u, v = euclid(a,m)  
print(f"ggd({a},{m}) = {d}")
if d==1 :
    #print("ggd(a,m) =",d)
    inverse = u % m #verklein tot getal in Zm
    print(f"inverse van {a} is {inverse}")
    controle = (a*inverse)%m
    print(f"controle: {a} . {inverse} = {controle}")
else:
    print("inverse bestaat niet")    

```

### Oef 21

```python
def inverse_kandidaat(a:int , m:int) -> int :
    macht = 1
    for i in range(m-2):
        macht = (macht *a)% m
    return macht

print("bepaal de inverse van a modulo m:")
m = int(input("m = "))
a = int(input("a = "))
inverse = inverse_kandidaat(a,m)

if (a*inverse)%m==1 :
    print(f"inverse van {a} is {inverse}")   
else:
    print("inverse kan niet bepaald worden met Fermat") 
```

### Oef 22

```python
def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1

def congruentie(a: int, b:int, n: int) : 
    a = a%n  #maak positief
    b = b%n 
    print(f'{a}x = {b} mod {n}')
    d, u, v  = euclid(a,n)  
    print(f'ggd(a,n) = {d}')
    if d==1 :
        inverse = u%n
        xo = (b * inverse)%n #basisoplossing
        print(f'Alle oplossingen x = {xo} + {n}t, t in Z')
        print(f'Controle: a*xo = {a*xo} = {b} mod {n}')
    else:
        if b%d != 0:
            print("geen oplossing")
        else:
            print("ggd = ",d," deler van",b)
            a_r = a//d
            n_r = n//d
            b_r = b//d
            print(f"gereduceerd n = {n_r} , a = {a_r} , b = {b_r}")
            congruentie(a_r, b_r, n_r)

print("Los de vergelijking a*x = b mod n op.")
n = int(input("n = "))
a = int(input("a = "))
b = int(input("b = "))
congruentie(a, b, n)
```

### Oef 24

```python
# diofantische vergelijkingen 
#Gebruik uitgebreid algoritme van Euclides
#geeft (d, u, v)  terug met d = ggd(a,b) = u.a+v.b
#veronderstelt dat a en b positief zijn
def euclid(a:int , b:int ) -> tuple:
    a = a%b #maak positief
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1  
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1   
    return a, u_1, v_1

# Methode 1 uit syllabus
def diofantisch(a: int, b: int, c: int):
    d, u, v = euclid(abs(a), abs(b)) #positieve getallen
    
    if c%d != 0:
        print("geen oplossingen want ggd = ",d, "en dit is geen deler van ",c)
    else:
        a_r = a//d  #reduceer
        b_r = b//d
        c_r = c//d
        if a<0:
            u = -u #enkel u hebben we nog nodig    
        x0 = u*c_r % abs(b_r) #in {0,1,...,b_r-1}
        y0 = (c_r - a_r*x0)//b_r 
        print(f'ggd = {d} : (x0, y0) = ({x0}, {y0})')
        print(f'Alle oplossingen: ({x0} + {b_r}.t , {y0} - {a_r}.t)')

# Methode 2 uit theorieles
def diofantisch_2(a: int, b: int, c: int):
    #gebruikt _ indien de variabele niet meer gebruikt wordt
    d, _, _ = euclid(abs(a), abs(b)) #positieve getallen  
    if c%d != 0:
        print("geen oplossingen want ggd = ",d, "en dit is geen deler van ",c)
    else:
        a = a//d  #reduceer
        b = b//d
        c = c//d
        d, u, _ = euclid(a % abs(b), abs(b)) #positieve getallen
        x_0 = (c * u) % abs(b)   # congruentie oplossen geeft x_0
        x_t = abs(b)             # x_0 + x_t * t, t in Z
        y_0 = (c - a*x_0) // b   # substitueer x_0 in de diofantische vergelijking en los op naar y_0
        y_t = - a * abs(b) // b  # y_0 + y_t * t, t in Z
        print(f'ggd = {d} : (x0, y0) = ({x_0}, {y_0})')
        print(f'Alle oplossingen: ({x_0} + {x_t}.t , {y_0} + {y_t}.t)')

print("Los de diofantische vergelijking a*x + by = c op.")
a = int(input("a = "))
b = int(input("b = "))
c = int(input("c = "))
diofantisch(a,b,c)
diofantisch_2(a,b,c)
```



### Oef 28

```python
def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1

#Bereken de inverse modulo m - werp fout op als de inverse niet bestaat
def inverse(getal: int, m:int)-> int:
    d, u, v = euclid(getal,m)
    if d==1 :
        return u % m
    else:
        raise Exception("inverse bestaat niet")    

def reduceer(a: int, b: int, m: int) -> tuple:
    d, u, v  = euclid(a,m)  
    print(f'{a} = {b} mod {m}  met ggd({a},{m})={d}')
    inverse = u%m 
    if d==1 :
        b = (b * inverse)%m
        return 1,b,m
    if b%d == 0:              
        return reduceer(a//d, b//d, m//d)
    raise Exception("lukt niet")

def leesvergelijking() -> tuple:  
    lijn = input("Vergelijking a*x = b mod m  - geef a b en m gescheiden door spatie:")
    getallen = lijn.split()
    if len(getallen)==3:
        a = int(getallen[0])
        b = int(getallen[1])
        m = int(getallen[2])     
        if m<0:
            a, b, m = -a, -b, -m
        return a%m,b%m,m  #alle getallen zijn nu positief
    else:
        print("Fout!")
        return leesvergelijking()

def checkvoorwaarden(m: list)->bool:
    for i in range(len(m)):       
        if m[i]==0:  #reductie niet gelukt
            return False 
    for i in range(len(m)):
        for j in range(len(m)):
            if i!=j:
                r,u,v = euclid(m[i],m[j])
                if r!= 1:
                    print(f'{m[i]} en {m[j]} zijn niet onderling ondeelbaar')
                    return False
    
    return True

#Bereken een oplossing x0
def oplossing(m:tuple, rm:tuple, M:int)->int:    
    g = 0
    for i in range(len(m)):        
        Mi = M//m[i]
        yi = inverse(Mi,m[i])
        g += rm[i]*Mi*yi
    return g%M

n = int(input("aantal vergelijkingen:"))
a = [0] *n
b = [0] *n
m = [0] *n
for i in range(n):
   a[i],b[i],m[i] = leesvergelijking()
   print(f'{a[i]} = {b[i]} mod {m[i]}')

#deep copy voor controle op het einde
a_o = a[:]
b_o = b[:]
m_o = m[:]

print("\nNa reductie:")
check = True
for i in range(len(a)):
    try:
        a[i],b[i],m[i] = reduceer(a[i],b[i],m[i])
        print(f'{a[i]}.x = {b[i]} mod {m[i]} \n')
    except Exception:
        print(f'{a[i]}.x = {b[i]} mod {m[i]} is niet oplosbaar\n')
        check = False #kan niet opgelost worden

if check:
    if checkvoorwaarden(m):
        M = 1
        for mi in m:
            M *= mi
        x0 = oplossing(m, b, M)
        print(f'Oplossingen: x = {x0} + t . {M}' )
        print(f'Controle van {x0} met originele vergelijkingen')
        for i in range(len(m_o)):
            print(f'\t a.x = b mod m: {a_o[i]} * {x0} = {b_o[i]} mod {m_o[i]} : {(a_o[i]*x0)%m_o[i]} == {b_o[i]}')
    else:
        print("Geen oplossing gevonden. Stel zelf een nieuw stelsel op met de bovenstaande opmerkingen")
   
else:
    print('Er zijn geen oplossingen!')
```

### Oef 30

```python
def leesvergelijking() -> tuple:  
    lijn = input("Vergelijking a*x = b mod m  - geef a b en m gescheiden door spatie:")
    getallen = lijn.split()
    if len(getallen)==3:
        a = int(getallen[0])
        b = int(getallen[1])
        m = int(getallen[2])     
        if m<0:
            a, b, m = -a, -b, -m
        return a%m,b%m,m  #alle getallen zijn nu positief
    else:
        print("Fout!")
        return leesvergelijking()

def ontbind(n:int) ->list:
    parts = []
    p = 2
    q = 1
    while n !=1:
        if n%p == 0:
            q = q*p
            n = n/p
        else:
            if q>1:
                parts.append(q)
                q=1
            p+= 1
    if q>1:
        parts.append(q)
    return parts

print("geef de vergelijking die moet opgesplitst worden")
a,b,m = leesvergelijking()

parts = ontbind(m) #ontbindt  m in product van priemmachten
print("\nSplits op in volgende vergelijkingen")
for priemmacht in parts:
    print(f'{a%priemmacht}x = {b%priemmacht} mod {priemmacht}')
```

### Oef 39

```python
def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1

#Bereken de inverse modulo m - werp fout op als de inverse niet bestaat
def inverse(getal: int, m:int)-> int:
    d, u, v = euclid(getal,m)
    if d==1 :
        return u % m
    else:
        raise Exception("inverse bestaat niet")    

def residu(a:int, m: list)->list:
    r = [0] * len(m)
    for i in range(len(m)):
       r[i] = a % m[i]
    
    return r

#Bereken een oplossing x0
def oplossing(m:tuple, rm:tuple, M:int)->int:    
    g = 0
    for i in range(len(m)):        
        Mi = M//m[i]
        yi = inverse(Mi,m[i])
        g += rm[i]*Mi*yi
    return g%M

a = 123456
b = 654321
m = [99,97,95,94]
M = 1
for mi in m:
    M *= mi
print("Max = ",M)

am =residu(a,m)
bm = residu(b,m)
print(oplossing(m,am,M),":",am)
print(oplossing(m,bm,M),":",bm)

som = [(am[i]+bm[i])%m[i] for i in range(len(m))]
print("som =",som,":", oplossing(m,som,M))
#terugrekenen zie oefening 28

print("\nControle:",a,"+",b,"=",a+b)
print()
print(f'M/a={M/a:0.2f} >? {b} : {M/a > b}')

print("controleer dat het product niet kan berekend worden:")
prod = [(am[i]*bm[i])%m[i] for i in range(len(m))]
print("prod =",prod,":", oplossing(m,prod,M))
#terugrekenen met oefening 28

print("\nControle: a*b=",a,"*",b,"=",a*b,">" ,M)
print("Merk op: (a*b) % M =", (a*b)%M)


```



### Oef 41

```python
#Caesar’s encryptie
import string
def codeer(zin: string, k: int)->string:
    code = ""
    for letter in zin:
        if letter in string.ascii_lowercase:
            n = ord(letter) - ord('a')
            fn = (n+k)%26
            letter = chr(ord('a') + fn)
        code += letter
    return(code)

zin = "om negen uur in het park"

print(codeer(zin,2))
```



### Oef 41b

```python
#Caesar’s encryptie - omgekeerd
import string

def decodeer(zin:string):
    for k in range(1,26):
        cod = ""

        for letter in zin:
            if letter in string.ascii_lowercase:
                n = ord(letter) - ord('a')
                fn = (n-k)%26
                letter = chr(ord('a') + fn)
            cod += letter

        print(k,":",cod)

zin = "gpshfu ju"
decodeer(zin)
```



### Oef 42

```python
import math

def ggd(a:int , b:int ) -> int:
    while a != b:  
        if a > b:
            a -= b
        else:
            b -= a                
    return a

def euclid(a:int , b:int ) -> tuple:
    u_1 = 1
    v_1 = 0
    u_2 = 0
    v_2 = 1
    
    while a != b:  
        if a > b:
            a -= b
            u_1 -= u_2
            v_1 -= v_2
        else:
            b -= a
            u_2 -= u_1
            v_2 -= v_1
            
    return a, u_1, v_1

def codeer(boodschap:int, sleutel:tuple) -> int:
    C=1
    n, e = sleutel
    
    for i in range(e):
        C = (C*boodschap) % n  #gebruik geen **
    return C


def decodeer(boodschap:int, inverse:int, sleutel:tuple)->int:
    D = 1
    n, e = sleutel    
    for i in range(inverse):
        D = (D*boodschap) % n #gebruik geen **
    return D


N=int(input("N="))


getallen = [i for i in range(0,N)]

grens = int(math.sqrt(N))
k = 2
p = getallen[k]
while p <= grens:
    for i in range(2*p,N,p):
        
        getallen[i] = -1    
    k +=1
    while getallen[k] ==  -1:
        k +=1
    p = getallen[k]
priem = [g  for g in getallen if g!=-1]
priem = priem[-2:]

print(priem)
m =(priem[0]-1)*(priem[1]-1)

e=2
while ggd(e,m) != 1:
    e+=1

n= priem[0]*priem[1]
print(f'publieke sleutel: ({n}, {e})') 

letter = input("Geef letter:")
code = ord(letter)
C = codeer(code,(n,e))

ggd,u,v = euclid(e,m) #kennis van  m nodig
d = u%m #inverse
#print(f'{e}.{d}={e*d%m}')

D = decodeer(C,d,(n,e))
print("gedecodeerd:", chr(D))
```



## H3

### Oef 6

```python
p = 7 #rekenen in het veld Zp

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
    return s

def reken(v:list, g:int)->int:
    s=0
    for c in v:
        s = (s*g + c)%p
    return s

def getnulpunt(v:list) -> int:
    for g in range(p):
        if reken(v,g)==0:
            return g            
    return -1 #geen nulpunt gevonden

v = [3,7,4,2]
print(f"v = {veelterm(v)} in Z_{p}[x]")

print(f"v(3) = {reken(v,3)} in Z_{p}")

g=getnulpunt(v)
print(f"heeft nulpunt {g} in Z_{p}")

print()
p=3
v=[1,1,0,2,2,2,2]
print(f"v = {veelterm(v)} in Z_{p}[x]")
g=getnulpunt(v)
print(f"heeft nulpunt {g} in Z_{p}")

```



### Oef 7

```python
#veelterm over F2 - list bevat enkel de machten die voorkomen
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    res=""
    for m in sorted(v, reverse=True):
        if m>1:
            res +="x^"+str(m)+" + "
        elif m==1:
               res += "x" +" + "
        else:
            res +="1"+" + "
        
    return res[:-3]    

def reken(v:list, g:int)->int:
    gr = max(v) #hoogste graad
    s = 0
    for i in range(gr+1,-1,-1):
        if i in v:
            s = (s*g + 1)%2
        else:
            s = (s*g)%2   
           
    return s

def getnulpunt(v:list) -> int:
    for g in range(2):
        if reken(v,g)==0:
            return g
    return -1 #geen nulpunt gevonden


v = [16,3,7,0]
print("v=", veelterm(v))

print("v(1)=", reken(v,1))

print("Nulpunt van v is", getnulpunt(v))

```

### Oef 8

```python
p = 7 #rekenen in Zp
def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      


def reken(v:list, g:int)->int:
    s=0
    for c in v:
        s = (s*g + c)%p
    return s

def getnulpunt(v:list) -> int:
    for g in range(p): 
        if reken(v,g)==0:
            return g
    return -1 #geen nulpunt gevonden

print(f"{[2,6,-1]} + {[5,2,1,-2]} = {plus([2,6,-1], [5,2,1,-2])} in Z_{p}")

print(f"{[2,6,-1,2]} + {[5,2,1,-2]} = {plus([2,6,-1,2], [5,2,1,-2])} in Z_{p}")

print(f"{[2,6,-1]} . (-5) = {factor(-5,[2,6,-1])} in Z_{p}")

print(f"{[2,6,-1,5]} . x^5 = {maalx(5,[2,6,-1,5])} in Z_{p}")

print(f"{[1,0,0,0,1]} . {[1,2,1]} = {maal([1,0,0,0,1],[1,2,1])} in Z_{p}")

#extra oefeningen toegevoegd
p=2
print(f"{[1,0,0,0,1,1,0]} . {[1,0,1]} = {maal([1,0,0,0,1,1,0],[1,0,1])} in Z_{p}")

p=5
v=[1,-1,1,-2,-2,2]
print(f'\n {veelterm(v)}', end=' ')
g=getnulpunt(v)
if g!=-1:
    print(f"heeft nulpunt {g} in Z_{p}")
else:
    print(f"heeft geen nulpunt in Z_{p}")


f=[1,3,1,0,3]
f1=[1,4]

print(f'\n({veelterm(f)}) . ({veelterm(f1)}) = {veelterm(maal(f,f1))})')

g = getnulpunt(f)
if g!=-1:
    print(f'\n{veelterm(f)} heeft nulpunt {g} in Z_{p}')
else:
    print(f'\n{veelterm(f)} heeft geen nulpunt in Z_{p}')

f2=[1,1,1]
f3=[1,2,3]

print(f'\n({veelterm(f2)}) . ({veelterm(f3)}) = {veelterm(maal(f2,f3))}')

f = maal([1,1],[1,1])
g = maal(f,[1,1])
h = maal(g,[1,0,2])
#print(veelterm(h))

g = getnulpunt(h)
if g!=-1:
    print(f'\n{veelterm(h)} heeft nulpunt {g} in Z_{p}')
else:
    print(f'\n{veelterm(h)} heeft geen nulpunt in Z_{p}')

```



### Oef 9

```python
#veelterm over F2 - list bevat enkel de machten die voorkomen
#plus en min is hetzelfde in F2
def plus(v1:list, v2:list)-> list:
    som=[]
    for m in v1:
        if not m in v2:
            som.append(m)
    for m in v2:
        if not m in v1:
            som.append(m)
    return sorted(som)

#maal x^k
def maalx(k:int,v1:list)-> list:
    return [m+k for m in v1]

def maal (v1:list, v2:list)-> list:
    res = []
    h = v1[:]
    for i in range(max(v2)+1):
        if i in v2:
            res = plus(res,h)
        h = maalx(1,h)
    return sorted(res)
        
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    res=""
    for m in sorted(v, reverse=True):
        if m>1:
            res +="x^"+str(m)+" + "
        elif m==1:
               res += "x" +" + "
        else:
            res +="1"+" + "
        
    return res[:-3]    

def reken(v:list, g:int)->int:
    gr = max(v) #hoogste graad
    s = 0
    for i in range(gr+1,-1,-1):
        if i in v:
            s = (s*g + 1)%2
        else:
            s = (s*g)%2   
           
    return s

def getnulpunt(v:list) -> int:
    for g in range(2):
        if reken(v,g)==0:
            return g
    return -1 #geen nulpunt gevonden


print([2,6,1],"+", [5,2,1],"=",plus([2,6,1], [5,2,1]))

print([2,6,1,5],". x^","5", "=", maalx(5,[2,6,1,5]))

print([1,2,6],".",[0,2],"=",maal([1,2,6],[0,2]))



```



### Oef 11

```python
p = 2 #rekenen in Zp

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      


def reken(v:list, g:int)->int:
    s=0
    for c in v:
        s = (s*g + c)%p
    return s

def getnulpunt(v:list) -> int:
    for g in range(p): 
        if reken(v,g)==0:
            return g
    return -1 #geen nulpunt gevonden

p = int(input("Waarde voor priemgetal p:"))

print("graad 1")
prod = [1]
#maak alle monische veelterm van graad 1: x + c, met c in Zp
for c in range(p): 
    v = [1,c] 
    prod = maal(prod,v)
    
print(f'product van alle monische veeltermen van eerste graad in Z_{p} is {veelterm(prod)}')

#delers van 2 zijn 1 en 2
print("\ngraad2")
prod2 = prod[:]  #start met alle monische veeltermen van de eerste graad 

#maak alle monische veeltermen van graad 2: x^2 + c1 x + c2
for c1 in range(p):
    for c2 in range(p):
            v =[1,c1,c2]  #monische veelterm van tweede graad
            nulp = getnulpunt(v) #heeft deze veelterm een nulpunt?
            if nulp==-1:#irreducibel                
                prod2 = maal(prod2,v)
print(f'product van alle monische  irreduciebele veeltermen van graad | 2 in Z_{p} is {veelterm(prod2)}')

#delers van 3 zijn 1 en 3
print("\ngraad 3")
prod3 = prod[:] #start met alle monische veeltermen van de eerste graad 
#maak alle monische veeltermen van graad 3: x^3 + c1 x^2 + c2 x + c3
for c1 in range(p):
    for c2 in range(p):
        for c3 in range(p):
            v = [1,c1,c2,c3] #monische veelterm van derde graad
            nulp = getnulpunt(v) #heeft deze veelterm een nulpunt?
            if nulp==-1:  #irreduciebel
                prod3 = maal(prod3,v)
print(f'product van alle monische irreduciebele veeltermen van graad | 3 in Z_{p} is {veelterm(prod3)}')

```



### Oef 13

```python
p = 2 #rekenen in Zp

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      


def reken(v:list, g:int)->int:
    s=0
    for c in v:
        s = (s*g + c)%p
    return s

def getnulpunt(v:list) -> int:
    for g in range(p): 
        if reken(v,g)==0:
            return g
    return -1 #geen nulpunt gevonden

#nieuw
#zorg dat veelterm monisch wordt
def monic(h:list)->list:
    if h==[]:
        return h
    c = h[0]%p #hoogste graadscoeff
    #zoek de inverse
    inv=1
    while (c*inv)%p != 1:
        inv = (inv+1)%p
    return factor(inv, h)

#nieuw - v en deler zijn monische veeltermen
def euclides (v:list, deler:list)-> tuple:
    gr = len(v)-len(deler) #graad van het quotient
    q = [0]*(gr+1) #declareer list van juiste grootte - overal 0
    r = v[:]
    while len(r)>=len(deler):
        c = r[0] #bepaal coeff voor q - deler is monisch dus coeff is 1
        g = len(r) - len(deler)
        q[gr-g] = c
        v = factor(-c,maalx(g,deler))
        r = plus(r, v)
    return(q,r)

def lineaire_factoren(v:list):
    v = monic(v) #monisch maken
    print(f"\nAfsplitsen van lineaire factoren voor {veelterm(v)} in Z{p}")
    nulpunt = getnulpunt(v)
    while nulpunt>=0:
        print(f'{veelterm(v)} heeft nulpunt {nulpunt}')
        deler = [1,-nulpunt]
        q,r = euclides(v,deler)
        print(f'(x - {nulpunt}) . ({veelterm(q)})')
        v = q  
        nulpunt = getnulpunt(v)

#hulpprogramma om nulpunten te vinden en lineaire factoren af te splitsen - dus niet de volledige ontbinding!

p=2
#(a)
h=[1,0,0,0,1,1] #x^5+x+1
lineaire_factoren(h)


#(b)
h=[1,1,0,0,0,1] #x^5+x^4+1
lineaire_factoren(h)

p=3 
#(c)
h=[1,1,-1,-1,0,-1,-1]#x^6+x^5-x^4-x^3-x-1
lineaire_factoren(h)

p=5
#(d)
h = [1,2,-2,-1,-2,2] #x^5 + 2x^4 - 2x^3 - x^2 -2x +2  geeft weinig informatie
lineaire_factoren(h)

#(e)
h=[1,3,0,2,1,2]   #x^5+3x^4+2x^2+x+2
lineaire_factoren(h)

#h=[2,1,0,4,2,4]   #2x^5+x^4+4x^2+2x+4 - niet monisch
#lineaire_factoren(h)

#(f)
h = [1,-1,2,0,2,-1] #x^5 - x^4+2 x^3 +2x -1 geeft weinig informatie
lineaire_factoren(h)


```



### Oef 14

```python
#veeltermen in Zp
p = 5 #globale variabele

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      


def euclides (v:list, deler:list)-> tuple:
    gr = len(v)-len(deler) #graad van het quotient
    q = [0]*(gr+1) #declareer list van juiste grootte - overal 0
    r = v[:]
    while len(r)>=len(deler):
        c = r[0] #bepaal coeff voor q - deler is monisch dus coeff is 1
        g = len(r) - len(deler)
        q[gr-g] = c
        v = factor(-c,maalx(g,deler))
        r = plus(r, v)
    return(q,r)


#nieuw
#zorg dat veelterm monisch wordt
def monic(h:list)->list:
    if h==[]:
        return h
    c = h[0]%p #hoogste graadscoeff
    #zoek de inverse
    inv=1
    while (c*inv)%p != 1:
        inv = (inv+1)%p
    return factor(inv, h)

def ggd(v2:list, h:list) -> list:
    if (len(v2)<len(h)):
        v2,h = h,v2
    (q,r)=euclides(v2,h)
    while len(r)>1 :
        v2 = h
        h = monic(r)  #hoogstegraadscoefficient 1
        (q,r) = euclides(v2,h)
    if len(r)==0: #deelbaar
        return(h)
    return(monic(r))

#initaliseert x^m - x
def veelterm_macht(m: int)-> list :
  return [1] + [0]*(m-2)+[-1%p,0]

#zoekt deler van graad i voor h
def deler(i:int, h:list):
    h=monic(h)
    print("h(x)=",veelterm(h))
    m = p**i
    v2=veelterm_macht(m) #x^m - x
    r = ggd(v2,h)
    if len(r)==1:
        print("geen deler van graad",i)
        print("i =",i,"/ m =",m,"  -> ggd(",veelterm(h),",",veelterm(v2),") = 1")
    else:
        print("ggd(",veelterm(h),",",veelterm(v2),") = ",veelterm(r))
        print(f'product van alle delers van graad (|{i}) is',veelterm(r))
        print()
        
p=2
#(a)
h=[1,0,0,0,1,1] #x^5+x+1
deler(2,h)

#(b)
h=[1,1,0,0,0,1] #x^5+x^4+1
deler(2,h)

p=3 
#(c)
h=[1,1,-1,-1,0,-1,-1]#x^6+x^5-x^4-x^3-x-1
deler(2,h)

p=5
#(d)
h = [1,2,-2,-1,-2,2] #x^5 + 2x^4 - 2x^3 - x^2 -2x +2  geeft weinig informatie
h = [1,3,1,0,3]  # lineaire factor wegdelen -> x^4+ 3x^3+x^2+ 3
deler(2,h)

#(e)
h=[1,3,0,2,1,2]   #x^5+3x^4+2x^2+x+2
deler(2,h)

#(f)
h = [1,-1,2,0,2,-1] #x^5 - x^4+2 x^3 +2x -1 geeft weinig informatie
h = [1,1,4,3,3] # lineaire factor wegdelen -> x^4+x^3+ 4x^2+ 3x+ 3
deler(2,h)

#(g)
h=[1,-1,1,-2,-2,2] #x^5-x^4+x^3-2x^2-2x+2
deler(2,h)

#(h)
h = [1,-1,2,0,2,-1] #x^5-x^4+2x^3+2x-1 
deler(1,h)
```



### Oef 15

```python
#veeltermen in Zp
p = 5 #globale variabele

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      

def euclides (v:list, deler:list)-> tuple:
    gr = len(v)-len(deler) #graad van het quotient
    q = [0]*(gr+1) #declareer list van juiste grootte - overal 0
    r = v[:]
    while len(r)>=len(deler):
        c = r[0] #bepaal coeff voor q - deler is monisch dus coeff is 1
        g = len(r) - len(deler)
        q[gr-g] = c
        v = factor(-c,maalx(g,deler))
        r = plus(r, v)
    return(q,r)

#zorg dat veelterm monisch wordt
def monic(h:list)->list:
    if h==[]:
        return h
    c = h[0]%p #hoogste graadscoeff
    #zoek de inverse
    inv=1
    while (c*inv)%p != 1:
        inv = (inv+1)%p
    return factor(inv, h)

def ggd(v2:list, h:list) -> list:
    if (len(v2)<len(h)):
        v2,h = h,v2
    (q,r)=euclides(v2,h)
    while len(r)>1 :
        v2 = h
        h = monic(r)  #hoogstegraadscoefficient 1
        (q,r) = euclides(v2,h)    
    if len(r)==0: #deelbaar
        return(h)
    return(monic(r))

#nieuw
#bepaal de priemdelers van n
def prime(n:int)->list:
    pp=[]
    g = 2
    while n!=1:
        if n%g == 0:
            if pp.count(g)==0:
                pp.append(g)
            n //=g
        else:
            g+=1
    return pp

#initaliseert x^m - x
def veelterm_macht(m: int)-> list :
  return [1] + [0]*(m-2)+[-1%p,0]

def rabinstest(h:list):
    h=monic(h)
    n = len(h)-1 # graad van h
    print("\np =",p," en n =",n)
    irreducible=True
    for pr in prime(n):
        m = p**(n//pr)
        v2=veelterm_macht(m) #x^m - x
        r = ggd(v2,h)    
        if len(r)==1:
            print("priemdeler =",pr,"  -> ggd(",veelterm(h),",",veelterm(v2),") = 1")
        else:
            print("ggd(",veelterm(h),",",veelterm(v2),") = ",veelterm(r))
            print("vw niet ok voor priem =",pr)
            irreducible = False
            print(f'{veelterm(h)} is reducibel in Z_{p}')
            return

    if irreducible:
        macht = p**n
        v2=veelterm_macht(macht) #x^macht - x
        q,r = euclides(v2,h)
        if len(r)==0:
            print(f'{veelterm(h)} deelt {veelterm(v2)} want ggd = {veelterm(r)}')
            print(f'{veelterm(h)} is irreducibel in Z_{p}')
        else:
            print("is geen deler van",veelterm(v2))
            print(f'{veelterm(h)} is reducibel in Z_{p}')

#oefeningen 
#(a)
p=2 #modulo p rekenen
h=[1,0,1,1] 
rabinstest(h)

#(b)
p = 3 
h = [1,0,0,0,2,1]  #x^5 + 2x + 1 
rabinstest(h)
h = [1,1,1,1,1,2] #x^5 + x^4 + x^3 + x^2 + x + 2
rabinstest(h)

#(c)
p=7
h=[1,0,6,2]  #x^3 + 6x + 2
rabinstest(h)

#(d)
p = 5 
h = [1,4,0,4,3] #x^4 + 4 x^3 + 4x + 3
rabinstest(h)

#Voorbeeld theorie p 74
p=2 #modulo p rekenen
h=[1,0,0,1,0,0,1]  #x^6 + x^3 + 1 is irreducibel in Z2
rabinstest(h)

#voorbeeld theorie p 75
p=3
h=[2,0,0,1,2] #2x^4 + x + 2 is reducibel in Z3
rabinstest(h)

#Extra oefeningen 
p=3
h=[1,1,1,1,1,2] #x^5 + x^4 + x^3 + x^2 + x + 2 is niet irreduciebel in Z3
rabinstest(h)

p=5
h=[1,4,1,3,3,2] #x^5 + 4x^4 + x^3 + 3x^2 + 3x + 2 is reducibel in Z5 - oefening in hoofdstuk4
rabinstest(h)

p=19
h = [1,18,2] #x^2 + 18x + 2 is irreducibel in Z19
rabinstest(h)

p=17
h=[1,16,3] # x^2 + 16x + 3 is irreducibel in Z17
rabinstest(h)

```

### Oef 16

```python
#veeltermen in Zp
p = 5 #globale variabele

def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "x^"+str(gr) #hoogste graad
    elif gr==1:
        s += "x"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal x^k  in Zp
def maalx(k:int, v1:list)-> list:
    return v1 + [0]*k #voeg k  nullen toe

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]
        
def maal(v1: list, v2: list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2)-1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalx(gr2,v1)))
        gr2 -=1
    return pr      

def euclides (v:list, deler:list)-> tuple:
    gr = len(v)-len(deler) #graad van het quotient
    q = [0]*(gr+1) #declareer list van juiste grootte - overal 0
    r = v[:]
    while len(r)>=len(deler):
        c = r[0] #bepaal coeff voor q - deler is monisch dus coeff is 1
        g = len(r) - len(deler)
        q[gr-g] = c
        v = factor(-c,maalx(g,deler))
        r = plus(r, v)
    return(q,r)

#zorg dat veelterm monisch wordt
def monic(h:list)->list:
    if h==[]:
        return h
    c = h[0]%p #hoogste graadscoeff
    #zoek de inverse
    inv=1
    while (c*inv)%p != 1:
        inv = (inv+1)%p
    return factor(inv, h)

def ggd(v2:list, h:list) -> list:
    if (len(v2)<len(h)):
        v2,h = h,v2
    (q,r)=euclides(v2,h)
    while len(r)>1 :
        v2 = h
        h = monic(r)  #hoogstegraadscoefficient 1
        (q,r) = euclides(v2,h)  
    if len(r)==0: #deelbaar
        return(h)
    return(monic(r))

#bepaal de priemdelers van n
def prime(n:int)->list:
    pp=[]
    g = 2
    while n!=1:
        if n%g == 0:
            if pp.count(g)==0:
                pp.append(g)
            n //=g
        else:
            g+=1
    return pp

#initaliseert x^m - x
def veelterm_macht(m: int)-> list :
  return [1] + [0]*(m-2)+[-1%p,0]#veeltermen in Zp

#Nieuw variant rabintest
def rabinstest(h:list):
    h=monic(h)
    n = len(h)-1 # graad van h
    print("\np =",p," en n =",n)
    irreducible=True
    for i in range( 1, 1+n//2):
        m = p**i
        v2=veelterm_macht(m) #x^m-x
        r = ggd(v2,h)    
        if len(r)==1:
            print("i =",i,"/ m =",m,"  -> ggd(",veelterm(h),",",veelterm(v2),") = 1")
        else:
            print("ggd(",veelterm(h),",",veelterm(v2),") = ",veelterm(r))
            print("vw niet ok voor i =",i)
            irreducible = False
            break
    if irreducible:
        print(f'{veelterm(h)} is irreducibel in Z_{p}')
    else:
        print(f'{veelterm(h)} is reducibel in Z_{p}')
#oefeningen 
#(a)
p=2 
h=[1,0,1,1] #x^3 + x + 1
rabinstest(h)

#(b)
p=3 
h=[1,1,1,1,1,2] #x^5 + x^4 + x^3 + x^2 + x + 2
rabinstest(h)

#(c)
p=7 
h=[1,0,6,2] # x^3 + 6x + 2
rabinstest(h)

#(d)
p = 5 
h = [1,4,0,4,3] #x^4 + 4x^3 + 4x + 3
rabinstest(h)

#Voorbeeld theorie p 74
p=2 #modulo p rekenen
h=[1,0,0,1,0,0,1]  #x^6 + x^3 + 1 is irreducibel in Z2
rabinstest(h)

#voorbeeld theorie p 75
p=3
h=[1,0,0,2,1] #x^4 + 2x + 1 is reducibel in Z3
rabinstest(h)

#Extra oefeningen 
p=3
h=[1,1,1,1,1,2] #x^5 + x^4 + x^3 + x^2 + x + 2 is reduciebel in Z3
rabinstest(h)

p=5
h=[1,4,1,3,3,2] #x^5 + 4x^4 + x^3 + 3x^2 + 3x + 2 is reducibel in Z5 - oefening in hoofdstuk4
rabinstest(h)

p=19
h = [1,18,2] #x^2 + 18x + 2 is irreducibel in Z19
rabinstest(h)

p=17
h=[1,16,3] # x^2 + 16x + 3 is irreducibel in Z17
rabinstest(h)

```



### Oef 17

```python
p=2 #modulo p

#nullen vooraan verwijdern
def kuisop(v:list):
    while(len(v)>1 and v[0]==0):
        v = v[1:]
    return v

h=[1,0,1,1] #monische veelterm x^3+x+1=0
n=len(h)-1 #graad van de veelterm
#elementen = [[0],[1],[1,1],[1,0],[1,0,1],[1,0,0],[1,1,0],[1,1,1]]
#eerste poging enkel voor n=3:
elementen=[]
for c1 in range(p):
    for c2 in range (p):
        for c3 in range (p): 
            el = kuisop([c1,c2,c3]) #hoogste graad heeft coef niet nul            
            elementen.append(el)  
print(elementen)

#algemene oplossing
elementen = [[i] for i in range(p)]
for k in range(n - 1):
   new_elementen = []
   for el in elementen:
      for i in range(p):
         new_el = kuisop(el + [i])
         new_elementen.append(new_el)
   elementen = new_elementen

#alternatief met bibliotheek  https://docs.python.org/3/library/itertools.html
import itertools
elementen = [kuisop(list(x)) for x in itertools.product(range(p), repeat=n)]
print(elementen)
```



### Oef 19

```python
p=2 #modulo p
#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 = [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 = [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
    #hier kan je ook de methode kuisop gebruike (zie verder)   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]

#gebruik a ipv x 
def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "a^"+str(gr) #hoogste graad
    elif gr==1:
        s += "a"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
    return s

#hier grondige aanpassing enkel .x (dus niet .x^k)
#maal x en herleid de hoogste graad met h(x)
def maalx(v1:list, h:list)->list:
    vervang = factor(-1, h[1:]) #h(x) = 0 -> x^n = ... 
    v = v1[:] + [0] #schuif alles 1 plaats op -> maal x 
    if len(v)==len(h):  #a^n komt erbij
        b = factor(v[0],vervang) #bereken v[0].vervang
        v = plus(v[1:],b) # schap eerste getal in v en tel b erbij op
    return v

#maal x^k en herleid de hoogste graad met h(x)
#parameter h toegevoegd
def maalxk(k: int, v1:list, h:list)->list:
    temp = v1[:] #start met v1
    for _ in range(k):  #k keer vermenigvuldig met x
        temp = maalx(temp, h)
    return temp
        
#parameter h toegevoegd
def maal(v1: list, v2: list, h:list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2) - 1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalxk(gr2,v1,h)))
        # pr = plus(pr, factor(v2[j], maalx(gr2,v1))) #aangepast
        gr2 -=1
    return pr      

#alternatieve versie - efficienter 
def maal_bis(v1:list, v2:list, h:list) ->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    term = v1[:] #term bevat v1.x^k - in elke stap .x
    #vertrekt van de constante (laatste getal in v2)
    #j voopt van 0 tot len(v2)-1
    #j -> j-1 is iets eenvoudiger
    for j in range(len(v2),0,-1):
        pr = plus(pr, factor(v2[j-1], term))
        term = maalx(term,h) #vermenigvuldig met x
    return pr      


#nullen vooraan verwijdern
def kuisop(v:list):
    while(len(v)>1 and v[0]==0):
        v = v[1:]
    return v

h=[1,0,1,1] #monische veelterm x^3+x+1=0
n=len(h)-1 #graad van de veelterm

#zie oefening 17 zonder deze tool
import itertools
elementen = [kuisop(list(x)) for x in itertools.product(range(p), repeat=n)]

for el in elementen:
    for el2 in elementen:
        print(f'\t({veelterm(el)}) + ({veelterm(el2)}) = {veelterm(plus(el,el2))}')
    print()

for el in elementen:
    for el2 in elementen:
        print(f'\t({veelterm(el)}) . ({veelterm(el2)}) = {veelterm(maal(el,el2,h))}')        
    print()
```



### Oef 20

```python
p=2 #modulo p
#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   # print("verwijder 0 in ",som)   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#gebruik b ipv a 
def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "b^"+str(gr) #hoogste graad
    elif gr==1:
        s += "b"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    #gr -=1
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
       # gr-=1
    return s

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]

#maal x en herleid de hoogste graad met h(x)
def maalx(v1:list, h:list)->list:
    vervang = factor(-1, h[1:]) #h(x) = 0 -> x^n = ... 
    v = v1[:] + [0] #schuif alles 1 plaats op -> maal x 
    if len(v)==n+1:  #a^n komt erbij
        b = factor(v[0],vervang) #bereken v[0].vervang
        v = plus(v[1:],b) # schap eerste getal in v en tel b erbij op
    v = plus(v,[])
    return v

#maal x^k en herleid de hoogste graad met h(x)
def maalxk(k: int, v1:list, h:list)->list:
    temp = v1[:] #strat met v1
    for _ in range(k):  #k keer vermenigvuldig met x
        temp = maalx(temp, h)
    return temp

def maal(v1: list, v2: list, h:list)->list:
    pr=[0]*(len(v1)+len(v2)-1) #list aanmaken van juiste grootte
    gr2 = len(v2) - 1 # graad van v2
    for j in range(len(v2)):
        pr = plus(pr, factor(v2[j], maalxk(gr2,v1,h)))
        gr2 -=1
    return pr  

h=[1,1,0,1] #monische veelterm 1+x^2+x^3=0
n=len(h)-1 #graad van de veelterm

#zie oefening 17 zonder deze tool
#nullen vooraan verwijdern
def kuisop(v:list):
    while(len(v)>1 and v[0]==0):
        v = v[1:]
    return v

import itertools
elementen = [kuisop(list(x)) for x in itertools.product(range(p), repeat=n)]

for el in elementen:
    for el2 in elementen:
        print(f'\t({veelterm(el)}) + ({veelterm(el2)}) = {veelterm(plus(el,el2))}')
    print()

for el in elementen:
    for el2 in elementen:
        print(f'\t({veelterm(el)}) . ({veelterm(el2)}) = {veelterm(maal(el,el2,h))} ')        
    print()


```



### Oef 21

```python
#veeltermen in Zp
p = 5 #globale variabele

#aangepast: gebruik a ipv x  
def get_term(coeff: int, gr: int) ->str:    
    s = str(coeff%p) #in Zp
    if s =="1" and gr!=0:
        s = "" #coefficient 1 wordt niet geschreven
    if gr>1:
        s += "a^"+str(gr) #hoogste graad
    elif gr==1:
        s += "a"
    return s

#zet de list om in veeltermnotatie
def veelterm(v:list)->str:
    if len(v)==0:
        return "0"
    gr = len(v)-1
    s = get_term(v[0], gr)
    for i in range(1,len(v)):       
        if v[i]%p!=0:
            s+= " + " + get_term(v[i],gr-i)           
    return s

#optellen in Zp
def plus(v1:list, v2:list)-> list:
    l = max(len(v1),len(v2))
    v1 =  [0]*(l-len(v1)) + v1  #nullen toevoegen
    v2 =  [0]*(l-len(v2)) + v2
    som=[0]*(l)
    for i in range(len(som)):
        som[i]=(v1[i]+v2[i])%p
   
    while(len(som)>0 and som[0]==0): #hoogste graad heeft coef niet nul
        som = som[1:]   
    return som

#maal constante in Zp
def factor(f:int, v1:list)->list:
    return [f*i%p for i in v1]

#maal x en herleid de hoogste graad met h(x)
def maalx(v1:list, h:list)->list:
    vervang = factor(-1, h[1:]) #h(x) = 0 -> x^n = ... 
    v = v1[:] + [0] #schuif alles 1 plaats op -> maal x 
    if len(v)==n+1:  #a^n komt erbij
        b = factor(v[0],vervang) #bereken v[0].vervang
        v = plus(v[1:],b) # schap eerste getal in v en tel b erbij op
    v = plus(v,[])
    return v
        
p = 5
h = [1,1,2] #monische veelterm #x^2+x+2

p = 3
h=[1,0,2,1] #monische veelterm x^3 + 2x +1 
n=len(h)-1 #graad van de veelterm
alfa=[1,0]## [1,0]
b = alfa[:]
print("0")
print("a^0 = 1")
for i in range(1,p**n-1):
    print(f'a^{i} = {b} -> {veelterm(b)}')
    b = maalx(b,h)
```

### Oef 22

```python
#modulo 2 voorstelling met n-bits -> getal
def bitpatroon(x:int) ->str:
    w = bin(x)[2:]
    w = '0' * (n - len(w)) + w  #vul aan met nullen        
    return w

def plus(g1:int,g2:int) -> int:
    return g1 ^ g2

def maalalfa(code_getal:int, h : str)->int:
    h = h[1:]  #x^n = ...  in Z2
    h_int = int(h,2) #omgezet naar int met basis 2

    shift = code_getal<<1
    res = shift
    if shift >= 2**n: 
        res = shift%(2**n) #schrap de meest significante bit == de rest bij delen door 2**n 
        #res = shift-(2**n) #is ook correct
        res = plus(res, h_int) 
    return res
 
#n = int(input("Geef n"))
n=4
for code in range(0,2**n): 
    print(code, "->", bitpatroon(code))

print("\n deel2\n")

h="10011" #monische veelterm x^4+x+1
n=len(h)-1 #graad van de veelterm
machten = [0] #lijst om als macht op te slaan - nul toevoegen 

b = 1
for i in range(1,2**n):
    machten.append(b)
    b = maalalfa(b, h)

print("orde is ",len(machten))
print(sorted(machten)) #geeft alle getallen 0-15

print(f'{0} \t {bitpatroon(machten[0])}  \t {bitpatroon(machten[1])}\t a^{0}')
for i in range(1,len(machten)):
    som = plus(machten[i],1)
    j = machten.index(som) #zoek de macht van alpha die overeenkomt met deze som.
    if j>0:
        print(f'a^{i-1} \t {bitpatroon(machten[i])}  \t {bitpatroon(som)}\t a^{j-1}')
    else:
        print(f'a^{i-1} \t {bitpatroon(machten[i])}  \t {bitpatroon(som)}\t 0')
        
```

### Oef 26

```python
#modulo 2 voorstelling met n-bitpatroon -> getal

def bitpatroon_kort(x:int) ->str:
    w = bin(x)[2:]
    #w = '0' * (n - len(w)) + w  #vul aan met nullen        
    return w

def plus(g1:int,g2:int) -> int:
    return g1 ^ g2

def maalalfa(code_getal:int, h : str)->int:
    h = h[1:]  #x^n = ...  in Z2
    h_int = int(h,2) #omgezet naar int met basis 2

    shift = code_getal<<1
    res = shift
    if shift >= 2**n:
        res = shift-(2**n)
        res = plus(res, h_int)
    return res

def codeer(code:int,  h: str) ->int:   
    code_alfa = maalalfa(code, h)
    code_alfa_square = maalalfa(code_alfa, h)
    return plus(code_alfa_square,code)

h="1111101" #monische veelterm x^6+x^5+x^4+x^3+x^2+1

n=len(h)-1 #graad van de veelterm
codes = set()
for code in range(0,2**n): #generate_words(n):
    res = codeer(code,h)
   # print(bitpatroon_kort(code),"->",bitpatroon_kort(res))
    if res in codes:
        print("dubbel:", bitpatroon_kort(res))
    codes.add(res)

print(f'Aantal verschillende coderingen: {len(codes)} en 2^{n}={2**n}')
```

### Oef 27

```python
#modulo 2 voorstelling getal -> n-bitpatroon
def bitpatroon_kort(x:int) ->str:
    w = bin(x)[2:]
    return w

def plus(g1:int,g2:int) -> int:
    return g1 ^ g2

#efficienter h:str  -> h_int:int (maar 1 keer omzetten)
def maalalfa(code_getal:int, h_int:int)->int:
    shift = code_getal<<1
    res = shift
    if shift >= 2**n:
        res = shift%(2**n)
        res = plus(res, h_int)
    return res

h="100011011" #monische veelterm x^8+x^4+x^3+x+1
n=len(h)-1 #graad van de veelterm

h = h[1:] #x^4+x^3+x+1
h_int = int(h,2) #omgezet naar int met basis 2

a="1010111"
a_int = int(a,2)
b="10000011"
b_int = int(b,2)

print(a,"+",b,"=", bitpatroon_kort(plus(a_int,b_int)))

macht = a_int
machten =[]
for k in range(0,n):
    print(f'{a} . alfa^{k} = {bitpatroon_kort(macht)} (= {macht})')
    machten.append(macht)
    macht = maalalfa(macht,h_int)
print("de machten van alfa:",machten)

print("\ntel op:")
graad = len(b)-1
s = 0
for bit in b:
    if (bit!="0"):
        print(f'  {a}.alfa^{graad} : {bitpatroon_kort(machten[graad])} (= {machten[graad]})')
        s = plus(s, machten[graad])
    graad-=1
print("res=",bitpatroon_kort(s))

#alternatief maar minder algemeen:
#als b wijzigt lukt deze oplossing niet meer
a="1010111"
a_int = int(a,2)
#b="10000011" wordt niet gebruikt
res2=plus(a_int, maalalfa(a_int,h_int)) # a.(alfa+1)

#bereken nu a. alfa^7
temp = a_int
for i in range(7):
    temp = maalalfa(temp,h_int)
res2 = plus(res2,temp)
print("alternatief: res2=",bitpatroon_kort(res2))

```



### Oef 28

```python
#modulo 2 voorstelling met n-bits of m-bits-> getal
def bitpatroon(x:int) ->str:
    w = bin(x)[2:]
    w = '0' * (n - len(w)) + w  #vul aan met nullen        
    return w
 
def bitpatroon_kort(x:int) ->str:  
    w = bin(x)[2:]
    return w

def plus(g1:int, g2:int) -> int:
    return g1 ^ g2

def codeer(l:int, h:list)->int:
    pr=0
    for k in h:
        pr = plus(pr, l<<k)  #.alfa^k       
    return pr  
    
def afstand(g1:int,g2:int)-> int:
    x = g1 ^ g2  # bitsgewijs vergelijken 
    return bitpatroon_kort(x).count("1")

h="10011" #monische veelterm x^4+x+1

h_list=[]
graad = len(h)-1
for b in h:
    if b=="1":
        h_list.append(graad)
    graad-=1
print("h=",h_list)

m = 11

n=len(h)-1 + m #graad van de veelterm + aantal bits
elementen = range(2**m) 

codewoorden=[]
for el in elementen:
    gecodeerd = codeer(el,h_list)
    codewoorden.append(gecodeerd)
    #print(f'{bitpatroon_kort(el)}->{bitpatroon_kort(gecodeerd)}')

afst = n
for code in codewoorden:
    for code2 in codewoorden:
        if code!=code2:
            dist = afstand(code,code2)
            if dist<afst:
                afst = dist
                print(afst,":",bitpatroon(code),"-",bitpatroon(code2))

print("Minimale Hammingafstand is:",afst)

```

### Oef 29

```python
#modulo 2 voorstelling met n-bits of m-bits-> getal
 
#met m of n bits in deze oefening : extra parameter
def bitpatroon(x:int) ->str:
    w = bin(x)[2:]
    w = '0' * (n - len(w)) + w  #vul aan met nullen        
    return w

def bitpatroon_kort(x:int) ->str:
    w = bin(x)[2:]
    return w

def plus(g1:int,g2:int) -> int:
    return g1 ^ g2

def codeer(l:int, h:list)->int:
    pr=0
    for k in h:
        pr = plus(pr, l<<k)  #.alfa^k       
    return pr  
    
def afstand(g1:int,g2:int)-> int:
    x = g1 ^ g2  # bitsgewijs vergelijken 
    return bitpatroon_kort(x).count("1")

def decodeer(l:int, codering: dict)->str:    
    dichtst = 0
    afst = n #grootst mogelijk verschil = aantal tekens
    for el,code in codering.items():
        if code==l:
            return el
        if afstand(code,l)<afst:
            dichtst = el
            afst = afstand(code,l) 
    return dichtst

h="10011" #monische veelterm x^4+x+1 ->GF(2^4)
h_list=[]
graad = len(h)-1
for b in h:
    if b=="1":
        h_list.append(graad)
    graad-=1

m = 11
n=len(h)-1 + m #graad van de veelterm + aantal bits
elementen = range(2**m) 

codering={} #dictionary voor de codering

for el in elementen:
    gecodeerd = codeer(el,h_list)
    codering[el] = gecodeerd # key-value kan ook omgekeerd

invoer =input("Geef een codewoord met "+str(n)+" tekens: ")
if len(invoer)==n:
    invoer_int = int(invoer,2)
    decode = decodeer(invoer_int,codering)
    controle = codeer(decode,h_list)
    print(f'gedecodeerd: {bitpatroon_kort(decode)} - aantal fouten {afstand(controle,invoer_int)}')
else:
    print("codewoord moet exact", n,"tekens hebben")


```

### Oef 30

```python
#modulo 2 voorstelling met n-bits of m-bits-> getal
import random 
#met m of n bits in deze oefening : extra parameter
def bitpatroon(x:int) ->str:
    w = bin(x)[2:]
    w = '0' * (n - len(w)) + w  #vul aan met nullen        
    return w
 
def bitpatroon_kort(x:int) ->str:  
    w = bin(x)[2:]
    return w

def plus(g1:int, g2:int) -> int:
    return g1 ^ g2

def codeer(l:int, h:list)->int:
    pr=0
    for k in h:
        pr = plus(pr, l<<k)  #.alfa^k       
    return pr  
    
def afstand(g1:int,g2:int)-> int:
    x = g1 ^ g2  # bitsgewijs vergelijken 
    return bitpatroon_kort(x).count("1")

def decodeer(l:int, codering: dict)->str:    
    dichtst = 0
    afst = n #grootst mogelijk verschil = aantal tekens
    for el,code in codering.items():
        if code==l:
            return el
        if afstand(code,l)<afst:
            dichtst = el
            afst = afstand(code,l) 
        
    return dichtst

def flip(codewoord:str, aantal:int)->str:
    n = len(codewoord)
    pos = set()
    while len(pos) != aantal:
        k = random.randint(0,n-1)
        pos.add(k)
    res=""
    for i in range(n):
        if i in pos: #wijzig deze bit
            if codewoord[i]=="0":
                res+="1"
            else:
                res+="0"
        else:
            res+=codewoord[i]
    return res

h="11001" #monische veelterm x^4+x+1 ->GF(2^4)
h_list=[]
graad = len(h)-1
for b in h:
    if b=="1":
        h_list.append(graad)
    graad-=1
m = 11

n=len(h)-1 + m #graad van de veelterm + aantal bits
elementen = range(2**m) 

codering={}

for el in elementen:
    gecodeerd = codeer(el,h_list)
    codering[el]=gecodeerd

informatiewoord =input("Geef een informatiewoord "+str(m)+" tekens: ")
if len(informatiewoord)==m:
    woord_int = int(informatiewoord,2)
    code = codeer(woord_int,h_list)
    codewoord = bitpatroon_kort(code)
    print(f'{informatiewoord} --CODEER--> {codewoord}')

    aantal = int(input("Hoeveel bits flippen?"))   
    geflipt = flip(codewoord,aantal)
    code = decodeer(int(geflipt,2),codering)
    print(f'{geflipt} --DECODEER--> {bitpatroon_kort(code)}')
    
else:
    print("informatiewoord moet exact", m,"tekens hebben")
```

