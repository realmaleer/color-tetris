package com.example.colortetris.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PagerViewModel : ViewModel() {
    private val _currentPage = MutableStateFlow(1)
    var currentPage = _currentPage.asStateFlow()

    fun updateCurrentPage(toPage: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            _currentPage.emit(toPage)
        }
    }
}