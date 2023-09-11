package cl.jpvs.mod6ej02.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.jpvs.mod6ej02.data.Repository
import cl.jpvs.mod6ej02.data.local.Item
import cl.jpvs.mod6ej02.data.local.ItemDataBase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>>
    { return  repository.getItem() }

    fun insertItem(nombre: String, precio: Double, cantidad: Double) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repository.insertItem(item)
    }

    suspend fun deleteDatoView() {
        viewModelScope.launch { Dispatchers.IO }
        repository.deleteDatos()
    }
}
