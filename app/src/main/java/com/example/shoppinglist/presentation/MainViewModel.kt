package com.example.shoppinglist.presentation

import android.util.Log
import androidx.fragment.app.FragmentOnAttachListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel
 : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList =  getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem){
        deleteShopItemUseCase.deleteShopItem(item)
    }

    fun editShopItem(item: ShopItem){
        val newItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}