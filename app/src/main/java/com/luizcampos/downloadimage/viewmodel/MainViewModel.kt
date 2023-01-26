package com.luizcampos.downloadimage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luizcampos.downloadimage.helper.Constants
import com.luizcampos.downloadimage.repository.DownloaderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val downloaderRepository: DownloaderRepository
) : ViewModel() {

    private val _grantedAllPermissions = MutableLiveData<Boolean>()
    val grantedAllPermissions: LiveData<Boolean> = _grantedAllPermissions

    fun downloadImage(url: String = Constants.IMAGE_URL) {
        downloaderRepository.downloadFile(url)
    }

    fun setGrantedAllPermission (grantedAllPermissions: Boolean) {
        _grantedAllPermissions.value = grantedAllPermissions
    }

    fun checkPermissions() : MainViewModel {
        // TODO implements
        return this
    }
}