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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    ) {
        ArtworkDisplay(modifier)

        ArtworkSummary(modifier)

        NavigationButtons(modifier)
    }
}

@Composable
private fun ArtworkDisplay(modifier: Modifier) {
    Box(
        modifier = modifier
            .shadow(elevation = 3.dp)
    ) {
        Image(
            painterResource(id = R.drawable.hornbills),
            contentDescription = null,
            modifier = modifier
                .padding(36.dp)
        )
    }
}

@Composable
private fun ArtworkSummary(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ) {
        Text(
            stringResource(id = R.string.hornbills_title),
            fontSize = 24.sp,
            modifier = modifier
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(top = 10.dp)
        ) {
            Text(
                stringResource(id = R.string.hornbills_artist),
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Text(
                stringResource(id = R.string.hornbills_year),
                modifier = modifier
            )
        }
    }
}

@Composable
private fun NavigationButtons(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = modifier
                .width(140.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Previous")
        }
        Button(
            modifier = modifier
                .width(140.dp),
            onClick = { /*TODO*/ }
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