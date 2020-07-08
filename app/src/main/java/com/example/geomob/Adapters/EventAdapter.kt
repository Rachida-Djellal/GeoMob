package com.example.geomob.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Activities.PaysActivity
import com.example.geomob.DataClasses.Evenement
import com.example.geomob.DataClasses.Ressource
import com.example.geomob.R

class EventAdapter (val activity : PaysActivity, val list : ArrayList<Evenement>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    class EventViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val titleEvent = v.findViewById<TextView>(R.id.evenTitle)
        val descEvent = v.findViewById<TextView>(R.id.eventDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(activity).inflate(R.layout.event_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = list[position]

        holder.titleEvent.text = event.date
        holder.descEvent.text = event.description

    }
}