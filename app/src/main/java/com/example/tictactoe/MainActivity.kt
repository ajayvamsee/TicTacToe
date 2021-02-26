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

        var cellId:Int=0
            when(btnSelect.id){
                R.id.btn1 -> cellId=1
                R.id.btn2 -> cellId=2
                R.id.btn3 -> cellId=3
                R.id.btn4 -> cellId=4
                R.id.btn5 -> cellId=5
                R.id.btn6 -> cellId=6
                R.id.btn7 -> cellId=7
                R.id.btn8 -> cellId=9

            }

        playGame(cellId,btnSelect)

    }

    var activePlayer=1

    var person1=ArrayList<Int>()
    var person2=ArrayList<Int>()

    // creating game functiom

     fun playGame(cellId: Int,btnSelect: Button) {

         if(activePlayer==1){
             btnSelect.text="X"
             btnSelect.setBackgroundResource(R.color.blue)
             person1.add(cellId)
             activePlayer=2
         }
         else{

             btnSelect.text="O"
             btnSelect.setBackgroundResource(R.color.green)
             person2.add(cellId)
             activePlayer=1
         }
         btnSelect.isEnabled=false


    }

}