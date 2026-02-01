package com.example.recyclerview.data

class PokemonProvider {
    fun getPokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(1, "Bulbasaur", "Planta"),
            Pokemon(2, "Ivysaur", "Planta"),
            Pokemon(3, "Venusaur", "Planta"),
            Pokemon(4, "Charmander", "Foc"),
            Pokemon(5, "Charmeleon", "Foc"),
            Pokemon(6, "Charizard", "Foc"),
            Pokemon(7, "Squirtle", "Aigua"),
            Pokemon(8, "Wartortle", "Aigua"),
            Pokemon(9, "Blastoise", "Aigua"),
            Pokemon(10, "Pikachu", "Elèctric"),
            Pokemon(11, "Raichu", "Elèctric"),
            Pokemon(12, "Jigglypuff", "Fada"),
            Pokemon(13, "Meowth", "Normal"),
            Pokemon(14, "Psyduck", "Aigua"),
            Pokemon(15, "Snorlax", "Normal")
        )
    }
}