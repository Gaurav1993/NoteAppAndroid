package com.example.note_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Note> noteList;

    public NoteAdapter(Context mCtx, List<Note> noteList) {
        this.mCtx = mCtx;
        this.noteList = noteList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_note, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Note mNote = noteList.get(position);
        holder.text_tile.setText(mNote.getTitle());
        holder.txt_message.setText(mNote.getMessage());


    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder  {

        TextView txt_message, text_tile;

        public TasksViewHolder(View itemView) {
            super(itemView);

            text_tile = itemView.findViewById(R.id.text_tile);
            txt_message = itemView.findViewById(R.id.txt_message);



        }


//        @Override
//        public void onClick(View view) {
//            Task task = taskList.get(getAdapterPosition());
//
//            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
//            intent.putExtra("task", task);
//
//            mCtx.startActivity(intent);
//        }
    }
}
