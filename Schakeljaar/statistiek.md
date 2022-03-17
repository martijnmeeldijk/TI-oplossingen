# Statistiek





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

