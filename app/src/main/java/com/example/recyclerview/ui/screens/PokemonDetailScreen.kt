package com.example.recyclerview.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recyclerview.data.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(pokemon.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Enrere")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imatge Gran
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
                    .padding(20.dp),
                tint = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = pokemon.name, style = MaterialTheme.typography.displayMedium)

            Spacer(modifier = Modifier.height(8.dp))

            AssistChip(
                onClick = { },
                label = { Text(pokemon.type) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Aquí aniria la descripció detallada de ${pokemon.name}. " +
                        "Pots afegir més camps a la classe de dades si vols.",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tornar a la llista")
            }
        }
    }
}