# Deelopracht 4

## Uitleg van Dennis

### Deel 2

**hero.ts** is een class met alle attributen van een "hero"; 

**hero.service.ts** maakt get requests naar uw backend om alle hero's op he halen (vanuit JSON), die convert die ook automatisch; 

**heroes.component.ts** gebruikt **hero.service.ts** om alle heroes in te laden en die op u pagina te displayen, hiervoor gebruikt hij **heroes.component.html**;



Je kan veel code overnemen van [deze](https://github.com/UCLLWebontwikkeling4/Demo10_Angular_LectorExample_FrontEndAsync_V9) repo.

Begin met een **user.ts** aan te maken, analoog aan de **hero.ts** van de repo.



### Deel 3

zoals die vrouw doet, een input late verschijnen als ge derop klikt

submit heeft een Click="<Function>" die een POST request stuurt naar u servelt

ma eig moet ge dus in u html een functie aanspreke naar u component en die roept gwn een function aan naar u Service, u service stuurt dan u POST request

Documentatie van Angular

```
/** POST: add a new hero to the database */
addHero (hero: Hero): Observable<Hero> {
  return this.http.post<Hero>(this.heroesUrl, hero, httpOptions)
    .pipe(
      catchError(this.handleError('addHero', hero))
    );
}
```

 [Bron](https://angular.io/guide/http#making-a-post-request)



Zet dit in je java servlet als je een cors error krijgt :

```
response.setHeader("Access-Control-Allow-Origin", "*");
```

