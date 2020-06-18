Table of Contents
=================

   * [Labo 5 - CRUD](#labo-5---crud)
      * [Create operation](#create-operation)
      * [Read operation](#read-operation)
      * [Update operation](#update-operation)
      * [Delete operation](#delete-operation)
      * [Associations](#associations)
   * [Labo 6 - Users &amp; Cats (crud &amp; api)](#labo-6---users--cats-crud--api)
      * [Setup demo - the user has cats project](#setup-demo---the-user-has-cats-project)
      * [Configuring our cat context](#configuring-our-cat-context)
         * [Adjust the migration](#adjust-the-migration)
         * [Adjust the schema](#adjust-the-schema)
      * [Controller &amp; Routes](#controller--routes)
         * [Routes - nested resources](#routes---nested-resources)
         * [Router scopes](#router-scopes)
         * [Pipelines](#pipelines)
            * [Plug](#plug)
            * [Displaying our routes](#displaying-our-routes)
         * [Creating the controller](#creating-the-controller)
         * [Create the view](#create-the-view)
            * [Our create operation](#our-create-operation)
            * [Our read operation](#our-read-operation)
            * [Our update operation](#our-update-operation)
            * [Our delete operation](#our-delete-operation)
         * [Testing your API with postman](#testing-your-api-with-postman)
         * [Extra](#extra)
   * [Labo 7 - Auth](#labo-7---auth)
      * [AuthN and AuthZ guide](#authn-and-authz-guide)
         * [Intro](#intro)
         * [Setup resources](#setup-resources)
            * [Schema](#schema)
            * [Acceptable roles](#acceptable-roles)
            * [Database integrity](#database-integrity)
            * [Seeding your database](#seeding-your-database)
      * [AuthN](#authn)
         * [Providing a way to authenticate](#providing-a-way-to-authenticate)
         * [Setup Guardian](#setup-guardian)
         * [Configuring our routes](#configuring-our-routes)
         * [Making our session controller](#making-our-session-controller)
         * [Making our template](#making-our-template)
      * [AuthZ](#authz)
         * [Adjusting our router](#adjusting-our-router)
         * [Creating our plug](#creating-our-plug)
         * [Role specific resources](#role-specific-resources)
   * [Labo 8 - i18n](#labo-8---i18n)
      * [Overview](#overview)
      * [Internationalization](#internationalization)
         * [Gettext](#gettext)
         * [Configuring gettext](#configuring-gettext)
         * [Let our webpage to use translations](#let-our-webpage-to-use-translations)
            * [POT files](#pot-files)
            * [PO files](#po-files)
            * [Adding a new language](#adding-a-new-language)
         * [Remaining files](#remaining-files)
      * [Language switching](#language-switching)
         * [Generating a URL with the language specified](#generating-a-url-with-the-language-specified)
         * [Reading the language from the URL](#reading-the-language-from-the-url)
         * [Closing notes](#closing-notes)
   * [Labo 9 - Webpack](#labo-9---webpack)
      * [Hello webpack](#hello-webpack)
      * [Loader](#loader)
      * [Secret](#secret)
      * [Phoenix](#phoenix)

Created by [gh-md-toc](https://github.com/ekalinin/github-markdown-toc)



# Labo 5 - CRUD



## Create operation

You've already seen how to create the schema and migration. You should know what this is used for. Here we'll focus on the create operation from CRUD. Create an umbrella application where the web project is apart from the actual logic / model project.

```bash
mix phx.new user_demo --umbrella --database mysql
```

### Migration and schema

First we'll make the schema and the migration. Let's make an example of a stereotypical user table.

Execute the following command

```bash
mix phx.gen.schema User users first_name:string last_name:string date_of_birth:date
```

Our users needs to be unique, so let us also make an unique index on the date of birth, first and last name. We don't need timestamps. So delete those as well. Change your migration file like so:

```elixir
defmodule UserDemo.Repo.Migrations.CreateUsers do
  use Ecto.Migration

  def change do
    create table(:users) do
      add :first_name, :string, null: false
      add :last_name, :string, null: false
      add :date_of_birth, :date, null: false
    end

    create unique_index(:users, [:first_name, :last_name, :date_of_birth],
             name: :unique_users_index
           )
  end
end
```

So data integrity is enforced. Though when this would raise an error, our system doesn't know about this. That's why we have to specify this in the schema as well:

```elixir
defmodule UserDemo.User do
  use Ecto.Schema
  import Ecto.Changeset

  schema "users" do
    field :date_of_birth, :date
    field :first_name, :string
    field :last_name, :string
  end

  @doc false
  def changeset(user, attrs) do
    user
    |> cast(attrs, [:first_name, :last_name, :date_of_birth])
    |> validate_required([:first_name, :last_name, :date_of_birth])
    |> unique_constraint(:date_of_birth,
      name: :unique_users_index,
      message:
        "Wow that's coincidence! " <>
          "Another person with the same first name and last name was born at this day. " <>
          "Oh gosh, our system can't deal with this. " <>
          "Contact our administrators or change your name. "
    )
  end
end
```

Wonderful. The schema is a representation of a data structure and what the associated fields are. The changeset is a function used to track changes on a user struct. An example could be the following:

```bash
# in apps/user_demo/
mix ecto.reset
# This is an alias for mix ecto.drop && mix ecto.create && mix ecto.migrate && mix run priv/repo/seeds.exs
# in / , your project root folder:
iex -S mix phx.server
Erlang/OTP 22 [erts-10.6.3] [source] [64-bit] [smp:8:8] [ds:8:8:10] [async-threads:1] [hipe]

[info] Running UserDemoWeb.Endpoint with cowboy 2.7.0 at 0.0.0.0:4000 (http)
[info] Access UserDemoWeb.Endpoint at http://localhost:4000
Interactive Elixir (1.10.0) - press Ctrl+C to exit (type h() ENTER for help)
iex(1)> initial_user = %UserDemo.User{}
%UserDemo.User{
  __meta__: #Ecto.Schema.Metadata<:built, "users">,
  date_of_birth: nil,
  first_name: nil,
  id: nil,
  last_name: nil
}
iex(2)>
nil
iex(3)> parameters_provided_by_external_sources = %{"date_of_birth" => Date.utc_today, "first_name" => "John", "last_name" => "Doe"}
%{
  "date_of_birth" => ~D[2020-02-06],
  "first_name" => "John",
  "last_name" => "Doe"
}
iex(4)>
nil
iex(5)> UserDemo.User.changeset initial_user, parameters_provided_by_external_sources
#Ecto.Changeset<
  action: nil,
  changes: %{
    date_of_birth: ~D[2020-02-06],
    first_name: "John",
    last_name: "Doe"
  },
  errors: [],
  data: #UserDemo.User<>,
  valid?: true
>
iex(6)>
```

_Feel free to copy paste the above commands:_

```elixir
initial_user = %UserDemo.User{}

parameters_provided_by_external_sources = %{"date_of_birth" => Date.utc_today, "first_name" => "John", "last_name" => "Doe"}

UserDemo.User.changeset initial_user, parameters_provided_by_external_sources
```

### Making a context

Because we'll have to do a lot of user-related operations, we'll maker a context for this. Make a new file (and folder) `user_demo/lib/user_demo/user_context/user_context.ex` and add the following code:

```elixir
defmodule UserDemo.UserContext do
  alias __MODULE__.User
  alias UserDemo.Repo

  @doc "Returns a user changeset"
  def change_user(%User{} = user) do
    user |> User.changeset(%{})
  end

  @doc "Creates a user based on some external attributes"
  def create_user(attributes) do
    %User{}
    |> User.changeset(attributes)
    |> Repo.insert()
  end
end
```

_Also rename your `User` module to `UserDemo.UserContext.User`. This way we can group related schemas and contexts together._

### Configuring our controller

We've already seen how we can configure our router. We'll need to add 2 routes in order to allow our users to create a user account:

```elixir
    get "/users/new", UserController, :new
    post "/users", UserController, :create
```

Our controller doesn't exist yet, let us make one with the necessary actions. _Reminder: An action is a regular function that receives the connection and the request parameters as arguments._

```elixir
defmodule UserDemoWeb.UserController do
  use UserDemoWeb, :controller

  alias UserDemo.UserContext
  alias UserDemo.UserContext.User

  def new(conn, _parameters) do
    changeset = UserContext.change_user(%User{})
    render(conn, "new.html", changeset: changeset)
  end

  def create(conn, %{"user" => user_params}) do
    case UserContext.create_user(user_params) do
      {:ok, user} ->
        conn
        |> put_flash(:info, "User #{user.first_name} #{user.last_name} created successfully.")
        |> redirect(to: Routes.user_path(conn, :new))

      {:error, %Ecto.Changeset{} = changeset} ->
        render(conn, "new.html", changeset: changeset)
    end
  end
end
```

For now let us forget that we're still missing our view and templates. We can see the `new/2` and `create/2` actions. For the `new/2` action, we create a changeset as forms need these to render themselves. Because it is new, we'll create a new struct and pass it as a parameter. Then when we render the template, we pass the changeset so that we can use it later on.

The `create/2` action on the other hand, will receive some parameters from the post requests. These are already parsed thanks to the plugs in the `:browser` pipeline. We use these attributes to create a new user, and if no errors are present we'll execute the pattern matched statement and redirect to a new form (for now). Otherwise you'll render that same form again with the necessary errors.

### The view

Creating the view is rather simple, we'll just need the following code:

```elixir
defmodule UserDemoWeb.UserView do
  use UserDemoWeb, :view
end
```

### Making a template

Then we'll create the templates. First we'll create the folder `templates/user/` as phoenix will automatically navigate to this folder. After which we'll need a `new.html.eex` template. Let us create a simple form:

```html
<h1>New User</h1>

<%= form_for @changeset, Routes.user_path(@conn, :create), fn f -> %>
<%= if @changeset.action do %>
<div class="alert alert-danger">
  <p>Oops, something went wrong! Please check the errors below.</p>
</div>
<% end %>

<%= label f, :first_name %>
<%= text_input f, :first_name %>
<%= error_tag f, :first_name %>

<%= label f, :last_name %>
<%= text_input f, :last_name %>
<%= error_tag f, :last_name %>

<%= label f, :date_of_birth %>
<%= date_select f, :date_of_birth, year: [options: 1910..2020] %>
<%= error_tag f, :date_of_birth %>

<div>
  <%= submit "Save" %>
</div>
<% end %>
```

So what exactly is happening here? First we create a form with the `form_for` macro. We pass the changeset (formdata) to it and it'll automatically match the values to the fields. After that we give a path to where the post request needs to be sent. Finally we use the anonymous function f to build our form.

When you try it out, you can make a new user and it'll show nice flash messages. These messages are also parsed thanks to plugs in the browser pipeline (check your `router.ex` file).



## Read operation

These are rather simple operations. First allow our `UserContext` to fetch all our users and get a specific user.

```elixir
  @doc "Returns a specific user or raises an error"
  def get_user!(id), do: Repo.get!(User, id)

  @doc "Returns all users in the system"
  def list_users, do: Repo.all(User)
```

Then we add the according routes in our `router.ex`.

```elixir
    get "/users", UserController, :index
    get "/users/:user_id", UserController, :show
```

After which we create the actions in our controller:

```elixir
  def index(conn, _params) do
    users = UserContext.list_users()
    render(conn, "index.html", users: users)
  end

  def show(conn, %{"user_id" => id}) do
    user = UserContext.get_user!(id)
    render(conn, "show.html", user: user)
  end
```

Above actions should be self-explanatory. Next up are the `index.html.eex` and `show.html.eex` pages.

```html
<h1>Listing Users</h1>

<table>
    <thead>
        <tr>
            <th>first name</th>
            <th>last name</th>
            <th>date of birth</th>

            <th></th>
        </tr>
    </thead>
    <tbody>
        <%= for user <- @users do %>
        <tr>
            <td><%= user.first_name %></td>
            <td><%= user.last_name %></td>
            <td><%= user.date_of_birth %></td>

            <td>
                <span><%= link "Show", to: Routes.user_path(@conn, :show, user) %></span>
            </td>
        </tr>
        <% end %>
    </tbody>
</table>

<%= link "New user", 
to: Routes.user_path(@conn, :new) %>
```

```html
<h1>Show User details</h1>

<ul>
    <li>
        <strong>First name:</strong>
        <%= @user.first_name %>
    </li>

    <li>
        <strong>Last name:</strong>
        <%= @user.last_name %>
    </li>

    <li>
        <strong>date of birth:</strong>
        <%= @user.date_of_birth %>
    </li>
</ul>

<%= link "Back", to: Routes.user_path(@conn, :index) %>
```

That's all there is to it. On to updating user details.



## Update operation

Similar to our previous operations, let us first adjust our context.

```elixir
  @doc "Update an existing user with external attributes"
  def update_user(%User{} = user, attrs) do
    user
    |> User.changeset(attrs)
    |> Repo.update()
  end
```

After which we'll have to provide 2 (or 3) extra routes:

```elixir
    get "/users/:user_id/edit", UserController, :edit
    put "/users/:user_id", UserController, :update
    patch "/users/:user_id", UserController, :update
```

Then we'll create the actions in our controller:

```elixir
  def edit(conn, %{"user_id" => id}) do
    user = UserContext.get_user!(id)
    changeset = UserContext.change_user(user)
    render(conn, "edit.html", user: user, changeset: changeset)
  end

  def update(conn, %{"user_id" => id, "user" => user_params}) do
    user = UserContext.get_user!(id)

    case UserContext.update_user(user, user_params) do
      {:ok, user} ->
        conn
        |> put_flash(:info, "User updated successfully.")
        |> redirect(to: Routes.user_path(conn, :show, user))

      {:error, %Ecto.Changeset{} = changeset} ->
        render(conn, "edit.html", user: user, changeset: changeset)
    end
  end
```

If you understand the code to create a user completely, above code should be self-explanatory as well. As for the update form, we'll re-use the form that we wrote to create a user.

First of all let us edit the `index.html.eex` file.

```html
                <span><%= link "Edit", to: Routes.user_path(@conn, :edit, user) %></span>
```

Add this to every row, the show page as well if you want to, and then let us create the `form.html.eex` page:

```html
<%= form_for @changeset, @action, fn f -> %>
<%= if @changeset.action do %>
<div class="alert alert-danger">
    <p>Oops, something went wrong! Please check the errors below.</p>
</div>
<% end %>

<%= label f, :first_name %>
<%= text_input f, :first_name %>
<%= error_tag f, :first_name %>

<%= label f, :last_name %>
<%= text_input f, :last_name %>
<%= error_tag f, :last_name %>

<%= label f, :date_of_birth %>
<%= date_select f, :date_of_birth, year: [options: 1910..2020] %>
<%= error_tag f, :date_of_birth %>

<div>
    <%= submit "Save" %>
</div>
<% end %>
```

The only change is that this "sub" html file contains the @action variable now. When rendering our form from `new.html.eex` or `edit.html.eex` we'll pass different actions like so:

```html
<h1>New User</h1>


<%= render "form.html", Map.put(assigns, :action, Routes.user_path(@conn, :create)) %>

<span><%= link "Back", to: Routes.user_path(@conn, :index) %></span>
```


```html
<h1>Edit user</h1>

<%= render "form.html", Map.put(assigns, :action, Routes.user_path(@conn, :update, @user)) %>

<span><%= link "Back", to: Routes.user_path(@conn, :index) %></span>
```

The `assigns` variable is actually something in our `conn` variable. We get this as a parameter in our controller action. We're storing all kinds of things there!

There we go. Now we can edit our users as well. We're almost there...



## Delete operation

Same thing all over again. You get it now don't you?

In your context:

```elixir
  @doc "Delete a user"
  def delete_user(%User{} = user), do: Repo.delete(user)
```

In your `router.ex`:

```elixir
    delete "/users/:user_id", UserController, :delete
```

Now that we have all crud routes, we can just replace it with the `resources` macro. We did this in the previous lesson, now you know what it does. In your `apps/user_demo_web` app you can run the `mix phx.server` command and see all supported routes.

Add this to your controller:

```elixir
  def delete(conn, %{"user_id" => id}) do
    user = UserContext.get_user!(id)
    {:ok, _user} = UserContext.delete_user(user)

    conn
    |> put_flash(:info, "User deleted successfully.")
    |> redirect(to: Routes.user_path(conn, :index))
  end
```

And add this to e.g. your `index.html.eex`:

```html
    <span><%= link "Delete", to: Routes.user_path(@conn, :delete, user),
        method: :delete, data: [confirm: "Are you sure?"] %></span>
```

And you're all set!

Know that you can autogenerate all these files with the `mix phx.gen.html` command.



## Associations

While I'd love to create a whole guide for this, it's already done quite nicely on [Elixir School](https://elixirschool.com/en/lessons/ecto/associations/). Personally I found [this link](https://ezcook.de/2018/05/15/cast-assoc/) clarifying as well.

To test your skills, you can try to add a second entity, called Jobs. Make up some fields and configure that many to many association. Try to use [nested resources](https://hexdocs.pm/phoenix/routing.html#nested-resources) in your router.



# Labo 6 - Users & Cats (crud & api)

## Setup demo - the user has cats project

We're not going to waste time here, instead of creating all our previous resources manually we'll generate them. Execute the following commands:

```bash
 $> mix phx.new user_cats_ref --umbrella --database mysql --no-webpack
 $> mix phx.gen.html UserContext User users first_name:string last_name:string date_of_birth:date
 $> # Adjust your dev.exs config file for db access.
```

Add the following to your router:

```elixir
resources "/users", UserController
```

Fire up your dev server with `mix phx.server` and go manually to the url `localhost:4000/users`. You should be able to do the CRUD operations on your `User` entity.

Next we'll go and configure our REST endpoint for editing our cats.



## Configuring our cat context

We could create the complete schema and migration again, but as we've seen we can tremendously reduce this repetitive task with generators. Let us go and create our context and after that make the association links. Execute the following command:

```bash
$> mix phx.gen.context CatContext Cat cats name:string user_id:references:users
```

### Adjust the migration

As you can see we've got our migration, schema and context generated for us. Adjust your migration to not allow stray / nameless cats:

```elixir
defmodule UserCats.Repo.Migrations.CreateCats do
  use Ecto.Migration

  def change do
    create table(:cats) do
      add :name, :string, null: false
      add :user_id, references(:users, on_delete: :delete_all), null: false
    end

    create index(:cats, [:user_id])
  end
end
```

_If you want to go really fancy here, feel free to make your own version of this user-cat service. You can add images, age, etc..._

_From the docs: `:on_delete` - What to do if the referenced entry is deleted. May be `:nothing` (default), `:delete_all`, `:nilify_all`, or `:restrict`._

### Adjust the schema

We also need to adjust our cat and user schema:

```elixir
defmodule UserCats.CatContext.Cat do
  use Ecto.Schema
  import Ecto.Changeset

  alias UserCats.UserContext.User

  schema "cats" do
    field :name, :string
    belongs_to :user, User
  end

  @doc false
  def changeset(cat, attrs) do
    cat
    |> cast(attrs, [:name])
    |> validate_required([:name])
  end
end
```

_Note: our changeset is not yet properly configured for the association. We'll do this later on._

Also adjust our user schema:

```elixir
defmodule UserCats.UserContext.User do
  # ...

  alias UserCats.CatContext.Cat

  schema "users" do
    field :date_of_birth, :date
    field :first_name, :string
    field :last_name, :string
    has_many :cats, Cat
  end

  # ...
end
```

Double check that your user CRUD operations are still working as expected. After that, let us go to the next section.



## Controller & Routes

### Routes - nested resources

Now that we have our (unfinished) context, schema and migration, we can go ahead and configure our routes. Because the user will want to configure his/her own cats, we'll need to generate some url that communicates this clearly in code and to the user. An example would be `/users/:user_id/cats` or `/users/:user_id/cats/:id/edit`. We can achieve this easily with [nested resources](https://hexdocs.pm/phoenix/routing.html) in our `router.ex`.

Though we could easily generate a html version for the cat CRUD operations, we want these to only be editable through a REST endpoint. 

### Router scopes

To put it shortly, we can use [scoped routes](https://hexdocs.pm/phoenix/routing.html#scoped-routes) to group routes under a common path prefix with certain plugs. Several examples would be:

* `/admin` scope that requires extra permissions
* `/user` scope that needs authentication
* `/api` scope to configure our requests not for html (`:browser` pipeline), but for JSON requests

We've already got a great example for the root path, let's create a new scope for `/api` and pipe it through our `:api` pipeline.

```elixir
  scope "/", UserCatsWeb do
    pipe_through :browser

    get "/", PageController, :index
    resources "/users", UserController
  end

  scope "/api", UserCatsWeb do
    pipe_through :api

    resources "/users", UserController, only: [] do
      resources "/cats", CatController
    end
  end
```

You can see that we created nested resources in the above code snippet. Though it seems that there's a lot of magic happening here, let us quickly go over this:

* scope "/" -> resources "/users" => is for the html interface to edit our users.
* scope "/api" -> resources "/users", only: [] => means that we're generating routes for our user as well. Thanks to the [resources macro](https://hexdocs.pm/phoenix/Phoenix.Router.html#resources/4), we can configure this and say that we don't want REST routes for the users resource.
* resources "/cats", CatController => means that we're going to allow (nested if it is inside another resources block) cat routes for our REST API.

### Pipelines

We've seen these [pipelines](https://hexdocs.pm/phoenix/routing.html#pipelines) several times now already, but what are these exactly?

Our request arrives and the endpoint and needs to go through a lot of tranformations so that we can start using it. These transformations are done with plugs.

#### Plug

A plug is a module that enforces certain rules or operations and can transform the request based on them.

We can naively represent a request flow like this:

```elixir
connection
|> endpoint()
|> router()
|> pipelines()
|> controller()
```

Where Endpoint already defines some plugs by default:

```elixir
defmodule MyApp.Endpoint do
  use Phoenix.Endpoint, otp_app: :my_app
  plug Plug.Static, ...
  plug Plug.RequestId
  plug Plug.Telemetry, ...
  plug Plug.Parsers, ...
  plug Plug.MethodOverride
  plug Plug.Head
  plug Plug.Session, ...
  plug MyApp.Router
end
```

As we can see, there are already a lot of plugs being used on the background. As soon as you want to custom configure plugs groups, you can configure it in your router pipelines, such as the preconfigured `:api` and `:browser`.

Later on we'll make our own plugs. For now just know that they exist and that you use them indirectly.

#### Displaying our routes

Feel free display your routes with:

```bash
mix phx.routes
# ONLY OUTPUTTING API ROUTES HERE
 GET     /api/users/:user_id/cats           CatController :index
 GET     /api/users/:user_id/cats/:id/edit  CatController :edit
 GET     /api/users/:user_id/cats/new       CatController :new
 GET     /api/users/:user_id/cats/:id       CatController :show
 POST    /api/users/:user_id/cats           CatController :create
 PATCH   /api/users/:user_id/cats/:id       CatController :update
 PUT     /api/users/:user_id/cats/:id       CatController :update
 DELETE  /api/users/:user_id/cats/:id       CatController :delete
```

We can see that we've got nested routes, and no user REST CRUD routes, which is exactly what we want.

### Creating the controller

Considering it is very similar to our other controller, let's copy the template.

```elixir
defmodule UserCatsWeb.CatController do
  use UserCatsWeb, :controller

  def index(conn, _params), do: # ...
  def create(conn,_params), do: # ...
  def show(conn, _params), do: # ...
  def update(conn, _params), do: # ...
  def delete(conn, _params), do: # ...
end
```

### Create the view

While we could just dump a JSON response back from our controller action, let's do this properly with view. Create a view like so:

```elixir
defmodule UserCatsWeb.CatView do
  use UserCatsWeb, :view
end
```

Later on we'll configure this a bit more, we'll come back to that.

#### Our create operation

##### `C`RUD: Adjusting our context and schema

First we adjust our schema. We create a specific changeset for the create operation. Know that there are many ways to do this, but personally I like this approach.

```elixir
defmodule UserCats.CatContext.Cat do
  # ...

  def create_changeset(cat, attrs, user) do
    cat
    |> cast(attrs, [:name])
    |> validate_required([:name])
    |> put_assoc(:user, user)
  end
end
```

As you can see we've putted a `put_assoc/3` function. You can find an overview when you want to use `cast_assoc/3` or other options at [this link](https://ezcook.de/2018/05/15/cast-assoc/).

Now we'll adjust our context to use this as well. If we know that we'll need a user to create the cat, we just add this as a parameter in our context like so:

```elixir
  def create_cat(attrs, %User{} = user) do
    %Cat{}
    |> Cat.create_changeset(attrs, user)
    |> Repo.insert()
  end
```

That should be quite obvious, next is the controller.

##### `C`RUD: Adjusting our controller

We'll once again do some straightforward stuff. First we get the user, after which we try to create the cat based on the given parameters. Your code should look like:

```elixir
  def create(conn, %{"user_id" => user_id, "cat" => cat_params}) do
    user = UserContext.get_user!(user_id)

    case CatContext.create_cat(cat_params, user) do
      {:ok, %Cat{} = cat} ->
        conn
        |> put_status(:created)
        |> put_resp_header("location", Routes.user_cat_path(conn, :show, user_id, cat))
        |> render("show.json", cat: cat)

      {:error, _cs} ->
        conn
        |> send_resp(400, "Something went wrong, sorry. Adjust your parameters or give up.")
    end
  end
```

#### Our read operation

##### C`R`UD: Adjusting our context

When we go to the path `/users/:user_id/cats`, we don't want to see all the cats but only the cats for that specific user. Let us first of all adjust our context to do this:

```elixir
  alias UserCats.UserContext.User
  def load_cats(%User{} = u), do: u |> Repo.preload([:cats])
```

This way we make sure that we load the cats of a user. Know that when you get an entity from the database, default its associations are not loaded, which you'll have to do with `Repo.preload`.

##### C`R`UD: Adjusting our controller

When we know that this is possible, let us adjust our index and show method like so:

```elixir
  def index(conn, %{"user_id" => user_id}) do
    user = UserContext.get_user!(user_id)
    user_with_loaded_cats = CatContext.load_cats(user)
    render(conn, "index.json", cats: user_with_loaded_cats.cats)
  end

  def show(conn, %{"id" => id}) do
    cat = CatContext.get_cat!(id)
    render(conn, "show.json", cat: cat)
  end
```

As you can see, we first retrieve our user, then preload our cats, after which we want to format this in the view. The only problem is that our view doesn't support this yet. Let us do that now.

##### C`R`UD: Adjusting our view

We'll often want to filter our data that we display to our users. This can of course be done in the controller, but the view is the place to do this. In the view we configure how we, yes you guessed it, view the data.

```elixir
  def render("index.json", %{cats: cats}) do
    %{data: render_many(cats, CatView, "cat.json")}
  end

  def render("show.json", %{cat: cat}) do
    %{data: render_one(cat, CatView, "cat.json")}
  end

  def render("cat.json", %{cat: cat}) do
    %{id: cat.id, name: cat.name}
  end
```

#### Our update operation

Most of the context operations are already generated, hence we can just focus on our controller.

##### CR`U`D: Adjusting our controller

Similar to our create method, we'll receive some params and a cat id to adjust. First we'll retrieve the cat, and then update it. Because we're not changing associations, we can use the default changeset from the schema in the context.

Your controller should look like:

```elixir
  def update(conn, %{"id" => id, "cat" => cat_params}) do
    cat = CatContext.get_cat!(id)

    case CatContext.update_cat(cat, cat_params) do
      {:ok, %Cat{} = cat} ->
        render(conn, "show.json", cat: cat)

      {:error, _cs} ->
        conn
        |> send_resp(400, "Something went wrong, sorry. Adjust your parameters or give up.")
    end
  end
```

#### Our delete operation

Same story as our update operation, most of it is already there. We just need to adjust our controller.

##### CRU`D`: Adjusting our controller

Principles are the same, first fetch the cat and then delete it based on the already existing method in the context.

Your controller should look like:

```elixir
  def delete(conn, %{"id" => id}) do
    cat = CatContext.get_cat!(id)

    with {:ok, %Cat{}} <- CatContext.delete_cat(cat) do
      send_resp(conn, :no_content, "")
    end
  end
```

### Testing your API with postman

In the git repo should be a folder `demo/postman_api_calls_export`. You need to be able to use this software on the exam as well.

### Extra

All of this could've mostly be done with `mix phx.gen.json` command. Though you still need to manually make the associations.



# Labo 7 - Auth

## AuthN and AuthZ guide

### Intro

This guide is to demonstrate how we can rather quickly achieve a simple project with AuthN and AuthZ. This guide will cover 3 parts.

* Setting up our resources
* Configuring our AuthN
* Protecting routes with AuthZ

### Setup resources

First we'll create a user resource as we've done before. The User resource will store a role attribute which can be `User`, `Manager` or `Admin`. The CRUD operations to create/delete/delete users should of course be limited to the `Admin`role. First we'll create the resource:

```bash
 mix phx.gen.html UserContext User users username:string hashed_password:string role:string
```

After which we add the resources routes as well. Next we'll configure that our password should be hashed. Do that with one of the `comeonin` packages. For Argon this would be the following dependency:

```elixir
{:argon2_elixir, "~> 2.2"}
```

add this to your mix.exs of your model project in e.g. `apps/auth`.

_Note that windows can have some issues with compiling this module. Feel free to use pbkdf2._

#### Schema

Next we'll adjust our schema like so:

```elixir
defmodule Auth.UserContext.User do
  use Ecto.Schema
  import Ecto.Changeset

  @acceptable_roles ["Admin", "Manager", "User"]

  schema "users" do
    field :username, :string
    field :password, :string, virtual: true
    field :hashed_password, :string
    field :role, :string, default: "User"
  end

  def get_acceptable_roles, do: @acceptable_roles

  @doc false
  def changeset(user, attrs) do
    user
    |> cast(attrs, [:username, :password, :role])
    |> validate_required([:username, :password, :role])
    |> validate_inclusion(:role, @acceptable_roles)
    |> put_password_hash()
  end

  defp put_password_hash(
         %Ecto.Changeset{valid?: true, changes: %{password: password}} = changeset
       ) do
    change(changeset, hashed_password: Argon2.hash_pwd_salt(password))
  end

  defp put_password_hash(changeset), do: changeset
end
```

_Note that we've adjusted `:hashed_password` to `:password` in our `cast` and `validate_required` parameters._

There are several new things here. First of all the `virtual field`, this is to illustrate that we have a virtual field, a field which is not mapped by a column in our database. This could be used for extra input, custom computation / verification implementations. There are also options without this virtual field, but personally I like the explicicity of this field to illustrate its purposes.

After which we validate whether our provided role is "acceptable" with `validate_inclusion(changeset, field, has_to_be_in_this_enumerable)`. We also have a multi-clause function that pattern matches whether the provided data is valid or not. We do the hashing at the last step so that we don't waste CPU resources when the data is invalid. Likewise, if you'd add password complexity constraints, you'd put these before the last hashing step.

Know that normally you could provide better database integrity constraints if you'd make a roles table. Though for educational purposes we won't do this and write this in our User module as well.

#### Acceptable roles

Though this is a small extra, our current form asks our role as a text field. Because we have a list of acceptable roles, lets adjust this quickly in our related files.

```elixir
# user_context.ex
defmodule Auth.UserContext do
  # ...

  defdelegate get_acceptable_roles(), to: User

  # ...
end
```

```elixir
# user_controller.ex
defmodule AuthWeb.UserController do
  # ...

  def new(conn, _params) do
    changeset = UserContext.change_user(%User{})
    roles = UserContext.get_acceptable_roles()
    render(conn, "new.html", changeset: changeset, acceptable_roles: roles)
  end

  def edit(conn, %{"id" => id}) do
    user = UserContext.get_user!(id)
    changeset = UserContext.change_user(user)
    roles = UserContext.get_acceptable_roles()
    render(conn, "edit.html", user: user, changeset: changeset, acceptable_roles: roles)
  end

  # ...
end
```

```html
<!-- templates/user/form.html.eex -->
<%= form_for @changeset, @action, fn f -> %>
<%= if @changeset.action do %>
<div class="alert alert-danger">
  <p>Oops, something went wrong! Please check the errors below.</p>
</div>
<% end %>

<%= label f, :username %>
<%= text_input f, :username %>
<%= error_tag f, :username %>

<%= label f, :password %>
<%= text_input f, :password %>
<%= error_tag f, :password %>

<%= label f, :role %>
<%= select f, :role, @acceptable_roles %>
<%= error_tag f, :role %>

<div>
  <%= submit "Save" %>
</div>
<% end %>
```

We've also adjusted our auto-generated template to ask for the virtual password (and not the hashed password) in our form.

#### Database integrity

In order to force our users to provide all the information at the database level, adjust your migration file.

```elixir
defmodule Auth.Repo.Migrations.CreateUsers do
  use Ecto.Migration

  def change do
    create table(:users) do
      add :username, :string, null: false
      add :hashed_password, :string, null: false
      add :role, :string, null: false
    end
  end
end
```

#### Seeding your database

This should normally enough to set up your resource. While this is great, after we've added authentication we'll want some kind of default user accounts. Let us adjust the file in `apps/auth/priv/repo/seeds.exs`:

```elixir
{:ok, _cs} =
  Auth.UserContext.create_user(%{"password" => "t", "role" => "User", "username" => "user"})

{:ok, _cs} =
  Auth.UserContext.create_user(%{
    "password" => "t",
    "role" => "Manager",
    "username" => "manager"
  })

{:ok, _cs} =
  Auth.UserContext.create_user(%{"password" => "t", "role" => "Admin", "username" => "admin"})
```

Run `mix ecto.reset` and you should see some green debug output. Verify manually that the passwords are stored safely in your database as a hash.



## AuthN

As covered in the theory classes, we'll use JWT over Sessions for now. Following libraries are quite popular at the time of writing:

* Guardian: Token based AuthN (default JWT)
* Pow: Traditional session based authentication

### Providing a way to authenticate

Before we start implementing our Guardian modules, let us first implement a way so that we can verify when logging in whether a provided username and password is correct or not. We'll provide this method in our `UserContext`.

```elixir
  def authenticate_user(username, plain_text_password) do
    case Repo.get_by(User, username: username) do
      nil ->
        Argon2.no_user_verify()
        {:error, :invalid_credentials}

      user ->
        if Argon2.verify_pass(plain_text_password, user.hashed_password) do
          {:ok, user}
        else
          {:error, :invalid_credentials}
        end
    end
  end
```

You might wonder why we call the `Argon2.no_user_verify/0` function when we can't find a user. This is to make it more difficult for attackers to retrieve usernames based on timing attacks. When a user is found it'll verify the password.

### Setup Guardian

#### Adding the depencency

In our `apps/auth_web` project its `mix.exs` file, add the following dependency:

```elixir
{:guardian, "~> 2.0"}
```

Remember to run `mix deps.get` after adjusting this file.

#### Implementation module

Because we want to pattern match on our `get_user/1` function, we don't want to use the bang version that's generated in our `UserContext`. Let us implement another one:

```elixir
  # UserContext
  def get_user(id), do: Repo.get(User, id)
```

We'll also need to have some kind of implementation module in order to tell Guardian how we identify our token and how it should retrieve this resource. We do that with an implementation module like so:

```elixir
defmodule AuthWeb.Guardian do
  use Guardian, otp_app: :auth_web

  alias Auth.UserContext
  alias Auth.UserContext.User

  def subject_for_token(user, _claims) do
    {:ok, to_string(user.id)}
  end

  def resource_from_claims(%{"sub" => id}) do
    case UserContext.get_user(id) do
      %User{} = u -> {:ok, u}
      nil -> {:error, :resource_not_found}
    end
  end
end
```

The `resource_from_claims/1` function allows us to retrieve our resource from a specific "claim" in our JWT. First let us take a look as to what we exectly get from arguments: (you'll be able to do this as well when everything works.)

```elixir
%{
  "aud" => "auth_web",
  "exp" => 1584137319,
  "iat" => 1581718119,
  "iss" => "auth_web",
  "jti" => "0425b8dd-d40c-42a5-943b-dbf2e87f9943",
  "nbf" => 1581718118,
  "sub" => "3",
  "typ" => "access"
}
```

A lot of these claims are documented by the IETF (open standards organization), you can read all about them in [this link](https://tools.ietf.org/html/rfc7519#section-4.1). What we are interested in, is the `sub` field which contains our user ID. It got there because of the `subject_for_token/1` function, where we put the user ID as the subject.

#### Setting up our config

In order to sign our JWT tokens, we'll need a secret. You can generate this with `mix guardian.gen.secret`. Add this to your config like so:

```elixir
config :auth_web, AuthWeb.Guardian,
  issuer: "auth_web",
  secret_key: "" # paste input here
```

_Note that `auth_web` is our project name!_

#### Setting up an error handler

We're also going to define a errorhandler in case there's an authentication failure. One of the most basic ones is this:

```elixir
defmodule AuthWeb.ErrorHandler do
  import Plug.Conn

  @behaviour Guardian.Plug.ErrorHandler

  @impl Guardian.Plug.ErrorHandler
  def auth_error(conn, {type, _reason}, _opts) do
    body = Jason.encode!(%{message: to_string(type)})
    send_resp(conn, 401, body)
  end
end

```

This just dumps a message to our screen. Feel free to personalize this with error messages, redirections, etc... .

#### Setting up our (module) pipeline

We can already see a default-generated pipeline in our `router.ex`. This is a pipeline constructed in our routes based on a collection of plugs. It is also possible to make a module into a plug and use that as a pipeline like so:

```elixir
defmodule AuthWeb.Pipeline do
  use Guardian.Plug.Pipeline,
    otp_app: :auth_web,
    error_handler: AuthWeb.ErrorHandler,
    module: AuthWeb.Guardian

  # If there is a session token, restrict it to an access token and validate it
  plug Guardian.Plug.VerifySession, claims: %{"typ" => "access"}
  # If there is an authorization header, restrict it to an access token and validate it
  plug Guardian.Plug.VerifyHeader, claims: %{"typ" => "access"}
  # Load the user if either of the verifications worked
  plug Guardian.Plug.LoadResource, allow_blank: true
end
```

We see that loading the resource is optional, as we'll have an index page on which it doesn't matter whether the user is logged in or not. (Though you may want to hide/show login/logout buttons depending on this.) Later on we'll restrict this further.

After defining our pipeline, we add this to our `router.ex` with one extra pipeline:

```elixir
  pipeline :auth do
    plug AuthWeb.Pipeline
  end

  pipeline :ensure_auth do
    plug Guardian.Plug.EnsureAuthenticated
  end
```

The second one is quite self-explanatory, but it just verifies whether you are authenticated or not.

### Configuring our routes

With two useful pipelines, let us configure our routes so that we have our user resources protected:

```elixir
  scope "/", AuthWeb do
    pipe_through [:browser, :auth]

    get "/", PageController, :index
    get "/login", SessionController, :new
    post "/login", SessionController, :login
    get "/logout", SessionController, :logout
  end

  scope "/admin", AuthWeb do
    pipe_through [:browser, :auth, :ensure_auth]

    resources "/users", UserController
  end
```

### Making our session controller

While the naming may be treacherous, remind that we're using __JWT and not sessions__. Though as far as the user is concerned, he'll log in and after a time he'll have to reconfirm / log in again. This behavior, or maybe better worded as purpose, is a lot like a session.

We've seen the underlying mechanisms of controllers already. It'll look like the following:

```elixir
defmodule AuthWeb.SessionController do
  use AuthWeb, :controller

  alias AuthWeb.Guardian
  alias Auth.UserContext
  alias Auth.UserContext.User

  def new(conn, _) do
    changeset = UserContext.change_user(%User{})
    maybe_user = Guardian.Plug.current_resource(conn)

    if maybe_user do
      redirect(conn, to: "/user_scope")
    else
      render(conn, "new.html", changeset: changeset, action: Routes.session_path(conn, :login))
    end
  end

  def login(conn, %{"user" => %{"username" => username, "password" => password}}) do
    UserContext.authenticate_user(username, password)
    |> login_reply(conn)
  end

  def logout(conn, _) do
    conn
    |> Guardian.Plug.sign_out()
    |> redirect(to: "/login")
  end

  defp login_reply({:ok, user}, conn) do
    conn
    |> put_flash(:info, "Welcome back!")
    |> Guardian.Plug.sign_in(user)
    |> redirect(to: "/user_scope")
  end

  defp login_reply({:error, reason}, conn) do
    conn
    |> put_flash(:error, to_string(reason))
    |> new(%{})
  end
end
```

### Making our template

#### First the view

We'll make a simple session view.

```elixir
defmodule AuthWeb.SessionView do
  use AuthWeb, :view
end
```

#### Login template

```html
<!-- templates/session/new.html.eex -->
<h2>Login Page</h2>

<%= form_for @changeset, @action, fn f -> %>

<div class="form-group">
    <%= label f, :username, class: "control-label" %>
    <%= text_input f, :username, class: "form-control" %>
    <%= error_tag f, :username %>
</div>

<div class="form-group">
    <%= label f, :password, class: "control-label" %>
    <%= password_input f, :password, class: "form-control" %>
    <%= error_tag f, :password %>
</div>

<div class="form-group">
    <%= submit "Submit", class: "btn btn-primary" %>
</div>
<% end %>
```

#### Properly configuring our routes

We'll do this in the next section. If you run your app now, you'll have to put in some URL's manually.



## AuthZ

### What we already have

Just to sum it up:

* User resource with a certain role
* Login mechanism
* Authentication pipeline
* Automatically loaded user resources thanks to the loadresource plug
* Protected routes

### Adjusting our router

In order to illustrate role-based authentication, we'll go further with our protected routes and define 3 scopes (based on the role).

* User scope
* Manager scope
* Admin scope (will be able to create/delete users)

We'll want to have a router file similar to:

```elixir
  pipeline :allowed_for_users do
    plug AuthWeb.Plugs.AuthorizationPlug, ["Admin", "Manager", "User"]
  end

  pipeline :allowed_for_managers do
    plug AuthWeb.Plugs.AuthorizationPlug, ["Admin", "Manager"]
  end

  pipeline :allowed_for_admins do
    plug AuthWeb.Plugs.AuthorizationPlug, ["Admin"]
  end

  scope "/", AuthWeb do
    pipe_through [:browser, :auth]

    get "/", PageController, :index
    get "/login", SessionController, :new
    post "/login", SessionController, :login
    get "/logout", SessionController, :logout
  end

  scope "/", AuthWeb do
    pipe_through [:browser, :auth, :ensure_auth, :allowed_for_users]

    get "/user_scope", PageController, :user_index
  end

  scope "/", AuthWeb do
    pipe_through [:browser, :auth, :ensure_auth, :allowed_for_managers]

    get "/manager_scope", PageController, :manager_index
  end

  scope "/admin", AuthWeb do
    pipe_through [:browser, :auth, :ensure_auth, :allowed_for_admins]

    resources "/users", UserController
    get "/", PageController, :admin_index
  end
```

As you can wee we have 3 scopes, each one is for a specific role. While one could achieve results in a single scope and certain "policies", we'll go for our custom solution. You can see that we have a custom plug, the `AuthWeb.Plugs.AuthorizationPlug`, which takes some options.

### Creating our plug

We've seen plugs in action several times already. As you can see it'll transform the request several times until it is returned back as a response. An illustration of this proces could be found [here](https://www.brianstorti.com/assets/images/plug.png).

We'll write our own plug which checks whether a user has enough roles. Of course you don't want to write a plug for each role (e.g. "IsAdminPlug"), hence the use of the options in our router. An example plug would be:

```elixir
defmodule AuthWeb.Plugs.AuthorizationPlug do
  import Plug.Conn
  alias Auth.UserContext.User
  alias Phoenix.Controller

  def init(options), do: options

  def call(%{private: %{guardian_default_resource: %User{} = u}} = conn, roles) do
    conn
    |> grant_access(u.role in roles)
  end

  def grant_access(conn, true), do: conn

  def grant_access(conn, false) do
    conn
    |> Controller.put_flash(:error, "Unauthorized access")
    |> Controller.redirect(to: "/")
    |> halt
  end
end
```

Here you can see 2 necessary callbacks and a custom multi-clause function. The `init/1` callback takes the options and does necessary transformations. This is often nothing, as you'll use the result of the `init/1` function and use it as the 2nd argument of the `call/2` function. **The init function is called during compile time**, while the `call/2` callback is the workhorse.

We can also [halt](https://hexdocs.pm/plug/Plug.Builder.html#module-halting-a-plug-pipeline) a pipeline when we see fit. In this case, we'll want to halt it when the user doesn't have access to those resources. This doesn't mean that we don't give a response, as we nicely redirect the user to the index page (or somewhere else). _If you don't do this, you'll get the common "response already sent" error._

### Role specific resources

In order to demonstrate specific roles, we'll use a page that'll print for who it should be visible. This'll be really basic, so we'll reuse the home page and just display our role.

#### Adjusting our templates

```html
<!-- templates/layout/app.html.eex -->
      ...
      <nav role="navigation">
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="<%= Routes.user_path(@conn, :index) %>">Users</a></li>
          <li><a href="<%= Routes.session_path(@conn, :new) %>">Login</a></li>
          <li><a href="<%= Routes.session_path(@conn, :logout) %>">Logout</a></li>
          <li><a href="/user_scope">User scope</a></li>
          <li><a href="/manager_scope">Manager scope</a></li>
          <li><a href="/admin">Admin scope</a></li>
        </ul>
      </nav>
      ...
```

```html
<!-- templates/page/index.html.eex -->
<section class="phx-hero">
  <h1><%= gettext "Welcome to %{name}!", name: "Phoenix" %></h1>
  <p>A productive web framework that<br />does not compromise speed or maintainability.</p>
</section>

<section class="row">
  this page is for: <%= @role %>
  <br>
  user accounts with password "t":
  <br>
  user - manager - admin
</section>
```

#### Adjusting our controller

As we've already seen what our router expects, let us quickly implement the necessary actions in our controller.

```elixir
defmodule AuthWeb.PageController do
  use AuthWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html", role: "everyone")
  end

  def user_index(conn, _params) do
    render(conn, "index.html", role: "users")
  end

  def manager_index(conn, _params) do
    render(conn, "index.html", role: "managers")
  end

  def admin_index(conn, _params) do
    render(conn, "index.html", role: "admins")
  end
end
```

This should be enough to do role-based authorization! You can get only so far with custom-making all of your plugs. As soon as you have more complex scenarios, you should consider using a library such as bodyguard.



# Labo 8 - i18n

## Overview

Internationalization is an import aspect of your application. Not to mention that it is very tricky, as [some companies](https://www.translatemedia.com/translation-blog/coca-cola-cancels-french-campaign-due-to-translation-blunder/) have already experienced. This is often called I18n, where the 18 stands for the letters in the word. Do not confuse this with localization, which also means that you're adjusting your website for the end user his/her culture (date formatting, currency, ...).

We're going to create a simple website with 2 pages containing some text. After that we'll implement internationalization so that we can support different languages. As a finishing touch, we'll store the language preference in a cookie.

### Setting up the website

Create a new project with:

```bash
 mix phx.new i18n --no-ecto --no-webpack
```

Adjust the following files, an in-depth explanation should no longer be necessary of the following changes:

```elixir
# router.ex
  scope "/", I18nWeb do
    pipe_through :browser

    get "/", PageController, :index
    get "/another_index", PageController, :another_index
  end
```

```elixir
defmodule I18nWeb.PageController do
  use I18nWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end

  def another_index(conn, _params) do
    render(conn, "another_index.html")
  end
end
```

```html
<!-- templates/layout/app.html.eex -->
      <nav role="navigation">
        <ul>
          <li>
            <a href="/">HOME</a>
          </li>
          <li>
            <a href="/another_index">ANOTHER INDEX</a>
          </li>
        </ul>
      </nav>
```

```html
<!-- templates/page/index.html.eex -->
<p>Welcome to the world of Elixir and Phoenix!</p>
```

```html
<!-- templates/page/another_index.html.eex -->
<p>Students from UCLL are so great!
    They can make a website with Phoenix in English and Japanese!</p>
```

When you fire up your web app, you'll see a simple website with two links. That is what we're going to internationalize.



## Internationalization

### Gettext

Phoenix uses by default Gettext for translations. It is a GNU project that uses `.po` and `.pot` files to manage its translations. It offers a lot of features, such as plural forms and much more.

You can see a whole list of pluralforms on [this website](https://localization-guide.readthedocs.io/en/latest/l10n/pluralforms.html#f2), but just to show the complexity:

```text
nl  Dutch       nplurals=2; plural=(n != 1);
en  English     nplurals=2; plural=(n != 1);
ja  Japanese    nplurals=1; plural=0;
hr  Croatian    nplurals=3; plural=(n%10==1 && n%100!=11 ? 0 : n%10>=2 && n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2);
```

Good thing that Gettext helps us with this. Let's get started.

### Configuring gettext

First we'll start with some basic configuration:

```elixir
config :i18n, I18nWeb.Gettext,
  locales: ~w(en ja), # ja stands for Japanese.
  default_locale: "en"
```

### Let our webpage to use translations

That's all good and well, but in our webpage we still need to use gettext in order to get this translation. First of all our main page:

```html
<!-- index.html.eex -->
<p>
  <%= gettext "Welcome to the world of %{language} and %{framework}!", language: "Elixir", framework: "Phoenix!" %>
</p>
```

Often you'll see the text here completely corresponding with the actual text. This is because the gettext function will by default return the string that's passed in.

#### POT files

POT stands for Portable Object Template. These files are automatically generated by `mix gettext.extract`. **Do not edit these files manually!**

When you execute this task, you'll see that there's a new file called `priv/gettext/default.pot`. This file is based on the `gettext` function that you called in your template. Though we'll not add our translations here, we do that in the next section.

#### PO files

The Portable Object files are based on the POT files. You'll add your translations here, but in order to do that we'll have to generate them with the task `mix gettext.merge priv/gettext`. Now you should see a `default.po` file which should look like this:

```text
#, elixir-format, fuzzy
#: lib/i18n_web/templates/page/index.html.eex:2
msgid "Welcome to the world of %{language} and %{framework}!"
msgstr ""
```

__Note that the above commands could be run in a single one. This is `mix gettext.extract --merge`.__

#### Adding a new language

This gets us started. You can add a new language with `mix gettext.merge priv/gettext --locale ja`. You'll see some new files being added. Next we can add our translation in ther `ja/LC_MESSAGES/default.po` file:

```text
#, elixir-format
#: lib/i18n_web/templates/page/index.html.eex:2
msgid "Welcome to the world of %{language} and %{framework}!"
msgstr "「%{language}」と「%{framework}」の世界へようこそ！"
```

If you want to test it out manually, change your default language in your config to `ja`. Fire up your webserver and there you go!

### Remaining files

Next we do the same thing again but for the second page. Adjust the following files and execute the following tasks:

```html
<!-- another_index.html.eex -->
<p>
    <%= gettext "Students from UCLL are so great! They can make a website with %{framework} in English and Japanese!", framework: "Phoenix" %>
</p>
```

```bash
mix gettext.extract --merge
```

The following file is `ja/LC_MESSAGES/default.po` :

```text
#, elixir-format
#: lib/i18n_web/templates/page/another_index.html.eex:2
msgid "Students from UCLL are so great! They can make a website with %{framework} in English and Japanese!"
msgstr "「UCLL」という大学の生徒はすごいです！「%{framework}」で英語と日本語のウェブサイトを作ることができます！"
```

If you've adjusted your default locale to japanese, you should see the translated text!



## Language switching

We've seen that our templates can render multilingual context with a small effort. Though the user still needs to be able choose his/her language. We'll do this in 3 steps:

* Provide a link / button
* Read the locale
* Remember the locale (cookie)

### Generating a URL with the language specified

There are 3 common ways to configure your locale with a URL link. Those are commonly:

* [http://en.example.com/some/path](http://en.example.com/some/path)
* [http://example.com/en/some/path](http://example.com/en/some/path)
* [http://example.com/some/path?locale=en](http://example.com/some/path?locale=en)

We'll go for the last one. So in order to provide these links, we'll create 2 buttons (for japanese and english):

```elixir
defmodule I18nWeb.LayoutView do
  use I18nWeb, :view

  def new_locale(conn, locale, language_title) do
    "<a href=\"#{Routes.page_path(conn, :index, locale: locale)}\">#{language_title}</a>" |> raw
  end
end
```

```html
<!-- app.html.eex -->
    <section class="container">
      <nav role="navigation">
        <ul>
          <li><a href="/">HOME</a></li>
          <li><a href="/another_index">ANOTHER INDEX</a></li>
        </ul>
      </nav>
      <ul>
        <li><%= new_locale @conn, :en, "English" %></li>
        <li><%= new_locale @conn, :ja, "Japanese" %></li>
      </ul>
    </section>
```

Firing up your browser results in language buttons that do nothing (for now).

### Reading the language from the URL

Right now we're pointing to a single location in our application to configure our URL. Though it should be configureable on whatever page. That's why we'll write this as a plug:

```elixir
# router.ex
  pipeline :browser do
    plug :accepts, ["html"]
    plug :fetch_session
    plug :fetch_flash
    plug :protect_from_forgery
    plug :put_secure_browser_headers
    plug I18nWeb.Plugs.Locale
  end
```

```elixir
defmodule I18nWeb.Plugs.Locale do
  import Plug.Conn

  @locales Gettext.known_locales(I18nWeb.Gettext)

  def init(default), do: default

  def call(conn, _options) do
    case fetch_locale_from(conn) do
      nil ->
        conn

      locale ->
        I18nWeb.Gettext |> Gettext.put_locale(locale)
        conn |> put_resp_cookie("locale", locale, max_age: 365 * 24 * 60 * 60)
    end
  end

  defp fetch_locale_from(conn) do
    (conn.params["locale"] || conn.cookies["locale"])
    |> check_locale
  end

  defp check_locale(locale) when locale in @locales, do: locale
  defp check_locale(_), do: nil
end
```

First of all we add the plug to our browser pipeline. This causes every request to pass through that plug. After which, if the language setting is present, will configure this for every request it is processing. This is done with `I18nWeb.Gettext |> Gettext.put_locale(locale)`.

After the locale is found and set for the connection, we add a cookie.

### Closing notes

While it seems at first that the language setting can only be done at the index page, feel free to go to [http://localhost:4000/another_index/?locale=ja](http://localhost:4000/another_index/?locale=ja) . This will illustrate that the language could be set at every route.

You need to be able to show:

* That the cookie is stored in your browser
* That the set-cookie header is present in your response



# Labo 9 - Webpack

## Hello webpack

### Installation

First, install [Webpack](https://www.npmjs.com/package/webpack) and [webpack-dev-server](https://www.npmjs.com/package/webpack-dev-server) globally.

```bash
$ npm i -g webpack webpack-dev-server
$ npm i -D -g webpack-cli

```

### Front-end code

After installing webpack and webpack-dev-server we will create a new folder for our hello webpack demo. Within this folder create a new file named 'myjsfile.js'. with the following javascript code. This will be all our javascript code for this hello world demo.

```js
document.write('<h1>Hello Webpack</h1>');
```

Besides javascript we need to serve some html content to the client. Next create a new file named 'index.html'.
This file should contain the code below.

```html
<html>
  <body>
    <script type="text/javascript" src="bundle.js"></script>
  </body>
</html>
```

Notice the src of the script tag, this is pointing to bundle.js, not to our myjsfile.js!

### Webpack config

For the final part we have to configure our webpack. Thus create a new file named 'webpack.config.js'. Within this file write the following code. 

```js
module.exports = {
  entry: './myjsfile.js',
  output: {
    filename: 'bundle.js'
  }
};
```

In the code the entry point is our myjsfile.js because this is the file we want to include. As output we want a file named bundle.js. This is the same file we referred to in our .html file. Because this hello webpack demo only contains javascript code we do not need any other loaders.

For ease we create a package.json file that can be used to run webpack from a single command.



```json
{
  "name": "hello_webpack",
  "version": "1.0.0",
  "main": "myjsfile.js",
  "scripts": {
    "dev": "webpack -d && webpack-dev-server --open",
    "build": "webpack -p"
  },
  "license": "MIT",
  "devDependencies": {
    "webpack-cli": "^3.3.11"
  }
}
```

### Run

To let webpack run use the following command, this triggers the package.json script. If the browser does not open automatically, go to [this page](http://localhost:8080/) to visit your page.

```bash
$ npm run dev
```

 If you open the folder you'll see that webpack created a new file named bundle.js. You can open this file and see a lot of non-human-understandable javascript which loaded by the client.



## Loader

### Installation

Make sure you have finished the installation of [hello_Webpack](1_hello_Webpack.md).



### Front-end code

Webpack allows you to include CSS in JS file, then preprocessed CSS file with CSS-loader.


Create a new folder for our loader demo. Within this folder create a new file named 'main.js'. with the following javascript code. This will be all our javascript code for this loader demo.

```js
require('./app.css');
```

As the javascripts requires a app.css file we have to make one. Create a new file named app.css and include the following code in this file.

```css
body {
  background-color: blue;
}
```

Besides javascript we need to serve some html content to the client. Next create a new file named 'index.html'.
This file should contain the code below.

```html
<html>
  <head>
    <script type="text/javascript" src="bundle.js"></script>
  </head>
  <body>
    <h1>Hello blue Webpack</h1>
  </body>
</html>
```

### Webpack config

For the final part we have to configure our webpack. Thus create a new file named 'webpack.config.js'. Within this file write the following code. 

```js
module.exports = {
  entry: './main.js',
  output: {
    filename: 'bundle.js'
  },
  module: {
    rules:[
      {
        test: /\.css$/,
        use: [ 'style-loader', 'css-loader' ]
      },
    ]
  }
};
```

In the code the entry point is our main.js because this is the file we want to include. As output we want a file named bundle.js. This is the same file we referred to in our .html file. Next we included a loader which matches against all .css files. When matches it uses both the style-loader and the css-loader.

For ease we create a package.json file that can be used to run webpack from a single command.

```json
{
  "name": "webpack-loader",
  "version": "1.0.0",
    "devDependencies": {
    "css-loader": "^0.28.9",
    "style-loader": "^0.19.1",
    "webpack": "^3.10.0",
    "webpack-dev-server": "^2.11.1"
  },
  "scripts": {
    "dev": "webpack -d && webpack-dev-server --open",
    "build": "webpack -p"
  },
  "license": "MIT"
}
```

### Run

To let webpack run use the following command. If the browser does not open automatically, go to [this page](http://localhost:8080/) to visit your page. 

```bash
$ npm install #Install the devDependencies defined in package.json
$ npm run dev #run the script commands defined in package.json
```

You should see the page with a blue body. If you inspect the page you will see that webpack changed the html code so that the styling previously defined in the app.css file is now included in the html.



## Secret

### Installation

Make sure you have finished the installation of [hello_Webpack](1_hello_Webpack.md).

### Front-end code

Create a new folder for our secret demo. Within this folder create a js folder to store our javascript files. Within this js folder create 2 new javascript files. A selector file which uses ordinary queryselectors to select the correct html element.

selector.js

```js
var btn = document.querySelector('#button');
var para = document.querySelector('#paragraph');
```

And an app file which is responsible for the application logic. This javascript should hide or show a secret message when the button is clicked.

app.js

```js
  
var showSecret = false;

btn.addEventListener('click', toggleSecretState);
updateSecretParagraph();

function toggleSecretState() {
    showSecret = !showSecret;
    updateSecretParagraph();
    updateSecretButton()
}

function updateSecretButton() {
    if (showSecret) {
        btn.textContent = 'Hide the Secret';
    } else {
        btn.textContent = 'Show the Secret';
    }
}

function updateSecretParagraph() {
    if (showSecret) {
        para.style.display = 'block';
    } else {
        para.style.display = 'none';
    }
}
```

As you probably have noticed is that the app.js file depends on the selector.js file. The app.js file reference to two parameters called 'btn' and another parameter called 'para' who are defined in the selector.js file. This means that our app.js file can only run when it is placed **after** importing the selector.js file. This is what we will do in the index.html file.

index.html

```html
<!doctype html>
  <body>
    <button id="button">Show the Secret</button>
    <p id="paragraph">The answer to life the universe and everything = 42.</p>
    <script src="js/selector.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
```

 To verify that everything is working correctly at this point, go to your folder and double click the index.html file so it will be displayed in the browser. Click on the button to make the secret message appear and disappear.

To prove that the order of importing the scripts is important, try to swap them and check if the button is still working correctly. Check the console to see any error messages.

As you might have guessed, it won't work as the import order is important. For this small and easy demo this is not a problem, but for big projects this can cause severe problems. This is a reason to use webpack as webpack can bundle the dependend files so the import order isn't important anymore.


To make use of webpack we have to change our index.html file to use the app_bundle.js file that webpack will create for us.

index.html

```html
<!doctype html>
  <body>
    <button id="button">Show the Secret</button>
    <p id="paragraph">The answer to life the universe and everything = 42</p>
    <script src="dist/js/app_bundle.js"></script>
  </body>
</html>
```

Besides changing the index.html we have to change both the js files. This to let webpack know what dependecies to use. In the selector.js file export the used variables.

selector.js

```js
export var btn = document.querySelector('#button');
export var para = document.querySelector('#paragraph');
```

In the app.js specify the imports at the top of the file.
app.js

```js
import {btn, para} from './selector.js'
```

### Webpack config

For the final part we have to configure our webpack. Thus create a new file named 'webpack.config.js'. Within this file write the following code. 

```js
module.exports = {
  entry: {
  app_bundle: './js/app.js',
  },
  output: {
    filename: './dist/js/[name].js'
  }
};

```

For ease we create a package.json file that can be used to run webpack from a single command.

```json
{
  "name": "webpack-demo3",
  "version": "1.0.0",
  "devDependencies": {
    "webpack": "^3.10.0",
    "webpack-dev-server": "^2.11.1"
  },
  "scripts": {
    "dev": "webpack -d && webpack-dev-server --open",
    "build": "webpack -p"
  },
  "license": "MIT"
}
```

### Run

To let webpack run use the following command. If the browser does not open automatically, go to [this page](http://localhost:8080/) to visit your page. 

```bash
$ npm install #Install the devDependencies defined in package.json
$ npm run dev #run the script commands defined in package.json
```



## Phoenix

### Installation

Make sure you have finished the installation of [hello_Webpack](1_hello_Webpack.md).

### Create phoenix project

```bash
$ mix phx.new a_webpack_demo --umbrella --database mysql
```

### Front-end code

Copy the selector.js and app.js javascript files from the [3_secret](3_secret.md) demo. We will reuse those files in this demo to get webpack working with the phoenix framework. Navigate to 'apps/a_webpack_demo_web/assets/js' and paste both the selector.js and the app.js files in here, do **NOT** overwrite the 'app.js' file but rename your file to 'secret.js'.

Next navigate to the template folder and open the 'index.html.eex' file. This is our html code we have to change to show a button and a paragraph section. Add the code below between the .phx-hero and the .row sections.

```html
  <button id="button">Show the Secret</button>
  <p id="paragraph">The answer to life the universe and everything = 42</p>
```

Next we open the webpack.config.js file again in 'apps/a_webpack_demo_web/assets/js'. Here we can see full configuration. If you want you can alter the webpack configuration in this file. You will do so later on in this guide. For now it is important to see the entry point webpack will use to build its internal dependency graph, open this entry point file and add the following line at the bottom of this file. This imports our secret.js file so now the app.js file depends on secret.js so this will be included in our dependency graph and eventually included in our output bundle.

```js
import './secret.js'
```

### Run

As phoenix already configured the webpack config file, we dont have to do this ourselves. We can just build webpack and run our server with the following commands.

Build webpack in the apps/a_webpack_demo_web/assets folder.

```bash
$ webpack -d #Build webpack in the apps/a_webpack_demo_web/assets folder.
$ mix phx.server
```

### Multiple bundles

Until now webpack has build everything in a single bundle. Your task now is to reconfigure the nessecary .js and .html.eex files to build and include two seperate bundles. The one original bundle including the app.css and app.js (prebuild by phoenix) and another bundle which is responsible for the secret button.