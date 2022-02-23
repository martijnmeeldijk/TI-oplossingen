# CN2

[Het boek](https://www.ucg.ac.me/skladiste/blog_44233/objava_64433/fajlovi/Computer%20Networking%20_%20A%20Top%20Down%20Approach,%207th,%20converted.pdf)

# Leerstof

(gewoon de lijst vanop ufora)



- Introductieles
  - Sectie 1.5 Protocollagen en servicemodel
  - Sectie 2.1 Principes van netwerkapplicaties
  - Sectie 3.2 Multiplexen en demultiplexen
  - Sectie 6.7 Een dag in het leven van ...

- Week 1
  - Sectie 2.4 DNS 
  - Kennisclip: Resolver
  - Kennisclip: DNS registratie
  - Kennisclip: Reverse DNS (*)
  - Kennisclip: DNS server (*)
  - Sectie 2.5 Peer-to-peer bestandsdistributie
    - Kennisclip: What is een DHT? (*)
    - Kennisclip: Hoe werkt een DHT? (*)
- WEEK 2
  - Sectie 4.3.3 IPv4 Dynamic Host Configuration Protocol
    - Kennisclip: DHCP
    - Kennisclip: DHCP renewal & relay (*)*
    - *Kennisclip: DHCP server (*)
  - Sectie 4.3.4 Network Address Translation Protocol
    - Kennisclip: Network Address Translation
  - Sectie 5.6 Internet Control Message Protocol (ICMP)
    - Kennisclip: Internet Control Message Protocol (*)



# Notities

## Week 1

Sluit je een pc aan op een netwerk, stuurt hij eerst een **dhcp request**. Vervolgens wordt er een **dns request** uitgestuurd om het ip adres van de website te vinden. Het dns-pakketje, geëncapsuleerd in UDP, sturen we naar de DNS server. Hiervoor heb je ook het MAC adres van de default gateway nodig. Deze vind je met ARP.



DNS is in de praktijk beide iteratief en recursief. 



Three way TCP handshake 

* SYN
* ACK
* SYNACK



Een socket is een soort deurtje van de transportlaag naar je applicatie. 



# Samenvatting

## Intro

### Protocol layers and their service models

<img src="img/image-20220223165015145.png" alt="image-20220223165015145" style="zoom:50%;float: right;" />Om structuur te voorzien bij het ontwerpen van netwerkprotocollen, organiseren we protocollen, de netwerkhardware en -software in **lagen**. Elke laag doet dan een dienst aan de bovenliggende laag, gebruikmakende van de dienst van de onderliggende laag. Zo kan één laag bijvoorbeeld instaan voor het afleveren van berichten, en zijn bovenliggende laag voor foutcontrole en het herversturen van verloren berichten. 

Het werken met laagjes zorgt ervoor dat het veel makkelijker is om de verschillende protocollen te onderhouden en te updaten, aangezien ze gescheiden zijn.

Een **protocol stack** bestaat uit meerdere lagen van verschillende protocollen. Bij de internet protocol stack zijn dit er vijf:

* **Applicatielaag**
  * Protocollen zoals HTTP, IMAP en DNS
  * Een protocol op de applicatielaag is meestal verdeeld over meerdere end-users
  * Een pakket op de applicatielaag noemen we een <u>message</u>
* **Transportlaag**
  * De transportlaag transporteert messages van de applicatielaag.
  * Op het internet zijn er twee transportprotocollen: 
    * TCP: connectie-georiënteerd, er gaan basically nooit pakketten verloren
    * UDP: connectieloze verbinding, minder betrouwbaar, maar sneller (handig bij calls en streaming enzo)
  * Een pakket op de transportlaag noemen we een <u>segment</u>
* **Netwerklaag**
  * De netwerklaag zorgt ervoor dat pakketten van de ene host naar de andere geraken
  * Hier draait het IP protocol
  * Een pakket op de netwerklaag heet een <u>datagram</u>
* **Datalinklaag**
  * De datalinklaag zorgt voor elke stap in het proces van een pakket tot aan een host brengen, dat het pakket naar de volgende node raakt. 
  * Een pakket kan dus bij elke hop in de grote hoeveelheid routers waar hij langskomt door een ander protocol behandeld worden. Zie het zo, als je een messenger-bericht stuurt, zal je gsm eerst het pakket via wifi naar de default gateway sturen (de router). Daarna stuurt je router het waarschijnlijk door een coax kabel naar een router van telenet in je straat, ... enzovoort. In elk van deze stappen wordt het datagram van de netwerklaag uitgepakt en in een frame van het desbetreffende linklaagprotocol gestoken.
  * Protocollen zoals Ethernet, Wifi of PPP
  * Een pakket van de linklaag noemen we een <u>frame</u>
* **Fysieke laag**
  * De fysieke laag staat in voor het verplaatsen van individuele bits van het ene apparaat naar het andere.
  * Door verschillende mediums zoals:  twisted-pair copper wire, single-mode fiber optics.



Dit is natuurlijk niet de enige protocolstack (wel de meest gebruikte). In de seventies werd het OSI-referentiekader bedacht rond het idee dat computernetwerken in zeven lagen georganiseerd moesten worden. In het OSI-model heb je nor twee extra lagen:

* **Presentatielaag**
  * Zorgt ervoor dat services de betekenis van uitgewisselde data kunnen interpreteren, dit kan in de vorm van encryptie of compressie, met als oogmerk om ervoor te zorgen dat de bovenliggende lagen zich niet druk zouden hoeven te maken over dergelijke zaken.

* **Sessielaag**
  * Zorgt voor de afbakening en synchronisatie van datauitwisseling.



#### Encapsulatie

<img src="img/image-20220223171923724.png" alt="image-20220223171923724" style="zoom:50%;" />

Om het even kort te houden. Deze afbeelding legt het concept vrij goed uit. Ons pakketje wordt telkens ingepakt in een pakket van de bovenliggende laag en weer uitgepakt tot waar nodig.
