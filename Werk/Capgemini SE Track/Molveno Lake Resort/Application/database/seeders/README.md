# Heya its me Caimin here,
Als je seeders wilt gebruiken:

- Zit in de application folder.
- Als je alles leeg wil maken in je database; in je console: (php artisan migrate:fresh), let op dit verwijderd alle data!!!
- dan (php artisan db:seed), dit vult alles op met dummy data.

- Technisch gezien is migrate:fresh gewoon migrate, maar wel met alles data verwijderen wat ik wel handiger vond.


> [!WARNING]
> Als je nieuwe dummy data wil toevoegen, altijd eerst migrate:fresh doen. Je verliest dan wel nieuwe toegevoegde data.

# TODO: (NOT FINISHED YET)
- In de DatabaseSeeder.php file kan je $useDummyData veranderen naar false om echte meer realistische hotel data te gebruiken. 
