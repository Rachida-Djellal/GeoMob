package com.example.geomob.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Activities.PaysActivity
import com.example.geomob.DataClasses.Personalite
import com.example.geomob.DataClasses.Ressource
import com.example.geomob.R

class PersonneAdapter (val activity : PaysActivity, val list : ArrayList<Personalite>) : RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder>() {
    class PersonneViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val personName = v.findViewById<TextView>(R.id.personNameView)
        val personImg = v.findViewById<ImageView>(R.id.personPicView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonneViewHolder {
        return PersonneViewHolder(
            LayoutInflater.from(activity).inflate(R.layout.personalite_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PersonneViewHolder, position: Int) {
        val person = list[position]

        holder.personName.text = person.nomPersonalite
        holder.personImg.setImageResource(person.resId)

    }
}