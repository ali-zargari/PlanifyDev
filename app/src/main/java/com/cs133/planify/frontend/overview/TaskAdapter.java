package com.cs133.planify.frontend.overview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs133.planify.R;
import com.cs133.planify.backend.Task;
import com.cs133.planify.backend.ToDoItem;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> taskList;

    public TaskAdapter(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.bindTask(task);

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView taskDescriptionTextView;
        private TextView taskDateTextView;
        private CheckBox taskCheckBox;
        private TextView taskNameTextView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCheckBox = itemView.findViewById(R.id.todoCheckBox);
            taskDescriptionTextView = itemView.findViewById(R.id.todoText);
            taskDateTextView = itemView.findViewById(R.id.todoDate);
        }

        public void bindTask(Task task) {
            taskDescriptionTextView.setText(task.getDescription());
            taskDateTextView.setText(task.getDate());
            taskCheckBox.setChecked(task.getCompletion());
            taskNameTextView.setText(task.getName());

        }
    }
}