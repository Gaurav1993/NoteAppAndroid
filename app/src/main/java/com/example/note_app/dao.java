package com.example.note_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface dao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void  insert(Note note);

    @Query("SELECT * from note")
    List<Note> getListOfnote();

    @Update
    public void update(Note note);


    @Query("DELETE FROM note WHERE id = id")
    public void delete();
}
