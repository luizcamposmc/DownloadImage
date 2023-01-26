package com.luizcampos.downloadimage.repository

interface DownloaderRepository {
    fun downloadFile(url: String): Long
}