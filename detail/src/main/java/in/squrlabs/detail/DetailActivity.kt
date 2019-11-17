package `in`.squrlabs.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private val loadFeatures by lazy { loadKoinModules(detailModule) }
    private fun injectFeatures() = loadFeatures

    // Instantiate viewModel with Koin
    private val viewModel by viewModel<DetailViewModel>()
    private val disposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        injectFeatures()
    }

    override fun onStart() {
        super.onStart()
        val id:Int = intent.getIntExtra("MOVIEID", 0)

        disposable.add( viewModel.getMovie(id.toLong())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movie ->
                    detailProgress.visibility = View.GONE
                    fiThumbnail.setImageURI("https://image.tmdb.org/t/p/w200${movie.posterPath}")
                    txName.text = movie.title
                    txOverview.text = movie.overview
                    txRatings.text = movie.voteAverage
                    txVotes.text = movie.voteCount.toString()
                    txRelease.text = movie.releaseDate

                },
                { Log.e("Adapter", "Failed to get items")}
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(detailModule)
    }
}