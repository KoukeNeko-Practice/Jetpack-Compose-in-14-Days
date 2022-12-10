package dev.koukeneko.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.koukeneko.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()

                val color = MaterialTheme.colorScheme.background

                SideEffect {

                    systemUiController.setStatusBarColor(
                        color = color,
                        darkIcons = useDarkIcons
                    )

                    systemUiController.setNavigationBarColor(
                        color = color,
                        darkIcons = useDarkIcons
                    )

                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = color
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0
): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
//    val amountInput: MutableState<String> = mutableStateOf("0")
//    val amountInput = mutableStateOf("0")

    TextField(
        label = { Text(stringResource(id = R.string.cost_of_service)) },
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent, //hide the indicator
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}


@Composable
fun TipTimeScreen() {

    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = amountInput,
            onValueChange = { amountInput = it }
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            // Rest of the code
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipTimeTheme {
        TipTimeScreen()
    }
}