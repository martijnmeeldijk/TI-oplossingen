---
typora-copy-images-to: ./img

---

# Association rule exercises

Check zeker *07_2_titanic_exercises.pdf* in de repo van BA minor. Daar leggen ze uit hoe je associations moet doen in Orange. Vraag 12 en 13 had ik fout.

## 1. Titanic: Which are the frequent 1-itemsets (>60%)?

:rage: Oke ik moet hier even mijn aggressie uiten. 

<img src="img/image-20200509220428260.png" alt="image-20200509220428260" style="zoom: 25%;" />

Volgens de pdf moet je de slider op 60% zetten maar dat vervelende kankerding springt de hele tijd tussen 61% en 59%. Ik heb weliswaar vreselijk veel zin om iets kapot te slaan 

...

Het is ondertussen al 5 minuten later en het lukt npg steeds niet. Als ik ook maar de allerkleinste miniscuulste microbeweging maak springt hij van 59 direct naar 61. Ik sta op het punt om een oorlogsmisdaad te plegen. Bij elk ander percentage kan je de slider met ongelofelijke precisie op de juiste waarde brengen, maar niet op 60. Waarom? Hoe? Is dit een opzettelijke daad van een kwaadwillige boosdoener?????

...

*Nog enkele minuten later.* Ik heb het opgegeven. Ik ben één geworden met buddha en het universum. Woede en haat brengt ons niet verder. Soms moet je in het leven gewoon accepteren dat je die slider op 59% moet laten. 

...

Nee, sike ik ga het hier niet bij laten. Ik heb een issue aangemaakt op de repo van orange3-associate: https://github.com/biolab/orange3-associate/issues/32

Als jullie hetzelfde probleem hebben mogen jullie ook klagen. 

...

Ik zit nog maar aan oefening 4 en ze hebben al geantwoord. Ik hou jullie up to date met mijn contributie aan de orange community.

...

De guy die heeft geantwoord op mijn issue wist me te vertellen dat je de waarde op 60 kan zetten door je keyboard focus op de slider zetten en met de pijltjes te bewegen . YESSSSSSS.

Oke, terug naar de oefening



Als je dit resultaat wilt krijgen <img src="img/image-20200509223501822.png" alt="image-20200509223501822" style="zoom:33%;" />



en niet dit: <img src="img/image-20200509223553148.png" alt="image-20200509223553148" style="zoom:33%;" />

Dan moet je de widget *select rows* in je workflow zetten en *survived* uit het target variable ding halen. Anders telt hij survived niet mee in de subsets.

## 2. Titanic: Which are frequent 2-itemsets?

Ja nu moet je gewoon naar het raamje kijken, dat moet wel lukken.

## 3. Titanic: Which is the frequent 3-itemsets?

Same

## 4. Titanic: What is the conditional probability of a male passenger surviving?

Conditional probability: `P(A|B) = P(A∩B) / P(A)`

Oke nee laat dat maar zitten. Het is hier niet de bedoeling dat we met de hand dingen gaan uitrekenen he.

<img src="img/image-20200509224917813.png" alt="image-20200509224917813" style="zoom:33%;" />

Doe dit maar in orange. En --> *confidence = conditional probability*

## 5. Small Market Basket: {Bread} is a frequent itemset.

heirvoor moet je de file *market basket* gebruiken in de repo. Dan gewoon weer de *frequent itemsets* widget gebruiken. Zo kan je ook de volgende vragen oplossen.



## 6. {Milk} is a frequent itemset.

Ja

## 7. {Diapers} is a frequent itemset.

Nog een keer

## 8. {Beer} is a frequent itemset.

Jawel

## 9. {Eggs} is a frequent itemset.

Joehoe

## 10. {Cola} is a frequent itemset.

Yeey

## 11. Which is the frequent 3-itemset?

Yeet

## 12. Which rule has the highest lift?

Gebruik *association rules* en vindt welke regel het hoogste Lift (kolom) heeft.

## 13. Which Association Rule do you think is the strongest?

Gebruik *association rules* en pruts wat met de settings, je zal het wel vinden. Deze keer wel op de titanic dataset.



# (mijn) Antwoorden

1. {Did Not Survive}, {Adult}, {Male}
2. {Adult,Did Not Survive}, {Adult, Male}, {Male, Did Not Survive}
3.  {Adult, Male, Did Not Survive}
4. 0.212
5. True
6. True
7. True
8. True
9. False
10. False
11. Neither of the above
12. Cola -> Milk, Diapers
13. "Adult, Male -> Did Not Survive" // fout en "Did Not Survive -> Adult, Male" is ook fout






