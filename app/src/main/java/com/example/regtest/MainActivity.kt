package com.example.regtest

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Patterns.EMAIL_ADDRESS
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.regex.Pattern


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
TimePickerDialog.OnTimeSetListener{

    lateinit var et_name:EditText
    lateinit var et_email:EditText
    lateinit var btn_ok:Button
    lateinit var radioGroup: RadioGroup
    lateinit var male:RadioButton
    lateinit var female:RadioButton
    lateinit var radioButton:RadioButton
    lateinit var genSelected:String
    lateinit var checkBox: CheckBox
    lateinit var btnpick: Button
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Register Page")
        initViews()
        val etName=et_name.text
        val etEmail=et_email.text
        println("Name oncreate = "+etName)

        btnpick.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this@MainActivity, this@MainActivity, year, month,day)
            datePickerDialog.show()
        }

        btn_ok.setOnClickListener(View.OnClickListener {
            println("Name = "+etName)
            Toast.makeText(this,"Test ",Toast.LENGTH_LONG).show()
            if (validateName(etName.toString())==true){
                println("Valid Name = "+etName)
            }
            if (validEmail(etEmail.toString())==true){
                println("Valid Email = "+etEmail)
                valGender()
            }
            if (checkLicence()==true){
                Snackbar.make(it,"Success",Snackbar.LENGTH_SHORT).show()
                val intent=Intent(this@MainActivity,RviewActivity::class.java)
                intent.putExtra("Name",etName.toString())
                intent.putExtra("Email",etEmail.toString())
                intent.putExtra("Gender",genSelected)
                startActivity(intent)
            }

            else{
                Toast.makeText(this,"Inavlid Credentials!!!",Toast.LENGTH_LONG).show()
                println(" Inavlid Credentials!!!")
            }
        })
    }

    fun initViews(){
        et_name=findViewById(R.id.et_name)
        et_email=findViewById(R.id.et_email)
        btn_ok=findViewById(R.id.btv_ok)
        radioGroup=findViewById(R.id.genderGroup)
        male=findViewById(R.id.radioM)
        female=findViewById(R.id.radioF)
        checkBox=findViewById(R.id.condCheck)
//        textView = findViewById(R.id.textView)
        btnpick = findViewById(R.id.btnPick)
    }

    fun validateName(name:String) : Boolean {
        var validName:Boolean
        if (name.length>=5 && name.length<30){
            validName= true
        }else{
            et_name.setError("Please Enter Valid Name!!")
            validName=false
        }
        return validName
    }

    fun validEmail(email:String) :Boolean{
        var validEmail:Boolean
        if (email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            validEmail=true
        }else{
            et_email.setError("Palease Enter Valid Email")
            validEmail=false
        }

        return validEmail
    }

    fun valGender() {
        if (radioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "selected Gender", Toast.LENGTH_LONG).show()
        } else {
            val selectedOpt: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(selectedOpt)
            println("Selected val = " + radioButton.text)
            genSelected = radioButton.text.toString()
            println("Selectd gen=" + genSelected)
        }
    }

    fun checkLicence():Boolean{
        var licenceVal:Boolean
        if(checkBox.isChecked){
            licenceVal=true
        }
        else{
            checkBox.setError("Please Accept Licence")
            licenceVal=false
        }
        return licenceVal
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this@MainActivity, this@MainActivity, hour, minute,
            DateFormat.is24HourFormat(this))
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        myHour = hourOfDay
        myMinute = minute
        datetime.text = "Year: " + myYear + "\n" + "Month: " + myMonth + "\n" + "Day: " + myDay + "\n" + "Hour: " + myHour + "\n" + "Minute: " + myMinute
    }

    fun replace(list: Unit) {

    }

}