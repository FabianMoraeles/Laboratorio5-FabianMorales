package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio5.ui.theme.Laboratorio5Theme

// Datos del concierto
data class Concert(val title: String, val description: String, val imageRes: Int)

// Conciertos favoritos
val favoriteConcerts = listOf(
    Concert("Title 1", "Los Tigres del Norte 2023", R.drawable.ic_launcher_foreground),
    Concert("Title 2", "Myke Towers 2023", R.drawable.ic_launcher_foreground)
)

// Todos los conciertos
val allConcerts = listOf(
    Concert("Title 3", "Bad Bunny  2022", R.drawable.ic_launcher_foreground),
    Concert("Title 4", "Marc Anthony 2023", R.drawable.ic_launcher_foreground),
    Concert("Title 5", "Daddy Yankee 2022", R.drawable.ic_launcher_foreground)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ConcertScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color(0xFF4CAF50)) // Fondo verde
                    )
                }
            }
        }
    }
}

@Composable
fun ConcertScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        item {
            Text(
                text = "TodoEventos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        item {
            Text(
                text = "Your favorites",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        items(favoriteConcerts) { concert ->
            ConcertCard(concert)
        }
        item {
            Text(
                text = "All Concerts",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        items(allConcerts) { concert ->
            ConcertCard(concert)
        }
    }
}

@Composable
fun ConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(concert.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = concert.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = concert.description,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConcertScreenPreview() {
    Laboratorio5Theme {
        ConcertScreen(
            modifier = Modifier.background(Color(0xFF4CAF50))
        )
    }
}