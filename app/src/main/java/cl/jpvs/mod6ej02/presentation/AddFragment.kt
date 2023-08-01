package cl.jpvs.mod6ej02.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }
  private fun initListener() {
       binding.btnGuardar.setOnClickListener{
           val nombre = binding.editTextNombre.text.toString()
           val precio = binding.editTextPrecio.text.toString().toInt()
           val cantidad = binding.editTextCantidad.text.toString().toInt()

           itemsViewModel.insertItem(nombre,precio,cantidad)

       }
  }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}