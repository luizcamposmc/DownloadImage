package com.luizcampos.downloadimage.helper.ext

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.luizcampos.downloadimage.helper.Constants

fun Context.toastShort(message: String) {
    toToast(this, message, Toast.LENGTH_SHORT)
}

fun Context.toastLong(message: String) {
    toToast(this, message, Toast.LENGTH_LONG)
}

private fun toToast(context: Context, message: String, duration: Int) {
    Toast.makeText(context, message, duration).show()
}

fun Context.hasGrantedAllPermissions(): Boolean = Constants.PERMISSIONS.all {
    ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
}