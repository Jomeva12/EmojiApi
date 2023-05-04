package com.jomeva.myemoji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.myemoji.adapters.EmojiAdapter
import com.jomeva.myemoji.interfaces.IEmoji
import com.jomeva.myemoji.modelos.EmojiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        traerEmoji()
    }
fun traerEmoji(){
    CoroutineScope(Dispatchers.IO).launch {
        val call=IEmoji.retrofit.create(IEmoji::class.java).obtenerEmoji("all")
        val respuesta=call.body() as MutableList<EmojiResponse.EmojiResponseItem>
       runOnUiThread{
           if (call.isSuccessful){
               iniciarRecycler(respuesta)
Log.d("mostrando","${respuesta}")
           }else{
               Log.d("mostrando2","nada")
           }
       }

    }
}

    fun iniciarRecycler(respuesta: MutableList<EmojiResponse.EmojiResponseItem>) {
        val recicler=findViewById<RecyclerView>(R.id.recicler)
        recicler.layoutManager=LinearLayoutManager(this)
        val mAdaper=EmojiAdapter(this,respuesta)
        recicler.adapter=mAdaper
    }
}