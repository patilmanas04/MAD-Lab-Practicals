package com.example.taskmanager.modules;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical14.R;
import com.example.taskmanager.EditFacility;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    ArrayList<Note> dataset = new ArrayList<>();
    SQLHandler sqlHandler;
    Context context;
    FragmentManager fragmentManager;

    public NotesAdapter(SQLHandler sqlHandler, Context context, FragmentManager fragmentManager) {
        this.sqlHandler = sqlHandler;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public void sync() {
        sqlHandler.fetch(dataset);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView, modifiedView;
        Button editNote, deleteNote;

        public ViewHolder(View itemView) {
            super(itemView);
            this.titleView = itemView.findViewById(R.id.title);
            this.modifiedView = itemView.findViewById(R.id.modified);
            this.editNote = itemView.findViewById(R.id.editNote);
            this.deleteNote = itemView.findViewById(R.id.deleteNote);
        }

        public TextView getTitleView(){
            return this.titleView;
        }

        public TextView getModifiedView(){
            return this.modifiedView;
        }

        public Button getEditNote(){
            return this.editNote;
        }

        public Button getDeleteNote(){
            return this.deleteNote;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTitleView().setText(dataset.get(position).title);
        holder.getModifiedView().setText(dataset.get(position).datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        holder.getDeleteNote().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHandler.Delete(dataset.get(holder.getAdapterPosition()).title, dataset.get(holder.getAdapterPosition()).description);
                sync();
            }
        });

        holder.getEditNote().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EditFacility.class).putExtra("title", dataset.get(holder.getAdapterPosition()).title).putExtra("description", dataset.get(holder.getAdapterPosition()).description).putExtra("date", dataset.get(holder.getAdapterPosition()).datetime.toString()));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                ShowNote showNote = new ShowNote(dataset.get(holder.getAdapterPosition()).title, dataset.get(holder.getAdapterPosition()).description, dataset.get(holder.getAdapterPosition()).datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
                showNote.showNow(fragmentManager, "NoteEdit");
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
