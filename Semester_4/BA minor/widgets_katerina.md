# Widgets, for what and why they are used

:bulb: Very useful documentation: 
[Orange Documentation](https://orange.biolab.si/docs/)

:bulb: Comparison of algorithms:
[towardsscience. com] (https://towardsdatascience.com/comparative-study-on-classic-machine-learning-algorithms-24f9ff6ab222) 

## Scatter Plot
> With this you can answer questions like: "Agree or disagree? Wines with a higher alcohol content also have a higher sugar content.
Explain your reasoning"

## Box Plot

 * Identify Outliers
 * You have to see if things are not overlaping. If they are, then the variable is not good in seperating the values we are looking for. Example from the practise test. We want to see which variable predicts the quality of the wine better, all of the variables in the box plot overlap almost. The one that doesn't overlap much is the alcohol percentage therefore is a better variable to identify good quality wine.

## Test and Score
> We use Test and Score to test the quality of the model and compare it with other models. When it comes to Regression, the best algorithm is the one with the lowest RMSE. But sipler models are preferred because they are more general and probably can predict better with new data. SO for example, if you have to regression models and the one has fewer features, because it used lasso regularization, it might be a better model. When it comes to classification, best practise is to first look at precision and recall. They need to be the highest they can, but they also influence each other. If you try to increase the one, most likely the othr will decrease. When different models have similar recall and precision values, look at the AUC value.  This needs to be high as well. CA from what I understood is pretty much worthless and doesn't say a lot about the efficiency of the model. But if you are asked to compare models, know that more answers can be right. What is important is to give an explanation for your answer so that the teachers understand your logic. 

* Test on train data uses the whole dataset for training and then for testing. This method practically always gives wrong results.
* Test on test data: the above methods use the data from Data signal only. 

### Classification Columns:

#### CLassification Accuracy (CA)
* You have to compare accuarcy with chance. If CA is better at predicting something correct than chance would, then it is a good model.
* CA = #correct predictions/ #total predictions ( (TP + TN)/ TP + TN + FP + FN )
* Great source to understand how to judge an algorithm based on the test and score results: https://developers.google.com/machine-learning/crash-course/classification/accuracy
https://medium.com/usf-msds/choosing-the-right-metric-for-machine-learning-models-part-1-a99d7d7414e4 => Here is also an image that shows the Right Metric for Evaluating Machine Learning Models

#### Precision 
* percentage of items flagged as positive, that were correctly classified
* What proportion of positive identifications was actually correct? ( TP / (TP + FP) ) 
* A model that produces no false positives has a precision of 1.0.

#### Recall 
* percntage of actual positives, that were correctly classified
* What proportion of actual positives was identified correctly? ( TP / ( TP + FN) )
* A model that produces no false negatives has a recall of 1.0.

:warning: improving precision typically reduces recall and vice versa. Generally (But not with certainty) : 
* Increasing CT (classification threshold) => precision increases, recall decreases
* Decreasing CT => precision decreases, recall increases

:bulb: In general, a model that outperforms another model on both precision and recall is likely the better model. Obviously, we'll need to make sure that comparison is being done at a precision / recall point that is useful in practice for this to be meaningful. For example, suppose our spam detection model needs to have at least 90% precision to be useful and avoid unnecessary false alarms. In this case, comparing one model at {20% precision, 99% recall} to another at {15% precision, 98% recall} is not particularly instructive, as neither model meets the 90% precision requirement. But with that caveat in mind, this is a good way to think about comparing models when using precision and recall.

#### AUC (Area Under the ROC Curve)

###### ROC curve :
> is a graph showing the performance of a classification model at all classification thresholds. This curve plots two parameters: True Positive Rate, False Positive Rate

* AUC measures the entire two-dimensional area underneath the entire ROC curve (think integral calculus) from (0,0) to (1,1).
* the probability that the model ranks a random positive example more highly than a random negative example. 
* predictions are 100% correct has an AUC of 1.0

### Regression Columns:

#### MSE

#### RMSE

* The lower the better 
[Source] (https://stats.stackexchange.com/questions/56302/what-are-good-rmse-values)

:warning: It is usually best to report the root mean squared error (RMSE)rather than mean squared error (MSE), because the RMSE ismeasured in the same units as the data, rather than in squaredunits, and is representative of the size of a "typical" error. 

:warning: If one model's RMSE is 30% lower than another's, that is prob-ably very significant. If it is 10% lower, that is probably some-what significant. If it is only 2% better, that is probably not sig-nificant. These distinctions are especially important when weare trading off model complexity against the error measures: itis probably not worth adding another independent variable to aregression model to decrease the RMSE by only a few morepercent.

:warning: If the RMSE difference is not significant between two models, the model with less features, that is simpler, might be preferred.

[Source] (https://www.academia.edu/8738608/PERFORMANCE_COMPARISON_OF_TIME_SERIES_DATA_USING_PREDICTIVE_DATA_MINING_TECHNIQUES)

## Python Script

> We learned to use the python script to calculate p-values in linear regression. If p-vamue less than 0.05, our results are statisticaally significant otherwise not! 

:warning: DOn't forget to add the add-on: Orange3-Timeseries, otherwise you won't be able to work with p-values. In orange => Options => Add-ons => tik Orange3-Timeseries => ok => then restart orange

**Script given by lecturers: **

import pandas as pd

import numpy as np

from sklearn import datasets, linear_model

from sklearn.linear_model import LinearRegression

import statsmodels.api as sm

from scipy import stats


training = in_data

print(training.domain.attributes)

print(training.domain.class_var)


#print(training.X)

print(training.Y)


x = training.X

y = training.Y


#http://www.statsmodels.org/dev/regression.html

X2 = sm.add_constant(x)

#est = sm.OLS(y, X2,missing='drop')

est = sm.OLS(y,X2)

est2 = est.fit()

print(est2.summary())


:warning: If script doesn't seem to work maybe there are missing values in the table, in that case comment est and uncomment the other version of est that drops the missing values


:information_source: In het geval dat ik een pull request vergeet te maken, kan je de laatste versie hier vinden: https://github.com/katerinastav/collegestuff/blob/master/ba_minor/widgets.md
