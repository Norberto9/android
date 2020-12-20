package com.example.myapplication2

import android.graphics.Color
import android.graphics.Color.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication2.retrofit.Restaurant

class RecycleAdapter() :
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    companion object{
        private var dataSet: List<Restaurant> = listOf()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.restaurantTitle)
        private val city: TextView = view.findViewById(R.id.restaurantCity)
        private val address: TextView = view.findViewById(R.id.restaurantAddress)
        private val phone: TextView = view.findViewById(R.id.restaurantPhone)
        private val price: TextView = view.findViewById(R.id.restaurantPrice)
        private val image: ImageView = view.findViewById(R.id.imageView3)

        init {
            view.setOnClickListener(View.OnClickListener {
                DetailsFragment.r = RecycleAdapter.dataSet[adapterPosition]
                var v = RestaurantsFragment.instance!!.requireView()
                Navigation.findNavController(v).navigate(R.id.action_restaurantsFragment_to_detailsFragment)
            })
        }

        fun bind(restaurant: Restaurant)
        {
            title.text = restaurant.name
            city.text = restaurant.city
            address.text = restaurant.address
            phone.text = restaurant.phone
            price.text = restaurant.price.toString()
            //Log.i("valami", restaurant.name!!)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load("https://cdn.pixabay.com/photo/2015/08/19/02/27/restaurant-895427_1280.png")
                .into(image)
        }
    }

    public fun setData(newData: List<Restaurant>) {
        dataSet = newData

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        var view: CardView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycleitem, viewGroup, false) as CardView
        //view.cardBackgroundColor = Color.parseColor("#AE05AE")
        //Log.i("valami","hello")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecycleAdapter.ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(dataSet[position])
        if(position%2 == 0)
        {
            (viewHolder.itemView as CardView).setCardBackgroundColor(parseColor("#FFFFFFFF"))
        }
        else
        {
            (viewHolder.itemView as CardView).setCardBackgroundColor(parseColor("#FFDDDDDD"))
        }
    }

    override fun getItemCount(): Int {
        Log.i("valami", dataSet.size.toString())
        return dataSet.size
    }


}