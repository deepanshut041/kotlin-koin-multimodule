package `in`.squrlabs.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class ListActivity : AppCompatActivity() {

    private val loadFeatures by lazy { loadKoinModules(listModule) }
    private fun injectFeatures() = loadFeatures

    // Instantiate viewModel with Koin
    private val viewModel by viewModel<ListViewModel>()
    private lateinit var movieAdapter: MovieAdapter
    private val disposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        injectFeatures()
        movieAdapter = MovieAdapter()
        rvMovies.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = movieAdapter
        }

        initViewModel()
    }

    override fun onStart() {
        super.onStart()

        disposable.add( viewModel.moviesList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { newMovies -> movieAdapter.updateData(newMovies!!)},
                { Log.e("Adapter", "Failed to get items")}
            )
        )
    }

    private fun initViewModel() {
        viewModel.showLoading.observe(this, Observer { showLoading ->
            pbProgress.visibility = if (showLoading!!) View.VISIBLE else View.GONE
        })

        viewModel.showError.observe(this, Observer { showError ->
            Toast.makeText(this, showError, Toast.LENGTH_SHORT).show()
        })

        movieAdapter.movieId.observe(this, Observer {
            val intent = Intent().setClassName( this, "in.squrlabs.detail.DetailActivity")
            intent.putExtra("MOVIEID", it)
            startActivity(intent)
        })

        viewModel.sync()
    }

    override fun onDestroy() {
        unloadKoinModules(listModule)
        super.onDestroy()
    }
}