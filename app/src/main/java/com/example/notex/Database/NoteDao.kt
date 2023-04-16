package com.example.notex.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notex.Models.Note


@Dao
 public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)
    @Query("select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("UPDATE notes_table set title = :title,note = :note WHERE id = :id")

    suspend fun update(id : Int?, title : String?, note : String?)



    }
