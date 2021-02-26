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


         checkWinner()


    }

    private fun checkWinner() {
        var winner=-1
        //row1
        if(person1.contains(1)&& person1.contains(2)&&person1.contains(3)){
            winner=1
        }
        if(person2.contains(1)&& person2.contains(2)&&person2.contains(3)){
            winner=2
        }

        //row2
        if(person1.contains(4)&& person1.contains(5)&&person1.contains(6)){
            winner=1
        }
        if(person2.contains(4)&& person2.contains(5)&&person2.contains(6)){
            winner=2
        }

        //row3
        if(person1.contains(7)&& person1.contains(8)&&person1.contains(9)){
            winner=1
        }
        if(person2.contains(7)&& person2.contains(8)&&person2.contains(9)){
            winner=2
        }

        //col1
        if(person1.contains(1)&& person1.contains(4)&&person1.contains(7)){
            winner=1
        }
        if(person2.contains(1)&& person2.contains(4)&&person2.contains(7)){
            winner=2
        }
        //col2
        if(person1.contains(2)&& person1.contains(5)&&person1.contains(8)){
            winner=1
        }
        if(person2.contains(2)&& person2.contains(5)&&person2.contains(8)){
            winner=2
        }
        //col3
        if(person1.contains(3)&& person1.contains(6)&&person1.contains(9)){
            winner=1
        }
        if(person2.contains(3)&& person2.contains(8)&&person2.contains(9)){
            winner=2
        }

        // for vertical rows1 at starting
        if(person1.contains(1)&& person1.contains(5)&&person1.contains(9)){
            winner=1
        }
        if(person2.contains(1)&& person2.contains(5)&&person2.contains(9)){
            winner=2
        }

        // for vertical row1 at ending
        if(person1.contains(3)&& person1.contains(5)&&person1.contains(7)){
            winner=1
        }
        if(person2.contains(3)&& person2.contains(5)&&person2.contains(7)){
            winner=2
        }

            // Announce Winner
        if(winner==1){
            Toast.makeText(this,"Player 1 WON",Toast.LENGTH_LONG).show()
        }
        else if(winner==2){
            Toast.makeText(this,"Player 2 is WON",Toast.LENGTH_LONG).show()
        }


    }

}