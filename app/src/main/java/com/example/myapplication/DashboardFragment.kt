package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.myapplication.data.DataState
import com.example.myapplication.data.Photo
import com.example.myapplication.data.PhotoStateEvent
import com.example.myapplication.data.PhotosViewModel
import com.example.myapplication.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(){
    private lateinit var binding: FragmentDashboardBinding
    private val photosViewModel by activityViewModels<PhotosViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        photosViewModel.photoResponse.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    launchDetail(it.response.photoList.get(0))
                    //initi detail view
                }
                is DataState.Error -> {
                    Log.e("_ERROR_", "$it.error.message")
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.btn1.setOnClickListener {
            photosViewModel.makeApiCall(PhotoStateEvent.GetPhotos)
        }
    }

    fun launchDetail(photo: Photo){
        val photoBundle = bundleOf("photo" to photo)
        view?.findNavController()?.navigate(R.id.detailsFragment, photoBundle)
    }

}