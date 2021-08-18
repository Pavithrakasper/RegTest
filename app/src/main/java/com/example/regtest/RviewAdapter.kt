package com.example.regtest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RviewAdapter (val rViewList:ArrayList<RegisterModel>):RecyclerView.Adapter<RviewAdapter.ViewHolder>(){
    //var mcontext:Context=this
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.rview_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(rViewList[position])
    }

    override fun getItemCount(): Int {
        return rViewList.size
    }

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(registerModel: RegisterModel){
            val tvName=itemView.findViewById(R.id.tv_name) as TextView
            //val tvEmail=itemView.findViewById(R.id.tv_email) as TextView
            //val tvGender=itemView.findViewById(R.id.tv_gender) as TextView
            val btnMore=itemView.findViewById(R.id.btn_view) as Button
            tvName.text=registerModel.name
            //tvEmail.text=registerModel.email
            //tvGender.text=registerModel.gender
            btnMore.setOnClickListener(View.OnClickListener {
                val intent= Intent(itemView.context,ProfileActivity::class.java)
                intent.putExtra("Name",registerModel.name.toString())
                intent.putExtra("Email",registerModel.email.toString())
                intent.putExtra("Gender",registerModel.gender.toString())
//                intent.putExtra("pickdate",registerModel.btnpick.toString())
                itemView.context.startActivity(intent)
                //print("udfyufdydydw")
                //Toast.makeText(itemView.context,"btn prsd"+registerModel.name.toString(),Toast.LENGTH_LONG).show()
            })
        }
    }



}
