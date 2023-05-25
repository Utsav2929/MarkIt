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

class moneydetailsadapter(private val userList : ArrayList<money>) : RecyclerView.Adapter<moneydetailsadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_money,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

//        holder.cname.text = currentitem.cname
//if (currentitem.name=)

        holder.username.text = currentitem.username

        holder.date.text = currentitem.date
        holder.money.text = currentitem.money



// get reference to button


    }

    override fun getItemCount(): Int {

        return userList.size
    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //        val cname : TextView = itemView.findViewById(R.id.cname)
        val username : TextView = itemView.findViewById(R.id.tvfirstName)
        val date : TextView = itemView.findViewById(R.id.date)
        val money : TextView = itemView.findViewById(R.id.money)





    }


}