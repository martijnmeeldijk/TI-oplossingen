# Routing & Switching essentials

[TOC]

> :warning:  Ik maak dit voor mezelf. Het kan dat er erg onlogische dingen inzitten. Je mag het document altijd bewerken als je zin hebt.

> :warning: Je mag deze guide niet lezen, hij bevat gecopyrighted materiaal van Cisco. Deze guide is mijn persoonlijke samenvatting en dient niet geherdistribueert te worden.

# Tips and Tricks

## My to-do list

* OSPF
* 

## Shortcuts

| Commando                           | Afkorting         |
| ---------------------------------- | ----------------- |
| configure terminal                 | conf t            |
| copy running-config startup-config | wr                |
| show ip route                      | sh ip ro          |
| show ip interface brief            | sh ip int brie    |
| show running-config [interface]    | sh ru [interface] |
| interface GigabitEthernet 0/0      | int G0/0          |
|                                    |                   |
|                                    |                   |
|                                    |                   |

## Translating domain server

Oke boys ik heb de superieure fix gevonden als je vas zit op `Translating "azerqdfgfdgq"...domain server (255.255.255.255)` 

<img src="img/Screenshot 2020-05-22 at 13.29.03.png" alt="Screenshot 2020-05-22 at 13.29.03" style="zoom:33%;" />

Ram gewoon een paar keer op dit knopje (fast forward). Dan skip je die timeout van *translating...*

## Command Hierarchy

Dit vind ik altijd nuttig. Daarom zet ik het hier vanboven.

![hierarchy](img/hierarchy.jpg)



## Port labels

<img src="img/image-20200521184003400.png" alt="image-20200521184003400" style="width:40%;" />

Doe in je preferences **always show port labels** aan.

da's handig



# Module 1: Basic Device configuration

**SVI**: Switch Virtual Interface

![image-20200521164259511](img/image-20200521164259511.png)

Checken of je shit werkt:

![image-20200521170749340](img/image-20200521170749340.png)



## SSH 1.3.6

Op de switch:

**ip domain-name cisco.com**

**crypto key generate rsa**

**username admin secret ccna**

**line vty 0 15**

**transport input ssh**

**login local**

**no password**

**exit**









## Commando's

* Passwords instellen
* ssh configureren
* default gateway instellen
* ip adressen op interfaces zetten
* interfaces hernoemen
* apparatuur hernoemen
* motd instellen

Dit allemaal staat normaal in de volgende codefragmenten.

```
Router# configure terminal
Enter configuration commands, one per line.  End with CNTL/Z.
Router(config)# hostname R1
R1(config)# enable secret class
R1(config)# line console 0
R1(config-line)# password cisco
R1(config-line)# login
R1(config-line)# exit
R1(config)# line vty 0 4
R1(config-line)# password cisco
R1(config-line)# login
R1(config-line)# exit
R1(config)# service password-encryption
R1(config)#
```

```
banner motd $ Authorized Access Only! $
```

```
R1(config)# interface gigabitethernet 0/0/0
R1(config-if)# ip address 192.168.10.1 255.255.255.0 
R1(config-if)# ipv6 address 2001:db8:acad:1::1/64 
R1(config-if)# description Link to LAN 1
R1(config-if)# no shutdown
R1(config-if)# exit
R1(config)# interface gigabitethernet 0/0/1
R1(config-if)# ip address 192.168.11.1 255.255.255.0 
R1(config-if)# ipv6 address 2001:db8:acad:2::1/64 
R1(config-if)# description Link to LAN 2
R1(config-if)# no shutdown
R1(config-if)# exit
R1(config)# interface serial 0/0/0
R1(config-if)# ip address 209.165.200.225 255.255.255.252 
R1(config-if)# ipv6 address 2001:db8:acad:3::225/64 
R1(config-if)# description Link to R2
R1(config-if)# no shutdown
R1(config-if)# exit
R1(config)#
```

```
Router# configure terminal
Enter configuration commands, one per line.  End with CNTL/Z.
Router(config)# hostname R1
R1(config)# enable secret class
R1(config)# line console 0
R1(config-line)# password cisco
R1(config-line)# login
R1(config-line)# exit
R1(config)# line vty 0 4
R1(config-line)# password cisco
R1(config-line)# login
R1(config-line)# exit
R1(config)# service password-encryption
R1(config)#
```



## SVI configureren

| **Task**                                         | **IOS Commands**                                       |
| :----------------------------------------------- | :----------------------------------------------------- |
| Enter global configuration mode.                 | `S1# configure terminal`                               |
| Enter interface configuration mode for the SVI.  | `S1(config)# interface vlan 99`                        |
| Configure the management interface IPv4 address. | `S1(config-if)# ip address 172.17.99.11 255.255.255.0` |
| Configure the management interface IPv6 address  | `S1(config-if)# ipv6 address 2001:db8:acad:99::1/64`   |
| Enable the management interface.                 | `S1(config-if)# no shutdown`                           |
| Return to the privileged EXEC mode.              | `S1(config-if)# end`                                   |
| Save the running config to the startup config.   | `S1# copy running-config startup-config`               |

# Module 2: Switching concepts

Switch Forwarding Methods:

**Store-and-forward switching** - Receives the entire frame and ensures the frame is valid. Store-and-forward switching is Cisco’s preferred switching method. 

**Cut-through switching** – Forwards the frame immediately after determining the destination MAC address of an incoming frame and the egress port. 



Een switch scheidt **collision domains**

een router scheidt **broadcast domains**

een hub vergroot **collision domains**



# Module 3: VLAN's

**VLAN trunk**: A trunk is a point-to-point link between two network devices. Kan in meerdere VLAN's zitten.

**FCS**: frame check sequence

Hier nog wat feitjes van netacad:

<img src="img/image-20200522111939325.png" alt="image-20200522111939325" style="width:50%;" />

**Een VLAN tag bevat het volgende** :

- **Type** - A 2-byte value called the tag protocol ID (TPID) value. For Ethernet, it is set to hexadecimal 0x8100.

- **User priority** - A 3-bit value that supports level or service implementation.

- **Canonical Format Identifier (CFI)** - A 1-bit identifier that enables Token Ring frames to be carried across Ethernet links.

- **VLAN ID (VID)** - A 12-bit VLAN identification number that supports up to 4096 VLAN IDs.

  

## Soorten VLANS

* **Native VLAN**: default is die VLAN 1, op de native vlan wordt *untagged* traffic gesmeten. Je kan best een ongebruikte vlan als native vlan configureren.
* **Management VLAN**: ook default op VLAN 1: deze vlan dient voor SHH, telnet enzo. Voor het beheer van je apparatuur.
* **Voice VLAN**: VLAN voor *VoIP* (voice over ip)



## VLAN commando's

### VLAN's

**Vlan aan poort assignen**

![image-20200522112905121](img/image-20200522112905121.png)

`no switchport access vlan` zet de poort terug op vlan 1.

**Vlan maken**

![image-20200522112748651](img/image-20200522112748651.png)

**Vlans tonen**

```
show vlan [brief | id vlan-id | name
vlan-name | summary]
```

**Vlans verwijderen**

```
S1(config-if)# no vlan [vlan-id]
```

**Voice VLAN maken**

```
S3(config)# vlan 20
S3(config-vlan)# name student
S3(config-vlan)# vlan 150
S3(config-vlan)# name VOICE
S3(config-vlan)# exit
S3(config)# interface fa0/18
S3(config-if)# switchport mode access
S3(config-if)# switchport access vlan 20
S3(config-if)# mls qos trust cos <!-dit zet quality of service aan-!>
S3(config-if)# switchport voice vlan 150
S3(config-if)# end
```

> The configuration in the example creates the two VLANs (i.e., VLAN 20 and VLAN 150) and then assigns the F0/18 interface of S3 as a switchport in VLAN 20. It also assigns voice traffic to VLAN 150 and enables QoS classification based on the class of service (CoS) assigned by the IP phone.



### Trunks

Trunk poort maken**

<img src="img/image-20200522111131162.png" alt="image-20200522111131162" style="width:50%;" />

| **Task**                                                   | **IOS Command**                                              |
| :--------------------------------------------------------- | :----------------------------------------------------------- |
| Enter global configuration mode.                           | `Switch# **configure terminal**`                             |
| Enter interface configuration mode.                        | `Switch(config)# **interface** *interface-id*`               |
| Set the port to permanent trunking mode.                   | `Switch(config-if)# **switchport mode trunk**`               |
| Sets the native VLAN to something other than VLAN 1.       | `Switch(config-if)# **switchport trunk native vlan** *vlan-id*` |
| Specify the list of VLANs to be allowed on the trunk link. | `Switch(config-if)# **switchport trunk allowed vlan** *vlan-list*` |
| Return to the privileged EXEC mode.                        | `Switch(config-if)# **end**`                                 |

**Trunk verwijderen/resetten**

<img src="img/image-20200522111243424.png" alt="image-20200522111243424" style="width:50%;" />

**Trunk verifiëren**

```
show interfaces fa0/1 switchport
```



## DTP

**dtp**: Dynamic trunking protocol

> Some Cisco switches have a proprietary protocol that lets them automatically negotiate trunking with a neighboring device. This protocol is called Dynamic Trunking Protocol (DTP). DTP can speed up the configuration process for a network administrator. Ethernet trunk interfaces support different trunking modes. An interface can be set to trunking or nontrunking, or to negotiate trunking with the neighbor interface. Trunk negotiation is managed by DTP, which operates on a point-to-point basis only, between network devices.

uitzetten:

```
S1(config-if)# switchport mode trunk
S1(config-if)# switchport nonegotiate
```

terug aanzetten:

```
S1(config-if)# switchport mode dynamic auto
```



# Module 4: Inter-VLAN Routing

## Legacy inter-vlan routing

<img src="img/image-20200522223258396.png" alt="image-20200522223258396" style="width:50%;" />

zo ziet dat eruit.

> Legacy inter-VLAN routing using physical interfaces works, but it has a significant limitation. It is not reasonably scalable because routers have a limited number of physical interfaces. Requiring one physical router interface per VLAN quickly exhausts the physical interface capacity of a router.





## Router-on-a-Stick Inter-VLAN Routing

<img src="img/image-20200522223817196.png" alt="image-20200522223817196" style="width:50%;" />

dat ziet er zo uit

Je moet de vlans op de switches configureren (dat lukt wel als je het vorige hoofdstuk hebt gedaan)

daarna moet je de router configureren:

```
R1(config)# interface G0/0/1.10 -- de .10 voor vlan 10 (dit is een conventie, geen verplichting)
R1(config-subif)# description Default Gateway for VLAN 10
R1(config-subif)# encapsulation dot1Q 10 -- lees hieronder (1)
R1(config-subif)# ip address 192.168.10.1 255.255.255.0
R1(config-subif)# exit
```

(1)

> **encapsulation dot1q** *vlan_id* **[native]** - This command configures the subinterface to respond to 802.1Q encapsulated traffic from the specified *vlan-id*. The **native** keyword option is only appended to set the native VLAN to something other than VLAN 1.

doe oefening 4.2.7

## Inter-VLAN Routing on a Layer 3 Switch

<img src="img/image-20200522224033400.png" alt="image-20200522224033400" style="width:50%;" />

dat hebben we dan ook alweer gehad.

Hoe doe je dat?

**1. Create the VLANs.**

```
D1(config)# vlan 10
D1(config-vlan)# name LAN10
D1(config-vlan)# vlan 20
D1(config-vlan)# name LAN20
D1(config-vlan)# exit
```

**2. Create the SVI VLAN interfaces.**

```
D1(config)# interface vlan 10
D1(config-if)# description Default Gateway SVI for 192.168.10.0/24
D1(config-if)# ip add 192.168.10.1 255.255.255.0
D1(config-if)# no shut
D1(config-if)# exit
D1(config)#
D1(config)# int vlan 20
D1(config-if)# description Default Gateway SVI for 192.168.20.0/24
D1(config-if)# ip add 192.168.20.1 255.255.255.0
D1(config-if)# no shut
D1(config-if)# exit
```

**3. Configure access ports.**

```
D1(config)# interface GigabitEthernet1/0/6
D1(config-if)# description Access port to PC1
D1(config-if)# switchport mode access
D1(config-if)# switchport access vlan 10
D1(config-if)# exit
D1(config)#
D1(config)# interface GigabitEthernet1/0/18
D1(config-if)# description Access port to PC2
D1(config-if)# switchport mode access
D1(config-if)# switchport access vlan 20
D1(config-if)# exit
```

**4. Enable IP routing.**

> Finally, enable IPv4 routing with the **ip routing** global configuration command to allow traffic to be exchanged between VLANs 10 and 20. This command must be configured to enable inter-VAN routing on a Layer 3 switch for IPv4.

typo in netacad btw

```
D1(config)# ip routing
```

**Je moet ook routing configureren met volgens ospf**

**OSPF**: Open Shortest Path First (een routing protocol)

```
D1(config)# router ospf 10
D1(config-router)# network 192.168.10.0 0.0.0.255 area 0
D1(config-router)# network 192.168.20.0 0.0.0.255 area 0
D1(config-router)# network 10.10.10.0 0.0.0.3 area 0
```



### Troubleshooten

| **Issue Type**              | **How to Fix**                                               | **How to Verify**                                            |
| :-------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| Missing VLANs               | Create (or re-create) the VLAN if it does not exist.Ensure host port is assigned to the correct VLAN. | `**show vlan [brief]****show interfaces switchport****ping**` |
| Switch Trunk Port Issues    | Ensure trunks are configured correctly.Ensure port is a trunk port and enabled. | `**show interfaces trunk****show running-config**`           |
| Switch Access Port Issues   | Assign correct VLAN to access port.Ensure port is an access port and enabled.Host is incorrectly configured in the wrong subnet. | `**show interfaces switchport****show running-config interface****ipconfig**` |
| Router Configuration Issues | Router subinterface IPv4 address is incorrectly configured.Router subinterface is assigned to the VLAN ID. | `**show ip interface brief****show interfaces**`             |

