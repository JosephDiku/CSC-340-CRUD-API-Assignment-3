# CSC-340-CRUD-API-Assignment-3

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/JosephDiku/CSC-340-CRUD-API-Assignment-3.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/JosephDiku/CSC-340-CRUD-API-Assignment-3/blob/main/pom.xml) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/JosephDiku/CSC-340-CRUD-API-Assignment-3/blob/main/src/main/resources/application.properties) This file has the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.

## API Endpoints
Base URL: [`http://localhost:8080/hawk`](http://localhost:8080/hawk)


1. ### [`/`](http://localhost:8080/hawk) (GET)
Gets a list of all Hawks in the database.

#### Response - A JSON array of Hawk objects.

 ```
[
    ... // The array was lengthy so I am only showing the part relevant to other endpoints.
    {
    "animalId": 48,
    "name": "Himalayan Buzzard",
    "description": "A medium-sized raptor found in the high mountains and forests of the Himalayas.",
    "origin": "Asia (Himalayas)",
    "population": 25000
  },
  {
    "animalId": 52,
    "name": "Grey-faced Buzzard",
    "description": "A migratory bird of prey known for its distinct facial coloring and long-distance movements across East Asia.",
    "origin": "Asia",
    "population": 100000
  },
  {
    "animalId": 2,
    "name": "Cooper' Hawk",
    "description": "A medium-sized hawk found in North America",
    "origin": "North America",
    "population": 750000
  }
]
```

2. ### [`/{hawkId}`](http://localhost:8080/hawk/2) (GET)
Gets an individual Hawk in the system. Each Hawk is identified by a numeric `hawkId`

#### Parameters
- Path Variable: `hawkId` &lt;Long &gt; - REQUIRED

#### Response - A single Hawk

```
  {
  "animalId": 2,
  "name": "Cooper' Hawk",
  "description": "A medium-sized hawk found in North America",
  "origin": "North America",
  "population": 750000
}
```

3. ### [`/name`](http://localhost:8080/hawk/name?key=Kite) (GET)
Gets a list of hawks with a name that contains the given string.

#### Parameters
- query parameter: `search` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Hawk objects.

```
[
  {
    "animalId": 24,
    "name": "Square-tailed Kite",
    "description": "Not a true Buteo, but often mistaken for a hawk; endemic to Australia.",
    "origin": "Australia",
    "population": 5000
  },
  {
    "animalId": 41,
    "name": "Black Kite",
    "description": "One of the most numerous raptors in the world.",
    "origin": "Asia",
    "population": 6000000
  },
  {
    "animalId": 42,
    "name": "Snail Kite",
    "description": "Highly specialized hawk that only eats snails.",
    "origin": "South America",
    "population": 100000
  },
  {
    "animalId": 43,
    "name": "Plumbeous Kite",
    "description": "Found in lowland forests and often seen near water.",
    "origin": "South America",
    "population": 75000
  },
  {
    "animalId": 44,
    "name": "Mississippi Kite",
    "description": "Graceful, light-colored hawk of the US South.",
    "origin": "North America",
    "population": 120000
  },
  {
    "animalId": 45,
    "name": "Hook-billed Kite",
    "description": "Specialized beak for tearing into snails and beetles.",
    "origin": "South America",
    "population": 25000
  },
  {
    "animalId": 46,
    "name": "Brahminy Kite",
    "description": "Distinctive white and chestnut plumage, common near coasts.",
    "origin": "Asia",
    "population": 300000
  }
]
```

4. ### [`/origin/{origin}`](http://localhost:8080/hawk/origin/Africa) (GET)
Gets a list of hawks from a specific continent.

#### Parameters
- path variable: `major` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Hawk objects.

```
[
  {
    "animalId": 28,
    "name": "Black-chested Snake Eagle",
    "description": "A large raptor that hunts primarily snakes.",
    "origin": "Africa",
    "population": 50000
  },
  {
    "animalId": 29,
    "name": "Martial Eagle",
    "description": "Africa's largest eagle, often mistaken for a large hawk.",
    "origin": "Africa",
    "population": 10000
  },
  {
    "animalId": 30,
    "name": "Augur Buzzard",
    "description": "Common large hawk of open mountainous areas.",
    "origin": "Africa",
    "population": 80000
  },
  {
    "animalId": 31,
    "name": "Lizard Buzzard",
    "description": "Small, slender hawk specializing in lizards and insects.",
    "origin": "Africa",
    "population": 150000
  },
  {
    "animalId": 32,
    "name": "African Goshawk",
    "description": "Found in forests and dense woodlands.",
    "origin": "Africa",
    "population": 60000
  },
  {
    "animalId": 33,
    "name": "Grasshopper Buzzard",
    "description": "Specializes in hunting large insects.",
    "origin": "Africa",
    "population": 40000
  }
]
```

6. ### [`/`](http://localhost:8080/hawk) (POST)
Create  a new Hawk entry

#### Request Body
A hawk object. Note the object does not include an ID as this is autogenerated.
```
{
    "name": "Mountain Hawk-Eagle",
    "description": "A powerful, crested bird of prey native to tropical and subtropical Asia, often found at high altitudes.",
    "origin": "Asia",
    "population": 50000 
}
```
#### Response - The newly created Hawk.

```
  {
  "animalId": 53,
  "name": "Mountain Hawk-Eagle",
  "description": "A powerful, crested bird of prey native to tropical and subtropical Asia, often found at high altitudes.",
  "origin": "Asia",
  "population": 50000
}
```

7. ### [`/{hawkId}`](http://localhost:8080/hawk/2) (PUT)
Update an existing Hawk.

#### Parameters
- Path Variable: `hawkId` &lt;integer&gt; - REQUIRED

#### Request Body
A hawk object with the updates.
```
{
  "animalId": 2,
  "name": "Cooper' Hawk",
  "description": "A medium-sized hawk found in North America",
  "origin": "South America",
  "population": 950000
}
```
#### Response - the updated Hawk object.
```
{
  "animalId": 2,
  "name": "Cooper' Hawk",
  "description": "A medium-sized hawk found in North America",
  "origin": "South America",
  "population": 950000
}
```

8. ### [`/{hawkId}`](http://localhost:8080/hawk/2) (DELETE)
Delete an existing Hawk.

#### Parameters
- Path Variable: `hawkId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Hawk.
```
[
... // The array was lengthy so I am only showing the part relevant to other endpoints.
  {
    "animalId": 48,
    "name": "Himalayan Buzzard",
    "description": "A medium-sized raptor found in the high mountains and forests of the Himalayas.",
    "origin": "Asia (Himalayas)",
    "population": 25000
  },
  {
    "animalId": 52,
    "name": "Grey-faced Buzzard",
    "description": "A migratory bird of prey known for its distinct facial coloring and long-distance movements across East Asia.",
    "origin": "Asia",
    "population": 100000
  },
  {
    "animalId": 53,
    "name": "Mountain Hawk-Eagle",
    "description": "A powerful, crested bird of prey native to tropical and subtropical Asia, often found at high altitudes.",
    "origin": "Asia",
    "population": 50000
  }
]
```