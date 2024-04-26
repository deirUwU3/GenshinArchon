package com.example.character

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.character.god.data
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.character.model.Charac
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.character.ui.theme.CharacterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterTheme {
                genshin()
            }
        }
    }

    @Composable
    fun genshin() { // connected to the start of the game the name of the App  
        impact(
            charlist = data().a()
        )
    }




    @Composable
    fun  charCard(charac: Charac, modifier: Modifier = Modifier) {
        Card(modifier = modifier) {
            Column {
                Image(
                    painter = painterResource(charac.imageResourceId), // R.drawable.NameofCharacter in data()
                    contentDescription = stringResource(charac.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth() // width image
                        .height(300.dp), // height image
                    contentScale = ContentScale.FillBounds //modifier
                )
                Text(
                    text = LocalContext.current.getString(charac.stringResourceId), // R.String.NumofCharacter in data()
                    modifier = Modifier.padding(7.dp), // padding 
                    style = MaterialTheme.typography.headlineMedium // font
                )
            }
        }
    }
        @Composable
        fun impact(charlist: List<Charac>, modifier: Modifier = Modifier) {
            LazyColumn(modifier = modifier) {
                items(charlist) { charac ->
                    charCard(
                        charac = charac,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

    }







