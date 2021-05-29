package com.vientamthuong.learningfragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Button button = findViewById(R.id.buttonMain);
        button.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("a");
            fragmentA.changeText("DSFSsdfsdf");
        });
    }

    private void init() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putString("name", "Day la A");
        fragmentA.setArguments(bundle);
        fragmentTransaction.add(R.id.f1, fragmentA,"a");

        FragmentB fragmentB = new FragmentB();
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", "Day la B");
        fragmentB.setArguments(bundle2);
        fragmentTransaction.add(R.id.f2, fragmentB,"b");

        fragmentTransaction.commit();
    }
}