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

De kans dat het verschijnsel $A$ pas optreedt bij de $i$-de waarneming. 
$$
f(i) = P(x=i) = (1-p)^{i-1} \cdot p
$$


### Hypergeometrische verdeling

$$
f(i)= P(x=i)=\frac{C^i_M C_{N-M}^{n-i}}{C^n_N} \\
f(i) = 0 \text{ als } i>min(n,M)
$$

* $N$ elementen
* Waarvan $M$ de eigenschap $A$ bezitten
* $n$ getrokken elementen
* Waarvan er $i$ de eigenschap $A$ bezitten



### Poisson verdeling

$x$ is het aantal keer dat een bepaald verschijnsel optreedt in een tijdsinterval. 
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

### Normale verdeling

(oftewel Gaussdistributie)

<img src="img/n0mwotvl28g4aufzvew9.jpeg" alt="Gaussian Distribution - DEV Community" style="zoom:33%;" />
$$
f(x) = \frac{1}{\sigma \sqrt{2\pi}}\cdot e^{-\frac{(x-\mu)^2}{2\sigma^2}}
$$

* Maximum: $\mu$
* Buigpunten in: $x=\mu + \sigma$ en $x=\mu - \sigma$



# 6 - Schattingstheorie



# 7 - Testen van hypothesen



# 8 - ANOVA



# 9 - Regressie

# --------------- Labo ---------------

## Oefeningen matlab

### Week 1

Oefening 4

```matlab
z = sqrt(2)*exp(1)^(3*pi*1j*0.20)
theta = angle(conj(z+1))
r = abs(conj(z+1))
rad2deg(angle(conj(z+1)))
```

Oefening 5

```matlab
a = [1,3,5,7,9]
b = repelem(a,18,1)
```

Oefening 7

```matlab
array = 1:100
square = array.^2
s = sum(square)
```

Oefening 8

```matlab
a = [1, 2, 0]
b = [3, 0, -3]
c = [5, 2, 6]
ab = b-a
bc = c-b
c = cross(ab, bc)
opp = norm(c)/2
```

Oefening 9

```matlab
%t/(1+sqrt(t))
arr = 0:0.1:1
arr = arr./(1+sqrt(arr))
res = mean(arr)
```

Oefening 14

```matlab
tan(2*acos(-1/5))
```

### Week 2

Oef 11

```matlab
arr = 1:1000
lol = sin(arr)
filtered = lol > 0.5
som = sum(filtered)
```

Oef 13

```matlab
arr = 0:10
arr = factorial(arr)
som = sum(arr)
```

Oef 15

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

Oef 17

```matlab
syms x 
eq = 2*x^3-x^2-15*x+18
opl = solve(eq > 0, x, 'ReturnConditions', true, 'Real', true)
opl.conditions
```

Oef 18

```matlab
syms x real
eq = x^5-5*x
opl = solve(eq == -2,x, 'Real', true)
var = vpa(opl)
```



### Week 3

Oef 20

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

Oef 23

```matlab
clear
syms x 
syms a 
f = 1/(1+x^2)
g = x^2/2
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

Oef 26

```matlab
syms x y
hold off
z = sin(sqrt(x^2+y^2)) /sqrt(x^2+y^2)
fmesh(z)
contour(z)
```



### Week 4

Oef 35

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

Oef 43

```matlab
t = 0:0.01:2*pi;
r = sin(4*theta)
r(r<0) = 0;

polarplot(t, r)
```





Oef 39

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







Oef 44

```matlab
t = 0:0.01:2*pi;

r = 1-cos(t)
```



### Week 5

