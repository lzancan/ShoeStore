package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private val viewModel: ShoesListViewModel by activityViewModels()

    lateinit var binding: FragmentShoesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.fabList.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoesListFragment_to_shoeDetailFragment)
        }
        viewModel.listOfShoes.observe(viewLifecycleOwner, {
            binding.parentLinear.removeAllViews()
            it.forEach { shoe ->
                val linearShoe = LinearLayout(context)
                linearShoe.orientation = LinearLayout.VERTICAL
                val textName = TextView(context)
                val textSize = TextView(context)
                val textCompany = TextView(context)
                val textDescription = TextView(context)
                textName.text = shoe.name
                textSize.text = shoe.size.toString()
                textCompany.text = shoe.company
                textDescription.text = shoe.description
                linearShoe.addView(textName)
                linearShoe.addView(textSize)
                linearShoe.addView(textCompany)
                linearShoe.addView(textDescription)
                binding.parentLinear.addView(linearShoe)
            }
        })
    }

}