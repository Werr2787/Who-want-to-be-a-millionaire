package com.whatrushka.whowhantbeamillionare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.whatrushka.whowhantbeamillionare.core.view_model.QuestionsViewModel
import com.whatrushka.whowhantbeamillionare.ui.theme.WhoWhantBeAMillionareTeam1Theme
import com.whatrushka.whowhantbeamillionare.views.navigation.Navigation
import com.whatrushka.whowhantbeamillionare.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhoWhantBeAMillionareTeam1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Image(
                        painter = painterResource(R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Navigation(
                        viewModel = QuestionsViewModel(applicationContext),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
