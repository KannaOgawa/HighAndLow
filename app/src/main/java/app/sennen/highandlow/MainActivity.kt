package app.sennen.highandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import androidx.appcompat.app.AlertDialog




class MainActivity : AppCompatActivity() {


    var point = 0
    var num1 : Int=0
    var num2 : Int=0
    val images: List<Int> = listOf(R.drawable.card_heart_01,R.drawable.card_heart_02,R.drawable.card_heart_03,R.drawable.card_heart_04,
        R.drawable.card_heart_05,R.drawable.card_heart_06,R.drawable.card_heart_07,R.drawable.card_heart_08,
        R.drawable.card_heart_09,R.drawable.card_heart_10,R.drawable.card_heart_11,R.drawable.card_heart_12, R.drawable.card_heart_13)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newGame()
        hiButton.setOnClickListener {
            if(num1<num2) {
                point++
                AlertDialog.Builder(this)
                    .setTitle("勝ち")
                    .setPositiveButton("続ける"){ dialog, which ->
                        newGame()
                    }
                    .setNegativeButton("最初から"){ dialog, which ->
                        point=0
                        newGame()

                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("負け")
                    .setPositiveButton("最初から"){ dialog, which ->
                        point=0
                        newGame()

                    }
                    .show()
            }
            textView.text=point.toString()
            imageView2.setImageResource(images[num2])

        }

        lowButton.setOnClickListener {
            if(num1>num2) {
                point++
                AlertDialog.Builder(this)
                    .setTitle("勝ち")
                    .setPositiveButton("続ける"){ dialog, which ->
                        newGame()
                    }
                    .setNegativeButton("最初から"){ dialog, which ->
                        point=0
                        newGame()

                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("負け")
                    .setPositiveButton("最初から"){ dialog, which ->
                        point=0
                        newGame()

                    }
                    .show()
            }
            textView.text=point.toString()
            imageView2.setImageResource(images[num2])
        }
    }

    fun newGame(){
        num1=0
        num2=0
        textView.text=point.toString()
        while (num1==num2){
            num1 = Random().nextInt(12) + 1
            num2 = Random().nextInt(12) + 1
        }
        imageView2.setImageResource(R.drawable.card_back)
        imageView1.setImageResource(images[num1])

    }


}


