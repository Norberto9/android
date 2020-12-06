package com.example.myapplication2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.myapplication2.database.RoomRepository

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_register).setOnClickListener(View.OnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registrationFragment)

        })

        view.findViewById<Button>(R.id.btn_login).setOnClickListener(View.OnClickListener {
            Thread(Runnable {
                var roomRepository: RoomRepository = RoomRepository()
                var users = roomRepository.getUsers()
                for(user in users)
                {
                    Log.i("login", user.email!!)
                    Log.i("login", user.password!!)
                    if((user.email == view.findViewById<EditText>(R.id.et_email).text.toString())
                    and (user.password == view.findViewById<EditText>(R.id.et_password).text.toString())){

                        Log.i("login", "siker")
                        Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_restaurantsFragment)
                    }
                }


            }).start()
            //

        })
    }
}