package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication2.R.layout
import com.example.myapplication2.database.RoomRepository
import com.example.myapplication2.retrofit.RetrofitRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        var roomRepository: RoomRepository = RoomRepository()
        findViewById<Button>(R.id.button1).setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "A", Toast.LENGTH_SHORT).show()
            //roomRepository.addNewRestaurant(findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
        })

        var text = findViewById<TextView>(R.id.textView)
        var repo = RetrofitRepository()
        findViewById<Button>(R.id.button2).setOnClickListener(View.OnClickListener {


            Thread(Runnable {
                var call = repo.getRepo()
                var response: Response<String?>? = call?.execute()
                var s = response?.body()
                text.post{text.setText(s)}

            }).start()

        }
        )
    }
}