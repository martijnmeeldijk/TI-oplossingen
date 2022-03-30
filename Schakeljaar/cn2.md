# CN2

[Het boek](https://www.ucg.ac.me/skladiste/blog_44233/objava_64433/fajlovi/Computer%20Networking%20_%20A%20Top%20Down%20Approach,%207th,%20converted.pdf)

# Leerstof

(gewoon de lijst vanop ufora)



- Introductieles
  - Sectie 1.5 Protocollagen en servicemodel `x`
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
- WEEK 3
  - Sectie 6.4 Local-Areanetwerken met switches (herhaling, behalve *)
    - Kennisclip: ARP
    - Kennisclip: ARP cache management (*)
    - Kennisclip: Ethernet switching
    - Kennisclip: VLAN




# Notities

## Week 1

Sluit je een pc aan op een netwerk, stuurt hij eerst een **dhcp request**. Vervolgens wordt er een **dns request** uitgestuurd om het ip adres van de website te vinden. Het dns-pakketje, geëncapsuleerd in UDP, sturen we naar de DNS server. Hiervoor heb je ook het MAC adres van de default gateway nodig. Deze vind je met ARP.



DNS is in de praktijk beide iteratief en recursief. 



Three way TCP handshake 

* SYN
* ACK
* SYNACK



Een socket is een soort deurtje van de transportlaag naar je applicatie. 

Oké er was dus maar 1 les. Tot zover de notities.



# -------------Samenvatting-------------

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

//TODO 2.1, 3.2, 6.7



## DNS

Een **DNS resolver** is een client-side programma dat instaat voor het omvormen van webadressen naar ip-adressen. Meestal krijgt onze host een default DNS server via DHCP. 

Voordat DNS bestond had elke host een mapping met hostnames en ip adressen. 

Buiten de API van je besturingssysteem zijn er nog andere manieren om te interageren met DNS servers

* `host`: queries met enkel een hostname
* `nslookup`
* `DiG`: handige tool voor geavanceerde queries

```bash
dig +trace www.example.com
```

Dig is handig, want je kan met de trace flag het hele afgelegde pad van je query navragen.

### Hierarchie

<img src="img/image-20220228104417057.png" alt="image-20220228104417057" style="zoom: 33%;" />

Er zijn over de wereld een aantal **root dns servers**, deze bevatten resource records voor elk van de top level domains (com, edu, be, ...). Deze vertellen je eigenlijk waar je de volgende server kunt vinden. Gaan we een niveau lager, komen we bij de **top level domain servers**. Deze zullen je vertellen waar je het ip adres van een bepaald domein kunt vinden (ugent, gov, nokia, ...). Vanaf hier kan je blijven omlaag gaan naar subdomeinen. 

**Registry operators** zijn de mensen die de database onderhouden waarin staat welke domeinnamen van wie zijn. We noemen deze database de **registry** Generische top-level domeinen (com, org, edu) worden beheerd door ICANN, maar het beheer van domeinen zoals *be, nl* verschilt per land. 

**Registrars** zijn bedrijven die toegang krijgen tot de registry om domeinnamen te registreren voor registrants.

Een **registrant** is een persoon die de rechten tot een domeinnaam bezit.



Met het commando `whois` kan je opzoeken wie de eigenaar is van een domein.



### Reverse DNS

Met reverse dns kan je de domeinnaam vinden die bij een bepaald ipadres hoort. Dit is niet zo makkelijk als het klinkt, want je kan niet zomaar alle DNS servers gaan doorzoeken om het record te vinden dat bij een bepaald ip adres hoort. Om reverse queries toe te laten, werd er een nieuw top level domain, genaamd arpa aangemaakt. Binnen het in-addr subdomein heb je dan een subdomein per octet van het ip adres.

Het proces van reverse DNS gaat dus eigenlijk in dezelfde volgorde als gewone DNS.

<img src="img/image-20220228113631667.png" alt="image-20220228113631667" style="zoom: 33%;" />

### DNS server

Een **caching dns server** zorgt ervoor dat gebruikers sneller een resultaat kunnen krijgen op DNS queries. Hij houdt de resultaten van vorige queries bij (zolang de time to live van het record dit toelaat). Wil je zelf een (caching) DNS server beheren, zal je zelf de adressen van de root servers in de DNS server moeten steken.



**Authoritative dns servers** beantwoorden enkel queries met betrekking tot records waarover zij authoriteit hebben. Als zij niet over deze data beschikken, zullen ze de query doorverwijzen (en ze niet recursief verwerken).

<img src="img/image-20220228163051606.png" alt="image-20220228163051606" style="zoom: 33%;" />

Wat doet een DNS server precies?

* *named* daemon luistert op poort 53 (spreek je uit als name-D)
* Queries komen binnen via UDP, zone transfers gebeuren met TCP
* De DNS server antwoordt op queries gestuurd door resolvers
* Een zone file bevat resource records voor een bepaalde zone

Een **zone transfer** is het proces waarin een primaire DNS server een zone file kopieert naar een secundaire dns server, alle resource records zijn op die manier altijd beschikbaar op de secundaire DNS server.

Een **zone** is simpelwel een deel van het domein. In de afbeelding kan dit *com* zijn of *www, dk*. Anderzijds is een domein juist de volledige deelboom vanaf een bepaald punt.



### Zone file

Wat zit er allemaal in een zone file?

* SOA (start of authority) record
  * definiëert default parameters die betrekking hebben tot de hele zone (TTL, email beheerder, refresh rate, ...)
* NS (nameserver) records
  * duidt de authoritatieve DNS server voor het domein aan
* A/AAAA (alias) records
  * de naam van je website bijvoorbeeld
* CNAME (canonical name) records
  * mapt één domeinnaam naar een andere
* MX (mailserver) records

### TTL

* Kleine time to live: meer consistentie en minder fouten op het netwerk
* Grote time to live: minder belasting op het netwerk en snellere DNS queries



## Peer-to-peer bestandsdistributie

### Bittorrent

Bij bittorrent worden bestanden opgesplitst in **chunks** van 512KB. Een **torrent** is dan een groep van **peers** (computers) die een bestand delen met elkaar. Een **tracker** is een node die de actieve peers van een torrent bijhoudt. Om een download te starten moeten we dus eerst van de tracker een lijst van peers krijgen. Hiermee kunnen we dan bestanden uitwisselen.

Trackers zijn eigenlijk de bottleneck van het hele gebeuren. Als we het hele systeem willen verkloten moeten we enkel de trackers uitschakelen en niemand kan nog files downloaden. Zijn er alternatieven waar dit niet het geval is?



### Distributed hash table (DHT)

We gebruiken in plaats van een tracker een gedistribueerde hashtabel. De key-value paren van een gewone hashtabel worden verdeeld over verschillende nodes. Elke node krijgt een id. We maken vervolgens een hashfunctie die elke sleutel afbeeldt op een node en een record binnen die node.

Hier onstaat dan natuurlijk weer een probleem. Wat moeten we doen als we op een id uitkomen die niet hoort bij een node? Dan gaan we simpelweg naar de eerstvolgende node.

<img src="img/image-20220228170856251.png" alt="image-20220228170856251" style="zoom:50%;" />

**Peer churn** (het constant joinen en leaven van nodes)

Nodes slaan telkens het ip adres van hun opvolger op. Als er een node het netwerk verlaat, moet hij eerst al zijn records aan zijn opvolger geven. Komt er een nieuwe node bij, dan neemt hij een deel van de records van zijn opvolger op. 



## DHCP

Hoe stellen we op ons apparaat het juiste ip adres in? We kunnen manueel op onze host het ip adres ingeven, maar als we dan omhoog willen schalen naar meer hosts, komen we in de problemen. Hier komt **DHCP** binnen spel. We willen dat als er een pc op het netwerk wordt aangesloten, hij automatisch een ip-adres krijgt.

Een **DHCP server** houdt een lijst van vrije ip-adressen bij. Als een apparaat zich aansluit op het netwerk, zal hij een **DHCP request** sturen naar de server, waarna de server zal antwoorden met het volgende vrije ip-adres in zijn lijst. Omdat de host wanneer hij pas op het netwerk zit het adres van de DHCP server nog niet weet, zal hij eerst een **DHCP discover** broadcasten over het netwerk.

Iets meer detail:

<img src="img/image-20220228222327627.png" alt="image-20220228222327627" style="zoom:33%;" />

* DHCPDISCOVER
  * aanvraag voor een ip-adres, uitgestuurd door de client
* DHCPOFFER
  * De DHCP server biedt een adres aan 
  * het kan dat er meerdere servers tegelijk een offer sturen, de client kiest er dan eentje
* DHCPREQUEST
  * De client antwoordt om het offer te bevestigen
* DHCPACK
  * De server bevestigt het request

Merk op dat de lease time 86400s bedraagt. Als de client zijn 'lease' op het ip adres niet vernieuwt binnen deze tijd, kan het ip-adres hergebruikt worden.

DHCP kan je niet alleen het gealloceerde ip-adres binnen het subnet geven, maar ook het adres van de default gateway en het subnetmasker.

Is er op het netwerk geen DHCP server beschikbaar, kan een host een random gegenereerd ipv4 link-local adres (169.254.X.X/16) gebruiken. Om dan toch zeker te zijn dat je niet het ip adres van iemand anders hebt genomen, kan je een ARP request op het netwerk uitsturen. Als er dan iemand op antwoord genereer je een nieuw adres. Dit is een goede fallback, maar kan voor problemen zorgen als de DHCP server terug online komt. 

Verder heb je met een DHCP server ook het gevaar van een **single point of failure**. Deze tekortkomingen worden blijkbaar opgelost in ipv6

### DHCP Renewal

Wanneer onze lease vervalt, zou in principe de gebruiker een nieuwe aanvraag moeten sturen om opnieuw een ip adres te verkrijgen. Dit is natuurlijk niet zo handig, want als hij dan een ander ip adres krijgt gaan er paketten verloren en een heleboel andere bazaar.

Daarom voorziet DHCP een **renewal**-proces. Dit proces gaat als volgt:

<img src="img/image-20220307164629961.png" alt="image-20220307164629961" style="zoom: 33%;" />

* DHCPREQUEST
  * Wordt typisch in de helft van de lease time al gestuurd van de host naar de DHCP server waarvan hij het ip adres kreeg.
  * Als deze niet beschikbaar is zal een andere DHCP-server geprobeerd worden door de dhcprequest te broadcasten.
* DHCPACK
  * De server antwoordt rechtstreeks naar de cilent met de mededeling dat hij het ip-adres mag blijven gebruiken.

### DHCP Relay

Als we in ons netwerk verschillende kleine subnetten hebben, zo het achterlijk zijn om op elk subnet een DHCP server te zetten. Het probleem is nu eenmaal wel dat onze hosts enkel binnen hun subnet naar een ip-adres kunnen vragen, want ze hebben er nog geen. Om dit probleem tegen te gaan kunnen we gebruik maken van een **DHCP relay**. De relay ontvangt alle DHCP broadcasts en stuurt ze per unicast door naar de DHCP server (in een ander subnet). In de omgekeerde richting (met de offer enzo), gaat het exact hetzelfde. De DHCP server stuurt de offer naar de relay en deze stuurt het in zijn subnet als een broadcast, waardoor het voor de host lijkt alsof hij met een gewone DHCP-server praat.

De meeste routers tegenwoordig hebben DHCP-relays ingebouwd.



### DHCP server

Om onze DHCP-server te laten werken, voorzien we hem eerst en vooral van een aantal **scopes**. Dit zijn ranges van ip adressen (bv 192.168.0.1 - 192.168.0.100 of 192.168.0.0/24). Nu kunnen we adressen gaan toekennen aan hosts. Dit kan op basis van het MAC-adres (indien we geen relay gebruiken), we kunnen ook voor specifieke hosts bepaalde adressen gaan reserveren, of een nieuwe host simpelweg een vrij adres uit de lijst toewijzen.

Je kan via DHCP ook andere configuratieparameters meegeven, zoals nameserver, domeinnaam en default gateway.



#### ISC DHCP

2 bestanden:

**/etc/dhcpd.conf**

```sql
lease-file-name "/var/lib/dhcpd/dhcpd.leases";

subnet 192.168.1.0 netmask 255.255.255.0 { # het subnet dat je wilt beheren
        option domain-name "cnet2.ugent.be";
                                                  
                                                  
        default-lease-time 					86400;			# 24 hours
        max-lease-time 							172800;			# 48 hours
        option routers 							192.168.1.1;
        option subnet-mask					255.255.255.0;
        option broadcast-address		192.168.1. 255;
        option domain-name-servers 	192.168.1.1;
				option ntp-servers 					192.168.1.1;
        range 192.168.1.101 	192.168.1.200; # de range binnen het subnet die we mogen beheren
        
        host cnet2server {
            hardware ethernet 00:ca:20:cc:54:89
            fixed address 192.168.1.105
         }
```

 **/var/lib/dhcp/dhcpd.leases**

```sql
lease 192.168.1.108 { 
    starts 0 2021/01/30 08:02:54; 
    ends 5 2021/02/04 08:02:54; 
    hardware ethernet 00:50:04:53:D5:57; 
    uid 01:00:50:04:53:D5:57; 
    client-hostname "laptop-wouter"; 
}

```



## NAT

Er zijn maar $2^{32}$ , oftewel $4.294.967.296$ mogelijke ipv4 adressen. Om dit probleem om te lossen laten we typisch alle toestellen binnen één netwerk hetzelfde ip adres gebruiken. In het geval van je thuisnetwerk heeft je router dan enkel een ip adres. De toestellen binnen je netwerk gebruiken dan een private ip. (192.168.0.22 bijvoorbeeld).

Als je met je computer thuis een pakketje stuurt naar een server buiten je netwerk, zal je router het source ip adres vervangen door zijn publieke ip adres. Hij onthoudt dan jouw ip en de source poort en stuurt het pakketje door naar de server (mogelijks ook via een andere poort). Als hij antwoord krijgt van de server op diezelfde poort weet hij dat hij het pakketje naar jouw pc moet doorsturen.

# ------------------Labo's--------------------

## Vragen

* Wireshark Lab 1
  * [Is your browser running HTTP version 1.0 or 1.1? What version of HTTP is the server running?](#l1v1)
  * [How many HTTP GET request messages did your browser send? To which Internet addresses (URL) were these GET requests sent?](#l1v16)
  * [Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain.](#l1v17)
  * [When your browser’s sends the HTTP GET message for the second time, what new field is included in the HTTP GET message?](#l1v19)
* Wireshark Lab 2
  * [How many bytes are in the IP header? How many bytes are in the payload of the IP datagram? Explain how you determined the number of payload bytes.](#l2v3)
  * [Analyze the first fragment of the fragmented IP datagram. What information in the IP header indicates that the datagram been fragmented? What information in the IP header indicates whether this is the first fragment versus a latter fragment? How long is this IP datagram?](#l2v10)
* DNS
  * [Resolve de URL www.tinder.com verschillende keren na elkaar, en gebruik verschillende nameservers. Herhaal hetzelfde op de home server (log in met SSH), die andere DNS-servers gebruikt. Beschrijf wat je ziet - waarom gaat een groot bedrijf op deze manier te werk?](#dnsv3)
  * [Start in je Linux VM het script capture_dns.sh2 op dat je downloadde; voer de lookup naar www.tinder.com opnieuw uit. Hoeveel DNS requests werden er naar de server gestuurd, hoeveel antwoorden kreeg je terug?](#dnsv4)


# Wireshark



## 1. Wireshark Lab: HTTP v7.0

**1.1. The Basic HTTP GET/response interaction**

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



**1.2. The HTTP CONDITIONAL GET/response interaction**

optioneel, effe skippen dus

**1.3. Retrieving Long Documents**

Ook optioneel blijkbaar

**1.4. HTML Documents with Embedded Objects**

16. *How many HTTP GET request messages did your browser send? To which Internet addresses (URL) were these GET requests sent?* <a name="l1v16"></a>

```
http.request.method == GET
```

<img src="img/image-20220224150937427.png" alt="image-20220224150937427" style="zoom:50%;" />

Geeft er 4 terug. De destination adressen staan in het destination veld.

17. *Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain.* <a name="l1v17"></a>

![image-20220224152226721](img/image-20220224152226721.png)

Ze lijken parallel gedownload te zijn. De twee GET requests (`10` en `16`) worden direct na elkaar gestuurd, zonder te wachten op het antwoord. Nu weet ik niet of dit belangrijk is, maar in `20` zit een response dat zegt dat de afbeelding is verplaatst, waardoor hij in `30` opnieuw opgehaald moet worden. 



**1.5 HTTP Authentication**

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



**1.A. Appendix: making a live capture**

![image-20220224153428799](img/image-20220224153428799.png)

geweldig



## 2. Wireshark Lab: IP



**2.1 A look at the captured trace**

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





**2.A. Appendix**

![image-20220224162607564](img/image-20220224162607564.png)





# DNS

## DNS queries (vanop je client VM)

1. Welk IP-adres heeft www.ugent.be? Welke servers zijn verantwoordelijk voor dit domein? 

```bash
157.193.43.50

;; AUTHORITY SECTION:
UGent.be.		71589	IN	NS	ugdns2.UGent.be.
UGent.be.		71589	IN	NS	ugdns3.UGent.be.
UGent.be.		71589	IN	NS	ugdns1.UGent.be.
UGent.be.		71589	IN	NS	ns.belnet.be.

```



2. www.belnet.be geeft een IP-adres terug, maar als je dit IP-adres probeert om te zetten in een URL (reverse lookup) merk je dat de server een andere naam heeft. Welke? Licht toe hoe je dit vond. 

```bash
$ dig www.belnet.be
=> 217.19.230.167
$ nslookup -x 217.19.230.167
=> 217.19.230.167.static.hosted.by.combell.com.
```



3. Resolve de URL www.tinder.com verschillende keren na elkaar, en gebruik verschillende nameservers. Herhaal hetzelfde op de home server (log in met SSH), die andere DNS-servers gebruikt. Beschrijf wat je ziet - waarom gaat een groot bedrijf op deze manier te werk? <a name="dnsv3"></a>

```bash
# Ik krijg altijd 4 resultaten

$ nslookup www.tinder.com 1.1.1.1
=>
Non-authoritative answer:
Name:	www.tinder.com
Address: 108.156.28.108
Name:	www.tinder.com
Address: 108.156.28.118
Name:	www.tinder.com
Address: 108.156.28.22
Name:	www.tinder.com
Address: 108.156.28.40

# Waarschijnlijk voor load-balancing
```



4. Start in je Linux VM het script capture_dns.sh2 op dat je downloadde; voer de lookup naar www.tinder.com opnieuw uit. Hoeveel DNS requests werden er naar de server gestuurd, hoeveel antwoorden kreeg je terug?<a name="dnsv4"></a>

```bash
# 2 queries, 2 responses
```

<img src="img/image-20220303154303418.png" alt="image-20220303154303418" style="zoom: 33%;" />

5. Netwerkinstellingen DNS server

dit erin kletsen en de default settings (dhcp) verwijderen

```bash
# The primary network interface
allow-hotplug eth0
iface eth0 inet static
address 10.0.2.44
netmask 255.255.255.0
gateway 10.0.2.2 # optioneel, voor als je andere netwerken wil bereiken
```



## DNS-server – caching

1 en 2: gewoon de stappen volgen



3. Werkt jouw DNS-server momenteel iteratief of recursief? Leg uit aan de hand van wat je van verkeer kunnen “capturen” hebt. Werk je DNS-server bij, zodat hij een forwarder contacteert voor zijn eigen aanvragen. Herstart de bind9 server; monitor opnieuw het verkeer zoals in de vorige vraag. Werkt de server nu iteratief of recursief? Leg uit aan de hand het DNS verkeer dat je kon opvangen. 

Ik denk iteratief -> allemaal vragen naar verschillende dns servers want we worden doorverwezen

```sql
tcpdump: verbose output suppressed, use -v or -vv for full protocol decode
listening on eth0, link-type EN10MB (Ethernet), capture size 262144 bytes
IP 10.0.2.15.38474 > 10.0.2.4.53: 49889+ A? www.belnet.be. (31)
IP 10.0.2.4.35762 > 1.1.1.1.53: 53860+ [1au] A? www.belnet.be. (54)
IP 10.0.2.4.57271 > 1.1.1.1.53: 25548+ [1au] NS? . (40)
IP 1.1.1.1.53 > 10.0.2.4.35762: 53860 1/0/1 A 217.19.230.167 (86)
IP 10.0.2.4.53 > 10.0.2.15.38474: 49889 1/0/0 A 217.19.230.167 (47)
IP 1.1.1.1.53 > 10.0.2.4.57271: 25548 13/0/1 NS k.root-servers.net., NS b.root-servers.net., NS h.root-servers.net., NS l.root-servers.net., NS f.root-servers.net., NS i.root-servers.net., NS m.root-servers.net., NS a.root-servers.net., NS j.root-servers.net., NS e.root-servers.net., NS g.root-servers.net., NS c.root-servers.net., NS d.root-servers.net. (267)
IP 10.0.2.15.44113 > 10.0.2.4.53: 35366+ AAAA? www.belnet.be. (31)
IP 10.0.2.4.57863 > 1.1.1.1.53: 15969+ [1au] AAAA? www.belnet.be. (70)
IP 1.1.1.1.53 > 10.0.2.4.57863: 15969 1/6/13 AAAA 2a00:1c98:10:2c::10 (464)
IP 10.0.2.4.53 > 10.0.2.15.44113: 35366 1/6/12 AAAA 2a00:1c98:10:2c::10 (425)

```

nadat je de forwarder instelt is dit de output:

```sql
IP 10.0.2.15.50263 > 10.0.2.44.53: 2630+ A? www.belnet.be. (31)
IP 10.0.2.44.53 > 10.0.2.15.50263: 2630 1/6/12 A 217.19.230.167 (413)
IP 10.0.2.15.44072 > 10.0.2.44.53: 45873+ AAAA? www.belnet.be. (31)
IP 10.0.2.44.53 > 10.0.2.15.44072: 45873 1/6/12 AAAA 2a00:1c98:10:2c::10 (425)

```

== recursief



## DNS-server – authoritative

De configuratie van mijn epische DNS setup:

**named.conf.local**

```c++
//
// Do any local configuration here
//

// Consider adding the 1918 zones here, if they are not used in your
// organization
// include "/etc/bind/zones.rfc1918";

zone "example.com" {
 type master;
 notify no;
 file "/etc/bind/db.example.com";
};

zone "meeldijk.com"{
 type master;
 notify no;
 file "/etc/bind/db.meeldijk.com";
};

zone 2.0.10.in-addr.arpa{
 type master;
 notify no;
 file "/etc/bind/db.10.0.2";
};

```



**db.meeldijk.com**

```sql
$TTL 86400 ; 24 hours could have been written as 24h or 1d
meeldijk.com. 1D IN SOA ns1.meeldijk.com. hostmaster.meeldijk.com. (
 2002022401 ; Serial
 3H ; Refresh
 15 ; Retry
 1w ; Expire
 3h ; Default TTL
 )
 IN NS ns1.meeldijk.com. ; in the domain

; name servers
meeldijk.com. 	IN	NS	ns1.meeldijk.com.
ns1		IN	A 	10.0.2.44 ; name server definition

; andere servers
serv1	IN	A	10.0.2.12 	; general server definition
www	IN	CNAME	serv1 	; web server definition
@	IN	A	10.0.2.44

```



**db.10.0.2**

```sql
$TTL    604800
@       IN      SOA     meeldijk.com. admin.meeldijk.com. (
                              5         ; Serial
                         604800         ; Refresh
                          86400         ; Retry
                        2419200         ; Expire
                         604800 )       ; Negative Cache TTL
;

; Name servers
        IN      NS      ns1.meeldijk.com.

; PTR records
10       IN      PTR      ns1.meeldijk.com.
12	IN	PTR	www.meeldijk.com

```

Dit hier is dus voor de reverse DNS. Ik heb enkel `10.0.2.10` en `10.0.12` erin gezet (laatste twee lijnen). Want dat was het enige dat moest van de opdracht.



### Verificatie

Je demonstreert de correcte werking van je server door vanuit je client 

* een NS lookup uit te voeren van de name server van jouw domein 
* een lookup uit te voeren van www..be 
* een lookup uit te voeren van de ingestelde client hostnaam (deze snap ik niet)
* [extra] een reverse lookup uit te voeren van 10.0.2.10 en 10.0.2.12. 

```bash
student@cnet:~$ nslookup meeldijk.com 10.0.2.44
```

<img src="img/image-20220307111139221.png" alt="image-20220307111139221" style="zoom:50%;" /> 

```bash
student@cnet:~$ nslookup www.meeldijk.com 10.0.2.44
```

<img src="img/image-20220307111227115.png" alt="image-20220307111227115" style="zoom:50%;" /> 

```bash
student@cnet:~$ nslookup -x 10.0.2.10 10.0.2.44 
```

<img src="img/image-20220307111254316.png" alt="image-20220307111254316" style="zoom:50%;" /> 

```bash
student@cnet:~$ nslookup -x 10.0.2.12 10.0.2.44 
```

<img src="img/image-20220307111329085.png" alt="image-20220307111329085" style="zoom:50%;" /> 





# VLANs & STP

## Subnetten

1. Bereken de router interface voor de drie subnetten (die corresponderen met elke VLAN). Kies het hoogst mogelijke IP van het subnet. Wat worden de drie IP-adressen voor de router? 

| Hostname | IP               | VLAN | Interface     | Subnet           | Default GW    |
| -------- | ---------------- | ---- | ------------- | ---------------- | ------------- |
| PC10     | 10.20.101.10/26  | 10   | S1 - Fa0/10   | 10.20.101.0/26   | 10.20.101.62  |
| PC50     | 10.20.101.50/26  | 10   | S2 - Fa0/10   | 10.20.101.0/26   | 10.20.101.62  |
| PC78     | 10.20.101.78/26  | 20   | S1 - Fa0/18   | 10.20.101.64/26  | 10.20.101.126 |
| PC96     | 10.20.101.96/26  | 20   | S3 - Fa0/18   | 10.20.101.64/26  | 10.20.101.126 |
| PC182    | 10.20.101.182/25 | 33   | S3 - Fa0/6    | 10.20.101.128/25 | 10.20.101.254 |
| PC193    | 10.20.101.193/25 | 33   | S2 - Fa0/6    | 10.20.101.128/25 | 10.20.101.254 |
| CompServ | 10.20.101.253/25 | 33   | S0 – Gig1/0/6 | 10.20.101.128/25 | 10.20.101.254 |

* Vlan 10: 10.20.101.62
* Vlan 20: 10.20.101.126
* Vlan 33: 10.20.101.254

2. Stel deze adressen in als default gateway bij alle 6 de host PCs. Configureer eveneens de DNSserver van het bedrijf bij elke host (DNS server is 10.20.101.253). 

```
Klik op pc -> config -> global
```



3. Ga na dat je momenteel _niet_ kan pingen van geen enkele host naar een andere host. De switches behoeven duidelijk nog enige configuratie!

<img src="img/image-20220317151002793.png" alt="image-20220317151002793" style="zoom:50%;" />



### Configuratie access ports

1. Stel op elke switch (s1, s2, s3) de juiste poorten in, opdat alle 6 de host PCs in de juiste VLAN terecht komen. 

```
S1>en
S1#conf t
S1(config)#int fa0/1
S1(config-if)#switchport mode access
S1(config-if)#switchport access vlan 10
% Access VLAN does not exist. Creating vlan 10
S1(config-if)#
```

overal gewoon dit doen

2. Ga na dat de hosts binnen de VLAN naar elkaar kunnen pingen (PC10 naar PC50; PC78 naar PC96) 

   <img src="img/image-20220317152732671.png" alt="image-20220317152732671" style="zoom:50%;" />

   

   

3. Reflecteer over de verbinding s1-s2 en s2-s3. Hoe moeten deze poorten geconfigureerd zijn opdat het netwerk kan werken zoals het nu werkt. Leg uit.



## Configuratie trunk links

1. Stel op switch s0 de juiste poorten in opdat de nodige trunks actief worden in het netwerk. 

```
S1(config)#int G1/0/1
S1(config-if)#switchport mode trunk

-- ook voor 2 en 3
```



2. Ga na dat een host uit VLAN 33 de server, die in deze VLAN vertoeft, de CompServ kan pingen. 

   <img src="img/image-20220317153500867.png" alt="image-20220317153500867" style="zoom:50%;" />

3. Kan deze host een DNS query uitvoeren naar de server?

![image-20220317153601286](img/image-20220317153601286.png)

blijkbaar wel



## Router on a stick

1. Stel op de router de nodige subinterfaces in, opdat de router de default gateway kan zijn voor elke VLAN van je netwerk. 

   ```
   int gig0/0.10
   encapsulation dot1Q 10
   ip addr 10.20.101.62 255.255.255.192
   
   int gig0/0.20
   encapsulation dot1Q 20
   ip addr 10.20.101.126 255.255.255.192
   
   int gig0/0.33
   encapsulation dot1Q 33
   ip addr 10.20.101.254 255.255.255.128
   ```

   

   255.255.255.128

2. Kan elke host de default gateway bereiken? Welke VLAN werkt wel, welke niet?

* S0 - G1/0/4 op trunk zetten

commando om te kijken welke interfaces op trunk staan

```
show interface trunk
```

Zo te zien werkt alleen vlan 33



## Troubleshoot

Enkel VLAN 33 lijkt te werken, hoewel overal alle VLANs in trunking worden toegelaten. Bekijk het VLAN overzicht op elke switch, en probeer na te gaan hoe elke VLAN actief kan krijgen in je hele netwerk. Hint: https://www.letsconfig.com/how-to-configure-vlan-on-cisco-switch/ 

```
doe gewoon op S0 ->
S0#vlan 10
S0#vlan 20
```

Je moet eigenlijk op alle switches alle vlans toevoegen



1. Kan elke host nu de default gateway bereiken? Kan PC78 surfen naar www.ugent.be?

<img src="img/image-20220317163103619.png" alt="image-20220317163103619" style="zoom:33%;" />



## STP 

1. Configureer S0 als root voor elk van jouw VLANs. 



```
spanning-tree vlan 10 root primary
spanning-tree vlan 20 root primary
spanning-tree vlan 33 root primary
```





2. Bekijk op S1, S2 en S3 welke poorten geblokkeerd zijn door het STP protocol. Beschrijf in je persoonlijke verslag hoe de tree er uitziet voor jouw drie VLANs



**S1**

```
VLAN0010

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/23           Altn BLK 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p
Fa0/10           Desg FWD 19        128.10   P2p

VLAN0020

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/23           Altn BLK 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p
Fa0/18           Desg FWD 19        128.18   P2p

VLAN0033

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/23           Altn BLK 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p

```

**S2**

```
VLAN0010

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p
Fa0/10           Desg FWD 19        128.10   P2p

VLAN0020

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p

VLAN0033

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/6            Desg FWD 19        128.6    P2p
Fa0/24           Root FWD 19        128.24   P2p
```

**S3**

```
VLAN0010

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p
Fa0/10           Desg FWD 19        128.10   P2p

VLAN0020

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/24           Root FWD 19        128.24   P2p

VLAN0033

Interface        Role Sts Cost      Prio.Nbr Type
---------------- ---- --- --------- -------- --------------------------------
Fa0/22           Desg FWD 19        128.22   P2p
Fa0/23           Desg FWD 19        128.23   P2p
Fa0/6            Desg FWD 19        128.6    P2p
Fa0/24           Root FWD 19        128.24   P2p
```





# WiFi

## Part I

1. What is the BSSID value of your access point? (You’ll need this in future commands.)

![image-20220324153923997](img/image-20220324153923997.png)

```
04:F0:21:1C:B4:D5
```



2. As stated before, the BSSID needs to be unique for each access point. What does the access point use as BSSID identifier to achieve this goal?

```
mac address
```



3. Are there any packets sent? If yes, who is sending these packets and how often? 

![image-20220324155854749](img/image-20220324155854749.png)

```
The other groups, very often
```

4. Which packets are sent by your access point? Why are these packets necessary? What useful information do these packets contain? 

```
SSID broadcast om netwerk vindbaar te maken
```

5. Why do you also see packets from machines other than from your access point?

```
sniffer, wireless
```



![image-20220324160316747](img/image-20220324160316747.png)





6. Which packets are sent when a device (dis)connects to/from the access point (write down a message chart for both)? 

![image-20220324164114541](img/image-20220324164114541.png)

![image-20220324164248451](img/image-20220324164248451.png)

7. How long does it take to fully associate to the access point (up to and including the assignment of the IP address)?

```
about 2 seconds
```



## Part II

8. Now which packets are always the same size, occur automatically between connected PCs in order to make the IP protocol work (also on wired networks) and will be replyed upon by the AP with a packet of which we will know its content?

```
ARP
```







![image-20220324170011261](img/image-20220324170011261.png)



De commando's die ik heb gebruikt. (kleine sidenote, het lukte niet)

```
airodump-ng -c 5 --bssid 04:F0:21:1C:B4:D5 -w dump wlanMoni

aireplay-ng --fakeauth 6000 -o 1 -q 10 -a 04:F0:21:1C:B4:D5 -e MobanGr15 wlanAttack

aireplay-ng --fakeauth 6000 -o 1 -q 10 -a 04:F0:21:1C:B4:D5 -e MobanGr15 -h 00:0e:8e:6a:f5:b8 wlanAttack

aireplay-ng -3 -b 04:F0:21:1C:B4:D5 -h 00:0e:8e:6a:f5:b8 wlanAttack

aireplay-ng --deauth 5 -a 04:F0:21:1C:B4:D5 -c 00:0e:8e:6a:f5:b8 wlanAttack
```



9. Now that the home user’s traffic is encrypted, can you still apply the deauthentication command on the attacker’s machine ? Why (not)? (hint: examine the deauthentication message within dump-xx.cap file)

```
Deauth frames aren't encrypted in WEP.
```



10. Why does disassociating the home user speeds up the WEP cracking process?

```
This forces the user to reassociate with the AP, creating an ARP request. We'll resend this to the AP. This gives us more packets with the same encrypted content to try and crack. (denk ik)
```



11. How long does it take to crack the WEP key? 


```
A few minutes
```



11. Both the client and the AP know the 40-bit WEP key, but how does the client know the 24-bit Initialization Vector (IV) to decrypt a packet? (hint: examine the dump-xx.cap file)

```
ik ga naar huis sorry het is tijd
```



# Network Management



![image-20220330164839056](img/image-20220330164839056.png)





## Deel I

Vul de volgende tabel aan m.b.t. de informatie horend bij verschillende routers.

| Node | Informatie                     | Waarde       | Object id             | Object naam    |
| ---- | ------------------------------ | ------------ | --------------------- | -------------- |
| r1   | contactpersoon                 | root         | .1.3.6.1.2.1.1.4      | sysContact     |
| r1   | locatie                        | cnet2 labo   | .1.3.6.1.2.1.1.6      | sysLocation    |
| r2   | next hop voor de default route | 192.168.0.42 | .1.3.6.1.2.1.4.21.1.7 | ipRouteNextHop |
| igw  | aantal interfaces              | 3            | .1.3.6.1.2.1.2.1.0    | ifNumber       |
| igw  | hoeveelheid RAM geheugen       | 2040900      | .1.3.6.1.2.1.25.2.2   | hrMemorySize   |

.1.3.6.1.2.1.4.21.1.13

.1.3.6.1.2.1.4.21

Hoe kun je in drie command line instructies vanop de NMS node een goed overzicht krijgen van de routingtabellen van r1, r2 en IGW?

1. ```
   nms snmpwalk 192.168.0.38 ipRouteTable
   ```

2. ```
   nms snmpwalk 192.168.0.37 ipRouteTable
   ```

3. ```
   nms snmpwalk 192.168.0.41 ipRouteTable
   ```

   

Hoe kun je makkelijk filteren op SNMP netwerkverkeer in Wireshark zonder "snmp" in te geven in het filterveld?

```
udp.port == 161 or udp.port == 162
```

Wat is het eerste SNMP bericht die hiervoor werd uitgestuurd (type + parameters)?

```
ifIndex: 1
```

Wat is het laatste SNMP bericht die hiervoor werd uitgestuurd (type + parameters)?

```
atIfIndex: 2
```

Hoeveel SNMP pakketten zijn er voor deze zoekopdracht in totaal uitgewisseld?

```
134
```

Waarom werden er precies zoveel pakketten uitgewisseld?

```
omdat we de hele subtree hebben opgehaald
```



## Deel II

Hoe controleer je op de bijhorende host of de webserver is gestart en luistert op de gebruikelijke poort 80 (TIP: introductieles)?

Voer dit uit op de NMS node en toon via de output van wget -q -O- http://192.168.0.5 aan dat de correcte webpagina wordt weergegeven.

> Sorry ik kreeg die lighttpd niet aan de praat



Geef in onderstaande vak de aangepaste inventory-file:

```yml
192.168.0.42 hostname=igw
192.168.0.37 hostname=r1
192.168.0.41 hostname=r2
192.168.0.45 hostname=nms
# ik denk dat die hierboven er eigenlijk niet in moeten staan

192.168.0.5 hostname=h1
192.168.0.6 hostname=h2
192.168.0.7 hostname=h3
192.168.0.8 hostname=h4
192.168.0.21 hostname=h5
192.168.0.22 hostname=h6
192.168.0.23 hostname=h7
192.168.0.24 hostname=h8
```



Geef in onderstaande vak de configuratie-template voor lighttpd:

```yml
server.document-root = "/student/labo6/generated" # folder with static html files
index-file.names = ( "index-{{ hostname }}.html" ) # main file
server.port = 80 # default TCP port
mimetype.assign = (
 ".html" => "text/html",
 ".txt" => "text/plain",
 ".jpg" => "image/jpeg",
 ".png" => "image/png"
)
server.modules = ( "mod_status" ) # page for statistics
status.status-url="/server-status" # todo
```



flex

<img src="img/image-20220330190758094.png" alt="image-20220330190758094" style="zoom:50%;" />



## Deel III

> Ik heb effe geen zin meer sorry

Welke OID wordt gebruikt voor het gegeven extra object?

```

```



Hoe zien configuratiebestand(en) en playbooks er uit voor dit doel?

