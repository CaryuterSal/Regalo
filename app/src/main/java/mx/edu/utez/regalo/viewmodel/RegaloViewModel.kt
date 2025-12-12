package mx.edu.utez.regalo.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegaloViewModel: ViewModel() {

    private val _isEnvuelto = MutableStateFlow(true)
    val isEnvuelto = _isEnvuelto.asStateFlow()

    fun abrirCaja(){
        _isEnvuelto.value = false
    }

    fun envolverCaja(){
        _isEnvuelto.value = true
    }


}