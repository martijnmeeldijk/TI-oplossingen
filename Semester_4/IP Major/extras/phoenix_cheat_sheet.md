# Phoenix Cheat Sheet

Het leek me handig om een klein overzicht te hebben van de nuttige commando's voor tijdens het examen.

Een paar links met phoenix cheat sheets 

[devhints.io](https://devhints.io/phoenix)

[benbarber](https://github.com/benbarber/phoenix-cheatsheet)



## Generators

### Crud

```elixir
mix phx.gen.html UserContext User users username:string hashed_password:string role:string
```

en dit in de controller

```elixir
resources "/users", UserController
```

### Context

```elixir
mix phx.gen.context AnimalContext Animal animals name:string user_id:references:users
```

### Json resource

```elixir
mix phx.gen.json AnimalContext Animal animals name:string dob:string cat_or_dog:string user_id:references:users
```

### Associations 

Je kan associations (bijvoorbeeld een 1 op n relatie) ook genereren. Dit zie je in het commando onder **Context**



## i18n

### Nieuwe taal toevoegen

```bash
mix gettext.merge priv/gettext --locale ja
```

Wie weet moeten we op het examen een nieuwe taal toevoegen :wink:

### Extract

```bash
mix gettext.extract --merge
```

Dit commando genereert/refresht je translation files.



## Webpack

### Build

```bash
webpack -d
```



## Ecto

Creates the required databases ready for any migrations to be run

```bash
mix ecto.create
```

Run your applications migrations

```
mix ecto.migrate
```

Drop the database and run all migrations

```
mix ecto.reset
```

Database droppen

```
mix ecto.drop
```

