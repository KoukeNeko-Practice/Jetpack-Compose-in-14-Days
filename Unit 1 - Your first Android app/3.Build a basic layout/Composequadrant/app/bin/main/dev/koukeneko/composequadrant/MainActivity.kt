package dev.koukeneko.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.koukeneko.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun Card(title: String, content: String, color: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(R.string.Text_composable),
                content = stringResource(R.string.Content1),
                color = androidx.compose.ui.graphics.Color.Green,
                modifier = Modifier.weight(1f))
            Card(
                title = stringResource(R.string.Image_composable),
                content = stringResource(R.string.content2),
                color = androidx.compose.ui.graphics.Color.Yellow,
                modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(R.string.Row_composable),
                content = stringResource(R.string.content3),
                color = androidx.compose.ui.graphics.Color.Cyan,
                modifier = Modifier.weight(1f))
            Card(
                title = stringResource(R.string.Column_composable),
                content = stringResource(R.string.content4),
                color = androidx.compose.ui.graphics.Color.LightGray,
                modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}