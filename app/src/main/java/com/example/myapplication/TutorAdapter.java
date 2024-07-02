package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Tutor;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private Context context;
    private List<Tutor> tutors;

    public TutorAdapter(Context context, List<Tutor> tutors) {
        this.context = context;
        this.tutors = tutors;
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
        holder.textViewTutorName.setText(tutor.getName());
        holder.textViewTutorEmail.setText(tutor.getEmail());
        holder.textViewTutorDescription.setText(tutor.getDescription());
        holder.textViewTutorCountry.setText(tutor.getCountryOfBirth());
        holder.textViewTutorRating.setText(String.valueOf(tutor.getRating()));
        holder.textViewTutorPrice.setText(tutor.getPrice());
        holder.textViewTutorReviews.setText(String.valueOf(tutor.getReviews()));
        holder.textViewTutorLessons.setText(String.valueOf(tutor.getLessons()));
        holder.textViewTutorExperience.setText(String.valueOf(tutor.getExperience()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TutorDetailActivity.class);
            intent.putExtra("tutor", tutor);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tutors.size();
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTutorName;
        TextView textViewTutorEmail;
        TextView textViewTutorDescription;
        TextView textViewTutorCountry;
        TextView textViewTutorRating;
        TextView textViewTutorPrice;
        TextView textViewTutorReviews;
        TextView textViewTutorLessons;
        TextView textViewTutorExperience;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTutorName = itemView.findViewById(R.id.textViewTutorName);
            textViewTutorEmail = itemView.findViewById(R.id.textViewTutorEmail);
            textViewTutorDescription = itemView.findViewById(R.id.textViewTutorDescription);
            textViewTutorCountry = itemView.findViewById(R.id.textViewTutorCountry);
            textViewTutorRating = itemView.findViewById(R.id.textViewTutorRating);
            textViewTutorPrice = itemView.findViewById(R.id.textViewTutorPrice);
            textViewTutorReviews = itemView.findViewById(R.id.textViewTutorReviews);
            textViewTutorLessons = itemView.findViewById(R.id.textViewTutorLessons);
            textViewTutorExperience = itemView.findViewById(R.id.textViewTutorExperience);
        }
    }
}
