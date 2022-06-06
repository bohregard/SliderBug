package com.bohregard.slidertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bohregard.slidertest.ui.theme.SliderTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var manualDuration by remember { mutableStateOf(7500f) }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.size(12.dp))
                        Slider(
                            // If a size is specified, the issue is not present
                            modifier = Modifier.weight(3f),
                            value = manualDuration,
                            valueRange = 0f..15000f,
                            onValueChange = {
                                manualDuration = it
                            },
                            onValueChangeFinished = {
                                println("Value Changed Finished")
                            },
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(
                            // Commenting this line out makes the slider emit prematurely
                            // Uncommenting will fix the issue.
//                            modifier = Modifier.weight(1f),
                            text = String.format("%05.0f", manualDuration)
                        )
                    }
                }
            }
        }
    }
}