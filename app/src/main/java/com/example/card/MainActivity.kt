package com.example.card

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection.Companion.Content

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateCard()
                }
            }
        }
    }
}

@Composable
fun CreateCard(){
    // this remembers the state of the button
    val buttonClikedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(CornerSize(15.dp)),
//            elevation = 10.dp,
        ){
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxHeight(),

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                CreateImgProfile()
                Divider(
                    thickness = 3.dp,
                    color = Color.DarkGray,
                    modifier = Modifier.border(1.dp, color = Color.LightGray)
                )
                TextBox()
                Button(
                    onClick = {
//                              Log.d("Clicked", "Card : Clicked")
                        // toggle between the values
                              buttonClikedState.value = !buttonClikedState.value

                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Portofolio")
                }
                if(buttonClikedState.value){
                    Content()
                }else{
                    Box{}
                }

            }
        }


    }

}

@Composable
private fun CreateImgProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(180.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.DarkGray),

        ) {
        Image(
            painter = painterResource(id = R.drawable.poza),
            contentDescription = "Profile picture",

            )
    }
}

@Composable
fun TextBox(){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Dornea Sergiu",
            color = Color.Blue,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Android Compose Programmer",
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 8.dp),
        )
        Text(
            text = "dorneasergiu@gmail.com",
            fontSize = 15.sp,

        )

    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    CardTheme {
        CreateCard()
    }
}


@Composable
fun Content(){
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(3.dp),
            border = BorderStroke(5.dp, color = Color.DarkGray),
            shape = RoundedCornerShape(8.dp)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4"))
        }
    }
}


@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->
            ListItem(text = item)

        }
    }
}


@Composable
fun ListItem(text : String){
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RectangleShape
    ){
        Row(){
            Surface(
                shape = CircleShape,
                modifier = Modifier.padding(3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poza),
                    contentDescription ="Profile picture",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                    )
            }

            Column (modifier = Modifier.align(alignment = Alignment.CenterVertically)){
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 4.dp)
                )
                Text(
                    text = "A great project indeed",
                )
            }
        }

    }
}

@Preview
@Composable
fun ListItemPreview(){
    ListItem(text = "Paragraf 1")
}

