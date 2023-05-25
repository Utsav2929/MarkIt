package com.example.markit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.R

class notificationadapter(private val userList : ArrayList<notificationadd>) : RecyclerView.Adapter<notificationadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_notification,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

//        holder.cname.text = currentitem.cname
//if (currentitem.name=)


        holder.date.text = currentitem.date
        holder.notification.text = currentitem.notification



// get reference to button


    }

    override fun getItemCount(): Int {

        return userList.size
    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //        val cname : TextView = itemView.findViewById(R.id.cname)
        val date : TextView = itemView.findViewById(R.id.date1)
        val notification : TextView = itemView.findViewById(R.id.notification1)





    }


}