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





# Labo's

## Vragen

* Lab 1
  * [Is your browser running HTTP version 1.0 or 1.1? What version of HTTP is the server running?](#l1v1)
  * [How many HTTP GET request messages did your browser send? To which Internet addresses (URL) were these GET requests sent?](#l1v16)
  * [Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain.](#l1v17)
  * [When your browser’s sends the HTTP GET message for the second time, what new field is included in the HTTP GET message?](#l1v19)
* Lab 2
  * [How many bytes are in the IP header? How many bytes are in the payload of the IP datagram? Explain how you determined the number of payload bytes.](#l2v3)
  * [Analyze the first fragment of the fragmented IP datagram. What information in the IP header indicates that the datagram been fragmented? What information in the IP header indicates whether this is the first fragment versus a latter fragment? How long is this IP datagram?](#l2v10)





## 1. Wireshark Lab: HTTP v7.0

### 1.1. The Basic HTTP GET/response interaction

1. *Is your browser running HTTP version 1.0 or 1.1? What version of HTTP is the server running?* <a name="l1v1"></a>

In het http GET request:

<img src="img/image-20220224145541537.png" alt="image-20220224145541537" style="zoom:50%;" />

Response van de server:

<img src="img/image-20220224145657808.png" alt="image-20220224145657808" style="zoom:50%;" />

2. *What languages (if any) does your browser indicate that it can accept to the server?* 

   

```http
Accept: text/html, text/plain, text/sgml, text/css, */*;q=0.01\r\n
```

3. *What is the IP address of your computer? Of the gaia.cs.umass.edu server?* 

```
157.193.215.200
128.119.245.12
```

4. *What is the status code returned from the server to your browser?* 

```
200 OK
```

5. *When was the HTML file that you are retrieving last modified at the server?* 

```
Last-Modified: Wed, 18 Oct 2017 05:59:01 GMT\r\n
```

6. *How many bytes of content are being returned to your browser?* 

```
File Data: 128 bytes
```

7. *By inspecting the raw data in the packet content window, do you see any headers within the data that are not displayed in the packet-listing window? If so, name one.*

```
? //TODO
```



### 1.2. The HTTP CONDITIONAL GET/response interaction

optioneel, effe skippen dus

### 1.3. Retrieving Long Documents

Ook optioneel blijkbaar

### 1.4. HTML Documents with Embedded Objects

16. *How many HTTP GET request messages did your browser send? To which Internet addresses (URL) were these GET requests sent?* <a name="l1v16"></a>

```
http.request.method == GET
```

<img src="img/image-20220224150937427.png" alt="image-20220224150937427" style="zoom:50%;" />

Geeft er 4 terug. De destination adressen staan in het destination veld.

17. *Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain.* <a name="l1v17"></a>

![image-20220224152226721](img/image-20220224152226721.png)

Ze lijken parallel gedownload te zijn. De twee GET requests (`10` en `16`) worden direct na elkaar gestuurd, zonder te wachten op het antwoord. Nu weet ik niet of dit belangrijk is, maar in `20` zit een response dat zegt dat de afbeelding is verplaatst, waardoor hij in `30` opnieuw opgehaald moet worden. 



### 1.5 HTTP Authentication

18. *What is the server’s response (status code and phrase) in response to the initial HTTP GET message from your browser?* 

```
401 Unauthorized
```



```http
Frame 10: 783 bytes on wire (6264 bits), 783 bytes captured (6264 bits)
Ethernet II, Src: SuperMic_b0:30:fc (0c:c4:7a:b0:30:fc), Dst: ASUSTekC_77:5e:5c (14:da:e9:77:5e:5c)
Internet Protocol Version 4, Src: 128.119.245.12, Dst: 157.193.215.200
Transmission Control Protocol, Src Port: 80, Dst Port: 45102, Seq: 1, Ack: 382, Len: 717
Hypertext Transfer Protocol
    HTTP/1.1 401 Unauthorized\r\n
    Date: Wed, 18 Oct 2017 13:14:02 GMT\r\n
    Server: Apache/2.4.6 (CentOS) OpenSSL/1.0.2k-fips PHP/5.4.16 mod_perl/2.0.10 Perl/v5.16.3\r\n
    WWW-Authenticate: Basic realm="wireshark-students only"\r\n
    Content-Length: 381\r\n
    Keep-Alive: timeout=5, max=100\r\n
    Connection: Keep-Alive\r\n
    Content-Type: text/html; charset=iso-8859-1\r\n
    \r\n
    [HTTP response 1/1]
    [Time since request: 0.105910000 seconds]
    [Request in frame: 8]
    [Request URI: http://gaia.cs.umass.edu/wireshark-labs/protected_pages/HTTP-wireshark-file5.html]
    File Data: 381 bytes
Line-based text data: text/html (12 lines)
    <!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">\n
    <html><head>\n
    <title>401 Unauthorized</title>\n
    </head><body>\n
    <h1>Unauthorized</h1>\n
    <p>This server could not verify that you\n
    are authorized to access the document\n
    requested.  Either you supplied the wrong\n
    credentials (e.g., bad password), or your\n
    browser doesn't understand how to supply\n
    the credentials required.</p>\n
    </body></html>\n

```



19. *When your browser’s sends the HTTP GET message for the second time, what new field is included in the HTTP GET message?* <a name="l1v19"></a>

```
Authorization: Basic d2lyZXNoYXJrLXN0dWRlbnRzOm5ldHdvcms=\r\n
Als je base64 decodeert -> wireshark-students:network
```



```http
Frame 19: 506 bytes on wire (4048 bits), 506 bytes captured (4048 bits)
Ethernet II, Src: ASUSTekC_77:5e:5c (14:da:e9:77:5e:5c), Dst: SuperMic_b0:30:fc (0c:c4:7a:b0:30:fc)
Internet Protocol Version 4, Src: 157.193.215.200, Dst: 128.119.245.12
Transmission Control Protocol, Src Port: 45104, Dst Port: 80, Seq: 1, Ack: 1, Len: 440
Hypertext Transfer Protocol
    GET /wireshark-labs/protected_pages/HTTP-wireshark-file5.html HTTP/1.1\r\n
    Host: gaia.cs.umass.edu\r\n
    User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:55.0) Gecko/20100101 Firefox/55.0\r\n
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n
    Accept-Language: en-US,en;q=0.5\r\n
    Accept-Encoding: gzip, deflate\r\n
    Connection: keep-alive\r\n
    Upgrade-Insecure-Requests: 1\r\n
    Authorization: Basic d2lyZXNoYXJrLXN0dWRlbnRzOm5ldHdvcms=\r\n
    \r\n
    [Full request URI: http://gaia.cs.umass.edu/wireshark-labs/protected_pages/HTTP-wireshark-file5.html]
    [HTTP request 1/1]
    [Response in frame: 21]

```



### 1.A. Appendix: making a live capture

![image-20220224153428799](img/image-20220224153428799.png)

geweldig



## 2. Wireshark Lab: IP



### 2.1 A look at the captured trace

1. *Select the first ICMP Echo Request message sent by your computer, and expand the Internet Protocol part of the packet in the packet details window. What is the IP address of your computer?* 

```
Internet Protocol Version 4, Src: 192.168.1.102, Dst: 128.59.23.100
```

(the source address)

2. *Within the IP packet header, what is the value in the upper layer protocol field?* 

```
Protocol: ICMP (1)
```

3. *How many bytes are in the IP header? How many bytes are in the payload of the IP datagram? Explain how you determined the number of payload bytes*.  <a name="l2v3"></a>

```
.... 0101 = Header Length: 20 bytes (5)
Total Length: 84
84 - 20 = 64
64 bytes payload dus
```



4. *Has this IP datagram been fragmented? Explain how you determined whether or not the datagram has been fragmented.*

<img src="img/image-20220224155540263.png" alt="image-20220224155540263" style="zoom:50%;" />

Er staat dat er geen andere fragmenten zijn dus ik veronderstel van niet 

5. *Which fields in the IP datagram always change from one datagram to the next within this series of ICMP messages sent by your computer?* 

```
Time to live
Header Checksum
Identification
```



6. *Which fields stay constant? Which of the fields must stay constant? Which fields must change? Why?*

```
Source IP & Destination IP (moeten constant blijven want we zijn de route tussen de twee aan het zoeken)
De TTL moet altijd veranderen (incrementeren) om de next hop te identificeren
```



7. *What is the value in the Identification field and the TTL field?* 

```
TTL: 255
ID: verandert
```



8. *Do these values remain unchanged for all of the ICMP TTL-exceeded replies sent to your computer by the nearest (first hop) router? Why?*

```
De TTL sowieso wel, hij komt van een router die maar 1 hop verder zit, dus de TTL gaat in transit nooit veranderen. De identification zal wel altijd veranderen hoop ik.
```



9. *Find the first ICMP Echo Request message that was sent after the Packet Size has been changed to 2000 bytes. Has that message been fragmented across more than one IP datagram? [Note: The provided trace was captured from a computer that has an Ethernet interface, which means that a packet size of 2000 should cause fragmentation.2 ]* 

![image-20220224161326813](img/image-20220224161326813.png)

Het lijkt me wel gesplitst

10. *Analyze the first fragment of the fragmented IP datagram. What information in the IP header indicates that the datagram been fragmented? What information in the IP header indicates whether this is the first fragment versus a latter fragment? How long is this IP datagram?* <a name="l2v10"></a>

<img src="img/image-20220224161743501.png" alt="image-20220224161743501" style="zoom:50%;" />

* More fragments staat op 1
* Fragment offset: 0 (dus dit is het begin)
* Total Length: 1500

11. *Analyze the second fragment of the fragmented IP datagram. What information in the IP header indicates that this is not the first datagram fragment? Are there more fragments? How can you tell?* 

<img src="img/image-20220224161821653.png" alt="image-20220224161821653" style="zoom:50%;" />

* Fragment offset: 1480
* More fragments: 0 (dus geen volgende fragmenten)

12. *What fields change in the IP header between the first and second fragment?*

```
Length, Flags, Header Checksum
```



13. *How many fragments were created from the original datagram?* 

```
3
```



14. *What fields change in the IP header among the fragments?*

```
Length, Flags, Header Checksum
```





### 2.A. Appendix

![image-20220224162607564](img/image-20220224162607564.png)

