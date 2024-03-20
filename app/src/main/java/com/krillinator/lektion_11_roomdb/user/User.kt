package com.krillinator.lektion_11_roomdb.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User(
    var name: String,
    var age: Int
) {

    // TODO - Check for automatic Generation
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    override fun toString(): String {
        return "User(name='$name', age=$age, id=$id)"
    }


}