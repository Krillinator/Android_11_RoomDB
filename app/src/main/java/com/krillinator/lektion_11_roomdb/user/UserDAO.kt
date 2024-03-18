package com.krillinator.lektion_11_roomdb.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    // Define Queries & Abstract-Methods
    @Upsert
    fun insertOrUpdateUser(user: User)

    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>

}
