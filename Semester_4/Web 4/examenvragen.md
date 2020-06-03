# Examenvragen webontwikkeling 4

(en mogelijke antwoorden)

## Theorievragen



### Wat betekent asynchroon?

> introduces the idea of a “partial screen update” to the web application model
>
> * only the user interface elements that contain new information will be updated
> * the rest of the user interface will be unchanged

In de context van dit vak betekent asynchroon dus dat als er een verandering is die getoond moet worden aan een gebruiker, dat dan niet heel de webpagina herladen moet worden. Een stukje van de webpagina wordt dan vervangen door nieuwe data.

### Leg de 5 verschillende toestanden van het XMLHttpRequest object uit?

```
UNSENT = 0; // initial state
OPENED = 1; // open() has been called
HEADERS_RECEIVED = 2; // response headers received
LOADING = 3; // response is loading (a data packed is received)
DONE = 4; // request complete
```



```
xhr.onreadystatechange = function() {
  if (xhr.readyState == 3) {
    // loading
  }
  if (xhr.readyState == 4) {
    // request finished
  }
};
```



### Wat is een nadeel van polling?

Elke zoveel seconden vraagt de client: "hey server, heb je iets nieuws voor mij?". Meestal is het antwoord "Nee, sorry". Er wordt dus veel bandbreedte verspild aan verkeer zonder nuttige data.

Er is ook iets, genaamd **long polling**. De client stuurt een request naar de server, en de server antwoordt pas als er iets nieuws is voor de client. De connectie wordt dus voor een langere tijd open gehouden. Vaak heb je dan het probleem dat de server niet genoeg connecties tegelijk open kan houden voor veel clients. 

**Push** lost dit probleem redelijk goed op. Kort samengevat: de client blijft gewoon luisteren naar de server. De server kan dan gewoon iets sturen als dat nodig is.

### Wat is een nadeel van push?

to be continued, ik moet een bureau gaan halen bij de dreamland.

### Wat is het voordeel aan een library zoals jQuery?



## Reflectievragen

### Zou je chatten nog altijd met polling implementeren?

Nee, met push.



## Uitbreidingsvragen

### Leg stap voor stap uit welke code je moet toevoegen om de status en de naam in 1 request te kunnen aanpassen en tonen asynchroon

