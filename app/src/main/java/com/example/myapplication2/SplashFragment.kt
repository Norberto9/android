package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
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

        Thread(Runnable {
            var call = repo.getCities()
            var response: Response<City?> = call?.execute()
            var s = response?.body()
            //text.post{text.setText(s)}
            RestaurantsFragment.list = s?.cities
            if (s != null) {
                if(s.cities.size > 0)
                    Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_loginFragment)
            }
            else
            {
                Toast.makeText(requireContext(), "No internet connection or failed to connect to API", Toast.LENGTH_LONG)
            }
        }).start()
    }




}