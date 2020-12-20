package com.example.myapplication2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.retrofit.City
import com.example.myapplication2.retrofit.Restaurant
import com.example.myapplication2.retrofit.Restaurants
import com.example.myapplication2.retrofit.RetrofitRepository
import kotlinx.android.synthetic.main.fragment_restaurants.*
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.await
import retrofit2.awaitResponse
import java.lang.Runnable
import kotlin.coroutines.CoroutineContext

class RestaurantsFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var citiesSpinner = view.findViewById<Spinner>(R.id.spinner3)
        var spinnerArrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, list!!.toMutableList())
        citiesSpinner.adapter = spinnerArrayAdapter



        var pricesSpinner = view.findViewById<Spinner>(R.id.spinner4)
        var priceArray = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        var pricesArrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, priceArray!!.toMutableList())
        pricesSpinner.adapter = pricesArrayAdapter


        var recycleView = view.findViewById<RecyclerView>(R.id.recycleview)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        var adapter = RecycleAdapter()
        recycleView.adapter = adapter


        citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.i("valami", list!![position]!!)
                spinner1 = position
                search()
            }

        }



        pricesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.i("valami", list!![position]!!)
                spinner2 = position
                search()
            }

        }
        go_profile.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_restaurantsFragment_to_profilFragment)
        })
    }
    var spinner1 = 1
    var spinner2 = 1
    private fun search(){
        var repo = RetrofitRepository()
        var adapter = view?.findViewById<RecyclerView>(R.id.recycleview)?.adapter as RecycleAdapter
        Thread(Runnable {
            var call = repo.getRestaurants(list!![spinner1]!!, spinner2)
            var response: Response<Restaurants> = call?.execute()

            var s = response?.body()
            //Log.i("valami2", s.toString()!!)
            adapter.setData(s!!.restaurants)
            requireActivity().runOnUiThread(Runnable {
                adapter.notifyDataSetChanged()
            })

            if(s!!.restaurants.isEmpty())
            {
                requireActivity().runOnUiThread{
                    Toast.makeText(requireActivity(), "No restaurants found!", Toast.LENGTH_SHORT).show()
                }
            }
        }).start()

    }
    companion object{
        var list:List<String?>? = null
        var instance:RestaurantsFragment? = null
    }
}