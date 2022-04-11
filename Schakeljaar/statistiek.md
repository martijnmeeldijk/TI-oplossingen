# Statistiek

[Examen 2020 A](https://github.com/martijnmeeldijk/TI-oplossingen/blob/master/Schakeljaar/Examens%20/Examen_Statistiek_A_2020.pdf)

[Examen 2020 B](https://github.com/martijnmeeldijk/TI-oplossingen/blob/master/Schakeljaar/Examens%20/Examen_Statistiek_B_2020.pdf)

# ------------- Theorie -------------



# 1 - Kansrekenen

**De optellingswet**
$$
P(A \or B) = P(A) + P(B) - P(A \and B)
$$
**De vermenigvuldigingswet**
$$
P(A \and B) = P(B)P(A \vert B)= P(A)P(B \vert A)
$$
\* *$P(A \vert B)$ is de kans dat A gebeurt, gegeven dat B gebeurt*



**Combinaties**
$$
C^p_n = \frac{n!}{p!(n-p)!}
$$


**Regel van Bayes**

* Elke gebeurtenis $A_i$ kan een gebeurtenis $B$ als gevolg hebben. 
* Gebeurtenissen $A_i$ sluiten elkaar uit
* $P(B\vert A_i)$ is gekend
* We willen dus als $B$ zich voordoet weten wat de kans is dat één specifieke gebeurtenis $A_i$ hem voorafging

$$
P(A_j \vert B) = \frac{P(A_j)P(B \vert A_j)}{\sum_{i=1}^n P(A_i)P(B\vert A_i)}
$$



# 2 - Beschrijvende statistiek

Ik ga dit even overslaan ik weet niet echt wat ik moet neerschrijven



# 3 - Verdelingsfuncties van een populatie



## Definities

### Kansfunctie / dichtheidsfunctie

* Is nooit negatief



**Discrete veranderlijke**

De kansfunctie geeft de kans dat een discrete willekeurige variabele precies gelijk is aan een bepaalde waarde. De som van deze kansen is natuurlijk gelijk aan $1$.
$$
\sum_{i=1}^k f(x_i) = 1 
$$
**Continue veranderlijke**

Bij een continue veranderlijke bepaalt $f(x)$ de kans dat $x$ tussen $x$ en $dx$ ligt. Er geldt ook dat $P(x=c) = 0$, aangezien je bij een continue veranderlijke nooit een exacte waarde kan bekomen.
$$
P(a \leq x \leq b)= \int_a^b f(x)dx \quad \text{ en } \quad \int_{-\infty}^{+\infty} f(x)dx = 1
$$

### Cumulatieve distributiefunctie / verdelingsfunctie

* Is nooit negatief en is niet-dalend
* $ \lim_{t \to +\infty} F(t) = 1$ (bij continue veranderlijke)
* $\frac{dF}{dx} = f(x)$
* $P(a \leq x \leq b) = \int_{a}^b f(x)dx = P(x\leq b) - P(x \leq a) = F(b) - F(a)$

De verdelingsfunctie van een veranderlijke $x$ geeft voor elke waarde $t$ de kans dat $x$ kleiner of gelijk is aan $t$. Het is dus eigenlijk de som van alle kansen tot aan $t$.
$$
F(t) = P(x \leq t) = \sum_{x_i\leq t}f(x_i)
$$

$$
F(t) = P(x \leq t) = \int_{-\infty}^t f(x)dx
$$

## Momentenfunctie

De **momentenfunctie** is de verwachte waarde van $g(x) = e^{tx}$
$$
M(t) = \sum e^{tx}f(x_i)\\
M(t) = \int_{-\infty}^{+\infty} e^{tx}f(x) dx \\
\frac{dM}{dt} = E \bigg[ xe^{tx} \bigg]
$$


## Ongelijkheid van Chebychev

De kans dat $x$ meer dan $k$ keer de dispersie van het gemiddelde afwijkt is kleiner dan of gelijk aan $\frac{1}{k^2}$.
$$
P(\lvert x-\mu \rvert \geq k\sigma) \leq \frac{1}{k^2} \quad \xLeftrightarrow{} \quad 
P(\lvert x-\mu \rvert < k\sigma) \geq 1- \frac{1}{k^2}
$$
(//TODO moeten we dit bewijs kennen?)



# 4 - Discrete verdelingen

### Uniform discrete verdeling

De kans op voorkomen is voor alle waarden hetzelfde. 
$$
f(i) = P(x=x_i)= \frac{1}{n} \\
\mu = \frac{n+1}{2} \\
\sigma^2 = \frac{n^2 - 1}{12}
$$


### Bernoulli verdeling

Met $p$ de kans dat gebeurtenis $A$ optreedt. $x$ kan slechts twee waarden aannemen.
$$
x = 0 \text{ met kans } 1-p \\
x = 1 \text{ met kans } p
$$

$$
f(i) = P(x=i)= p^i(1-p)^{1-i} \\
\mu = p \\
\sigma^2 = p(1-p)
$$

### Binomiale verdeling

$x$ is het aantal keer dat verschijnsel $A$ optreedt bij $n$ experimenten.
$$
f(i) = P(x=i) = C^i_n p^i(1-p)^{n-i}
$$

$$
f(i+1) = f(i)\cdot\frac{p}{(1-p)} \frac{(n-i)}{(i+1)}
$$

### Geometrische verdeling

* Wanneer gebruiken?
  * Sleutelwoord 'herhalen' 

$P(x=i)$ = de kans dat het verschijnsel $A$ pas optreedt bij de $i$-de waarneming. 
$$
f(i) = P(x=i) = (1-p)^{i-1} \cdot p
$$

### Hypergeometrische verdeling

* Wanneer gebruiken
  * Elementen trekken zonder teruglegging
  * Als je de kans wil bepalen dat er $i$ elementen tussen zitten die je wilt.

$$
f(i)= P(x=i)=\frac{C^i_M C_{N-M}^{n-i}}{C^n_N} \\
f(i) = 0 \text{ als } i>min(n,M) \\
\mu = \frac{nM}{N} \quad \text{en} \quad \sigma^2 = \frac{N-n}{N-1}n\frac{M}{N}\left( 1 - \frac{M}{N} \right)
$$

* $N$ elementen
* Waarvan $M$ de eigenschap $A$ bezitten
* $n$ getrokken elementen
* Waarvan er $i$ de eigenschap $A$ bezitten



### Poisson verdeling

* Wanneer gebruiken
  * $x$ is het aantal keer dat een bepaald verschijnsel optreedt in een tijdsinterval. 
  * Als het aantal successen in een interval onafhankelijk is van de successen in de andere intervallen
  * Als een groter interval een grotere kans op succes geeft



Als $n$ heel groot is en $p$ heel klein, kan je de poissonverdeling gebruiken om de binomiaalverdeling te benaderen.
$$
f(i) = P(x=i)= \frac{e^{-\lambda}\lambda^i}{i!}\\
f(i+1) = f(i)\cdot \frac{\lambda}{i+1}
$$




# 5 - Continue verdelingen

### Uniform continue verdeling

Dichtheidsfunctie $f(x) = k$

<img src="img/1200px-Uniform_Distribution_PDF_SVG.svg.png" alt="Continue uniforme distributie" style="zoom: 25%;" />
$$
f(x) = \frac{1}{b-a} \quad \forall x \in [a,b]
$$

### Exponentiele verdeling

<img src="img/image-20220405162624029.png" alt="image-20220405162624029" style="zoom:50%;" />
$$
f(x) = \frac{1}{\theta}e^{-\frac{x}{\theta}} \quad \text{ met } x \geq 0 \text{ en } \theta > 0
$$

$\theta = \mu$

### Normale verdeling

(oftewel Gaussdistributie)

<img src="img/n0mwotvl28g4aufzvew9.jpeg" alt="Gaussian Distribution - DEV Community" style="zoom: 33%;" />
$$
f(x) = \frac{1}{\sigma \sqrt{2\pi}}\cdot e^{-\frac{(x-\mu)^2}{2\sigma^2}}
$$

* Maximum: $\mu$
* Buigpunten in: $x=\mu + \sigma$ en $x=\mu - \sigma$

Als $np \geq 5$ en $n(1-p) \geq 5$, benadert de normaalverdeling de binomiaalverdeling. Met $\mu = np$ en $\sigma = \sqrt{np(1-p)}$

Als je een berekening moet doen met een lineaire combinatie van verschillende normaalverdelingen, gebruik je dit:
$$
y= \sum a_ix_i + b \\
\mu_y = \sum a_i\mu_i + b\\
\sigma^2_y = \sum a^2_i \cdot \sigma^2_i
$$
Nu heb je een nieuwe normaalverdeling waarmee je verder kan rekenen. 

### De genormeerd normale verdeling

<img src="img/Normal_distribution_pdf.png" alt="Kansdichtheid van de normale verdeling" style="zoom: 25%;" />

(de groene op de afbeelding)

Als je normale verdeling als gemiddelde $0$ en als standaardafwijking $1$ heeft, krijg je een genormeerd normale verdeling.
$$
\varphi(x) = \frac{1}{ \sqrt{2\pi}}\cdot e^{-\frac{1}{2}z^2}
$$

$$
P(z < z_1) = \Phi(z_1) = \int_{-\infty}^{z_1} \frac{1}{ \sqrt{2\pi}}\cdot e^{-\frac{1}{2}z^2} dz
$$

Als je te maken hebt met een gewone normaalverdeling, en kansen ofzo moet uitrekenen, zal je heb sowieso moeten omzetten naar een genormeerde. Doe dit zo:
$$
z = \frac{x-\mu}{\sigma}
$$
Nu is je gemiddelde $0$ en je standaardafwijking $1$.

### De $\chi^2$ verdeling

![Chi-Square Distribution - an overview | ScienceDirect Topics](img/3-s2.0-B9780128051634000049-u04-08-9780128051634.jpg)
$$
x = \sum_{i=1}^{n}(z_i)^2
$$
$x$ is $\chi^2$-verdeeld, met $z_i$ een genormeerde normaalverdeling. De $\chi^2$-verdeling is eigenlijk een som van normaalverdelingen. Het aantal vrijheidsgraden is gelijk aan $n$ of $(n-k)$ als de $z_i$ gebonden zijn door $k$ vergelijkingen. 
$$
f(x) = \frac{1}{\Gamma(\frac{v}{2})2^{\frac{v}{2}}}x^{\frac{v}{2}-1}e^{-\frac{x}{2}} \\\\
\Gamma(t) = \int_0^{+\infty}e^{-x}x^t dx
$$

$$
\mu = v \quad \quad \sigma^2 = 2v
$$

Hoe meer vrijheidsgraden het hebt, hoe meer symmetrisch de curve wordt. Bij veel vrijheidsgraden $(v \geq 30)$ wordt de variabele $z=\frac{x-v}{\sqrt{2v}}$ benaderd door de standaardnormaalverdeling.

### De student-t verdeling

![Student's t-distribution - Wikipedia](img/325px-Student_t_pdf.svg.png)
$$
x = \frac{z}{\sqrt{\frac{y}{v}}} \text{ is } t(v) \text{ verdeeld als } 

\; \left\{ \begin{array}{l}
z \text{ is } N(0,1) \text{ verdeeld}\\
y \text{ is } \chi^2(v) \text{ verdeeld }
\end{array}\right.
$$


### De $F$ verdeling

<img src="img/fisher_f_pdf.png" alt="F Distribution - 1.49.0" style="zoom: 50%;" />
$$
x = \frac{\frac{u}{v_1}}{\frac{v}{v_2}}
$$
$x$ is $F(v_1, v_2)$ verdeeld als $u$ : $ \chi^2(v_1)$ en $v$ : $ \chi^2(v_2)$ verdeeld zijn. 

Nuttige eigenschap:
$$
F_{1-\alpha}(v_2, v_1) = \frac{1}{F_\alpha(v_1, v_2)}
$$
Als je bijvoorbeeld een berekening moet maken met $\alpha = 0.95$, kan je zo alsnog gebruik maken van de tabel met $\alpha = 0.05$

# 6 - Schattingstheorie



# 7 - Testen van hypothesen



# 8 - ANOVA



# 9 - Regressie

# 

# 







# --------------- Labo ---------------

## Oefeningen matlab

### Week 1

#### 1.4

Stel $z = \sqrt{2} e^{3 \pi j/5}$. Bepaal het reëel en imaginair deel. Bepaal (in graden) het argument
(=poolhoek) van het complex toegevoegde van (z+1).

```matlab
z = sqrt(2)*exp(1)^(3*pi*1j*0.20)
theta = angle(conj(z+1))
r = abs(conj(z+1))
rad2deg(angle(conj(z+1)))
```

#### 1.5

Voer op de meest handige manier de matrix A in die 18 rijen bevat.
$$
A = \begin{pmatrix}
1 & 3 & 5 & 7 & 9\\
1 & 3 & 5 & 7 & 9\\
\vdots & \vdots & \vdots & \vdots& \vdots \\
1 & 3 & 5 & 7 & 9\\

\end{pmatrix}
$$


```matlab
a = [1,3,5,7,9]
b = repelem(a,18,1)
```

#### 1.7

Bereken op een efficiënte manier: $1^2 + 2^2 + \cdots+ 100^2$

```matlab
array = 1:100
square = array.^2
s = sum(square)
```

#### 1.8

Bereken de oppervlakte van de driehoek met hoekpunten a(1, 2, 0), b(3, 0, -3) en c(5, 2, 6).

```matlab
a = [1, 2, 0]
b = [3, 0, -3]
c = [5, 2, 6]
ab = b-a
bc = c-b
c = cross(ab, bc)
opp = norm(c)/2
```

#### 1.9

Bereken het gemiddelde van de elementen uit de verzameling *{f(0), f(0.1),..., f(1)}* met
$$
f(t) = \frac{1}{1+\sqrt{t}} \text{ (zonder lussen)}
$$


```matlab
%t/(1+sqrt(t))
arr = 0:0.1:1
arr = arr./(1+sqrt(arr))
res = mean(arr)
```

#### 1.10

Een rechthoekige driehoek heeft een omtrek van 5 cm en de lengte van de schuine zijde is 2/3 van de som van de lengtes van de rechthoekszijden. Wat is de waarde van de zijden van deze driehoek?

```
//TODO
```



#### 1.14

Bereken $\tan(2\arccos(-\frac{1}{5}))$

```matlab
tan(2*acos(-1/5))
```

### Week 2

#### 1.11

Hoeveel van de volgende getallen zijn groter dan 0.5?
$$
sin(1), sin(2), sin(3),...,sin(1000)
$$


```matlab
arr = 1:1000
lol = sin(arr)
filtered = lol > 0.5
som = sum(filtered)
```

#### 1.13

$$
\text{Bereken: } \sum_{n=0}^{10}n!
$$



```matlab
arr = 0:10
arr = factorial(arr)
som = sum(arr)
```

#### 1.15

Een rechthoekige driehoek heeft een omtrek van 5 cm. Wat is de waarde van de zijden wanneer de driehoek maximale oppervlakte heeft.

```matlab
syms a b c
py = a^2 + b ^2 == c^2
omtr = a + b + c == 5
opp = a*b/2
b1 = solve(a^2 + b^2 == (5-a-b)^2)
vgl = subs(opp, b, b1)
afg = diff(vgl, a)
solve(afg, 0)
var2 = vpa(ans)
b = var2(1)
```

#### 1.17

Los op over $\mathbb{R}$: $2x^3 - x^2-15x+18 > 0$

```matlab
syms x 
eq = 2*x^3-x^2-15*x+18
opl = solve(eq > 0, x, 'ReturnConditions', true, 'Real', true)
opl.conditions
```

#### 1.18

Los op over $\mathbb{R}$: $x^5 - 5x = -2$

```matlab
syms x real
eq = x^5-5*x
opl = solve(eq == -2,x, 'Real', true)
var = vpa(opl)
```



### Week 3

Schets de kromme $y= \arctan\left(\frac{x-1}{2} - \frac{1}{2x-2}\right)$. Bepaal de limiet in $1$ en in $\infty$. Bepaal $y'$. Zoek de punten waarin $y'=2$. Verklaar de resultaten op de grafiek.



#### 1.20

```matlab
syms x
f = atan((x-1)/2-1/(2*x-2))
fplot(f)
x1left = limit(f,x,1, 'left')
x1right = limit(f,x,1, 'right')
xposinf = limit(f,x, +Inf)
xneginf = limit(f,x, -Inf)
d = diff(f)
solve(d==2,x)


```

#### 1.23

Schets de krommen $y= \frac{1}{1+x^2}$ en $y=\frac{x^2}{2}$.
Bepaal de snijpunten en bereken de oppervlakte van het gebied ingesloten door beide krommen. Gebruik verschillende kleuren voor de krommen.

```matlab
clear
syms x 
syms a 
f = 1/(1+x^2)
g = x^2/2
% TODO kleuren
```



```matlab
fplot(f)
hold on
fplot(g)
randen = solve(f==g)
upper = int(f, [randen(1) randen(2)])
lower = int(g, [randen(1) randen(2)])
opl = upper - lower
```

#### 1.26

Maak een 3D-plot en een contourplot van $z = \frac{\sin \sqrt{x^2+y^2}}{\sqrt{x^2+y^2}}$, $-10 \leq x \leq 10$ , $-10 \leq y \leq 10$

```matlab
syms x y
hold off
z = sin(sqrt(x^2+y^2)) /sqrt(x^2+y^2)
fmesh(z)
contour(z)
```

#### 1.29

Teken een gladde voorstelling van de kromme bepaald door:
$$
\begin{cases}
x = \cos(5t + \frac{\pi}{4}) \\
y = \sin(4t)
\end{cases}
$$

```matlab
%TODO
```



#### 1.30

Teken een kromme in het complexe vlak waarbij $z = t e^{it}$, $0 \leq t \leq 4\pi$

```matlab
%TODO
```



#### 1.33

Bepaal de reële oplossingen van 
$$
\begin{cases}
x^2 -2x + y^2 = 0 \\
9x^2-18x +4y^2 = 27
\end{cases}
$$
Verklaar grafisch het resultaat.

```matlab
%TODO
```



### Week 4

#### 1.35

Maak met behulp van een tekening een schatting voor welke waarden van $t$ de voerstraal van de punten van de kromme met parametervoorstelling $(x = 2 sin(t) + cos(2t), y = - 2 cos(t) - sin(2t))$ maximaal zal zijn en controleer via berekeningen.
                                        

```matlab
syms x
syms y
syms t
syms p

t=linspace(0,4*pi, 1000);
x = 2*sin(t) + cos(2*t)
y = -2*cos(t) - sin(2*t)
plot(x,y)

v = max(sqrt(x.^2 + y.^2))

m = diff(sqrt((2*sin(p) + cos(2*p))^2 + (-2*cos(p) - sin(2*p))^2))

solve(m== 0)

axis equal

grid on
```

#### 1.43

Teken de poolkromme $r = sin(4t)$.

```matlab
t = 0:0.01:2*pi;
r = sin(4*theta)
r(r<0) = 0;

polarplot(t, r)
```





#### 1.39

a) Teken op één grafiek de krommen met vergelijking $r =1$ en $r = 2 cos(3\theta)$.
b) Bereken de oppervlakte van het gemeenschappelijk deel binnen $r=1$ en $r= 2 cos(3\theta)$.

```matlab
syms x
t = 0:0.01:2*pi;
r = 2*cos(3*t)
polarplot(t,r)
hold on
polarplot(t,1+0*t) % barbaars volgens Tonesi
solve(2*cos(3*x)==1, x)

q = (0.5*int(1 + 0*x, 0, pi/9) + 0.5*int((2*cos(3*x))^2, pi/9, pi/6))*6
```







#### 1.44

Bereken de booglengte van de kromme $r = 1 – cos(t)$ gelegen buiten de kromme $r + \sqrt{3} sin(t) = 0$.

```matlab
t = 0:0.01:2*pi;

r = 1-cos(t)
%TODO
```



### Week 5

#### 1.45 a

a) Teken $f(x) = e^{2x+1}$ samen met zijn 2 afgekapte Taylorontwikkelingen rond $x=1$, resp. na de
    term in $x$ en na de term in $x$? . Gebruik daarvoor het commando 'taylor'.

```matlab
clear
syms x
syms y

y1 = exp(1)^(2*x+1)
y2 = taylor(y1,x,'ExpansionPoint',1,'Order',2)
y3 = taylor(y1,x,'ExpansionPoint',1,'Order',3)

xlim([0 2])
ylim([-20 140])

hold on
fplot(y1)
fplot(y2)
fplot(y3)
```

#### 1.45 b

b) Herhaal deze tekening voor $f (x) = x^2 - x$. Leg het resultaat uit. 

```matlab
clear
syms x
syms y

y1 = x^2-x
y2 = taylor(y1,x,'ExpansionPoint',1,'Order',2)
y3 = taylor(y1,x,'ExpansionPoint',1,'Order',3)

hold off
fplot(y1)
hold on
fplot(y2)
fplot(y3)
```

#### 1.46

Bepaal het inverse Laplacebeeld van: 
$$
F(s) = \frac{2s^3 + 8s^2 + 12s + 32}{s^4 + 4s^3 + 8s^2 + 16s + 16}
$$


```matlab
clear
syms s

l = (2*s^3 + 8*s^2 + 12*s + 32)/(s^4 + 4*s^3 + 8*s^2+16*s+ 16)
inv = ilaplace(l)
```



#### 1.48

Bereken het Laplacebeeld van de functie die niet nul is tussen 1 en 2 en daar als functiewaarde $2-x$ aanneemt. Bereken van het resultaat het inverse Laplacebeeld en maak een tekening van de functie.

```matlab
clear
syms x
y = heaviside(x-1)*(2-x) + heaviside(x-2)*(x-2)
l = laplace(y)
inv = ilaplace(l)
```

#### 1.51

Bepaal alle waarden van $a$ zodat $|A|= - 1$ met
$$
A = \begin{pmatrix}
1& a &0& 6\\ 4& 0& 1& 2\\ 1& 3& -1 &6\\ 1& 10& 3& 11

\end{pmatrix}
$$


```matlab
syms a
A = [1 a 0 6; 4 0 1 2; 1 3 -1 6; 1 10 3 11]
d = det(A)
solve(d==-1)
var = vpa(ans)
```

#### 1.52

Een oefening uit de cursus elektriciteit geeft aanleiding tot volgend stelsel:

![image-20220410111340136](img/image-20220410111340136.png)
$$
\begin{cases}
i_2 - i_1 - i_3 = 0 \\
i_3 - i_4 - i_5 = 0 \\
30i_1 + 30i_2 = -60 \\
30i_2 + 15i_3 + 30i_5 = 60 \\
-30i_5 + 10i_4 = 200
\end{cases}
$$
Bepaal de stroomsterkten

```matlab
syms i1 i2 i3 i4 i5
eq1 = i2 -i1 -i3 == 0
eq2 = i3 -i4 -i5 == 0
eq3 = 30*i1 + 30*i2 == -60
eq4 = 30*i2 + 15*i3 + 30*i5 == 60
eq5 = -30*i5 + 10*i4 == 200

opl = solve([eq1, eq2, eq3, eq4, eq5], [i1, i2, i3, i4, i5])

opl.i1 %als je echt een neurt bent kan je ze allemaal nog apart uitschrijven

var2 = vpa(ans)

```





#### 1.55

Bepaal een orthonormaal stel eigenvectoren van de lineaire transformatie $g: (x,y,z) → (-x, -y, -z)$. Wat is de fysische interpretatie hiervan? Verklaar het resultaat.

```matlab
%TODO
```



### Week 7

#### 1.58

Maak een simulatie met 100 steekproefwaarden van een variabele met een F(7,5 df)-verdeling. Herhaal dit 400 keer. Maak passende tekeningen om hierin de centrale limietstelling te herkennen.

```matlab

```

#### 1.63 

De resultaten (/100) behaald door een selectie van 10 studenten op het examen wiskunde en
economie worden gegeven in onderstaande tabel.

| Student        | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   |
| -------------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Score Wiskunde | 30   | 73   | 51   | 57   | 81   | 21   | 75   | 46   | 85   | 21   |
| Score Economie | 45   | 70   | 40   | 60   | 71   | 30   | 80   | 50   | 70   | 10   |

 (a) Wat is de gemiddelde score voor het examen wiskunde bij deze 10 studenten?
 (b) Schat de verwachte score voor het examen economie. Wat is daarbij de standaardfout?
 (c) Bij welk examen is de variantie het grootst voor deze groep studenten?
 (d) Maak een scatterplot waarbij je de score voor wiskunde uitzet ten opzichte van de score voor economie.

```matlab

```

#### 1.64 

Genereer een steekproef met 200 waarnemingen van een variabele met als verdeling N(2,1).
Teken de histogram van deze steekproef.
Vind een interval waarin het steekproefgemiddelde van een dergelijke steekproef zal liggen met 80% betrouwbaarheid.

```matlab

```

#### 1.65

Als $x:F(5,12 d.f.)$, dan is$ P(x<2)= \cdots$
Als $y:t(10 d.f.)$, dan is $P(y>1)=\cdots$
Wat is a als $P(y<a)=0.15$?
Als $z:Bin(500, 0.02 d.f.)$, dan is $P(z<12)= \cdots$
(controleer dit laatste ook met de normale verdeling en geef commentaar)

```matlab

```

#### 1.66

Genereer zelf een steekproef met 100 waarnemingen van lengtes van planken. De leverancier
stelt dat de lengtes normaal verdeeld zijn met gemiddelde $2 m$ en $\sigma=9 cm$. Onze zaagmachine
zaagt van elke plank een deel af met een lengte die normaal verdeeld verondersteld wordt met
gemiddelde $ 1.5 m$ en $\sigma=1 cm$. Simuleer dit. Welke verdeling verwacht je voor de lengtes van de
overblijvende stukken van de planken als je weet dat de werking van de machine onafhankelijk is
van de lengte van de plank. Controleer dit aan de hand van de grafieken van de cumulatieve
distributiefuncties (theoretische functie in het rood).

```matlab

```



#### 

### Week 9

#### 1.59

Creëer een nieuwe data-file met volgende gegevens: 24, 19, 14, 10, 7, 5, 6, 8, 12, 16, 21, 27.
(a) Maak een boxplot.
(b) Ga na of de gegevens uit een normaal verdeelde populatie komen.
(c) Ga na of de gegevens uit een normaal verdeelde populatie met gemiddeld 7 komen.

```matlab

```

#### 1.67

De afdeling kwaliteitscontrole van een fabriek die microgolfovens maakt, meet bij 42 ovens wat de straling is van de oven met gesloten deuren.
(a) Ga na of we er kunnen vanuit gaan dat deze emissie normaal verdeeld is.
(b) Ga na of er uitschieters zijn. Welke zijn die?
(c) Test of $\mu = 0.10$ met $\alpha = 0.05$.
(d) Geef een 99% betrouwbaarheidsinterval voor $\mu$.
Data : **microgolf.dat**

```matlab

```

#### 1.68

Een consumentenorganisatie evalueert de kwaliteit van zonnepanelen. Daarvoor werden op 15 daken panelen geplaatst, één van type A en één van type B. De geleverde stroom (in kWh) werd opgemeten gedurende 3 maanden. Kan op basis van deze gegevens worden geconcludeerd dat er een significant verschil is in opgewekte stroom tussen de twee soorten panelen?
Data : **zonnepaneel.txt**

```matlab

```

#### 1.69

Een consumentenorganisatie evalueert de kwaliteit van zonnepanelen. Daarvoor wordt op 30 daken één type zonnepaneel gelegd: ofwel type A ofwel type B. De geleverde stroom (in kWh) werd opgemeten gedurende 3 maanden. Kan op basis van deze gegevens worden geconcludeerd dat er een significant verschil is in opgewekte stroom tussen de twee soorten panelen? Maak voor beide groepen een box-and-Whisker plot en becommentarieer.

```matlab

```

#### 1.71

Voor het vervaardigen van synthetisch diamant wordt winst geboekt als de karaat-waarde > 0.5. Een steekproef van 6 diamanten geeft:
                0.46 0.61 0.52 0.48 0.57 0.54

Is algemeen gesproken de productie de moeite waard? (test op 85% niveau)

```matlab

```

#### 1.73

De hartslag vóór en na het toedienen van een bepaalde medicatie bij zeven personen geeft volgende resultaten, waarbij 'hartslag sport' slaat op de resultaten van groep 1: personen die 2 uren sporten per week, en 'hartslag geen sport' slaat op de resultaten van groep 2: personen die geen sport doen.

<img src="img/image-20220410113637261.png" alt="image-20220410113637261" style="zoom:50%;" />

```matlab

```

Kan op basis van deze steekproef gesteld worden dat de hartslag op populatieniveau hoger is voor de groep die geen sport doet$ (\alpha = 0.05)$? 

### Week 10

#### 1.60

(a) Geef de boxplot voor volgende data: 25, 50, 22, 10, 28, 95, 20, 14, 25, 30 Bepaal de uitschieter.
(b) Test of de gegevens normaalverdeeld zijn op 80%-niveau.
(c) Verwijder de uitschieter en test opnieuw.

```matlab

```

#### 1.61

Bij een fabriek die klinkers maakt, wil men de maatvastheid onderzoeken van de geproduceerde klinkers. Daarvoor werd een steekproef gedaan en de lengte gemeten.
          12, 13, 14, 16, 15, 18, 19, 10, 11, 12, 13, 14, 15, 13, 14, 12.
a) Presenteer een histogram van deze gegevens.
b) Kunnen we aannemen dat deze gegevens normaal verdeeld zijn?
c) Vind de mediaan, de interkwartielafstand, de modus, het gemiddelde, variantie, het 10% percentiel.

```matlab

```

#### 1.62

In onderstaande tabel staan de maandelijkse nettolonen van een KMO in de bouwsector.

<img src="img/image-20220410113831579.png" alt="image-20220410113831579" style="zoom:33%;" />

<img src="img/image-20220410113840838.png" alt="image-20220410113840838" style="zoom:33%;" />

(a) Schat het gemiddelde loon binnen deze KMo. Wat is de standaardafwijking?
(b) Bereken zelf het 95% betrouwbaarheidsinterval voor het gemiddelde loon voor een KMO in de bouwsector op basis van deze gegevens.

```matlab

```

#### 1.75

Een onderzoek werd opgericht om na te gaan of de leeftijd van de autobestwurder invloed heeft op zijn rijgedrag, met name het aantal auto-ongevallen waarin hij betrokken geraakt gedurende een jaar.
Test met een betrouwbaarheid van 95% of de leeftijd van de bestuurder invloed heeft op het aantal ongevallen ?
Data : **rijgedrag.dat**

```matlab

```

#### 1.77

Men wenst te onderzoeken wie kiest voor het bouwen van passieve woningen. Daarvoor heeft men gepeild naar het opleidingsniveau van de mensen die een woning bouwen. Er wordt onderscheid gemaakt volgens drie klassen (groep1 = hoger opgeleiden, groep 2 = middengroep, groep 3 = laaggeschoolden). De aantallen staan genoteerd in volgende tabel.

<img src="img/image-20220410114023670.png" alt="image-20220410114023670" style="zoom:33%;" />                                     

(a) Ga je op basis van deze steekproef akkoord met de stelling dat er geen verschil is qua opleidingsniveau bij de keuze voor een passieve woning? (onbetrouwbaarheidsdrempel=5%)?
(b) Hoeveel procent van de passieve woningen worden gebouwd door laaggeschoolden?
(c) Hoeveel procent van de hoger opgeleiden kiest voor een passieve woning?

```matlab

```

### Week 11

#### 1.79 

Een onderzoeker is geïnteresseerd in de breeksterkte van verschillende gelamineerde balken gemaakt uit drie houtvariëteiten en drie verschillende soorten lijm. Om deze te vergelijken werden vijf balken van elk van de negen combinaties aangemaakt en daarna onderworpen aan een spanningstest. De data bestaat uit waarden voor de druk waarbij de balken braken. Maak een vergelijkend onderzoek en controleer eventuele assumpties.
Data : **balken.dat**

```matlab

```



#### 1.80

Men wenst onderzoek te doen rond verschilende samenstellingen om het wegdek van de snelweg mee te bouwen. Bij een proefproject worden de vier verschillende types wegdek (die verschillen qua samenstelling van de asfalt) gebruikt op de E17, de E40, de R4 en de E413, telkens met een strook van 1 km. Na vijf jaar wordt geëvalueerd hoeveel herstellingen dienden te
gebeuren (zie tabel). Maak een totale variantie-analyse voor wat betreft de types wegdek op de verschillende snelwegen.

<img src="img/image-20220410114216957.png" alt="image-20220410114216957" style="zoom:33%;" />

```matlab

```



#### 1.81

Op verschillende plaatsen worden watermonsters genomen en het zuurstofgehalte bepaald:
plaats 1: stroomopwaarts
plaats 2: nabij een fabriek
plaats 3: stroomafwaarts
Ga na of er een significant verschil is tussen de plaatsen.

<img src="img/image-20220410114252008.png" alt="image-20220410114252008" style="zoom: 50%;" />

```matlab

```



#### 1.82

Er wordt een studie gedaan waarin de Fe-concentratie bepaald wordt in grondstalen. Op 3 verschillende plaatsen worden telkens zes stalen genomen en de metingen op elk staal worden uitgevoerd in 2 verschillende labo's, die elk een andere meettechniek gebruiken.
In de onderstande tabel worden de resultaten weergegeven.
Ga na in hoeverre het labo (factor A) en de plaats (factor B) effect hebben op de meting ($\alpha=0.1$).

<img src="img/image-20220410114355419.png" alt="image-20220410114355419" style="zoom:50%;" />

```matlab

```



### Week 12

#### 1.88

Gasmaatschappijen moeten voldoende gastoevoer voorzien om hun klanten het ganse jaar door te bevoorraden. Bij de planning wil men in staat zijn de benodigde hoeveelheid te voorspellen op basis van gegevens rond temperatuur van de dag zelf, van de voorbije dag, de windsnelheid, het feit of het weekend is of niet.

a.  Stel op basis van de data die voorhanden is, een lineair regressiemodel op dat ons in staat moet stellen om de nodige gashoeveelheid te modelleren.

b. Hoeveel procent van de variantie kan verklaard worden door het regressiemodel ? Interpreteer.

c. Wat is volgens het model de hoeveelheid gas die de maatschappij moet voorzien als de
   temperatuur van de dag (woensdag) gelijk is aan18 graden Celcius, de temperatuur van de
   dag ervoor 15 graden Celcius, de windsnelheid 10 bedraagt.

d. Wat is volgens het model het 95% betrouwbaarheidsinterval voor de coëfficiënt bij de
   temperatuur van de dag ?

Data : **gasbedrijf.dat**

```matlab

```



#### 1.89

Twee wijnproevers werd gevraagd een rangschikking te maken van 9 gegeven wijnen.
(a) Bereken de correlatiecoëfficiënt van de scores van beide wijnproevers en trek er je conclusies
   uit over de mening van de twee kenners.
(b) Maak een gepaste grafiek die het verband tussen de 2 beoordelingen weergeeft.
Data : **wijndegustatie.dat**

```matlab

```



#### 1.90

Het gewicht van personen wordt vergeleken met de systolische bloeddruk. Dit geeft:

<img src="img/image-20220410114701175.png" alt="image-20220410114701175" style="zoom:50%;" />

Bepaal het lineair verband dat algemeen de bloeddruk uitdrukt in termen van het gewicht.
Bespreek voor $\alpha = 0.05$.

```matlab

```



#### 1.91

Gegeven zijn volgende meetresultaten:

x: 1.5	 2	 3.1	 4.2	5  	 6.1 	6.9	 8.3	 9.5	 10.1 
y: 7 	20 	65 	 64 	187   430    600   1300  2000   3500

Bepaal op basis van deze gegevens het best passende lineair verband $y = \beta_0+ \beta_1x$. Kan je het  model verbeteren?

```matlab

```



#### 1.93

Men wil bestuderen hoe de weerstand van rubber tegen afschuren beïnvloed wordt door de hardheid en treksterkte van rubber. Twintig monsters rubber zijn getest op de hardheid (hoe hoger het getal des te sterker is het rubber) en treksterkte (in kg/cm?). Daarna is elk monster een uurlang afgeschuurd (elk monster op dezelfde manier) en is het afgeschuurde gewicht (in gram) aan rubber per uur (y) bepaald. Bepaal het meervoudige lineaire model $y = \beta_0 + \beta_1 x_1 + \beta_2 x_2$ en illustreer met een 3D tekening.

<img src="img/image-20220410115135624.png" alt="image-20220410115135624" style="zoom:50%;" />

```matlab

```

