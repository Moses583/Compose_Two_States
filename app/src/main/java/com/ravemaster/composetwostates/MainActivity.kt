 package com.ravemaster.composetwostates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ravemaster.composetwostates.ui.theme.ComposeTwoStatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTwoStatesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var textState by remember {
                        mutableStateOf("")
                    }

                    MyTextField2(textValue =textState,
                        onValueChanged = { textState = it },
                        modifier = Modifier.padding(innerPadding),
                        onAddClick = {

                        })
                }
            }
        }
    }
}

 @Composable
 fun MyTextField(modifier: Modifier = Modifier) {
     Box(modifier = modifier
         .fillMaxSize()
         .background(MaterialTheme.colorScheme.surface),
     ){
         //State controlled by composable:Stateful

         var textState by remember {
             mutableStateOf("")
         }

         TextField(value = textState,
             onValueChange = {
                 textState = it
             },
             modifier = modifier
                 .fillMaxWidth()
                 .align(Alignment.BottomCenter)

         )
     }
 }
 @Composable
 fun MyTextField2(modifier: Modifier = Modifier, textValue: String, onValueChanged: (String) -> Unit, onAddClick: () -> Unit) {
     //State controlled from outside: Stateless
     Box(modifier = modifier
         .fillMaxSize()
         .background(MaterialTheme.colorScheme.surface),
     ){

         TextField(value = textValue,
             onValueChange = {
                 onValueChanged(it)
             },
             modifier = modifier
                 .fillMaxWidth()
                 .align(Alignment.BottomCenter),
             trailingIcon = {
                 Icon(imageVector = Icons.Default.Add, contentDescription = null)
             }

         )
     }
 }

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeTwoStatesTheme {
//        Greeting(textState)
    }
}