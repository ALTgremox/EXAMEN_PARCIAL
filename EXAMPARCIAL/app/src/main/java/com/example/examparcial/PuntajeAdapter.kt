package com.example.examparcial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examparcial.databinding.ItemPuntajeBinding

class PuntajeAdapter(private val listaPuntajes: List<Int>) :
    RecyclerView.Adapter<PuntajeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPuntajeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPuntajeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val puntaje = listaPuntajes[position]
        holder.binding.tvItemPuntaje.text = "Partida ${position + 1}: $puntaje puntos"
    }

    override fun getItemCount() = listaPuntajes.size
}
