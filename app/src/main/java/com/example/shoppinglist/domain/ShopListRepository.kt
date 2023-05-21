package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

//делает все что требуется юзкейсам
interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList():  LiveData<List<ShopItem>>
}