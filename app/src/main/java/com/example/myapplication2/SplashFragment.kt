package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication2.retrofit.City
import com.example.myapplication2.retrofit.RetrofitRepository
import retrofit2.Response

class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var repo = RetrofitRepository()
        //view.findViewById<ImageView>(R.id.imageView).setOnClickListener(
           // View.OnClickListener {

                Thread(Runnable {
                    var call = repo.getCities()
                    var response: Response<City?> = call?.execute()
                    var s = response?.body()
                    //text.post{text.setText(s)}
                    RestaurantsFragment.list = s?.cities
                    Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_loginFragment)
                }).start()
            //}

        //)
    }




}