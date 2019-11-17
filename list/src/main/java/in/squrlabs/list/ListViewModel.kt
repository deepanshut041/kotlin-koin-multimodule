package `in`.squrlabs.list

import `in`.squrlabs.domain.model.MovieModel
import `in`.squrlabs.domain.repository.MovieRepository
import `in`.squrlabs.koltin_koin.util.SingleLiveEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListViewModel(private val movieRepository: MovieRepository): ViewModel() {
    //
    private val disposable = CompositeDisposable()

    val showLoading = MutableLiveData<Boolean>()
    val moviesList: Flowable<List<MovieModel>> = movieRepository.loadMovies()
    val showError = SingleLiveEvent<String>()

    fun sync() {

        disposable.add(movieRepository.sync()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { showError.value = "Sync Completed"},
                { showError.value = "Sync Failed" }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}