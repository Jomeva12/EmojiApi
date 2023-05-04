package com.jomeva.myemoji.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.myemoji.R
import com.jomeva.myemoji.modelos.EmojiResponse


class EmojiAdapter(val context:Context, val listaEmoji:List<EmojiResponse.EmojiResponseItem>):RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
val category=view.findViewById<TextView>(R.id.categoria)
        val grupo=view.findViewById<TextView>(R.id.grupo)
        val htmlCode=view.findViewById<TextView>(R.id.htmlcode)
        val nombre=view.findViewById<TextView>(R.id.nombre)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val layout=LayoutInflater.from(parent.context).inflate(R.layout.card_emoji,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int =listaEmoji.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.category.text=listaEmoji[position].category.toString()
        holder.grupo.text=listaEmoji[position].group
        val emojiText = Html.fromHtml(listaEmoji[position].htmlCode.toString(), Html.FROM_HTML_MODE_LEGACY)
        holder.htmlCode.text= emojiText.substring(1,3)
       // holder.nombre.text=listaEmoji[position].toString()

    }
}