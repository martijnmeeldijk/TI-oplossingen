# Statistiek





## Oefeningen matlab

### Reeks 1

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

### Reeks 2

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

