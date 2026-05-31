package com.example.steerapp.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.steerapp.Home.pertemuan10.TenthActivity
import com.example.steerapp.Home.pertemuan2.SecActivity
import com.example.steerapp.Home.pertemuan3.ThirdActivity
import com.example.steerapp.Home.pertemuan4.FourthActivity
import com.example.steerapp.Home.pertemuan5.FifthActivity
import com.example.steerapp.Home.pertemuan7.SeventhActivity
import com.example.steerapp.Home.pertemuan9.NinthActivity
import com.example.steerapp.R
import com.example.steerapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnToSec.setOnClickListener{
            val intent = Intent(requireContext(), SecActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener{
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFourth.setOnClickListener{
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener{
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSeventh.setOnClickListener{
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }

        binding.btnToNinth.setOnClickListener{
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToTenth.setOnClickListener{
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        /** binding lainnya */
    }

}