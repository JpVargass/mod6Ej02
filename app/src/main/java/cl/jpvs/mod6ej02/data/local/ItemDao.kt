package cl.jpvs.mod6ej02.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao

import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)

    @Query ("SELECT * FROM table_item order by id ASC")
    fun getAllitems() : LiveData <List<Item>>
/*
    @Delete
    fun deleteItems(items: List<Item>)
*/

    @Query("DELETE FROM table_item")
    suspend fun deleteDatos()

}



