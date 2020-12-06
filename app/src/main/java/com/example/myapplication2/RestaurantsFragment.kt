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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.retrofit.City
import com.example.myapplication2.retrofit.Restaurant
import com.example.myapplication2.retrofit.Restaurants
import com.example.myapplication2.retrofit.RetrofitRepository
import retrofit2.Response

class RestaurantsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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




    }
    var spinner1 = 1
    var spinner2 = 1
    private fun search(){
        var repo = RetrofitRepository()
        var adapter = view?.findViewById<RecyclerView>(R.id.recycleview)?.adapter as RecycleAdapter
        Thread(Runnable {
            var call = repo.getRestaurants(list!![spinner1]!!)
            var response: Response<Restaurants> = call?.execute()
            var s = response?.body()
            adapter.setData(s!!.restaurants)
            //recycleView.post()
            requireActivity().runOnUiThread(Runnable {


                adapter.notifyDataSetChanged()
                //Log.i("valami", s.restaurants[0].name!!)
            })

            /*recycleView.adapter = adapter*/
            //text.post{text.setText(s)}

        }).start()
    }
    companion object{
        var list:List<String?>? = null
        var instance:RestaurantsFragment? = null
    }

}