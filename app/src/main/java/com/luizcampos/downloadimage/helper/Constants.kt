package com.luizcampos.downloadimage.helper

import android.Manifest

object Constants {
    const val IMAGE_URL = "https://miro.medium.com/max/594/1*6tHWmspyG-13IWjPk6BbjA.png"

    val PERMISSIONS = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
}