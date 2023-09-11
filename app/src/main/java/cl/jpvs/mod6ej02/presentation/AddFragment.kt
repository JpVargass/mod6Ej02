package cl.jpvs.mod6ej02.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import cl.jpvs.mod6ej02.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    private val itemsViewModel : ItemsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        initListener()
        cargarItems()
        return binding.root
    }

    private fun cargarItems() {
        itemsViewModel.getAllItems().observe(viewLifecycleOwner) {
            var aux = 0
            for (it in it) {
                val precios = it.precio * it.cantidad
                aux = (aux + precios).toInt()
            }
            binding.txtResultado.text = "$ $aux"
        }
    }

        fun guardarItem(nombre: String, precio: Double, cantidad: Double) {
            itemsViewModel.insertItem(nombre, precio, cantidad)
        }

        private fun initListener() {
       binding.btnGuardar.setOnClickListener{
           val nombre = binding.editTextNombre.text.toString()
           val precio = binding.editTextPrecio.text.toString().toDouble()
           val cantidad = binding.editTextCantidad.text.toString().toDouble()

           //itemsViewModel.insertItem(nombre,precio,cantidad)
           guardarItem(nombre,precio,cantidad)
           binding.editTextNombre.setText("")
           binding.editTextPrecio.setText("")
           binding.editTextCantidad.setText("")
           Toast.makeText(requireContext(), "Item Agregado", Toast.LENGTH_SHORT).show()


       }
  }

}