package com.example.markit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.R

class userlistadapter(private val userList : ArrayList<user>) : RecyclerView.Adapter<userlistadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_list,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

//        holder.cname.text = currentitem.cname
//if (currentitem.name=)
        holder.email.text = currentitem.email

        holder.mobile.text = currentitem.mobile
        holder.name.text = currentitem.name
//
//
//

// get reference to button


    }

    override fun getItemCount(): Int {

        return userList.size
    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //        val cname : TextView = itemView.findViewById(R.id.cname)
        val name : TextView = itemView.findViewById(R.id.tvfirstName)
        val mobile : TextView = itemView.findViewById(R.id.mobile)
        val email : TextView = itemView.findViewById(R.id.emailid)





    }


}