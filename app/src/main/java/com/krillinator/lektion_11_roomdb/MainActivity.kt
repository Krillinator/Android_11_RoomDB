package com.krillinator.lektion_11_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.krillinator.lektion_11_roomdb.databinding.ActivityMainBinding
import com.krillinator.lektion_11_roomdb.user.User
import com.krillinator.lektion_11_roomdb.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Variables
        val db = MyDatabase.getInstance(applicationContext)
        val userRepository = UserRepository(db, lifecycleScope)

        // Run Logic
        applicationContext.getDatabasePath("my-app-db").delete()
        println(applicationContext.getDatabasePath("my-app-db"))

        binding.btnSubmitUser.setOnClickListener {
            userRepository.performDatabaseOperation(Dispatchers.IO) {
                val user = User("Benny", 15)
                userRepository.insertOrUpdateUser(user)
            }
        }

        // Delete User
        binding.btnDeleteUser.setOnClickListener {
            userRepository.performDatabaseOperation(Dispatchers.IO) {
                userRepository.deleteUserById(1)
            }
        }

        binding.tvDbOperation.setOnClickListener {
            userRepository.performDatabaseOperation(Dispatchers.Main) {
                userRepository.findAllUsers().collect {
                    println(it)
                }
            }
        }





    }
}