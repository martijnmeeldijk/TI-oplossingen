# Routing & Switching pka solutions

Commands zijn geschreven in een "logische" volgorde.
Context zal gegeven worden waar nodig.

Probeer dit niet vlak over te nemen. Ik heb hier zelf redelijk wat tijd in gestoken. Het is niet supermoeilijk om 70% te halen. Het examen is met open internet, dit wilt dus zeggen als je een commando niet weet je dit makkelijk kan googlen. Doe dit ook als je deze oefeningen probeert te maken.

Success en stel vragen waar nodig.

## PT_pre test1. pka solution

Deze oefening gaat vooral over ipv4 en ipv6 toekennen, basisconfiguraties en routing.
Ik heb deze oefening op 1 uur en 45 min afgewerkt zonder al teveel extra opzoekwerk. (Alles staat zeer duidelijk in de netacad cursus)

#### Step 1: Basic device configuration

- Main:
    - router(config)# hostname Main
    - router(config)# enable secret cisco
    - router(config)# no ip domain-lookup
    - router(config)# enable secret cisco
    - secure vty and console lines
        - router(config)# line vty 0 15
        - router(config-line)# password class
        - router(config)# line console 0
        - router(config-line)# password class
        - router(config-line)# login
    - router(config)# service password-encryption
    - router(config)# banner motd $ Epic gamer time $
    - router(config-if) description beschrijving (Dit moet je voor iedere interface doen!)

#### Step 2: Configure default, static & floating static routes

- Main:
    - Interface configuration
        - router(config)# interface S0/0/0 (dit moet ook voor S0/0/1 en S0/1/1 gebeuren)
        - router(config-if)# ip address 128.107.0.1 255.255.255.252 (ipv4 address)
        - router(config-if)# ipv6 address 2001:DB8:2:1::1/64 (ipv6 address)
        - router(config-if)# ipv6 address FE80::1 link-local (link local address)
        - router(config-if)# no shut (enable interface)
    - 2 directly connected static routers on main to reach the ipv4 lans on router bldg-1
        - router(config)# ip route 10.10.1.0 255.255.255.0 10.10.20.2 (ip route naar lan via ip 10.10.20.2 : S0/0/0 van Bldg-1)
        - router(config)# ip route 10.10.2.0 255.255.255.0 10.10.20.2 (ip route naar lan via ip 10.10.20.2 : S0/0/0 van Bldg-1)
    - 2 directly connected static rotuers on main to reach the ipv6 lans on router bldg-1
        - router(config)# ipv6 route 2001:DB8:1:A::A/64 2001:DB8:1:1::2 (route naar ipv6 lan via ip 2001:DB8:1:1::2 : S0/0/0 van Bldg-1)
        - router(config)# ipv6 route 2001:DB8:1:B::A/64 2001:DB8:1:1::2 (route naar ipv6 lan via ip 2001:DB8:1:1::2 : S0/0/0 van Bldg-1)
    - Configure directly connected IPv4 default static routes to reach hosts outside of the network.
        - router(config)# ip route 0.0.0.0 0.0.0.0 128.107.0.0 (primary)
        - router(config)# ip route 0.0.0.0 0.0.0.0 128.107.0.4 2 (floating)
    - Configure directly connected IPv6 default static routes to reach hosts outside of the network.
        - router(config)# ipv6 route ::/0 2001:DB8:2:1:: (primary)
        - router(config)# ipv6 route ::/0 2001:DB8:3:1:: 2 (floating)

__Sidenote: enable ipv6 unicast-routing via dit commando: router(config)# ipv6 unicast-routing__

- Bldg-1:
    - Interface configuration
        - Zelfde als bij Main. dit kan je zelf wel
    - Directly routed link from Bldg-1 to internet ipv4
        - Bldg-1(config)#ip route 0.0.0.0 0.0.0.0 10.10.20.1
    - Directly routed link from Bldg-1 to internet ipv6
        - Bldg-1(config)#ipv6 route ::/0 2001:DB8:1:1::1

- Host configuration
    - Host A:
        - ip address : 10.10.1.20
        - subnet: 255.255.255.0
        - Default gateway: 10.10.1.254
        - DNS: 64.100.10..10

        - ipv6 address: 2001:DB8:1:A::A / 64
        - ipv6 gateway: FE80::2
        - DNSv6 server: 2001:DB8:FF:F::10 
    - Host B:
        - ip address : 10.10.2.20
        - subnet: 255.255.255.0
        - Default gateway: 10.10.2.254
        - DNS: 64.100.10..10

        - ipv6 address: 2001:DB8:1:A::A / 64
        - ipv6 gateway: FE80::2
        - DNSv6 server: 2001:DB8:FF:F::10 

## PT_pre test2. pka solution

### Step 1: Determine addressing
We moeten beslissen welke addressen we gaan gebruiken in deze oefening. We gebruien hierbij de addressing list en wat eigen inspiratie.
Hier zijn de addressen die ik heb gebruikt. Lees zeker goed na of je een eigen ip mag kiezen of je een specifiek adres moet gebruiken!

- HQ : 
    - G0/0.20 : 172.16.20.254 / 24 
    - G0/0.40 : 172.16.40.254 / 24 
    - G0/0.60 : 172.16.60.254 / 24 
    - G0/0.88 : 172.16.88.254 / 24
    - G0/1.250 : 172.16.250.254 / 24
    - G0/1.254 : 172.16.254.254 / 24
- Mgmt :
    - SVI : 172.16.88.200 / 24
- Acct : 
    - SVI : 172.16.88.100 / 24
- HR : 
    - SVI : 172.16.88.50 / 24
- Clerical A:
    - IPv4 : 172.16.20.20
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.20.254
    - DNS : 172.16.254.252
- Acct A:
    - IPv4 : 172.16.40.20
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.40.254
    - DNS : 172.16.254.252
- HR A:
    - IPv4 : 172.16.60.20
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.60.254
    - DNS : 172.16.254.252
- Clerical B:
    - IPv4 : 172.16.20.21
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.20.254
    - DNS : 172.16.254.252
- Acct B:
    - IPv4 : 172.16.40.21
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.40.254
    - DNS : 172.16.254.252
- HR B:
    - IPv4 : 172.16.60.21
    - Subnet : 255.255.255.0
    - Default-gateway : 172.16.60.254
    - DNS : 172.16.254.252

### Step 2: Configure initial device settings on Mgmt and HQ
Hier stellen we de sitch mgmt en router hq in met de initiele settings:

- HQ Router :
    - Router()> en
    - Router()# conf t
    - Router(config)# hostname HQ
    - HQ(config)# no ip domain-lookup
    - HQ(config)# enable secret cisco
        - HQ(config)# line vty 0 15
        - HQ(config-line)# password cisco
        - HQ(config-line)# login
        - HQ(config-line)# exit
    - HQ(config)# line console 0
        - HQ(config-line)# password cisco
        - HQ(config-line)# login
        - HQ(config-line)# exit
    - HQ(config)# service password-encryption

- Mgmt Switch :
    - Switch()> en
    - Switch()# conf t
    - Switch(config)# hostname Mgmt
    - Switch(config)# enable secret cisco
    - Switch(config)# line vty 0 15 
        - Switch(config-line)# password cisco
        - Switch(config-line)# login
        - Switch(config-line)# exit
    - Switch(config)# line console 0
        - Switch(config-line)# password cisco 
        - Switch(config-line)# exit 
    - Switch(config)# service password-encryption 

### Step 3: Configure VLAN's
Herhaal deze stappen ook voor de HR en Acct switches.

- Mgmt Switch : 
    - Mgmt()> en
    - Mgmt()# conf t
        - Mgmt(config)# vlan 20
            - Mgmt(config-vlan)# name Clerical
            - Mgmt(config-vlan)# exit
        - Mgmt(config)# interface vlan 20
            - Mgmt(config-if)# no shut
            - Mgmt(config-if)# exit
        - Mgmt(config)# vlan 40
            - Mgmt(config-vlan)# name Acct
            - Mgmt(config-vlan)# exit
        - Mgmt(config)# interface vlan 40
            - Mgmt(config-if)# no shut
            - Mgmt(config-if)# exit
        - Mgmt(config)# vlan 60
            - Mgmt(config-vlan)# name HR
            - Mgmt(config-vlan)# exit
        - Mgmt(config)# interface vlan 60
            - Mgmt(config-if)# no shut
            - Mgmt(config-if)# exit
        - Mgmt(config)# vlan 88
            - Mgmt(config-vlan)# name NetAdmin
            - Mgmt(config-vlan)# exit
        - Mgmt(config)# interface vlan 88
            - Mgmt(config-if)# no shut
            - Mgmt(config-if)# exit

### Step 4: Assign Switch interfaces to VLAN
Herhaal dit ook voor de HR switch.

- Acct Switch : 
    - Acct()> en
    - Acct()# conf t
        - Acct(config)# interface range f0/1 - 5
            - Acct(config-if-range)# switchport mode access
            - Acct(config-if-range)# switchport access vlan 20
            - Acct(config-if-range)# exit
        - Acct(config)# interface range f0/6 - 10
            - Acct(config-if-range)# switchport mode access
            - Acct(config-if-range)# switchport access vlan 40
            - Acct(config-if-range)# exit
        - Acct(config)# interface range f0/11 - 15
            - Acct(config-if-range)# switchport mode access
            - Acct(config-if-range)# switchport access vlan 60
            - Acct(config-if-range)# exit

### Step 5: Configure the Switches for remote management
Hier gaan we VLAN 88 configureren wodat de switches hierover kunnen communiceren
Herhaal deze stappen ook voor Mgmt en HR switches

__Vergeet hier niet de juiste waarden van de ip voor iedere switch te nemen. (Zie Step1)__

- Mgmt Switch :
    - Mgmt()> en
    - Mgmt()# conf t
    - Mgmt(config)# interface vlan 88
    - Mgmt(config-if)# ip add 172.16.88.200 255.255.255.0
    - Mgmt(config-if)# exit
    - Mgmt(config)# ip default-gateway 172.16.88.254

    Hier moet misschien nog iets bij.

### Step 6: Configure VLAN trunking
Trunking tussen de switches. Dit moet je doen voor deze poorten:
- Mgmt switch:
    - Fa0/23
    - Fa0/24
- Acct switch:
    - Fa0/23
- HR switch:
    - Fa0/24

Voorbeeld Mgmt Fa0/23:
- Mgmt(config)# interface fa0/23
- Mgmt(config-if)# switchport mode trunk
- Mgmt(config-if)# switchport trunk allowed vlan 20,40,60,88
- Mgmt(config-if)# no shut
- Mgmt(config-if)# exit

### Step 7: Configure inter vlan routing
Hier gaan we de G0/0 en G0/1 interfaces van HQ instellen dat ze de juiste vlans hebben
Dit moeten we doen voor vlan 20 - 40 - 60 - 88 - 250 - 254

- HQ()# conf t
- HQ(config)# interface g0/0.20
- HQ(config-if)# encapsulation dot1Q 20
- HQ(config-if)# ip add 172.16.20.254 255.255.255.0
- HQ(config-if)# interface g0/0.40
- HQ(config-if)# encapsulation dot1Q 40
- HQ(config-if)# ip add 172.16.40.254 255.255.255.0
- HQ(config-if)# interface g0/0.60
- HQ(config-if)# encapsulation dot1Q 60
- HQ(config-if)# ip add 172.16.60.254 255.255.255.0
- HQ(config-if)# interface g0/0.88
- HQ(config-if)# encapsulation dot1Q 88
- HQ(config-if)# ip add 172.16.88.254 255.255.255.0
- HQ(config-if)# interface g0/1.250
- HQ(config-if)# encapsulation dot1Q 250
- HQ(config-if)# ip add 172.16.250.254 255.255.255.0
- HQ(config-if)# interface g0/1.254
- HQ(config-if)# encapsulation dot1Q 254
- HQ(config-if)# ip add 172.16.254.254 255.255.255.0

### Step 8: Configure Host Addressing
Test hier eerst op een pc in zijn console of je ping www.cisco.com kan doen. De eerste ping zal timeout zijn maar daarna moet je normaal een connectie hebben.

### Step 9: Configure Access Control lists
De vty op HQ zijn al secure (Zie step 2)
a. Max 1 ACL statement
- HQ()# conf t
- HQ(config)# access-list 10 permit 172.16.60.0 0.0.0.255
b. Max 2 ACL statement
- HQ()# conf t
- HQ(config)# ip access-list standard INT-WEB
- HQ(config-std-nacl)# permit 172.16.40.0 0.0.0.255
- HQ(config-std-nacl)# permit 172.16.60.0 0.0.0.255 



### Step 10: Addenda

Hier zijn nog een aantal commando's die je moet invullen om het volledig in orde te maken

HQ(config)# line vty 0 15
HQ(config)# access-class 10 in

HQ(config)# interface g0/1.250
HQ(config)# ip acces-group INT-WEB out

Het kan zijn dat je niet 100% haalt, ik heb zelf de guide gevolgd en ik kwam op 97% uit toen ik de oefening opnieuw maakte. Ik weet niet exact welke stappen ik gemist heb. Let me know en verbeter gerust.

Good job, je bent nu een stap dichter tot een 20/20 voor Routing en switching