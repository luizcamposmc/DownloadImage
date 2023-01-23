package com.luizcampos.downloadimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luizcampos.downloadimage.ui.HomePage
import com.luizcampos.downloadimage.ui.theme.DownloadImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DownloadImageTheme {
                HomePage()
            } // DownloadImageTheme
        } // setContent
    }
}