package com.hfad.cyoapibeautified


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView = view.findViewById(R.id.pet_image)
        val petName: TextView = view.findViewById(R.id.pet_name)
       // val petDescription: TextView = view.findViewById(R.id.pet_description)
        val weightHeightTextView: TextView = itemView.findViewById(R.id.weightHeightTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]

        val weightHeightText = holder.itemView.context.getString(R.string.weight_height_format, pokemon.weight, pokemon.height)
        holder.weightHeightTextView.text = weightHeightText
        holder.petName.text = pokemon.name
        //holder.petDescription.text = pokemon.description

        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .into(holder.petImage)


        // Load the image from the API (pokemon.imageUrl) using Glide or another library

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}

/*
Glide.with(holder.itemView.context)
.load(pokemon.imageUrl)
.into(holder.petImage)*/
