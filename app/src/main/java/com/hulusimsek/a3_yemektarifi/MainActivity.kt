package com.hulusimsek.a3_yemektarifi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.hulusimsek.a3_yemektarifi.ui.theme._3_YemekTarifiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _3_YemekTarifiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Sayfa(

                    )
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Yemek Tarifi") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk),
                    titleContentColor = colorResource(id = R.color.black)
                )
            )
        },
        content = { innerPadding -> // Scaffold içeriği için padding değerini al
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Resim ile üst padding vermek için innerPadding'ı kullanabilirsiniz
                Image(
                    painter = painterResource(id = R.drawable.yemek),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = innerPadding.calculateTopPadding()) // Üst padding olarak kullan
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.anaRenk)
                        ),
                        modifier = Modifier
                            .weight(1f) // Buton genişliğini eşit olarak ayarla
                    ) {
                        Text(text = "Beğen")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.anaRenkKoyu)
                        ),
                        modifier = Modifier
                            .weight(1f) // Buton genişliğini eşit olarak ayarla
                            .padding(horizontal = 4.dp) // Butonlar arasında boşluk bırak
                    ) {
                        Text(text = "Yorum Yap")
                    }
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)) {
                    Text(text ="Köfte", color = colorResource(id = R.color.alternatifRenk), fontSize = 18.sp)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text ="Izgaraya Uygun")
                        Text(text ="7 Haziran")

                    }
                }
                
                Text(
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,

                    text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydonozları ince ince kıyın. İsterseniz, bir diş sarımsak da ekleyebilirsiniz.")
            }
        }

    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3_YemekTarifiTheme {
        Sayfa()
    }
}