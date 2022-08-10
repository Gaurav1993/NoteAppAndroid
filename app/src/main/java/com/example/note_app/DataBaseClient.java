package com.example.note_app;

import android.content.Context;

import androidx.room.Room;

public class DataBaseClient
{

    private Context mCtx;
    private static DataBaseClient mInstance;

    //our app database object
    private NoteDatabase appDatabase;





    private DataBaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, NoteDatabase.class, "note").allowMainThreadQueries().build();
    }


    public static synchronized DataBaseClient getInstance(Context mCtx)
    {
        if(mInstance==null)
        {
            mInstance =new DataBaseClient(mCtx);
        }
        return mInstance;
    }

    public NoteDatabase getAppDatabase() {
        return appDatabase;
    }



}
