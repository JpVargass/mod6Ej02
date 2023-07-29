package cl.jpvs.mod6ej02.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.jpvs.mod6ej02.data.Repository
import cl.jpvs.mod6ej02.data.local.Item
import cl.jpvs.mod6ej02.data.local.ItemDatabase
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDatabase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItem()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = Item(name, price, quantity)
        repository.insertItem(item)
    }
}