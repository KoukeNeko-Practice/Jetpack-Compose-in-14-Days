package dev.koukeneko.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.koukeneko.compose.ui.theme.Compose文章Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose文章Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.Title),
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                   .padding(16.dp)

            )
            Text(
                text = stringResource(R.string.Section1),
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = stringResource(R.string.Section2),
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Card()
}