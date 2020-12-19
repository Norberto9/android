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
import com.example.myapplication2.retrofit.City
import com.example.myapplication2.retrofit.Restaurant
import com.example.myapplication2.retrofit.RetrofitRepository
import retrofit2.Response

class DetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.details_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.detailsName).text = r!!.name
        view.findViewById<TextView>(R.id.detailsCity).text = r!!.city
        view.findViewById<TextView>(R.id.detState).text = r!!.state
        view.findViewById<TextView>(R.id.detName).text = r!!.country
        view.findViewById<TextView>(R.id.detArea).text = r!!.area
        view.findViewById<TextView>(R.id.detLat).text = r!!.lat.toString()
        view.findViewById<TextView>(R.id.detLon).text = r!!.lng.toString()
        view.findViewById<TextView>(R.id.detAddress).text = r!!.address
        view.findViewById<TextView>(R.id.detPrice).text = r!!.price.toString()
        view.findViewById<TextView>(R.id.detPhone).text = r!!.phone
        view.findViewById<TextView>(R.id.detReserve).text = r!!.reserve_url
        view.findViewById<TextView>(R.id.detMobilReserve).text = r!!.mobile_reserve_url

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(requireContext())
            .applyDefaultRequestOptions(requestOptions)
            .load("https://cdn.pixabay.com/photo/2015/08/19/02/27/restaurant-895427_1280.png")
            .into(view.findViewById<ImageView>(R.id.imageView2))
    }

    companion object{
        var r:Restaurant? = null
    }


}