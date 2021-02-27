package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var btn1:Button? = null
    private var btn2:Button?=null
    private var btn3:Button? = null
    private var btn4:Button? = null
    private var btn5:Button? = null
    private var btn6:Button? = null
    private var btn7:Button? = null
    private var btn8:Button? = null
    private var btn9:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)




    }

    fun btnPress(view: View){

        var btnSelect:Button?
        btnSelect = view as Button
        // just to know which button as been clicked here
        // Toast.makeText(this,"u selected btn is"+ btnSelect.id.toString(),Toast.LENGTH_SHORT).show()

        var cellId =0
        when(btnSelect.id){
            R.id.btn1 -> cellId=1
            R.id.btn2 -> cellId=2
            R.id.btn3 -> cellId=3
            R.id.btn4 -> cellId=4
            R.id.btn5 -> cellId=5
            R.id.btn6 -> cellId=6
            R.id.btn7 -> cellId=7
            R.id.btn8 -> cellId=8
            R.id.btn9 -> cellId=9

        }

        playGame(cellId,btnSelect)

    }



    private var activePlayer=1

    private var person1=ArrayList<Int>()
    private var person2=ArrayList<Int>()

    // creating game functiom

    private fun playGame(cellId: Int, btnSelect: Button) {

        if(activePlayer==1){
            player1Count += 1
            btnSelect.text="X"
            btnSelect.setBackgroundResource(R.color.blue)
            person1.add(cellId)
            activePlayer=2

            autoPlay()
        }
        else{
            player2Count += 1
            btnSelect.text="O"
            btnSelect.setBackgroundResource(R.color.green)
            person2.add(cellId)
            activePlayer=1
        }
        btnSelect.isEnabled=false


        checkWinner()


    }

     private fun checkWinner() {
        var winner = -1
        //row1
        if (person1.contains(1) && person1.contains(2) && person1.contains(3)) {
            winner = 1
        }
        if (person2.contains(1) && person2.contains(2) && person2.contains(3)) {
            winner = 2
        }

        //row2
        if (person1.contains(4) && person1.contains(5) && person1.contains(6)) {
            winner = 1
        }
        if (person2.contains(4) && person2.contains(5) && person2.contains(6)) {
            winner = 2
        }

        //row3
        if (person1.contains(7) && person1.contains(8) && person1.contains(9)) {
            winner = 1
        }
        if (person2.contains(7) && person2.contains(8) && person2.contains(9)) {
            winner = 2
        }

        //col1
        if (person1.contains(1) && person1.contains(4) && person1.contains(7)) {
            winner = 1
        }
        if (person2.contains(1) && person2.contains(4) && person2.contains(7)) {
            winner = 2
        }
        //col2
        if (person1.contains(2) && person1.contains(5) && person1.contains(8)) {
            winner = 1
        }
        if (person2.contains(2) && person2.contains(5) && person2.contains(8)) {
            winner = 2
        }
        //col3
        if (person1.contains(3) && person1.contains(6) && person1.contains(9)) {
            winner = 1
        }
        if (person2.contains(3) && person2.contains(9) && person2.contains(9)) {
            winner = 2
        }

        // for vertical rows1 at starting
        if (person1.contains(1) && person1.contains(5) && person1.contains(9)) {
            winner = 1
        }
        if (person2.contains(1) && person2.contains(5) && person2.contains(9)) {
            winner = 2
        }

        // for vertical row1 at ending
        if (person1.contains(3) && person1.contains(5) && person1.contains(7)) {
            winner = 1
        }
        if (person2.contains(3) && person2.contains(5) && person2.contains(7)) {
            winner = 2
        }

        // Announce Winner
        if (winner == 1) {
            Toast.makeText(this, "Player 1 WON", Toast.LENGTH_LONG).show()
        } else if (winner == 2) {
            Toast.makeText(this, "Player 2 is WON", Toast.LENGTH_LONG).show()
        }




    }


    // functinality for autoplay
    private fun autoPlay() {
        val emptyCells = ArrayList<Int>()

        for (cellId in 1..9) {
            if (!(person1.contains(cellId) || person2.contains(cellId))) {
                emptyCells.add(cellId)
            }

        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        var cellId = emptyCells[randIndex]

        var btnSelect: Button?
        btnSelect = when(cellId) {

            1 -> btn1
            2 -> btn2
            3 -> btn3
            4 -> btn4
            5 -> btn5
            6 -> btn6
            7 -> btn7
            8 -> btn8
            9 -> btn9
            else -> { btn1 }


        }

        playGame(cellId, btnSelect!!)

    }

    var player1Count=0
    var player2Count=0

    fun restartGame(){
        activePlayer=1
         person1.clear()
        person2.clear()
        for (cellId in 1..9){

            var btnSelect: Button?
            btnSelect = when(cellId) {

                1 -> btn1
                2 -> btn2
                3 -> btn3
                4 -> btn4
                5 -> btn5
                6 -> btn6
                7 -> btn7
                8 -> btn8
                9 -> btn9
                else -> { btn1 }


            }
            btnSelect!!.text=""
            btnSelect.setBackgroundResource(R.color.white)
            btnSelect.isEnabled=true



        }
        Toast.makeText(this, "Player 1 Wins: $player1Count, Player 2 Wins: $player2Count ",Toast.LENGTH_LONG).show()

    }



}