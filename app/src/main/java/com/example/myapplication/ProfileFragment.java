package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class ProfileFragment extends Fragment {

    private ImageView profileImage;
    private TextView profileName;
    private Button editProfileButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileImage = view.findViewById(R.id.profile_image);
        profileName = view.findViewById(R.id.profile_name);
        editProfileButton = view.findViewById(R.id.edit_profile_button);

        // Загрузка изображения профиля (временно используем заглушку)
        Glide.with(this).load(R.drawable.ic_profile_placeholder).into(profileImage);

        // Установка временного имени профиля
        profileName.setText("Ваше имя");

        // Обработчик нажатия на кнопку редактирования профиля
        editProfileButton.setOnClickListener(v -> {
            Log.d("ProfileFragment", "Edit Profile Button Clicked"); // логирование
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
