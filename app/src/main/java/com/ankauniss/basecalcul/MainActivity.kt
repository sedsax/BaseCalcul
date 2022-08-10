package com.ankauniss.basecalcul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ankauniss.basecalcul.ui.theme.BaseCalculTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseCalculTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.onSecondary
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column() {
        var workingScreen = remember { mutableStateOf("0")}
        var canAddOperation = false
        var canAddDecimal = true
        var length = workingScreen.value.length

        Spacer(modifier = Modifier.height(450.dp))
    //    Spacer(modifier = Modifier.width(70.dp))
        Row() {
            Spacer(modifier = Modifier.width(70.dp))
            TextField(
                value = workingScreen.value,
                onValueChange = {workingScreen.value = it},
                shape = RectangleShape,
                //modifier = Modifier.fillMaxSize().padding(70.dp),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color(0xFFFFFFFF)
                )
            )
        }

        Row() {
            Spacer(modifier = Modifier.width(70.dp))
            Column() {
                Button(onClick = {
                    workingScreen.value = ""
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) { Text(text = "AC",color = Color.Red)}

                Button(onClick = {
                    workingScreen.value = workingScreen.value + "7"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "7", color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "4"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "4", color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "1"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "1", color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty())
                    workingScreen.value = workingScreen.value + "."
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = ".", color = Color.White, fontWeight = FontWeight.ExtraBold)}
            }
            Column() {
                Button(onClick = {
                   // val length = workingScreen.value.length
                    if(workingScreen.value.isNotEmpty()) {
                        if(length > 0) {
                            workingScreen.value = workingScreen.value.subSequence(0,length-1).toString()
                        }
                    }

                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "geri",color = Color.Red)}

                Button(onClick = {
                    workingScreen.value = workingScreen.value + "8"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "8",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "5"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "5",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "2"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "2",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "0"
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {Text(text = "0",color = Color.White, fontWeight = FontWeight.ExtraBold)}
            }
            Column() {
                Button(onClick = { },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = " ")}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "9"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "9",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "6"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "6",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = {
                    workingScreen.value = workingScreen.value + "3"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "3",color = Color.White, fontWeight = FontWeight.ExtraBold)}
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = " ")}
            }
            Column() {
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty() && (workingScreen.value.substring(workingScreen.value.length)!= "+" ||workingScreen.value.substring(workingScreen.value.length) != "-" || workingScreen.value.substring(workingScreen.value.length) != "x"|| workingScreen.value.substring(workingScreen.value.length) != "/"))
                    workingScreen.value = workingScreen.value + "/"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "/",color = Color.Red)}
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty())
                    workingScreen.value = workingScreen.value + "x"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "x",color = Color.Red)}
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty())
                    workingScreen.value = workingScreen.value + "-"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "-",color = Color.Red)}
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty())
                    workingScreen.value = workingScreen.value + "+"
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {Text(text = "+",color = Color.Red
                )}
                Button(onClick = {
                    if(workingScreen.value.isNotEmpty()) {}
                    //TextField ekranını temizle ve sonucu göster
                    //workingScreen.value = ""
                    //workingScreen.value = result
                    // workingScreen.value = workingScreen.value + "="
                },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {Text(text = "=")}
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Scaffold() {
        BaseCalculTheme {
            MainScreen()
        }
    }

}