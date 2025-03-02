/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unscramble.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

//val getWords : (Context) -> Set<String> = { context ->
//    when (getCurrentLanguage(context)) {
//        "ES" -> allSpanishWords
//        else -> allWords
//    }
//}

val allWords: Set<String> =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom",
        "coffee",
        "colorful",
        "cookie",
        "creative",
        "cruise",
        "dance",
        "daytime",
        "dinosaur",
        "doorknob",
        "dine",
        "dream",
        "dusk",
        "eating",
        "elephant",
        "emerald",
        "eerie",
        "electric",
        "finish",
        "flowers",
        "follow",
        "fox",
        "frame",
        "free",
        "frequent",
        "funnel",
        "green",
        "guitar",
        "grocery",
        "glass",
        "great",
        "giggle",
        "haircut",
        "half",
        "homemade",
        "happen",
        "honey",
        "hurry",
        "hundred",
        "ice",
        "igloo",
        "invest",
        "invite",
        "icon",
        "introduce",
        "joke",
        "jovial",
        "journal",
        "jump",
        "join",
        "kangaroo",
        "keyboard",
        "kitchen",
        "koala",
        "kind",
        "kaleidoscope",
        "landscape",
        "late",
        "laugh",
        "learning",
        "lemon",
        "letter",
        "lily",
        "magazine",
        "marine",
        "marshmallow",
        "maze",
        "meditate",
        "melody",
        "minute",
        "monument",
        "moon",
        "motorcycle",
        "mountain",
        "music",
        "north",
        "nose",
        "night",
        "name",
        "never",
        "negotiate",
        "number",
        "opposite",
        "octopus",
        "oak",
        "order",
        "open",
        "polar",
        "pack",
        "painting",
        "person",
        "picnic",
        "pillow",
        "pizza",
        "podcast",
        "presentation",
        "puppy",
        "puzzle",
        "recipe",
        "release",
        "restaurant",
        "revolve",
        "rewind",
        "room",
        "run",
        "secret",
        "seed",
        "ship",
        "shirt",
        "should",
        "small",
        "spaceship",
        "stargazing",
        "skill",
        "street",
        "style",
        "sunrise",
        "taxi",
        "tidy",
        "timer",
        "together",
        "tooth",
        "tourist",
        "travel",
        "truck",
        "under",
        "useful",
        "unicorn",
        "unique",
        "uplift",
        "uniform",
        "vase",
        "violin",
        "visitor",
        "vision",
        "volume",
        "view",
        "walrus",
        "wander",
        "world",
        "winter",
        "well",
        "whirlwind",
        "x-ray",
        "xylophone",
        "yoga",
        "yogurt",
        "yoyo",
        "you",
        "year",
        "yummy",
        "zebra",
        "zigzag",
        "zoology",
        "zone",
        "zeal"
    )

val allSpanishWords: Set<String> = setOf(
    // Traducciones de allWords
    "abierto",
    "amable",
    "almohada",
    "alfabeto",
    "animal",
    "anécdota",
    "aprender",
    "aprendizaje",
    "apresurarse",
    "año",
    "aula",
    "auto",
    "banco",
    "barco",
    "baile",
    "bien",
    "cachorro",
    "café",
    "cámara",
    "canguro",
    "carta",
    "casero",
    "camisa",
    "camión",
    "campamento",
    "cena",
    "cenar",
    "cien",
    "correr",
    "cesta",
    "cocina",
    "coliflor",
    "celo",
    "charla",
    "clase",
    "clásico",
    "colorido",
    "creativo",
    "crepúsculo",
    "crucero",
    "diente",
    "dinosaurio",
    "elefante",
    "elevar",
    "eléctrico",
    "esmeralda",
    "estilo",
    "extraño",
    "flores",
    "frecuente",
    "gato",
    "galleta",
    "girar",
    "globo",
    "guitarra",
    "gran",
    "habilidad",
    "habitación",
    "hielo",
    "iglu",
    "ícono",
    "invertir",
    "invitar",
    "invierno",
    "jarrón",
    "jovial",
    "juntos",
    "kaleidoscopio",
    "koala",
    "labrinto",
    "laberinto",
    "liberar",
    "libre",
    "libro",
    "limón",
    "lirio",
    "luna",
    "marco",
    "marino",
    "maletín",
    "malvavisco",
    "melodía",
    "miel",
    "mitad",
    "minuto",
    "monumento",
    "montaña",
    "morsa",
    "música",
    "mundo",
    "nave espacial",
    "naranja",
    "noche",
    "nombre",
    "norte",
    "nunca",
    "negociar",
    "nariz",
    "número",
    "opuesto",
    "orden",
    "ordenado",
    "paquete",
    "paisaje",
    "palabra",
    "pintura",
    "polar",
    "pizza",
    "picnic",
    "pintor",
    "persona",
    "pintura",
    "polo",
    "pollo",
    "podcast",
    "presentación",
    "presentar",
    "puppy",
    "puzzle",
    "receta",
    "reír",
    "reírse",
    "rebobinar",
    "receta",
    "recoger",
    "recuerdo",
    "revolución",
    "restaurante",
    "rompecabezas",
    "rodilla",
    "rosa",
    "roble",
    "saltar",
    "secreto",
    "seguir",
    "semilla",
    "sueño",
    "surgir",
    "terminar",
    "tiempo diurno",
    "tarde",
    "taxi",
    "temporalizador",
    "torbellino",
    "tú",
    "together",
    "tooth",
    "turista",
    "unidad",
    "unicornio",
    "único",
    "uniforme",
    "útil",
    "vagabundear",
    "vagar",
    "vela",
    "ver",
    "verde",
    "violin",
    "violín",
    "vista",
    "visita",
    "visitante",
    "visión",
    "volumen",
    "volar",
    "vuelar",
    "vista",
    "viva",
    "yoga",
    "yogur",
    "yoyó",
    "zebra",
    "zigzag",
    "zoología",
    "zona",
    "zeal",
    "amor",
    "amistad",
    "árbol",
    "casa",
    "sol",
    "luna",
    "estrella",
    "mar",
    "montaña",
    "río",
    "bosque",
    "flor",
    "cielo",
    "nube",
    "lluvia",
    "viento",
    "nieve",
    "tierra",
    "fuego",
    "agua",
    "aire",
    "vida",
    "muerte",
    "sueño",
    "esperanza",
    "paz",
    "guerra",
    "libertad",
    "justicia",
    "verdad",
    "mentira",
    "felicidad",
    "tristeza",
    "ira",
    "amoroso",
    "rápido",
    "lento",
    "fuerte",
    "débil",
    "grande",
    "pequeño",
    "alto",
    "bajo",
    "ancho",
    "estrecho",
    "nuevo",
    "viejo",
    "joven",
    "viejo",
    "bonito",
    "feo",
    "rico",
    "pobre",
    "inteligente",
    "tonto",
    "dulce",
    "amargo",
    "salado",
    "picante",
    "ligero",
    "pesado",
    "suave",
    "duro",
    "limpio",
    "sucio",
    "caliente",
    "frío",
    "seco",
    "húmedo",
    "rápido",
    "lento",
    "alegre",
    "enojado",
    "cansado",
    "emocionado",
    "aburrido",
    "asustado",
    "sorprendido",
    "contento",
    "embarazoso",
    "generoso",
    "egoísta",
    "valiente",
    "miedoso",
    "optimista",
    "pesimista",
    "paciente",
    "impaciente",
    "calmado",
    "nervioso",
    "relajado",
    "estresado",
    "confundido",
    "claramente",
    "rápidamente",
    "lentamente",
    "cuidadosamente",
    "fácil",
    "difícil",
    "complejo",
    "simple",
    "interesante",
    "aburrido"
)

