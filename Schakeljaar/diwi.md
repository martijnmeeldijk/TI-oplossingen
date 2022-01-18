# Discrete wiskunde

Deze samenvatting is iets meer low effort sorry. 

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

