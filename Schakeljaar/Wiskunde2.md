# Wiskunde II

Eigenlijk meer een formularium dan een samenvatting.



# 1 - Ruimtemeetkunde

## Vlakken

**Carthesische vergelijking**

Vlak: $\alpha:\;ax+by+cz+d=0$ heeft normaalvector: $\overrightarrow{n_\alpha}=\left\{a,b,c\right\}$

Je kan een vlak bepalen d.m.v. een punt en een normaalvector. We gebruiken $\overrightarrow{n_\alpha}$ en $p(x_1,y_1,z_1)$ en bekomen:
$$
a(x-x_1) + b(y-y_1) + c(z-z_1) = 0\\
$$
dit herleiden we tot
$$
\alpha:\;ax+by+cz+d=0
$$



**Determinantvorm**

Vergelijking vlak door een punt $p(x_1,y_1,z_1)$ en 2 onafhankelijke richtingsvectoren $\overrightarrow u=\left\{u_x,u_y,u_z\right\}$ en $\overrightarrow v=\left\{v_x,v_y,v_z\right\}$
$$
\gamma:\;\begin{vmatrix}x-x_1&y-y_1&z-z_1\\u_x&u_y&u_z\\v_x&v_y&v_z\end{vmatrix}=0
$$







**Parametervergelijking**
$$
\gamma:\;\left\{\begin{array}{l}
x = x_1 + ku_x + lv_x
\\y = y_1 + ku_y + lv_y \quad \quad \text{met } k,l \in \mathbb{Z}
\\z = z_1 + ku_z + lv_z

\end{array}\right.
$$


**Hoek tussen 2 vlakken**

met $\overrightarrow{n_1}$ en $\overrightarrow{n_2}$ de normaalvectoren van de vlakken.
$$
\cos\theta = \frac{\overrightarrow{n_1}\cdot \overrightarrow{n_2}}
{\lvert\lvert\overrightarrow{n_1}\rvert\rvert \cdot  \lvert\lvert\overrightarrow{n_2}\rvert\rvert}
$$
**Onderlinge stand**

> Twee vlakken zijn **evenwijdig** als hun normaalvectoren evenwijdig zijn.

> Twee vlakken zijn **orthogonaal** als hun normaalvectoren loodrecht op elkaar staan.

> Een rechte is **evenwijdig** met een vlak als als de richtingsvector van de rechte **loodrecht** staat op de normaalvector van het vlak.

> Een rechte staat **loodrecht** op een vlak als zijn richtingsvector **evenwijdig** is met de normaalvector van het vlak.


## Rechten

**Rechte als snijlijn van 2 vlakken**
$$
R:\;\left\{\begin{array}{l}a_1x+b_1y+c_1z+d_1=0\\a_2x+b_2y+c_2z+d_2=0\end{array}\right.
$$
heeft richtingsvector $\overrightarrow{u_R}=\overrightarrow{n_1}\times\overrightarrow{n_2}$

met:
$$
\overrightarrow{n_1}=\left\{a_1,b_1,c_1\right\} \\
$$

$$
\overrightarrow{n_2}=\left\{a_2,b_2,c_2\right\}
$$





**Carthesische vergelijking** 

Carthesische vergelijking van rechte door punt $p(x_1,y_1,z_1)$ richtingsvector $\overrightarrow u=\left\{u_x,u_y,u_z\right\}$
$$
\frac{x-x_1}{u_x}=\frac{\displaystyle y-y_1}{\displaystyle u_y}=\frac{\displaystyle z-z_1}{\displaystyle u_z}
$$

**Hoek tussen twee rechten**
$$
\cos\theta = \frac{\overrightarrow{u_1}\cdot \overrightarrow{u_2}}
{\lvert\lvert\overrightarrow{u_1}\rvert\rvert \cdot  \lvert\lvert\overrightarrow{u_2}\rvert\rvert}
$$


**Hoek tussen een rechte en een vlak**
$$
\sin\theta = \frac{\overrightarrow{u}\cdot \overrightarrow{n}}
{\lvert\lvert\overrightarrow{u}\rvert\rvert \cdot  \lvert\lvert\overrightarrow{n}\rvert\rvert}
$$
**Ondelinge stand**

> Twee rechten zijn evenwijdig als hun richtingsvectoren **evenwijdig** zijn.

> Ze zijn **orthagonaal** als hun richtingsvectoren loodrecht op elkaar staan.

> Ze zijn **snijdend** als ze samen een vlak bepalen (je kan dan ook een snijpunt vinden). Anders zijn ze **kruisend**.

## Afstanden

**Afstand tussen 2 punten** $a(x_1,y_1,z_1)$ en $b(x_2,y_2,z_2)$:
$$
d(a,b)=\sqrt{\left(x_2-x_1\right)^2+\left(y_2-y_1\right)^2+\left(z_2-z_1\right)^2}
$$







**Afstand tussen punt en vlak**
$$
d(p_1, \alpha) = \frac{\left| ax_1 + by_1 + cz_1 +d \right|}{\sqrt{a^2 + b^2 + c^2}}
$$

punt $p_1(x_1,y_1,z_1)$ en vlak $\alpha:\;ax+by+cz+d=0$



**Afstand punt tot rechte**

//todo



**Afstand tussen 2 rechten**

//todo







## Boloppervlak & Cirkel

**Boloppervlak**
$$
(x-x_0)^2 + (y-y_0)^2 + (z-z_0)^2 = R^2
$$

met middelpunt $m(x_0,y_0,z_0)$ en straal R





**Cirkel**

Als snijlijn van een bol en een vlak.
$$
R:\;\left\{\begin{array}{l}
(x-x_0)^2 + (y-y_0)^2 + (z-z_0)^2 = R^2
\\
ax+by+cz+d=0\end{array}\right.
$$


## Inhoud ruimtelichamen

Kan altijd van pas komen.

<img src="img/volume_ZO.png" alt="img" style="zoom: 50%;" />





# 2 - Functies van meerdere veranderlijken



## Gradiënt

De gradiënt in een punt $p$ van een scalaire functie $\varphi$ geeft de richting van grootste verandering in dat punt.
$$
\overrightarrow\nabla\varphi=\left\{\frac{\partial\varphi}{\partial x},\frac{\partial\varphi}{\partial y},\frac{\partial\varphi}{\partial z}\right\}
$$


## Lineaire benadering

als je bijvoorbeeld $1.02^{3.01}$ moet berekenen

* $\triangle x = 0.02$ 
* $\triangle y = 0.01$ 
* $z=x^y$ in $(1,3)$

$$
f(x_p+\triangle x,y_p+\triangle y)\approx f(x_p,y_p)+{\left(\frac{\partial f}{\partial x}\right)}_p\cdot\triangle x+{\left(\frac{\partial f}{\partial y}\right)}_p\cdot\triangle y
$$



## Vergelijking raakvlak aan oppervlak

In het punt $p(x_0, y_0, z_0)$ aan $\varphi(x,y,z)$
$$
\left(  \frac{\partial\varphi}{\partial x} \right)_p (x-x_0)
+ \left(  \frac{\partial\varphi}{\partial y} \right)_p (y-y_0)
+ \left(  \frac{\partial\varphi}{\partial z} \right)_p (z-z_0)
=0
$$


## Vergelijking normaal aan oppervlak

In het punt $p(x_0, y_0, z_0)$ aan $\varphi(x,y,z)$
$$
\frac{x-x_0}{\left(  \frac{\partial\varphi}{\partial x} \right)_p}
=\frac{y-y_0}{\left(  \frac{\partial\varphi}{\partial y} \right)_p}
=\frac{z-z_0}{\left(  \frac{\partial\varphi}{\partial z} \right)_p}
$$


## Totale differentiaal van de eerste orde

$$
df = \frac{\partial\varphi}{\partial x}dx + \frac{\partial\varphi}{\partial y}dy + \cdots \text{ voor alle variabelen}
$$



## Vergelijking raaklijn in een punt van een kromme

In het punt $p(x_0, y_0, z_0)$ aan de snijlijn van de krommen:
$$
\;\left\{\begin{array}{l}
\varphi(x,y,z) = 0
\\
\psi(x,y,z) = 0
\end{array}\right.
\\
$$
De raaklijn is de snijlijn van de twee raakvlakken. We krijgen een richtingsvector van de raaklijn door het vectorieel product te nemen van de normaalvectoren. 
$$
\\
\left\{
\left(\frac{\partial\varphi}{\partial x} \right)_p,
\left(\frac{\partial\varphi}{\partial y} \right)_p,
\left(\frac{\partial\varphi}{\partial z} \right)_p
\right\}
\times
\left\{
\left(\frac{\partial\psi}{\partial x} \right)_p,
\left(\frac{\partial\psi}{\partial y} \right)_p,
\left(\frac{\partial\psi}{\partial z} \right)_p
\right\}
$$
Dan gebruik je de [formule](#rechten) om de vergelijking van een rechte op te stellen aan de hand van een richtingsvector en een punt.

### Normaalvlak

Het normaalvlak in $p$ staat loodrecht op de raaklijn. Je kan de bovenstaande vector hier dus voor hergebruiken. Doe [dit](#vlakken). Je gaat wel nog $d$ moeten zoeken. Dat kan je door het punt in de bekomen vergelijking in te vullen.





## Raaklijn aan parameterkromme

$$
\;\left\{\begin{array}{l}
x = f_1(t)
\\
y = f_2(t)
\\
z = f_2(t)
\end{array}\right.

\\
\\
\text{richtingsvector raaklijn: } \{f_1'(t_0), f_2'(t_0), f_3'(t_0)\}
\\\\
\text{raaklijn in $p$: }\\ \frac{x-x_0}{f_1'(t_0)} = \frac{y-_y0}{f_2'(t_0)} = \frac{z-z_0}{f_3'(t_0)}
\\\\
\text{normaalvlak in $p$: }\\ f_1'(t_0)(x-x_0) + f_2'(t_0)(y-y_0) + f_3'(t_0)(z-z_0) = 0
$$



## Extrema

Vind alle punten waarvoor:
$$
\left\{\begin{array}{l}{\left(\frac{\partial z}{\partial x}\right)}_p=0\\{\left(\frac{\partial z}{\partial y}\right)}_p=0\end{array}\right.
$$
Bereken voor elk punt de vereenvoudigde discriminant:
$$
\triangle_p=\left(\frac{\partial^2z}{\partial x\partial y}\right)_p^2-{\left(\frac{\partial^2z}{\partial x^2}\right)}_p\cdot{\left(\frac{\partial^2z}{\partial y^2}\right)}_p
$$

* $\triangle_p>0$: $p$ is een zadelpunt
* $\triangle_p<0$: $p$ is een extremum
  * ${\left(\frac{\partial^2z}{\partial x^2}\right)}_p>0$: $p$ is een minimum
  * ${\left(\frac{\partial^2z}{\partial x^2}\right)}_p<0$: $p$ is een maximum
  * ${\left(\frac{\partial^2z}{\partial x^2}\right)}_p=0$: verder onderzoek nodig



# 3 - Dubbelintegralen

## Oppervlakte vlak gebied

$$
\begin{align}
S &= \iint_Gds 
\\
&= \iint_Gdxdy 
\\
&=\iint_G \operatorname r dr d\theta
\end{align}
$$

## Inhoud lichaam

Met $G$ een gebied in het $XY$-vlak.
$$
V=\iint_G\left|f(x,y)\right|\operatorname dS
$$


## Oppervlakte van een oppervlak

Met $G$ een gebied in het $XY$-vlak.
$$
\sigma=\iint_G\sqrt{1+\left(\frac{\partial f}{\partial x}\right)^2+\left(\frac{\partial f}{\partial y}\right)^2} dS
$$






## Jacobiaan

$$
\\
\left\{\begin{array}{l}
{x=g(u,v)}
\\
{y=h(u,v)}
\end{array}\right.
\\\\
dxdy = |J(u,v)|dudv \\\\
J =
\begin{vmatrix}
\frac{\partial x}{\partial u} & \frac{\partial x}{\partial v} \\
\frac{\partial y}{\partial u} & \frac{\partial y}{\partial v}
\end{vmatrix}

\\ \\
\iint_Gf(x,y) dxdy = \iint_Gf(g(u,v), h(u,v)) \space |J(u,v)|dudv
$$

### Overgang naar poolcoördinaten

Je kan de Jacobiaan dus ook gebruiken om over te gaan naar poolcoördinaten. Deze is gelijk aan $r$. 
$$
\\
\left\{\begin{array}{l}
{x=r\cos\theta}
\\
{y=r\sin\theta}
\end{array}\right.
\\\\
J =
\begin{vmatrix}
\cos \theta & -r\sin\theta \\
\sin \theta & r\cos \theta
\end{vmatrix} = r
\\\\
\iint_Gf(x,y) dxdy = \iint_Gf(r\cos \theta, r\sin \theta) r \space drd\theta
$$

## Traagheidsmoment en Statisch moment

Beide zijn altijd ten opzichte van één as. Dus $a$ is de afstand van $dS$ tot die as.

**Traagheidsmoment**
$$
I_a = \iint_G a^2 dS
$$
**Statisch moment**
$$
M_A = \iint_G a \space dS
$$

### Zwaartepunt 

$$
\overline{x} = \frac{M_y}{S} \quad \quad \overline{y} = \frac{M_x}{S}
\\ 
z = (\overline{x},\overline{y})
$$

