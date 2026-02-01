package com.example.recyclerview.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recyclerview.data.Pokemon
import com.example.recyclerview.data.PokemonProvider
import com.example.recyclerview.ui.components.PokemonItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    onPokemonClick: (Pokemon) -> Unit
) {
    val pokemonList = remember { PokemonProvider().getPokemonList() }
    var showGrid by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pokedex") },
                actions = {
                    IconButton(onClick = { showGrid = !showGrid }) {
                        Icon(
                            imageVector = if (showGrid) Icons.Default.List else Icons.Default.Menu,
                            contentDescription = "Canviar vista"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            if (showGrid) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(pokemonList) { pokemon ->
                        PokemonItem(
                            pokemon = pokemon,
                            onItemClick = onPokemonClick // Passem el clic amunt
                        )
                    }
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(8.dp)) {
                    items(pokemonList) { pokemon ->
                        PokemonItem(
                            pokemon = pokemon,
                            onItemClick = onPokemonClick // Passem el clic amunt
                        )
                    }
                }
            }
        }
    }
}