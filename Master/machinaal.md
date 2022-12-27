# Machinaal Leren

Deze samenvatting omvat de onderwerpen gezien in de slides. Waar de uitleg tekortschiet heb ik aangevuld met informatie uit het boek [(hier is de pdf)](https://www.knowledgeisle.com/wp-content/uploads/2019/12/2-Aur%C3%A9lien-G%C3%A9ron-Hands-On-Machine-Learning-with-Scikit-Learn-Keras-and-Tensorflow_-Concepts-Tools-and-Techniques-to-Build-Intelligent-Systems-O%E2%80%99Reilly-Media-2019.pdf).

## Puntenverdeling

Evaluation:

* 50% theory exam
* 50% NPE: 3 deadlines throughout the semester



# 1 - The ML Landscape

(boek p3)

## ML Types

We kunnen machine learning modellen onderverdelen volgens de hoeveelheid of de soort **supervisie** die ze krijgen tijdens hun training. 

Op deze manier kunnen we machine learning modellen in drie types onderverdelen:

* **Supervised learning**
  * De data die we aan het algoritme geven bevat ook de gewenste oplossing
  * Classificatie: een klasse proberen te voorspellen (bv. spam filter)
  * Regressie: een bepaalde numerieke waarde proberen te voorspellen op basis van een set van *features* (bv. prijs van een auto op basis van kilometers en leeftijd)
* **Unsupervised learning**
  * Er is geen *ground truth* beschikbaar
  * Clustering: gelijkaardige datapunten groeperen (bv. aanbevelingen op netflix voor gelijkaardige kijkers)
  * Anomaly detection (bv. fraudelente creditcard transacties)
* **Reinforcement learning**
  * We trainen een *agent* door hem te belonen, de *agent* leert dan vanzelf een methode (*policy*) om de beloning te maximaliseren



### Model-based and Instance-based learning

Een andere manier om machine learning modellen onder te verdelen is volgens hoe ze **veralgemenen** om met ongeziene samples om te kunnen gaan. Dit kan typisch op twee manieren.

Bij **model-based** **learning** is het de bedoeling om een model te leren dat de output kan voorspellen van een gegeven input. Het model is dan een set parameters die geleerd worden van gegeven data. De nieuwe sample in de figuur is volgens het model een driehoek, op basis van de parameters die het model heeft geleerd van de training samples.

Een andere manier is **instance-based learning**. We gebruiken training samples om voorspellingen te maken op nieuwe data, zonder bepaalde parameters te trainen. De voorspelling is enkel gebaseerd op de vergelijking tussen de nieuwe data en de training samples. In de figuur wordt de nieuwe instance een driehoek omdat de meeste dichtstbijzijnde training samples driehoeken zijn.

| Model-based learning                                         | Instance-based learning                                      |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![image-20221227143336110](img/machinaal/image-20221227143336110.png) | ![image-20221227143324160](img/machinaal/image-20221227143324160.png) |



### Model selection

<img src="img/machinaal/image-20221227144116441.png" alt="image-20221227144116441" style="zoom:80%;" />

Wanneer we model-based learning toepassen, zullen we een bepaald model moeten kiezen. In de tekening hierboven lijkt de grafiek een lineaire trend te volgen. Als we hier nu een lineair regressiemodel voor maken is het belangrijk om te weten dat we zijn vertrokken vanuit de assumptie dat de data een lineaire trend volgt. Dit is een voorbeeld van een **inductive bias**. 

> Inductive bias = your assumptions on the nature of the target and on the properties of the data



## Main challenges in machine learning

| No free lunch theorem                                        |
| ------------------------------------------------------------ |
| Als je absoluut geen veronderstellingen maakt over je data, is er geen reden om een bepaald model boven een ander te kiezen. Voor sommige datasets is het beste model een lineair model, voor anderen is een neuraal netwerk beter geschikt. Er is geen model dat *a priori* gegarandeerd beter werkt. |

Er zijn een aantal zaken die mis kunnen gaan bij een machine learning model. Deze vallen typisch ofwel in de categorie *bad model* of *bad data*. 

We zullen beginnen met een paar voorbeelden van **bad data**:

* <u>Te weinig trainingsdata</u>
  * Voor de meeste machine learning algoritmes hebben we grote hoeveelheden data nodig, zeker voor problemen zoals image of speech recognition. Voor zulke problemen hebben we typisch miljoenen voorbeelden nodig.
* <u>Non-representatieve trainingsdata</u>
  * De data waarop we het model trainen moet representatief zijn voor de nieuwe gevallen waarnaar we willen generaliseren. 
  * Als je steekproef te klein is krijg je *sampling noise*. De data is niet representatief door toeval.
  * Als je steekproefmethode gebrekkig is zal je te maken krijgen met *sampling bias*, zelfs al is je steekproefgrootte voldoende.
* <u>Slechte kwaliteit data</u>
  * Als je data vol fouten zit is het natuurlijk moeilijk om een goed model te maken
  * Je kan proberen uitschieters te verwijderen of normaliseren of ontbrekende data aanvullen.
* <u>Irrelevante features</u>
  * Belangrijk bij een machine learning model is om een goeie set van features te vinden om het model op te trainen. Dit proces, *feature engineering* bestaat uit:
    * *Feature selection*: de meest nuttige features kiezen
    * *Feature extraction*: features combineren om een nuttigere feature te verkrijgen
    * Nieuwe features maken door nieuwe data te verzamelen



Soms is de data niet de boosdoener, maar liggen de slechte resultaten aan het **algoritme**:

* <u>Overfitting op trainingsdata</u>
  * Het model is te specifiek afgesteld op de trainingsdata en presteert daarom slechter op nieuwe data.
  * Dit probleem kunnen we verminderen door **regularisatie**, hierover later meer.
  * We kunnen ook ons model versimpelen, meer trainingsdata verzamelen of de hoeveelheid *noise* in de data proberen te verminderen.
* <u>Underfitting</u>
  * Het model doet het slecht op zowel trainingsdata als testdata
  * Het model is te simpel, we kunnen meer paramaters of features toevoegen, maar we kunnen ook de hyperparameter van de regularisatie kleiner maken.



## Testing and validating

<img src="img/machinaal/image-20221227160707384.png" alt="image-20221227160707384" style="zoom: 50%;" />

Om te weten of het model effectief werkt, is het belangrijk om het te testen op nieuwe gevallen. We splitsen onze dataset op in een **training set** en een **test set**. Vanzelfsprekend gaan we dan ons model trainen op de training set en testen op de test set. Zo krijgen we inzicht in hoe ons model zou presteren op nieuwe gevallen.

Wat als we nu verschillende modellen willen testen. We trainen meerdere modellen op de training set en testen ze op de test set. Raar genoeg presteert zelfs het beste model nog steeds slecht bij een praktische test. Dit komt doordat we nu een model hebben gekozen en afgesteld zodat het het beste presteert op onze test set. 

Een oplossing hiervoor is om onze training set op te splitsen in een **training set** en een **validation set**. De validation set wordt dan gebruikt voor de modelselectie en het afstellen van hyperparameters. 



### Cross-validation

Deze oplossing werkt goed, maar als de validation set te klein is, kunnen we per ongeluk een suboptimaal model kiezen doordat de evaluaties niet precies genoeg zijn. Als de validation set te groot is, is de resterende training set veel kleiner dan de volledige training set. Dit is ook niet goed, want we gaan dan het model dat op een veel kleinere kleine set getraind en gevalideerd is trainen op de volledige training set. Dit is zoals de snelste sprinter kiezen voor een marathon. 

Een oplossing voor dit probleem is herhaaldelijke **cross-validation**. We gebruiken meerdere kleine validation sets. We evalueren het model dan één keer per validation set, waarna we het trainen op de rest van de data. Als we nu het gemiddelde nemen van al deze evaluaties, krijgen we een veel beter zicht op de prestatie van het model. 

Eén groot nadeel hieraan is dat we dus voor elke validation set het model moeten trainen. De **trainingstijd** wordt **vermenigvuldigt** met het **aantal validation sets**.



# 2 - End-to-end machine learning project

(boek p37)

Stel je nu voor dat we data scientists zijn in een groot bedrijf. Dit zijn de stappen die we zullen moeten doorlopen:

1. Look at the big picture. 
2. Get the data. 
3. Discover and visualize the data to gain insights. 
4. Prepare the data for Machine Learning algorithms. 
5. Select a model and train it. 
6. Fine-tune your model. 
7. Present your solution. 
8. Launch, monitor, and maintain your system.

We zullen een aantal stappen behandelen want sommige zijn niet erg relevant.

## Look at the big picture

Eerst en vooral moeten we het probleem proberen te **kaderen**:

* Hebben we ML nodig?
* Wat is het type van het probleem? (regressie, classificatie, ...)
* Welke data is er beschikbaar?

Vervolgens moeten we een **performance metric** kiezen. Een typisch voorbeeld hiervan voor regressieproblemen is de Root-Mean-Squared-Error (RMSE). Deze geeft ons een idee van hoe fout ons systeem zit in zijn voorspellingen, met een hoger gewicht voor grote fouten. 
$$
\text{RMSE}(X,h_0) = \sqrt{ \frac 1 m \sum_{i=1}^m (h_0(x^{(i)}) - y^{(i)})^2 }
$$
We kunnen ook de $\ell_k$ norm gebruiken, waar de $\ell_2$ norm volgens mij hetzelfde is als de RMSE. 
$$
\ell_k = \lVert \hat y - y \rVert_k = (\lvert \hat y ^{(1)} - y^1 \rvert ^k + \cdots + \lvert \hat y^{(m)} - y^m \rvert^k )^\frac{1}{k}
$$
<u>Notatie</u>

* $h_0$ is onze hypothesefunctie
* $\hat y^{(i)} = h_0(x^{(i)})$: als we onze functie een feature vector van een bepaalde instantie $x^{(i)}$ geven, zal hij een voorspelde waarde $\hat y^{(i)}$ teruggeven.
  * $x^{(i)}$ is dus de feature vector van een bepaalde instantie zonder de labels
  * $y^{(i)}$ bevat dan de labels
* De matrix $X$ bevat alle features $x^{(i)}$ van alle instanties.

## Get the data



## Discover and visualize the data to gain insights

Een andere belangrijke zaak is **exploratory data analysis** (EDA). Hiermee willen we een aantal doelen bereiken:

1. Gevoel krijgen met de data
   * We kunnen histogrammen maken voor elke feature
2. De data visualiseren en inzicht krijgen
   * Scatterplots per twee attributen
3. De data voorbereiden
   * Dit doen we in de volgende stap

## Prepare the data 

* Ontbrekende waarden invullen 
  * Entry of attribuut met ontbrekende waarde verwijderen
  * Vervangen door mediaan, gemiddelde of 0
* Categorische attributen
  * Kunnen maar een aantal mogelijke waarden aannemen, voor nominale variabelen gebruiken we one-hot-encoding
* Feature scaling
  * We kunnen de features herschalen door ze te normaliseren of standaardiseren zodat features met een groter bereik geen grotere impact hebben op modellen 

## Select a model and train it

Nu evalueren we meerdere modellen op onze training set. Probeer verschillende hyperparameters uit voor elk type model en evalueer de prestaties met cross-validation. Vervolgens train je het model opnieuw op de volledige training set met de optimale hyperparameters. 



<img src="img/machinaal/image-20221227172436843.png" alt="image-20221227172436843" style="zoom:50%;" />

* Grid search 
  * We defineren een *grid* met combinaties van hyperparameters en trainen het model voor elk punt van de *grid*, waarna we het beste model kiezen.
  * Dit is moeilijk als je erg veel combinaties hebt
* Random search
  * We proberen *at random* combinaties van parameters uit en gebruiken de beste combinatie die we vinden. 
  * 