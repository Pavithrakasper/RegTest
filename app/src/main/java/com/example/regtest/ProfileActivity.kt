package com.example.regtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var tv1:TextView
    lateinit var tv2:TextView
    lateinit var tv3:TextView
    lateinit var btnBack:Button
    lateinit var del: Button
//    lateinit var datetime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setTitle("Profile Details")
        var name:String=intent.getStringExtra("Name").toString()
        var email:String=intent.getStringExtra("Email").toString()
        var gender:String=intent.getStringExtra("Gender").toString()
//        var datetime:String=intent.getStringExtra("Datetime").toString()

        println("Name ="+name+", email="+email+", gender="+gender)

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        tv3=findViewById(R.id.tv3)
        del = findViewById(R.id.delete)


        tv1.setText("Name : "+name)
        tv2.setText("Email : "+email)
        tv3.setText("Gender : "+gender)



        btnBack=findViewById(R.id.btnBack)
        btnBack.setOnClickListener(View.OnClickListener {
            val backIntent= Intent(this@ProfileActivity,MainActivity::class.java)
            startActivity(backIntent)

        }
        )
        del.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setMessage("Are You sure to delete?")
            builder1.setCancelable(true)
            builder1.setPositiveButton(

                "Yes"
            ) { dialog, id -> dialog.cancel() }
            builder1.setNegativeButton(
                "No"
            ) { dialog, id -> dialog.cancel() }
            val alert11 = builder1.create()
            alert11.show()
            true
        }
    }
}