# Beveiliging van netwerken en computers

* 70% schriftelijk examen 
* 30% labosessies

Wanneer men minder dan 8/20 heeft voor minstens één van de onderdelen kan men niet meer slagen voor het geheel van het opleidingsonderdeel.



# Theorie

## Chapter 1: Introduction



## Chapter 2: Basic concepts 

Explain the difference between confidentiality, authentication, access control / authorization, data integrity, non-repudiation and availability

Which of the above security goals are realized in the network protocols from Chapter 4?

Why are sequence numbers (or nonces) added to messages? Is it a good idea to use a time stamp for
this purpose?
Which counter measurements can be taken against DoS and DDoS attacks?

Give 5 examples of active attacks that can be used to compromise the security of a network protocol.

## Chapter 3: Encryption algorithms

Try to encrypt and decrypt a self-defined message using the provided encryption approaches

What are block cipher modes? What are the advantages and disadvantages of the modes described in the course?

How secure is 3-DES? Explain why.

What does ECDHE_RSA stand for? For which purpose are these different algorithms used?

Why is AES or DES not typically used as a hash function?

What are the strong and weak collision requirements?

Give an example scenario describing why these are relevant.

What is the main difference between a digital signature and a MAC?

## Chapter 4: Network and communication security

True or false: the SSH transport layer protocol encrypts TCP packets. Explain.

Explain the functions of the SSH transport layer protocol, SSH user authentication protocol and SSH connection protocol

In which scenarios does it make sense to do a SSH key re-exchange? Why?

What is the difference between a SSH session and a SSH channel? Which channels are supported?

Which port number does SSH typically listen to?

Explain the difference between local and remote port forwarding.





Explain the benefits of ephemeral DH over traditional DH.

What is the difference between a Key Distribution Centre (KDC) and Public Key Infrastructure (PKI)?

What are the advantages / disadvantages of both approaches?

List 5 reasons why a certificate might have to be revoked. How can this revocation be implemented?

Give example restrictions that can be part of a certificate. Why are these relevant?





What are the main differences between TLS and SSH?

TLS encrypted packets are authenticated when they are transmitted. Does this authentication mechanism use a shared secret key, or a private key? Why?

Is TLS vulnerable to traffic pattern analysis attacks? Why (not)?

Is the TLS record header included in each transmitted TCP packet?

For which applications / use cases would you prefer SSH over TLS (and vice versa)? Why?



Give 5 examples of security problems that can be solved by IPsec but not by TLS or SSH

Which of the following security services can be achieved with IPsec: access control, integrity, authentication, confidentiality (which types)?

Which IPsec protocols provide traffic flow confidentiality? Why is this only a limited form of confidentiality?

## Chapter 5: Software and systems security

True or false: to generate an S/MIME session key, first a key exchange algorithm is invoked

What is the purpose of degenerate signedData messages in S/MIME?

Explain the workings of cross-site scripting. How can one defend against this type of attack?

Explain the differences between XSS and CSRF



What are the advantages and disadvantages of increasing the length of hash chains / rainbow tables?

Explain the major differences between hash chains and rainbow tables.

What is 2-factor authentication?

What are the security advantages of using security tokens vs software based approaches?

Which are the advantages of using full disk encryption vs manual encryption?

## Chapter 6: Intrusion detection



## Chapter 7: Future trends





# Labo



## Veelgemaakte fouten ssh

![](img/beveiliging/image-20221026202919263.png)

* Server zegt nee omdat de verkeerde key wordt aangeboden



![image-20221026202932694](img/beveiliging/image-20221026202932694.png)

* Je mag niet aan de map
* sudo zal niks uithalen, want je krijgt meer rechten op de lokale machine
* Kopieer eerst het bestand van de lokale machine naar een map waar je wel rechten op hebt, ssh naar de server en voer sudo cp om het bestand dan op de juiste plaats op de remote te zetten

![image-20221026202947102](img/beveiliging/image-20221026202947102.png)

* Gebruiker heeft geen toegang tot het bestand op de lokale machine
* Hier werkt sudo wel
* Je kan wel weer een public key permission denied krijgen omdat hij de default keys van de root gebruiker zal gebruiken voor ssh



### Permission denied (public key)

Check 3 dingen:

* Zit ik op de juiste user?
* Gebruikt de client de juiste key?
  * default ~/.ssh/id_\*
* Heeft de server de juiste key voor de juiste user?



### SSH naar private VM zonder routing

​	![1](img/beveiliging/image-20221026204035341.png)

In dit scenario is er geen routing van de client naar de nieuwe VM

```bash
ssh -NT -L 8888:192.168.64.2:22 student@192.168.132.1
#			|				|			|
#			|				|			|
#			Lokale poort	|		Login van gateway
#							|
#							Poort van nieuwe VM
# NT -> gewone portforwarding, geen shell

ssh -p 8888 student@localhost
```





![image-20221026204900983](img/beveiliging/image-20221026204900983.png)

* Het bovenste moet je doen op de gateway
* Het tweede doet remote port-forwarding
  * Al het verkeer dat wordt gestuurd naar een bepaalde poort van de remote server, wordt doorgestuurd over de ssh tunnel naar de lokale server, waarna het doorgestuurd wordt naar het IP adres dat we aangeven.