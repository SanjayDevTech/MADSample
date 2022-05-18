package com.sample.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.mad.ui.theme.MADSampleTheme

class CalculatorActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MADSampleTheme {
                Calculator()
            }
        }
    }
}

@Preview
@Composable
fun CalculatorPreview() {
    MADSampleTheme {
        Calculator()
    }
}

@Composable
fun Calculator() {

    val numbers = listOf(
            listOf("7", "8", "9"),
            listOf("4", "5", "6"),
            listOf("1", "2", "3"),
            listOf(".", "0"),
    )
    val ops = listOf(
            "/", "*", "-", "+",
    )
    val brackets = listOf("(", ")")
    var eval by remember {
        mutableStateOf("")
    }
    fun onOpClick(value: String) {
        eval += value
    }
    Scaffold {
        Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
        ) {
            Text(text = eval)
            Row {
                ops.forEach {
                    KeyButton(value = it, onClick = ::onOpClick)
                }
            }
            Row {
                brackets.forEach {
                    KeyButton(value = it, onClick = ::onOpClick)
                }
                KeyButton(value = "<-") {
                    eval = eval.dropLast(1)
                }
                KeyButton(value = "=") {

                }
            }
            Column {
                numbers.forEach { keys ->
                    Row {
                        keys.forEach {
                            KeyButton(value = it, onClick = ::onOpClick)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun KeyButton(value: String, onClick: (String) -> Unit) {
    Button(
            onClick = { onClick(value) }) {
        Text(value)
    }
}
