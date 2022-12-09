package dev.koukeneko.createabusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.koukeneko.createabusinesscardapp.ui.theme.CreateABusinessCardAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateABusinessCardAppTheme {
                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color(0xFF073042),
                        darkIcons = false
                    )
                    systemUiController.setSystemBarsColor(
                        color = Color(0xFF073042),
                        darkIcons = false)

                    systemUiController.setNavigationBarColor(
                        color = Color(0xFF073042),
                        darkIcons = useDarkIcons
                    )
//                    // navigation bar
//                    systemUiController.isNavigationBarVisible = false
//
//                    // status bar
//                    systemUiController.isStatusBarVisible = false

                    // system bars
                    // systemUiController.isSystemBarsVisible = false
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF073042)),
                    color = Color(0xFF073042),


                ) {
                    val list = listOf<Contact>(
                        Contact(R.drawable.baseline_phone_24,"+00 (00) 000 000"),
                        Contact(R.drawable.baseline_share_24,"+00 (00) 000@socialmediahandle"),
                        Contact(R.drawable.baseline_email_24,"email@domain.com"),
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
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
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

class Contact internal constructor (
    private @DrawableRes val icon: Int,
    private val context: String) {

    fun getContactIcon(): Int {
        return icon
    }

    fun getContactContext(): String {
        return context
    }
}

@Composable
fun ContactDetailsList(list: List<Contact>?) {
Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
//            .wrapContentHeight(Alignment.Bottom)
    ) {
        list?.listIterator()?.forEach {
            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = it.getContactIcon(),
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp),
                    tint = Color(0xFF3ddc84)
                )
                Text(
                    text = it.getContactContext(),
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                )
            }
            if (list.indexOf(it) != list.lastIndex) {
                Spacer(modifier = Modifier.height(4.dp))
                Divider(color = Color(0x66FFFFFF))
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun Container(
    name: String,
    title: String,
    contacts: List<Contact>? = null
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

    val list = listOf<Contact>(
        Contact(R.drawable.baseline_phone_24,"+00 (00) 000 000"),
        Contact(R.drawable.baseline_phone_24,"@socialmediahandle"),
        Contact(R.drawable.baseline_phone_24,"email@domain.com"),
    )

    CreateABusinessCardAppTheme {
        Container("Jennifer Doe", "Android Developer Extraordinaire", list)
    }
}