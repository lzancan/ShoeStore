package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes: LiveData<List<Shoe>> = _listOfShoes

    fun addNewShoe(shoe: Shoe){
        val list = _listOfShoes.value?.toMutableList() ?: mutableListOf()
        list.add(shoe)
        _listOfShoes.value = list
    }
}