# CN2

* Schriftelijk examen: 66% (theorie, theoretische oefeningen, labokennis)
  * Gesloten boek (deel uit vragenlijst)
  * Open boek (theoretische oefeningen)
* Labo testjes: 33%

[Het boek](https://www.ucg.ac.me/skladiste/blog_44233/objava_64433/fajlovi/Computer%20Networking%20_%20A%20Top%20Down%20Approach,%207th,%20converted.pdf)

# Leerstof

(gewoon de lijst van op ufora)

- [ ] Introductieles
  - [x] Sectie 1.5 Protocollagen en servicemodel 	
  - [ ] Sectie 2.1 Principes van netwerkapplicaties
  - [ ] Sectie 3.2 Multiplexen en demultiplexen
  - [ ] Sectie 6.7 Een dag in het leven van ...
- [ ] [Week 1](#week-1)
  - [ ] Sectie 2.4 DNS 
    - [x] Kennisclip: Resolver
    - [x] Kennisclip: DNS registratie
    - [x] Kennisclip: Reverse DNS (*)
    - [ ] Kennisclip: DNS server (*)
  - [ ] Sectie 2.5 Peer-to-peer bestandsdistributie
    - [x] Kennisclip: What is een DHT? (*)
    - [ ] Kennisclip: Hoe werkt een DHT? (*)
- [ ] [Week 2](#week-2)
  - [ ] Sectie 4.3.3 IPv4 Dynamic Host Configuration Protocol
    - [x] Kennisclip: DHCP
    - [x] Kennisclip: DHCP renewal & relay (*)*
    - [x] Kennisclip: DHCP server (*)
  - [ ] Sectie 4.3.4 Network Address Translation Protocol
    - [x] Kennisclip: Network Address Translation
  - [ ] Sectie 5.6 Internet Control Message Protocol (ICMP)
    - [ ] Kennisclip: Internet Control Message Protocol (*)
- [x] [Week 3](#week-3)
  - [ ] Sectie 6.4 Local-Areanetwerken met switches (herhaling, behalve *)
    - [x] Kennisclip: ARP
    - [x] Kennisclip: ARP cache management (*)
    - [x] Kennisclip: Ethernet switching
    - [x] Kennisclip: VLAN
- [x] [Week 4](#week-4)
  - [ ] Sectie 7.1 - 7.2 Inleiding/Draadloze links en netwerkkenmerken
    - [x] Kennisclip: Introductie tot draadloze netwerke
  - [ ] Sectie 7.3 Wifi: 802.11 draadloze LANs
  - [x] Kennisclip: Draadloze LANs
- [x] [Week 5](#week-5)
  - [ ] Sectie 5.7 Netwerkbeheer en SNMP
    - [x] Kennisclip: Netwerk management
    - [x] Kennisclip: SNMP
    - [x] Kennisclip: Netwerk Automatisering en Ansible
- [ ] [Week 6](#week-6)
  - [ ] IPv6 - pagina's 1 tot 31 (leerstof)
    - [x] Kennisclip: IPv6 address space & notatie
    - [x] Kennisclip: IPv6 address scope
    - [x] Kennisclip: IPv6 ULA scope
    - [x] Kennisclip: IPv6 address type
  - [ ] IPv6 - pagina's 32 tot 35 (achtergrond)
    - [x] Kennisclip: IPv6 header
- [ ] [Week 7](#week-7)
  - [ ] IPv6 - ICMPv6 - pagina's 36 tot 59 (leerstof)
    - [x] Kennisclip: IPv6 address resolution
    - [x] Kennisclip: IPv6 Duplicate Address Detection (DAD)
    - [x] Kennisclip: IPv6 StateLess Address AutoConfiguration (SLAAC)
    - [x] Kennisclip: IPV6 - DHCPv6
  - [ ] IPv6 - Transition to IPv6 - pagina's 60 tot 73 (achtergrond)
    - [x] Kennisclip: IPv6 dual stack v6/v4
    - [x] Kennisclip: IPv6 (only) to an IPv4 network
- [ ] [Week 9](#week-9)
  - [ ] Sectie 5.1 Introductie
    - [x] Kennisclip: Wat is routing
  - [ ] Sectie 5.2 Routeringsalgoritmen
    - [x] Kennisclip: Distance vector routing
  - [ ] Sectie 5.3 Intra-AS routering: OSPF
    - [x] Kennisclip: Link-state routing en OSPF
- [ ] [Week 10](#week-10)
  - [ ] Sectie 1.7
  - [ ] Sectie 5.4 Routing among the ISPs: BGP
    - [ ] Kennisclip: Structuur van het Internet
    - [x] Kennisclip: BGP
- [ ] [Week 11](#week-11)
  - [ ] Sectie 1.6
  - [ ] Sectie 8.9 Firewalls & IDS (leerstof)
    - [x] Kennisclip: Firewall and IDS
- [ ] [Week 12](#week-12)
  - [ ] Sectie 4.4 Gegeneraliseerde forwarding en SDN
  - [ ] Sectie 5.5 Het SDN-controlelevel
    - [x] Kennisclip: SDN	
    - [x] Kennisclip: Netwerkvirtualisatie







# -------------Samenvatting-------------

# Week 1

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

Bij bittorrent worden bestanden opgesplitst in **chunks** van 512KB. Een **torrent** is dan een groep van **peers** (computers) die een bestand delen met elkaar. Een **tracker** is een node die de actieve peers van een torrent bijhoudt. Om een download te starten moeten we dus eerst van de tracker een lijst van peers krijgen. Hiermee kunnen we dan bestanden uitwisselen. Om een bestand te downloaden met bittorrent nemen we de volgende stappen:

* Gebruiker meldt zich aan
* Hij haalt een lijst van peers op voor het gewenste bestand via een tracker
* Nu kan hij chunks uitwisselen met de andere peers

Trackers zijn eigenlijk de bottleneck van het hele gebeuren. Als we het hele systeem willen verkloten moeten we enkel de trackers uitschakelen en niemand kan nog files downloaden. Zijn er alternatieven waar dit niet het geval is?



### Distributed hash table (DHT)

We gebruiken in plaats van een tracker een gedistribueerde hashtabel. We zien **de bestandsnaam en het nummer van de chunk** als **key** en de lijst van **IP-adressen van de trackers** als **value**. De key-value paren van deze hashtabel worden vervolgens verdeeld over verschillende nodes. Elke node krijgt een id. We maken vervolgens een hashfunctie die elke key afbeeldt op een node.

Hier onstaat dan natuurlijk weer een probleem. Wat moeten we doen als we op een id uitkomen die niet hoort bij een node? Dus als niet elke id een overeenkomstige node heeft. 

* We mappen het key-value paar op de eerste node met een id groter dan of gelijk aan de berekende id.
* Nu zetten we de id's in een cirkel, de node met het laagste id is dan de opvolger van de node met het hoogste id

<img src="img/image-20220228170856251.png" alt="image-20220228170856251" style="zoom:50%;" />

**Peer churn** (het constant joinen en leaven van nodes)

Nodes slaan telkens het ip adres van hun opvolger op. Als er een node het netwerk verlaat, moet hij eerst al zijn records aan zijn opvolger geven. Komt er een nieuwe node bij, dan neemt hij een deel van de records van zijn opvolger op. 



# Week 2

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

Er zijn maar $2^{32}$ , oftewel $4.294.967.296$ mogelijke IPv4 adressen. Om dit probleem om te lossen laten we typisch alle toestellen binnen één netwerk hetzelfde IP-adres gebruiken. In het geval van je thuisnetwerk heeft je modem dan enkel een IP-adres. De toestellen binnen je netwerk gebruiken dan een private IP. (192.168.0.22 bijvoorbeeld).



<img src="img/image-20220625155508882.png" alt="image-20220625155508882" style="zoom: 33%;" />

Als je met je computer thuis een pakketje stuurt naar een server buiten je netwerk, zal je router het **source IP-adres vervangen** door zijn **publieke IP-adres**. Hij onthoudt dan jouw IP en de source poort en stuurt het pakketje door naar de server (mogelijks ook via een andere poort). Als hij antwoord krijgt van de server op diezelfde poort weet hij dat hij het pakketje naar jouw pc moet doorsturen.

Dit wordt een beetje moeilijker als het toestel in het private netwerk als webserver wilt fungeren. We zullen moeten doen aan **port-forwarding**. We moeten in onze NAT-router een regel toevoegen in de vertalingstabel die poort 80 mapt met het interne IP-adres. Als het verkeer op poort 80 op het publieke adres van de router wordt dan doorgesluisd naar onze webserver.

Buiten het beperken van het aantal gebruikte IPv4 adressen, werkt NAT dus eigenlijk ook als een soort firewall. We kunnen niet aan de devices binnen het netwerk, zolang er geen NAT-regel is toegevoegd. Dit noemt met net **NAT traversal probleem**. De mogelijke oplossingen voor dit probleem betreffen:

* **Statisch** een regel toevoegen in de tabel (zoals hierboven)
* **UPNP** en **IGD**:
  * Universal Plug and Play: wordt niet uitgelegd in de video
  * Het Internet Gateway Device protocol laat toe om een server in het private netwerk automatisch te laten leren wat het publieke IP-adres is van je NAT-router en **dynamisch** regels toe te voegen die ervoor zorgen dat binnenkomend verkeer op een gegeven poort doorgesluisd wordt naar de server.
* **Relay** 
  * De client initieert een verbinding met een publieke relay server. De andere partij, die mogelijks ook achter NAT zit, doet dit ook. De relay koppelt dan beide verbindingen aan elkaar om communicatie tussenbeide mogelijk te maken. Die is hoe systemen zoals messenger en skype werken.



**Voordelen van NAT**

* **Berperkt** het aantal gebruikte IP-adressen
* IP-adressen in het private netwerk kunnen **wijzigen** zonder invloed op de buitenwereld
* Je kan van ISP veranderen zonder dat de adressen in je lokale netwerk moeten veranderen
* Apparaten binnen je netwerk zijn niet expliciet adresseerbaar, omdat je NAT werkt als een soort firewall. Dit is natuurlijk goed voor **security**

**Nadelen**

* Het gebruik van transportlaagpoorten om pakketten naar het juiste device te krijgen is een inbreuk op het model van verschillende lagen, dit is bovendien enkel mogelijk zo lang er poorten vrij zijn op de NAT-router
* Het NAT-traversal probleem zorgt dat het moeilijker is om servertoepassingen draaiende te krijgen op het private netwerk 
* Applicatieontwikkelaars moeten rekening houden met het feit dat NAT hun toepassingen kan dwarsbomen.



### NAT444

In Aziatische landen kregen sommige ISPs maar één publiek IP-adres, in plaats van een heel adresblok. Hiervoor hebben ze **carrier grade NAT**, oftewel NAT444 bedacht. Hier wordt NAT twee maal achter elkaar gebruikt. In het voorbeeld hieronder krijgen dan de klanten een 'publiek' IP-adres uit de 10.0.0.0/8 range. Hun apparaten krijgen dan een adres uit de 192.168.0.0/16 range.

<img src="img/image-20220625174613647.png" alt="image-20220625174613647" style="zoom: 50%;" />



Hier doen zich twee problemen voor

* De ISP moet erop toezien dat de adressen die de klanten gebruiken niet overlappen met de adressen van de infrastructuur van de ISP.
* Communicatie tussen klantennetwerken volgt niet noodzakelijk het kortste pad, omdat ze altijd de NAT van de ISP moeten gebruiken. 





## ICMP

Of langer: Internet Control Message Protocol

ICMP voorziet diagnosemechanismen voor

* Bereikbaarheid van hosts (`ping`)
  * Of ze aan zijn
  * Round-trip tijd
* Routeringsproblemen (`icmpredirect`)
  * Kijken of bepaalde routes korter kunnen
* Route discovery (`traceroute`)
  * Detecteren wat de tussenliggende hops zijn op een route naar een bepaalde host
* Nog dingen ...



ICMP werkt rechtstreeks bovenop laag 3, bovenop de IP-header en gebruikt dus geen transportlaagprotocol. Er zijn 2 soorten ICMP-berichten:

* Error
* Query-response 



**ICMP redirect**

<img src="img/image-20220625180456796.png" alt="image-20220625180456796" style="zoom:50%;" />

Als wij met onze computer een pakketje willen sturen naar het subnet achter router B, maar enkel A als default gateway hebben, zal het pakketje dus eerst richting router A vertrekken. A ziet dat hij het pakket moet terugsturen op het interface waarop hij het heeft ontvangen en stuurt een ICMP redirect met de correcte gateway naar onze computer. A is lief en stuurt het pakketje de juiste richting uit. Door de ICMP redirect kunnen wij nu onze routeringstabel updaten en zullen toekomstige pakketjes voor het subnet achter router B direct in de juiste richting gestuurd worden.

**Traceroute**

Traceroute maakt gebruik van het TTL veld van IP-pakketjes. Door telkens IP-pakketjes te sturen met een toenemende TTL, zullen de pakketjes één voor een gedropt worden door de verschillende hops naar de bestemming. Als een router een pakketje dropt zal hij een ICMP error: Time Exceeded genereren en die naar ons terugsturen om te laten weten dat het pakketje zijn bestemming niet heeft bereikt. Dit kunnen we dan handig gebruiken om het pad dat onze pakketjes afleggen naar een bepaalde bestemming te achterhalen.

# Week 3

## ARP

In de header van een ip pakketje zit alleen het adres van de verzender en het adres van de bestemming. Hoe weet nu onze router dat het pakketje voor hem bestemd is? Deze vraag zullen we zo meteen beantwoorden.

**Mac adres**

Ook wel het fysisch adres genoemd. We dit adres enkel voor hosts die rechtstreeks met elkaar verbonden zijn. Het MAC adres wordt bepaald door de fabrikant van je netwerkadapter. Hoe kan onze computer nu het mac-adres van de router weten? Daarvoor hebben we dus ARP.

**Eigenschappen **

Arp is plug & play. het werkt dus gewoon direct wanneer je het aanzet. Elke node op het netwerk houdt een **lokale ARP cache** bij met een mapping tussen ARP -en IP-adressen. Als er een IP adres in de lijst staat kan je een **broadcast message** sturen om het bijhorende MAC-adres te verkrijgen. Verder hebben entries in deze tabel ook een **TTL**, en zullen periodiek vernieuwd moeten worden. Ze hebben dus met andere woorden een **soft state**.   

De adresresolutie bij een ontbrekende entry gaat als volgt:

* Host A wilt het MAC-adres van host B te weten komen, maar heeft alleen zijn IP-adres
* Host A doet een ARP request op het netwerk (broadcast) met het IP-adres van host B erin
* Host B ziet dat dit voor hem bestemd is en doet een ARP-reply naar host A, daarin zit dus ook zijn MAC adres



## ARP Cache management

Met `arp -a` kan je alle entries van je ARP cache opvragen. Wil je ze leegmaken doe je met `arp -d -a`. Dit kan nuttig zijn als bepaald verkeer niet bij zijn bestemming geraakt of als er een adres in dubbel gebruik is. Een specifieke entry verwijderen gaat mat `arp -d [ip adres]`. Je kan ook een mapping vastleggen die niet uit de tabel mag gehaald worden met ` arp -s [ip adres] [mac adres]`. Dit kan nuttig zijn als je het ARP-verkeer op je netwerk wilt reduceren.



## Ethernet switching

Verschil tussen een switch en een hub

* Een hub is een **passieve repeater** die ervoor zorgt dat het lijkt alsof alle toesten die erop aangesloten zijn op hetzelfde gedeelde medium zijn aangesloten. 
* Een switch is een stuk slimmer. Hij kijkt effectief naar de pakketjes en stuurt ze bijvoorbeeld alleen op de nodige aansluitingen door.

**Ethernet switch**

Een switch is een actief **store-and-forward** toestel. Hij ontvangt frames, slaat ze op in een buffer, doet een lookup in een MAC-forwarding tabel en stuurt ze door. Hij lijkt een beetje op een router, maar op laag 2. Switches werken **transparant**. Dit betekent dat hosts niet weten dat hun verkeer door een switch gaat. 

Waar hubs het **collision-domain** uitbreiden, spitsen switches het op in verschillende segmenten. Frames worden dus niet zomaar doorgestuurd naar elke poort zoals bij een hub. 

Hoe weet een switch nu naar waar hij de pakketjes moet forwarden. Dit kan met een combinatie van 3 technieken:

* **Flooding**
* **Spanning tree protocol**
* **Mac-based forwarding & learning**

Bij **flooding** zal de switch het pakket doorsturen op alle andere poorten buiten de poort waar het pakket vandaan kwam. Dit is natuurlijk niet zo efficiënt. Je hoeft wel niets te configureren. Er kunnen zich ook **lussen** voordoen (zie afbeelding).

<img src="img/image-20220623223507072.png" alt="image-20220623223507072" style="zoom:50%;" />

Om dit te voorkomen gebruiken we het **spanning tree protocol**. Dit protocol zorgt ervoor dat er automatisch poorten geblokkeerd worden om loops te voorkomen. De configuratie hiervan verloopt in 4 stappen

1. Alle poorten beginnen in **blocking mode**
2. Een **root switch** wordt geselecteerd
3. Er wordt een minimale boomstructuur op basis van de kortste padkosten opgesteld, naar de geselecteerde root-node
4. Poorten zullen hun toestand veranderen naar forwarding mode op basis van de spanning tree 

Om te bepalen welke switch de root bridge wordt kan je prioriteiten instellen, als je dat niet doet wordt de switch met het laagste MAC-adres gekozen. 

// todo misschien iets dieper ingaan op de werking



**MAC-based forwarding & learning**

Iedere switch heeft een **switch forwarding table**. Hier staat naar welke poort hij pakketjes voor een bepaald MAC-adres moet sturen. De switch leert automatisch op basis van het netwerkverkeer naar waar elk pakketje moet door de afzender en zijn locatie in de tabel te noteren bij passerende pakketjes. 



## VLAN

VLAN, oftewel **virtual LAN** voorziet een mechanisme om een LAN netwerk in meerdere logische netwerken op te splitsen, gebruik makende van dezelfde hardware. De netwerken gedragen zich alsof ze fysiek ontkoppeld zijn. Ten gevolge zullen de flooding en mac-learning processen van de switches gescheiden verlopen in de verschillende VLANs.

Er zijn meerdere soorten VLANs:

* **Port-based**: de poort van een switch wordt toegewezen aan een VLAN.
* **Tag-based**: er wordt op basis van een veld in pakketjes in het netwerk aangegeven tot welke VLAN zij behoren.
* **Protocol-based**: een VLAN per protocol (ICMP, IP, multicast, ...)
* **Host-based**: VLAN per host/MAC

**Port-based vlan**

Poorten van switches kunnen enkel met elkaar communiceren indien ze zich bevinden in de zelfde VLAN. Je hebt dus een aparte link nodig per VLAN. Ook al verbinden die links dezelfde switches.

**Tag-based vlan**

Het vorige probleem wordt hier opgelost. We steken in elk ethernet frame ook een **tag-veld**, waardoor **vlan-aware** switches hun forwarding gedrag aan kunnen passen aan de inhoud van de tag. Ik ga hier niet verder op ingaan als je niet weet hoe VLANs werken ben je echt een loser.







# Week 4

## Draadloze netwerken (introductie)

Hoe hoger je in frequentie gaat, hoe hoger de mogelijke bandbreedte. Spijtig genoeg zijn hogere frequenties gevoeliger aan interferentie en kunnen zij dus enkel op kleinere schaal gebruikt worden. 

Belangrijkste verschillen met een bekabelde link:

* Een radiosignaal **verzwakt** wanneer het zich door materie propageert (path loss)
* Andere toestellen in het radiospectrum zorgen voor **interferentie**
* Een radiogolf kan zich via **meerdere paden** verspreiden (door reflecties)

Deze zaken maken het natuurlijk moeilijk om een betrouwbaar draadloos netwerk op te stellen. We kunnen aan de hand van 2 metrieken de kwaliteit van onze draadloze link meten. 

* signal-to-noise ratio (SNR)
  * Geeft aan hoe sterk je signaal is ten opzichte van de gemeten ruis, liefst zo hoog mogelijk dus.
* bit-error-rate (BER)
  * Hoeveel van de ontvangen bits foutief blijken te zijn

Je kan door de sterkte van je signaal te verhogen de SNR hoger krijgen. Dit is natuurlijk niet altijd mogelijk (apparaten met batterijen). 



**Elementen**

* Draadloze hosts (gsm, laptop)
* Base station (zendmast, access point)
  * Geeft ons draadloos toegang tot een bedraad netwerk
  * Heeft typisch een cell/area die binnen zijn bereik ligt
* Wireless link
  * Gebruikt om de hosts met de base station te verbinden

**Complicaties**

* Hidden terminal problem
  * ![image-20220624103501335](img/image-20220624103501335.png) 
  * Als A en C op hetzelfde kanaal zitten, maar elkaar niet kunnen horen door mount everest, kan er zich veel interferentie voordoen bij B
* Signal attenuation
  * ![image-20220624103805281](img/image-20220624103805281.png) 
  * Opnieuw, A en C kunnen elkaar niet horen door de afnemende sterkte van het signaal. Hierdoor kan er zich interferentie voordoen in B

**Modes**

In de context van draadloze netwerken spreken we vaak over twee modes.  

* **Infrastructure mode**: toestellen maken altijd via een base station verbinding met het netwerk.
* **Ad hoc mode**: toestellen communiceren met elkaar zonder het gebruik van base stations. Ze organiseren zichzelf tot een netwerk.  

 

## 802.11 LAN 

![image-20220624104954581](img/image-20220624104954581.png)

In het 2.4 GHz spectrum overlappen aanliggende kanalen, en zal je voor aanliggende WiFi netwerken kanalen moeten kiezen die minstens 4 kanalen van elkaar verwijderd zijn. Bij 5 GHz overlappen de mogelijke kanalen niet.



Het verbinden van een een toestel met een WiFi netwerk wordt **associatie** genoemd. Dit verloopt in enkele stappen.

* De host moet scannen naar **beacon frames**, deze bevatten de naam, Service Set Identifier (SSID) en MAC adres van het access point
* De host **kiest** een access point waarmee hij wilt verbinden
* Nu moet de host zich mogelijks **authenticeren** (MAC-based, username/pass, shared key)
* Nu heb je verbinding en kan er een DHCP proces in gang gezet worden 

Deze manier van werken noemt met ook wel **passieve scanning**. Je kan ook doen aan **actieve scanning**. Dan zal de host in plaats van te wachten op een beacon frame, zelf een **probe request** sturen, waarop access points dan kunnen antwoorden met een **probe** response. 



**Shared key authentication**

Wanneer een host wilt associëren met een met shared key encryption beveiligd netwerk, zal het netwerk typisch een **challenge text** sturen. De host moet deze dan encrypteren met de shared key om te bewijzen dat hij hem kent. Dan pas wordt hem de toegang tot het netwerk verleend. Er zijn 3 bekende protocollen om dit mee te doen.

* WEP (wired equivalent protocol)
  * Onveilig, keys zijn maar 40 bits lang
* WPA (WiFi protected access)
  * Gebruikt periodiek nieuwe encryptiesleutels per client
  * TKIP (temporal key integrity protocol)
* WPA2
  * uitbreiding op WPA met ondersteuning van Ad Hoc netwerken. Gebruikt AES i.p.v. RC4 encryptie.



**Multiple access**

Botsingen kunnen zich voordoen net zoals op bedraadde netwerken. We hebben dus CSMA nodig om botsingen te vermijden.  Alle nodes zullen dus eerst luisteren of het medium vrij is, en dan pas starten met de transmissie van hun berichten. 

**CSMA/CA**

(carrier sense multiple access / collision avoidance)



**Channel reservatie**

<img src="img/image-20220624121039153.png" alt="image-20220624121039153" style="zoom:50%;" />

Een zender kan het kanaal 'reserveren' om een groter dataframe te versturen. Dit doet hij door middel van een **request-to-send** (RTS) pakketje. De base station zal dan een **clear-to-send** (CTS) broadcasten als dit mag. Zo weten de andere nodes ook dat ze moeten wachten. De RTS en CTS frames kunnen natuurlijk ook botsen, maar doordat ze zo klein zijn is die kans minimaal.

 

**IEEE Ethernet standards**

<img src="img/image-20220624121129015.png" alt="image-20220624121129015" style="zoom:50%;" />

De IEEE heeft de datalinklaag eigenlijk in twee sublagen gesplitst. 

* De Logical Link Control layer voorziet flow control en mechanismen om bovenliggende lagen te multiplexen. Het voorziet dus een manier om bijvoorbeeld ip-pakketten te transporteren.
* Mac Layer voorziet addressering en MAC-protocollen zoals CSMA



**802.11 Frame**

De 802.11 frames hebben wat extra velden in vergelijking met de 802.3 frames

<img src="img/image-20220624121547498.png" alt="image-20220624121547498" style="zoom:67%;" />

De belangrijkste wijzigingen zijn:

* Duration: geeft het tijdsslot in ms voor het RTS/CTS gebaseerde reservatiesysteem

* Seq control: zodat getracked kan worden welke frames wel of niet aangekomen zijn

* Frame control: vlaggen om het type van het frame aan te geven

  * To AP/from AP geven aan of de frames van/naar het access point worden gestuurd

* De 4 adresvelden 

  * Hoe deze worden gebruikt hangt af van de To AP/From AP velden
  * <img src="img/image-20220624122141425.png" alt="image-20220624122141425" style="zoom: 67%;" /> 
  * <img src="img/image-20220624123020353.png" alt="image-20220624123020353" style="zoom:33%;" /> 

  * To AP en from AP beide nul:
    * We zitten sowieso in een ad-hoc netwerken kunnen de eerste twee adressen gebruiken als bron- en bestemmingsadres. Als derde adres gebruiken we een BSSID waarde die is afgesproken tussen de verschillende nodes

  * To AP staat op 1: 
    * De node wenst een frame te sturen naar het AP op weg naar een laag 3 bestemming van het pakket. Het MAC adress van de AP zal in adres 1 gestoken worden en het bestemmingsadres in adres 3.
  * From AP staat op 1:
    * Het omgekeerde van het vorige geval
  * Beide op 1
    * Als twee AP's draadloos met elkaar verbinding maken in een wireless mesh network



**Optimalisaties**

* Rate adaptation
  * Het access point zal op basis van de SNR en de BER proberen om een sweetspot te vinden door de transmissiesnelheid en redundantie in de pakketjes te veranderen. 
*  Power management
  * Nodes kunnen om stroom te sparen aangeven dat ze zullen 'slapen' tot het volgende beacon frame. Dan weet de AP dat hij tot dan geen pakketjes moet sturen naar deze node. De node zal dan vlak voor de volgende beacon frame 'wakker worden' en zal de AP vervolgens hem de gebufferde frames bezorgen.





# Week 5

## Network management

Een netwerk beheerd tot dezelfde partij wordt ook wel een **autonoom systeem** genoemd. In netwerken op grote schaal is het moeilijk om alles in de gaten te houden. Hoe doen we dit? 

Volgens FCAPS

* **F**ault management: fouten loggen, detecteren en opsporen
* **C**onfiguration management: het bijhouden van een inventaris van toestellen en de configuratie ervan
* **A**ccounting management: gebruikersprofielen bepalen en per profiel instellingen voorzien voor rechten, quota, toegang, ...
* **P**erformance management: bandbreedte, delay, worden bij ISPs in SLAs vastgelegd
* **S**ecurity management: bv Firewalls



Bij netwerkbeheer maken we onderscheid tussen 2 zaken

* Network elements (NA) (bv. routers, switches, ...)
  * Bevat een management agent (MA)
  * Zijn verantwoordelijk voor een aantal network management objects (NMO), zaken die gemonitord of geconfigureerd moeten worden
  * Een route op een router is een voorbeeld van een network management object
* Network management station (NMS)
  * Interageert met de agents van de verschillende netwerktoestellen
  * Bevindt zich meestal in een controlekamer
  * Draait network management applications (NMA)

 

## SNMP

SNMP bestaat uit 4 cruciale onderdelen

* Management information base (MiB)
  * Een datastructuur, verspreid over de verschillende netwerkelementen die alle managementdata bijhoudt
* Structure of management information (SMI)
  * Dit is de structuur die alle MiB objecten moeten volgen
* SNMP protocol
  * Connectieloos protocol om deze informatie door te geven
* Security, administration capabilities
  * toegevoegd in SNMPv3



**MiB**

Er zijn een heleboel MIB objecten gedefineerd, van een eenvoudige parameter zoals de hostname van een gegeven node, tot UDP statistieken die door een node bijgehouden kunnen worden.

MiB's worden gestructureerd in een soort boomstructuur. Dit is redelijk obvious dus ik hou de uitleg kort.

<img src="img/image-20220624154610311.png" alt="image-20220624154610311" style="zoom:50%;" />

<img src="img/image-20220624154631679.png" alt="image-20220624154631679" style="zoom:50%;" />

Dit nummertje is dus het pad van de root tot een leaf. 

**SMI**

Voor ieder soort managementobject in de boomstructuur moet vastgelegd worden over welk soort data het precies gaat. Hiervoor gebruiken we de SMI als **data definition language**. 



### Het SNMP protocol

Om deze MIB info nu effectief door te kunnen geven in ons netwerk, gebruiken we het SNMP protocol. Dit protocol is connectieloos en maakt onderliggend gebruik van UDP.

Het werkt in twee modussen

* Request/response mode
  * Het management apparaat (NMS) stuurt een request naar een bepaalde MIB van een beheerd apparaat, deze stuurt dan een antwoord
* Trap mode
  * Beheerde apparaten sturen automatisch trap messages. Zo moet de NMS niet constant requests sturen. 

Soorten SNMP messages:

<img src="img/image-20220624162043982.png" alt="image-20220624162043982" style="zoom:50%;" />

Doordat de MiB's voor configuratie bij veel apparaten verschillend zijn, wordt SNMP niet zo veel gebruikt voor configuratie. Het wordt eigenlijk vooral gebruikt voor monitoring.



**Security**

SNMP berichten kunnen sinds SNMPv3 nu ook geëncrypteerd worden. Er werden ook authenticatiemogelijkheden toegevoegd.



### Net-SNMP

//todo



## Ansible

Ansible kan zowel gebruikt worden om tests uit te voeren, alsook een gehele netwerkconfiguratie uit te rollen. Zo kan je bijvoorbeeld met Ansible automatisch nieuwe virtuele machines opstarten wanneer de load op je netwerk toeneemt. Ansible zelf is een python applicatie die bepaalde playbooks kan uitvoeren. 

Ansible kan werken in twee modes

* Local execution mode
  * De playbooks worden uitgevoerd vanop een controller of een network management node, deze zullen dan remote nodes aansturen gebruik makende van protocollen zoals SNMP
* Remote execution mode
  * Alle Ansible logica wordt gekopiëerd naar specifieke nodes om daar uitgevoerd te worden. 

**Use cases**

Een paar nuttige dingen waarvoor je Ansible kan gebruiken

<img src="img/image-20220624163138394.png" alt="image-20220624163138394" style="zoom:50%;" /> 



**Onderdelen**

<img src="img/image-20220624163257967.png" alt="image-20220624163257967" style="zoom:50%;" />

* CMDB (configuration management database)
  * Houdt alle configuratie op een version-control manier bij
* Devices
  * Deze wensen we te beheren of aan te sturen
* Users
  * De mensen die aan de hand van playbooks de devices aansturen
* Ansible automation engine
  * Verwerkt playbooks en interageert op basis daarvan met de devices
  * Bevat een lijst van devices die hij moet beheren
  * Ook een command line interface
  * De basisfunctionaliteit van Ansible kan uitgebreid worden met plugins
  * Via de modules kan hij met verschillende remote systemen interageren



**Playbooks **

Een Ansible playbook bestaat uit verschillende onderdelen

<img src="img/image-20220624163815105.png" alt="image-20220624163815105" style="zoom:50%;" />

Iedere **play** omvat een lijst van **tasks** die op een bepaalde host uitgevoerd moeten worden. Een task is een call naar een bepaalde Ansible **module**. Dit kan je zien als een functie die kan uitgevoerd worden. 



**Wat maakt Ansible interessant?**

* Agent-less
  * Je hoeft niets te installeren op je netwerkapparatuur, ansible kan zelf uitgebreid worden aan de hand van modules die met verschillende types devices kunnen samenwerken
* Templates
  * Je kan makkelijke eenzelfde taak generaliseren voor veel verschillende apparaten van hetzelfde type
  * Dit kan je met de jinja2 templatetaal
* Modules zijn zo opgesteld dat ze de beheerder dwingen om te definiëren wat de gewenste eindtoestand is, eerder dan wat het recept is om bij die eindtoestand te geraken. Deze **declaratieve** aanpak zorgt ervoor dat de logica in de module zelf geïplementeerd wordt, en gebruiker hiervan af te schermen.
  * Als dezelfde taak meerdere keren wordt uitgevoerd, moet hij elke keer hetzelfde resultaat geven = **idempotente uitvoering**



 **Workflow in ansible**

1. Maak een inventory file en zet je apparaten erin
2. Maak een playbook
   * Deze bevat dan de bepaalde taak die je wilt uitvoeren, gebruik makende van een bepaalde module.
3. De playbook uitvoeren

# Week 6

## IPv6

Een IPv6 bestaat uit twee delen:

* Eerste 64 bits: (sub-)netwerkprefix
* Laatste 64 bits: interface identifier (IID)

Je kan een IPv6 adres noteren volgens een paar regels

* Nullen aan het begin van elk hextet mag je weglaten
* Opeenvolgende nullen mag je éénmalig vervangen door `::`
* Wil je een poortnummer achter je adres zetten, moet je het adres tussen brackets `[]` zetten 



**Interface identifier**

De IID van een apparaat bepalen kan je op verschillende manieren:

* Je hem afleiden van het MAC-adres van de host volgens EUI-64, door `ff:fe` in het midden te stoppen en de 7de bit te flippen.
  * <img src="img/image-20220624171257896.png" alt="image-20220624171257896" style="zoom:50%;" /> 
  * Yeey nu ben je wereldwijd traceerbaar
* Je kan je IID ook randomizen



### Address scope

Een interface heeft typisch **meerdere** IPv6 adressen. Zo kan een host bijvoorbeeld een **lokaal** en een **globaal** IPv6 adres hebben.  De scope bepaalt dan tot **waar** het adres geldig is en wat dan precies het type van dat adres is (unicast multicast, ...). Hier een overzicht van alle soorten IPv6 adressen

* Link-local
  * Prefix `FE80::/10`
  * Typisch doe je eerder `FE80/64`, maar ze gaan je op het examen sowieso proberen te foppen hiermee
  * Dit adres wordt automatisch gegenereerd zonder hulp van een centrale server
* Global unicast
  * Prefix `2000::/3`
  * Dit adres is globaal routeerbaar
  * Worden niet zomaar toegekend, als bedrijf kan je een prefix van /48 aanvragen, dan heb je nog 16 bit
  * Een RIR krijgt typisch een /12 of /23, de routering is dus mooi gestructureerd over de hele wereld
  * Deze geeft dan een /32 blok aan een ISP
* Unique local address scope
  * Prefix `FC00::/7`
  * Als je twee kleine netwerkjes hebt die je naar elkaar wilt kunnen routeren volstaan link-local adressen niet. Als je niet verbonden bent met een ISP kan je geen globale adressen gebruiken
  * Eigenlijk gebruiken ze nu enkel `FD00::/8`, om `FC00::/8` vrij te houden voor toekomstig gebruik
  * De prefix van /48 wordt pseudo-random gegenereerd, de eerste 8 bits van de prefix zijn dus `FD` en de resterende 40 zijn random. Hier kan je nu zelf subnets van maken.
  * De IID kan je bijvoorbeeld manueel toekennen



### Address types

* Unicast
  * Alle adressen hierboven zijn unicast
  * voor 1-op-1 communicatie
* Multicast
  * Prefix `FF00::/8`
  * Om meerdere apparaten aan te spreken
  * One-to-many
  * Heeft een aantal bits om aan te geven wat de groep is die hij beschrijft (4 flag bits, 4 scope bits)
  * `FF02::1` betekent alle nodes binnen het LAN, is gelijkaardig aan broadcast, want echte broadcast if afgeschaft. Het is eigenlijk niet de bedoeling dat dit gebruikt wordt.
  * Apparaten kunnen zich 'abonneren' op bepaalde multicast adressen
* Anycast
  * One-to nearest
  * Dus de dichtstbijzijnde
  * Je dit bijvoorbeeld gebruiken voor DNS servers
  * Zorgt wel voor problemen met TCP verbindingen. Als je wisselt van nodes tijdens de verbinding is alles genaaid.

Doordat broadcast is afgeschaft is `FFFF:FFFF:FFFF:FFFF` een geldig adres. Een adres met allemaal nullen dus ook.



# Week 7

## IPv6 Adresresolutie

Bij IPv4 gebruikte de adresresolutie met een apart protocol: ARP. Bij IPv6 zit dit echter ingebouwd. In tegenstelling tot IPv4 wordt er geen broadcast, maar multicast gebruikt. Hiervoor gebruiken we het **solicited-node** multicast adres. 

* Solicited node adres
  * Prefix `FF02::1:FF00:0/104` + de laatste 24 bits van het unicast adres
  * Als je een unicast adres configureert op een computer schrijft hij zich automatisch in op deze multicast groep
  * Er wordt ook een multicast adres op laag 2 aangemaakt



Stel je voor dat host A het fysieke adres van host B wilt krijgen. Hoe verloopt deze adresresolutie nu dan precies? 

* A stuurt een **Neighbor Solicitation** naar het solicited node multicast adres van host B. 
* Nu antwoordt B met en unicast **Neighbor Advertisement** bericht, deze bevat zijn fysieke adres
* Host A slaat dit adres nu op in zijn **Neighbor Cache** (gelijkaardig aan een ARP table)

Wat als er toevallig twee apparaten op hetzelfde solicited node multicast adres ingeschreven zijn? Op de applicatielaag zal het apparaat waarvoor het bericht niet bestemd is zien dat het gevraagde adres niet overeenkomt met die van hem en dus niet antwoorden.



## Duplicate Address Detection (DAD)

* Genereer een nieuw adres
* Neem dit adres tijdelijk aan (tentative, dus je kan het nog niet als source adres gebruiken)
* Stuur een neighbor solicitation op het netwerk
* Als het al in gebruik is zal er iemand antwoorden, dan markeer je het adres als duplicate en gebruik je het niet
* Als niemand antwoord, kan je het adres definitief gebruiken (preferred)

Als er al een node was die het adres had, zal deze antwoorden op het `FF02::1` all nodes on link-local network adres, want anders kan dit bericht nooit aankomen bij de afzender van de neighbor solicitation. Normaal gezien is dit ook de enige keer dat dit adres gebruikt zou worden.



##  SLAAC

(StateLess Address AutoConfiguration)



Het Neighbor Discovery Protocol definieert 5 types ICMPv6 pakketten:

* Neighbor sollicitation
* Neighbor advertisement
  * Voor link-layer address resolution en DAD
* Router Solicitation (RS)
* Router Advertisement (RA)
  * Address Autoconfiguration (dit gaan we dus doen)
  * Router discovery
* Redirect message

We willen met een minimale configuratie, zonder DHCP server onze apparaten globale IP-adressen kunnen geven. Dit kunnen we met SLAAC volgens de volgende stappen

1. Een **link-local adres genereren**
   * Dit hebben we nodig om met de router te kunnen praten, we doen in deze stap alle stappen van het vorige hoofdstuk (DAD)
2. We doen een **Router Solicitation**
   * Naar het all-routers multicast adres `FF02::2`
   * Dan antwoordt de router met een **Router Advertisement** naar `FF02::1` (deze bevat geen DNS info)
   * Nu kan je de prefix van de router nemen en er een eigen gegenereerde IID aanplakken
   * Nu moet je weer DAD doen om te verifiëren dat dit adres uniek is binnen je netwerk
   * Nu weet je ook de default gateway, want dit is de router die op je solicitation heeft geantwoord



## DHCPv6

Een DHCP server is niet noodzakelijk in een IPv6 netwerk. We kunnen het nog steeds doen als we dat willen, om bijvoorbeeld DNS informatie te verspreiden, want dit zit niet standaard in de router advertisements bij SLAAC. 

Als SLAAC heeft plaatsgevonden kan er in de router advertisement een flag aangezet worden die aangeeft dat er ook een DHCP server aanwezig is. Als deze aanstaat weten we dat we nadien ook op zoek moeten gaan naar een DHCPv6 server in het netwerk. Deze server zal dan extra informatie aanbieden waaronder DNS en NTP informatie.

Je kan DHCPv6 op twee manieren gebruiken:

* Stateless: bovenop de stateless adressen gegenereerd door SLAAC geeft de DHCP-server extra informatie (DNS, NTP, ...), zonder bij te houden aan wie hij die informatie allemaal heeft uitgedeeld
* Stateful: de server gaat effectief managen in het netwerk zoals bij een klassieke DHCP server. Hij gaat ook adressen uitdelen en houdt bij wie welk adres heeft ontvangen.

Bij een stateful DHCPv6 server zullen de volgende pakketjes uitgewisseld worden, analoog aan DHCP bij IPv4:

* Solicit (DHCPDISCOVER bij IPv4)
* Advertise (DHCPOFFER bij IPv4)
* Request (DHCPREQUEST bij IPv4)
* Reply (DHCPACK bij IPv4)



## Dual Stack

Hoe kunnen we nu IPv6 gebruiken in een wereld waar alles op IPv4 draait?

Je computer heeft zowel een IPv4 als een IPv6 adres. Als je dus surft naar een website die IPv6 gebruikt, zal je computer het IPv6 adres gebruiken. Dankzij Dual Stack kunnen we IPv6 geleidelijk aan invoeren. Het probleem is nu natuurlijk dat we veel dubbel werk moeten doen. 

Zo wordt er bij DNS het AAAA record toegevoegd om IPv6 adressen te ondersteunen. Nu zal je de reverse zone wel helemaal opnieuw moeten opbouwen. Dual-stack apparaten vragen dus naar het A record en het AAAA record en kan dan in principe kiezen welke hij gebruikt. 



## IPv6 only to IPv4

Wat als we nu een netwerk hebben dat alleen nog maar IPv6 gebruikt? Hoe kan dit netwerk nu communiceren met het internet dat nog steeds grotendeels op IPv4 draait? We moeten een oplossing, soortgelijk aan NAT gebruiken. Dit noemen ze NAT64 (NAT 6 to 4).

De IPv6 payload wordt geplaatst in een IPv4 pakketje. Dit is natuurlijk wel moeilijk schaalbaar, want je moet een tabel bijhouden van alle mappings.



Neem het volgende voorbeeld. We willen met ons IPv6 only apparaat een request doen naar minerva.ugent.be. Deze server draait enkel IPv4. 

<img src="img/image-20220624212056172.png" alt="image-20220624212056172" style="zoom:50%;" />

Als je van je IPv6 client een DNS query doet, kan je alleen vragen naar een AAAA record. Als jouw DNS server dit doorstuurt naar een gewone DNS server, zal hij spijtig genoeg geen antwoord krijgen. Je DNS server zal dan een gewone query moeten doen en het antwoord (een A record) inpakken in een IPv6 pakketje met een AAAA record. Hiervoor wordt een specifieke prefix gebruikt.

<img src="img/image-20220624212659560.png" alt="image-20220624212659560" style="zoom:50%;" />

Als jij nu een request wilt sturen naar de server, zal je het IPv4 adres van de server moet en prefixen met de Well-known NAT64 prefix. Op het moment dat het pakketje de router bereikt op de rand van je IPv6 netwerk, zal hij een entry moeten toevoegen (nat zoals bij NAT) waarin jouw IPv6 adres gemapt wordt op een IPv4 adres. Deze router zal dan een IPv4 verbinding opzetten met de server.

# Week 9

## Wat is routing?

Routing is het proces dat gebruikt wordt door routers om te bepalen welk pad moet genomen worden naar een gegeven bestemming. Hiervoor kunnen ze gebruikmaken van gecentraliseerde of gedistribueerde algoritmen om de kortste route of de kleinste afstand te bepalen tussen het begin en eindnetwerk.

Om deze routes te kunnen vinden, moeten routers informatie met elkaar uitwisselen volgens een bepaald protocol, en dan met een bepaald algoritme het pad naar elke bestemming berekenen. Het is natuurlijk niet mogelijk elke router in het internet met elke andere router in het internet informatie uit te laten wisselen. Daarom is het internet georganiseerd in autonome systemen.

Een **autonoom systeem** is netwerk van routers dat beheerd wordt door dezelfde instantie. Dit kunnen grote bedrijven zijn zoals ISPs of organisaties zoals Belnet. Hierdoor ontstaat er een hiërarchisch systeem van routering. We gebruiken dan twee soorten protocollen:

* **Intra-AS** routeringsprotocollen tussen routers van dezelfde autonome systemen
* **Inter-AS** routeringsprotocollen tussen routers van verschillende autonome systemen



Routers kunnen verschillende types informatie uitwisselen om routes te berekenen:

* **Link-states**
  * Bv. Er is een link van A naar B met kost x
  * **Link-state** protocollen (OSPF, IS-IS)
* **Afstanden** naar bepaalde bestemmingen
  * Bv. Node C kan node D bereiken met afstand y
  * **Distance-Vector** protocollen
* **Paden** naar bepaalde bestemmingen
  * Bv. Node E kan node F bereiken via [G,H,I,J]
  * **Path-Vector** protocollen

Binnen AS'en wordt er het meeste gebruik gemaakt van link-state protocollen. Voor inter-AS routering wordt vrijwel alleen BGP gebruikt.



## Distance Vector Routing

Bij distance-vector routerings houdt iedere router een vector bij met de afstanden naar alle routers in het netwerk. Elke link tussen twee routers krijgt een bepaalde 'afstand'

1. De vector wordt binnen de router geïnitialiseerd met enkel de afstand naar zichzelf. (nul dus)
2. Elke router gaat zijn distance vector adverteren naar zijn buren
3. Gegeven de ontvangen distance vectors gaat elke router nu zijn eigen distance vector updaten
   * Nieuwe bestemmingen worden gewoon toegevoegd in de vector
   * Als hij een bestemming binnenkrijgt die hij al heeft, neemt hij de kortste. Als de nieuwe afstand plus de afstand tot de node van wie hij die heeft gekregen kleiner is dan de afstand die hij al had, kiest hij dus het nieuwe pad.

Dit proces wordt voortdurend herhaald zodat uiteindelijk de paden convergeren.



**Count to infinity**

Er doet zich wel een probleem voor bij deze manier van routes vinden. Goed nieuws verspreid zich snel, maar slecht nieuws trager. Als er een sneller pad opduikt, zullen routers dit snel oppikken en zal er sneller geconvergeerd worden naar dit snellere pad. Als de kost van een link plots verhoogt, zal het echter zeer lang duren voordat routers dit doorhebben.

Aanschouw onderstaand afbeeldsel.

<img src="img/image-20220624224749715.png" alt="image-20220624224749715" style="zoom:50%;" />

De link tussen C en B verhoogt in kost. C zal zijn distance vector updaten en neemt het kortste pad (naar B) over van A, met kost 5. Het probleem is dat het kortste pad van A naar B ook via C ging. C neemt dit foute pad over, telt er 1 bij op en zet het in zijn distance vector. Dit proces blijft zich herhalen tot we aan 50 komen en C eindelijk door gaat hebben dat het kortste pad naar B via A loopt.

Hoe lossen we dit probleem op?

* Split horizon: geef nooit de distance aan een buur voor een bestemming die gebruik maakt van die buur
* Poisoned reverse: geef wel de distance aan een buur voor een bestemming die gebruik maakt van die buur, maar zet die op oneindig.

### RIP 

RIP is een simpel routeringsprotocol, gemakkelijk te gebruiken in kleine netwerken. De afstandsmetriek die wordt gebruikt is een simpele **hop count**, in plaats van een link kost. Elke advertisement kan maximum een lijst van afstanden naar 25 subnetten bevatten. Routers wisselen elke 30 distance vectors distance vectors uit met hun buren. Als een router langer dan 180 seconden niets van zich laat weten, wordt hij dood verklaard en worden alle routes via hem ongeldig verklaard.



## Link State routing

Distance vector protocollen zijn in staat om kortste paden te gebruiken naar gegeven bestemmingen zonder dat individuele nodes beschikken over de route naar die bestemming. Ze houden enkel vectoren bij met de afstanden naar die bestemmingen en hebben geen inzicht in de topologie van het netwerk.

Link-state routeringsprotocollen hebben kennis van de **volledige topologie** van het netwerk en bekomen dit door de uitwisseling van **link-states**. Dit verloopt in de volgende stappen.

* Elke router maakt een lijst van de links waarmee hij verbonden is, bij elke link hoort ook een state. In dit geval zullen we de hop count nemen als state.
* Elke router stuurt zijn lijst met link states door naar zijn buren. Die buren gaan dan op hun beurt die link states doorsturen (ook wel **flooden** genoemd) naar de rest van het netwerk. Om te voorkomen dat die link states oneindig blijven rondgestuurd worden, maken we gebruik van **sequence numbers**. Link states afkomstig van dezelfde bron en een zelfde of ouder sequence number hebben, zullen genegeerd worden.
* Elke router kan nu dankzij de bekomen informatie zijn **link state database** vullen. Vervolgens kan hij een volledige kaart van de netwerktopologie opbouwen en met het algoritme van Dijkstra de kortste paden berekenen.
* Met deze informatie kan onze router nu zijn **routing table** opstellen.

Belangrijk is dat elke router in ons netwerk beschikt over dezelfde topologie-informatie en gebruik maakt van hetzelfde kortste-pad-algoritme. Als er een link wegvalt is het dus mogelijk dat door inconsistenties in de topologie-informatie er zich tijdelijk (voor enkele seconden) lussen voordoen. 



### OSPF

Link state routeringsprotocollen zijn de **eerste keus** voor grote netwerken van één autonoom systeem. Ze hebben **geen count-to-infinity** probleem en convergeren over het algemeen heel erg snel. Het nadeel is dat ze **meer computationeel vermogen** van de individuele routers vergen.

Open Shortest Path First is één van de voornaamste link state routeringsprotocollen. Het ondersteunt zowel IPv4 als IPv6 en er zijn veel open-source implementaties beschikbaar. OSPF maakt gebruik van **advertisements** om link states te verspreiden. Die worden gebundeld per bronrouter en geflood over het hele netwerk. Links zijn **niet alleen links tussen routers**, maar ook links van routers naar andere **stub-netwerken** waartoe ze toegang geven.

OSPF heeft een aantal eigenschappen die het aantrekkelijk maken voor grote bedrijven:

* **Security**: OSPF berichten kunnen geauthentificeerd worden, zodat stoute mensen niet zomaar link-state berichten kunnen verspreiden.
* **Multiple same-cost paths**: als er meerdere korste paden zijn, kunnen die geconfigureerd worden in de forwarding tabel (als dit ondersteund is door de router natuurlijk)
* **Integrated uni- and multicast support**: OSPF kan dus ook multicast routeren
* **Hierarchical OSPF**: OSPF kan gebruik maken van areas en een hiërarchie om het protocol schaalbaarder te maken.



**Hierarchical OSPF**

Bij grote netwerken heb je natuurlijk veel overhead door constante updates van link states, omdat bij elke update onze routers hun kortste paden moeten herberekenen. Om dit te voorkomen kan je je netwerk opdelen in hiërarchische areas om het protocol beter te laten schalen. Iedere area gaat alleen link state informatie verspreiden binnen zichzelf. De korste paden worden dus enkel berekend binnen elke area

<img src="img/image-20220625114205298.png" alt="image-20220625114205298" style="zoom:50%;" />

In deze voorstelling voorziet een **backbone** de verbinding tussen verschillende areas, verkeer tussen de verschillende areas moet hier altijd door. Er is telkens een **edge router** die verbinding heeft met twee areas, deze routers noemen we ook wel area gateway routers of **area border routers**. De edge routers moeten de netwerken zo veel mogelijk aggregeren om de belasting te beperken. 

Uit dit voorbeeld kunnen we een paar concepten halen waarmee we binnen OSPF zullen werken:

* **Two-level hierarchy**: er wordt een hiërarchie van twee niveaus gebruikt, met een backbone op het hoogste niveau
* **Internal routers:** link states worden enkel binnen hun eigen area, zodat elke router over een topologie beschikt van zijn eigen area, maar niet naar bestemmingen in andere areas
* **Area border routers:** moeten bereikbaarheid 'samenvatten' voor hun eigen area en adverteren naar andere area border routers via de backbone
* **Backbone routers:** draaien het link state protocol enkel onder de routers van de backbone
* **Boundary routers:** maken verbinding met andere autonome systemen



## Link State vs Distance Vector

| Link State Routing                         | Distance Vector Routing                        |
| ------------------------------------------ | ---------------------------------------------- |
| Elke router kent de volledige topologie    | Router kent enkel de lengte van het korste pad |
| Meer CPU en geheugen                       | Minder resources nodig                         |
| Dijkstra                                   | Bellman-Ford                                   |
| Update na elke link change                 | Periodieke updates                             |
| Reageert snel op wijzigingen               | Trage convergentie                             |
| Bruikbaar in netwerken met duizenden nodes | Kleine netwerken (hop limit 15)                |



# Week 10

## BGP

Het Border Gateway Protocol wordt gebruikt voor de routering **tussen** verschillende autonome systemen op het internet. In tegenstelling tot OSPF, dat zich bezig houdt met de routering **binnen** een autonoom systeem. Alleen routers die verbinding maken met andere autonome systemen maken gebruik van het BGP protocol. Dit zij dan ook de Border Gateways. Als ze met elkaar praten, noemen we dat *peeren*.

BGP maakt gebruik van TCP in de transportlaag. Er is dus niet speciaal een rechtstreekse link tussen twee routers opdat ze BGP met elkaar kunnen praten.

BGP is een **path-vector** protocol. Dit wil zeggen dat:

* We houden een pad bij naar de bestemming (in plaats van een afstandsmaat)
* De convergentie loopt beter dan bij distance-vector protocollen (we kunnen sneller loops detecteren)
* We kunnen andere paden toelaten dan de kortste paden



### Basisprincipes

BGP voorziet elke AS drie dingen

* **Advertise**: routers gaan adverteren tot welke prefixen of subnetten ze toegang bieden. Dus hun reachability info doorgeven aan andere routers
* **Propagate**: Routers kunnen ontvangen reachability info propageren naar andere BGP routers.
* **Select**: BGP routers kunnen ontvangen paden of routers selecteren aan de hand van hun eigen voorkeuren of policies.

We zullen wat dieper ingaan op elk van deze principes.



### Advertisement of reachability

Een router laat zijn aangrenzende routers weten welke subnet prefixen hij kan bereiken. Dit is eigenlijk een *impliciete belofte* die stelt dat hij ontvangen pakketten naar deze subnet prefixen zal afleveren naar hun bestemming.

Zo een advertisement bevat de volgende zaken:

* AS-PATH: dit is een padvector die de definiëert welke tussenliggende AS'en moeten doorlopen worden om tot een bepaald netwerk te raken.
* NEXT-HOP: De volgende hop die moet genomen te worden om dit netwerk te bereiken. 



### Propagation

<img src="img/image-20220517135631932.png" alt="image-20220517135631932" style="zoom:50%;" />

Binnen een AS zullen routers gebruik maken van **iBGP** (interior BGP) om reachability informatie met elkaar te delen, het zal dan een *full mesh*\* op te zetten tussen alle routers. Zo kan de reachability info vanuit een ander AS ook binnen onze AS verder propageren. Routers die verbonden zijn met andere AS'en gebruiken dan **eBGP** (exterior BGP) om informatie met elkaar uit te wisselen. Elke keer dat een router een nieuwe prefix leert, zal hij daarvoor een entry toevoegen in zijn routeringstabel. Die tabellen kunnen in de context van het internet natuurlijk snel heel groot worden.

\* *Full mesh*: elke router is verbonden met elke andere router. In deze context is deze verbinding een iBGP-sessie.

Een AS kan ook beslissen om bepaalde reachability info **niet door te propageren**. Als je bijvoorbeeld enkel paketten van betalende klanten wilt doorsturen. Je hebt dus eigenlijk zelf de macht om te beslissen hoe jouw net werk wordt gebruikt, door bepaalde info wel of niet te delen. Denk terug aan de belofte van de vorige titel.



### Route selection

Hoe kiest een router nu welke route hij moet gebruiken als hij meerdere routes heeft naar dezelfde prefix? De volgende regels zullen overlopen worden in volgorde:

1. **Local preference value**: handmatig instellen om voorkeur te geven aan paden via bepaalde AS'en.
2. **Shortest AS-PATH**: het pad dat zo min mogelijk AS'en doorloopt.
3. **Closest NEXT-HOP**: als de paden even lang zijn, kiezen we voor de dichtstbijzijnde router (hot potato routing)
4. Andere criteria





# Week 11

## Firewalls

Een firewall is eigenlijk een soort router, maar hij zal niet zomaar alle IP-pakketten doorsturen. Hij zal elk IP-pakket bekijken om te zien of het verkeer is dat we wensen in ons netwerk. Op die manier trachten we pakketjes van boeven, schurken en stinkende IT'ers met te veel tijd aan hun handen tot een minimum beperken.

Er zijn verschillende soorten firewalls. We zullen er zo meteen enkele ter sprake brengen.



### Stateless packet filtering

Een packet filter zal elk pakket dat door de firewall passeert onafhankelijk beoordelen. Je kan hiervoor regels opstellen die bijvoorbeeld beslissingen zullen nemen op basis van het **source** en **destination** ip-adressen of poortnummers. Zo kunnen we dan een **access control list** (ACL) opstellen. 

**Access Control Lists**

Een tabel van regels die bepalen welk verkeer er wel of niet door de firewall mag passeren. De regels worden van boven naar onder toegepast. Typisch zet je dan onderaan je tabel een regel die van toepassing is op alle pakketten.



### Stateful packet filtering 

Een stateful packet filter kan bijvoorbeeld kijken naar een hele TCP connectie en zien of die wel 'klopt'. Zo kan hij dan bijvoorbeeld geen ACK pakketten van buitenaf toelaten als daar niet een SYN van binnenin het netwerk op voorafging. Daarvoor houdt de firewall een **connection state table** bij. 



### Application gateways

Die zorgen ervoor dat er alleen heel specifieke soorten applicatiedata naar buiten mogen. Zij worden typisch gecombineerd met een stateless of stateful packet filter. Een voorbeeld hiervan is een proxy server. Deze gaat eigenlijk in jouw plaats een HTTP verbinding maken met een server. De packet filters zorgen er dus voor dat alleen de proxy server mag surfen op het internet. Hierdoor ben je dus verplicht om de proxy te gebruiken binnen dit netwerk.

<img src="img/image-20220625143152954.png" alt="image-20220625143152954" style="zoom:50%;" />

### Intrusion detection system

(IDS)

Intrusion detection systems doen nog een stapje extra bovenop wat packet filters doen. 

* **Deep packet inspection**: De inhoud van pakketjes wordt gecontroleerd en vergeleken met een database van bekende virussen of schadelijke strings
* **Correlatie** tussen pakketjes wordt ook onderzocht. Om bepaalde aanvallen te detecteren zoals:
  * port scanning
  * network mapping
  * (D)DoS aanvallen

Typisch zet je meerdere IDSen op verschillende plekken in je netwerk

<img src="img/image-20220625144106785.png" alt="image-20220625144106785" style="zoom:50%;" />



# Week 12

### SDN

Onze netwerkinfrastructuur lijdt aan dezelfde problemen als computers in de jaren 80'. Er waren slechts een handvol grote spelers die computers produceerden, met ieder hun eigen hardware, eigen besturingssysteem en features. Met de komst van de persoonlijke computers kwamen er architecturen met gestandaardiseerde API's waar verschillende besturingssystemen en applicaties op konden draaien. 

Het kernidee van software defined networking bestaat erin om net zoals bij persoonlijke computers ook bij de netwerktoestellen open interfaces te voorzien zodat iedereen snel zijn eigen besturingsysteem en applicaties kan schrijven.

Onderaan dit model hebben we **switching hardware**. Hierboven hebben we een **control plane** besturingssysteem, waarop we verschillende **applicaties** zelf kunnen programmeren.

Dit idee kwam van een student van Stanford en heette het **OpenFlow** project. Zo konden er nieuwe soorten netwerkbedrijven ontstaan. Bedrijven die alleen controleapplicaties schrijven die op eender welke soort OpenFlow hardware konden uitgevoerd worden. 

### OpenFlow

Openflow is een soort protocol dat wordt gesproken tussen de **control plane** en de **data plane**. Dus eigenlijk een protocol dat je kan gebruiken om te spreken met switching hardware om deze te configureren.

* **Control plane**: bestaat uit één of meer gecentraliseerde controllers. Je kan dit zien als een soort krachtige server in een datacenter die interageert met vele switches. Deze zal dan een ssl verbinding maken met de OpenFlow agent van die switches

<img src="img/image-20220625150948865.png" alt="image-20220625150948865" style="zoom:50%;" />

Alle configuratie in een programmeerbare switch wordt door OpenFlow geabstraheerd in een **flow table**. De controller kan die flow table gaan configureren aan de hand van een OpenFlow instructie.

* **Data plane**: 
  * Een regel in zo een **flow table** heeft drie velden:
    * **Rule**: een matching regel die beschrijft welk protocol de instructie omvat
    * **Action**: wat er gedaan moet worden. Bv. het pakket sturen naar de controller
    * **Stats**: voor iedere regel worden er statistieken bijgehouden. Bv. hoe vaak hij werd toegepast.



<img src="img/image-20220625151342952.png" alt="image-20220625151342952" style="zoom:50%;" />

Dit is best wel gek. Door de mogelijkheden van OpenFlow kan je zelfs een switch als router of firewall gebruiken. 

OpenFlow voorziet twee manieren om flows toe te voegen aan een tabel:

* Reactive Flow Insertion
  * Pas een regel aan de flow table toevoegen nadat er eerst een pakket van die flow werd ontvangen in een switch. Dit eerste pakket wordt dan doorgestuurd naar de controller die op basis daarvan een nieuwe regel toevoegt in de flow table van de switch. Dan zal de switch alle pakketten van diezelfde flow behandelen volgens dezelfde regel.
* Proactive Flow Insertion
  * De controller kan ook proactief regels regels configureren in de flowtabel zonder dat er een pakket werd ontvangen in de switch. Zo kan ook het eerste pakket van die flow direct in de data plane afgehandeld worden.



### SDN Architectuur

De SDN netwerkachitectuur bestaat uit drie delen:

* **Goedkope switches** met een open API
* **SDN controller** die netwerkgegevens vergaart en een aantal abstracties voorziet om op basis daarvan routeringsapplicaties te schrijven.
* De **applicatie** zelf: vormt het brein van het netwerk en bepaalt hoe de routering, access control of load balancing in je netwerk zal verlopen

Je kan nu dus alles in software schrijven en aanpassen aan je eigen eisen.



## Netwerkvirtualisatie

Virtualisatie is het principe waarin een bepaalde functie wordt ontkoppeld van de specifieke hardware waarop ze wordt uitgevoerd. Door die ontkoppeling kunnen we sneller en robuuster omgaan met de omstandigheden.

Dit willen we dus ook doen met onze netwerkinfrastructuur. Als we dynamisch virtuele machines kunnen toevoegen en verwijderen op basis van hoe zwaar ons netwerk belast wordt, kunnen we veel efficiënter omgaan met onze resources en dus een stuk minder geld uit het raam smijten.

Om een lang verhaal kort te maken. In een datacenter heb je een hele fysieke netwerkinfrastructuur met routers en switches. Bovenaan zitten Top of Rack (ToR) switches die fysieke servers met elkaar verbinden. Op elke server zit een besturingssysteem dat toelaat dat dezelfde hardware kan gedeeld worden door verschillende virtuele machines. Deze kunnen virtuele applicaties zoals webservers en database-servers draaien. Mogelijks moeten deze virtuele machines met elkaar verbonden worden alsof ze tot hetzelfde LAN-netwerk behoren. Hiervoor hebben we **virtuele switches** nodig. 

<img src="img/image-20220625154841692.png" alt="image-20220625154841692" style="zoom:50%;" />

**Virtuele switch**

Een virtuele switch is een switch die volledig in software geschreven is. Hij kan verschillende virtuele interfaces van virtuele machines met elkaar verbinden alsof ze verbonden zijn met een echte ethernet switch. Een bekende open-source implementatie hiervan is **Open VSwitch** (OVS). De werking van OVS ga ik even achterwege laten. 



**VXLAN** (Virtual eXtensible Local Area Network)

Nu wordt het gek. In datacenters gaan ze ervoor zorgen dat laag 2 pakketten over IP kunnen getransporteerd worden. Dit gebeurt aan de hand van een **VXLAN** (een soort tunnel). De eindpunten van deze tunnels worden **VTEP**s (virtual tunnel endpoints) genoemd. Zo kunnen dan virtuele machines, ook al zijn ze gescheiden door routers, met elkaar praten alsof ze zich in hetzelfde LAN bevinden. De details ga ik nogmaals achterwege laten.

<img src="img/image-20220625154637431.png" alt="image-20220625154637431"  />





 

# Examenvragen theorie

## Hoofdstuk 2

1. > DNS is een hiërarchisch gedecentraliseerd systeem. Geef a.d.h.v. een voorbeeld aan hoe dit werkt.
   
   We zullen aan de hand van de FQDN amerigo.ugent.be. het DNS-systeem overlopen.
   
   Er zijn over de wereld een aantal **root DNS servers**, deze bevatten resource records voor elk van de top level domains (com, edu, be, ...). Deze vertellen ons eigenlijk waar we de volgende server kunnen vinden. Ze zullen ons dus vertellen waar we de server verantwoordelijk voor het **be** gedeelte van onze url kunnen vinden, waarschijnlijk ergens in belgië. Eenmaal doorverwezen, komen we bij de **top level domain servers**. Deze worden beheerd door **registry operators** en zullen ons vertellen waar we het ip adres van een bepaald domein kunnen vinden (ugent, gov, nokia, ...). Zij zullen ons vervolgens vertellen waar de **authoritatieve DNS server** voor de naam **ugent.be** zich bevindt. Deze server zal waarschijnlijk ook verantwoordelijk zijn voor het subdomein **amerigo.ugent.be**. 
   
   
   
2. > Een lokale DNS-server werkt meestal zowel op recursieve als iteratieve wijze. Bespreek beide werkwijzen. Leg uit welke methode gebruikt wordt voor lokale hosts.
   
   Als we een DNS-query doen, kan deze op twee manieren opgelost worden:
   
   * **Recursief**: de server waarnaar we de query sturen, zal zelf op zoek gaan naar het gezochte IP-adres door de vraag te stellen aan de nodige sequentie DNS-servers. In een puur recursieve implementatie zal onze DNS-server de query ook weer doorgeven en zal de volgende server (bv. de TLD nameserver) verder zoeken. In het echt zal een TLD server waarschijnlijk geen werk willen doen dat je eigenlijk zelf kan doen.
   * **Iteratief**: we sturen een query naar onze DNS-server. Deze antwoordt, hij weet het gevraagd IP-adres voor de domeinnaam niet, maar hij weet bijvoorbeeld wel waar de TLD nameserver zich bevindt en verwijst ons door. Nu stellen we onze vraag opnieuw aan de TLD server, die ons vervolgens weer zal doorverwijzen. We herhalen dit proces tot we het IP-adres hebben gevonden. 
   
   In de praktijk zullen we waarschijnlijk een combinatie van beide methodes gebruiken. Als we een query naar onze lokale DNS server sturen, zal hij die **iteratief** voor ons oplossen. Van het standpunt van onze host wordt de query dus **recursief** opgelost. 
   
   
   
3. > Wat is (in de context van DNS) : RR, A, NS, CNAME, MX (geef ook een voorbeeld)

   **RR** staat voor resource records. Een resource record is een veld in een DNS record. Er zijn verschillende types van resource records:

   * **A record**: een alias record bevat bijvoorbeeld de naam van je website (martijniscool.be ofzo) en mapt deze op een IP-adres
   * **NS record**: een nameserver record duidt de authoritatieve DNS server van het domein aan, dus welke server verantwoordelijk is voor de naam van jouw website. Dit ziet er typisch zo uit: ns1.example.com 
   * **CNAME**: een canonical name record mapt een domeinnaam naar een andere domeinnaam. Zo kan je bijvoorbeeld je domein laten doorverwijzen naar een ander domein.
   * **MX**: een mail exchanger record vertelt je welke mailserver er verantwoordelijk is voor email-berichten naar email-adressen onder het domein. 

4. > Wat is reverse DNS en hoe werkt het?

   Met reverse DNS kan je DNS doen in de andere richting. Je kan dus achterhalen welke domeinnaam er bij een bepaald IP-adres hoort. 

   Neem bijvoorbeeld het adres 200.123.222.111. We maken een FQDN (fully qualified domain name) van dit adres door het ip adres achterstevoren te zetten, dit geeft ons **111.222.123.200.in-addr.arpa**. Als er een **PTR-record** aanwezig is voor het gezochte IP-adres, kunnen we nu eigenlijk een gewone DNS-lookup doen, gebruik makende van de FQDN die we net hebben opgesteld. Deze lookup zal beginnen bij het '200'-gedeelte van de FQDN en op deze manier ons adres aflopen analoog aan forward DNS.

5. > Leg het principe van sockets uit en hoe je in de praktijk de actieve sockets op je Linux- systeem kan opvragen.
   
   Een socket is één endpoint in een tweerichtingscommunicatielink tussen twee applicaties op een netwerk. Dit is een combinatie van een IP-adres en een poortnummer. 
   
   
   
   Openstaande sockets kan je opvragen met `ss`. Sockets die bovendien ook aan het luisteren zijn kan je opvragen met `ss -l`. 
   
   
   
6. > Bespreek de werking en functie van een DHT in peer-to-peer netwerken.
   
   DHT staat voor **distributed hash table**. In een peer-to-peer netwerk worden bestanden in chunks opgedeeld. Deze worden verdeeld over verschillende nodes. Om te weten wie welke bestanden heeft kan men gebruik maken van een DHT. We maken een hashtabel met als key de bestandsnaam en chunknummer, en met als value de lijst met hosts die deze chunks bezitten. 
   
   <img src="img/image-20220228170856251.png" alt="image-20220228170856251" style="zoom: 33%;" />
   
   Een DHT werkt hetzelfde als een gewone hastabel, buiten het feit dat zijn sleutels worden verdeeld over verschillende nodes. Door de keys te **hashen** krijgen we een bepaalde range van mogelijke id's voor de nodes. We hebben typisch minder nodes dan id's, dus zorgen we ervoor dat een gegeven id overeenkomt met een node waarvoor de id groter of gelijk aan de gegeven id is. Door dit schema dan in een cirkel te zetten waarbij de kleinste id de opvolger is van de grootste, kunnen we ervoor zorgen dat elke id overeenkomt met een node. 
   
   In het voorbeeld hierboven zullen dus alle keys die als id 4, 5, 6, 7 of 0 opleveren terecht komen bij de node met id 0.
   
   

## Hoofdstuk 4

1. Leg NAT uit aan de hand van een voorbeeld. Bespreek de voor- en nadelen van NAT.

   

   

   

2. Stel een packet flow diagram op, waar één client in een netwerk een DHCP adres aanvraagt, maar waar er twee DHCP servers in het netwerk voorkomen. Leg aan de hand hiervan de werking van DHCP uit.
   
   ![dhcp](img/dhcp.gif)

3. Wat is DHCP relay en waarvoor dient het?

4. Leg het werkingsprincipe uit van Software-Defined Networking. Wat zijn de voordelen.

   

## Hoofdstuk 5

1. Wat is een AS ? Geef 3 types (waarom is het belangrijk een onderscheid te maken).

   

2. Bespreek het verschil tussen intra- en inter-AS routering.

   

3. Leg het werkingsprincipe van distance vector en link-state routering uit. Geef een
   voorbeeld voor beide strategieën.

   

4. Hoe gaan distance vector en link-state routering om met problemen in het netwerk?
   Evalueer de voor- en nadelen van beide strategieën.

   

5. Bespreek hierarchical OSPF. Waarom is dat nuttig ?

   

6. Bespreek een voorbeeld van BGP. Waarom heeft men I-BGP en E-BGP ?

   

7. Wat is een AS-PATH ? Wat is een NEXT-HOP ?

   

8. Wat is policy based routing in BGP ? Geef een voorbeeld.

   

9. Wat is ICMP ? Geef een voorbeeld bij het gebruik in een redirect en traceroute.

   

10. Leg de basisprincipes van SNMP uit (wat, waarom, hoe, ...). Verwerk het woord MIB en
    OID in je antwoord.

    

11. Hoe kan Ansible ingezet worden voor netwerkautomatisering, en wat zijn de nodige
    basiscompomenten en protocollen van Ansible?

    

12. Wat is netwerkvirtualisatie en waarom wordt het gebruikt?

    

## Hoofdstuk 6

1. Hoe werkt een Ethernet switch.

   

2. Hoe worden de switchtabellen ingevuld ? En hoe worden ze gebruikt ?

   

3. Bespreek STP en geef een voorbeeld.

   

4. Wat is een VLAN ? Bespreek de relatie tussen VLANs en subnetten.

   

5. Geef een aantal voor- en nadelen van switches (versus routers).

## Hoofdstuk 7

1. Bespreek de voornaamste verschillen tussen draadloze netwerken en bekabelde
   netwerken (bv. welke problemen kunnen optreden in draadloze netwerken, die je niet
   hebt in bekabelde netwerken)?

   

2. Hoe werkt het IEEE 802.11 MAC protocol?

   

3. Bespreek de werking van de adresvelden bij IEEE 802.11 netwerken.

   

## Hoofdstuk 8

1. Bespreek pakketfiltering “packet firewall: stateless en stateful” en toepassingsgateway
   “application gateway”

   

## Hoofdstuk 4* : IPv6

De slides van dit hoofdstuk bevatten tekstuele verduidelijking in de notes; deze notes vullen
de slides aangezien er geen IPv6 hoofdstuk opgenomen is in het boek van Kurose-Ross.

1. Bespreek de verschillende types adressen bij IPv6 (“Address Type”).

   

2. Leg uit: fe80::/10, 2000::/3, fc00::/7. Waarvoor worden deze verschillende scopes
   gebruikt?

   

3. Wat zijn de belangrijkste verschillen tussen een IPv4 en IPv6 header ? Waarom heeft
   men die verschillen ingevoerd ?

   

4. Geef een voorbeeld van IPv6 adresresolutie en leg uit wat “solicited-node address” is.

   

5. Leg uit: IPv6 DAD.

   

6. Een IPv6 node met meerdere interfaces (e.g. een router), gebruikt intern steeds een
   zone index.
   Leg uit waarom.

   

7. Bespreek de verschillende autoconfiguratiestappen van IPv6.

   

8. De overgang van IPv4 van IPv6 wordt georganiseerd in DNS records. Leg uit hoe dit
   mechanisme werkt.




# Afkortingen overzicht

Met het commando

```bash
grep -oE [A-Z][A-Z]+ cn2.md |sort|uniq >> afkortingen.txt
```

kan je een overzicht maken van alle woorden in drukletters. Als je daar dan een paar nutteloze dingen uithaalt, heb je een easy overzicht van alle afkortingen. (bedankt Wim)

| Afkorting | Betekenis                                                    |
| --------- | ------------------------------------------------------------ |
| ACL       | Access Control List                                          |
| AES       | Advanced Encryption standard                                 |
| AP        | Access Point                                                 |
| API       | Application Programming Interface                            |
| ARP       | Address Resolution Protocol                                  |
| AS        | Autonomous System                                            |
| BER       | Bit-error-rate                                               |
| BGP       | Border Gateway Protocol                                      |
| BSSID     | Basic Service Set Identifier                                 |
| CMDB      | Configuration management database                            |
| CSMA/CA   | Carrier sense multiple access / collision avoidance          |
| CTS       | Clear-to-send                                                |
| DAD       | Duplicate address detection                                  |
| DHCP      | Dynamic host configuration protocol                          |
| DHT       | Distributed hash table                                       |
| DNS       | Domain name system                                           |
| EUI-64    | Extended unique identifier                                   |
| FCAPS     | Fault, configuration, accounting, performance en security management |
| GW        | gateway                                                      |
| ICANN     | Internet Corporation for Assigned Names and Numbers          |
| ICMP      | Internet control message protocol                            |
| IDS       | Intrusion detection system                                   |
| IEEE      | Institute of Electrical and Electronics Engineers            |
| IGD       | Internet Gateway Device protocol                             |
| IID       | Interface Identifier                                         |
| IMAP      | Internet mail access protocol                                |
| IP        | Internet protocol                                            |
| IS-IS     | Intermediate System to Intermediate System protocol          |
| ISC       | Internet Systems Consortium                                  |
| ISP       | Internet Service Provider                                    |
| LAN       | Local Area Network                                           |
| LL        | Link-Local                                                   |
| MAC       | Medium access control                                        |
| MIB       | Management information base                                  |
| NAT       | Network Address Translation                                  |
| NMA       | Network management applications                              |
| NMO       | Network management objects                                   |
| NMS       | Network management station                                   |
| NTP       | Network time protocol                                        |
| OID       | Object Identifier                                            |
| OSI       | Open Systems Interconnection (model)                         |
| OSPF      | Open Shortest Path First                                     |
| OVS       | Open VSwitch                                                 |
| PPP       | Point-to-Point Protocol                                      |
| RC4       | Rivest Cipher 4                                              |
| RIB       | Routing information base                                     |
| RIP       | Routing information protocol                                 |
| RIR       | Regional internet registry                                   |
| RR        | Resource Record                                              |
| RS        | Router Solicitation                                          |
| RTS       | Request to Send                                              |
| SDN       | Software defined networking                                  |
| SLA       | Service level agreement                                      |
| SLAAC     | Stateless address autoconfiguration                          |
| SMI       | Structure of management information                          |
| SNMP      | Simple network management protocol                           |
| SNR       | Signal to noise ratio                                        |
| SOA       | Start of authority                                           |
| SSH       | Secure shell protocol                                        |
| SSID      | Service set identifier                                       |
| SSL       | Secure sockets layer                                         |
| STP       | Spanning tree protocol                                       |
| TCP       | Transport control protocol                                   |
| TKIP      | Temporal key integrity protocol                              |
| TTL       | Time to live                                                 |
| UDP       | User datagram protocol                                       |
| ULA       | Unique local address                                         |
| UPNP      | Universal Plug and Play protocol                             |
| VLAN      | Virtual local area network                                   |
| VTEP      | Virtual tunnel endpoint                                      |
| VXLAN     | Virtual extensible local area network                        |
| WEP       | Wired equivalent protocol                                    |
| WPA       | WiFi Protected Access                                        |

# ------------------Labo's--------------------


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



11. Both the client and the AP know the 40-bit WEP key, but how does the client know the 24-bit Initialization Vector (IV) to decrypt a packet? (hInt: examine the dump-xx.cap file)

```
The IV is also included in the packet
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



# IPV6 oefeningen

**Vraag 1** 

Aggregeer de volgende netwerken tot een zo groot mogelijk geheel: 

2001:6a8:1d80:7374::/64 

2001:6a8:1d80:7375::/64 

2001:6a8:1d80:7376::/64

 2001:6a8:1d80:7377::/64

```
0100 
0101
0110
0111
=> 2001:6a8:1d80:7374::/62
```

 2001:6a8:002a::/48

 2001:6a8:002b::/48

 2001:6a8:002c::/48

 2001:6a8:002d::/48

```
1010
1011
1100
1101
2001:6a8:0028::/45 ! er zit wel te veel in

2001:6a8:002a::/47 -> beter in 2 splitsen
2001:6a8:002c::/47
```

**Vraag 2**

Splits de volgende network ranges in 4 subnetwerken van gelijke grootte: 

2001:6a8:1d80:2080::/58 

```
2080 -> 0010 0000 01|00 0000

0010 0000 0100 | 0000 -> 2001:6a8:1d80:2080::/60
0010 0000 0101 | 0000 -> 2001:6a8:1d80:2090::/60
0010 0000 0110 | 0000 -> 2001:6a8:1d80:20A0::/60
0010 0000 0111 | 0000 -> 2001:6a8:1d80:20B0::/60
```

2001:6a8:1d80:e000::/52 

```
E000 -> 1110 | 0000 0000 0000

1110 00 | 00 0000 0000 -> 2001:6a8:1d80:e000::/54
1110 01 | 00 0000 0000 -> 2001:6a8:1d80:e400::/54
1110 10 | 00 0000 0000 -> 2001:6a8:1d80:e800::/54
1110 11 | 00 0000 0000 -> 2001:6a8:1d80:eC00::/54
```

2001:6a8:1d80:7a00::/55

```
7A00 -> 0111 101|0 0000 0000

```

**Vraag 3**

<img src="img/image-20220421153731944.png" alt="image-20220421153731944" style="zoom:50%;" />

Beschouw het bovenstaande IPv6 netwerk. 

1. Genereer een Link-Local (LL) adres voor host A 

2. Geef weer in de tabel hoe de andere hosts hun LL adres werd aangemaakt. Er zit ook vermoedelijk een fout in. 

|                                   | Host B | Host C | Serv S | R / eth1 | R / eth2 |
| --------------------------------- | ------ | ------ | ------ | -------- | -------- |
| IID EUI-64 based                  |        |        |        |          |          |
| IID privacy extension (md5 based) |        |        |        |          |          |
| Manually assigned IID             |        |        |        |          |          |

3. Een globale prefix 2001:db8:101::/48 werd toegekend aan het bedrijf. Deel op in subnetwerken van nuttige grootte, en bepaal welke adressen alle interfaces in het netwerk hierdoor zullen krijgen (duidt ze aan op de figuur).



4. Extra: Genereer voor het eigen netwerk een ULA prefix range, en maak hierbinnen subnetwerken aan voor beide LANs. Ken eveneens aan de interfaces binnen het netwerk IPv6 adressen binnen de ULA prefix toe.



5. Stel de routing table op van de router:





| Destination | Prefix | Gateway | Interface |
| ----------- | ------ | ------- | --------- |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |
|             |        |         |           |



# IPV6 Labo









# Intra AS routing



Show ipv6 ripng

1 router zonder RIP



## Voorbereiden van labo-omgeving

**Afhalen en uitpakken van de labo bestanden**

In de folder `/home/student` (de default folder), doe je het volgende vanuit een terminalscherm:

``` bash
student@cnet:~# wget https://www.dropbox.com/s/3qhlpldbi7jsat1/ripnglabo.py
```

**Mininet**

Dit labo maakt opnieuw gebruik van [Mininet](http://mininet.org). Iedere node (host, router of switch) in Mininet gedraagt zich alsof het bijna een volledig afgezonderde virtuele machine is:

* processen die draaien op de ene node zijn niet zichtbaar op de andere,
* iedere heeft een eigen netwerkstack met eigen interfaces. 

<u>Let wel</u>: het bestandssysteem wordt wel gedeeld tussen alle Mininet nodes: alle nodes hebben toegang tot dezelfde schijf. Dit maakt het makkelijk om slechts eenmaal software te installeren die door alle nodes kan gebruikt worden. Ook configuratiebestanden kunnen in dezelfde folder (bv. `\home\student\labo9`)  worden opgeslagen en gebruikt worden door verschillende nodes.

Een aantal nuttige opdrachten binnen Mininet:

| Commando            | Functie                                                      |
| ------------------- | ------------------------------------------------------------ |
| `> net`             | Geeft overzicht van de netwerkcomponenten (bv. welke interfaces zijn met elkaar verbonden. |
| `> links`           | Geeft overzicht van de netwerklinks.                         |
| `> nodes`           | Geeft overzicht van de netwerknodes.                         |
| `> xterm <node>`    | Start een shell op in een gegeven node.                      |
| `> help`            | Informatie m.b.t. andere commando's                          |
| `> <node> commando` | Laat toe om commando vanuit Mininet-shell uit te voeren op gegeven node |
| `> ss` evt. `ss -l` | Geef openstaande sockets (evt. enkel luisterende)            |

In nood (bv. wanneer systeem, proces, ... is gecrashed) kun je mininet afsluiten en opschonen door `mn -c`.

Andere praktische tips:

- **bewerken van bestanden** kun je doen via een command line editor (bv. `nano`) of GUI editor (bv. Accessories -> Pluma) vanop de host machine.
  - aangezien het bestandssysteem gedeeld wordt door alle mininetnodes, kun je meteen de bestanden gebruiken op een bepaalde Mininet node
- **copy/paste van commando's** kan niet in de `xterm` vensters, maar wel in de Mininet-terminal

**Linux command-line**

De volgende tabel geeft bij wijze van herhaling een overzicht van mogelijks nuttige commando's die je kunt gebruiken in de command line interface op je Linuxomgeving.

| Commando                                            | Functie                                                      |
| --------------------------------------------------- | ------------------------------------------------------------ |
| `> man <commando>` of `<commando> --help`           | Vraag extra informatie over een commando op (wat zijn de mogelijke parameters, etc.). |
| `> ip link`                                         | Vraag informatie m.b.t interfaces (alternatief voor `ifconfig`) |
| `> ip route` voor IPv4 of `ip -6 route` voor IPv6   | Vraag forwardingtabel op                                     |
| `> traceroute` voor IPv4 of `traceroute6` voor IPv6 | Achterhaal de tussenliggende hops van de route naar een gegeven node. |

## Routering met RIPng

In dit labo gaan we de structuur en routering van een RIPng netwerk onderzoeken. RIPng maakt gebruik van distance vectors t.o.v. IPv6 netwerkprefixen. 

Start het netwerk in Mininet als volgt:

```shell
/home/student/labo9$ sudo -s
root# python3 ripnglabo.py
```

**Analyse van het netwerk en routering**

In eerste instantie proberen we de onderdelen van de topologie te begrijpen en analyseren. Om dit proces bij te staan kunnen we gebruik maken van de volgende netwerkfiguur en onderstaande tabel.  Aan de hand van Mininet en de draaiende RIPng daemons op routers kunnen de nodenamen, subnetadressen en distance metrics gecontroleerd worden. 
<u>Let op</u>: niet alle gegevens zijn op de figuur te zien.

<img src="img/image-20220505151845108.png" alt="image-20220505151845108" style="zoom:50%;" />

| Link  | Netwerk prefix        | Link    | Netwerk prefix         |
| ----- | --------------------- | ------- | ---------------------- |
| r1-r2 | 2001:db8:1341:12::/64 | a-r4-r5 | 2001:db8:1341:a45::/64 |
| r1-r3 | 2001:db8:1341:13::/64 | r2-r4   | 2001:db8:1341:24::/64  |
| r1-r7 | 2001:db8:1341:17::/64 | r3-r4   | 2001:db8:1341:34::/64  |
| r2-r3 | 2001:db8:1341:23::/64 | r7-c    | 2001:db8:1341:c7::/64  |
| r3-r7 | 2001:db8:1341:37::/64 |         |                        |

**FRRouting**

De uitgerolde setup maakt gebruik van [FRRouting](https://frrouting.org) software. Informatie i.v.m. de [RIP](http://docs.frrouting.org/en/latest/ripd.html) en [RIPng](http://docs.frrouting.org/en/latest/ripngd.html) daemons vind je inde vermelde links. Via de management interface van FRRouting kun je inloggen op de routers via telnet op een specifieke poort per routing protocol. De RIPng management interface kan gevonden worden op poort 2603.

> [!Info] RIPng info ophalen op router via FRR management interface
>
> 1. Open een `xterm` voor een gegeven router (bv. `r1`)
> 2. Log in op de management interface van de RIPng routing daemon a.d.h.v. `telnet localhost 2603`. 
> 3. Gebruik het paswoord `zebra` om in te loggen. 
> 4. Onderzoek de RIPng routeringsdata van de daemon met `show ipv6 ripng`.

<u>Kun je op basis van de info die je terugvindt in een enkele RIPng routingdaemon de volledige netwerktopologie achterhalen? Waarom wel of niet?</u>

```
niet echt denk ik
```

Als netwerkbeheerder wens je vervolgens de connectiviteit tussen verschillende (end)hosts te testen. Achterhaal de genomen route tussen host `a` en `c`.

<u>Hoe heb je de route gevonden?</u>

```
traceroute to 2001:db8:1341:c7::c (2001:db8:1341:c7::c), 30 hops max, 80 byte packets
 1  r4 (2001:db8:1341:a45::4)  0.051 ms  0.010 ms  0.007 ms
 2  r3 (2001:db8:1341:34::3)  0.029 ms  0.011 ms  0.008 ms
 3  r1 (2001:db8:1341:13::1)  0.024 ms  0.012 ms  0.009 ms
 4  r7 (2001:db8:1341:17::7)  0.019 ms  0.010 ms  0.010 ms
 5  c (2001:db8:1341:c7::c)  0.021 ms  0.013 ms  0.023 ms

```

<u>Is dit de meest logische route?</u>

```
nee, hij zou r1 kunnen overslaan en direct naar C gaan
```

<u>Wat kan de reden zijn dat deze route werd gebruikt?</u>

```
misschien door de distance metrics
```



**RIPng analyse**

Ieder routeringsprotocol maakt gebruik van berichten die tussen routers worden uitgewisseld. Start `wireshark` op vanuit `r1` of `r3` om de uitgewisselde RIPng berichten tussen `r1` en `r3` te analyseren. Je kunt [Wireshark](https://www.wireshark.org) gebruiken om live te capturen, maar je kunt ook de eerste 10 RIPng pakketten ontvangen op de routers analyseren uit de tracefiles `/home/student/labo9/ripng-rx-trace.pcap` die zijn gecreëerd tijdens het opstarten van het netwerk.

Bepaal hieruit de belangrijkste karakteristieken van RIPng:
<u>Tussen welke IP adressen worden de RIPng berichten uitgewisseld, en wat is bijzonder aan deze adressen?</u>

```
fe80::dc73:84ff:febd:5134 en	ff02::9	
link-local								en 	multicast
```

<u>Welke transportlaagprotocol en poortnummer wordt hiervoor gebruikt?</u>

```
UDP, 521
```


Routingprotocollen vergen enige tijd vooraleer ze leiden tot stabiele routingtabellen. Eenmaal de initiële interactie is geconvergeerd, analyseer je welke berichten tussen `r1` en `r3` worden uitgewisseld. 

<u>Via welke berichten worden distance vectors uitgewisseld?</u>

```
r1-eth1: fe80::a2:4dff:fe1a:dd82/64
r3-eth2: fe80::f42f:a7ff:fe73:58cb/64
```

<u>Welke prefixen worden in welke richting uitgewisseld? Waarom?</u>

```
?
```

<u>Op welke tijdsschaal wordt dit gedaan?</u>

```
71ms
```

Je kunt de uitgewisselde berichten nu gaan vergelijken met de informatie die `r3` bijhoudt in zijn RIPng routingdaemon.  Alle routeringsinformatie  in de control plane wordt bijgehouden wordt ook wel de Routing Information Base (RIB) genoemd. Bij RIPng bestaat de RIB voornamelijk uit distance vectors.

<u>Geef de bijgehouden distance vector in r3 op basis van de gevonden info (vul volgende tabel aan).</u>

```
Network      Next Hop                      Via     Metric Tag Time
R(n) 2001:db8:1341:12::/64 
                  fe80::a2:4dff:fe1a:dd82     r3-eth2    4    0  02:40
C(i) 2001:db8:1341:13::/64 
                  ::                          self       1    0  
R(n) 2001:db8:1341:17::/64 
                  fe80::a2:4dff:fe1a:dd82     r3-eth2    4    0  02:40
C(i) 2001:db8:1341:23::/64 
                  ::                          self       1    0  
R(n) 2001:db8:1341:24::/64 
                  fe80::9893:deff:fe50:831d   r3-eth0    2    0  02:33
C(i) 2001:db8:1341:34::/64 
                  ::                          self       1    0  
C(i) 2001:db8:1341:37::/64 
                  ::                          self       1    0  
R(n) 2001:db8:1341:c7::/64 
                  fe80::a2:4dff:fe1a:dd82     r3-eth2    8    0  02:40
R(n) 2001:db8:1341:a45::/64 
                  fe80::9893:deff:fe50:831d   r3-eth0    2    0  02:33

```



| Netwerk prefix | Distance | Gateway | Next Hop |
| -------------- | -------- | ------- | -------- |
| zie hierboven  |          |         |          |

<u>Waarin verschilt de distance vector van de gebruikte forwarding table van router `r3` (zoals die gebruikt wordt door de Linux netwerkstack)?</u>

```
2001:db8:1341:12::/64 via fe80::a2:4dff:fe1a:dd82 dev r3-eth2 proto 190 metric 20 pref medium
2001:db8:1341:13::/64 dev r3-eth2 proto kernel metric 256 pref medium
2001:db8:1341:17::/64 via fe80::a2:4dff:fe1a:dd82 dev r3-eth2 proto 190 metric 20 pref medium
2001:db8:1341:23::/64 dev r3-eth1 proto kernel metric 256 pref medium
2001:db8:1341:24::/64 via fe80::9893:deff:fe50:831d dev r3-eth0 proto 190 metric 20 pref medium
2001:db8:1341:34::/64 dev r3-eth0 proto kernel metric 256 pref medium
2001:db8:1341:37::/64 dev r3-eth3 proto kernel metric 256 pref medium
2001:db8:1341:c7::/64 via fe80::a2:4dff:fe1a:dd82 dev r3-eth2 proto 190 metric 20 pref medium
2001:db8:1341:a45::/64 via fe80::9893:deff:fe50:831d dev r3-eth0 proto 190 metric 20 pref medium
fe80::/64 dev r3-eth2 proto kernel metric 256 pref medium
fe80::/64 dev r3-eth1 proto kernel metric 256 pref medium
fe80::/64 dev r3-eth3 proto kernel metric 256 pref medium
fe80::/64 dev r3-eth0 proto kernel metric 256 pref medium

```



**RIPng configuratie met FRRouting**

==Een router in de gegeven topologie is nog niet geconfigureerd a.d.h.v. RIPng. over welke router gaat het precies?==


Manueel zo'n router configureren is een tijdrovende klus die bovendien makkelijk tot fouten kan leiden in de routingtabel. Daarom gaan we RIPng op die router activeren.

Om die router te configureren met behulp van FRRouting software, moeten we twee configuratiebestanden aanleveren voor de router:

1. [Zebra](http://docs.frrouting.org/en/latest/zebra.html) configuratie (interfacesgegevens)
2. [RIPng](http://docs.frrouting.org/en/latest/ripngd.html) configuratie (link costs, netwerkprefixen, etc.)

De bedoeling is dat alle links van de router optimaal gebruikt worden en dat **alle link costs op 0** worden gezet.

**Zebra IP routing manager**

De Zebra IP routing manager verzorgt de interface tussen de Linux kernel en de specifieke routing daemons. Deze manager moet geconfigureerd worden op de betrokken node, vooraleer het specifieke routing proces kan gestart worden.

Een **voorbeeld van de Zebra configuratie voor router r1** vind je hieronder. Je kunt deze gebruiken als template en naar wens kopiëren/aanpassen om de Zebra configuratie van de betrokken router op te stellen. 

zebra_r1.cfg:

```
hostname r1
password zebra

    log file /tmp/zebra_r1.log

interface lo
  no shutdown
  description -> n/a
  link-detect
  
!
interface r1-eth0
  no shutdown
  description -> r2-eth2
  link-detect
  
!
interface r1-eth1
  no shutdown
  description -> r3-eth2
  link-detect
  
!
interface r1-eth2
  no shutdown
  description -> r7-eth0
  link-detect
```

==Stel nu de Zebra-configuratie op voor de resterende router. Check de te configureren interfaces via Mininet.== 

> [!Info] Activeer de Zebra configuratie
> Eenmaal je de bijhorende configuratie hebt aangepast voor de ontbrekende router, activeer je zebra op de router als volgt (in een `xterm`): `zebra -f <configfile> -u root`. 
> Je kunt het proces stoppen a.d.h.v. CTRL+C.

**RIPng configuratie**

Wanneer Zebra is geconfigureerd en opgestart, kun je het RIPng proces voor de betrokken router configureren. Dit doe je ook a.d.h.v. een configuratiebestand. Hieronder vinden we een voorbeeld van de configuratie van router `r1`. 

ripng_r1.cfg:

```
hostname r1
password zebra

log file /tmp/ripngd_r1.log


interface lo
# -> n/a
  
interface r1-eth0
# -> r2-eth2
  
interface r1-eth1
# -> r3-eth2
  
interface r1-eth2
# -> r7-eth0
  
!
ipv6 ripng split-horizon poisoned-reverse
!
router ripng
  timers basic 30 180 120
  network lo
  offset-list lo out 0 lo
  offset-list lo in 0 lo
  network r1-eth0
  offset-list r1-eth0 out 0 r1-eth0
  offset-list r1-eth0 in 0 r1-eth0
  network r1-eth1
  offset-list r1-eth1 out 2 r1-eth1
  offset-list r1-eth1 in 2 r1-eth1
  network r1-eth2
  offset-list r1-eth2 out 3 r1-eth2
  offset-list r1-eth2 in 3 r1-eth2
  
!
ipv6 access-list lo permit ::/0
ipv6 access-list lo deny any
ipv6 access-list r1-eth0 permit ::/0
ipv6 access-list r1-eth0 deny any
ipv6 access-list r1-eth1 permit ::/0
ipv6 access-list r1-eth1 deny any
ipv6 access-list r1-eth2 permit ::/0
ipv6 access-list r1-eth2 deny any  
```

==Je mag opnieuw dergelijke configuratie als template gebruiken voor de resterende router en aanpassen als volgt:==

1. Pas de vermelde **interfaces** aan
2. Activeer opnieuw `split-horizon` met `poisoned-reverse` (check de werking hiervan.)
3. Herneem **dezelfde timer-waarden**
4. Zorg ervoor dat de netwerkprefixen voor alle interfaces worden geannonceerd a.d.hv. de `network`-instructies.
5. Zet alle **link-costs op 0** voor binnenkomende- en uitgaande verkeer alle interfaces a.d.h.v. `offset-list <listname> 0 <interface>`. De `<listname>` en `<interface>` worden vaak met zelfde naam gekozen (zoals in voorbeeld).
6. We maken geen gebruik van access lists, en laten alle mogelijke sources toe (zoals bij `r1`) 

>[!Info] Activeer de RIPng configuratie
>Eenmaal de RIPng configuratie voor de resterende router is vastgelegd, kun je de RIPng applicatie in de voorgrond starten met deze configuratie op de node (in `xterm`) via `ripngd -f <configfile> -u root`. 
>Het proces kun je dan stoppen via CTRL+C.

<div style="page-break-after: always;"></div>

Controleer de routingtabel van de router eenmaal zowel zebra als ripng zijn gestart. Zijn alle netwerken vanop de router nu bereikbaar? 

==Geef de routingtabel/distance vector van de router eenmaal de routers de nieuwe netwerksituatie hebben geleerd.==

| Netwerk prefix | Distance | Gateway | Next Hop |
| -------------- | -------- | ------- | -------- |
| ...            |          |         |          |

**Connectiviteit tussen host a en host c**

Het activeren van RIPng op de betrokken router zal er hoogstwaarschijnlijk voor zorgen dat het gebruikte netwerkpad tussen host `a` en host `c` verandert. 

==Welk nieuw pad wordt gebruikt tussen host `a` en `c` en waarom is dit het geval?==


Routingprotocollen hebben ook tijd nodig om nieuwe netwerksituaties te verwerken. Zo ook hadden de routers tijd nodig om dit nieuwe pad te ontdekken.  Om dit te evalueren, stop je de daemons van de router die je zelf hebt geconfigureerd, wacht je tot de oude situatie is hersteld, en ga je `wireshark` activeren om na te gaan welk verkeer wordt uitgewisseld wanneer de router opnieuw wordt opgestart.

==Welke RIPng berichten werden uitgewisseld vooraleer het netwerk stabiel werd?==


==Herneem bovenstaande procedure, en probeer tot op een seconde nauwkeurig te bepalen hoe lang RIPng nodig heeft om het nieuwe netwerkpad te activeren. Hoe heb je dit bekomen?==


> [!Tip] 
> Maak gebruik van `ping` en `wireshark` om de activatietijd te bekomen.

**Convergentie van RIPng bij falende link `r1`-`r7`**

Eenmaal alle routers naar behoren werken en dat alle routingtabellen stabiel zijn, kunnen we nagaan hoe RIPng omgaat met netwerkfouten. 

==Om dit te evalueren gaan we moedwillig een netwerkfout introduceren in ons netwerk:==

1. Om dit te kunnen monitoren, starten we `wireshark` op verschillende routers
2. Start een `ping` tussen host `a`  en `c` .
3. Log in op router `r1` en bepaal de naam van de interface naar router `r7`:  deactiveer de bijhorende interface met `ip link set dev <ifnaam> down`. 


==Hoeveel seconden werd de verbinding verbroken en welke RIPng berichten werden uitgewisseld tussen welke nodes vooraleer de verbinding opnieuw beschikbaar werd?==





# BGP

In dit labo gaan we onderzoeken hoe routering werkt in het Internet tussen verschillende autonome systemen. 

![[Gebruik van Mininet]]

<div style="page-break-after: always;"></div>

![[Linux command-line]]

**Afhalen en uitpakken van de labobestanden**

Op de VM, in de folder `/home/student` (de default folder) doe je het volgende in een shell:

```shell
/home/student$ wget https://www.dropbox.com/s/026i2pd7gsmzyf2/labo10.tgz
/home/student$ tar -xzvf labo10.tgz
```

<u>**Update (11-05-2022)**</u>: om ook het policy-gerelateerde gedeelte van dit labo te kunnen maken moet de volgende patch toegepast worden!

```
/home/student$ cd /home/student/labo10/ipmininet  
/home/student/labo10/ipmininet$ sudo pip3 install -e .
```

Mogelijks zie je hierbij enkele warnings, maar die mag je negeren.

## BGP in het huidige Internet

In het [BGP update report](https://bgpupdates.potaroo.net/instability/bgpupd.html) dat dagelijks bijgewerkt wordt vinden we enkele BGP cijfers i.v.m. het aantal messages, (IPv4) prefixen en het total AS aantal van ons huidige Internet. 

==Zoek hierin op hoeveel IPv4 netwerk prefixen en ASen telt het huidige Internet volgens deze cijfers?==

In een [rapport van AS 6447](https://bgp.potaroo.net/as6447/) vind je ook gegevens over de routing- en forwardingtabel van routers binnenin dit Autonoom Systeem.

==Wie is de eigenaar van AS 6447?==

==Mocht je `ip route` op een BGP router doen binnen AS6447, hoeveel resultaatregels (entries) verwacht je dan?==

==Van welke prefixlengte vinden we het meest entries in dergelijke forwardingtabel?==

## BGP in een mini-Internet

Voor dit labo gaan we BGP bestuderen in de context van een kleinschalig Internet bestaande uit slechts 6 ASen en 8 routers. Om dit netwerk op te starten, gebruiken we Mininet. Je laadt het netwerk als volgt:

```Shell
/home/student/labo10$ sudo -s  
root# python3 bgplabo.py
```

### Netwerkanalyse

Ons mini-Internet bestaat uit slechts 8 routers. Alle subnetten in ons netwerk maken gebruik van `/24` adresblokken onder het adresblok `192.168.0.0/16`. In de praktijk kunnen deze adressen uiteraard niet gebruikt worden in het publieke Internet (waarom niet?). 

Aan iedere router hangt een host met de naam `hrx` waarbij x staat voor het routernummer. `hr3` is bijvoorbeeld rechtstreeks verbonden met router `r3`. Om de figuur overzichtelijk te houden, werden de hosts niet afgebeeld maar enkel de interface die verbinding geeft tot de host. De `.2.` bij de link bovenaan `r1` duidt aan dat de host die met `r1` verbonden is in het subnet `192.168.2.0/24` ligt.

![[bgp-topology]]

Ons mini-Internet wordt uiteraard niet beheerd door 1 partij, maar door 6 verschillende partijen, elk verantwoordelijk voor 1 Autonoom Systeem (AS).

==Bepaal op basis van de gegevens in de BGP daemon software van verschillende routers tot welk AS iedere router behoort, en maak op basis hiervan een figuur of tabel.==

>[!Tip] Inloggen op management interface van de BGPd 
>
>- Start een `xterm` op de router die je wil raadplegen
>- `telnet localhost bgpd` in de command line. Het paswoord dat vervolgens wordt gevraagd, is zoals steeds `zebra`. 
>- Eenmaal ingelogd, kun je a.d.h.v. `show ip bgp` de RIB info opvragen. Gebruik TAB om mogelijke subcommando's te achterhalen. De uitvoer van de RIB van een router zie in het voorbeeld hieronder.
>- Als alternatief kun je meteen `noecho <node> telnet localhost bgpd` gebruiken vanuit de Mininet shell. 

![[frr-bgpd-show-rib.png]]

<img src="img/image-20220512152039864.png" alt="image-20220512152039864" style="zoom:50%;" />

In deze interface vind je cruciale gegevens m.b.t.: de gegeven router, de ontvangen routes en zijn BGP configuratie. Merk op dat alle bruikbare (valid) routes een asterisk aan het begin van de lijn. Bij de routes vind je in de laatste kolom de padvector die kan gebruikt worden per bestemming. De laatste hop wordt steeds als "?" weergegeven, en betekent dat die rechtstreeks verbonden is aan de laatste hop (en dus niet noodzakelijk "incomplete").

==Wat is de gebruikte route van `hr4` naar `hr7`?==

```
traceroute to 192.168.17.1 (192.168.17.1), 30 hops max, 60 byte packets
 1  r4 (192.168.10.2)  0.052 ms  0.007 ms  0.003 ms
 2  r5 (192.168.9.2)  0.016 ms  0.005 ms  0.004 ms
 3  r6 (192.168.11.2)  0.016 ms  0.005 ms  0.006 ms
 4  r7 (192.168.15.2)  0.017 ms  0.007 ms  0.006 ms
 5  hr7 (192.168.17.1)  0.029 ms  0.011 ms  0.008 ms

```

==Waarom werd deze route gekozen en niet een pad met minder tussenliggende routers?==

Omdat hij dan door meer AS'en moet gaan.

- Wat is het IP adres van de bestemming?
- Welke routing padvectoren zijn in BGP beschikbaar voor die bestemming in de verschillende routers?

==Niet alle netwerkprefixen staan op de netwerktopologie afgebeeld.  In de management interface van bgpd kun je zien dat er aan elk AS nog een extra prefix verbonden is. Over welke prefixen gaat het en aan welk ASen zijn ze verbonden?==

| Netwerkprefix   | AS   | Router |
| --------------- | ---- | ------ |
| 192.168.19.0/24 | 6    | R1     |
| 192.168.20.0/24 | 5    | R2     |
| 192.168.21.0/24 | 4    | R3     |
| 192.168.22.0/24 | 1    | R4     |
| 192.168.23.0/24 | 2    | R5     |
| 192.168.24.0/24 | 2    | R6     |
| 192.168.25.0/24 | 3    | R7     |
| 192.168.26.0/24 | 2    | R8     |

### Protocolanalyse

De routering in dit mini-Internet werd volledig automatisch opgebouwd door routeringsprotocollen. Je kan dit valideren door `ping4all` in Mininet uit te voeren. Als alles goed ging, heeft (bijna) iedere host verbinding met iedere andere host in het mini-Internet. Een host mist connectiviteit. Daarop komen we later terug.

Maak gebruik van Wireshark om op iedere link na te gaan welk protocol gebruikt wordt tussen de 2 aangrenzende nodes.

BGP wisselt enkel berichten uit wanneer dat nodig is. 

- `BGP UPDATE` messages worden slechts uitgewisseld wanneer iets in het netwerk verandert. 
- `BGP KEEPALIVE` berichten zorgen ervoor dat BGP sessies levend gehouden worden door periodiek berichten uit te wisselen.

In het bestand `\home\student\labo10\bgp-r1r2-trace.pcap` vind je de eerste 30 uitgewisselde BGP berichten tussen router `r1` en router `r2`. Daarin kun je `BGP UPDATE` messages terug vinden.

==Leg uit welk `BGP UPDATE` message van `r1` naar `r2` m.b.t. de bestemming in adresblok `192.168.2.0/24` heeft geleid tot een specifieke regel in de RIB van `r2`.==

- Welk transportlaagprotocol gebruikt BGP? TCP
- Welke informatie heeft `r1` over dit netwerkprefix gedeeld met `r2`? `next hop 192.168.0.2`
- Hoe heeft `r2` dit verwerkt (hoe check je dit)?

**Netwerkfout**

Netwerkfouten in het Internet zijn legio. Om te achterhalen hoe BGP omgaat met een linkfout, gaan we een klein experiment uitvoeren. Achterhaal via Mininet de gebruikte interfaces voor de link tussen router `r1` en `r2`. 

`r1-eth0<->r2-eth0`

Om na te gaan hoe snel BGP kan omgaan met een falende link, gaan we het ==volgende uitvoeren==:

- Start een ping-sessie van `r2` naar `hr1`. Pas het interval van de ICMP-berichten aan naar 0.1 sec (de manual pages helpen je hierbij).
- Disable de link tussen `r1` en `r2` aan de hand van het commando `ip link set dev <interfacenaam> down` op de router `r1`.
- Stop de ping-sessie en achterhaal hoeveel pakketten verloren zijn gegaan om een indicatie te krijgen van hoe snel de connectie hersteld is. Maar 1tje??
- Controleer nu wat veranderd is in de RIB informatie van router `r2` en of de BGP peering relationship met `r1` nog steeds actief is.
- Gebruik traceroute om eventueel de (nieuwe) route van `r2` naar `hr1` te bepalen.

```
traceroute to 192.168.2.2 (192.168.2.2), 30 hops max, 60 byte packets
 1  r3 (192.168.3.2)  0.025 ms  0.004 ms  0.003 ms
 2  r1 (192.168.1.1)  0.014 ms  0.004 ms  0.004 ms
 3  hr1 (192.168.2.2)  0.014 ms  0.006 ms  0.006 ms
```

<img src="img/image-20220512152039864.png" alt="image-20220512152039864" style="zoom:50%;" />

==Geef in je verslag de gemeten convergentietijd (tot op 0.1 sec nauwkeurig), evenals de route voor en na de netwerkfout.== 

ongeveer 0.1 (1 pakketje is weggevallen)

==Kon BGP pas de nieuwe route activeren toen het gedetecteerd had dat de BGP sessie tussen `r2` en `r1` niet meer actief was? Geef een mogelijke uitleg.==

**Heractivering** van de link

In dit onderdeel ga je de link en bijhorende BGP sessie tussen `r1` en `r2` heractiveren en de invloed ervan in BGP achterhalen. ==Ga hiervoor als volgt te werk==:

- Start een wiresharksessie op `r2` op de interface naar `r1`
- Start een ping-sessie van `r2` naar `hr1`. Pas het interval van de ICMP- berichten aan naar 0.1 sec.    
- Re-enable de link tussen `r1` en `r2` aan de hand van het commando `ip link set dev <interfacenaam> up` op de router `r1`. 
- Stop de ping-sessie en achterhaal hoeveel pakketten verloren zijn gegaan om een indicatie te krijgen van hoe snel de connectie hersteld is. 
- Controleer nu wat veranderd is in de RIB informatie van router `r2` en of de BGP peering relationship met `r1` nog steeds actief is. 
- Gebruik traceroute om de (nieuwe) route van `r2` naar `hr1` te bepalen.

Als het bovenstaande proces goed is verlopen, dan is de connectiviteit via het oorspronkelijke pad hersteld, en zijn de RIBs van `r1` en `r2` opnieuw up to date.

Op basis van de opgenomen Wireshark-activiteit kun je achterhalen hoe en hoe lang dit BGP proces heeft plaats gevonden.

==Maak een overzicht van de uitgewisselde BGP berichten sinds het herstel van de fout, en bepaal hieruit hoeveel tijd BGP nodig had om te convergeren.==

### Disconnected host

Op basis van het commando `ping4all` in Mininet konden we eerder detecteren dat 1 host geen verbinding lijkt te hebben met alle andere hosts in het mini-Internet.

==Over welke node gaat het?==

==Waarom heeft die node geen connectiviteit?==

==Welke nodes zijn wel bereikbaar vanaf die host (waarom)?==

Het is instructief om de BGP configuratie van enkele routers even te bekijken, en mogelijks aan te passen om dit probleem te verhelpen. De configuratie kun je enkel bekijken in *management mode*. 

> [!Tip] Activeer management mode in bgpd
>
> - log in op de BGP daemon via `telnet localhost bgpd` (paswoord `zebra`)
> - ga in de *management mode* via het commando `enable

>[!Tip] Bekijk running configuration van BGP router
>In de management mode van bgpd het volgende uit te voeren:
>
>- `show running-config`  

De meest relevante onderdelen van een BGP configuratie zijn benoemd in volgende configuratieovoorbeeld van `r5`.  

![[BGP-config.svg]]

De (her-)configuratie van routers kan zoals in hedendaagse commerciele routers van Cisco of Juniper niet alleen tijdens het opstarten gebeuren, maar ook na de opstart kan die configuratie aangepast worden. Hiervoor moet je ook de configuratieterminal activeren.

> [!Tip] Activeer de configuratieterminal
>
> - `enable` (om management mode te activeren) 
> - `configure terminal` om in de configuratieterminal te komen.

In de configuratieterminal kunnen letterlijk dezelfde commando's als in het configuratiebestand ingegeven worden.  Let wel op, wanneer de tekst in configuratiebestand is ingesprongen, dan moet je eerst het de bovenliggende instructie ingegeven die niet ingesprongen was (bv. `address-family ipv4 unicast` vooraleer je een neighbor kan activeren met `neighbor <ip> activate`).

==Pas de BGP configuratie aan van enkele routers zodat, ook de resterende host bereikbaar wordt vanuit alle andere hosts.==

### Netwerkpolicies in BGP

Het succes van BGP als inter-AS routeringsprotocol in het Internet is grotendeels te wijten aan het feit dat BGP toelaat aan netwerkbeheerders om de routering aan te passen aan de *business agreements* tussen verschillende partijen.

Hiervoor kan BGP gebruik maken van 2 mechanismen:

1. Beperken aan wie bepaalde routes beschikbaar worden gemaakt
2. Kiezen of ordenen welke van de ontvangen routes naar een gegeven bestemming worden verkozen boven alternatieve routes

**No transit AS2**

AS2 heeft een centrale ligging in ons mini-Internet. Bijgevolg ligt AS2 vaak op het kortste pad tussen verschillende nodes in het netwerk. Je kunt dit bijvoorbeeld nagaan door de route tussen `hr4` en `hr7` in beide richtingen te inspecteren.

==Wat is de gevonden route tussen `hr4` en `hr7`?==

Gezien de beperkte capaciteit van het netwerk, wenst de beheerder van AS2 dergelijk doorgangsverkeer onmogelijk te maken. De netwerkbeheerder gaat hiervoor geen gebruik maken van firewalls, maar zal verhinderen dat BGP bepaalde routes naar netwerkprefixen adverteert aan zijn peers. Routes die niet geadverteerd worden, kunnen in principe ook niet gebruikt worden door aangrenzende autonome systemen. De netwerken binnen AS2 moeten uiteraard wel nog toegankelijk zijn voor de rest van het mini-Internet.

==Welke netwerkprefixen mogen dan wel en niet geadverteerd worden door de routers van AS2?==

- routers van AS2:
- netwerkprefixen te adverteren: 

Om dit te bewerkstelligen, kunnen we gebruik maken van routemaps en communitylists in BGP:

- met **BGP routemaps** kunnen regels bepaald worden voor inkomende en uitgaande BGP berichten (routes) naar een gegeven buur
- met **BGP communities** kun je routes labelen zodat je ze kunt gebruiken in de regels van routemaps.

Beide zaken kun je eenmaal in managementmode als volgt achterhalen.

> [!Tip] Check routemap
> De routemaps die reeds werden aangemaakt, kunnen in *management mode* als volgt geraadpleegd worden:
>
> - gebruik `show route-map` om alle bestaande route-maps te zien.

Een voorbeeld van de output van bovenstaande proces kun je vinden in onderstaande figuur. Hieruit is het duidelijk dat er 2 route-maps per BGP neighbor (i.e. per bijhorende interface) gedefinieerd zijn: 1 routemap voor BGP routes die ontvangen worden van die BGP neighbor (bv. `r3-ipv4-in`), en 1 routemap voor BGP routes die doorgestuurd worden naar die BGP neighbor (bv. `r3-ipv4-out`). In het gegeven voorbeeld hebben de routemaps geen toegevoegde waarde, aangezien ze alle mogelijke routes toelaten en er geen bijkomende acties op uitvoeren.

![[frr-bgpd-routemap.png]]

Routes die een AS ontvangt van een neighboring AS kunnen gemarkeerd worden zodat ze niet verder geëxporteerd worden naar andere BGP neighbors. Dit doe je als volgt.

> [!Tip] Routes markeren om ze niet te exporteren
> Geef volgende in, *in de configuratieterminal* om routemaps niet te exporteren.
>
> - `# route-map rx-ipv4-in permit 10` (verander rx naar `r3` indien je de inkomende routes van `r3` wil vlaggen) 
>   - (config) # `set community no-export`
>   - (config) # `quit`

De bovenstaande actie zorgt ervoor dat aan de routemap `rx-ipv4-in` (inkomend verkeer van router rx) met hoge prioriteit (10) elke route wordt gekoppeld/gemarkeerd met de community `no-export`. Iedere route wordt vervolgens weerhouden (permit). Wanneer routes eenmaal als volgt zijn gevlagd, zullen ze NIET verder worden geadverteerd aan (of geëexporteerd naar) andere neighboring ASen.

Voer deze stappen uit voor alle interfaces waarvoor je het nodig acht om ervoor te zorgen dat AS2 niet als transit AS kan gebruikt worden. Zet vooraleer je die stappen onderneemt ook een Wiresharksessie op over de interfaces waarop veranderingen zullen optreden. Zo kun je de uitgewisselde BGP messages n.a.v. de wijziging noteren.

Documenteer voor welke router(s) en interfaces je dit proces hebt gevolgd. 

==Welke BGP berichten werden uitgestuurd naar aanleiding van je wijziging op de betrokken interfaces?==

==Geef de output terug van een traceroute van `hr4` naar `hr7` nadat je dit gedaan hebt om te valideren of AS2 daadwerkelijk niet meer als transit gebruikt wordt.==

> [!Tip] Rechtzetten van routemap configuratiefouten
> Indien je een fout hebt gemaakt, heb je 2 mogelijkheden om dit recht te zetten:
>
> 1. Herstart de volledige Mininet-omgeving met je netwerk.
> 2. Verwijder de routemap a.d.h.v. `no route-map <routemapnaam>` in de configuratieomgeving
> 3. Configureer de routemap opnieuw zoals de configuratie die reeds beschikbaar was in de routemap voordat je hem verwijderde. Deze kan je terugvinden in de BGP configuratiebestanden van de routers in het bestand `\tmp\bgpd_rx.cfg` voor router `rx`. Ook die andere reeds bestaande regels hoor je opnieuw toe te voegen voor een goede werking. 

**Lokale policy in AS5**

Eenmaal bovenstaande oefening succesvol is uitgevoerd, verloopt veel verkeer via de link tussen AS5 en AS4. Nu kan het immers niet wenselijk zijn dat verkeer die link gebruikt (bvb. lage bandbreedte), waardoor de netwerkbeheerders van AS5 en AS4 verkiezen dat verkeer via AS6 loopt i.p.v. via de link tussen AS5 en AS4.

Dit kunnen beide beheerders (van AS5 en AS4) bewerkstelligen door alle routes ontvangen van AS6 te markeren met een hogere local preference waarde (hoger dan de standaard waarde van 100).

> [!Tip] Local preference instellen in route-map
> In de configuratieterminal (zie vorig kader), kun je de local preference als volgt instellen
>
> - `route-map rx-ipv4-in permit 10` (verander `rx` naar `r3` indien je de inkomende routes van `r3` wil markeren)
>   - (config) # `set local-preference 200`
>   - (config) # `quit`    

==Documenteer voor welke router(s) en interfaces je dit proces hebt gevolgd.==

==Welke BGP berichten werden uitgestuurd naar aanleiding van je wijziging op de betrokken interfaces?==

==Geef de output terug van een traceroute van `hr4` naar `hr7` nadat je dit gedaan hebt om te valideren of de verbinding tussen AS5-AS4 daadwerkelijk niet meer gebruikt wordt.==

