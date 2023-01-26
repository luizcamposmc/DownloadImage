package com.luizcampos.downloadimage.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.luizcampos.downloadimage.helper.Constants
import com.luizcampos.downloadimage.helper.ext.hasGrantedAllPermissions
import com.luizcampos.downloadimage.ui.HomePage
import com.luizcampos.downloadimage.ui.theme.DownloadImageTheme
import com.luizcampos.downloadimage.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            viewModel.setGrantedAllPermission(permissions.entries.all {it.value})
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.setGrantedAllPermission(hasGrantedAllPermissions())

            if (!(viewModel.grantedAllPermissions.value as Boolean)) {
                requestPermissionLauncher.launch(Constants.PERMISSIONS)
            }
        }

        setContent {
            DownloadImageTheme {
                HomePage()
            } // DownloadImageTheme
        } // setContent
    }
}