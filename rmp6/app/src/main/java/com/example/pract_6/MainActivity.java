package com.example.pract_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentOnDrawer = new Intent(this, DrawerActivity.class);
        // Устанавливаем основной XML макет для данной активности
        setContentView(R.layout.activity_main);

        // Настройка ActionBar для добавления кнопки "Назад" и изменения заголовка
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false); // не показываем кнопку "Назад" в ActionBar
            actionBar.setTitle("Главная"); // Устанавливаем заголовок ActionBar
            // Находим объект BottomNavigationView из макета по его ID
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

            // Устанавливаем слушатель для обработки нажатий на элементы BottomNavigationView
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Проверяем, какой пункт меню был нажат
                    if(item.getItemId() == R.id.cardio){
                        // Если выбран пункт "кардио"
                        actionBar.setTitle("Кардио");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerView, CardioFragment.class, null).commit();

                        return true;
                    } else if (item.getItemId() == R.id.strength) {
                        // Если выбран пункт "силовые"
                        actionBar.setTitle("Силовые");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerView, PowerFragment.class, null).commit();

                        return true;
                    } else if(item.getItemId() == R.id.stretching){
                        // Если выбран пункт "растяжка"
                        actionBar.setTitle("Растяжка");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerView, StretchingFragment.class, null).commit();

                        return true;
                    } else if (item.getItemId() == R.id.onDrawer) {
                        startActivity(intentOnDrawer);
                    }
                    // Если нажат элемент, который не обрабатывается, возвращаем false
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Создаем и наполняем меню из XML-файла `bottom_nav_menu`
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Обрабатываем нажатия на элементы меню ActionBar
        if (item.getItemId() == R.id.cardio){
            // Если выбран пункт "Кардио", показываем сообщение и возвращаем true
            Toast.makeText(MainActivity.this, "Кардио", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.strength){
            // Если выбран пункт "силовые", показываем сообщение
            Toast.makeText(MainActivity.this, "Силовые", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.stretching) {
            Toast.makeText(MainActivity.this, "Растяжка", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.onDrawer) {
            // Если выбран пункт, запускающий DrawerActivity, создаем Intent и запускаем новую активность
            Intent intentOnDrawer = new Intent(this, DrawerActivity.class);
            startActivity(intentOnDrawer);
        }
        // Если элемент не обработан, возвращаем результат вызова родительского метода
        return super.onOptionsItemSelected(item);
    }
}
