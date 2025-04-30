package com.example.petify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petify.ui.theme.PetifyTheme

data class LostPet(
    val id: Int,
    val name: String,
    val description: String,
    val lastSeenLocation: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LostPetsScreen()
                }
            }
        }
    }
}

@Composable
fun LostPetsScreen() {
    var lostPets by remember {
        mutableStateOf(
            listOf(
                LostPet(1, "Buddy", "Golden Retriever, very friendly", "Central Park"),
                LostPet(2, "Mittens", "Gray tabby cat, shy", "5th Avenue"),
                LostPet(3, "Charlie", "Small brown dog, wears a red collar", "Broadway")
            )
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Lost Pets",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(lostPets) { pet ->
                LostPetItem(pet)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun LostPetItem(pet: LostPet) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = pet.name, style = MaterialTheme.typography.titleMedium)
        Text(text = pet.description, style = MaterialTheme.typography.bodyMedium)
        Text(text = "Last seen at: ${pet.lastSeenLocation}", style = MaterialTheme.typography.bodySmall)
    }
}
