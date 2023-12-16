package com.example.nearbyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.nearbyapp.data.remote.response.Place
import com.example.nearbyapp.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private var binding: ActivityMainBinding? = null

    private val placesAdapter = PlacesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        binding = mBinding

        mBinding.recyclerView.adapter = placesAdapter

        lifecycleScope.launchWhenStarted {
            viewModel
                .uiState
                .collectLatest { placesViewState: PlacesViewState ->
                    when(placesViewState) {
                        is PlacesViewState.Success -> {
                            setupViewState(placesViewState.places)
                        }
                        else -> {

                        }
                    }
                }
        }
    }

    private fun setupViewState(places: Array<Place>) {
        placesAdapter.setData(places)
    }

}