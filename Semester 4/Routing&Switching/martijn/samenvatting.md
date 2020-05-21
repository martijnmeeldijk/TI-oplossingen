# Routing & Switching essentials

[TOC]

> :warning:  Ik maak dit voor mezelf. Het kan dat er erg onlogische dingen inzitten. Je mag het document altijd bewerken als je zin hebt.

# Tips and Tricks



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



## Command Hierarchy

Dit vind ik altijd nuttig. Daarom zet ik het hier vanboven.

![hierarchy](img/hierarchy.jpg)



## Port labels

<img src="img/image-20200521184003400.png" alt="image-20200521184003400" style="zoom:33%;" />

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









## Te kunnen voor dit hoofdstuk

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



# Module 2: Switching concepts

Switch Forwarding Methods:

**Store-and-forward switching** - Receives the entire frame and ensures the frame is valid. Store-and-forward switching is Cisco’s preferred switching method. 

**Cut-through switching** – Forwards the frame immediately after determining the destination MAC address of an incoming frame and the egress port. 



Een switch scheidt **collision domains**

een router scheidt **broadcast domains**

een hub vergroot **collision domains**



# Module 3: VLAN's