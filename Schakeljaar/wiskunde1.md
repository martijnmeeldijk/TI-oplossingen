# Wiskunde 1

# Complexe getallen

$$
z.\bar{z} = (a+bj)(a-bj) = a^2 + b^2 \\\
cos\theta + jsin\theta = e^{j\theta}
$$

Omzetting:
$$
\begin{equation}
    \begin{cases}
     x= rcos\theta \\
     y= rsin\theta
      
    \end{cases}\,
\end{equation}
$$

$$
\begin{equation}
    \begin{cases}
     tan\theta = \frac{b}{a} \\
     r = \sqrt{a^2+b^2}
      
    \end{cases}\,
\end{equation}
$$

k-de machtswortel
$$
w_k = \sqrt[n]{r}e^{j\frac{1}{n}(\theta +2k\pi)} = \sqrt[n]{r}(cos\frac{1}{n}(\theta +2k\pi) + jsin\frac{1}{n}(\theta +2k\pi))
$$
Eigenschappen:

Veelterm van de n-de graad met complexe coëfficiënten: n complexe nulpunten

Veelterm met reële coëfficiënten met niet reëel nulpunt $z$: $\bar{z}$ is ook een nulpunt

Veelterm van oneven graad met reële coëfficiënten heeft ten minste één reëel nulpunt.



# Vectoren

### Scalair product

$$
\vec{a}//\vec{b} \xRightarrow{} \vec{a} = \vec{0} \text{ of } \vec{b} = k.\vec{a} \\
\norm{\vec{a} \pm \vec{b}} = \sqrt{\norm{\vec{a}}^2 + \norm{\vec{b}}^2 \pm 2\norm{\vec{a}}\norm{\vec{b}}cos\theta} \quad ,\theta \text{ hoek tussen a en b} \\
\vec{a}.\vec{b} = a_xb_x + a_yb_y + a_zb_z = \norm{\vec{a}}.\norm{\vec{b}}.cos\theta \\
\vec{a}.\vec{b} = 0 \xRightarrow{} \vec{a} \perp \vec{b} \text{ of } \vec{a} = \vec{0}
\text{ of } \vec{b} = \vec{0} \\
\norm{\vec{a}}  = \sqrt{\vec{a}.\vec{a}}
$$

### Projectie

Loodrechte projectie van vector op richting $e_u$:
$$
\vec{p} = (\vec{a}.\vec{e_u})\vec{e_u}
$$

### Vectorieel product

$$
\vec{a} \times \vec{b} = 0 \xRightarrow{} \vec{a} // \vec{b} \text{ of } \vec{a} = \vec{0}
\text{ of } \vec{b} = \vec{0} \\
\norm{\vec{a} \times \vec{b}} = \norm{\vec{a}}.\norm{\vec{b}}\abs{sin\theta} 
= \text{oppervlakte parallelogram} 
\\
\frac{1}{2} \norm{\vec{a} \times \vec{b}} = \text{oppervlakte driehoek}
\\
\vec{a} \times \vec{a} = 0
$$

### Gemengd product

kan je doorschuiven: $\vec{a}.(\vec{b} \times \vec{c}) = \vec{b}.(\vec{c} \times \vec{a}) = \vec{c}.(\vec{a} \times \vec{b})$
$$
\abs{\vec{a}.(\vec{b} \times \vec{c})} = \text{inhoud parallellepipedum} \\
\frac{1}{6}\abs{\vec{a}.(\vec{b} \times \vec{c})} = \text{inhoud tetraëder} \\
\abs{\vec{a}.(\vec{b} \times \vec{c})} \xRightarrow{} \text{vectoren zijn coplanair}
$$

# Tweedegraadskrommen en -oppervlakken

Dit ga ik effe laten maar er komt sowieso 1 vraag waar je moet zeggen welke kromme de vergelijking is.



# Functies

Nogmaals, ik schrijf alleen de dingen op die ik moeilijk kan onthouden

### Logaritmen

$$
log_bx = log_ba.log_ax
$$

### Areaalfuncties

$$
shx = \frac{e^x - e^{-x}}{2} \\
chx = \frac{e^x + e^{-x}}{2}
$$

# Continuïteit

Een functie $f$ is continu over $[a,b]$ indien:

- $f$ rechts continu is in $a$
- $\forall x \in ]a,b[$, $f$ is continu in $x$
- $f$ is links continu in $b$



### Limieten

$$
\lim_{x\to 0}(1+x)^\frac{1}{x} = \lim_{x\to \infty}(1+\frac{1}{y})^y= e \\
\lim_{x\to 0} \frac{sinx}{x} = 1 \\
\lim_{x\to 0} \frac{tanx}{x} = 1 \\
\lim_{x\to a}u^v = e^{\lim_{x\to a}(v\ln u)}
$$

# Afgeleiden

$f$ afleidbaar in $a \xRightarrow{}$ $f$ continu in a (niet speciaal andersom, een typische examenvraag is om dit toe te passen)

Sommige afgeleiden die ik vaak vergeet of door elkaar haal
$$
(Arcsinx)' = \frac{1}{\sqrt{1-x^2}} \\
(Arccosx)' = \frac{-1}{\sqrt{1-x^2}} \\
(Arctanx)' = \frac{1}{1+x^2} \\
(log_ax)' = \frac{1}{(\ln a)x } \\
(a^x)' = (\ln a)a^x \\
$$
Impliciet afleiden:

* leid de uitdrukking term per term af naar x
* voor factoren afhankelijk van y, kettingregel gebruiken: $\frac{dg(y)}{dx} = \frac{dg(y)}{dy} \frac{dy}{dx} = \frac{dg(y)}{dy}.y'$

### l'Hopital

Alleen gebruiken bij $\frac{0}{0}$ of $\frac{\infty}{\infty}$

### Raaklijn en normaal in een punt

$$
y-y_p = y'_p(x-x_p) \xRightarrow{} \text{ raaklijn} \\
y-y_p = \frac{1}{y'_p}(x-x_p) \xRightarrow{} \text{ normaal}
$$

### Kromtestraal

$$
k = \frac{y''}{(1+y'^2)^{\frac{3}{2}}} \text{ en } R =  \frac{(1+y'^2)^{\frac{3}{2}}}{\abs{y''}}
$$

bereken de eerste en tweede afgeleide *in het punt* waarin je de kromtestraal of kromming moet berekenen en vul dan in in de formule.

# Functieonderzoek

Niet verticale asymptote:
$$
y = \omega x + b \\
\omega = \lim_{x \to \infty}\frac{f(x)}{x} \\
b = \lim_{x \to \infty}(f(x)  - \omega x)
$$

# Poolcoördinaten

Rechte in poolcoordinaten:
$$
r\cos (\theta - \theta_0) = d_0 \xRightarrow{} \text{ rechte door } p_0:(d_0,\theta_0)
$$
// TODO afgeleiden, en cirkel in poolcoordinaten



# Parameterkrommen

$$
y' = \frac{\frac{dy}{dt}}{\frac{dx}{dt}} \\
x' = \frac{\frac{dy'}{dt}}{\frac{dx}{dt}} \\
$$

### Verticale asymptoot

Zoek waar de $y$ naar oneindig gaat. De limiet daarnaartoe bij x is de verticale asymptoot

### Niet-verticale asymptoot

Zoek waar de $x$ naar oneindig gaat
$$
y = \omega x + b \\
\omega = \lim_{t \to t_0}\frac{y}{x} \\
b = \lim_{t \to t_0}(y  - \omega x)
$$

### Bijzondere poolkrommen

Cycloïde

![img](img/Cycloid_f.gif)
$$
{\begin{aligned}x&=r(t-\sin t)\\y&=r(1-\cos t)\end{aligned}}
$$
Epicycloïde

<img src="https://upload.wikimedia.org/wikipedia/commons/a/ae/EpitrochoidOn3-generation.gif" alt="img" style="zoom: 50%;" />
$$
{\displaystyle x(\theta )=(R+r)\cos \theta \ -r\cos \left({\frac {R+r}{r}}\theta \right)}
$$
Cardioïde

<img src="https://upload.wikimedia.org/wikipedia/commons/d/d0/Cardiod_animation.gif" alt="img" style="zoom:50%;" />
$$
\begin{equation}
    \begin{cases}
     x= r(2\cos t- \cos 2t) \\
     y= r(2 \sin t - \sin 2t)
      
    \end{cases}\,
\end{equation}
$$
Astroïde

<img src="img/HypotrochoidOn4.gif" alt="img" style="zoom:50%;" />
$$
\begin{equation}
    \begin{cases}
     x= r \cos^3 t \\
     y= r \sin^3 t
      
    \end{cases}\,
\end{equation}
$$


# Onbepaalde integralen

## Standaardintegralen

(die ik moeilijk kan onthouden)
$$
\int\frac{1}{\sqrt{a^2-x^2}}dx = Arcsin(\frac{x}{a}) + C \quad \quad a\neq 0 \newline

\int\frac{1}{\sqrt{x^2+b}}dx = ln\abs{x + \sqrt{x^2 + b}} + C \quad \quad b\neq 0 \newline
\int\frac{1}{x^2+a^2}dx = \frac{1}{a}Arctan\frac{x}{a} + C \quad \quad a\neq 0 \newline
\int\frac{1}{x^2-a^2}dx = \frac{1}{2a}ln\abs{\frac{x-a}{x+a}} + C \quad \quad a\neq 0 \newline
\int \frac{1}{ch^2x}dx = thx + c \newline
\int \frac{1}{sh^2x}dx = -cothx + c \newline
$$

## Partiële integratie


$$
\boxed{
\int f(x).g'(x) = f(x).g(x) - \int f'(x).g(x)dx
}
$$


## Rationale en irrationale functies

$$
\boxed{
\int \frac{dx}{ax^2+bx+c} \text{ of } \int \frac{dx}{\sqrt{ax^2+bx+c}}
}
$$

Maak van $ax^2+bx+c$ een volkomen kwadraat en gebruik één van de formules van hierboven.


$$
\boxed{
\int \frac{ex + f}{ax^2+bx+c}dx \text{ of } \int \frac{ex+f}{\sqrt{ax^2+bx+c}}dx
}
$$
$ax^2+bx+c$ afleiden. Dan vorm je $ex + f$ om tot een veelvoud van die afgeleide + een constante. Dan kan je de breuk opsplitsen en easy oplossen.


$$
\boxed{
\int \frac{V_n(x)}{V_m(x)}dx
}
$$

| **Als $n \geq m$**             | Als $n \leq m$                 |
| ------------------------------ | ------------------------------ |
| 1. Euclidische deling doen     | 1. Splitsen in partiëelbreuken |
| 2. Splitsen in partiëelbreuken | Winst                          |
| Winst                          | Nog winst                      |



## Recursieformule maken

Omdat dit een beetje lang is om met wiskundige symbolen uit te leggen ga ik het even in simpele mensenwoorden uitleggen.

Je gaat gewoon partieel integreren totdat je de integraal waarmee je begon opnieuw tegenkomt (meestal een veelvoud ervan). Dan heb je dus eigenlijk een vergelijking waar je beginintegraal in het linker en rechterlid staat. Dan moet je dus gewoon dat veelvoud van die integraal van beide leden aftrekken en dan heb je alleen je integraal in het linkerlid. Voor de rest weet je wel wat je moet doen. Zo niet, raad ik je aan om een hoekje te zoeken om in te gaan huilen.



## Goniometrische functies

$$
\boxed{
\int sin^nx.cos^mxdx \quad \quad m,x \in \mathbb{N}
}
$$

**m oneven**: $t = cosx$

**n oneven**: $t = sinx$

**m en n even**: dubbele hoek formules (van $cos2x$)




$$
\boxed{
\int R(sinx, cosx) \quad \quad \text{met R een rationale functie met sin en cos}
}
$$
:warning: gebruik als het mogelijk is $t = sinx$ of $t = cos(x)$

Als $R(sin,x, cosx) \neq R(-sinx, -cosx)$: 



Stel $t = tan\frac{x}{2}$
$$
dx = \frac{2dt}{1+t^2} \quad sinx = \frac{2t}{1+t^2} \quad cosx = \frac{1-t^2}{1+t^2}
$$
Als $R(sin,x, cosx) = R(-sinx, -cosx)$:

Stel $t = tanx$
$$
dx = \frac{dt}{1+t^2} \quad sin^2x = \frac{t^2}{1+t^2} \quad cos^2x = \frac{1}{1+t^2}
$$



$$
\boxed{
\int sin(mx)cos(nx)dx \quad \int sin(mx)sin(nx)dx \quad \int cos(mx)cos(nx)dx \quad
}
$$
Gebruik: 

* $2sin\alpha cos\beta = sin(\alpha - \beta) + sin(\alpha + \beta)$
* $2sin\alpha sin\beta = cos(\alpha - \beta) - cos(\alpha + \beta)$
* $2cos\alpha cos\beta = cos(\alpha - \beta) + cos(\alpha + \beta)$



## Goniometrische & hyperbolische substituties

$$
\boxed{
\int R(x, \sqrt{ax^2+bx + c})dx
}
$$

Maak van $ax^2+bx + c$ een volkomen kwadraat en gebruik dan één van de volgende substituties.

$\boxed{\int R(x, \sqrt{a^2+x^2})dx}$ : stel $x = a.sh(t)$

$\boxed{\int R(x, \sqrt{a^2-x^2})dx}$ : stel $x = a.sin(t)$ of $x = a.cos(t)$

$\boxed{\int R(x, \sqrt{x^2 - a^2})dx}$ : stel $x = a.ch(t)$





# Bepaalde integralen

// TODO bepaalde integralen in parameterkrommen

Oppervlakte vlak gebied in poolcoordinaten:
$$
S = \frac{1}{2}\int_{\theta_1}^{\theta_2}r^2d\theta
$$

### Booglengte vlakke kromme 

Carthesisch:
$$
L = \int_{x_1}^{x_2}\sqrt{1 + y'^2}dx \\
= \int_{y_1}^{y_2}\sqrt{1 + x'^2}dy \\
= \int_{t_1}^{t_2}\sqrt{(\frac{dx}{dt})^2 + (\frac{dy}{dt})^2} dt
$$
Poolcoordinaten:
$$
L = \int_{\theta_1}^{\theta_2}\sqrt{r'^2 + r^2}d\theta
$$

### Volume van omwentelingslichamen

**Schijfmethode**
$$
V_a = \pi \int_{x_1}^{x_2}r^2dx
$$
hier formule van oppervlakte cirkel, stel je allemaal cirkeltjes voor die opgestapeld worden

**Schilmethode**
$$
V_a = 2\pi \int_{x_1}^{x_2}rf(x)dx
$$
hier gebruiken ze de omtrek van de cirkel, dus we nemen telkens een grotere cylinder en stapelen die op



### Zijdelingse oppervlakte van omwentelingslichamen

$$
S_x = 2\pi\int_{x_1}^{x_2} \abs{y} \sqrt{1 + y'^2}dx \\
S_y = 2\pi\int_{y_1}^{y_2} \abs{x} \sqrt{1 + x'^2}dy \\
S_x = 2\pi \int_{t_1}^{t_2} \abs{g(t)} \sqrt{(\frac{dx}{dt})^2 + (\frac{dy}{dt})^2} dt
\quad \quad \text{met} 
\begin{equation}
    \begin{cases}
     x= f(t) \\
     y= g(t)
      
    \end{cases}\,
\end{equation}

\\
S_{poolas} = 2\pi\int_{\theta_1}^{\theta_2} r \abs{\sin \theta} \sqrt{r^2 + r'^2}d\theta
$$

### Traagheidsmoment, statisch moment en zwaartepunt

**Traagheidsmoment**
$$
I_x = \int_{(p)}^{(q)}y^2ds \quad I_y = \int_{(p)}^{(q)}x^2ds
$$
**Statisch moment**
$$
M_x = \int_{(p)}^{(q)}yds \quad M_y = \int_{(p)}^{(q)}xds
$$
**Zwaartepunt van een homogene boog**
$$
\bar{x} = \frac{M_y}{L} \quad \quad \bar{y} = \frac{M_x}{L} \quad \quad z = (\bar{x}, \bar{y})
$$
**Stellingen van guldin**

(voor dit deel stonden geen formules in de cursus, dus ik heb wat verzonnen schiet me niet neer als het niet klopt)

Zijdelingse oppervlakte = L * omtrek van de cirkel die door het zwaartefpunt van de boog beschreven wordt.
$$
S_x = 2\pi (a - \bar{y}).L \\
\text{rond rechte } y = a
\\
S_y = 2\pi (a - \bar{x}).L \\
\text{rond rechte } x = a
$$
Inhoud omwentelingsoppervlak
$$
V_x = \pi (a - \bar{y})^2.Opp_{figuur} \\
\text{rond rechte } y = a
\\
V_y = \pi (a - \bar{x})^2.Opp_{figuur} \\
\text{rond rechte } x = a
$$
