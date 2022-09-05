package com.example.formtask.Model
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao


//Dao is where the method used for accessing the db is contained
interface UserDao {
    //this help to remove dupilcates
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM address_table ORDER BY id ASC" )
    fun readAllData(): LiveData<List<User>>

}