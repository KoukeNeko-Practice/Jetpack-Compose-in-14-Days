package dev.koukeneko.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.koukeneko.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {

                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()
                val color = Color(0xFF073042)
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = color,
                        darkIcons = false
                    )
//                    systemUiController.setSystemBarsColor(
//                        color = Color(0xFF073042),
//                        darkIcons = false)

                    systemUiController.setNavigationBarColor(
                        color = color,
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
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = color
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier
) {
    var result by remember {
        mutableStateOf(0)
    }
    val imageResource = when (result) {
        0 -> R.drawable.dice_1
        1 -> R.drawable.dice_2
        2 -> R.drawable.dice_3
        3 -> R.drawable.dice_4
        4 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = "1")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = (1..6).random()

        }) {
            Text(text = stringResource(id = R.string.roll))
        }
    }
}