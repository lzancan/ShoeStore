package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes: LiveData<List<Shoe>> = _listOfShoes

    var shoeName = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var shoeCompany = MutableLiveData<String>()
    var shoeDetails = MutableLiveData<String>()

    val shoeAdded = MutableLiveData<Unit>()

    fun addNewShoe(){
        val shoe = Shoe(
            shoeName.value.orEmpty(),
            shoeSize.value.orEmpty().toDoubleOrNull() ?: 0.0,
            shoeCompany.value.orEmpty(),
            shoeDetails.value.orEmpty()
        )
        val list = _listOfShoes.value?.toMutableList() ?: mutableListOf()
        list.add(shoe)
        _listOfShoes.value = list
        shoeAdded.value = Unit
    }
}