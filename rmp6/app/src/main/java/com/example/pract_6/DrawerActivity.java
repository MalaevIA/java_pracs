package com.example.pract_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    // DrawerLayout отвечает за панель навигации
    private DrawerLayout drawer;

    // ActionBarDrawerToggle используется для синхронизации состояния панели навигации и значка меню
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Включаем поддержку режима Edge-to-Edge, который позволяет элементам интерфейса доходить до краев экрана
        EdgeToEdge.enable(this);

        // Устанавливаем XML-макет для активности
        setContentView(R.layout.activity_drawer);

        // Находим DrawerLayout из XML-макета по его ID
        drawer = findViewById(R.id.drawer_layout);

        // Создаем ActionBarDrawerToggle, который синхронизирует значок меню и DrawerLayout
        toggle = new ActionBarDrawerToggle(DrawerActivity.this, drawer, R.string.app_name, R.string.app_name);

        // Добавляем ActionBarDrawerToggle как слушатель к DrawerLayout
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }

        // Синхронизируем состояние значка меню с состоянием панели навигации
        toggle.syncState();

        // Включаем кнопку "Назад" (стрелку) на ActionBar для взаимодействия с DrawerLayout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Инициализация NavigationView для боковой панели навигации
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Установка слушателя для обработки нажатий на элементы боковой панели
        navigationView.setNavigationItemSelectedListener(item -> {

            // Проверяем, выбран ли элемент с ID R.id.onTrain
            if(item.getItemId() == R.id.onTrain){

                // Создаем Intent для перехода на MainActivity
                Intent onTrainIntent = new Intent(this, MainActivity.class);

                // Запускаем MainActivity
                startActivity(onTrainIntent);
            }
            if(item.getItemId() == R.id.nav_time){
                TextView textView = findViewById(R.id.textView);
                textView.setText(R.string.plan);
            }
            if(item.getItemId() == R.id.nav_food){
                TextView textView = findViewById(R.id.textView);
                textView.setText(R.string.food);
            }
            if(item.getItemId() == R.id.nav_meditation){
                TextView textView = findViewById(R.id.textView);
                textView.setText(R.string.meditation);
            }


            // Закрытие боковой панели навигации после выбора элемента
            drawer.closeDrawers();

            // Возвращаем true, чтобы указать, что обработка события завершена
            return true;
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Проверяем, был ли выбран элемент меню, связанный с ActionBarDrawerToggle
        if (toggle.onOptionsItemSelected(item)) {
            return true; // Если выбран, обработка завершена
        }
        // Если элемент не связан с ActionBarDrawerToggle, выполняется стандартная обработка
        return super.onOptionsItemSelected(item);
    }
}
