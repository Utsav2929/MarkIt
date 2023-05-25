package com.example.markit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.databinding.ActivityHomeBinding

class attendencedetailsadapter(private val userList : ArrayList<date>) : RecyclerView.Adapter<attendencedetailsadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_attendence,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

//        holder.cname.text = currentitem.cname
//if (currentitem.name=)
//        holder.email.text = currentitem.email
//
//        holder.mobile.text = currentitem.mobile
        holder.date.text = currentitem.date
        holder.late.text = currentitem.late
//
//        holder.needs.text = currentitem.needs
//        holder.name.text = currentitem.name



// get reference to button


    }

    override fun getItemCount(): Int {

        return userList.size
    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //        val cname : TextView = itemView.findViewById(R.id.cname)
        val date : TextView = itemView.findViewById(R.id.tvfirstName)
        val late : TextView = itemView.findViewById(R.id.Late)
//        val name : TextView = itemView.findViewById(R.id.name)
//        val email : TextView = itemView.findViewById(R.id.emailid)
//        val needs : TextView = itemView.findViewById(R.id.needs)
//        val money : TextView = itemView.findViewById(R.id.money)




    }


}