package com.example.weatherapp.app;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class FragmentUtils {
    public static NavController findNavController(@NonNull Fragment fragment) {

        View view = fragment.getView();
        if (view != null) {
            return Navigation.findNavController(view);
        } else {
            return null;
        }
    }
}
