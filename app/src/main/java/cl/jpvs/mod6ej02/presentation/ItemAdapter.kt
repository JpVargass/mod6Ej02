package cl.jpvs.mod6ej02.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.mod6ej02.data.local.Item
import cl.jpvs.mod6ej02.databinding.ItemBinding

/*
[x ] implementar clase Adapter
[x]  heredar RecyclerView.Adapter
[x] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[x ] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[x] Agregar constructor
[x] crear objeto, data class
[x] Crear lista
[x] asignar tamaño de la lista en getItemCount
[x] definir Binding Class del Item
[x] cambiar view por el binding
[x] declarar variable item en onBindViewHolder
[x] implementar binding en clase viewHolder
[x] Adapter+ view holder
[ x] obtener los datos
*/
class ItemAdapter : RecyclerView.Adapter <ItemAdapter.ItemViewHolder> (){
    lateinit var binding: ItemBinding
    private  val listItem = mutableListOf<Item>()
    //


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemViewHolder(binding)
    }
    fun setData(listaItem: Item : List<Item>)
    override fun getItemCount(): Int {
      return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)

    }
    class ItemViewHolder(v: ItemBinding) : RecyclerView.ViewHolder(v.root) {
        fun render(item : Item){
            v.tvNombre.text = item.nombre
        }
    }
}