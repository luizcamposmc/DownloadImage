package com.luizcampos.downloadimage.repository

interface Downloader {
    fun downloadFile(url: String): Long
}