package com.khusainov.rinat.flickr.presentation.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.khusainov.rinat.flickr.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, HomeFragment.newInstance())
                    .commit();
        }
    }
}
