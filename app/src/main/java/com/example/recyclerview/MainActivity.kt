package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.recyclerview.data.Pokemon
import com.example.recyclerview.ui.screens.PokemonDetailScreen
import com.example.recyclerview.ui.screens.PokemonListScreen
import com.example.recyclerview.ui.theme.RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecyclerViewTheme {
                Surface {
                    PokemonApp()
                }
            }
        }
    }
}

@Composable
fun PokemonApp() {
    var selectedPokemon by remember { mutableStateOf<Pokemon?>(null) }

    if (selectedPokemon == null) {
        PokemonListScreen(
            onPokemonClick = { pokemon ->
                selectedPokemon = pokemon
            }
        )
    } else {
        PokemonDetailScreen(
            pokemon = selectedPokemon!!,
            onBack = {
                selectedPokemon = null
            }
        )
    }
}