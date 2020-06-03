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

In een [paper](https://arxiv.org/pdf/0706.3984.pdf) waar ze push en pull vergelijken staat dit. 

> Our experiment shows that if we want high data coherence and high network performance, we should choose the push approach. However, push brings some scalability issues; the server application CPU usage is 7 times higher as in pull. According to our results, the server starts to saturate at 350-500 users. For larger number of users, load balancing and server clustering techniques are unavoidable. With the pull approach, achieving total data coherence with high network performance is very difficult. If the pull interval is higher than the publish interval, some data miss will occur. If it is lower, network performance will suffer. Pull performs well only if the pull interval equals to publish interval. However, in order to achieve that, we need to know the exact publish interval beforehand. However, the publish interval is rarely static and predictable. This makes pull useful only in situations where the data is published frequently according to some pattern.

### Wat is een nadeel van push?

Zie vorige vraag: **push** gebruikt meer resources. Als een site op een frequent interval geupdate wordt, kan je beter **pull** gebruiken en het pull-interval gelijkzetten aan het interval van de site. Ik weet niet of dit is wat Elke Steegmans wilt dat je vertelt, maar ik vind het een best goede uitleg.

### Wat is het voordeel aan een library zoals jQuery?

Maakt javascipt programmeren een heel stuk gemakkelijker. Je kan veelvoorkomende taken doen in veel minder lijnen code. JQuery maakt het selecteren van elementen een stuk gemakkelijker en het is ook compatibel met heel veel browsers. 



## Reflectievragen

### Zou je chatten nog altijd met polling implementeren?

Nee, met push. Als je je chat window open hebt staan, moet er niet elke 5 seconden gecheckt worden of er nieuwe berichten zijn. Wie weet ben je heel eenzaam en krijg je op een hele dag maar 1 bericht van je mama. Dan zou het echt dikke verspilling zijn om geen push te gebruiken.



## Uitbreidingsvragen

### Leg stap voor stap uit welke code je moet toevoegen om de status en de naam in 1 request te kunnen aanpassen en tonen asynchroon

(ik ken je code niet, sorry)

