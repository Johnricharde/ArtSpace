package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpace( modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val artworkState = remember { mutableIntStateOf(1) }
        val artwork by artworkState

        val image = when (artwork) {
            1 -> R.drawable.hornbills
            2 -> R.drawable.womanofthehaslital
            else -> R.drawable.bouquetofflowers
        }
        val title = when (artwork) {
            1 -> R.string.hornbills_title
            2 -> R.string.woman_of_the_haslital_title
            else -> R.string.bouquet_of_flowers_title
        }
        val year = when (artwork) {
            1 -> R.string.hornbills_year
            2 -> R.string.woman_of_the_haslital_year
            else -> R.string.bouquet_of_flowers_year
        }
        val artist = when (artwork) {
            1 -> R.string.hornbills_artist
            2 -> R.string.woman_of_the_haslital_artist
            else -> R.string.bouquet_of_flowers_artist
        }

        ArtworkDisplay(image, Modifier.fillMaxHeight(0.5f))

        ArtworkSummary(title, year, artist, Modifier.fillMaxHeight(1f))

        NavigationButtons(artworkState, modifier.fillMaxHeight(1f))
    }
}

@Composable
private fun ArtworkDisplay(image: Int, modifier: Modifier) {
    Box(
        modifier = modifier
            .shadow(elevation = 3.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .padding(36.dp)
                .height(500.dp)
        )
    }
}

@Composable
private fun ArtworkSummary(title: Int, year: Int, artist: Int, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = stringResource(id = title),
            fontSize = 24.sp,
            modifier = modifier
        )
        Text(
            text = stringResource(id = year),
            modifier = modifier
        )
        Text(
            text = stringResource(id = artist),
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }
}

@Composable
private fun NavigationButtons(artworkState: MutableState<Int>, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = modifier
                .width(140.dp),
            onClick = {
                if (artworkState.value > 1) {
                    artworkState.value--
                } else {
                    artworkState.value = 3
                }
            }
        ) {
            Text(text = "Previous")
        }
        Button(
            modifier = modifier
                .width(140.dp),
            onClick = {
                if (artworkState.value < 3) {
                    artworkState.value++
                } else {
                    artworkState.value = 1
                }
            }
        ) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}