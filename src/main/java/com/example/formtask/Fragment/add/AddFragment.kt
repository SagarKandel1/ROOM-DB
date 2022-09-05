package com.example.formtask.Fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.formtask.Model.User
import com.example.formtask.Model.UserViewModel
import com.example.formtask.R
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

// TODO: Rename parameter arguments, choose names that match


class AddFragment : Fragment() {

    private lateinit var mAddressViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mAddressViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.btncontinue.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstaddress = AddressTextBox.text.toString()
        val postal = eTPostalCode.text.toString()
        val city = editTextTown.text.toString()
        val country = eTCountry.text.toString()

        if (inputCheck(firstaddress,postal,city,country)){
        val user = User(0,firstaddress,postal,city,country)
        mAddressViewModel.addUser(user)
        Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
        // Navigate Back
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }else{
        Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
    }

    }



    private fun inputCheck(address1: String, postalcode: String,city: String, country: String): Boolean{
        return !(TextUtils.isEmpty(address1) && TextUtils.isEmpty(postalcode)
                && TextUtils.isEmpty(city) && TextUtils.isEmpty(country))
    }


}