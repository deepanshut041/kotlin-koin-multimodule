package `in`.squrlabs.detail

import `in`.squrlabs.domain.model.MovieModel
import `in`.squrlabs.domain.repository.MovieRepository
import `in`.squrlabs.koltin_koin.util.SingleLiveEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    private val disposable = CompositeDisposable()

    val showLoading = MutableLiveData<Boolean>()
    val showError = SingleLiveEvent<String>()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getMovie(id: Long): Maybe<MovieModel> {
        return movieRepository.getMovie(id)
    }
}