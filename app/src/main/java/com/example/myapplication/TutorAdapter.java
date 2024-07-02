package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Tutor;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private List<Tutor> tutors;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Tutor tutor);
    }

    public TutorAdapter(List<Tutor> tutors, OnItemClickListener listener) {
        this.tutors = tutors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {
        Tutor tutor = tutors.get(position);
        holder.bind(tutor, listener);
    }

    @Override
    public int getItemCount() {
        return tutors.size();
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTutorName;
        public TextView textViewTutorEmail;
        public TextView textViewTutorDescription;
        public TextView textViewTutorRating;
        public TextView textViewTutorPrice;
        public TextView textViewTutorCountry;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTutorName = itemView.findViewById(R.id.textViewTutorName);
            textViewTutorEmail = itemView.findViewById(R.id.textViewTutorEmail);
            textViewTutorDescription = itemView.findViewById(R.id.textViewTutorDescription);
            textViewTutorRating = itemView.findViewById(R.id.textViewTutorRating);
            textViewTutorPrice = itemView.findViewById(R.id.textViewTutorPrice);
            textViewTutorCountry = itemView.findViewById(R.id.textViewTutorCountry);
        }

        public void bind(final Tutor tutor, final OnItemClickListener listener) {
            textViewTutorName.setText(tutor.getName());
            textViewTutorEmail.setText(tutor.getEmail());
            textViewTutorDescription.setText(tutor.getDescription());
            textViewTutorRating.setText(String.valueOf(tutor.getRating()));
            textViewTutorPrice.setText(tutor.getPrice());
            textViewTutorCountry.setText(tutor.getCountryOfBirth());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(tutor);
                }
            });
        }
    }
}
