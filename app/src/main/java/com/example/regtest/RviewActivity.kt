package com.example.regtest

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class
RviewActivity : AppCompatActivity() {
    lateinit var name:TextView;
    lateinit var email:TextView;
    lateinit var gender: TextView;
//    lateinit var btnpick: TextView;

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rview)

        setTitle("Recycler Page")
        var name:String=intent.getStringExtra("Name").toString()
        var email:String=intent.getStringExtra("Email").toString()
        var gender:String=intent.getStringExtra("Gender").toString()
//        var btnpick:String=intent.getStringExtra("pickdate").toString()



        val recyclerView=findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val registerModels=ArrayList<RegisterModel>()
        registerModels.add(RegisterModel(name,email,gender,))
        //registerModels.add(RegisterModel(name,email,gender))
        //registerModels.add(RegisterModel(name,email,gender))

        val adapter=RviewAdapter(registerModels)
        recyclerView.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when (id) {
            R.id.item1 -> {

                val builder1 = AlertDialog.Builder(this)
                builder1.setMessage("Are You sure to logout?")
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
            else -> super.onOptionsItemSelected(item)
        }

    }
}