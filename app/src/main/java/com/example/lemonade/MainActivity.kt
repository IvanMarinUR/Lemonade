package com.example.lemonade

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    // A surface container using the 'background' color from the theme

    var currentStep by remember { mutableStateOf(1) }
    var lemonsqueezes = 0

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentStep) {
            1 -> {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        stringResource(R.string.tree_desc),
                        modifier = Modifier.border(width = 2.dp,color = Color(105,205,216,255),shape = RoundedCornerShape(4.dp)).clickable {
                            currentStep=2
                            lemonsqueezes = (2..4).random()
                        }
                    )
                    Text(stringResource(R.string.tree_label), modifier=Modifier.padding(top = 16.dp), fontSize = 18.sp )
                }
            }
            2 -> {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        stringResource(R.string.lemon_desc),
                        modifier = Modifier.border(width = 2.dp,color = Color(105,205,216,255),shape = RoundedCornerShape(4.dp)).clickable {
                            lemonsqueezes--
                            if(lemonsqueezes==0)
                                currentStep=3
                        }
                    )
                    Text(stringResource(R.string.lemon_label), modifier=Modifier.padding(top = 16.dp), fontSize = 18.sp)
                }
            }
            3 -> {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        stringResource(R.string.lemonade_desc),
                        modifier = Modifier.border(width = 2.dp,color = Color(105,205,216,255),shape = RoundedCornerShape(4.dp)).clickable { currentStep=4 }
                    )
                    Text(stringResource(R.string.lemonade_label), modifier=Modifier.padding(top = 16.dp), fontSize = 18.sp)
                }
            }
            4 -> {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        stringResource(R.string.glass_desc),
                        modifier = Modifier.border(width = 2.dp,color = Color(105,205,216,255),shape = RoundedCornerShape(4.dp)).clickable { currentStep=1 }
                    )
                    Text(stringResource(R.string.glass_label), modifier=Modifier.padding(top = 16.dp), fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
