package com.luizcampos.downloadimage.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.luizcampos.downloadimage.R
import com.luizcampos.downloadimage.ui.button.FabType
import com.luizcampos.downloadimage.ui.button.FloatingActionButtonCustom

@Preview
@Composable
fun HomePage() {
    val context = LocalContext.current

    Surface(
        // on below line we are specifying modifier and color for our app
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            // in scaffold we are specifying the top bar.
            topBar = {
                // inside top bar we are specifying background color.
                TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                    // along with that we are specifying title for our top bar.
                    title = {
                        // in the top bar we are specifying tile as a text
                        Text(
                            // on below line we are specifying
                            // text to display in top app bar.
                            text = context.resources.getString(R.string.home_app_bar_title),
                            // on below line we are specifying
                            // modifier to fill max width.
                            modifier = Modifier.fillMaxWidth(),
                            // on below line we are specifying
                            // text alignment.
                            textAlign = TextAlign.Center,
                            // on below line we are specifying
                            // color for our text.
                            color = MaterialTheme.colors.onPrimary
                        ) // Text
                    } // title
                ) // TopAppBar
            } // topBar
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                FloatingActionButtonCustom(
                    onClick = {
                        Toast.makeText(context, "Floating Action Button", Toast.LENGTH_SHORT).show()
                    }
                ).fabType(FabType.FAB)
                    .fabText("Fab Desc")
                    .build()
            }
        } // Scaffold
    } // Surface
}
