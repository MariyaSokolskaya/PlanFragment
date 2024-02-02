package com.example.planfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Button currentButton, completeButton;
    FrameLayout frameLayout;
    CurrentTasksFragment currentTasksFragment;
    CompleteTasksFragment completeTasksFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentButton = findViewById(R.id.current);
        completeButton = findViewById(R.id.complete);
        frameLayout = findViewById(R.id.container);

        currentTasksFragment = new CurrentTasksFragment();
        completeTasksFragment = new CompleteTasksFragment();
        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, currentTasksFragment);
        fragmentTransaction.commit();
        currentButton.setEnabled(false);

        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, currentTasksFragment);
                fragmentTransaction.commit();
                currentButton.setEnabled(false);
                completeButton.setEnabled(true);
            }
        });
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, completeTasksFragment);
                fragmentTransaction.commit();
                completeButton.setEnabled(false);
                currentButton.setEnabled(true);
            }
        });
    }
}