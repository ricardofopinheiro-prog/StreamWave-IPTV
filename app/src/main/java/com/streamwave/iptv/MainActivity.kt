package com.streamwave.iptv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF101318)
private val SurfaceDark = Color(0xFF1A2029)
private val Accent = Color(0xFF2684FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StreamWaveApp() }
    }
}

@Composable
private fun StreamWaveApp() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Accent,
            background = Background,
            surface = SurfaceDark,
            onBackground = Color.White,
            onSurface = Color.White
        )
    ) {
        Surface(modifier = Modifier.fillMaxSize(), color = Background) {
            HomeScreen()
        }
    }
}

@Composable
private fun HomeScreen() {
    val sections = listOf(
        Triple("TV em direto", "Os teus canais", Icons.Default.LiveTv),
        Triple("Filmes", "Biblioteca de filmes", Icons.Default.Movie),
        Triple("Séries", "Temporadas e episódios", Icons.Default.Tv),
        Triple("Favoritos", "Conteúdos guardados", Icons.Default.Favorite),
        Triple("Histórico", "Continua de onde ficaste", Icons.Default.History),
        Triple("Guia TV", "Programação e horários", Icons.Default.CalendarMonth),
        Triple("Definições", "Listas, aparência e segurança", Icons.Default.Settings)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.PlayCircle, contentDescription = null, tint = Accent, modifier = Modifier.size(38.dp))
                Spacer(Modifier.width(10.dp))
                Column {
                    Text("STREAMWAVE", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White, letterSpacing = 1.5.sp)
                    Text("O teu entretenimento", color = Color.LightGray, fontSize = 12.sp)
                }
            }
            Spacer(Modifier.height(28.dp))
            Text("Bem-vindo", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("Adiciona uma lista IPTV autorizada para começar.", color = Color.LightGray, fontSize = 14.sp)
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { /* Importação será implementada na etapa 3. */ },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Adicionar lista IPTV")
            }
            Spacer(Modifier.height(12.dp))
            Text("EXPLORAR", color = Color.Gray, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
        }
        items(sections) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(item.third, contentDescription = null, tint = Accent, modifier = Modifier.size(28.dp))
                    Spacer(Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(item.first, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        Text(item.second, color = Color.LightGray, fontSize = 12.sp)
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
                }
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
            Text("StreamWave IPTV · versão 0.1.0", color = Color.Gray, fontSize = 11.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}
