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

class shoeemployeeadapter(private val userList : ArrayList<employee>) : RecyclerView.Adapter<shoeemployeeadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
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
        holder.username.text = currentitem.username
//        holder.needs.text = currentitem.needs
        holder.money.text = currentitem.money
        holder.count.text = currentitem.count
        holder.total.text = currentitem.total



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
        val username : TextView = itemView.findViewById(R.id.username)
        val count : TextView = itemView.findViewById(R.id.count)
        val total : TextView = itemView.findViewById(R.id.total)
        val money : TextView = itemView.findViewById(R.id.money)





    }


}