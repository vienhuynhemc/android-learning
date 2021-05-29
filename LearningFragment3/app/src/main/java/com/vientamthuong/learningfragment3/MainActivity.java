package com.vientamthuong.learningfragment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addA = findViewById(R.id.addA);
        Button rA = findViewById(R.id.rA);
        Button addB = findViewById(R.id.addB);
        Button rB = findViewById(R.id.rB);
        Button addC = findViewById(R.id.addC);
        Button rC = findViewById(R.id.rC);
        Button back = findViewById(R.id.back);
        Button popA = findViewById(R.id.popA);

        addA.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.f1, new FA(), "FA");
            fragmentTransaction.commit();
        });
        addB.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.f1, new FB(), "FB");
            fragmentTransaction.commit();
        });
        addC.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.f1, new FC(), "FC");
            fragmentTransaction.commit();
        });

        rA.setOnClickListener(v -> {
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            FA a = (FA) getSupportFragmentManager().findFragmentByTag("FA");
            if (a != null) {
                f.remove(a);
            }
            f.commit();
        });
        rB.setOnClickListener(v -> {
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            FB a = (FB) getSupportFragmentManager().findFragmentByTag("FB");
            if (a != null) {
                f.remove(a);
            }
            f.commit();
        });
        rC.setOnClickListener(v -> {
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            FC a = (FC) getSupportFragmentManager().findFragmentByTag("FC");
            if (a != null) {
                f.remove(a);
            }
            f.commit();
        });
        back.setOnClickListener(v -> {
            List<Fragment> l = getSupportFragmentManager().getFragments();
            if (l.size() > 0) {
                FragmentTransaction f = getSupportFragmentManager().beginTransaction();
                f.remove(l.get(l.size() - 1));
                f.commit();
            }
        });
        popA.setOnClickListener(v -> {
            List<Fragment> l = getSupportFragmentManager().getFragments();
            while (l.size() > 0) {
                Fragment fragment = l.get(l.size() - 1);
                if (fragment.getTag().equals("FA")) {
                    break;
                } else {
                    FragmentTransaction f = getSupportFragmentManager().beginTransaction();
                    f.remove(l.get(l.size() - 1));
                    f.commit();
                    l.remove(l.size()-1);
                }
            }
        });

    }
}