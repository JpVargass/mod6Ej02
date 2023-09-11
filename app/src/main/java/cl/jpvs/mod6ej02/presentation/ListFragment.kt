package cl.jpvs.mod6ej02.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cl.jpvs.mod6ej02.R
import cl.jpvs.mod6ej02.databinding.FragmentListBinding
import kotlinx.coroutines.launch

/*
* Pasos para crear un recycler view
[x ] item layout
[x] agregar constraints
[x] cambiar altura de constraints layout de item layout a wrap content
[X] definir ID
[x ] layout con recycler view
[X ] asignar layout manager

* */

class ListFragment : Fragment() {
lateinit var binding : FragmentListBinding
private val itemsViewModel : ItemsViewModel by activityViewModels()
val adapter = ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater,container, false)
        initLista()
        initDelete()
        return binding.root
    }
    private fun initDelete() {
        binding.floatingDelete.setOnClickListener() {
            viewLifecycleOwner.lifecycleScope.launch {
                itemsViewModel.deleteDatoView()
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        }
    }

    private fun initLista() {
        itemsViewModel.getAllItems().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

        binding.RecyclerV.adapter = adapter
    }

}