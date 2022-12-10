@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package dev.koukeneko.artspace

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.koukeneko.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {

                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()

                val color = MaterialTheme.colorScheme.background

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = color,
                        darkIcons = useDarkIcons
                    )
                    systemUiController.setNavigationBarColor(
                        color = color,
                        darkIcons = useDarkIcons
                    )
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContainer()
                }
            }
        }
    }
}

@Composable
fun ImageWithDetailsText(imageData: Array<String>) {
    val id = Integer.parseInt(imageData[0])
    val title = imageData[1]
    val description = imageData[2]

    Column(
        modifier = Modifier
           .fillMaxHeight(0.8f),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp)

        )
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Bottom)
                .padding(start = 64.dp, end = 64.dp, top = 32.dp, bottom = 32.dp),

        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)

            )
            Text(
                text = description,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)

            )
        }

    }
}

@Composable
fun ButtonGroup(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier.width(110.dp)
        )
        {
            Text(text = "Previous")
        }
        Button(
            onClick = onNext,
            modifier = Modifier.width(110.dp)
        )
        {
            Text(text = "Next")
        }
    }
}

@Composable
fun AppContainer() {

    val imageList = arrayOf(
        arrayOf(R.drawable._0220712_152401.toString(), "林永城", "description1"),
        arrayOf(R.drawable.dsc_0031.toString(), "不是麻糬", "description1"),
        arrayOf(R.drawable.dsc_0512.toString(), "識破貓", "description1"),
        arrayOf(R.drawable.dsc_0513.toString(), "林勇誠", "description1"),
        arrayOf(R.drawable.dsc_0515.toString(), "不是破貓", "description1"),
        arrayOf(R.drawable.img20190428172531.toString(), "絕對不是破貓", "description1"),
        arrayOf(R.drawable.pxl_20220403_015747105.toString(), "貓凹", "description1"),
        arrayOf(R.drawable.pxl_20220815_120932932.toString(), "BARBAR", "description1"),
        arrayOf(R.drawable.pxl_20220815_121000489.toString(), "都不來幫我", "description1"),
        arrayOf(R.drawable.pxl_20220902_115401219.toString(), "NULL", "description1"),
    )

    var indexNow by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(),

        ) {
        ImageWithDetailsText(imageList[indexNow])
        ButtonGroup(onPrevious = {
            indexNow--
            if (indexNow < 0)
                indexNow = imageList.lastIndex
        },
            onNext = {
                indexNow++
                if (indexNow > imageList.lastIndex)
                    indexNow = 0
            })
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        AppContainer()
    }
}