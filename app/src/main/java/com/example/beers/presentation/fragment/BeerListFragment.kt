package com.example.beers.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.beers.databinding.FragmentBeersListBinding
import com.example.beers.presentation.BeerApp
import com.example.beers.presentation.viewmodel.BeersViewModel
import com.example.beers.presentation.ViewModelFactory
import com.example.beers.presentation.adapter.BeerListAdapter
import javax.inject.Inject

class BeerListFragment : Fragment() {

    private lateinit var viewModel: BeersViewModel
    private lateinit var beerListAdapter: BeerListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as BeerApp).component
    }

    private var _binding: FragmentBeersListBinding? = null
    private val binding: FragmentBeersListBinding
        get() = _binding ?: throw RuntimeException("FragmentBeersListBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerListAdapter = BeerListAdapter()
        binding.rvBeerList.adapter = beerListAdapter
        viewModel = ViewModelProvider(this, viewModelFactory)[BeersViewModel::class.java]
        viewModel.beerList.observe(viewLifecycleOwner){
            beerListAdapter.submitList(it)
        }
        beerListAdapter.onBeerItemClick = {
            Toast.makeText(requireContext(), "$it! Good choice!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        fun newInstance() = BeerListFragment()
    }
}