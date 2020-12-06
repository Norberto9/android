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
import com.example.myapplication2.database.User
import com.example.myapplication2.retrofit.City
import retrofit2.Response
import java.time.LocalDateTime
import java.util.*

class RegistrationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_register1).setOnClickListener(View.OnClickListener {
            var u:User = User(null,
                view.findViewById<EditText>(R.id.etr_name).text.toString(),
                view.findViewById<EditText>(R.id.etr_email).text.toString(),
                Calendar.getInstance().time.toString(),
                Calendar.getInstance().time.toString(),
                view.findViewById<EditText>(R.id.etr_password).text.toString()
                )
            if(view.findViewById<EditText>(R.id.etr_password).text.toString() != view.findViewById<EditText>(R.id.etr_repassword).text.toString()) {
                Log.i("login", "failed")
                return@OnClickListener
            }
            Thread(Runnable {
                var roomRepository: RoomRepository = RoomRepository()
                var users = roomRepository.getUsers()
                for(user in users)
                {
                    if(user.email == u.email){
                        Log.i("login", "failed")
                        return@Runnable
                    }
                }
                roomRepository.addNewUser(u)
                Log.i("login", "successful")
                Navigation.findNavController(requireView()).navigate(R.id.action_registrationFragment_to_loginFragment)
            }).start()


        })
    }
}