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

