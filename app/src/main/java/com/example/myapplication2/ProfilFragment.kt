package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication2.database.User
import com.example.myapplication2.retrofit.City
import com.example.myapplication2.retrofit.RetrofitRepository
import retrofit2.Response

class ProfilFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.profil_name).text = user!!.name
        view.findViewById<TextView>(R.id.prof_email).text = user!!.email
        view.findViewById<TextView>(R.id.prof_lastlog).text = user!!.lastlog
        view.findViewById<TextView>(R.id.prof_regtime).text = user!!.regtime

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(view.context)
            .applyDefaultRequestOptions(requestOptions)
            .load("https://t4.ftcdn.net/jpg/03/46/93/61/360_F_346936114_RaxE6OQogebgAWTalE1myseY1Hbb5qPM.jpg")
            .into(view.findViewById<ImageView>(R.id.imageView4))
    }

    companion object{
        var user: User? = null
    }



}