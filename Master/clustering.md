# Literature study

* Initial Papers

- [x] Classification of reverberant audio signals using clustered ad hoc distributed microphones
- [x] Estimating Source Dominated Microphone Clusters in Ad-Hoc Microphone Arrays by Fuzzy Clustering in the Feature Space
- [x] Source separation by fuzzy-membership value aware beamforming and masking in ad hoc arrays
- [x] SOURCE SEPARATION BY FEATURE-BASED CLUSTERING OF MICROPHONES IN AD HOC ARRAYS
- [ ] Madhu phd thesis

* Extra papers

- [x] 2D Acoustic Source Localisation Using Decentralised Deep Neural Networks on Distributed Microphone Arrays
- [x] A Coherence-based Clustering Method for Multichannel Speech Enhancement in Wireless Acoustic Sensor Networks
- [ ] ESTIMATION OF MICROPHONE CLUSTERS IN ACOUSTIC SENSOR NETWORKS USING UNSUPERVISED FEDERATED LEARNING
- [ ] Exploiting Temporal Context in CNN Based Multisource DOA Estimation
- [ ] Unsupervised Clustered Federated Learning in Complex Multi-source Acoustic Environments

* Under review

- [ ] EXPLOITING SPEAKER EMBEDDINGS FOR IMPROVED MICROPHONE CLUSTERING AND SPEECH SEPARATION IN AD-HOC MICROPHONE ARRAYS

## Questions



* Q: Mel-frequency cepstrum?
  * eerst naar fourier domein
  * 

* 



## Classification of reverberant audio signals using clustered ad hoc distributed microphones





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
  
    <img src="img/clustering/image-20221106214317527.png" alt="image-20221106214317527" style="zoom: 67%;" />
  
* Decision domain
  * Analyse-then-combine (ATC)
  
  * Here we classify the feature vectors from different devices independently, after which they are combined to result in one classification decision.
  
    <img src="img/clustering/image-20221106214335384.png" alt="image-20221106214335384" style="zoom: 67%;" />



**Proposed algorithm**

The authors have opted to use the CTA strategy for this problem, as this allows the microphones to be clustered with a fuzzy-clustering procedure. This way, microphones can be divided into groups dominated by one type of audio signal. Devices that receive a more balanced mixture of source signals will receive an intermediate cluster value. 

After clustering, a combination strategy is applied, whereafter the signal classification can be performed.

![image-20221204184514922](img/clustering/image-20221204184514922.png)

* Signal feature extraction
  * Audio data is transformed into a parametric representation, which allows distinction between classes while reducing the amount of data.
  * Mod-MFCCs features are computed //TODO
  *  Cepstral mean normalization is performed on the result to reduce reverberation
* Unsupervised signal clustering
  * The resulting features from the previous step are clustered using the Fuzzy c-means algorithm. 
  * Each microphone will receive a value for each cluster in the range $[0,1]$ 
  * This value indicates its membership in each of the $N$ clusters
  * There are $N-1$ microphones, so one extra cluster is added for microphones where background noise or reverberation is dominant. 
* Feature vector combination
  * The feature vectors from the different microphones are combined, using weights acquired from the previous step
  * This way, microphones that pick up the source signal better will contribute more to the classification
  * The combined information is used to perform a cluster related classification



**Conclusion**

This method outperforms classification based on a single microphone for each cluster. The algorithm works very well for distinguishing between speech and music. 





## Estimating Source Dominated Microphone Clusters in Ad-Hoc Microphone Arrays by Fuzzy Clustering in the Feature Space

This paper proposes to cluster microphones in an ad-hoc microphone array by source, adding one cluster for noise. Audio features, extracted from the microphone signals are used for fuzzy clustering, after which their fussy membership value is used to assign them to either a source dominant or a background cluster.

**Fuzzy clustering**

Instead of hard clustering the microphones. We'll use fuzzy clustering. This means that each microphone won't be perfectly in one cluster, but rather get a Fuzzy Membership Value (FMV) that indicates how much a microphone belongs in a certain cluster. The microphone is then assigned to the cluster for which it has the highest FMV.

$$
J_m(\Delta, \bold u) = \sum_{d=1}^D \sum_{n=1}^N (\mu_{nd})^{\alpha} \vert \vert \bold v_d - \bold u_n \vert \vert ^2_{\beta}
$$
![image-20221206164344088](img/clustering/image-20221206164344088.png)

![image-20221206164353715](img/clustering/image-20221206164353715.png)

**Evaluation**

Two simulated setups were used, one where two sources were placed randomly, but each in one half of the room. In the second setup, the sources were put closer together.

![image-20221116211618119](img/clustering/image-20221116211618119.png)

Research was also conducted in an acoustic laboratory using 16 microphones and two sound sources. The sources were either music or a male and female speaker. 100 different combinations were used. 



**Results**

For all scenarios, the background cluster is detected correctly in at least 89.7% of the cases for the scenario with speech and music sources and in over 93% of the cases with a male and a female speech source. This method seems to work very well with two sound sources, but no research was done with more sources. 



## Source separation by fuzzy-membership value aware beamforming and masking in ad hoc arrays

Q: What does an impulse response from a source to a microphone mean?

**1. Introduction**

This paper focuses on audio signal enhancement with delay-and-sum beamforming and extends upon the previous paper's fuzzy clustering.  For each source cluster, relative time-differences-of-arrival (TDOA) are estimated. This is combined with the FMV in the beamforming stage.

In a second enhancement stage, cluster-related spectral masks are applied to the output of the beamformers.

Q: Cepstral mean normalization? -> minder reverberaties door gemiddelde ervan af te trekken





**2. Ad hoc clustering**

A FMV is calculated for each microphone and for any source, a subset of the microphones will be selected for further processing. In essence, we're selecting the most useful microphones for processing the sound from each source.

**3. FMV-aware signal enhancement**

In each cluster, a reference microphone is selected. Subsequently, a correlation analysis of all the other microphone signals in respect to the reference signal is performed. This allows for an estimation of the TDOAs, which can be used in the beamforming stage. 

**3.1 Initial source signal estimation**

As I understand it, this mask just indicates in which microphone the source signal is dominant.

//TODO


$$
\mathscr{M}_n(k,b) = \begin{cases} 
1 \quad \vert X_{R_n}(k-b)\vert > \frac 1 B \sum \vert X_{R_j}(k,b)\vert, \\\ 
\quad \quad j = 1, \dots ,N \text{ and } j \neq n

\\
0 \quad \text{otherwise}

\end{cases}
$$
Q: Is this correct?

Q: What is $B$ in the mask?

**3.2 Time-difference-of-arrival estimation**

Now the TDOAs are estimated with correlation analysis. This is realised as a time-domain cross-correlation, computed over segments of ∼ 4s in length, which is also the duration across which the audio features for the fuzzy clustering are computed. 

**3.3 Clustering-steered beamforming**
$$
\hat{s}_{n \text{, W-DSB}}(l) = \sum_{i_n}w_{n,i_n}x_{i_n}(l + D_{i_n})
$$

* $\hat{s}_{n \text{, W-DSB}}(l) $: Q: what exactly does this mean?
  * $l$ is the discrete time index
* $D_{i_n}$: relative TDOA's
* $w_{i_n}$: the weights allocated to each microphone $i_n$ of cluster $n$
  * These are proportional to the FMV

By using a weighted combination of the microphone signals, we can make a better DSB.



**3.4 Mask re-estimation for post-filtering**

The result of the previous stage should give an enhanced signal, which can now be used to compute a post-filtering mask.

Q: I don't understand very well how this mask is calculated.

This mask is then applied to the the signal, which was already processed by the fuzzy-membership value aware beamforming. 

This yields a final source signal estimate. 

![image-20221206181002091](img/clustering/image-20221206181002091.png)
$$
\mathscr{M}_n(k,b) = \begin{cases} 
1 \quad \vert \hat S_{n, \text{FMVA-DSB}}(k,b)\vert
> \frac 1 B \sum \vert \hat S_{j, \text{FMVA-DSB}}(k,b)\vert, \\\ 
\quad \quad j = 1, \dots ,N \text{ and } j \neq n

\\
0 \quad \text{otherwise}

\end{cases}
$$
The image below shows a schematic of the full algorithm.

<img src="img/clustering/image-20221130173959370.png" alt="image-20221130173959370" style="zoom: 67%;" />

Q: Wat gebeurt er precies bij de feature extraction?

**4. Evaluation**

This was very similar to the previous paper.

FMVA-DSB consistently yields a better performance compared to the simple DSB. However, the performance difference is not very large. 







## Source separation by feature-based clustering of microphones in ad-hoc arrays



Here, the simple DSB is done on the microphone signals, without taking into account the FMVs. 



Q: Why do they use fuzzy clustering here? Because they're only using the FMV to determine in which cluster a microphone should end up.



## 2D Acoustic Source Localisation Using Decentralised Deep Neural Networks on Distributed Microphone Arrays

In this paper, a method to estimate the direction of arrival in a microphone using neural networks is proposed. By sharing a part of the neural network between the different microphone arrays, we should be able to achieve higher accuracy.

With one microphone array, is is only possible to find an estimate for the DOA. If we use multiple microphone arrays, a wireless acoustic sensor network (WASN), it is also possible to localize the source signal in 2D space by combining the data from the arrays. In this paper, they use two microphone arrays.

Typically, the different nodes are only weakly synchronized. The solution should be able to deal with that. 



The paper describes three approaches to the problem:

**Triangular approach**

This approach is used as a reference

<img src="img/clustering/image-20221204155856170.png" alt="image-20221204155856170" style="zoom:67%;" />

The grey bands show that the weights on each level are identical. Two microphones are used to gain a DoA estimate for both microphones. The processing is done separately on each microphone array, after which the DoA for each array is sent to a central processing hub. Here, the intersection of the two DoA's is calculated using triangulation, which results in an estimated position of the target speaker in 2D space.



**Narrowband mixing CLA (NM-CLA)**

<img src="img/clustering/image-20221204165330110.png" alt="image-20221204165330110" style="zoom:67%;" />

The information of the different microphone arrays is combined right after the last convolutional layer of both arrays, after which an inter-array convolution is performed. The method is called narrowband, because the frequency information is still present at this time.

The output is defined as a classification problem, where each class represents a rectangle in 2D space. The output of the DNN represents the probability of the speaker being present in each region.

This approach uses more bandwidth, as $64 \cdot K$ (where $K$ is the amount of frequency bins) features have to be transmitted to the central node by each array.





**Broadband mixing CLA (BM-CLA)**

<img src="img/clustering/image-20221204165348187.png" alt="image-20221204165348187" style="zoom:67%;" />

This method has lower bandwidth requirements. The convolutional layers are joined together after they are flattened and go through a fully connected layer. This layer already combines the frequency bins, hence the name broadband. 

This way, only 512 features have to be sent to the central unit.

Both methods don't add a crazy amount of parameters in comparison to the triangulation method, since they only add one convolutional layer.

**Conclusion**

BM-CLA has the best accuracy, and a lower bandwidth requirement. Both methods are robust against small deviations in clock synchronicity, because the features between nodes are only mixed at deeper stages of the DNN. 





## Estimation of microphone clusters in acoustic sensor networks using unsupervised federated learning

**Introduction**

This paper proposes a way to use federated learning to estimate source-dominated microphone clusters, exchanging minimal data between nodes.  The model is optimized for training on scarce data.

The transmission of data-rich signal representations over a potentially unsafe network poses serious privacy risks. This technique  should be a solution for this problem. The previously mentioned methods fall short in this category.



**Federated learning**

This is a machine learning technique that that trains a model distributed over multiple decentralized devices. Data is not shared between nodes. Instead, a three step process is followed.



1. The clients synchronize with the server by downloading the latest model parameters
   * This is a column vector $\theta^\tau$
2. Each client independently improves its own parameters $\theta^\tau_i$ with stochastic gradient descent on their own data
3. Each client uploads its model parameter updates $\Delta\theta^\tau_i$ to the server, where they are aggregated.

$$
\theta^{\tau+1} = \sum_{i=1}^M \frac{\lvert D_i \rvert}{\lvert D \rvert} \Delta\theta^\tau_i
$$

* $M$: number of clients
* $\lvert D_i \rvert$ the cardinality of the dataset of the $i$-th client
* $\lvert D \rvert$: the cardinality of the total dataset

So the new model parameters are a weighted sum of the each of the updated parameters from the clients.



**Clustered federated learning**

The problem with the previously mentioned approach is that it doesn't work if the different clients' data comes from different (incongruent) distributions. So there is no single set of parameter updates that can optimally minimize the loss of all clients at the same time. 

To help with this, the clients with similar distributions are clustered. A separate server model is then trained for each cluster.



**Unsupervised clustered federated learning**



$$
a_{i,j} = \frac{ \langle \Delta  \theta _i, \Delta  \theta _j \rangle}{ \vert\vert \Delta  \theta _i, \Delta  \theta _j \vert\vert}
$$

* $\langle \cdot \rangle$ denotes the inner product
* $\lvert \lvert \cdot \rvert \rvert$ denotes the $L_2$ norm

![image-20221206192958190](img/clustering/image-20221206192958190.png)
$$
\max_{\forall i \in c_1, k\in c_2}(a_{i,k}) < 
\min(\min_{\forall i,j \in c_1}(a_{i,j}), \min_{\forall k,l \in c_2}(a_{i,j}))
$$




![image-20221206193005722](img/clustering/image-20221206193005722.png)
$$
\Delta \overline \theta_c = \lVert \frac 1 {\lvert c \rvert} \sum_{i\in c} \pmb \Delta \pmb \theta_i  \rVert
\text{ and }
\Delta \hat \theta_c = \max_{i \in c}(\lVert \Delta \pmb \theta_i \rVert)
$$


## A Coherence-based Clustering Method for Multichannel Speech Enhancement in Wireless Acoustic Sensor Networks

This paper proposes a way to cluster nodes in a WASN based on the estimation of the magnitude-squared cohesion between microphones observations. This measures the degree of their linear dependency by analysing similar frequency components, after which a non-negative matrix factorization (NMF) based approach is developed to find the optimal clustering.

This method should allow to perform clustering dynamically with a very low computational burden. 



**Signal model**

The signal is clean speech plus interference:
$$
x_m(t) = s_m(t) + v_m(t) \\
$$
Collecting a frame of observation samples in vector form, the signal model can be rewritten as: 
$$
\begin{align} 
\bold x_m(t) &= [x_m(t)x_m(t − 1). . . x_m(t − T + 1)]T \\ 
&= \bold s_m(t) + \bold v_m(t)

\end{align}
$$

* $T$ frame size

  

**Clustering**

The proposed clustering algorithm works in two steps:

1. Compute the magnitude squared coherence between the microphone observations to measure their degree of linear dependency
2. Apply NMF to the output of the previous step to find the optimal clustering



**Magnitude squared coherence**

We can measure the coherence between two signals $x(t)$ and $y(t)$ by computing the FFT of the signals. Then, we measure the coherence as a function of the center frequency of the filter.
$$
\Gamma_{xy}(f) = \frac{\lvert S_{xy}(f)\rvert ^2}{S_{xx}(f)S_{yy}(f)}
$$
$S_{xy}(f)$ is the cross-spectral density, which is really a spectral correlation density. This tells how the two signals are correlated in the time domain at a certain frequency and can be computed as:
$$
S_{xy}(f) = \sum_{k=1-T}^{T-1} R_{xy}(k)e^{-i2\pi fk}
$$
$R_{xy}(k)$ is the cross-correlation function between $x(t)$ and $y(t)$ and can be estimated by:
$$
R_{xy}(k) = 
\begin{cases}
\frac 1T \sum_0^{T-1-k} x(t)y(t+k)  &k=0,\dots,T-1 \\
R_{xy}(-k)  &k=-(T-1),\dots,-1 \\

\end{cases}
$$
Now we'll make a matrix consisting of all the correlations between the different microphone signals. We'd like to give the same weight to all frequency bins, regardless of their power. So we'll use the following coherence metric:
$$
C_{xy} = \frac{\sum_{f=0}^{F} \Gamma_{xy}(f)}{F}
$$

* $F$: is the amount of frequency bins.

This can be organized in a matrix:
$$
C=
\begin{bmatrix}
1 & \cdots & \cdots & C_{1M} \\
C_{12} & 1 & \cdots &\vdots \\
\vdots& \vdots& \ddots &\vdots \\
C_{1M} & C_{2M} & \cdots & 1
\end{bmatrix}
$$
Note that all the values in this matrix are non negative, due to the cross-correlation function that was used.



**NMF-based model for clustering coherence observations**

Every value $C_{ij}$ contains the degree of correlation between the $i$-th and $j$-th observation. This means that microphones close to a certain source will be correlated. The matrix $C$ can be modelled as:
$$
C = BB^T \odot (1-I) + 1
$$

* $B \in \mathbb{R}^{M \times K}$ is the cluster matrix, where $K$ is the amount of speakers (the amount of clusters)
  * Because $C$ is symmetric, we model it as $BB^T$
* Where $\odot$ is the element-wise product
* $I$ is the identity matrix 
* $1$ is the all-ones matrix
  * These two are introduced because the main diagonal of $C$ does not provide any relevant information in the learning process of $B$



Based on Euclidian divergence, $B$ is estimated with multiplicative update rules. It is first initialized with random values in the algorithm:
$$
B \leftarrow B \odot \frac{(C \odot (1-I))B}{(BB^T \odot (1-I))B}
$$

* With element-wise division

Now each column of $B$ contains the contribution of a microphone to each cluster. We can obtain the clustering result with:
$$
\gamma_m = \{
j \in [1,K] : B_{mj} \geq B_{mk}, \forall k \in [1,K]
\}
$$
This is simply the largest value of that column.



**Results**

Confusion matrices for simulations with 3 clusters and 50 microphones. For reverberation time $T_{60} = 200 \space ms$  and $T_{60} =  400 \space ms$.

<img src="img/clustering/image-20221206121717073.png" alt="image-20221206121717073" style="zoom:67%;" />

<img src="img/clustering/image-20221206121759388.png" alt="image-20221206121759388" style="zoom:67%;" />

The variance ratio criterion (VRC) is used to obtain the optimal number of clusters, which is the same as the amount of speakers. This model seems robust against reverberation. According to the authors, this method outperforms the method based on k-means and AR models. This model works better, the more microphones are introduced, because more spatial information is captured, making it easier to discriminate coherence patterns.



**Conclusion**

This method allows to perform clustering without any prior knowledge of the speakers or the acoustic scene. And showed improved clustering performance in comparison to other methods.





## Notes

cluster 4

project ghent

adhoc thesis jupyterlabs

