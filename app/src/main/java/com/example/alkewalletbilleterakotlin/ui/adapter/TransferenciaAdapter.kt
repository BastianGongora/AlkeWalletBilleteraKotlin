package com.example.alkewalletbilleterakotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.data.model.Transferencia

class TransferenciaAdapter (private val transferencias: List<Transferencia>) : RecyclerView.Adapter<TransferenciaAdapter.TransferenciaViewHolder>() {


    class TransferenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val nombreTextView: TextView = itemView.findViewById(R.id.text_view_nombre)
        val fechaTextView: TextView = itemView.findViewById(R.id.text_view_fecha)
        val cantidadTextView: TextView = itemView.findViewById(R.id.text_view_cantidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferenciaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_transferencia, parent, false)
        return TransferenciaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransferenciaViewHolder, position: Int) {
        val currentItem = transferencias[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.nombreTextView.text = currentItem.nombre
        holder.fechaTextView.text = currentItem.fecha
        holder.cantidadTextView.text = currentItem.cantidad.toString()
    }

    override fun getItemCount() = transferencias.size
}