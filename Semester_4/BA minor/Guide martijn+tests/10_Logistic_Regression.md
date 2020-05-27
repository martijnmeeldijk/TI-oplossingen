---
typora-copy-images-to: ./img
---

# Logistic Regression

Wow je bent bij het einde van het vak geraakt: [hier](https://youtu.be/_p6hDcPhhqo) een bonus voor je goede werk.

## 1. Cars: How many equations are there?

Oke ik heb logistic regression gedaan op m'n auto's. 

De output van de *logistic regression* widget heeft 22 rijen, is dit het antwoord? Find out in the next episode.

<img src="img/image-20200510223926287.png" alt="image-20200510223926287" style="zoom:33%;" />

Het was fout. Ik heb aan Aimée gevraagd waarom:

> There are 4 equations, you got that right.

Oke we moesten dus het aantal kolommen tellen. Noice.

## 2. What does each equation mean?

[source](https://saedsayad.com/logistic_regression.htm)

> Logistic regression predicts the probability of an outcome that can only have two values (i.e. a dichotomy). The prediction is based on the use of one or several predictors (numerical and categorical). A linear regression is not appropriate for predicting the value of a binary variable for two reasons:

Ik veronderstel het antwoord de kans om een bepaalde eigenschap te hebben of niet, of nee. 

*different regression models to compare* klinkt ook wel logisch. frick.

Aimée wist me weer een goede uitleg te geven:

> Normally we think of logistic regression as a binary classifier. The equation takes the values for each instance as inputs x1, x2, x3, ... and outputs the probability that that instance belongs to the class. 76% yes, for example.
> In this case, we don't have only one class, so we actually have to create a different logistic regression equation for each class, then you'll plug an instance's values into each equation and get a probability that it belongs to that class, so 1st equation: 65% acc, 2nd equation: 35% good, 3rd equation: 4% unacc, 4th equation: 37% vgood. Then you choose the one with the highest percentage as the predicted class (here, acceptable).
> So in short, each equation determines the probability of one of the possible classes.

## 3. What is the odds ratio for Unacceptable for Low Safety (using L2)?

Ik heb alweer de oplossing geopend hoor. Je moet de *feature constructor* widget gebruiken en in de widget daarvoor `safety=low` selecteren.

## 4. Which features have the largest influence on our model?

Als je de output van *logistic regression* in een *data table* stopt, zie je dat de nummertjes van één groep best veel hoger zijn dan de andere nummertjes. 



> zie je dat de nummertjes van één groep best veel hoger zijn dan de andere nummertjes. 

-- Thanks for coming to my Ted Talk

## 5. True or False: These results are in line with what we've seen with other techniques.

Oke hier kan je zelf wel een conclusie trekken.

> Eén keer trek je de conclusie, vriendschap is een illusie :musical_note:

*Luistertip van martijn: "Het goede doel - Vriendschap"*

## 6. Which classification technique seems to perform the best?

Volgens de oefeningen pdf moet je je baseren op de *CA*. Gebruik *test and score.*

## 7. How many cars which are actually Unacceptable are classified as Good?

Zet een *Confusion Matrix* achter je *test and score*. 

## (mijn) Antwoorden

1. 4 (volgens Aimée Backiel)
2. the probability of a car belonging to a certain category (ook bedankt aan Aimée)
3. 122.466
4. Safety, Persons, and Buying
5. True
6. Bin Tree
7. 2

Aight boys, 7 op 7



