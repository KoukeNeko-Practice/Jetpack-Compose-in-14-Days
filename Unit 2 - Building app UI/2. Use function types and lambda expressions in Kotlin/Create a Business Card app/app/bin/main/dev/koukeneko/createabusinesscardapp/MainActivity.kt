package dev.koukeneko.createabusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.koukeneko.createabusinesscardapp.ui.theme.CreateABusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateABusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF073042)),
                    color = Color(0xFF073042),


                ) {
                    val list = listOf<String>(
                        "+00 (00) 000 000",
                        "@socialmediahandle",
                        "email@domain.com",
                    )
                    Container("Jennifer Doe", "Android Developer Extraordinaire", list)
                }
            }
        }
    }
}

@Composable
fun LogoWithName(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
//            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
        Text(text = name,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light
        )
        Text(text = title,
            color = Color(0xFF3ddc84),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactDetailsList(list: List<String>?) {
Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
//            .wrapContentHeight(Alignment.Bottom)
    ) {
        list?.listIterator()?.forEach {
            Row {
                Icon(painter = , contentDescription = null)
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 14.sp,
                )
            }
            if (list.indexOf(it) != list.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun Container(
        name: String,
        title: String,
        contacts: List<String>? = null
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LogoWithName(name, title)
        ContactDetailsList(contacts)
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {

    val list = listOf<String>(
        "+00 (00) 000 000",
        "@socialmediahandle",
        "email@domain.com",
    )

    CreateABusinessCardAppTheme {
        Container("Jennifer Doe", "Android Developer Extraordinaire", list)
    }
}