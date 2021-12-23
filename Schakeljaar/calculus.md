# Calculus

Een opsomming van regels en formules die ik best nuttig vind. Er ontbreken nog een heel aantal dingen. Aarzel niet om er wat aan toe te voegen.

## Afgeleiden

**The Constant Rule**:
$$
\frac{d}{dt} \big[ c f(t) \big] = c \frac{d}{dt} \big[ f(t) \big] = c f'(t)
$$
**The Sum Rule**:
$$
\frac{d}{dt} \big[ f(t) + g(t) \big] = f'(t) + g'(t)
$$
**The Product Rule:**
$$
\frac{d}{dx} \left[ f(x) g(x) \right] = f(x) g'(x) + g(x) f'(x)
$$
**The Power Rule:**
$$
\frac{d}{dx} \left[ x^{a} \right] = a x^{a-1}.
$$
**Chain Rule:**
$$
\frac{d}{dx} \big[ (f \circ g)(x)\big] = f'\big(g(x)\big)g'(x).
$$
**The Quotient Rule:**
$$
\frac{d}{dx} \left[ \frac{f(x)}{g(x)} \right] = \frac{ g(x) f'(x) - f(x) g'(x)}{g(x)^{2}}.
$$

## Integrals

**The Power Rule:**
$$
\int x^{n} \, dx = \frac{1}{n+1} x^{n+1} + C, \, \, n \neq -1.
$$

$$
\int x^{-1} dx = \ln |x| + C.
$$

**The sum rule:**
$$
\int \left[ f(x) + g(x) \right] dx = \int f(x) \, dx + \int g(x) \, dx
$$
**The Constant Rule:**
$$
\int \left[ c f(x)\right] dx = c \int f(x) \, dx
$$


## Factorization

$$
a^2 – b^2 = (a + b)(a – b)\\
a^2 + b^2 = (a + b)^2 - 2ab\\
a^3 – b^3 = (a – b)(a^2 + ab + b^2)\\
a^3 + b^3 = (a + b)(a^2 – ab + b^2)\\
(a + b + c)^2 = a^2 + b^2 +c^2 + 2ab + 2ac + 2bc
$$

## Powers

$$

\def\arraystretch{1.5} \begin{array} { c | c }\text{ Rule name} & \text{ Rule } \\ \hline \text{Product Rule} & a^m \times a^n = a^{ m + n } \\ & a ^n \times b^n = (a \times b)^ n \\ \hline \text{Quotient Rule} & a^n / a^m = a^ { n - m } \\ & a^n / b^n = (a/b) ^ n \\ \hline \text{Negative Exponent} & a^ {-n} = 1/a^n \\ \hline \text{Power Rule} & (a^n)^m = a^ { n \times m } \\ \hline \text{Tower Rule}& a ^ { n^ m } = a ^ { \left ( n^ m \right) } \\ \hline \text{Fraction Rule} & a ^ {1/n} = \sqrt[n]{a } \\ & \sqrt[m]{ a^n} = a^ { n/m} \\ \hline \text{Zero Rule} & a^0 = 1 \\ & 0^ a = 0 \text{ for } a > 0 \\ \hline \text{One Rule} & a^1 = a \\ & 1^a = 1 \\ \end{array}
 
$$

## Taylor series

$$
\begin{aligned} e^{x} & = \sum\limits_{n=0}^{\infty} \frac{x^{n}}{n!} \\ \sin(x) & = \sum\limits_{n=0}^{\infty} \frac{(-1)^{n}}{(2n+1)!} x^{2n+1} \\ \, \cos(x) & = \sum\limits_{n=0}^{\infty} \frac{(-1)^{n}}{(2n)!} x^{2n} \end{aligned}
$$

