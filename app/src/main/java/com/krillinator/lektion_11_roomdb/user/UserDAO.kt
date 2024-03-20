package com.krillinator.lektion_11_roomdb.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    // Define Queries & Abstract-Methods
    @Upsert
    fun insertOrUpdateUser(user: User)

    @Delete
    fun deleteUserById(user: User)

    // TODO - Philosophy of Queries and Functions
    // TODO - Check for GET annotation
    // TODO - SQL BONUS module
    // TODO - Database Inspector

    // TODO - 10:10

    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>

}
