package com.giancarlosfigueroa.searchmeli.feature_search.presentation.screen.results


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giancarlosfigueroa.searchmeli.feature_search.domain.model.Product
import com.giancarlosfigueroa.searchmeli.feature_search.domain.use_case.ProductUseCases
import com.giancarlosfigueroa.searchmeli.feature_search.presentation.screen.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val productUseCase:ProductUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _resultsItems = mutableStateListOf<Product>()
    val resultsItems: MutableList<Product> = _resultsItems
    init {
        savedStateHandle.get<String>("q")?.let { q ->
            if(q != "") {
                viewModelScope.launch {
                    _resultsItems.addAll(productUseCase.searchProducts(q.trim()))
                }
            }
        }
    }
}