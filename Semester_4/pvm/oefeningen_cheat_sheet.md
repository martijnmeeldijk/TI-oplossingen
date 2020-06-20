# C++ Cheat Sheet

Stukjes tekst uit de oefeningen die misschien kunnen helpen bij de quiz.

## Inheritance

> A subclass constructor will call its superconstructor prior to execute its own body.

> A subclass destructor does the opposite of constructors: it first executes its own prior, and only then calls its superdestructor.

> Each object must have a destructor. If you don't define one, the compiler generates one for you that will call the destructor of each member variable and then calls the superdestructor.



### **Destructor order** 

Executing its body. -> Destroying `Bar`'s member variables. -> Calling the superdestructor.

### Copy Constructor



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



## Bitwise operators

**& (bitwise AND)**

**| (bitwise OR)**

**^ (bitwise XOR)**

**<< (left shift)**  :warning: bitshift werkt per bit, niet per byte

**>> (right shift)**

**~ (bitwise NOT)** 



## To do

- [ ] copy constructor inheritance c++


- [ ] function constness





