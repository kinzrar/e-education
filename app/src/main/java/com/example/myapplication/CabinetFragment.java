package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;

public class CabinetFragment extends Fragment {
//test
    private ImageView profileImage;
    private TextView profileName;
    private Button editProfileButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cabinet, container, false);

        profileImage = view.findViewById(R.id.profile_image);
        profileName = view.findViewById(R.id.profile_name);
        editProfileButton = view.findViewById(R.id.edit_profile_button);

        // Загрузка изображения профиля (временно используем заглушку)
        Glide.with(this).load(R.drawable.ic_profile_placeholder).into(profileImage);

        // Установка временного имени профиля
        profileName.setText("Ваше имя");

        // Обработчик нажатия на кнопку редактирования профиля
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
