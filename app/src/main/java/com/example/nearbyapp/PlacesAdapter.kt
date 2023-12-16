package com.example.nearbyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.data.remote.response.Place
import com.example.nearbyapp.databinding.VenuesBinding
import javax.inject.Inject

class PlacesAdapter
@Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var venueList: Array<Place> = emptyArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VenuesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.venues,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = venueList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VenuesViewHolder) {
            holder.binding.apply {
                title.text = venueList[position].name
                address.text = venueList[position].display_location
            }
        }
    }

    fun setData(data: Array<Place>) {
        venueList = data
        notifyDataSetChanged()
    }

    class VenuesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = VenuesBinding.bind(itemView)
    }
}