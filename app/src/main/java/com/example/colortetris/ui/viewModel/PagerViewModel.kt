package com.example.colortetris.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

sealed class PagerAction {
    data class Scroll(val toPage: Int, val animated: Boolean) : PagerAction()
}

class PagerViewModel() : ViewModel() {
    private val _action = MutableSharedFlow<PagerAction>()
    var action = _action.asSharedFlow()

    fun scrollToPage(toPage: Int, animated: Boolean) {
        viewModelScope.launch(Dispatchers.Main) {
            _action.emit(PagerAction.Scroll(toPage, animated))
        }
    }
}