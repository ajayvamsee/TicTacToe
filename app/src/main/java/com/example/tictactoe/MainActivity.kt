package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun btnPress(view: View){

        var btnSelect:Button=view as Button
        Toast.makeText(this,"u selected btn is"+ btnSelect.id.toString(),Toast.LENGTH_SHORT).show()

        var

    }

}