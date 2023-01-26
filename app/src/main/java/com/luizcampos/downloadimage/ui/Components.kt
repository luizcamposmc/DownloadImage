package com.luizcampos.downloadimage.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.luizcampos.downloadimage.R
import com.luizcampos.downloadimage.helper.ext.toastShort
import com.luizcampos.downloadimage.ui.button.FabType
import com.luizcampos.downloadimage.ui.button.FloatingActionButtonCustom
import com.luizcampos.downloadimage.viewmodel.MainViewModel

@Preview
@Composable
fun HomePage() {
    val context = LocalContext.current

    val viewModel: MainViewModel = hiltViewModel()

    val enableFAB by viewModel.grantedAllPermissions.observeAsState(initial = false)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                    title = {
                        Text(
                            text = context.resources.getString(R.string.home_app_bar_title),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
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
                        context.toastShort("Floating Action Button")
                        viewModel
                            .checkPermissions()
                            .downloadImage()
                    },
                    enable = enableFAB
                ).fabType(FabType.FAB)
                    .fabText("Fab Desc")
                    .build()
            }
        } // Scaffold
    } // Surface
}
