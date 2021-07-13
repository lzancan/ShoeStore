package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoesListViewModel by activityViewModels()
    lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.buttonCancel.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }
        binding.buttonSave.setOnClickListener {
            viewModel.addNewShoe(
                Shoe(
                    binding.shoeNameInput.text.toString(),
                    binding.shoeSizeInput.text.toString().toDouble(),
                    binding.shoeCompanyInput.text.toString(),
                    binding.shoeDescriptionInput.text.toString()
                )
            )
            view?.findNavController()?.navigateUp()
        }
    }

}