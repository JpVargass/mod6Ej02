package cl.jpvs.mod6ej02.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_item")
data class Item(val nombre:String, val precio: Double, val cantidad: Double){
    @PrimaryKey (autoGenerate = true) var id : Long = 0
}
