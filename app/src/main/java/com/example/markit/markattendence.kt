package com.example.markit

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityMarkattendenceBinding
import com.example.markit.databinding.ActivityRegisteremployeeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*


class markattendence : AppCompatActivity() {
    private lateinit var binding : ActivityMarkattendenceBinding
    private lateinit var database : DatabaseReference

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarkattendenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username=""


        val filename ="companyname.txt"
        if(filename.toString()!=null ) {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(filename)
            var inputStreamReader  = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            //Displaying data on EditText
            username = stringBuilder.toString()

//                 binding.currentname.text = username.toString()

        }
//        binding.

        binding.submitbutton.setOnClickListener {
            val date = binding.date.text.toString()

            var late = binding.late.text.toString().toDouble()
            var cname = binding.cnameentry.text.toString()

//            val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
//            val currentDate: String = simpleDateFormat.format(Date())



//            database = FirebaseDatabase.getInstance().getReference(username.toString())
//            val attendence = attendence(cname,currentDate)



            database = FirebaseDatabase.getInstance().getReference(username.toString())
            database.child(cname).get().addOnSuccessListener {
//                cname=cname.uppercase()
                if (it.exists()){
                    var name = it.child("name").value.toString()
                    var email = it.child("email").value.toString()
                    var mobile = it.child("mobile").value.toString()

                    var count = it.child("count").value.toString().toDouble()
                    var total = it.child("total").value.toString().toDouble()
                    var money = it.child("money").value.toString().toDouble()

                    var late1 = it.child("late").value.toString().toDouble()
                    var type = it.child("type").value.toString()

                    var working = it.child("working").value.toString().toDouble()
                    late1+= late
                    count= count + 1
                    val temp=working*60
                    val tmp1=money/temp
                    val ttl=tmp1*late

                    total+= money-ttl





                        database = FirebaseDatabase.getInstance().getReference(username.toString())
                        val employee =employee(cname,name,email, mobile, count.toString(),money.toString(),total.toString(),type, working.toString(),late1.toString())
                    database.child(cname).setValue(employee).addOnSuccessListener {




                        database = FirebaseDatabase.getInstance().getReference(cname)
                        val data =date(date,name,late.toString())
                        database.child(date.toString()).setValue(data).addOnSuccessListener {


                            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


                        }.addOnFailureListener{

                            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

                        }


                            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


                        }.addOnFailureListener{

                            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

                        }
                    Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()


                }else{

                    Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


                }

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }

}


        binding.submitbutton2.setOnClickListener {
            var date = binding.date.text.toString()+"Half Day"

            var late= binding.late.text.toString().toDouble()
            var cname = binding.cnameentry.text.toString()

//            val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
//            val currentDate: String = simpleDateFormat.format(Date())



//            database = FirebaseDatabase.getInstance().getReference(username.toString())
//            val attendence = attendence(cname,currentDate)



            database = FirebaseDatabase.getInstance().getReference(username.toString())
            database.child(cname).get().addOnSuccessListener {
//                cname=cname.uppercase()
                if (it.exists()){
                        var name = it.child("name").value.toString()
                        var email = it.child("email").value.toString()
                        var mobile = it.child("mobile").value.toString()

                        var count :Double = it.child("count").value.toString().toDouble()
                        var total :Double= it.child("total").value.toString().toDouble()
                        var money :Double= it.child("money").value.toString().toDouble()

                    var late1 = it.child("late").value.toString().toDouble()
                    var working = it.child("working").value.toString().toDouble()
                        var type = it.child("type").value.toString()
                        count +=   0.50
                            val m =money/2
//

                    late1+= late
                    val temp=working*60
                    val tmp1=money/temp
                    val ttl=tmp1*late

                    total+= m-ttl


                        database = FirebaseDatabase.getInstance().getReference(username.toString())
                        val employee =employee(cname,name,email, mobile, count.toString(),money.toString(),total.toString(),type,working.toString(),late1.toString())
                        database.child(cname).setValue(employee).addOnSuccessListener {




                            database = FirebaseDatabase.getInstance().getReference(cname)
                            val data =date(date,cname,late.toString())
                            database.child(date.toString()).setValue(data).addOnSuccessListener {


                                Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


                            }.addOnFailureListener{

                                Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

                            }


                            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


                        }.addOnFailureListener{

                            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

                        }
                        Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()


                }else{

                    Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


                }

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }

        }
//            database.child(cname).setValue(attendence).addOnSuccessListener {
//                Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
//                val a = Intent(this, home::class.java)
//                startActivity(a)
//
//
//            }





    }


}


