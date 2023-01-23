package com.luizcampos.downloadimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposablePreview()
        }
    }

    @Preview
    @Composable
    fun ComposablePreview() {
        Column {
            Text(text = "Migrate")
            Text(text = "to")
            Text(text = "Jetpack Compose")
        }
    }
}