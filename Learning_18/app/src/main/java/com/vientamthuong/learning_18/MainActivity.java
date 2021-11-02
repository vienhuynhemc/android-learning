package com.vientamthuong.learning_18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_1) {
                    Toast.makeText(MainActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.menu_2) {
                    Toast.makeText(MainActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
                }
                return true;
            });
            popupMenu.show();
        });

        registerForContextMenu(button);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_1) {
            Toast.makeText(MainActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_2) {
            Toast.makeText(MainActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.setHeaderIcon(R.drawable.ic_launcher_background);
        menu.setHeaderTitle("sdfsdf");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_1) {
            Toast.makeText(MainActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_2) {
            Toast.makeText(MainActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}