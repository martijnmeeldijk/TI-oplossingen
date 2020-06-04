# Business Analytics Minor

## Inhoud

 [Week 1 - Intro](#week-1---intro)

 [Week 2 - Data Exploration](#week-2---data-exploration)

 [Week 3 - KNN](#week-3---knn)

 [Week 4 - Naive Bayes](#week-4---naive-bayes)

 [Week 5 - Regression](#week-5---regression)

​      [Simple Linear Regression](#simple-linear-regression)

​      [Multiple Linear Legression](#multiple-linear-legression)

​      [Errors](#errors)

 [Week 6 - Evaluation](#week-6---evaluation)

​        [Confusion matrix:](#confusion-matrix)

​        [Cross Validation](#cross-validation)

[Week 7 - Association rule](#week-7---association-rule)

[Week 8 - Clustering](#week-8---clustering)

[Week 9 - Decision tree](#week-9---decision-tree)

[Week 10 - Logistic Regression](#week-10---logistic-regression)

​      [Odds](#odds)

---

Nog even een korte intro.

[Ba minor anthem](https://youtu.be/_p6hDcPhhqo)

> :warning: In plaats van mij berichten te sturen als je een fout vindt of een verbetering wilt aanbrengen, kan je op github gewoon rechts boven op dit document op het potloodje drukken en het document bewerken. Druk op **create pull request** en ik krijg automatisch van github een bericht om de verandering goed te keuren. Ez martipoints.

Ik ga hier dus proberen om per les de besproken onderwerpen wat te verklaren.



## Week 1 - Intro

We hebben in deze tijden heel veel data. Met business analytics/data mining proberen we iets te doen met die data. Data mining is niet hetzelfde als statistiek. Bij statistiek heb je eerst een hypothese enzo, maar in data mining heb je dat niet. Je gaat data analyseren en er patronen in vinden. Je moet ook oppassen dat je geen nuttloze patronen in data gaat zitten zoeken. 



**Instance base learning**

Google zegt dit:

> In machine **learning**, **instance**-**based learning** (sometimes called memory-**based learning**) is a family of **learning** algorithms that, instead of performing explicit generalization, compares new problem **instances** with **instances** seen in training, which have been stored in memory.

Nog effe 1 afbeelding en dan zijn we klaar met deze les.

<img src="img/image-20200603170802846.png" alt="image-20200603170802846" width="50%;" />



## Week 2 - Data Exploration

Man, dit zijn gewoon slides van KU Leuven. De fak. 



**What Should You Look For?**

Good to look at simple statistics of 

* Number of variables 
* Size of data 
* Missing values 
* Skew

**For each attribute, look at:** 

* Discrete: number of possible values, are they ordered, frequency of each value, etc. 
* Numeric: mean, min, max, etc.



**Waarom schrijf ik dit zelfs op:**

Mean: het gemiddelde

Mode: het meestvoorkomende

Median: het midden

Variance: kwadraat van de standaardafwijking

Quartile (mediaan van elke helft): Sort X 

​	Q1: Value at position 0.25n

​	Q3: Value at position 0.75n 

​	IQR: Q3 – Q1



## Week 3 - KNN

KNN classification = K Nearest-neighbor classification 

**KNN** zoekt voor een instantie in je die je wilt classificeren de dichtstbijzijnde instanties in een oefenset. Als k = 1, neemt hij alleen de dichtstbijzijnde. Als k = 2, neemt hij de 2 dichtstbijzijndsten, etc. Dan kijk je naar de classificatie van deze instanties en kan je de klasse van de instantie die je wilt classificeren afleiden.

Je hebt ook **Distance-weighted nearest neighbor** dat is KNN, maar hoe verder de gerelateerde instanties zich bevinden van de instantie waarvan je de klasse wilt bepalen, hoe minder ze doorwegen op het uiteindelijke resultaat.

Veel meer is er niet aan. De wiskunde erachter moeten we toch niet kennen.



Nog wat referentiemateriaal;

**Strengths of instance-based learning** 

* simple to implement 
* “training” is very efficient 
* adapts well to on-line learning 
* robust to noisy training data (when k > 1) 
* often works well in practice 

**Limitations of instance-based learning** 

* sensitive to range of feature values 
* sensitive to irrelevant and correlated features, although… 
* there are variants that learn weights for different features 
* later we’ll talk about feature selection methods 
* classification can be inefficient, although edited methods and k-d trees can help alleviate this weakness 
* doesn’t provide much insight into problem domain because there is no explicit model 



## Week 4 - Naive Bayes

Bayes' theorem
$$
P(A|B) = \frac{P(A) P(B|A)} {P(B)}
$$
Als je dollartekens rond wiskunde zet, ziet de wiskunde er cool uit.

Naive Bayes is naief omdat er verondersteld wordt dat de voorspellende variabelen onafhankelijk zijn. Wat niet altijd het geval is. Als je hebt opgelet bij statistiek, weet je ook dat de bovenstaande formule alleen geldt als A en B elkaar niet beïnvloeden. In de echte wereld zijn twee gebeurtenissen echter vaak (gedeeltelijk) afhankelijk van elkaar, maar we zullen maar veronderstellen dat dit niet zo is.

Voorbeeld ([bron]([https://www.analyticsvidhya.com/blog/2017/09/naive-bayes-explained/#:~:text=What%20is%20Naive%20Bayes%20algorithm%3F,presence%20of%20any%20other%20feature.](https://www.analyticsvidhya.com/blog/2017/09/naive-bayes-explained/#:~:text=What is Naive Bayes algorithm%3F,presence of any other feature.))):

> For example, a fruit may be considered to be an apple if it is red, round, and about 3 inches in diameter. Even if these features depend on each other or upon the existence of the other features, all of these properties independently contribute to the probability that this fruit is an apple and that is why it is known as ‘Naive’.

Naive Bayes is efficiënt bij grote datasets. Juist dankzij deze veronderstelling.



## Week 5 - Regression

### Simple Linear Regression

We gaan op basis van een voorspellende variabele `X`, de waarde van een continue variabele `Y` proberen te voorspellen. We trekken dus een lijn die kleinst gemiddelde afstand heeft van elke waarde. Als je nu `X = 30` neemt op de foto, zie je op de foto dat `Y` ongeveer gelijk zal zijn aan 10.

![Simple linear regression - Wikipedia](https://upload.wikimedia.org/wikipedia/commons/3/3a/Linear_regression.svg)



### Multiple Linear Legression

Als je op multiple linear regression zoekt op google images, vind je een foto van de slides die Bertels gebruikt.

![New Aspects to consider while moving from Simple Linear Regression ...](https://miro.medium.com/max/1120/0*rGSfRsMjiQeG5jof.png)

Hetzelfde als het vorige, maar er zijn meerdere variabelen (**predictor variables**) die bijdragen tot het model om de **target variable** te proberen te voorspellen.



Als je te veel variabelen hebt, kan het dat je doet aan **overfitting**. Je moet dus maar een deel van de voorspellende variabelen gebruiken. Namelijk het deel dat 

**Methods to choose the best subset of predictor variables**

* first: reduce number of predictor variables by means of domain knowledge 
* then: use algorithms 
  * ’Exhaustive search’: try all predictor variables subsets 
  * ’Forward selection’: start with 1 predictor variable, add each time the most significant one 
  * ’Backward selection’: start with all predictor variables, remove each time the least significant one 



### Errors

<img src="img/image-20200604122507830.png" alt="image-20200604122507830" width="50%;" />

:warning: Rule of thumb: number of observations n in training data equals at least 5(p+2)



## Week 6 - Evaluation

### Confusion matrix:

<img src="img/image-20200604123018978.png" alt="image-20200604123018978" width="50%;" />

Accuracy:
$$
\frac {True Positive + True Negative} {Total}
$$
Precision/Positive Predictive Value:
$$
\frac {True Positive} {All Positive Predictions}
$$
Recall/Sensitivity/True Positive Rate:
$$
\frac {True Positive} {All Actual Positives}
$$


Specificity/True Negative Rate:
$$
\frac {True Negative} {All Actual Negatives}
$$


### **Cross Validation**

**K-Fold:**

 	Split data into training and test sets

 	Split training set into k subsets

 	Leave one subset for validation and train on all other sets

​	 Repeat k times, always using a different validation set

 	Choose the best model

 	Evaluate “best” model on original test set

**Leave One Out:**

 	k = number of instances

 	Leave one instance for validation and train on remaining training set

​	 Repeat for all instances



## Week 7 - Association rule

Stel je voor, je bent in een eigenaar van een winkel. Je merkt dat mensen vaak bier een nootjes tesamen kopen. Je wilt weten of er nog producten zijn die mensen vaak tegelijk kopen, zodat je misschien een promotie kan doen, of de prijs van een bepaald product verhogen. 

<img src="https://nextjournal.com/data/QmSf3DHu8WkV1f2qGpVrGQfW2KKQCd2yvSBnE2Futj8hoW?filename=association-rule-support-table.png&amp;content-type=image/png" alt="Filter association rules – Nextjournal" width="30%;" />

Ik zal ook een paar woordjes verklaren aan de hand van een voorbeeld:

**Support count**: neem een set van spulletjes `I`. De *support count* van `I` is het aantal transacties dat exact deze set bevat. Bijvoorbeeld: `support count({appel, bier})` = *3*

**Support**: Het vorige, maar dan in verhouding met het totaal aantal transacties: dus `support({appel, bier})` = *3/8* 

**Support threshold**: Een bepaalde limiet (die je zelf kan kiezen, bv. 50%). Alles boven deze limiet wordt gezien als *frequent itemset*. In dit geval is `{appel, bier}` geen *frequent itemset*.   `{appel}` , `{melk}` of `{bier, rijst}`, ... zijn dat wel.

**Association rule**: Als een winkelkar `{appel}` bevat, bevat hij ook `{bier}`. 

**Confidence**: is de kans dat een *association rule* klopt.
$$
confidence(A \Rightarrow B) = P(B|A) = \frac {support({A,B})} {support(A)}
$$
in dit geval dus:
$$
confidence(appel \Rightarrow bier) = P(bier|appel) =  \frac{\frac{3}{8}}{\frac{4}{8}} = \frac{3}{4}
$$
**Interestingness**: 

Given association rule:
$$
i → j \\ 
Interest = Confidence( j | i ) - Support( j )
$$
in dit geval dus:
$$
interest(appel \Rightarrow bier) = \frac{3}{4} - \frac{6}{8} = 0
$$
Interessant... Als je dit in het achterhoofd houdt:

> Interest = 0: I has no influence on j 
>
> Interest > 0: I may cause the presence of j 
>
> Interest < 0: I discourages presence of j



## Week 8 - Clustering

**Clustering** = gelijkaardige objecten groeperen.

Is ook **unsupervized**

<img src="img/image-20200604152342953.png" alt="image-20200604152342953" width="50%;" />

A good clustering method will produce clusters with

**High** **intra-class** similarity: Heel gelijkaardig binnen dezelfde cluster.

**Low** **inter-class** similarity: Veel verschillend tussen verschillende clusters.



**Hiërarchisch clusteren**

<img src="img/image-20200604153643215.png" alt="image-20200604153643215" width="50%;" />



The distance between two clusters can be determined in several ways

​	**Single link**: distance of two most similar instances: dist(cu, cv) = min{dist(a, b) | a∈cu, b∈cv}

​	**Complete link**: distance of two least similar instances: dist(cu, cv) = max{dist(a, b) | a∈cu, b∈cv} 

​	**Average link**: average distance between instances: dist(cu, cv) = avg{dist(a, b) | a∈cu, b∈cv}



## Week 9 - Decision tree

Dit is een decision tree:

<img src="img/image-20200604154528962.png" alt="image-20200604154528962" width="50%;" />

We gaan stap voor stap de data opsplitsen

<img src="img/image-20200604154727840.png" alt="image-20200604154727840" width="50%;" />

## Week 10 - Logistic Regression

**Logistic regression** is zoals **linear regression**, maar je uitkomst is binair (0 of 1) of (ja of nee).

### Odds

[Source](https://stats.idre.ucla.edu/stata/faq/how-do-i-interpret-odds-ratios-in-logistic-regression/)

> Let’s begin with probability. Probabilities range between 0 and 1. Let’s say that the probability of success is .8, thus
>
> **p = .8**
>
> Then the probability of failure is
>
> **q = 1 – p = .2**
>
> Odds are determined from probabilities and range between 0 and infinity. Odds are defined as the ratio of the probability of success and the probability of failure. The odds of success are
>
> **odds(success) = p/(1-p) or p/q = .8/.2 = 4,**
>
> that is, the odds of success are 4 to 1. The odds of failure would be
>
> **odds(failure) = q/p = .2/.8 = .25.**
>
> This looks a little strange but it is really saying that the odds of failure are 1 to 4. The odds of success and the odds of failure are just reciprocals of one another, i.e., 1/4 = .25 and 1/.25 = 4. Next, we will add another variable to the equation so that we can compute an odds ratio.

