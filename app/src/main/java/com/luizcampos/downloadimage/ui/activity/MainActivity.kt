package com.luizcampos.downloadimage.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.luizcampos.downloadimage.helper.Constants
import com.luizcampos.downloadimage.helper.ext.hasGrantedAllPermissions
import com.luizcampos.downloadimage.ui.HomePage
import com.luizcampos.downloadimage.ui.theme.DownloadImageTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var grantedAllPermissions: Boolean = false

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            grantedAllPermissions = permissions.entries.all {it.value}
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            grantedAllPermissions = hasGrantedAllPermissions()

            if (!grantedAllPermissions) {
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