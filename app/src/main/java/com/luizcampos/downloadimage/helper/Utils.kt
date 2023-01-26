package com.luizcampos.downloadimage.helper

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import com.luizcampos.downloadimage.helper.ext.toastShort
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

object Utils {

    fun openImage(context: Context) {
//        val downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
//        val file = File(downloadsDirectory, "image.jpg")
//        val imageUri = FileProvider.getUriForFile(
//            context,
//            context.applicationContext.packageName + ".provider",
//            file
//        )

        val imageUri = getUriImage(
            getBitmapFromFile(),
            context
        )

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(imageUri, "image/*")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        try {
            val chooserIntent = Intent.createChooser(intent, "Open Image")
            chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.applicationContext.startActivity(chooserIntent)
        } catch (_: ActivityNotFoundException) {
            context.toastShort("No applications found to open jpeg")
        }
    }

    fun shareImage(image: Bitmap, context: Context) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/jpeg"
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        val bmpUri = getUriImage(image, context)

        intent.putExtra(Intent.EXTRA_STREAM, bmpUri)
        intent.putExtra(Intent.EXTRA_SUBJECT, "New App")
        intent.putExtra(Intent.EXTRA_TEXT, "Title to share")

        try {
            context.startActivity(
                Intent.createChooser(intent, "Open Image")
            )
        } catch (_: ActivityNotFoundException) {
            context.toastShort("No applications found to open jpeg")
        }
    }

    private fun getUriImage(image: Bitmap, context: Context) : Uri? {
        val imagesFolder = File(context.cacheDir, "images")
        var uri: Uri? = null

        try {
            imagesFolder.mkdirs()
            val file = File(imagesFolder, "images.jpg")

            val stream = FileOutputStream(file)
            image.compress(Bitmap.CompressFormat.JPEG, 90, stream)
            stream.flush()
            stream.close()

            uri = FileProvider.getUriForFile(
                context,
                context.applicationContext.packageName + ".provider",
                file
            )
        } catch (_: IOException) {}

        return uri
    }

    private fun getBitmapFromFile(): Bitmap {
        val downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(downloadsDirectory, "image.jpg")

//        val options = BitmapFactory.Options()
//        options.inSampleSize = 2
//        val bitmap = BitmapFactory.decodeFile(file.absolutePath, options)

        val fileInputStream = FileInputStream(file.absolutePath)

        val fileDescriptor = fileInputStream.fd
        val bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)

        return bitmap
    }
}