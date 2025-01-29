package com.example.pr5.task2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr5.R;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>
{
    private List<State> states;

    public StateAdapter(List<State> states)
    {
        this.states = states;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        State state = states.get(position);
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());
        holder.flagView.setImageResource(state.getFlagResource());
    }

    @Override
    public int getItemCount()
    {
        return states.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameView, capitalView;
        ImageView flagView;
        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
            flagView = view.findViewById(R.id.flag);
        }
    }
}
