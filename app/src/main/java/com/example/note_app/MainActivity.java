package com.example.note_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText et_title,et_messgae;
    Button bt_save;
    RecyclerView recyclerView_get_note;
    String mTitle,mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_get_note = findViewById(R.id.recyclerView_Get_Note_DB);
        recyclerView_get_note.setLayoutManager(new LinearLayoutManager(this));


        et_title=findViewById(R.id.et_title);
        et_messgae=findViewById(R.id.et_messgae);
        bt_save=findViewById(R.id.bt_save);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mTitle=et_title.getText().toString();
                mMessage=et_messgae.getText().toString();

            if(mTitle.isEmpty())
            {
                et_title.setError("Please Fill Title");
            }
            else if(mMessage.isEmpty())
            {
                et_messgae.setError("Pelase Fill Message");
            }
            else
            {
                save();
            }

            }
        });








    }

    public void save()
    {
        Note note=new Note();
        note.setTitle(mTitle);
        note.setMessage(mMessage);
        DataBaseClient.getInstance(getApplicationContext()).getAppDatabase().getnotedao().insert(note);
        get_data();
    }


    public void get_data()
    {
        List<Note> taskList = DataBaseClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .getnotedao()
                .getListOfnote();

        NoteAdapter adapter = new NoteAdapter(MainActivity.this, taskList);
        recyclerView_get_note.setAdapter(adapter);
    }

}