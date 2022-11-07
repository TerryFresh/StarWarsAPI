Я фанат звёздных войн. Но я стал им совсем недавно и поэтому хочу иметь инструмент который даст мне возможность получать новую для себя информацию про различные объекты из вселенной.
Я хочу передавать твоему сервису строковый параметр, 
а ты должен возвращать мне всю инфу найденную по этой строке.

Как я это вижу:
запрос на localhost:8000/search?value=R2D2

Мне возвращается вся инфа по этому персонажу.
Я уже нашел апишку которая мне может помочь: https://swapi.dev 
Но есть проблема, там поиск работает конкретно по какому-то ресурсу (people, planets, films, species, species, vehicles, starships), 
а я хочу искать сразу по всем. 
И ещё инфы явно маловато, я хочу чтобы ты добавлял ссылку на статью в википедии в дополнительном поле 
wiki
:

Итого, при старте приложения ты должен ходить за списком доступных ресурсов: https://swapi.dev/api 
Дальше при получении поискового запроса, проходиться по всем ресурсам и отправлять запрос на поиск (посмотри как это делается в документации https://swapi.dev/documentation)
Собираешь ответы в JSON вида, где ключами являются ресурсы,  а значениям поле result из JSON’a который тебе пришлет SWAPI в. который ты добавишь ссылку на википедию
{
        people: [
         {
            "name": "R2-D2", 
            "height": "96", 
            "mass": "32", 
            "hair_color": "n/a", 
            "skin_color": "white, blue", 
            "eye_color": "red", 
            "birth_year": "33BBY", 
            "gender": "n/a", 
            "homeworld": "https://swapi.dev/api/planets/8/", 
            "films": [
                "https://swapi.dev/api/films/1/", 
                "https://swapi.dev/api/films/2/", 
                "https://swapi.dev/api/films/3/", 
                "https://swapi.dev/api/films/4/", 
                "https://swapi.dev/api/films/5/", 
                "https://swapi.dev/api/films/6/"
            ], 
            "species": [
                "https://swapi.dev/api/species/2/"
            ], 
            "vehicles": [], 
            "starships": [], 
            "created": "2014-12-10T15:11:50.376000Z", 
            "edited": "2014-12-20T21:17:50.311000Z", 
            "url": "https://swapi.dev/api/people/3/",
            "wiki": "https://en.wikipedia.org/wiki/R2-D2"
         }
        ],
      }
