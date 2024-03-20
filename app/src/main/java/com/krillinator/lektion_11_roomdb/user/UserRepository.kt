package com.krillinator.lektion_11_roomdb.user

import com.krillinator.lektion_11_roomdb.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/* What is a Repository?
*   Define/Invoke DAO Query Methods
*   CoroutineScope == Threads
* */

class UserRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {

    // SAVE USER
     fun insertOrUpdateUser(user: User) {
        myDatabase.userDao().insertOrUpdateUser(user)
    }

    // DELETE USER BY ID
    fun deleteUserById(user: User) {

        // TODO - FIND USER

        myDatabase.userDao().deleteUserById(user)
    }

     fun findAllUsers(): Flow<List<User>> {
        return myDatabase.userDao().findAllUsers()
    }

    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }

}