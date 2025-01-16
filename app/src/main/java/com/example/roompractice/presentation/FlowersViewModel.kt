package com.example.roompractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.interactor.Interactor
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlowersViewModel @Inject constructor(private val interactor: Interactor): ViewModel() {

    private val _flowersFlow: MutableSharedFlow<List<FlowerDto>> = MutableSharedFlow()

    val flowersFlow: SharedFlow<List<FlowerDto>>
        get () = _flowersFlow

    private val _bouquetsFlow: MutableSharedFlow<List<BouquetDto>> = MutableSharedFlow()

    val bouquetsFlow: SharedFlow<List<BouquetDto>>
        get () = _bouquetsFlow

    private val _availableBouquetsFlow: MutableSharedFlow<List<BouquetDto>> = MutableSharedFlow()

    val availableBouquetsFlow: SharedFlow<List<BouquetDto>>
        get () = _availableBouquetsFlow

    fun getFlowers(){
        viewModelScope.launch {
            _flowersFlow.emit(interactor.getFlowers())
        }
    }

    fun getBouquets(){
        viewModelScope.launch {
            _bouquetsFlow.emit( interactor.getBouquets())
        }
    }

    fun getAvailableBouquets(){
        viewModelScope.launch {
            _availableBouquetsFlow.emit(interactor.getAvailableBouquets())
        }
    }

    fun buyBouquets(name: String){
        viewModelScope.launch {
            interactor.buyBouquet(name)
        }
    }
}