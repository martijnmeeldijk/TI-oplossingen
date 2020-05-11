---
typora-copy-images-to: ./img
---

# Decision tree

Kijk zeker het [filmpje](https://www.youtube.com/watch?v=D6zd7m2aYqU&vl=en) van Orange Mevrouw. Zij legt al een beetje uit hoe je *decision tree* kan gebruiken in orange, onze lieve Aimée doet niet exact hetzelfde, maar een beetje uitleg kan geen kwaad.

Ga ook maar al naar *Chapter 12* van je "BA_minor_exercises.pdf".



## 1. Car Evaluation: What most important criteria based on Information Gain?

Gebruik de *rank* widget. Hier kan je de information gain voor alle citeria zien.

![image-20200510173632997](img/image-20200510173632997.png)

## 2. What is the classification accuracy of the Decision Tree on the test data?

*Test and score* met de *Tree* als learner. Komt in orde makker.

Kijk onder kolom CA (classification accuracy).

## 3. How likely is a car to be acceptable or better?

Ik heb gewoon in de *tree* widgets gekeken van de oplossing. 

## 4. How likely is a car with low safety to be acceptable or better?

Dieper in de tree kijken. 

## 5. If the safety is high, how many cars are unacceptable?

Dieper in de tree kijken.

## 6. Which type of tree seems to perform better?

Kijk naar test and score

## 7. Zoo: What's the probability an animal is a Fish, if you know it has no milk, no feathers, and a backbone?

Gewoon ook weer naar de tree gekeken in de oplossing. Zorg dat je tree binair is. 

## 8. The feature with the most Information Gain is Legs, but the top split in our tree is Milk. Why is that?

Orange documentatie:

```
Tree is a simple algorithm that splits the data into nodes by class purity. It is a precursor to Random Forest. Tree in Orange is designed in-house and can handle both discrete and continuous datasets.
```

**Class Purity**... 

Oh nee, maar in de oefeningen staat dit: 

```
Build a binary classification tree based upon the information gain criterion (tree)
```

Aha, daar hebben we het. Het is een binary tree, dus het gaat nooit iets in meer dan 2 takken splitsen.

Daar heb je je antwoord, lekker voorgekauwd. Nu is het helemaal sappig en druipt het speeksel er vanaf.

Oke ik ben even te ver gegaan, sorry.

## 9. How many leaves have more than one Type of animal?

Ik zie in deze tree er maar eentje.

## 10. Which appears to perform better?

Ja, dat hangt af van de settings. Ik gok op random forest.

## (mijn) Antwoorden

1. Safety
2. 0.891
3. 0.3
4. 0
5. 172
6. Binary Tree
7. 0.591
8. Tree isn't split by Information Gain
9. 1
10. Random Forest
