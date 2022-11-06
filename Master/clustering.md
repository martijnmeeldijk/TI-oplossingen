# Papers



## Classification of reverberant audio signals using clustered ad hoc distributed microphones

* What is a feature vector?



This paper proposes an algorithm to provide a way of clustering ad hoc distributed microphones so that they can be divided in:

* Microphones where one of the sound sources is dominant
* Microphones containing mainly signal mixtures and reverb

Audio feature extraction is performed directly in each device of the WASN. The captured data is represented in a feature vector compactly, so there is no need to exchange audio signals.



We need a strategy to create compatibility between test and train data, while also exploiting the spatial distribution of the receivers. This can be done in three different domains:

* Signal domain
  * We don't know much about the receiver positions so strategies like beamforming are quite useless
* Feature domain
  * Combine-then-analyse (CTA)
  * The feature vectors are combined, after which they are used as a common test sample in the classification system
  * <img src="img/clustering/image-20221106214317527.png" alt="image-20221106214317527" style="zoom: 67%;" />
* Decision domain
  * Analyse-then-combine (ATC)
  * Here we classify the feature vectors from different devices independently, after which they are combined to result in one classification decision.
  * <img src="img/clustering/image-20221106214335384.png" alt="image-20221106214335384" style="zoom: 67%;" />