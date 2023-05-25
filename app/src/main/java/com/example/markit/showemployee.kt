package com.example.markit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.btn27.databinding.ActivityCountributorBinding
//import com.example.btn27.databinding.ActivityUserlistBinding
import com.example.markit.databinding.ActivityShowemployeeBinding
import com.google.firebase.database.*

class showemployee : AppCompatActivity() {

    private lateinit var binding: ActivityShowemployeeBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<employee>

//    val companyname =intent.getStringExtra("companyname")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityShowemployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<employee>()
        getUserData()

    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("vaishnaviCreations")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(employee::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = shoeemployeeadapter(userArrayList)


                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}