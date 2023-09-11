package cl.jpvs.mod6ej02.data

import androidx.lifecycle.LiveData
import cl.jpvs.mod6ej02.data.local.Item
import cl.jpvs.mod6ej02.data.local.ItemDao


class Repository (private val itemDao: ItemDao) {
    suspend fun insertItem(item : Item) {
        itemDao.insertItem(item)
    }

    fun getItem() :
            LiveData<List<Item>> {
            return  itemDao.getAllitems()

    }
    suspend fun deleteDatos() {
        itemDao.deleteDatos()
    }

}