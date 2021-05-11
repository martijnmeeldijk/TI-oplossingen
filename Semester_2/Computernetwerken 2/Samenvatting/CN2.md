Page | **47**

# Hoofdstuk 2

# 2.1 Principes van netwerkapplicaties

## 2.1.1 Structuren van netwerkapplicaties


### **Client-server structuur**

- Host altijd-aan (server) &amp; handelt verzoeken van andere hosts (clients) af
- Meestal datacenters &rarr; anders overbelasting

### **P2P-structuur**

- Infrastructuurservers die altijd aan zijn &rarr; minimaal of afwezig
- Maakt gebruik van rechtstreekse communicatie &rarr; periodiek met elkaar verbonden hosts &rarr; peers
- Zelfschaalbaarheid &amp; goedkoper

![](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwiki.cas.mcmaster.ca%2Fimages%2Fthumb%2F3%2F35%2FPeer_to_peer.gif%2F250px-Peer_to_peer.gif&f=1&nofb=1)

## 2.1.2 Communicerende processen

- Processen in 2 verschillende hosts &rarr; communiceren met elkaar door berichten uit te wisselen &rarr; verzendend proces creëert &amp; verzendt berichten over netwerk &rarr; ontvangend proces ontvangt berichten en verzendt eventueel antwoordbericht

### Client – en serverprocessen

- Voor elk paar comunnicerende processen &rarr; 1 van de 2 processen **client** &amp; andere **server**
- Definitie client- en serverprocessen:
  - In context van een communicatiesessie tussen 2 processen noemen we het proces dat de communicatie initieert de **client**. Het wachtende proces noemen we de server
- In P2P kan een proces ophalen en beschikbaar stellen

### Interface tussen proces en computernetwerk

- Proces verzendt berichten naar en ontvangt berichten van het netwerk via een netwerkinterface &rarr;**socket AKA API ( Application Programming Interface)**

- Socket = soort deur &rarr; proces bericht naar ander proces sturen &rarr; bericht door deur (socket) naar buiten &rarr; verzendende proces neemt aan &rarr; andere kant deur &rarr; infrastructuur aanwezig is waarmee bericht &rarr; bij deur van huis van bestemming zal bezorgd worden &rarr; zodra bericht arriveert bij ontvangende host &rarr; passeert het de toegangsdeur van ontvangende proces &rarr; waarna ontvangende proces bericht verwerkt

### Adresseren van processen

- Om ontvangende proces te kennen moet het 2 gegevens bevatten:
  - Het adres van de host
  - Unieke aanduiding van ontvangende proces in ontvangende host


## 2.1.3 Transportdiensten voor applicaties

| **Data Integriteit:**
- Transportlaagprotocol &rarr; mogelijk een betrouwbare gegevensoverdracht tussen processen aan applicatie leveren &rarr; verzendend proces gegevens in socket duwen &amp; is zeker van geen fouten
- Als er geen betrouwbare gegevensoverdracht is &rarr; mogelijkheid dat deel gegevens niet aankomen bij ontvangend proces &rarr;**verliestolerante apps (**Skype,...)
 | **Doorvoer**
- Sommige apps (bijv. multimedia) vereisen een minimale verwerkingscapaciteit om &quot;effectief&quot; te zijn = **bandbreedtegevoelige apps**  **&rarr;** stellen eisen aan doorvoercapaciteit

- Elastische apps gebruiken de doorvoercapaciteit die op het moment beschikbaar is

**Timing:**
- Sommige apps (bijv. internettelefonie, interactieve games) hebben een korte vertraging nodig om &#39;effectief&#39; te zijn
**Security**
- Encryptie, data integriteit,...

### Diensten van TCP &amp; UDP
 ![](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fqk0qaqfa5xm21.jpg&f=1&nofb=1)

### Beveiligen van TCP

TCP gebruikt SSL/TLS &rarr; TCP met SSL/TLS &rarr; doet niet alleen wat oorspronkelijke TCP doet &rarr; levert ook beveiliginsdiensten voor communicerende processen &rarr; SSL niet een 3e transportprotocol voor internet is dat op zelfde niveau werkt als UDP &amp; TCP &rarr; uitbreiding van TCP &rarr; uitbreidingen geimplementeerd in applicatielaag

### Diensten die niet geleverd worden door internettransportprotocollen

- Huidig internet presteert goed voor tijdgevoelige apps &rarr; geen garanties voor timing of doorvoercapaciteit
- Internettelefonieapps kan enig verlies verwerken maar wel minimale snelheid eisen om te kunnen werken &rarr; Internettelefonieapps meestal UDP &rarr; grotendeel van firewalls blokkeren UDP &rarr; ontworpen voor TCP &rarr; als back-up communicatie via UDP niet lukt

![](RackMultipart20210428-4-1qa6j26_html_5c553c39278d388d.png)

## 2.1.5 Protocollen voor applicatielaag

In applicatielaag volgende aspecten gedefinieerd:

- Soorten berichten die uitgewisseld worden, request &amp; antwoordberichten
- Syntaxis van verschillende soorten berichten, velden in bericht &amp; manier waarop velden van elkaar gescheiden worden
- Semantiek van velden &rarr; betekenis informatie in velden
- Regels voor bepalen wanneer en hoe proces berichten verzendt &amp; beantwoordt

## 2.1.6 Netwerkapplicaties die in dit boek beschreven worden

# 2.2 Web &amp; HTTP

## 2.2.1 Meer over HTTP

![](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.cellbiol.com%2Fbioinformatics_web_development%2Fwp-content%2Fuploads%2F2017%2F01%2Furl_anatomy.png&f=1&nofb=1)

- Webpagina bestaat uit aantal objecten &rarr; object is een bestand
- HTTP definieert hoe webclient een webserver verzoekt om een webpagina op te zoeken &amp; hoe servers webpagina&#39;s versturen naar een client
- HTTP &rarr; TCP als transportprotocol
- HTTP-client initieert TCP-verbinding met server &rarr; verbinding tot stand &rarr; processen van browser &amp; server TCP via socketinterfaces &rarr; client verzendt HTTP-verzoekberichten door socket &rarr; server ontvangt op zelfde manier HTTP-verzoekberichten via socket &amp; verzendt HTTP-antwoordberichten door socket

- HTTP is staatloos &rarr; Server houdt geen informatie bij over eerdere clientaanvragen

## 2.2.2 Non-persistente en persistente verbindingen

### Non persistent

Basis HTML-file met volgende url: [http://www.someschool.edu/someDepartment/home.index](http://www.someschool.edu/someDepartment/home.index)

1. HTTP-client starts TCP-verbinding met server &rarr; client &amp; server gebruiken socket
2. HTTP-client verzendt HTTP-verzoekbericht naar HTTP
3. HTTP-serverproces ontvangt verzoekbericht
4. HTTP-serverproces TCP opdracht &rarr; verbreek verbinding als bericht ontvangen
5. HTTP-client ontvangt antwoordbericht
6. Herhaal stap 1-4 voor elk object

RTT &rarr; tijd die packet nodig heeft &rarr; client naar server &amp; omgekeerd

Klikt op een hyperlink &rarr; 3-way handshakeproces nodig:

1. Client verzendt TCP-segment naar server
2. Server bevestigt &amp; antwoord met TCP-segment
3. Client verzendt 2e bevestiging naar server

    &rarr; 1 RTT

- Na 1&amp;2 &rarr; verzendt client HTTP-verzoekbericht + 3e deel van 3way-handshake
- Totale responstijd = 2 RTT&#39;s + transmissietijd HTML-bestand server

### Persistent

- Bij non persistent &rarr; elk opgevraagd object een nieuwe verbinding tot stand gebracht &amp; gehouden worden
- Bij non persistent &rarr; elk object 2 RTT&#39;s vertraging &rarr; 1 voor TCP-verbinding starten &amp; 1 om TCP-verbinding object op te vragen &amp; ontvangen
- HTTP 1.1 persistent &rarr; server laat TCP-verbinding intact na respons

## 2.2.3 Indeling HTTP-berichten

### HTTP-verzoekbericht

- Eerste regel &rarr; requestregels
- Volgende regels &rarr; headerregels
- Host &rarr; host waar opgeslagen object is
- Connection: close &rarr; geen persistente verbinding nodig
- User Agent: &rarr; type browser
- POST &rarr; stuurt velden dat gebruiker heeft ingevuld door
- GET &rarr; 2 velden ( x &amp; y ) &rarr; structuur URL &rarr;[www.eensite.nl/zoekIets?x&amp;y](http://www.eensite.nl/zoekIets?x&amp;y)
- HEAD &rarr; server reageert HTTP-bericht zonder opgevraagde object te verzenden

### HTTP-antwoordbericht

- Statusregel, 6 headerregels &amp; entity body
- Connection: close &rarr; client weet TCP-verbinding weg na bericht verstuurd
- Server: &rarr; geeft aan gegenereerd door Apache-webserver
- Last-Modified: cachen objecten &rarr; lokaal &amp; server
- Content-length: &rarr; grootte object

![](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.researchgate.net%2Fprofile%2FMostafa_Sedighizadeh%2Fpublication%2F242714677%2Ffigure%2Fdownload%2Ffig1%2FAS%3A644655569973249%401530709273718%2FTypical-HTTP-response-and-request-headers.png&f=1&nofb=1)

## 2.2.4 Interactie gebruikers &amp; servers: cookies

1. Cookieheaderregel in HTTP-antwoordbericht
2. Cookieheaderregel in HTTP-verzoekbericht
3. Cookiebestand opgeslagen op host gebruiker &amp; browser van gebruiker beheerd
4. Back-enddatabase op website

## 2.2.5 Webcaching

Netwerkentiteit die HTTP-verzoeken afhandelt names oorspronkelijke webserver waar verzoek oorspronkelijk naartoe is gestuurd

Browser object [http://www.someschool.edu/campus.gif](http://www.someschool.edu/campus.gif)

1. Browser start TCP-verbinding met webcache &amp; verzendt HTTP-verzoek voor object naar webcache
2. Webcache checks &rarr; exemplaar opgevraagde object aanwezig? &rarr; if yes &rarr; webcache verzendt object in HTTP-antwoordbericht naar browser client
3. Opgevraagde object niet op webcache &rarr; TCP-verbinding met oorspronkelijke server &rarr; webcache verzendt HTTP-verzoek voor object via TCP-verbinding &rarr; wanneer server ontvangen &rarr; verzendt object in HTTP-antwoordbericht naar webcache
4. Opslaan kopie lokaal &amp; stuurt een exemplaar naar browser

2 redenen webcaching

- Responstijd clientverzoek verkorten
- Webcaches belasting van link van instituut verlagen

**CDN** (Content Distribution Networks) &rarr; veel geografische verspreide cachegeheugens in internet &rarr; groot deel dataverkeer lokaal

## 2.2.6 The conditional GET

- Verzoekbericht methode GET
- Verzoekbericht bevat If-Modified-Since

1. Client maakt get request
2. Server reageert met header
3. Client checkt de Last-Modified header
4. ls Last nieuwer is dan cache &rarr; haal pagina opnieuw op &amp; zet opnieuw in cache
5. anders &rarr; laad van cache

```
GET /index.html HTTP/1.1\r\n
Host: www-net.cs.umass.edu\r\n
User-Agent: Firefox/3.6.10\r\n
Accept: text/html,application/xhtml+xml\r\n
Accept-Language: en-us,en;q=0.5\r\n
Accept-Encoding: gzip,deflate\r\n
Accept-Charset: ISO-8859-1,utf-8;q=0.7\r\n
Keep-Alive: 115\r\n
Connection: keep-alive\r\n
\r\n
```


### **HTTP/2**

**Goal:** vertraging verlagen in multi-object HTTP requests
**HTTP1.1**** :** meerdere, pipelined GETs over 1 TCP connectie

- Server antwoord in-order ( **FCFS** : **first-come-first-served scheduling** ) naar GET requests
- Met FCFS, mogelijkheid dat kleine objects moeten wachten voor transmissie (Head-of-line (HOL) blocking) achter grote objects
- Herstel van loss (retransmissie van verloren TCP segmenten) stalls object transmissie

**HTTP/2**** :** flexibiliteit verhogen server in versturen van objects naar client
 **Goal:** vertraging verlagen in multi-object HTTP requests

- Methoden, status codes, meeste header velden onveranderd tov HTTP 1.1
- verzendvolgorde van aangevraagde objecten op basis van door de klant opgegeven objectprioriteit (Niet noodzakelijk FCFS)
- Push unrequested objects naar cleint
- Verdeel objects in frames, plan frames om HOL-blokkering te verminderen

![HOL-BLOCKING HTTP 1.1 & HTTP 2](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmiro.medium.com%2Fmax%2F1640%2F0*nhI-5imZWT2G7Flz&f=1&nofb=1)


### **HTTP/2 to HTTP/3**

**Goal:** vertraging verlagen in multi-object HTTP requests

HTTP/2 over single TCP connectie wil zeggen:

- Herstel packet loss vertraagt nog steeds alle objecttransmissies

- In HTTP 1.1 browsers &rarr; stimulans om meerdere TCP-verbindingen te openen &rarr; vertraging verminderen &rarr; algehele doorvoer te verhogen

- Geen security over vanilla TCP-verbinding
- HTTP/3 &rarr; adds security &rarr; per object fout- &amp; congestie-controle ( meer pipelining) over UDP

# 2.3 E-mail op het internet

## 2.3.1 SMTP

Werking:

1. Alice &rarr; UA opdracht verstuur bericht
2. Alice&#39;s UA stuurt bericht mailserver&rarr; in berichtenwachtrij
3. Clientzijde van SMTP opent TCP-verbinding met Bob&#39;s e-mailserver
4. SMTP-client verzendt het bericht van Alice via de TCP-verbinding
5. Bob&#39;s mailserver plaatst het bericht in Bob&#39;s mailbox
6. Bob roept zijn user agent aan om bericht te lezen

![](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.afternerd.com%2Fblog%2Fwp-content%2Fuploads%2F2017%2F11%2Fsmtp-message-flow.png&f=1&nofb=1) 

## 2.3.2 Vergelijking met HTTP

### SMTP

- Transfers files van 1 mail server naar een andere mail server
- **PUSH** protocol: verzendende e-mailserver duwt bestand naar e-mailserver van ontvanger
- Elk bericht moet in 7-bit ASCII zijn
- Plaatst alle bericht objecten in 1 bericht

### HTTP

- Transfers files van web server naar web client
- **PULL** protocol: Iemand zet informatie op een webserver &amp; gebruiker gebruikt HTTP om informatie van server ophalen wanneer het hem uitkomt
- Restrictie niet nodig
- Encapsuleert elk object in zijn eigen HTTP response message 

## 2.3.3 Formats e-mailberichten

## 2.3.4 Mail accessprotocollen

SMTP: levering/opslag van e-mailberichten op de server van de ontvanger

Mail Access Protocol: Ophalen server

IMAP: **Internet Mail Access Protocol** [RFC 3501]: berichten opgeslagen op de server, IMAP biedt ophalen, verwijderen, mappen met opgeslagen berichten op de server

HTTP: Gmail, Hotmail, Yahoo! Mail, etc. biedt webgebaseerde interface bovenop STMP (om te verzenden), IMAP (of POP) om e-mailberichten op te halen

### POP3

UA &rarr; TCP-verbinding naar mailserver

1. Autorisatiefase: UA &rarr; verstuurt username &amp; password &rarr; identitetit gebruiker vaststellen
2. Transactiefase: UA haalt berichten op
3. Updatefase: client opdracht quit &rarr; POP3-sessie closed

### IMAP

- Koppelt elk bericht aan een map
- Biedt opdrachten &rarr; UA afzonderlijke componenten van bericht

### Webmail

Ontvanger wil mailbox bekijken &rarr; bericht van mailserver naar browser van gebruiker verzonden &rarr; behulp van HTTP-protocol

# 2.4 DNS

## 2.4.1 Diensten van DNS

- Een gedistribueerde database &rarr; geïmplementeerd in hiërarchie van DNS-servers
- Applicatielaagprotocol waarmee hosts &amp; DNS-servers kunnen communiceren om vertaalslag ( omzetten IP &rarr; &quot;te onthouden&quot; adres &amp; omgekeerd)

DNS verzorgt aantal andere diensten naast vertalen hostnamen in IP-adressen:

- **Host-aliasing:** 1 of meerdere aliassen wanneer hostname te lastig is &rarr; canonieke hostnaam &rarr; aliashostnamen gebruikt &rarr; gemakkelijker te onthouden dan canonieke hostnamen
- **Mailserver-aliasing:** Hostnaam van een mailserver (bv. Yahoo) &rarr; moeilijker dan &rarr; eenvoudige Yahoo.com &rarr; DNS kan door mailapplicatie gebruikt worden &rarr; achterhalen canonieke hostnaam v/e bepaalde host + IP-adres van host &rarr; MX record maakt mogelijk dat mailserver &amp; webserver van bedrijf dezelfde hostnamen hebben &rarr; mailserver &amp; webserver van bedrijf kunnen dus bv. enterprise.com heten.

(Een MX-record (Mail eXchange-record) is een gegevenstype in het Domain Name System (DNS). Het specificeert de mail server die e-mailverkeer voor het betreffende domein afhandelt. Een domein kan meerdere MX-records hebben met een verschillende prioriteit waardoor het mogelijk is om bijvoorbeeld een back-up mailserver aan te geven als de computer met de hogere prioriteit niet bereikbaar blijkt. De naam die in het MX-record wordt gevonden kan via DNS op zijn beurt in een ip-adres worden vertaald. Src: Wikipedia)

- **Loadbalancing:** Belasting van gerepliceerde servers te verminderen &rarr; gerepliceerde webservers een serie IP-adressen gekoppeld aan canonieke hostname &rarr; DNS-database bevat serie IP-adressen

## 2.4.2 Overzicht van de werking van het DNS

Gecentraliseerd ontwerp levert volgende problemen op:

- **Single point of failure:** als DNS crashed hele internetonbruikbaar
- **Netwerkbelasting** : 1 DNS-server &rarr; alle DNS-verzoekberichten verwerken ( alle HTTP-verzoekberichten &amp; e-mails van honderden miljoenen hosts)
- **Afstand tot gecentraliseerde database** : 1 enkele DNS-server kan niet &#39;in de buurt&#39; van alle verzoekende clients staan &rarr; centrale DNS bijvoorbeeld in Antwerpen &rarr; verzoeken uit Nieuw-Zeeland &rarr; kan vertraging veroorzaken
- **Onderhoud** : die DNS-server informatie over alle internethosts moeten beheren &rarr; database wordt dan heel groot &amp; telkens bijgewerkt moeten worden wanneer nieuwe host wordt aangemeld.

### Een gedistribueerde, hiërarchische database

- **Root-DNS-servers:** meer dan 400 root-nameservers verspreid over de wereld &rarr; door 13 verschillende organisaties gemanaged &rarr; leveren IP adressen van TLD-servers
- **Topleveldomein (TLD) -servers:** voor elk TLD (com,org,net,edu,...) &amp; landTLD(nl,fr,ca,...) &rarr; is er een TLD &rarr; TLD leveren IP-adressen voor authoritative DNS-servers
- **Authoritative DNS-servers:** eigen DNS-server(s) van de organisatie, die gezaghebbende hostnaam biedt aan IP-toewijzingen voor de benoemde hosts van de organisatie + kan Dutch translation. kakjkworden onderhouden door organisatie of dienstverlener
- Lokale DNS-server behoort niet tot hiërarchie maar wel belangrijk voor DNS-structuur &rarr; elke ISP zoals een standaard ISP of ISP van instituut &rarr; lokale DNS-server &rarr; wanneer host verbinding tot stand wil brengen met ISP &rarr; ISP geeft aan die host IP-adressen van 1 of meer van diens lokale DNS-server &rarr; lokale DNS-server niet ver weg van host &rarr; bij residentiële ISP DNS-server &rarr; gescheiden enkele routers van host van client &rarr; host verzoekbericht aan DNS verzendt &rarr; doorgestuurd lokale DNS-server &rarr; fungeert als proxy &rarr; verzoek verder gestuurd in DNS-serverhiërarchie
- Recursief DNS-verzoek = host stuurt verzoek aan lokale DNS-server, die op zijn beurt een verzoek doet aan de root-server, die op zijn beurt een verzoek doet aan de TLD-server … (zie p127)
- Iteratief DNS-verzoek = host stuurt verzoek aan lokale DNS-server, die op zijn beurt een verzoek doot aan de root-server, de root-server stuurt antwoord naar lokal DNS-server die op haar beurt een verzoek doet aan de TLD-server… (zie p126)

### DNS-caching

DNS-server &rarr; in verzoekberichtenketen &rarr; wanneer DNS-antwoord ontvangt &rarr; verwijzing in lokale cachegeheugen plaatsen

## 2.4.3 DNS-records en -berichten

DNS-servers bevatten bronrecords &rarr; (Naam, Waarde, Type, TTL)

1. **If Type = A** then naam bevat hostnaam en Waarde bevat IP-adres van hostnaam
2. **If Type = NS** then naam bevat domeinnaam en Waarde bevat hostnaam van authoritative DNS-server die de hostnaam en IP combinaties voor de hosts in dat domein weet
3. **If Type = CNAME** then waarde is canonieke hostname voor aliashostname
4. **IF Type = MX** then waarde is canonieke naam van mailserver met alias hostname name

Een authoritative DNS-server bevat een A-record

Een niet-authoritative DNS-server bevat een NS-record voor het domein waarin de DNS-server zich bevindt en ook een A-record met het IP-adres van de DNS-server die in het veld Waarde van het NS-record staat

### DNS-berichten

- Eerste 12 bytes voor de header:

1. Eerste veld is een uniek 16 bit getal waarmee het verzoek geïdentificeerd kan worden. Dat getal word gekopieerd in het antwoordbericht, zodat de client het antwoord en het verzoek kan kopellen
2. Vlaggen veld bevat een aantal vlaggen. Een 1-bit verzoek/antwoord-vlag (verzoek = 1 en antwoord = 0), 1-bit authoritative-vlag wordt in een antwoordbericht gezet als de DNS-server de authoritative DNS-server voor de hostnaam is, 1-bit recursienoodzaak-vlag wordt gebruikt als de client vraagt om recursief te werken als het gevraagde record niet op die DNS-server staat en een 1-bit recursiemogelijkheids-vlag die in het antwoordbericht staat na een verzoekbericht met een recursienoodzaak-vlag

- Vraagveld bevat informatie over het verzonden verzoek:

1. Bevat een naamveld met de naam waarvoor het IP-adres wordt gezocht
2. Bevat een typeveld met het type verzoek (Type A, Type NS…)

- In een antwoordbericht staat in het antwoordveld de bronrecords van het oorspronkelijke DNS-verzoek
- Het autorisatieveld bevat gegevens van andere authoritative DNS-servers
- Het aanvullingsveld bevat aanvullende bronrecords (Het antwoordveld in een antwoord op een MX-verzoek bevat een bronrecord met de canonieke hostnaam van de mailserver en het aanvullingsveld bevat het een Type A record met het IP-adres van de canonieke hostnaam van de mailserver

###

### DNS-Security

**DDOS-attack:**

- root servers belasten met verkeer
- Tot op heden niet succesvol
- Verkeersfiltering
- Lokale DNS-servers cache-IP&#39;s van TLD-servers waardoor rootserver bypassed

**TLD servers bombarderen:**

- Kan gevaarlijker zijn maar moeilijker &rarr; TLD servers niet zo gemakkelijk bypassed

**Aanvallen omleiden**

- Man in the middle &rarr; DNS queries intercepten
- DNS poisoning &rarr; valse afhankelijkheden verzenden naar dns-server, die cachen

**DNS voor DdoS exploiteren**

- Queries versturen met vervalste bronadres &rarr; target IP
- Vereist versterking

**Laatste 2 vormen DNSSEC**

# 2.5 Peer-to-peer bestandsdistributie

### P2P file distributie: BitTorrent

Peer neemt deel aan torrent &rarr; meldt bij tracker &rarr; peer informeert tracker met regelmaat of nog aanwezig in torrent &rarr; nieuwe peer &rarr; tracker random # peers &rarr; verzendt IP-adressen van # peers &rarr; naar nieuwe peer &rarr; proberen TCP-verbinding met peers op lijst &rarr; bepaald tijdstip &rarr; elke peer &rarr; # chunks bestand &rarr; verschillende peers &rarr; verschillende verzamelingen chunks hebben &rarr; na een bepaalde tijd &rarr; gebruiker vraagt elke peer om lijst met chunks die ze hebben &rarr; gebruiker vraagt de &quot;missing chunks&quot; van de peerst &rarr; zeldzaamste eerst of **Rarest first**

### Tit-for-tat principe:

Gebruiker stuurt chunks naar die vier peers die momenteel haar chunks in het hoogste tempo verzenden &rarr; andere peers gestikt door gebruiker (ontvangen geen chunks van gebruiker) &rarr; herbeoordeeld top 4 elke 10 seconden

Elke 30 seconden &rarr; selecteert willekeurig een andere peers, begint met verzenden van chunks &rarr; optimistisch unchocked deze peer &rarr; nieuwe gekozen peer kan lid worden van top 4

# 2.6 Videostreaming en content distribution networks

## Internetvideo

- Video &rarr; sequentie van afbeeldingen &rarr; afgebeeld constante snelheid
 Bijvoorbeeld: 24 afbeeldingen / seconde


- Digital image &rarr; array van pixels
 Elke pixel gerepresenteerd door bits

- Coding: Gebruikt redundantie binnen en tussen afbeeldingen om # bits te verminderen die worden gebruikt om abeeldingen te gebruiken
 Spatial &rarr; binnen afbeelding
 Temporal &rarr; van 1 afbeelding naar volgende

- CBR &rarr; constant bit rate &rarr; video encoding rate is fixed
- VBR &rarr; variable bit rate &rarr; wijzigingen in videocoderingssnelheid als hoeveelheid spatial, temporal codering wijzigt

## 2.6.1.1 Streaming stored video

**Simpel Scenario:**

**Hoofddoelen:**

- Server to client bandbreedte varieert over tijd met veranderende netwerkcongestieniveaus &rarr; ( in huis, in acces network, network core, video server)

- pakketverlies en vertraging als gevolg van congestie zullen de play-out vertragen of resulteren in een slechte videokwaliteit

## 2.6.1.2 Streaming stored video : challenges

Continuous playout constraint &rarr; zodra play-out van client begint &rarr; afspelen overeenkomen met oorspronkelijke timing &rarr; **maar** network delays variabel (jitter) &rarr; heeft buffer aan clientzijde nodig om aan play-out vereisten te voldoen

Andere challenges

Client interactiviteit &rarr; pause, voortspoelen, terugspelen, verder in video gaan &rarr; video packets loss mogelijk &rarr; opnieuw verzonden

## HTTP-streaming en DASH

**D** ynamic **A** daptive **S** treaming over **H** TTP

- Server
  - Deelt video bestand in meerdere chunks
  - Elke chunk stored, gecodeerd met verschillende snelheden
  - **Manifestbestand** : biedt URL&#39;s voor verschillende chunks
- Client
  - Meet periodiek server-naar-client bandbreedte
  - Adviesmanifest, vraagt 1 chunk tegelijk
    - Kiest voor max coderingssnelheid duurzaam gezien huidige bandbreedte
    - Kan verschillende coding rates kiezen op verschillende punten in tijd &rarr; afhankelijk vrije bandbreedte

STREAMING VIDEO = CODERING + DASH + PLAYOUT BUFFERING

## Content Distribution Networks (CDNs)

Challenge: Hoe content streamen naar 100 tot 1000&#39;en gebruikers tegelijk

- **Optie 1: 1 grote server**
  - Single point of failuire
  - Punt van netwerkcongestie
  - Lange weg naar clients die verweg zijn
  - meerdere kopieën van video verzonden via uitgaande link

- Deze oplossing **schaalt niet**

- Optie 2: meerdere kopieën van video&#39;s opslaan/weergeven op meerdere geografisch gedistribueerde sites &rarr;**(CDN)**
  - Enter deep &rarr; push CDN servers diep in veel access networks &rarr; dichtbij users
    - Bijvoorbeeld: Akamai &rarr; 240k in meer dan 120 landen
  - Bring home: kleinere nummers (10&#39;s) of grotere clusters in POP&#39;s dichtbij access netwerken
- CDN &rarr; slaagt kopieen van content op aan CDN nodes
- Subscriber vraagt content van CDN &rarr; gericht nabijgelegen kopie &amp; haalt inhoud op
- kan een andere kopie kiezen als het netwerkpad overbelast is

# Hoofdstuk 8: Security in computer networks

## 8.1 Wat is netwerkbeveiliging

1. **Vertrouwelijkheid** : Alleen zender &amp; beoogde ontvanger inhoud van verzonden bericht begrijpen
2. **Berichtintegriteit** : de afzender en ontvanger zeker zijn dat inhoud van communicatie niet wordt gewijzigd
3. **Authenticatie op eindpunt:** zender &amp; ontvanger identiteit andere partij vaststellen zeker te zijn dat ander is wie hij beweert
4. **Operationele beveiliging:** bijna alle organisaties hebben netwerken aangesloten op het openbare internet.Deze netwerken kunnen daarom mogelijk worden aangetast.

## 8.2 Principes van cryptografie

**Verzender ( X )** verstuurt bericht naar **ontvanger (Y)**

1. X gebruikt sleutel **K**** A**&rarr; invoer versleutelalgoritme
2. Versleutelalgoritme gebruikt sleutel &rarr; onversleutelde bericht m &rarr; versleutelde tekst &rarr; **K**** A****(m)**
3. KA onderling afspreken
4. Y ook sleutel **K**** B **** &rarr;**invoer onsleutelalgoritme &rarr; versleutelde bericht X &rarr; plaintext
5. Y ontvangen versleutelde bericht KA(m) &rarr; ontsleutelen &rarr; berekenen van Kb(Ka(m)) = m

- Symmetrische sleutelsystemen &rarr; sleutels X &amp; Y identiek en geheim
- Openbare sleutelsystemen &rarr; 2 verschillende sleutels &rarr; 1 v/d 2 zowel bij X als Y bekend

## 8.2.1 Cryptografie met symmetrische sleutels

1. **First** &rarr; Caeser cipher &rarr; elke letter in platte tekst &rarr; letter &rarr; k-letters in alfabet te vervangen
2. **Daarna** &rarr; monoalfabetisch cijfer &rarr; lettervervanging maar moet uniek zijn

**Bruteforce-benadering**&rarr; uitproberen alle 10^26 &rarr; teveel werk

- **Aanval met alleen versleutelde tekst** &rarr; indringer beschikt alleen over onderschepte versleutelde tekst &rarr; niet over informatie van inhoud &rarr; onversleutelde bericht
- **Aanval met bekende onversleutelde tekst** &rarr;**Indringer (Z)**&rarr; kent enkele combinaties van onversleutelde &amp; versleutelde tekst
- **Aanval met specifieke onversleutelde tekst**  **&rarr;** Z kiest onversleuteld bericht &rarr; corresponderende versleutelde tekst krijgen &rarr; als Z &rarr; X een bepaalde zin kan laten verzenden &rarr; versleutelmethode verbroken

**Polyalfabetische codering** &rarr; verschillende monoalfabetische ciphers gebruikt &rarr; afwisselend ingezet &rarr; bepaalde positie in onversleutelde bericht te versleutelen

### Block ciphers (DES = data encryption standard, 3DES, AES= advanced encryption standard)

**2 categorieën** van symmetrische versleuteltechnieken

- Stream cipher
- Block cipher

**Blockciphers**

1. versleutelen bericht &rarr; verwerkt blokken k bits
2. **IF** k = 64 &rarr; bericht opgesplitst in 64 blokken &rarr; elk blok onafhankelijk versleuteld
3. Codering 1 op 1 toewijzing om k-bit blok cleartext toe te wijzen aan k-bit blok Ciphertext

**Hoeveel mogelijke verwijzingen?**

- k = 3 dan zijn er 23 mogelijke ingangen. Deze ingangen kunnen in 8 worden gepermuteerd! = 40 320.

Zeer moeilijk uit te voeren. Voor k = 64 moeten Alice en Bob een tabel onderhouden met 2^64 invoerwaarden &rarr; onmogelijk &rarr; blokcoderingen meestal functies die willekeurig gepermuteerde tabellen simuleren.

### Cipher-block chaining (CBC)

Blockcipher &rarr; twee of meer blokken identiek zijn&rarr;aanvaller mogelijk **cleartext raden** en misschien het hele bericht decoderen. &rarr; solution &rarr; willekeur in ciphertext

**Werkwijze:**

1. voor bericht versleutelt &rarr; genereert Afzender **een willekeurige k-bit string,initialisatievector (IV) = c(0)** genoemd&rarr; afzender stuurt IV naar ontvanger in leesbare vorm
2. Eerste blok berekent de afzender **m(1) + c(0) &rarr; exclusieve OR van eerste blok onversleutelde tekst &amp; IV. &rarr; verzender verwerkt met BC &rarr; bijhorende blok als versleutelde tekst c(1)=Ks(m(1)+c(0)** &rarr; verzender versleutelde blok (c1) naar ontvanger
3. Voor het i-blok genereert de afzender **c(i) = Ks(m(i) + c(i-1))**

## 8.2.2 Cryptografie met openbare sleutel

- 2 partijen delen gedeeld geheim &rarr;Symmetrische sleutel voor encryptie &amp; decryptie

### Diffie-Hellman key exchange

1. Alice haalt Bob&#39;s publieke sleutel
2. Alice versleutelt bericht (m) aan Bob &rarr; door public key van Bob en bekend encryptie-algoritme K+B(m).
3. Bob ontvangt &rarr; gecodeerde bericht van Alice &rarr; gebruikt private key &amp; bekend decoderingsalgoritme &rarr; gecodeerde bericht decoderen
4. Bob berekent K-B( K+B(m)).
5. Berekenen van Kb-(Kb+(m)) resulteert in m

**Note :** each party generates a public/private key pair and distributes the public key. After obtaining an authentic copy of each other&#39;s public keys, Alice and Bob can compute a shared secret offline. The shared secret can be used, for instance, as the key for a [symmetric cipher](https://en.wikipedia.org/wiki/Symmetric-key_algorithm).

![](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Public_key_shared_secret.svg/250px-Public_key_shared_secret.svg.png)

### RSA

**Maken van publieke en private RSA keys:**

1. Kies 2 grote priemgetallen p &amp; q &rarr; hoe groter de waarden hoe moeilijker RSA-algoritme te kraken
2. Bereken n = p \* q
3. Bereken z = (p – 1) \* (q-1)
4. Kies nummer e, dat kleiner is dan n &amp; geen factoren (buiten 1 ) gemeenschappelijk heeft met z
5. Zoek een getal d, zodanig dat ed – 1 precies deelbaar is door z. Wij kiezen d zodanig dat e\*d mod z = 1
6. Openbare sleutel (K+B) is het paar van de getallen (n, e)
7. The private key(K-B) is the pair of the numbers (n, d)

- Encrypteren &rarr; C = me mod n
- Decrypteren &rarr; m = cd mod n. Which requires the use of the private key (n, d)

**NOTE:** Diffie-Hellman niet zo veelzijdig als RSA omdat het niet gebruikt kan worden om berichten met willekeurige lengte te coderen &rarr; toegepast om symmetrische sessiesleutel tot stand te brengen &rarr; daarna coderen berichten

## Berichtintegriteit en digitale handtekeningen

## 8.3.1 Cryptografische hashfuncties

- Rekentechnisch onmogelijk &rarr; 2 verschillende berichten x en y te vinden &rarr; waarbij

H(x) = H(Y)

- Onmogelijk voor indringer &rarr; bericht vervangen door ander bericht dat beveiligd is met hashfunctie
- **Om veiligheidsredenen** hebben we een krachtigere hash-functie nodig dan een checksum &rarr; het **MD5-hash-algoritme.** Het berekent een 128-bits hash in een proces in **vier stappen** dat bestaat uit:
  - een opvulstap
  - een toevoegstap
  - een initialisatie van een accumulator
  - een laatste loopingstap waarin de blokken van 16 woorden van het bericht in vier rondes worden verwerkt
- Het tweede belangrijke hash-algoritme is het **Secure Hash Algorithm (SHA1).** Het produceert een 160-bits berichtcijfer. De langste output maakt SHA1 veiliger.

## 8.3.2 Berichtauthenticatiecode

berichtintegriteit uit te voeren&rarr;Alice en Bob&rarr; naast gebruik van cryptografische hashfuncties, &rarr; gedeeld geheim nodig&rarr;niets meer dan een reeks bits = verificatiesleutel.&rarr; door gedeelde geheim kan berichtintegriteit als volgt worden uitgevoerd:

- Alice maakt bericht m, samenvoegt s met m om m + s te maken en berekent de hash (m+s). &rarr; berichtverificatiecode (MAC = **Message Authentication Code** )
- Alice voegt vervolgens de MAC toe aan het bericht m, maakt een uitgebreid bericht (m, H(m+s)) en stuurt het naar Bob
- Bob ontvangt het bericht (m, h) en weet s, berekent de MAC H(m+s). Als H(m+s) = h, dan is alles in orde met de boodschap

## 8.3.3 Digitale handtekeningen

### Certificering van openbare sleutels

Certificate authority &rarr; echtheid identiteiten authenticeert &amp; certificaten uitgeeft

1. Een certification authority controleert of een entiteit is wie het zegt dat het is.

2. certificeringsinstantie identiteit van entiteit verifieert, maakt certificeringsinstantie een certificaat &rarr; openbare sleutel van de entiteit aan de identiteit bindt &rarr; certificaat bevat openbare sleutel + wereldwijd unieke identificerende informatie over eigenaar van openbare sleutel. Het certificaat digitaal ondertekend door certification authority.

## Authenticatie op het eindpunt

Eindpuntverificatie &rarr;proces waarbij de ene entiteit zijn identiteit aan een andere entiteit bewijst via een computernetwerk.

## 8.4.1 Authenticatieprotocol ap1.0

Trudy (indringer) stuurt bericht naar Bob &rarr; zegt &quot;ik ben Alice&quot; &rarr; Bob weet niet of het werkelijk Alice is
8.4.2 Authenticatieprotocol ap2.0
Alice bekend netwerkadres waaruit ze altijd communiceert&rarr; Bob proberen Alice te verifiëren &rarr; bronadres IP-datagram met verificatiebericht overeenkomt met het bekende adres van Alice.

niet moeilijk om IP-datagram te maken, zet elk IP-bronadres dat we willen in het IP-datagram.

## 8.4.3 Authenticatieprotocol ap3.0

Het wachtwoord is een gedeeld geheim tussen de authenticator en de persoon die wordt geverifieerd.

- Alice stuurt haar geheime wachtwoord naar Bob.
- De beveiligingsfout hier is dat als Trudy Alice&#39;s communicatie afluistert, ze Alice&#39;s wachtwoord kan leren.

## 8.4.4 Authenticatieprotocol ap3.1

Door het wachtwoord te versleutelen&rarr;voorkomen Trudy Alice&#39;s wachtwoord leert&rarr;aannemen dat Alice en Bob een symmetrische geheime sleutel delen, KA – B,dan kan Alice het wachtwoord versleutelen en haar identificatiebericht en het gecodeerde wachtwoord naar Bob sturen. Bob decodeert vervolgens het wachtwoord en verifieert Alice.

**De fout:**  **the playback attack**  **:** Trudy hoeft alleen maar de communicatie van Alice af te luisteren, de gecodeerde versie van het wachtwoord op te nemen en de gecodeerde versie van het wachtwoord af te spelen naar Bob om te doen alsof ze Alice is.

## 8.4.5 Authenticatieprotocol ap4.0

**Een nonce** is een getal dat een protocol maar één keer in een leven zal gebruiken. Dat wil zeggen dat zodra een protocol een nonce gebruikt, het het nummer nooit meer zal gebruiken. Onze ap4.0 **gebruikt een nonce in als volgt:**

1. Alice verzendt bericht &#39;ik ben Alice&#39; aan Bob
2. Bob kiest een nonce en verzendt die naar Alice
3. Alice versleutelt de nonce met de symmetrische sleutel van Alice en Bob, KA– B,en stuurt de gecodeerde nonce KA_B(R) terug naar Bob.
4. Bob ontsleutelt het ontvangen bericht. Als de gedecodeerde nonce gelijk is aan de nonce die hij Alice stuurt, dan is Alice geauthenticeerd

## 8.5 E-mail beveiligen

### 8.5.1 Ontwerp van veilige e-mail

**Vertrouwelijkheid (Systeem 1)**

- Bericht versleutelen &rarr; symmetrische sleuteltechnologie (DES) &rarr; ontvanger bericht ontsleutelen
- Alternatief &rarr; cryptografie openbare sleutel (RSA)
- Om dit efficiëntieprobleem op te lossen, maken we **gebruik van een sessie**  **key:**
  1. Alice selecteert een willekeurige symmetrische sessiesleutel (Ks)
  2. Versleutelt haar bericht m met de symmetrische sleutel
  3. Versleutelt de symmetrische sleutel met Bob&#39;s openbare sleutel K+b
  4. Voegt het gecodeerde bericht en de gecodeerde symmetrische sleutel samen om een pakket te vormen
  5. stuurt het pakket naar Bob&#39;s e-mailadres. **(zie p 586 onderaan voor schema)**

- Bob ontvangt pakket:

1. Gebruikt geheime sleutel Kb-&rarr; verkrijgen symmetrische sleutem Ks
2. Symmetrische sleutel Ks &rarr; ontsleutelen bericht

**Sessie key = inefficient**

**1. Berichtintegriteit**

- Digitale handtekeningen:

  1. Alice past hashfunctie H toe
  2. Versleutelt resultaat met hashfunctie &rarr; met geheime sleutel KA- &rarr; digitale handtekening
  3. Oorspronkelijke bericht samen met handtekening &rarr; 1 pakket
  4. Verzend pakket &rarr; e-mail Bob

- Bob ontvangt het pakket
  1. Openbare sleutel Alice KA+ &rarr; op ondertekende hash
  2. Vergelijkt resultaat bewerking met eigen hash H van bericht

**The 2 combined:**

- Alice maakt eerst een voorlopig pakket, dat bestaat uit haar originele bericht samen met een digitaal ondertekende hash van het bericht
- Vervolgens behandelt ze dit voorlopige pakket als een bericht op zich en stuurt dit nieuwe bericht via **de stappen van de afzender van (a)**, waardoor een nieuw pakket wordt gemaakt dat naar Bob wordtverzonden **(zie schema p**  **586**** )**

## 8.5.2 PGP

PGP-software gebruikt:

- MD5 of SHA &rarr; berekenen hash
- CAST, Triple-DES of IDEA &rarr; versleutelen symmetrische sleutel
- RSA versleuteling openbare sleutel

Als PGP installed:

1. Openbaar sleutelpaar voor gebruiker
2. Openbare sleutel &rarr; website gebruiker of openbare sleutelserver

- Persoonlijke sleutel beschermd &rarr; wachtwoord

PGP &rarr; mogelijkheid bericht digitaal ondertekenen

## 8.6 TCP-verbindingen beveiligen

Noodzaak SSL:

- Geen versleuteling &rarr; indringer Bobs bestelling onderscheppen &rarr; creditcardgegevens achterhalen
- Integriteit gegevens niet gecontroleerd &rarr; bestelling veranderen
- Server niet geauthenticeerd &rarr; Valse website maken &rarr; gegevens stelen

SSL lost problemen op door volgende bovenop TCP uit te voeren:

1. Vertrouwelijkheid
2. Gegevensintegriteit
3. Serverauthenticatie
4. Clientauthenticatie

SSL &rarr; eenvoudige API vergelijkbaar API van TCP

## 8.6.1 Het hele verhaal, maar vereenvoudigd

**Fase 1: Handshake**

1. Bob TCP-verbinding met Alice maken
2. Verzekeren dat Alice echt Alice is
3. Alice geheime mastersleutel zenden &rarr; Alice &amp; Bob gebruiken &rarr; symmetrische sleutel genereren &rarr; nodig voor SSL

**Fase 2: Verkrijgen van een sleutel**

Alice &amp; Bob moeten MS gebruiken om vier sleutels te genereren:

- EB: **session encryption key** for data sent from Bob to Alice
- MB: **session MAC key** for data sent from Bob to Alice
- EA: session encryption key for data sent from Alice to Bob
- MA: session MAC key for data sent from Alice to Bob

**Fase 3: Gegevensoverdracht**

Geen goed idee &rarr; integriteit alle gegevens tijdens hele sessie dat Bob gestuurd heeft controleren

1. SSL splitst gegevensstream &rarr; records
2. SSL voegt berichtauthenticatiecode toe aan elk record &rarr; versleutelt combinatie
3. Maken van berichtauthenticatiecode &rarr; Bob hashfunctie toe &rarr; combinatie recordgegevens &amp; sleutel Mb
4. Versleutelen &rarr; Bob gebruikt sessievercijfersleutel Eb

**Man in the middle attack** **( MITM)** : kansegmenten in de TCP-stream vervangen, invoegen en verwijderen tussen Alice en Bob.

Aannemen dat elk TCP-segment exact 1 record verpakt is &rarr; kijken hoe Alice segmenten verwerkt

1. TCP in host Alice &rarr; denkt alles is OK &rarr; 2 records aan SSL-sublaag
2. SSL in host Alice &rarr; 2 records ontsleutelen
3. SSL in host Alice &rarr;berichtauthenticatiecode in elk record gebruiken &rarr; integriteit van gegevens in 2 records
4. SSL &rarr; ontsleutelde bytestream van 2 records doorgeven &rarr; applicatielaag &rarr; door Alice ontvangen bytestream &rarr; gevolg verwisseling records &rarr; niet in juiste volgorde

**Oplossing: gebruik volgnummers**.

1. Bob onderhoudt een reeksnummerteller, die begint bij nul en wordt verhoogd voor elke SSL-record die hij verzendt.
2. Wanneer hij de MAC berekent,neemt hij het volgnummer op in de MAC-berekening.

Zo is MAC = hash van gegevens + MAC-toets + huidig volgnummer.

Alice kan Bob&#39;s volgnummers opsporen, zodat ze de gegevensintegriteit kan verifiëren.

### SSL record

Bestaat uit &rarr; typeveld, versieveld, lengteveld, gegevensveld &amp; berichtauthenticatiecode

## 8.6.2 Het hele verhaal, maar wat minder vereenvoudigd

### SSL handshake

Alice &amp; Bob begin SSL-sessie zelf afspraken maken over cryptografische algoritmen &rarr; aka handshakeprocedurefase &rarr; + Alice &amp; Bob zenden elkaar nonces toe &rarr; gebruikt bij maken van sessiesleutels (EB,MB,EA,MA)

Handshakeprocedure bij SSL:

1. Client verzendt lijst &rarr; versleutelalgoritmen die hij ondersteunt &amp; zelfgekozen nonce
2. Server kiest uit ontvangen lijst algoritme voor &rarr; symmetrische sleutel, openbare sleutel &amp; berichtauthenticatiecode &rarr; server verstuurt bericht met voorkeuren, certificaat &amp; zelfgekozen nonce
3. Client authenticeert certificaat + berekent openbare sleutel server + genereert geheime pre-mastersleutel (PMS) &rarr; versleutelt PMS met openbare sleutel server &rarr; verzendt versleutelde PMS naar server
4. Afgesproken functie bepalen sleutel &rarr; berekenen client &amp; server onafhankelijk &rarr; geheime mastersleutel met PMS &amp; nonces &rarr; geheime mastersleutel in stukken gehakt &rarr; 2 coderingssleutels &amp; 2 berichtauthenticatiecodes genereren &rarr; gekozen symmetrische codering werkt met cipher-block-chaining &rarr; 2 initialisatievectoren gemaakt &rarr; geheime mastersleutel &rarr; daarna alle berichten versleuteld &amp; geauthenticeerd
5. Client verzendt berichtauthenticatiecode &rarr; alle handshakeprocedureberichten
6. Server verzendt berichtauthenticatiecode &rarr; alle handshakeprocedureberichten

Alleen nonces &rarr; niet mogelijk &quot;replay attack&quot; te voorkomen

### Verbinding verbreken

Iemand geeft in het typeveld aan of de record dient om de SSL-sessie te beëindigen. Door zo&#39;n veld op te nemen, zou Alice weten dat als ze een TCP FIN zou ontvangen voordat ze een SSL-sluitingsrecord zou ontvangen, ze weet dat er iets grappigs aan de hand is.

## 8.7 Beveiliging op netwerklaag: IPsec &amp; VPN

### 8.7.1 IPsec &amp; VPN
Met VPN &rarr; interne dataverkeer van de instelling verzonden via het publiekelijk toegankelijke internet in plaats van via een fysiek gescheiden netwerk. &rarr; dataverkeer eerst versleuteld

**CHECK PAGINA 597 IN HANDBOEK VOOR AFBEELDING**

## 8.7.2 Authentication header-protocol en het encapsulation security payload-protocol

Protocolsuite IPsec &rarr; Authentication header **(AH-protocol)** &amp; encapsulation security payload
**(ESP-protocol)**

**AH-protocol**  &rarr; bronauthenticatie &amp; gegevensintegriteit maar geen vertrouwelijkheid
**ESP-protocol**  &rarr; bronauthenticatie &amp; gegevensintegriteit &amp; vertrouwelijkheid
 Vertrouwelijkheid essentieel bij VPN &amp; andere IP-sec applicaties

## 8.7.3 Beveiligingsassociaties

IPsec-datagrammen &rarr; verzonden tussen 2 netwerkentiteiten &rarr; voor bronentiteit IPsec-datagrammen verstuurt &rarr; 2 entiteiten &rarr; logische verbinding tot stand = **beveiligingsassociatie** &rarr; logische simplexverbinding &rarr; unidirectioneel van bron naar bestemmingsentiteit &rarr; beide entiteiten beveiligde datagrammen naar elkaar willen verzenden &rarr; noodzakelijk om 2 beveiligingsassociaties tot stand te brengen &rarr; voor elke richting 1

## 8.7.4 Het IPsec-datagram

2 verschillende packetvormen &rarr; **tunnelmodus &amp; transportmodus**
**PAGINA 589 HANDBOEK**

- R1 voegt achter aan oorspronkelijke IPv4-datagram een ESP-trailerveld toe
- R1 versleutelt resultaat met behulp van het algoritme & de sleutel die voor de beveiligingsassociatie zijn overeengekomen
- R1 voeg aan voorkant van versleutelde geheel &rarr; veld toe &rarr; ESP-header &rarr; Resulterende pakket &rarr; enchilada
- R1 voegt berichtauthenticatiecode toe aan achterkant van versleutelde geheel &rarr; alles te samen &rarr; inhoud van payloadveld
- R1 creëert een nieuwe IP-header met alle klassieke IPv4-headervelden &rarr; voegt voor payloadveld toe

## 8.7.5 sleutelbeheer in IPsec (IKE)

IKE kent twee fase

Fase1:

- Vaststellen bidirectionele IKE SA

_opmerking: IKE SA anders dan IPsec SA
 ook bekend als ISAKMP security association_

Fase 2:

- ISAKMP wordt gebruikt om veilig te onderhandelen over IPsec-paar SA&#39;s

fase 1 heeft twee modi: agressieve modus en hoofdmodus

- Agressieve modus gebruikt minder berichten
- Hoofdmodus biedt identiteitsbescherming en is flexibeler

IKE-berichtenuitwisseling voor algoritmen, geheime sleutels, SPI-nummers

- AH- of ESP-protocol (of beide) AH biedt integriteit, bronverificatie
- ESP-protocol (met AH) biedt bovendien versleuteling
- IPsec-peers kunnen twee eindsystemen zijn, twee routers/firewalls, of een router/firewall en een eindsysteem

##

## 8.8 Securing wireless LANs

## 8.8.1 Wired equivalent privacy

### LEER VANUIT SLIDES $rarr; DUIDELIJKER

## 8.9 Operationele beveiliging: firewalls &amp; intrusion-detectionsystemen

## 8.9.1 Firewalls

3 doelen:

- Alle dataverkeer van buiten naar binnen &amp; omgekeerd passeert firewall
- Alleen geauthenticeerd dataverkeer &rarr; gedefinieerd in lokale beveiligingspolicy&#39;s mag passeren
- Firewall kan niet zelf benaderd worden

### Traditionele packetfilters

Filterbeslissingen meestal genomen op basis van:

- IP-bronadressen of IP-bestemmingsadressen
- Typeveld in IP-datagram
- TCP- of UDP-bronpoorten en -bestemmingspoorten
- TCP-vlagbits: SYN, ACK,...
- ICMP-berichttype
- Verschillende regels voor datagrammen die netwerk binnenkomen en verlaten
- Verschillende regels voor verschillende routerinterfaces

Organisatie kan filteren op:

- TCP-SYN-segmenten &rarr; geen inkomende TCP-verbindingen toestaan behalve voor publieke webserver &rarr; alle TCP-SYN-segmenten blokkeren behalve &rarr; TCP-SYN-segmenten bestemmingspoort 80 &amp; bestemmings-IP overeenkomt met webserver
- TCP-ack-bit &rarr; interne clients verbinden met externe servers &rarr; externe clients niet verbinden met interne servers
  - 2e mogelijkheid &rarr; DNS-packets netwerk kunnen binnenkomen &amp; verlaten &rarr; blokkeert al het dataverkeer &rarr; behalve webdataverkeer binnen organistatie &amp; DNS-dataverkeer

Filterpolicy kan gebaseerd zijn op combinatie van adressen &amp; poortnummers

### Stateful packetfilters

Bewaken alle bestaande TCP-verbindingen &rarr; firewall kan nieuwe verbinding detecteren &rarr; door 3-wayhandshake (SYN, SYNACK &amp; ACK) &rarr; + eind verbinding detecteren &rarr; FIN-packet &rarr; firewall kan ook veronderstellen &rarr; verbinding niet meer nodig is &rarr; geen activiteit

Packet bereikt firewall

1. Firewall controleert lijst met **toegangsbeheer** ( traditionele packetfilters )
2. Verbindingstabel controleren voor packet in netwerk van organisatie kan komen
3. Controleert verbindingstabel &rarr; geen deel van lopende TCP-verbinding &rarr; weigert
4. IF webserver stuurt packet terug &rarr; firewall controleert tabel &rarr; overeenkomstige verbinding &rarr; packet passeren

### Application gateway

Firewalls moeten packetfilters combineren met applicatiegateways &rarr; die kijken verder dan headers van IP, TCP &amp; UDP &rarr; beslissingen op basis van applicatiegegevens
**Applicatiegateway** &rarr; applicatiespecifieke server die door alle applicatiegegevens gepasseerd moet worden &rarr; verschillende applicatiegateways kunnen op dezelfde host uitgevoerd worden &rarr; elke gateway afzonderlijke server met eigen processen

**Stel:**

Firewall &rarr; geselecteerde groep interne gebruikers &rarr; Telnet-verbindingen met externe netwerken &rarr; tegelijk voorkomen &rarr; externe clients &rarr; Telnet-verbinding maken met interne host

**Stel nu:**

Interne gebruiker wil verbinding tot stand brengen met buitenwereld

1. Gebruiker Telnet-sessie starten met applicatiegateway &rarr; op gateway draait applicatie &rarr; wacht voor inkomende Telnet-sessies tot stand komen
2. Applicatie vraagt username &amp; password
3. IF informatie = correct &rarr; applicatiegateway checkt IF gebruiker = gerechtigd is &rarr; als dat het geval is
4. Gateway vraagt gebruiker &rarr; hostname externe host ingeven
5. Gateway Telnet-sessie &rarr; tussen gateway &amp; externe host
6. Gateway verzendt alle gegevens afkomstig van externe host naar gebruiker &amp; omgekeerd

## 8.9.2 Intrusion-detectionsystems

- Intrusiondetectionsysteem **(IDS)**&rarr; waarschuwt wanneer mogelijk schadelijk dataverkeer detecteerd
- Intrusion-preventionsysteem **(IPS)**&rarr; Apparaat dat schadelijk dataverkeer blokkeert

**IDS + IPS = IDS**

Organisatie &rarr; meerdere IDS&#39;s sensoren implementeren &rarr; meestal samenwerkend &rarr; sturen verdachte verkeersactiviteit &rarr; centrale IDS-processor &rarr; verzamelt info &rarr; alarmen verzendt naar netwerkbeheerder wanneer nodig

**Pagina 619 afbeelding 3.6**

Organisatie &rarr; 2 delen opgesplitst

1. Streng beveiligd deel &rarr; afgeschermd door &rarr; packetfilter &amp; applicatiegateway &rarr; bewaakt door IDS sensoren
2. Minder streng beveiligd deel &rarr;**gedemilitariseerde zone (DMZ)**&rarr; alleen beveiligd door packetfilter maar ook bewaakt door sensoren IDS
(_is een netwerksegment dat zich tussen het interne en externe netwerk bevindt. Het externe netwerk is meestal het _[_Internet_](http://nl.wikipedia.org/wiki/Internet)_. Een DMZ is feitelijk een andere naam voor een _[_extranet_](http://nl.wikipedia.org/wiki/Extranet)_, een gedeelte van het netwerk dat voor de buitenwereld volledig toegankelijk is. Op het netwerksegment van de DMZ zijn meestal _[_servers_](http://nl.wikipedia.org/wiki/Server)_ aangesloten die diensten verlenen die vanuit het interne en externe netwerk aangevraagd kunnen worden)_

Sensoren voor IDS &rarr; verderop in systeem &rarr; elke sensor deel van dataverkeer &rarr; gemakkelijker taak uitvoeren

**IDS systemen in 2 categorieën**

1. **Systemen die werken met handtekeningen**
  - database met aanvalskenmerken (handtekeningen) &rarr; elke handtekening &rarr; verzameling regels &rarr; gebruikt verdachte activiteit &rarr; kan lijst met kenmerken 1 packet &rarr; vergelijkt packets met handtekening in database &rarr; overeenkomst in database &rarr; waarschuwing

**Beperkingen:**

1. dit soort IDS &rarr; alleen als voorkennis over aanval is &rarr; gebruikt nauwkeurige handtekening te vervaardigen &rarr; blind als er nieuwe aanvallen zijn
2. packet &rarr; zelfs als er bekende handtekening is &rarr; niets te maken met een aanval &rarr; false-positive warning
3. IDS kan overvoerd geraken &rarr; elk packet vergeleken moet worden &rarr; uitgebreide verzameling handtekeningen &rarr; kan zover komen dat IDS schadelijke packets niet detecteert

1. **Op anomalie gebaseerde systemen**
  - Creëert profiel &rarr; normale verloop &rarr; gecontroleerde dataverkeer &rarr; zoekt packetstreams statisctisch ongebruikelijk zijn
  - Niet afhankelijk van voorkennis bestaande aanvallen
  - Wel moeilijk &rarr; efficiënt onderscheid maken &rarr; normaal dataverkeer &amp; statistisch ongebruikelijk verkeer

### Snort

Maakt gebruik van generieke sniffingsinfterface, libpcap

Enorme groep gebruikers &amp; beveiliginsexperts &rarr; houden handtekeningdatabase actueel

## 9 Multimedianetwerken

## 9.1 Multimedianetwerkapplicaties

## 9.1.1 Eigenschappen van video

- **Hoge bit rate** : 100kbps voor low-quality video conferencing &rarr; 3 Mbps streaming high-definition movies. &rarr; bitsnelheidvereisten van video belangrijk ontwerpen netwerkvideotoepassing
- Een niet-gecomprimeerde, digitaal gecodeerde afbeelding &rarr; reeks pixels&rarr; elke pixel gecodeerd in aantal bits om luminantie en kleur weer te geven.
- 2 Types redundantie in video &rarr; exploited door video compressie
  1. **Tijdelijke redundantie**  **&rarr;** werkt met verschillen tussen opeenvolgende afbeeldingen
  2. **Spatial redundancy**  **&rarr;** redundantie binnen een bepaalde afbeeling

## 9.1.2 Eigenschappen van audio

- Digitale audio &rarr; lagere bandbreedte nodig dan video &rarr; Pulse Code Modulation (PCM) &rarr; coderen spraak &rarr; 8000 samples/seconde &amp; 8 bits per sample &rarr; bitsnelheid 64 kbps
- Compressietechniek voor stereomuziek &rarr; MP3 &rarr; bitsnelheid 128 kbps &rarr; geluidskwaliteit slechter
- Advanced Audio Coding (AAC) &rarr; meerdere versies vooropgenomen audio stream kan gemaakt worden &rarr; elke klein verschil bit rate

## 9.1.3 Soorten multimedianetwerkapplicaties

### Streamen van opgeslagen audio / video

Streamen van opgeslagen video 3 belangrijke onderscheidende kenmerken

- Streamen &rarr; client begint video &rarr; binnen enkele seconden na ontvangst weer te geven &rarr; client video weergeeft &rarr; bepaalde plaats in opname &amp; tegelijk latere delen van die opname ontvangt van server = **streamen**
- Interactiviteit &rarr; media vooraf opgenomen &rarr; gebruiker weergave onderbreken, doorspoelen,... &rarr; voor aanvaardbare gebruikskwaliteit &rarr; tijd tussen moment gebruiker actie start &amp; uitvoering actie &rarr; enkele seconden
- Continue weergave &rarr; zelfde snelheid weergeegven als orgineel &rarr; gegevens op tijd van server ontvangen &rarr; voor moment client moet weergeven &rarr; anders haperingen
- Gemiddelde doorvooercapaciteit &rarr; netwerk streamapplicatie &rarr; gemiddelde doorvoorcapaciteit bieden &rarr; ten minste even groot als bitsnelheid video

### VOIP

Timing is belangrijk &rarr; spraak- en videoapplicaties &rarr; vertragingsgevoelig &rarr; meeste multimedianetwerkapplicaties &rarr; bestand tegen een zekere mate van gegevensverlies &rarr; resulteert in korte onderbrekingen van audio of video

### Streamen van live audio &amp; video

Meestal via CDN&#39;s &rarr; zelfde snelheid weergeegven als orgineel &rarr; gegevens op tijd van server ontvangen &rarr; voor moment client moet weergeven &rarr; anders haperingen &rarr; omdat evenement = live &rarr; vertraging probleem zijn &rarr; timingeisen minder streng dan voor spraakgebrekken

## 9.2 Streamen van opgeslagen video

2 belangrijke voordelen bufferen door client

1. Fluctuaties in vertraging tussen server en client opvangen
2. Banbreedte tussen server &amp; client &rarr; daalt onder sneheid &rarr; waarmee videocontent wordt weergegeven &rarr; blijven kijken zolang buffer van clientcomponent niet leegraakt

## 9.2.1 Streamen met UDP

Kleine buffer op clientcomponent van applicatie gebruikt &rarr; net groot genoeg voor minder dan seconde video &rarr; server die video aan UDP-verbinding vertrouwt &rarr; stukjes video verpakken in transportpackets speciaal ontworpen voor transporteren audio &amp; video &rarr; Realtime Transport Protocol ( RTP )

Server &amp; client &rarr; onderhouden verbinding voor videostream &rarr; ook afzonderlijke besturingsverbinding die door client wordt gebruikt geven opdrachten

Systeem 3 belangrijke nadelen:

1. Streamen met constante snelheid &rarr; voor continue weergave &rarr; problemen opleveren als gevolg van onvoorspelbaare &amp; wisselende beschikbare bandbreedte
2. Streamen met UDP &rarr; server nodig om media te besturen &rarr; interactieve verzoeken tussen client en server afhandelen &amp; toestand client bewaren &rarr; voor elke sessie
3. Veel firewalls geconfigureerd om UDP verkeer te blokkeren

## 9.2.2 Streamen met HTTP

Video in HTTP server &rarr; gewoon bestand met specifieke URL &rarr; gebruiker wil video zien

1. Client start TCP-verbinding met server
2. Verzendt HTTP-GET-bericht
3. Server verzendt video bestand in HTTP-antwoordbericht
4. Clientcomponent applicatie verzamelt bytes in buffer
5. Zodra # bytes in buffer \&gt; bepaalde drempelwaarde
6. Client begint met weergave + videoframes periodiek uit buffer opgehaald &amp; gecomprimeerd

Packets &rarr; vertraagd als gevolg opnieuw verzenden packets

Gebruik van HTTP over TCP &rarr; firewalls en NAT&#39;s gemakkelijker gepasseerd kunnen worden &rarr; van het UDP-dataverkeer tegen houden &rarr; HTTP-dataverkeer door te laten &rarr; streamen HTTP geen mediabesturingsserver nodig (RTSP-server) &rarr; kosten lager &rarr; meeste videostreamapplicaties werken met HTTP over TCP als streamprotocol

### Prefetchen van video

Client probeert video downloaden &rarr; snelheid hoger dan weergavesnelheid &rarr; voorraad krijgen van videoframes &rarr; toekomst worden weergegeven

### Buffers van clientcomponent van de applicatie &amp; TCP-buffers

Volledige client applicatie buffer &rarr; legt indirect limiet op rate &rarr; video verstuurd van server naar client wanneer streamen over HTTP

### Analyse van clientcomponent van applicatie en TCP-buffers

If beschikbare rate \&lt; video rate &rarr; continue weergave afgewisseld worden &rarr; periodes beeld stilstaat &rarr; wanneer beschikbare rate in netwerk \&gt; video rate &rarr; na initiele buffering vertraging &rarr; continous playout tot einde video

### Vroegtijdige beëindiging van weergave &amp; verplaatsen van weergavetijdstip

HTTP-byterange-headerveld in HTTP-get-verzoekbericht &rarr; bevat informatie &rarr; bereik in bytes van gewenste video &rarr; client wil ontvangen &rarr; If gebruik springt naar ander tijdstip in video &rarr; client verzendt nieuw HTTP-verzoekbericht &rarr; in byterangeheaderveld van bericht &rarr; clientapplicatie specifieert vanaf welke byte in bestand &rarr; gegevens wil ontvangen &rarr; server nieuw HTTP-verzoek ontvangt &rarr; alle eerdere verzoeken weg &amp; bytes verzenden

## 9.2.3 Dynamic Adaptive Streaming over HTTP (DASH)

Gebruikt meerdere versies &rarr; zelfde video &rarr; elk een bepaalde snelheid waarmee gestreamd wordt &rarr; gecomprimeerd &rarr; CDN&#39;s vaak gebruikt distribueren opgeslagen &amp; live video

## 9.3 Voice-over-IP (VoIP)

## 9.3.1 Beperkingen van best-effortdienst van IP

IP &rarr; zo snel mogelijk van bron naar bestemming &rarr; geen beloften &rarr; vertraging of packet loss &rarr; belangrijke consequenties &rarr; ontwerp realtime spraakapplicaties &rarr; gevoelig voor packetvertraging, jitter &amp; verlies

1. Verzender genereert bytes met snelheid &rarr; 8000 bytes/seconde &rarr; iedere 20 ms verzamelt bytes in stuk &rarr; **chunk**
2. Chunk + speciale header &rarr; verpakt in UDP-segment &rarr; elke 20 ms UDP-segment verzonden

Als packet ontvanger bereikt &rarr; constante end-to-endvertraging &rarr; packets 20 ms na elke spraakactie van andere partij arriveren &rarr; ideale situatie &rarr; ontvanger elke chunk direct bij aankomst weergeven &rarr; sommige packets kwijt + niet zelfde end-to-endvertraging

Ontvanger moet

1. Bepalen wanneer chunk moet weergegeven worden
2. Bepalen wat er moet gebeuren als chunk ontbreekt

### Packetverlies

Verlies zou voorkomen &rarr; packets over TCP versturen &rarr; mechanismen opnieuw verzenden packets &rarr; niet geschikt voor VoIP &rarr; vergroten end-to-endvertraging

Packetloss tussen 1% en 20% is acceptabel &rarr; afhankelijk hoe spraakgegevens gecodeerd &amp; verzonden zijn &rarr; manier hoe ontvanger verlies maskeert &rarr; Forward Error Correction (FEC) &rarr; hulpvol zijn packetverlies maskeren

### End-to-endvertraging

Totaal van

- Transmission delay
- Processing delay
- Queing delays routers
- Propagation delays in verbindingen
- Processing delays hosts

Ontvanger bij VoIP-applicatie &rarr; packets negeren die vertraging groter dan bepaalde drempelwaarde

### Packetjitter

Variatie in queuing delays &rarr; packet in netwerkrouters ondervindt = cruciaal &rarr; deze vertragingen variëren &rarr; dus ook verstreken tijd tussen moment &rarr; verzenden packet &amp; ontvangen packet &rarr; fenomeen = **jitter** &rarr; compenseren aan de hand van **volgnummers** , **tijdstempels** &amp; **weergavevertraging**

## 9.3.2 Jitter voor audio compenseren bij ontvanger

Gedaan door 2 mechanismes combineren

1. Elke chunk vooral laten gaan door tijdstempel &rarr; verzender voegt aan elk nieuw gegenereerd packet &rarr; informatie over tijdstip &rarr; packet werd gegenereerd
2. Weergave chunks &rarr; bij ontvanger vertragen &rarr; weergave ontvangen chunks &rarr; vertraagd worden &rarr; zodat grootste deel packets ontvangen is voor weergeven

### 1) Onveranderlijke weergavevertraging

Ontvanger kan weergavevertragingen variëren

Chunk tijdstempel bij afzender op tijdstip t &rarr; ontvanger speelt chunk (q) af op tijdstip t + q &rarr; assuming chunk tegen die tijd gearriveerd &rarr; packets na hun geplande speeltijd arriveren &rarr; weggegooid

### 2) Variabele weergavevertraging

Door initiële weergavevertraging groot te maken &rarr; meestg packets op tijd aankomen &rarr; verloren packets = klein &rarr;weergavevertraging variëren aan begin elke spraaksessie &rarr; stiltes voorafgaand aan spraaksessie &rarr; verkort of verlengd &rarr; niet hoorbaar wanneer verleningen / verkortingen stiltes niet te groot zijn

- Schatting van de pakketvertraging ( di ) = schatting gemiddelde netwerkvertraging moment i-de packet arriveert bij ontvanger
- Schatting gemiddelde afwijking van vertraging ( vi ) = geschatte gemiddelde afwijking vertraging ten opzichte van de geschatte gemiddelde vertraging &rarr; di gemiddelde werkelijke netwerkvertragingen $rarr; r1 - t1,...,ri-ti
  -
- Schattingen di &amp; vi berekend elk ontvangen pakket &rarr; als packet i &rarr; 1e packet in spraaksessie &rarr; weergavemoment pi berekend $rarr; pi = ti + di + Kvi

- Term Kvi &rarr; weergavemoment zover in toekomst verschoven &rarr; klein gedeelte packets te laat arriveren in spraaksessie
- Stel dat qi = tj + qi &rarr; tijd tussen moment 1e packet in spraaksessie genegeerd &amp; moment packet weergegeven &rarr; als packet j ook hoor bij spraaksessie &rarr; wergegeven op tijdstip &rarr; pj = tj + qi

## 9.3.3 Compenseren van packetverlies

### Forward Error Correction ( FEC )

**Mechanisme 1:**

Verzendt redundant gecodeerde &#39;chunk&#39; na elke n chunks &rarr; geconstrueerd door exclusieve OR-bewerking uit te voeren op n oorspronkelijke chunk.

Als willekeurig packet van groep n+1 kwijtgeraakt &rarr; ontvanger verloren packet reconstrueren &rarr; meer dan 2 niet mogelijk &rarr; verhoogt overdrachtssnelheid &amp; weergavevertraging

**Mechanisme 2:**

Versturen van lagere resolutie audio stream &rarr; verzender genereert n-de packet door n-de chunk van nominale stream achter (n-1) de chunk van redundante stream te plaatsen &rarr; wanneer meerdere niet opeenvolgende packets kwijtraken &rarr; ontvanger verlies compenseren door chunk met lage bitsnelheid &rarr; volgende packet &quot;meelift&quot; geven &rarr; lagere geluidskwaliteit

### Interleaving

Verzender verstuurt eenheden audiogegevens in andere volgorde &rarr; oorspronkelijk aangrenzende eenheden in verzonden stream gescheiden zijn door afstand &rarr; effect packetverlies verkleinen &rarr; if packetloss &rarr; meeste van elke orginele chunk &rarr; geen redundantie overhead &rarr; verhoogt playout delay &rarr; voordeel &rarr; benodigde bandbreedte voor een stream niet vergroot

### Maskeren van fouten

Herhalen van packets &rarr; ontvanger vervangt kwijtgeraakte packets door kopieën

Interpolatie &rarr; kwijtgeraakte packet berekend p basis van voorgaande &amp; volgende packet in stream

## 9.3.4 Casus: VoIP met Skype

- Skype werkt met hiërarchisch overlaynetwerk
- Peer kan &quot;superpeer&quot; of gewone peer zijn
- Werkt met index &rarr; koppelt IP-adressen aan gebruikers
- Index gedistribueerd over superpeers
- Alice belt Bob &rarr; Skype client zoekt distribueerde index &rarr; Bob&#39;s IP adres bepalen

Meeste thuisnetwerken &rarr; NAT netwerken &rarr; NAT voorkomt host buiten thuisnetwerk verbinding met host binnen thuisnetwerk &rarr; beide Skype-bellers NAT &rarr; probleem

Super peers lossen probleem op

1. Alice logt in &rarr; superpeer buiten netwerk toegewesen &rarr; Alice &amp; superpeer besturingsberichten uitwisselen &rarr; idem voor Bob
2. Alice belt Bob &rarr; informeert Alice superpeer &rarr; superpeer Bob informeert &rarr; brengt Bob op hoogte &rarr; inkomende oproep Alice
3. Bob accepteert &rarr; 2 superpeers kiezen 3e superpeer zonder NAT &rarr; gegevens Alice en Bob uitwisselen aan elkaar koppelen

Conference calls &rarr; elke gebruiker verzendt audiostream naar deelnemer die gesprek start &rarr; deelnemer combineert audiostreams tot 1 enkele stroom &rarr; verzendt kopie van elk gecomineerde stream &rarr; elk van andere N-1 deelnemers &rarr; video elke deelnemer &rarr; gestuurd in servercluster

## 9.4 Protocollen voor realtime spraakapplicaties

## 9.4.1 RTP

Gebruikt PCM,MP3,... te transporteren

### Basisprincipes van RTP

RTP boven op UDP

1. Verzendende component verpakt chunk media-gegevens in RTP-packet
2. Verpakt packet in UDP-segment &rarr; naar IP
3. Ontvangende haalt RTP-packet uit UDP-segment
4. Chunk &rarr; mediaplayer &rarr; decodeert &amp; weergeven
5. Verzendende omponent voegt voor elke chunk audiogegevens &rarr; RTP-header toe
  - Type van audiocodering
  - Volgnummer
  - Tijdstempel
6. RTP packet &rarr; in UDP socket interface
7. Ontvanger &rarr; applicatie ontvangt RTP van socket interface
8. Applicatie filtert audiogegevens &amp; headervelden van RTP packet &rarr; gegevens decoderen &amp; afspelen

RTP geen mechanismen &rarr; tijdige bezorging van gegevens of kwaliteit diensten &rarr; geen garantie of packets aankomen of juiste volgorde

RTP &rarr; elke bron &rarr; eigen onafhankelijke RTP-packetstream &rarr; routers geen onderscheid tussen IP-datagrammen met RTP-packets &amp; zonder RTP-packets

### Headervelden van RTP-packet

- Volgnummerveld (16 bits) &rarr; verhoogt met 1 voor elk verstuurde RTP-packet &rarr; gebruikt door ontvanger om packet loss &amp; volgorde van packets herstellen
- Tijdstempelveld (32 bits) &rarr; ontvanger tijdstempels &rarr; packetjitter compenseren &amp; packets met zelfde snelheid weergeven als waarin verzonden &rarr; als applicaties 160 gecodeerde samples maakt &rarr; tijdstempelveld verhoogt met 160 voor elk RTP-packet wanneer bron actief &rarr; tijdstempelveld klok loopt met constante snelheid &rarr; zelfs if bron = inactief
- Bronidentificatieveld / ( **Synchronization Source Identifier** of **SSRC** (32 bits) &rarr; identificeerd bron van RTP stream &rarr; elke RTP sessie heeft unieke bronidentificatie

## 9.4.2 SIP

- Levert mechanismen &rarr; gesprekken over IP-netwerk &rarr; beller kan diegene die gebeld wordt waarschuwen &rarr; gesprek wil &rarr; beide partijen afspraken maken over codering van media &rarr; beide deelnemers ook gesprek beëindigen
- Mechanismen &rarr; beller huidige IP-adres bepalen van gebelde &rarr; gebruikers geen vast IP &rarr; dynamisch toegewezen &rarr; verschillende IP-apparaten
- Mechanismen &rarr; beheren gesprekken &rarr; bv. Toevoegen nieuwe mediastreams, doorschakelen van gesprekken, ...

### Gesprek tot stand brengen met bekend IP-adres

1. Alice stuurt Bob &rarr; SIP INVITE bericht &rarr; over UDP naar poort 5060 voor SIP &rarr; geeft poort aan
2. INVITE-bericht identificatie voor Bob + indicatie huidig IP van Alice &amp; preferred codering
3. Bob antwoord met 200 OK bericht &rarr; poort weer, IP &amp; preferred codering
4. Na ontvangen Bob antwoord &rarr; SIP ontvangst bericht &rarr; erna praten

SIP kan over TCP of UDP verstuurd worden &rarr; default port 5060 &rarr; SIP berichten verstuurd en ontvangen in sockets &rarr; andere dan voor media data

SIP berichten &rarr; ASCII leesbaar &rarr; lijken op HTTP-ber

### SIP-berichten

Kijk pagina 663. Voor voorbeeld

### Vertalen van namen en het traceren van een gebruiker

Alice kent alleen e-mailadres Bob &rarr; dit adres ook voor SIP-gesprekken

#### Hoe kent proxyserver het huidige IP-adres van [bob@domain.com](mailto:bob@domain.com)

Elke SIP-gebruiker &rarr; registrar gekoppeld

1. Gebruiker start SIP-applicatie
2. Applicatie verzendt SIP-registerbericht naar registrar &rarr; informatie huidig IP gebruiker
3. Registrar Bob &rarr; bijhouden huidig IP-adres Bob &rarr; ander SIP-apparaat &rarr; nieuw registerbericht met nieuw IP

Gebruik langere tijd &rarr; register blijft registerberichten sturen &rarr; registrar overeenkomsten met DNS-name-server &rarr; vertaalt vaste hostnamen naar vaste IP &rarr; SIP-registrar vaste menselijke identificatiegegevens &rarr; dynamische IP-adressen &rarr; SIP-registrars &amp; proxy&#39;s op zelfde host

####

####

####

#### Hoe kan SIP proxy huidige IP-adres van Bob achterhalen

1. Alice verstuurt INVITE-bericht &rarr; SIP-proxy Bob
2. Proxy stuurt bericht naar SIP-apparaat van Bob
3. Bob ontvangt Alice INVITE-bericht &rarr; kan antwoord sturen naar Alice

#### [Jim@umass.edu](mailto:Jim@umass.edu) (217.123.56.89) wil VoIP starten met [Keith@upenn.edu](mailto:Keith@upenn.edu) (197.87.54.21)

1. Jim verzendt INVITE-bericht naar SIP-proxy van umass
2. Proxy &rarr; DNS-lookup voor SIP-registrar upenn.edu &rarr; verzendt bericht naar registrarserver
3. Keith.upenn.edu &rarr; niet bekend bij registrar upenn &rarr; registrar omleidingsantwoordbericht &rarr; melding &rarr; umass keith.nyu.edu moet proberen
4. Proxy umass &rarr; INVITE-bericht &rarr; SIP-registrar van NYU
5. Registrar NYU &rarr; kent IP van [keith@upenn.edu](mailto:keith@upenn.edu)&rarr; stuurt INVITE-bericht door naar host 197.87.54.21 &rarr; SIP-client van Keith uitvoert.
6. Verzendt SIP-antwoordbericht &rarr; registrars/proxy&#39;s &rarr; terug naar SIP-client &rarr; 217.123.56.89
7. Idem 6
8. Idem 6
9. Media &rarr; rechtstreeks tussen 2 clients verzonden &rarr; ook ACK

## 9.5 Netwerkondersteuning voor multimedia

- **Beste maken van de best-effortdienst** &rarr; toenames van vraag voorspeld &rarr; ISP&#39;s extra bandbreedte &amp; switches in &rarr; acceptabele mate vertraging &amp; packetloss te garanderen
- **Diensten in verschillende categorieën aanbieden**  **&rarr;** 1 type van verkeer &rarr; kan hogere prioriteit krijgen dan een ander type
- **Per verbinding andere QoS-garanties geven** &rarr; per verbiending QoS garantie &rarr; elke instantie van applicatie &rarr; bandbreedte reserveren &rarr; garanties end-to-endperformance &rarr; **harde garantie** &rarr; applicatie zeker de gevraagde QoS zal ontvangen &rarr; **Zachte garantie** &rarr; grote waarschijnlijkheid de gevraagde QoS zal ontvangen

## 9.5.1 Best-effortnetwerken dimensioneren

Eerste manier kwaliteit multimedia-applicaties te verbeteren &rarr;

**Meer geld uitgeven**

Bij multimedia in netwerken &rarr; voorkomen tekort aan recources &rarr; als linkcapaciteit &rarr;
 groot genoeg &rarr; packets door huidige internet getransporteerd &rarr; zonder queuing delays of
 kans op vermissing

Vraag is &rarr; hoeveel capaciteit nodig? &rarr; kosten leveren benodigde bandbreedte &rarr; reële zakelijke optie is voor ISP&#39;s &rarr; hoe groot capaciteit netwerklinks &rarr; bepaalde topologie &rarr; bepaalde end-to-endperformance te leveren = **netwerkdimensioneringsprobleem**

**Volgende problemen moeten opgelost worden om performance van applicatielaag tussen 2 eindpunten in netwerk te kunnen voorspellen**

1. Modellen van het benodigde dataverkeer tussen eindpunten in het netwerk
  - Mogelijk modellen gedefinieerd worden op gespreksniveau
2. Goed gedefinieerde performance-eisen
  - Performance eis stellen dat gevoelig is voor vertraging &rarr; kans end-to-endvertraging van packets groter is dan max te tolereren vertraging
3. Modellen om end-to-endperformance bij een bepaald netwerkbelastingsmodel te voorspellen en technieken om zo gering mogelijke kosten zodanig bandbreete toe te wijzen dat aan alle eisen van de grebruikers wordt voldaan

## 9.5.2 Verschillende soorten diensten verlenen

Eenvoudigste uitbreiding &rarr; dataverkeer voor unitaire &amp; egalitaire best-effortdienst &rarr; huidige internet opsplitsen in categorieën &rarr; bij dienstverlening aan verschillende categorieën &rarr; verschillende niveaus

### Een paar scenarios

Principe 1: **Packet markering** &rarr; markeren van packets &rarr; router packets die horen bij verschillende dataverkeercategorieën van elkaar onderscheiden &rarr; originele doel (ToS) veld in IPv4

Principe 2: **Isolatie dataverkeer**  **&rarr;** zekere mate van isolatie tussen categorieën implementeren &rarr; ene klasse niet nadelig beïnvloed kan worden &rarr; als iets mis is met andere categorie

2 aanpakken mogelijk:

1. **Dataverkeerpolicy** &rarr; als dataverkeercategorie moet voldoen aan bepaalde criteria &rarr; controlemechanisme &rarr; zorgen policy nageleefd &rarr; als applicatie niet aan criteria houdt &rarr; mechanisme handelend optreden &rarr; dataverkeer netwerk binnenkomt voldoet aan criteria
2. **Packetschedulingmechanisme op datalinklaag** &rarr; expliciet een constante hoeveelheid van linkbandbreedte te laten reserveren &rarr; elke categorie

Principe 3: Belangrijk categorieën van elkaar scheiden &rarr; wenselijk recources &rarr; efficiënt mogelijk te benutten &rarr; manier packets in wachtrij voor verzending over link worden geselecteerd = **link-schedulingmethode**

### Leaky bucket

Policing = belangrijk QoS-mechanisme

3 policycriteria:

1. **Gemiddelde snelheid:** Netwerk kan gemiddelde snelheid van packets van stream langere tijd beperken &rarr; cruciale factor &rarr; tijdsduur waarover de gemiddelde snelheid zal worden geregeld &rarr; bron begrensd 100 packets per seconde &rarr; sneller afgeremd dan bron 6000 packets/min &rarr; zelfs beide bronnen &rarr; zelfde gemiddelde snelheid
2. **Maximale snelheid:** beperking van gemiddelde snelheid &rarr; begrenst hoeveelheid dataverkeer &rarr; in netwerk gezonden kan worden &rarr; relatief lange periode **&rarr;** beperking van maximale snelheid &rarr; begrenst # packets verzonden in korte periode
3. **Burstgrootte** &rarr; Netwerk kan ook max # packets &rarr; begrenzen &rarr; dat gedurende extreem korte periode via netwerk wordt verzonden

Buckets bestaan uit &rarr; bucket dat max b tokens bevat

1. Nieuwe tokens &rarr; in bucket &rarr; snelheid van r tokens per seconde genereerd
2. IF bucket \&lt; b tokens &rarr; token direct in bucket
3. Else &rarr; token genegeerd &rarr; bucket blijft gevuld met b tokens

**Stel packet voor het verzonden wordt**  **&rarr;**  **token uit bucket halen**

Omdat maximaal b tokens in bucket zitten &rarr; maximale burstgrootte voor een met leaky bucket begrense stream gelijk aan b packets

Tokens genereerd met snelheid r &rarr; maximale aantal packets &rarr; netwerk kan binnenkomen in willekeurige periode met lengte t &rarr; rt + b &rarr; snelheid r waarmee tokens genereerd worden &rarr; maat om gemiddelde snelheid &rarr; packets netwerk kunnen binnenkomen op lange termijn &rarr; begrenzen


## 9.5.3 Diffserv

Diffserv &rarr; differentiatie in dienstverlening &rarr; mogelijkheid verschillende categorieën dataverkeer &rarr; internet schaalbare manier

2 functionele elementen

1. **Functies aan de edge:** &rarr; classificeren en coditioneren van dataverkeer &rarr; ingaande edge netwerk ( bij Diffserv-host die dataverkeer genereert of eerste Diffserv-router waarlangs dataverkeer passeert) &rarr; arriverende packets gemarkeerd
2. **Functies in de core**  **&rarr;** doorverzenden &rarr; wanneer Diffserv gemarkeerd packet &rarr; arriveert Diffserv router &rarr; doorverzonden naar volgende hop &rarr; volgens &#39;per-hop&#39; voorschrift &rarr; geldt voor betreffende categorie packets &rarr; &#39;per-hop&#39; voorschrift uitsluitend gebaseerd op markering van packet ( Diffserv-model)

Packets die bij edgerouter aankomen &rarr; gaclassificeerd &amp; gemarkeerd (AFBEELDING p.679)

1. Classificeerder selecteert packets &rarr; basis 1 of meer waarden in headervelden
2. Verzendt packet naar betreffende markeerfunctie

Sommige gevallen host afgesproken &rarr; packetverzendsnelheid &rarr; sturen &rarr; voldoet aan bepaald **dataverkeerprofiel** &rarr; kan limiet op maximale overdrachtsnelheid bevatten of maximale # packets verzonden in korte tijd

Zolang gebruiker packets verzendt &rarr; voldoen aan overeengekomen waarden in dataverkeerprofiel &rarr; packets voorkeursbehandeling &rarr; wanneer verzender niet houdt aan dataverkeerprofiel, packets buiten overeenkomst vallen &rarr; andere markering of vertraagd worden of zelfs genegeerd worden aan edge netwerk

**Meetfunctie** &rarr; ingaande stream vergelijken met overeengekomen dataverkeerprofiel &rarr; bepalen packet binnen dat profiel past &rarr; eigenlijke beslissing over packets &rarr; netwerkbeheerder

In per-hop gedrag belangrijke overwegingen

- &#39;per-hop&#39; voorschrift &rarr; zorgen verschillende categorieën dataverkeer &rarr; verschillende diensten
- Per-hop voorschrift verschilt &rarr; behandeling tussen categorieën definieert &rarr; geen expliciete informatie hoe voorschrift uitvoeren
- Verschillen in performance moeten dus zichtbaar &amp; meetbaar zijn

**2 &#39;per-hop&#39; voorschriften gedefinieerd**

1. **Expedited forwarding** &rarr; &#39;per-hop&#39; voorschrift &rarr; vertreksnelheid van categorie &rarr;
 bij router = \&gt; dan geconfigureerde snelheid
2. **Assured forwarding** &rarr; &#39;per-hop&#39; voorschrift &rarr; verkeer in 4 categorieën &rarr; elke AF-categorie gegarandeerd &rarr; bepaalde minimale hoeveelheid bandbreedte &amp; buffers

**End-to-end-Diffserv-dienst** leverren &rarr; alle ISP&#39;s tussene eind systemen &rarr; service leveren &amp; samenwerken &amp; afspraken maken &rarr; klant &rarr; gedifferentieerde end-to-end dienst te bieden

##

## 9.5.4 Per verbinding Qos-garanties geven: recources reserveren &amp; streams toelaten

Principe 4:
 Nood aan nieuwe netwerk mechanics en protocollen &rarr; duidelijk wanneer stream gegearandeerde service moet ontvangen zodra gestart is

1. **Recources reserveren** &rarr; enige manier garanderen &rarr; stream beschikken over benodigde recources &rarr; recources gereserveerd &rarr; stream naar behoefte benutten &rarr; gedurende gereserveerde tijd ongeacht behoeften andere streams
2. **Streams toelaten** &rarr; recources gereserveerd &rarr; netwerk mechanisme hebben &rarr; streams verzoeken kunnen richten &rarr; recources niet oneindig &rarr; verzoek stream afgewezen &rarr; als gevraagde recources niet beschikbaar zijn
3. **Signaleren set-up streams**  **&rarr;** toelatingsproces &rarr; stream die QoS nodig heeft &rarr; voldoende recources reserveren &rarr; elke netwerkrouter tussen bron &amp; bestemming &rarr; zeker zijn end-to-end-QoS-eisen hebben &rarr; elke router &rarr; lokale recources voor nieuwe stream nodig zijn berekenen &rarr; bekijken hoeveel beschikbare recources in gebruik zijn &rarr; opgestarte streams &rarr; of bepalen beschikbare per hop &rarr; toereikend QoS-eisen &rarr; honoreren
 Signaliseringsprotocol nodig activiteiten coördineren = **call-setupprotocol**  **&rarr;**  **RSVP-protocol** &rarr; voorgesteld voor dit doel binnen internetarchitectuur (PAGINA 683 AFBEELDING)

## Active vs Passive FTP

### Active FTP

1. Client contacteert server op command poort
2. Server stuurt ACK terug naar client&#39;s commandpoort
3. Server initieert connectie op lokale datapoort &rarr; naar datapoort client eerder aanduidde
4. Client stuurt ACK terug

###

### Passive FTP

1. Client contacteert server op command poort
2. Server antwoord met poort 2024 &rarr; server verteld welke poort luisterd voor data connectie
3. Client initieert data connectie van zijn datapoort &rarr; gespecifieerde data poort
4. Server stuurt ACK terug naar client&#39;s datapoort

Active &rarr; SYN door client
 Passive &rarr; SYN door client