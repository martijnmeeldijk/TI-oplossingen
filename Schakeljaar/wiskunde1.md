# Wiskunde 1



# Integratietechnieken

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