# IP Major project

Het leek mij handig om eerst een structuur te schrijven voor de ontwikkeling van het project. Omdat een groot deel van de code gegenereerd kan worden met commando's. Ik garandeer niet dat je project gaat werken als je deze guide gebruikt, maar het kan wel helpen. 

## Specificaties

1. User

   1. Username
   2. Password (hashed) + authenticatie
   3. Authorizatie (admin/user...), user mag niet aan de user management pagina
   4. **Je kan al het vorige implementeren door gewoon labo 7 te volgen**
   5. Edit password 
   6. Edit username
   7. Api key genereren
   8. Api key laten zien (plaintext)
   9. User management (CRUD) op admin pagina
   10. Zie wel dat je alle namen (Auth, AuthWeb, auth_web, ...) aanpast naar die van jouw project (Hier heb ik 2 uur op vastgezeten)

2. Dieren

   1. ID
   2. Name
   3. Date of birth
   4. Cat_or_dog

3. Change Username

   1. Een user moet zijn username kunnen aanpassen
   2. Een user moet zijn password kunnen aanpassen (oud password ingeven en nieuw password twee keer, zoals op facebook ofzo)
   3. Een admin moet een user zijn username kunnen aanpassen op de user management pagina
   4. Een admin moet een user zijn password kunnen aanpassen op de user management pagina

4. Multilingual 

   1. 2 talen
   2. Ook error messages

5. Webpack

   1. Page specific JS
      1. Clock
      2. Password check (retype matching) [optioneel?]

6. API

   1. Dieren mogen enkel beheerd kunnen via de API

   2. API key moet veilig zijn (andere users mogen niet aan jouw dieren kunnen)

   3. Installeer zeker **Postman** om je API te testen

      



## Generating project

```
mix phx.new martijn_dieren --umbrella 
```



## CRUD users

```
mix phx.gen.html UserContext User users username:string hashed_password:string role:string
```

toevoegen aan controller:

```
resources "/users", UserController
```



## Security

Zie **lesson_7/guide** in de labos van ip major. 



## Username en password veranderen

Maak een nieuwe controller aan. Maak ook een nieuwe template folder aan. Ook een view. 



## Dieren API

```
mix phx.gen.context AnimalContext Animal animals name:string user_id:references:users
```

```
mix phx.gen.json AnimalContext Animal animals name:string dob:string cat_or_dog:string user_id:references:users
```

Zie **lesson_6/guide/2_cat_context.md** in de labos van ip major. 

"All of this could've mostly be done with `mix phx.gen.json` command. Though you still need to manually make the associations." staat op het einde van dat labo. Dus misschien even de documentatie van dit commando lezen.

https://hexdocs.pm/phoenix/Phoenix.Token.html

Oke; dus wat ik heb gedaan is die mix phx.gen.json gebruikt en mijn files vergeleken met die van Labo 6. Je moet bijvoorbeeld wat kleine aanpassingen maken aan je Animal, AnimalContext en je migrations. Normaal gezien kan je het bijna perfect overschrijven van de gegeven code snippets.



## Multilingual support

Zie **lesson_8/guide** in de labos van ip major. 

Je moet echt gewoon het labo volgen en het werkt.



## Api key

Random string generator

```
def random_string(length) do
  :crypto.strong_rand_bytes(length) |> Base.url_encode64 |> binary_part(0, length)
end

# random_string(64)
```



Api context

```
mix phx.gen.context ApiKeyContext ApiKey apikeys key:string name:string user_id:references:users
```



## Webpack (page specific js)

ik heb dit in mn webpack.config.js gestoken, zo kan ik per pagina specifiek een js file oproepen

```
entry: {
    'app': glob.sync('./vendor/**/*.js').concat(['./js/app.js']),
    'clock': glob.sync('./vendor/**/*.js').concat(['./js/clock.js']),
    'password_check': glob.sync('./vendor/**/*.js').concat(['./js/password_check.js'])
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, '../priv/static/js')
  },
```

