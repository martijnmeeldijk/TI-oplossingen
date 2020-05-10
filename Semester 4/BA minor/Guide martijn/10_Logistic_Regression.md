---
typora-copy-images-to: ./img
---

# Logistic Regression

> :warning: Ik ben nog aan het wachten op een antwoord van Ms. Backiel voor de eerste twee vragen.

## 1. Cars: How many equations are there?

Oke ik heb logistic regression gedaan op m'n auto's. 

De output van de *logistic regression* widget heeft 22 rijen, is dit het antwoord? Find out in the next episode.

<img src="img/image-20200510223926287.png" alt="image-20200510223926287" style="zoom:33%;" />

## 2. What does each equation mean?

[source](https://saedsayad.com/logistic_regression.htm)

> Logistic regression predicts the probability of an outcome that can only have two values (i.e. a dichotomy). The prediction is based on the use of one or several predictors (numerical and categorical). A linear regression is not appropriate for predicting the value of a binary variable for two reasons:

Ik veronderstel het antwoord de kans om een bepaalde eigenschap te hebben of niet, of nee. 

*different regression models to compare* klinkt ook wel logisch. frick.

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

1. 22 // fout

2. different regression models to compare // fout

3. 12020.282 // fout, ik heb zonder op te letten L1 gebruikt

4. Safety, Persons, and Buying

5. True

6. Decision Tree // fout 

   aah fuk ik ben echt dom, binary tree had de hoogste CA. Misschien moet ik beter effe gaan pitten. Of een serie kijken ofzo. 

7. 2



