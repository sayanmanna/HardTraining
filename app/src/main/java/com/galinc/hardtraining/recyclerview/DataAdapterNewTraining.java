package com.galinc.hardtraining.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galinc.hardtraining.R;
import com.galinc.hardtraining.itility.ListTraining;

import java.util.List;

public class DataAdapterNewTraining extends RecyclerView.Adapter<DataAdapterNewTraining.ViewHolder> {
    private LayoutInflater inflater;
    private List<ListTraining> trainings;

    public DataAdapterNewTraining(LayoutInflater inflater, List<ListTraining> trainings) {
        this.inflater = inflater;
        this.trainings = trainings;
    }

    @NonNull
    @Override
    public DataAdapterNewTraining.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.list_item_training, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterNewTraining.ViewHolder holder, int position) {
        ListTraining training = trainings.get(position);

        holder.nameView.setText(String.format(inflater.getContext().getResources().getString(R.string.exercise_string),training.getName()));
        holder.numberofitrView.setText(String.format(inflater.getContext().getResources().getString(R.string.itr_string),training.getNumberofitr()));
        holder.weightView.setText(String.format(inflater.getContext().getResources().getString(R.string.weight_string),training.getWeight()));


    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView imageView;
        final TextView nameView, numberofitrView,weightView;
        ViewHolder(View view){
            super(view);
            //imageView = view.findViewById(R.id.image);
            nameView =  view.findViewById(R.id.namefit);
            numberofitrView =  view.findViewById(R.id.numberofitr);
            weightView = view.findViewById(R.id.weight);

        }
    }
}
