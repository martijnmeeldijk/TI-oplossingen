# Routing & Switching pka solutions

Commands zijn geschreven in een "logische" volgorde.
Context zal gegeven worden waar nodig.

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

Dit is niet 100% juist. maak gerust verbeteringen. ik heb momenteel 71% met vooral ip config en vlan te doen.
Good luck

We beginnen met de pc's hun ip addressen toe te kennen. Dit gaat gewoon door op de pc te duwen en naar IP Configuration te gaan.

### PC Ip assignment
    1. Clerical A:
        1. Ipv4 address: 172.16.20.10
        2. SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252
    2. Acct A
        1. Ipv4: 172.16.40.10
        . SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252
    3. HR A
        1. Ipv4: 172.16.60.10
        2. SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252

    4. Clerical B
        1. Ipv4: 172.16.20.20
        2. SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252
    5. Acct B
        1. Ipv4 172.16.40.20
        2.SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252
    6. HR B
        1. Ipv4: 172.16.60.20
        2. SubnetMask: 255.255.255.0
        3. DNS: 172.16.254.252

### Router port assignment

De router HQ heeft sub interfaces op zijn interfaces. Deze moeten geconfigured worden naargelang de vlan
vb. G0/0.20 heeft access op vlan 20

- router(config)# interface g0/0.##
- router(config=subif)# encapsulation dot1Q ## (## representes vlan number)
- router(config-subif)# ip address #.#.#.# subnetmask

Je gaat hier de main interfaces wel nog moeten aanzetten. dit doe je zo:

- router(config)# interface g0/#
- router(config-if)# no shut


### Vlan creation

Op iedere switch en router moeten vlans aangemaakt worden.
Let hier op dat je bij alleen in SRV de juiste vlans aanmaakt en niet deze ook in de andere switches aanmaakt.

+ Switch> en
+ Switch# conf t
+ Switch(config)# vlan ##
+ Switch(config-vlan)# name 'vlan_name'

#### NetAdmin vlan

Dit vlan is bedoelt als management vlan.
Geen van de pc's kan hierop verbinden

ik heb voor vlan 88 de volgende ip's gebruikt

Acct switch : 172.16.88.10/24
Mgmt switch : 172.16.88.20/24
Hr switch : 172.16.88.30/24

#### Vlan 88 config

Acct, HR en Mgmt switch hebben toegang nodig tot vlan 88
Deze ports moeten dus trunk ports zijn.

Switch(config-if)# switchport mode trunk
Switch(config-if)# switchport trunk allowed vlan ##
Switch(config-if)# switchport trunk native vlan ##

### Vlan assignment

Voor iedere vlan moeten de ports assigned worden

+ Switch# interface range fa0/.. - .. 
+ Switch# switchport mode access
+ Switch# switchport access vlan ..

### Securing connections

De router en switches moeten beveiligd worden met een passwoord.
Vty line 0 tem 15

* R# conf t
* R(config)# line vty 0 15
* R(config-line)# enable secret cisco

Doe hetzelfde voor de console line:
* R(config)# line console 0
* R(config-line)# enable secret cisco