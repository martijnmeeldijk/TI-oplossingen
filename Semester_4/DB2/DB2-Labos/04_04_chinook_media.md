# Media Dabase

No joke, dit is de effectieve titel van dit bestand.



1. **Chinook Schema** 

   *Geef voor elk album de 2 langste nummers (tracks). (Dus alle albums moeten getoond worden). Toon de naam van het album, het nummer en de tijd. Schrijf deze query zo performant mogelijk.*

Het is het snelst met een gecorreleerde subquery

```sql
--gebruik dit
where 2 > (select count ("TrackId")
		  from "Track"
		  where "Track"."Milliseconds" > t."Milliseconds" and t."AlbumId" = "Track"."AlbumId")

```

