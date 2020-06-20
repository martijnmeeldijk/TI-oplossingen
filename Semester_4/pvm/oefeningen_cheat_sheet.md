# C++ Cheat Sheet

Stukjes tekst uit de oefeningen/dingen van op het internet die misschien kunnen helpen bij de quiz.



## Inheritance & Constructors

> A subclass constructor will call its superconstructor prior to execute its own body.

> A subclass destructor does the opposite of constructors: it first executes its own prior, and only then calls its superdestructor.

> Each object must have a destructor. If you don't define one, the compiler generates one for you that will call the destructor of each member variable and then calls the superdestructor.

### Constructor order

Superconstructor -> Member variables -> Constructor body

### **Destructor order** 

Executing its body. -> Destroying `Bar`'s member variables. -> Calling the superdestructor.

### Copy Constructor

```c++
class Foo {
public:
	Foo(const Foo &) { std :: cout << ’C’; }
};
void bar(Foo f) { }
Foo f; // default constructor
Foo g(f); // prints C
Foo g = f; // alternative syntax , prints C
bar(foo); // Call by value , copies foo, therefore prints C (not by reference or pointer)
```

### Implicit casts

```c++
class Foo {
public:
	Foo(int) { std :: cout << "U"; } //If you put 'explicit' in front of Foo, bar(5) will give an error
};

void bar(Foo) { }

int main ()
{
	bar(5); // prints U, implicit cast
  bar (( Foo) 5);// prints U, explicit cast
}
```



## Casting

> `dynamic_cast` works only on polymorphic types, i.e. `Foo` (the supertype) needs to have at least one virtual function.

> `q` is `nullptr` because `dynamic_cast`ing to the wrong type yields `nullptr`. Calling member functions on `nullptr` is undefined.

> `static_cast`ing to the wrong type leads to undefined behaviour.

> The compiler detects that your cast can never succeed, so rejects the `static_cast`.



## Const

### References

- `int& const` : a constant (const) reference (&) to int. Since references refer to the same object since their creation, they are always constant. The const is redundant. **Some compilers warn about it, other emit errors**.
- `int const&`: reference (&) to a constant (const) int. The integer can't be modified through the reference.
- `const& int`: integer to a reference of const. This makes no sense. **This is illegal.**
- `const int&` : a reference to an int object which happens to be const. Equivalent to `int const &`

### Pointers

[bron](https://www.geeksforgeeks.org/difference-between-const-int-const-int-const-and-int-const/)

**int const\*** is pointer to constant integer

**int \*const** is a constant pointer to integer

**const int\* const** is a constant pointer to constant integer

### Functions

> Non-modifying functions should be suffixed with `const`, telling the compiler these do not change the object
>
> `const` version called if accessed through const variable
>
> non`const` version called if through nonconst variable

You can't call a non`const` function on something that's `const`:

```c++
class int_array {
	int* ns;
public:
	int& at(int index)
	{
		return ns[index ];
	}
};
const int_array arr;
int x = arr.at(0); //this is illegal
```



## Bitwise operators

**& (bitwise AND)**

**| (bitwise OR)**

**^ (bitwise XOR)**

**<< (left shift)**  :warning: bitshift werkt per bit, niet per byte

**>> (right shift)**

**~ (bitwise NOT)** 



## Automatic generation

### Default Constructor

* Simplified rule: compiler generates default constructor for you if you don’t provide any constructors yourself 

* Once you provide any constructor, no default constructor is generated 

* Generated default constructor calls default constructor for all member variables 

* Generated default constructor does not initialise member variables to 0



## To do

- [ ] copy constructor inheritance c++


- [ ] function constness





