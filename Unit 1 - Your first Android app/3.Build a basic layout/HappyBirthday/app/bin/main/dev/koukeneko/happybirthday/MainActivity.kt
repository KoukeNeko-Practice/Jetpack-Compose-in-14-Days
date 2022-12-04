package dev.koukeneko.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.koukeneko.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage( getString(R.string.happy_birthday_text), getString(R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String = "Happy Birthday") {
    Column{
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally),
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally),
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage( "Happy Birthday Sam!", "- from Emma")
    }
}