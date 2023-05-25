package com.example.markit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.markit.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    private lateinit var database : DatabaseReference

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)
var type=""
var username1=""
//        val headerView : HeaderView = findViewById(R.id.nav_view)
         username1 =intent.getStringExtra("username").toString()
        val companyname =intent.getStringExtra("companyname")
//        val email =intent.getStringExtra("email")
        val headerView : View = navView.getHeaderView(0)
        val navUsername : TextView = headerView.findViewById(R.id.username)
        val navUserEmail : TextView = headerView.findViewById(R.id.useremailid)

        database = FirebaseDatabase.getInstance().getReference(companyname.toString())
        database.child(username1.toString()).get().addOnSuccessListener{

            if (it.exists()) {
//
                val firstname = it.child("name").value.toString()
                 type = it.child("type").value.toString()

                val email = it.child("email").value.toString()

                 username1 = it.child("username").value.toString()
                Toast.makeText(this, "Successfuly Read", Toast.LENGTH_SHORT).show()

                navUsername.text = username1.toString()
                navUserEmail.text = email.toString()
            }else{


            database = FirebaseDatabase.getInstance().getReference("User")
            database.child(companyname.toString()).get().addOnSuccessListener{

                if (it.exists()) {
//
                    val firstname = it.child("name").value.toString()
                    type = it.child("type").value.toString()

                    val email = it.child("email").value.toString()
                    Toast.makeText(this, "Successfuly Read2", Toast.LENGTH_SHORT).show()

                    navUsername.text = companyname.toString()
                    navUserEmail.text = email.toString()
                }

            }}

        }.addOnFailureListener {



        }
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this,"Home Page",Toast.LENGTH_SHORT).show()

                }

                R.id.nav_setting -> {
                    Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()

                }
                R.id.nav_share -> {
                    Toast.makeText(this,"SHARE APP",Toast.LENGTH_SHORT).show()

                }
                R.id.nav_a_d -> {
                        if(type=="owner") {
                            val Intent = Intent(this, forattendence::class.java)

                            startActivity(Intent)
                        }
                    else {
                            val Intent = Intent(this, attendencedetails::class.java)
                                .putExtra("username", username1)

                            startActivity(Intent)
                        }
                }
                R.id.nav_aboutyou -> {
                    if(type!="owner") {
                        val Intent = Intent(this, aboutyou::class.java)

                        startActivity(Intent)
                    }
                    else{

                        Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.nav_se -> {
                    if(type=="owner") {
                        val Intent = Intent(this, showemployee::class.java)
                            .putExtra("companyname", companyname)
                        startActivity(Intent)
                    }
                    else{

                        Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.nav_pm -> {

                    if(type=="owner") {
                        val Intent = Intent(this, paymoney::class.java)

                        startActivity(Intent)
                    }
                    else{

                        Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.nav_re -> {

                    if(type!="employee") {
                        val Intent = Intent(this, Registeremployee::class.java)

                        startActivity(Intent)
                    }
                    else{

                        Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.nav_admin -> {
                    val Intent = Intent(this, adminlogin::class.java)

                    startActivity(Intent)
                }
                R.id.nav_ma -> {       if(type!="employee") {
                    val Intent = Intent(this, markattendence::class.java)

                    startActivity(Intent)
                }
                else{

                    Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                }
                }
                R.id.nav_ad-> {
                    val Intent = Intent(this, aboutdeveloper::class.java)

                    startActivity(Intent)
                }
                R.id.nav_sn-> {
                    val Intent = Intent(this, notification::class.java)
                        .putExtra("username",companyname)
                    startActivity(Intent)
                }

                R.id.nav_logout -> {
                    auth = FirebaseAuth.getInstance()
                    auth.signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                R.id.nav_cu -> {
                    val Intent = Intent(this, contactus::class.java)

                    startActivity(Intent)
                }
//                R.id.nav_pm -> {
//                    val Intent = Intent(this, paymoney::class.java)
//
//                    startActivity(Intent)
//                }
                R.id.nav_md -> {
                    if(type=="owner") {
                        val Intent = Intent(this, formoney::class.java)

                        startActivity(Intent)
                    }
                    else {
                        val Intent = Intent(this, moneydetails::class.java)
                            .putExtra("username", username1)

                        startActivity(Intent)
                    }
                }
                R.id.nav_an -> {      if(type=="owner") {
                    val Intent = Intent(this, addnotification::class.java)
                        .putExtra("username", companyname)
                    startActivity(Intent)
                }
                else{

                    Toast.makeText(this,"You Cant't move to this section",Toast.LENGTH_SHORT).show()
                }}
                R.id.nav_rate_us -> {
                    val Intent = Intent(this, Rateus::class.java)
                        .putExtra("username",username1)
                    startActivity(Intent)
                }

            }

            true


        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){

            return true


        }
        return super.onOptionsItemSelected(item)
    }

}