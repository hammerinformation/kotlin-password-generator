package com.your.your

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var password:String=""
    val special= arrayListOf<String>("#","_","-","*","?","'","^","+","$","<",">")
    val letters= arrayListOf<String>("A", "B", "C", "D", "E", "F"
        , "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    val letters2= arrayListOf<String>("a", "b", "c", "d", "e", "f"
        , "g", "h", "i", "j", "k", "l", "m", "n", "o",
        "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    val numbers= arrayListOf<Int>(0,1,2,3,4,5,6,7,8,9)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        btn_copy.setOnClickListener(){
            copyTextToClipboard();
        }
        btn_generate.setOnClickListener(){
            generateRandomPass()
            print(password)
        }
    }


    private  fun generateRandomPass(){
        this.password=""
        var con:Int=0

        while (con<(10..30).random()){
            val select = (0..3).random()
con+=1
            if (select==0){
                this.password+=special.random().toString()
            }
            if (select==1){

                this.password+=letters.random().toString()

            }
            if (select==2){
                this.password+=numbers.random().toString()

            }
            if (select==3){
                this.password+=letters2.random().toString()

            }

        }


        textV.text=this.password
    }


    private fun copyTextToClipboard() {
        if (password.length>=1){


            val textToCopy = this.password

            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)

            Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()

        }
    }
}
