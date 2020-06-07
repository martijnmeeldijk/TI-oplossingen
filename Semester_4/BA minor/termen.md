# Een samenvatting van moeilijke woorden die ik niet begreep

[TOC]



:warning: Dit document is onvolledig of incorrect (de perfecte manier om martipoints te verdienen). Je weet wat je te doen staat.

#### Replicable sampling

Documentatie van Orange: 

> Replicable sampling maintains sampling patterns that can be carried across users, while stratification mimics the composition of the input data set.
>

#### Stratification

> **Stratification** is defined as the act of sorting data, people, and objects into distinct groups or layers. It is a technique used in combination with other data **analysis** tools. When data from a variety of sources or categories have been lumped together, the meaning of the data can be difficult to see.

#### Linear regression

> **Linear regression** is a way to explain the relationship between a dependent variable and one or more explanatory variables using a straight line.

#### Multiple linear regression

Hetzelfde, gewoon meerdere variabelen.

#### Regularization 
~~als iemand hier een duidelijke uitleg in kan plakken: 1:moneybag: ~~
Katerina heeft hier 1 :moneybag: verdiend
> **Regularization** is the process of adding information in order to solve an ill-posed problem or to prevent overfitting.

#### Ridge Regression
> As the penalty is increased, all parameters are reduced while still remaining non-zero.

#### Lasso Regression
> Increasing the penalty will cause more and more of the parameters to be driven to zero.

#### Ridge vs Lasso 
> The Lasso has an advantage over ridge regression, as driving parameters to zero deselects the features from the regression. Thus, Lasso automatically selects more relevant features and discards the others, whereas Ridge regression never fully discards any features.
https://en.wikipedia.org/wiki/Least_squares#Lasso_method

#### Logistic regression

Same

Slides van ba minor:

```
General rule of thumb: for classification, start with logistic regression
```

oke bedankt

#### Logistic regression: odds

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



#### Instance-based learning

> Instance-based learning refers to a family of techniques for [classification](https://doi.org/10.1007/978-0-387-30164-8_111) and [regression](https://doi.org/10.1007/978-0-387-30164-8_710), which produce a class label/predication based on the similarity of the query to its nearest neighbor(s) in the training set.



## Afkortingen

**MAE/MAED**: (Mean Absolute Error/Deviation)

**MAPE**: (Mean Absolute Percentage Error)

**RMSE**: (Root Mean Squared Error)

**TSSE**: Total Sum of Squared Errors



# Vocabulary (van Bertels)

#### **Supervised learning**

> the target is known (which class an instance belongs to) and a model is trained to predict that target, e.g. decision tree

#### **Unsupervised learning**

> the target is unknown (unknown class or even if any class structure exists) and the model seeks to uncover some hiddenclassification or structure, e.g. clustering

#### **Sample**

> extract a portion or subset of the data

#### **Oversampling**

> take multiple examples of a certain class, especially if that class is small

#### **Stratified sampling**

> keeping the class ratios for each sample approximately equal to the original dataset

#### **Discrete/Categorical**

> variable with a number of possible categories

#### **Numerical/Continuous**

> variable that takes any value in a range of numbers

#### **Outlier**

> an instance which is very different from all other examples, can mean there is an error or an interesting rare event, can skew a model’s results

#### **Normalize**

> adjust the scale of a variable’s values so they can be more easily compared

#### **Overfitting**

> training a model too closely to the training data, so it is not generalized enough to perform well on test or new data

#### **Training set**

> subset of the data used to train or learn a model

#### **Validation set**

> subset of the data used to improve the performance on a model during training

#### **Test set**

> subset of the data used to evaluate a model
