package ru.nsu.fit.nsuvolleyball.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.nsu.fit.nsuvolleyball.data.api.ApiUtils
import ru.nsu.fit.nsuvolleyball.data.network.Resource

class GalleryViewModel : ViewModel() {
    private val mutableLiveData = MutableLiveData<Resource<List<GalleryView>>>()
    val liveData: LiveData<Resource<List<GalleryView>>> get() = mutableLiveData

    var disposable: Disposable? = null

    init {
        disposable = ApiUtils.nsuVolleyballApi
            .getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    mutableLiveData.value = Resource.Success(response.albums
                        .map {
                            GalleryMapper().toGalleryView(it)
                        })
                },
                { throwable ->
                    mutableLiveData.value = Resource.Error(throwable.message ?: "Error")
                })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}