# C

Een kleine compilatie van dingen die nuttig vind om nog eens na te kijken.

## Lezen/schrijven

Lezen/schrijven van één character:

```c
#include <stdio.h>
#include <ctype.h>
int main() {
  int c;
  while ((c = getchar()) != '\n')
  	putchar(toupper(c));
  return 0;
}
```



## Bewerkingen

`x*x*x` is NIET gelijk aan `pow(x,3)`. Want pow gebruikt een reeksontwikkeling en is bedoeld voor reële getallen.

Voor de rest heb ik hier niks over te zeggen



## Arrays

Declaratie:

```c
int getallen[8];
//of
const int MAX = 8;
int getallen[MAX];
//of
int n = 8; //of n inlezen...
int getallen[n];
```

Kleine sidenote. Arrays zijn standaard altijd gevuld met rommel. Als je zeker wilt zijn dat alle getallen in je array 0 zijn, moet je hem initialiseren met nullen:

```c
int array[1024] = {0}; // wordt dus {0, 0, 0, 0, ...}
```

Laatste ding. Pas op, je kan de grootte van een array niet at runtime kiezen. De compiler moet weten hoeveel geheugen hij moet vrijmaken. Gebruik dus altijd een constante om de grootte van je array te bepalen.



## Pointers

Enkele regels om te onthouden

* Nullpointer niet derefereren
* Void pointer kan je niet derefereren (`void * v`)



Een paar dingen die fijn zijn om te weten:

```c
int *x[5]; //array van pointers naar int
int (*y)[10]; //pointer naar array van int


int *t = {1,2,3}; //FOUT
int t[] = {1,2,3} //OK

```



### Pointer naar const

```c
int n = 3;
int *p = &n;
const int *q = &n; // lees van achter naar voren: * int const -> een pointer naar een int die const is

(*p)++;
(*q)++; // mag niet, const int
*p = *q; // is oke, want je kopieert de waarde van q naar p
*q = *p; // mag niet, je kan een const int niet aanpassen
p = q; // mag niet, p wijst naar een gewone int, maar q naar een const int
			 // door hem in p te steken kunnen we niet garanderen dat die int niet aangepast wordt = error
q = p; // we laten onze pointer naar een const int nu wijzen naar een gewone int
			 // hierdoor kunnen we die int nu wel niet meer aanpassen via q
```



### Pointers en arrays

```c
int t[5] = {0};
int *p, *q;

p = &t[3]; // zelfde als p = t+3;
q = p-2; 
t = p+1; // mag niet, want t is een array pointer (constante pointer) en die kan je niet verplaasen
p++;
q--;
t++; // mag niet

```



### Pointers naar pointers

```c
const int MAX = 5;
int *p; const int *pc; const int **ppc;

p = pc; // mag niet
pc = p; // oke
p = &MAX; // mag niet
(*p)++; // sure
pc = &MAX; // oke
ppc = &p; // ik denk dat dit oke is, maar het mag niet volgens Helga (oke er komt gewoon een warning)
*ppc = &MAX; // oke

```



```c
int n = 7, m = 5;
const int *p = &n;
int * const q = &n;
const int * const l = &n;

(*p)++; // mag niet
p = &m; // oke
(*q)++; // oke
q = &m; // mag niet
(*l)++; // mag niet
l = &m; // mag niet

```



### Functiepointers

Voorbeeld

```c
double som(double x, double y) { return x + y; }
double product(double x, double y) { return x * y;}

int main() {
  double (*pfun)(double, double) = &som; 
  printf("som = %f\n", pfun(5,10));
  pfun = product; //& mag weggelaten worden!
  printf("product = %f\n", pfun(5,10));
  pfun = fmin; //uit math.h
  printf("min = %f\n", pfun(5,10));
  return 0;
}
```

Array van functiepointers

```c
double som(double x, double y) { return x + y; }
double product(double x, double y) { return x * y;}

int main() {
	double (*t[])(double, double) = {som,product,fmin};
	int i;
	for (i=0 ; i<3 ; i++)
		printf("result = %f\n", t[i](10,5));
	return 0;
}
```



Functiepointer als parameter

```c
void change(double(*fp)(double), double *t, int n) { // voert gegeven functie uit op alle elementen van de array
	int i=0;
	for (i=0 ; i<n ; i++)
		t[i] = fp(t[i]);
}

int main() {
	double tab[] = {1.0,2.0,4.0,8.0};
	change(sqrt,tab,4);
}
```



## C-strings

### scanf

```c
char *s1 = "str1"; char s2[80]; char s3[] = "test";
scanf("%s",s1); // crash
scanf("%s", s2); //max. 1 woord inlezen
scanf("%s", s3); //max. 1 woord inlezen
scanf("%79s", s2); //max. 1 woord (79 karakters) inlezen
scanf("%4s",s3);
```

Veel mensen op stackoverflow zeggen dat scanf suckt.

### fgets

```c
char *s1;
char s2[80]; char s3[] = "string";
gets(s1); // mag niet
gets(s2); gets(s3); //telkens (rest van) 1 lijn inlezen
fgets(s2,80,stdin); //max. 79 karakters inlezen
fgets(s3,7,stdin); 
```

gets suckt ook, gebruik fgets

Input buffer leegmaken nadat je fgets hebt gebruikt (en niet alles eruit hebt gehaald):

```c
while ((getchar()) != '\n');
```



### Stringfuncties

ahah deze krijg je op het examen dus ik ge hier mooi niet schrijven



## Argc en argv

```c
#include <stdio.h>
int main(int argc, char** argv) {
  // argc: het aantal argumenten (vanop command line), naam van het programma wordt meegeteld
  // argv: lijst van de argumenten, naam als eerste
  if (argc == 1)
  	printf("geen extra strings meegegeven");
  else {
    for (int i=1 ; i<argc ; i++)
      printf("Hallo %s\n", argv[i]);
  }
  return 0;
}
```



## Structs

Gebruik deze syntax:

```c
typedef struct {
	double x,y;
} punt;

punt p2 = {3.5,-2.9};
punt p3 = {7.2};
punt t1[5] = {{1.2,-1.2},{5.1,4.6}};
punt t2[3] = {0}; // alles 0
p2 = {6.2,3.8}; // mag niet
```



## Malloc

```c
punt* lees_punt() {
  punt *p = (punt *) malloc(sizeof(punt));
  printf("x-coordinaat: ");
  scanf("%lf",&p->x);
  printf("y-coordinaat: ");
  scanf("%lf",&p->y);
  return p;
}

// oproepen
punt *p = lees_punt(); … ; free(p); //daarna ook geheugen vrijmaken
```

`calloc` doet hetzelfde als `malloc`, maar zet het geheugen op 0;

Realloc:

```c
void* realloc(void *toegewezen_pointer,
size_t totaal_aantal_bytes) // hergebruikt geheugen
```



## Linked lists

### Definitie

```c
typedef struct knoop knoop;
struct knoop {
  int getal;
  knoop *next;
};
```

### Overlopen

```c
void print_lijst(const knoop *lst) {
  while (lst) {
    printf("%d\n", lst->getal);
    lst = lst->next;
  }
}
```

### Opbouwen

```c
knoop* maak_lijst() {
  knoop *l = 0;
  int g; scanf("%d",&g);
  if (g) {
    l = (knoop*) malloc(sizeof(knoop));
    knoop *h = l; h->getal = g;
    scanf("%d",&g);
    while (g) {
      h->next = malloc(sizeof(knoop));
      h = h->next; h->getal = g; scanf("%d",&g);
    }
    h->next = 0;
  }
  return l;
}
```

### Element verwijderen

```c
void verwijder_element(knoop **pl, int g) {
  if (*pl) {
    if ((*pl)->getal == g) {
    	knoop *m = *pl; *pl = (*pl)->next; free(m);
    }
    else {
      knoop *h = *pl;
      while (h->next && h->next->getal != g)
      h = h->next;
      if (h->next) {
        knoop *m = h->next;
        h->next = m->next; free(m);
      }
    }
  }
}

// lijst vernietigen
void vernietig_lijst(knoop **pl) {
  while (*pl) {
    knoop *h = *pl;
    *pl = h->next;
    free(h);
  }
}
```



### Voor -en nadelen

* Voordelen
  * Vooraan of tussenin (achter een bestaande knoop) een knoop toevoegen kan snel. 
  * Achteraan een knoop toevoegen kan ook snel als men over een wijzer beschikt naar de laatste knoop. 
  * Een knoop verwijderen lukt snel als men naast de opvolger ook de voorganger van de knoop kent.
* Nadelen
  * De i-de knoop kan men niet direct bekomen. Eerst moeten alle voorgangers overlopen worden. 
    * Indexeren ([ ]) is een dure operatie 
  * Een gelinkte lijst verbruikt meestal iets meer geheugen dan een tabel doordat elke knoop pointers moet bijhouden. Bovendien zorgt de verspreiding in het geheugen voor performantieverlies. 

## Bitoperatoren

| Operator | Beschrijving         |
| -------- | -------------------- |
| a & b    | bitwise AND          |
| a \| b   | bitwise OR           |
| a ^ b    | bitwise XOR          |
| ~a       | bitwise NOT          |
| a >> i   | shift right (i bits) |
| a << i   | shift left (i bits)  |



# C++





## Strings

```c++
std::string s, t; …
if (s < "tomaat") … //komt s alfabetisch voor "tomaat"?
if (s >= t) … //is s alfabetisch groter dan t?
if (s == "stop") … //bevat s het woord "stop"?
```



## Default parameters

```c++
void schrijf_lijn(char =ꞌ-ꞌ, int = 80); // default parameters moeten vanachter staan
void schrijf_lijn(char =ꞌ-ꞌ, int); // fout
```



## Reference types

```c++
int &y; // fout, je moet ze altijd initialiseren

// juist gebruik:
void swap(int &, int &);
int main() {
	int a = 5, b = 6;
	swap(a, b); // verwissel a en b
}
void swap(int &x, int &y) {
	int h = x;
	x = y;
	y = h;
}
```



## Templates

Voorbeeld

```c++
template <typename T>
void wissel( T & a, T & b) {
	T hulp = a;
	a = b;
	b = hulp;
}

// als je er twee wilt
template <typename T1, typename T2>
T1 functie_naam(int i, const T1 &t1, const T2 &t2);
```



## Console input

```c++
// 2 manieren
std::string s;
std::cin >> s; // leest 1 woord

// of

std::string s;
getline(std::cin, s); // lezen tot newline
```

```c++
// char lezen
char a;
std::cin >> a; // kan geen whitespaces lezen

char a;
a = std::cin.get(); //of: a = getchar();  kan wel whitespaces lezen
```



## Bestanden

Openen

```c++
#include <fstream>
#include <iostream>
using namespace std;

int main() {
	ifstream inv; inv.open("b1.txt");
	if (inv.is_open()) 
    cout << "openen gelukt";
	ofstream uit1, uit2;
	uit1.open("c:\\b2.txt");
	string s = "b3.txt";
	uit2.open(s, ios::app); // append mode, dan clear je het bestand niet als je schrijft
	return 0;
}
```

Lezen/schrijven

```c++
int getal;
inv >> getal;

char ch;
ch = inv.get();

string lijn;
getline(inv, lijn);
uitv1 << getal << " " << ch << " " << lijn << endl;
```

Fouten opvangen

```c++
while (!inv.fail()) {
		… //doe iets met wat je ingelezen hebt
		… //lees iets in uit het bestand (2)
	}
	if (inv.eof())
		… //OK: bestand werd volledig gelezen
	else
		… //FOUT: bestand bevat foutieve gegevens
```

Sluiten

```c++
inv.close();
uitv1.close();
uitv2.close();
```

Pas op met streams. Je moet ze best altijd by reference doorgeven want als je ze kopieert krijg je een fout.

```c++
void lees_en_schrijf_getal(ifstream &inv) { //goed
	int getal;
	inv >> getal; cout << getal;
}
```



## Functioneel programmeren

### Functies als parameter

```c++
#include <functional>
using namespace std;
bool zoek(const string t[], int n, function<bool (const string&)> func) { … }

// function<[return type] ([parameters])> naam
```



### Lambda's

```c++
[ captures ] (parameterlijst) -> returntype { statements }
```

Met een **capture** kan je de lambda toegang geven tot de variabelen in de omliggende scope (waar hij normaal geen toegang tot heeft)

Lijstje gepikt van de slides:

* `[]` captures nothing : de lambda functie kent enkel variabelen die meegegeven worden als parameter 
*  `[a,&b]` a is captured by value, b is captured by reference.  a is read-only. Vb: a++; – [&] captures all variables in the body of the lambda by reference 
*  `[&,b]` captures all variables in the body of the lambda by reference, but b is captured by value 
* ` [=]` captures all variables in the body of the lambda by value 
* `[=, &b]` captures all variables in the body of the lambda by value, but b is captured by reference

Voorbeeldje van het gebruik van een lambda:

```c++
if (zoek( mail, 4, [] (const string& addr) { return addr.find(".be")!=-1; }))
```



## Smart pointers

`unique_ptr`

```c++
unique_ptr<int> p1; // p1 is nullptr
p1 = make_unique<int>(); //sinds C++14; *p1 is 0
unique_ptr<int> p2 = make_unique<int>(202); //*p2 is 202
*p1 = 101; cout << *p1;
p2 = p1;
p1.swap(p2); // wisselt pointers
p2 = move(p1); // transfereert eigenaar; p1 is nullptr
p2.reset(); // geeft geheugen vrij
// gebeurt automatisch bij out of scope 
```



`shared_ptr`

```c++
shared_ptr<int> p1, p2; // p1 en p2 zijn nullptr
p1 = make_shared<int>(101);
p2 = p1; // beide zijn nu eigenaar
p2.reset(); // geeft geheugen nog niet vrij (wegens p1)
p1.reset(); // geeft geheugen vrij (gebeurt automatisch
// bij out of scope van alle eigenaars)
```



## Collections

Een paar nuttige dingen die ik wel wil onthouden

Vectors:

```c++
vector<int> v(n); // size n, capaciteit n
cout << v.front(); v.front() *= 2; // Geeft referentie naar het 1e element vd vector terug
cout << v.back(); // Geeft referentie naar laatste element vd vector terug 
cout << v.at(2)++; // Geeft referentie naar element op index i terug (en incrementeert hem)
v.clear(); // wist de vector
v.pop_back(); // verwijdert laatste element
v.resize(int n); // maakt de vector n groot
v.reserve(int n); //  Capaciteit van de vector wordt minstens n (capaciteit wordt niet verkleind, inhouden worden niet geïnitialiseerd -> grootte (size) blijft onveranderd)
```



Een **multiset** is een set waar je wel duplicaten in kan hebben.

### Iterators

Een iterator de lijst laten overlopen

```c++
list<string> l; ...
list<string>::iterator it = l.begin();
while (it != l.end()) { //niet: it < l.end()
	cout << *it << endl;
	it++;   // kan korter: cout << *it++ << endl;
}
```



## Klassen

Onthoud: default is alles private. Dus best alles expliciet aangeven.

* **mutators** = setters
* **accessors** = getters

Zet `const` na de parameterlijst van elke functie die geen klassenattributen wijzigt.

zo dus: 

```c++
class voorbeeld {
	public:
		void set_a(int = -1); // hier dus zeken geen const zetten
		int get_a() const;
	private:
		int a, b;
};

int voorbeeld::get_a() const {
	return a;
}
```

### Constructor

```c++
// Default constructor oproepen
myclass a;

// Constructor met argumenten
myclass a(1);

// Zelfde maar op de heap
myclass *a = new myclass;
myclass *a = new myclass(1);
delete a; // moet je altijd doen, anders wordt het geheugen niet vrijgegeven
```

Initializer list

```c++
A(const B &b, int i) : attr1(b), attr2(i) { … } // attr1 en attr2 worden gezet voor de rest van de constructor wordt betreden
```

Delegerende constructor 

```c++
class voorbeeld {
	public:
		voorbeeld(int _a, int _b) {
			a = _a; b = _b;
		}
		voorbeeld() : voorbeeld(1,2) {}
	private:
		int a, b;
};
```



### Destructor

Moet je alleen aanpassen als je iets van dynamisch geheugenbeheer doet (new).



### Copy constructor

De copy constructor is default altijd aanwezig en wordt gebruikt als je je object by value meegeeft. Hij kopieert je object, maar niet het dynamisch aangemaakt geheugen. Dus als je raw pointers enzo gebruikt, ga je de copy-constructor zelf moeten defineren.

```c++
A(const A &a) // neemt een reference naar je object
```



### Friend functies

Als je een functie toegang wilt geven tot private attributen en methoden van de klasse. Je kan zelfs een andere klasse als friend opgeven. Dan heeft die klasse toegang tot jouw private shit (maar niet omgekeerd). Kleine sidenote, friend schendt eigenlijk de OO principes, maar de boys van c++ vonden het toch handig voor efficientie en operator overloading.

```c++
class A {
	int i;
	public:
		A(int _i=0) : i(_i) {}
		int get_i() const;
		friend int fr(const A &);
};

int A::get_i() const { return i; } // je moet friend hier niet schrijven, alleen binnen de klasse
int fr(const A &a) { return a.i; }

int main() {
	A a(7); cout << a.get_i() << " " << fr(a);
	return 0;
}
```



### Operator overloading

```c++
class tijd {
	private:
		int uur, min, sec;
		void herbereken();
	public:
		…
		tijd operator+(const tijd &) const;
		tijd operator*(int) const;
		bool operator<(const tijd &) const;
}; 

tijd tijd::operator+(const tijd &t) const {
	tijd som(uur+t.uur, min+t.min, sec+t.sec); // haha dit is nog wel echt skeer maar oke i'll allow it
	return som;
}
tijd tijd::operator*(int factor) const {
	return tijd(uur*factor, min*factor, sec*factor);
}
bool tijd::operator<(const tijd &t) const {
	return uur*3600+min*60+sec <
	t.uur*3600+t.min*60+t.sec;
}

// je kan ook unaire operatoren overloaden
tijd operator-() const {
	return tijd(-uur, -min, -sec);
}
// die is niet hetzelfde als deze 
tijd operator-(const tijd &t) const;

// toekenningsoperatoren
tijd& tijd::operator+=(const tijd &t) {
	sec += t.sec; min += t.min; uur += t.uur;
	herbereken(); 
  return *this;
}

// Je moet een beetje oppassen met het verschil tussen prefix en postfix operatoren
class A {
  public:
    A& operator++(); // ++x
    A operator++(int); // x++, de int duidt hier het verschil aan, maar wordt niet gebruikt
    A& operator--(); // --x
    A operator--(int); // x--
}; 

tijd& tijd::operator++() {
	sec++; 
  herbereken(); 
  return *this;
}
tijd tijd::operator++(int a) {
	tijd temp(*this);
	sec++; 
  herbereken(); 
  return temp;
}
```



Iostream operatoren overloaden:

```c++
class tijd {
	…
	friend ostream& operator<<(ostream& os, const tijd& t);
	friend istream& operator>>(istream& is, tijd& t);
};

ostream& operator<<(ostream& os, const tijd& t) {
	os << setw(2) << setfill('0') << t.uur << ':' << …
	<< setw(2) << setfill('0') << t.sec;
	return os;
}

istream& operator>>(istream& is, tijd& t) {
	is >> t.uur >> t.min >> t.sec; t.herbereken();
	return is;
}
```



### Templates

```c++
template <typename T> //meerdere typenames mogelijk
class koppel { //hier géén <T> toevoegen!!
	public:
		koppel(); //hier géén <T> toevoegen!!
		koppel(const T&,const T&); (*)
		void set_first(const T&);
		T get_first() const; (*)
		koppel<T> operator+(const koppel<T> &) const;
	private:
		T first, second;
};

template <typename T>
koppel<T>::koppel(const T& _first, const T& _second): first(_first), second(_second) {}
// bij de definitie moet je ook nog template schrijven
```



### Inheritance

Een paar aandachtspunten:

* Private inheritance
  * Inheritance is **private by default**. Aanpassen dus! 
  * Publieke leden van basisklasse worden private leden van afgeleide klasse
  * De programmeur van de afgeleide klasse kan gebruik maken van de lidfuncties van de basisklasse, maar deze zijn ontoegankelijk voor de gebruikers van de afgeleide klasse
  * Objecten van type student kunnen de publieke lidfuncties van persoon NIET gebruiken
* Public inheritance
  * doet wat je verwacht
  * expliciet aangeven!
* Constructoren worden **niet default overgeerfd**
  * Er worden wel automatisch default constructors en copy constructors aangemaakt die de default constructor van de basisklasse oproepen
* Indien de constructor van de afgeleide klasse geen constructor van de basisklasse oproept, wordt automatisch de default constructor van de basisklasse opgeroepen 
* De constructor van de afgeleide klasse kan de constructor van de basisklasse enkel oproepen via de **initializer list**
* Wanneer de destructor van de afgeleide klasse opgeroepen wordt, roept deze **automatisch** de destructor van de basisklasse op



Om de constructor van de superklasse op te roepen gebruik je `using`:

```c++
class A {
	public:
    A(int vA1=-1, int vA2=-2);
    int getVarA1() const;
    int getVarA2() const;
  private:
  	int varA1, varA2;
};
class B : public A {
  public:
  	using A::A; // je kan wel geen specifieke constructoren overerven: using A::A(int); is fout
  	int getVarB() const;
  private:
  	int varB;
};
```

Constructor verwijderen:

```c++
class B : public A {
  public:
  	using A::A;
  	B(int) = delete;
};
```



### Toekenningsoperator overschrijven

```c++
B& B::operator=(const B &b) {
  if (this != &b) {
  	A::operator=(b);
  	… // assign extra members of B
  }
  return *this;
}
```



### Multiple inheritance

> The "**diamond problem**" (sometimes referred to as the "Deadly Diamond of Death"[[6\]](https://en.wikipedia.org/wiki/Multiple_inheritance#cite_note-6)) is an ambiguity that arises when two classes B and C inherit from A, and class D inherits from both B and C. If there is a method in A that B and C have [overridden](https://en.wikipedia.org/wiki/Method_overriding_(programming)), and D does not override it, then which version of the method does D inherit: that of B, or that of C?

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Diamond_inheritance.svg/220px-Diamond_inheritance.svg.png" alt="img" style="zoom:50%;" />

Kan je oplossen door B en C virtual te maken.



### Dynamic binding

* Regels voor dynamic binding: 
  * signatuur (= returntype, # en type parameters) van de methode in basisklasse en afgeleide klasse moeten gelijk zijn! 
  * methode in basisklasse moet virtueel zijn. 
  * methode in afgeleide klasse mag (maar moet niet) virtueel zijn.

Dit is een beetje lijp. Methodes zijn dus niet by default virtueel (zoals in java). Weeral om performatieredenen.



### Virtuele destructor

Maak de destructor gewoon altijd virtueel bij overerving (ook op het examen :wink:)

Indien gewone destructor in basisklasse: enkel destructor van basisklasse wordt opgeroepen!!



### Abstracte klassen

Een klasse is abstract als ten minste één lidfunctie puur virtueel is.

```c++
class Figuur {
  public:
  virtual void draw() const = 0;
  ...
};
```



## C++ 11

Vanaf c++11 kan je initialiseren met accolades.

```c++
class A {
  int x;
  int y[4];
  public:
  	A(int _x=0) : x{_x}, y{1,2,3,4} {}
};
int main() {
	A a{3};
	int b{2};
	int *t = new int[3] {1,2,3};
	vector<int> v = {10,20};
	return 0;
}
```

Je kan ook attributen binnen een klasse initialiseren met accolades:

```c++
class A {
  int x = 7;
  int y{9};
  public:
  	A() {}
};
```



### Move constructor/operator

```c++
int main() {
  vector<set<int>> v;
  for (int i=1; i<=3; i++) {
    set<int> s1, s2;
    … // voeg iets toe aan s1
    v.push_back(move(s1));
    … //voeg opnieuw iets toe aan s1
    s2 = move(s1);
  }
}
```

Hoe move constructor/operator schrijven? 

* attribuut dat geen pointer of primitief type is: kan (meestal) a.d.h.v. de overeenkomstige move constructor/operator van het attribuut 
* attribuut dat pointer is: neem ondiepe kopie (dus geen extra verplaatsing in geheugen) én zet originele pointer op nullptr 
* attribuut dat primitief type is: neem kopie én zet originele variabele op 0

```c++
class A {
  public:
    A(const A &); // copy constructor
    A(A &&); // move constructor
    …
  private:
    vector<int> vA;
    int grA;
    int *tA;
};
```



```c++
class A {
  public:
    A& operator=(const A &); // toekenningsoperator
    A& operator=(A &&); // move operator
    …
  private:
    vector<int> vA;
    int grA;
    int *tA;
};
```



## The big five

* operator= 
* copy constructor 
* destructor
* move constructor (nieuw sinds c++11)
* move operator (nieuw sinds c++11)



**Vóór C++11**: rule of three 

If a class requires a user-defined destructor, a user-defined copy constructor or a user-defined copy assignment operator, it almost certainly requires all three. 

**Sinds C++11**: rule of five 

If you define or =delete any default operation (= destructor, copyconstructor, copy-assignment, move constructor and the move assignment operator), define or =delete them all. 

(kan een leuke examenvraag zijn)



**Rule of zero** 

Classes that have custom destructors, copy/move constructors or copy/move assignment operators should deal exclusively with ownership (which follows from the Single Responsibility Principle). Other classes should not have custom destructors, copy/move constructors or copy/move assignment operators.

Als je het kan vermijden om defaultoperaties te defineren, doe dat dan.



## Exceptions

Exception gooien

```c++
int fac(int getal) {
  if (getal < 0)
  	throw "exceptie: negatief getal!";
  int res = 1;
  for (int i = 2 ; i <= getal ; i++)
    res *= i;
  return res;
}
```

Exception vangen:

```c++
int main() {
	int getal;
	cin >> getal;
  try {
  	cout << fac(getal) << endl;
  }
  catch (const char *s) { cout << s << endl; } // we vangen alleen exceptions van het type c-string
  return 0;
}
```

Catch-all

```c++
int main() {
  int getal;
  cin >> getal;
  try {
  	cout << fac(getal) << endl;
  }
  catch (...) { cout << "oei, een exceptie" << endl; }
  return 0;
}
```

Bestaande exception-klasse gebruiken:

```c++
#include <stdexcept> // nodig voor excepties
using namespace std;

int main() {
  vector<int> v = {8,10,12};
  try {
  	int i = v.at(v.size()); // 1tje te ver
  }
  catch (const out_of_range& e) {
  	cout << "Exceptie: " << e.what();
	}
}
```



Zelf exception maken:

```c++
#include <stdexcept>
using namespace std;

class file_error : public runtime_error { // klasse exception heeft geen constructor met std/c-string als parameter -> klasse beter niet afleiden van exception
  public:
    file_error() : runtime_error("can't open file") {}
    file_error(const string &what) :
    runtime_error(what) {}
};
```

En gebruiken dan:

```c++
#include "file_error.h"
void openFile(string fname, ifstream& in) {
  in.open(fname);
  if (!in)
  throw file_error("Can't open file " + fname);
}
int main() {
  string file_name = "test.txt"; ifstream inv;
try {
  openFile(file_name, inv); …
}
  catch (const file_error& fe) { cout << fe.what(); }
}
```





# Notes to self

* const niet vergeten (ook achter functies die niks aanpassen)
* `[] (const string& addr) { return addr.find(".be")!=-1; }` -> c++ lambda
* `function<[return type] ([parameters])> naam` -> functie als parameter in c++
* `double(*fp)(double)` functiepointer als parameter in c
* 

