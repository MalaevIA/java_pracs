package com.example.pract_7;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pract_7.databinding.ActivityTimeAndDateBinding;

public class TimeAndDateActivity extends AppCompatActivity {
    private int hour;
    private int minute;
    private int year;
    private int month;
    private int day;
    private static final String DATADELETE = "Данные удалены";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_date);
        // Получение данных из Intent
        String name = getIntent().getStringExtra("name");

        // Пример: отобразить имя на TextView
        TextView nameTextView = findViewById(R.id.showFromMain);
        nameTextView.setText("Привет, " + name + "!");

        Button buttonChangeTime = findViewById(R.id.buttonTime);
        buttonChangeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // создание и отображение TimePickerDialog для отображения и установки времени
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimeAndDateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute)//поменяли  int hour, int minute
                    {
                        TextView timeTextView = findViewById(R.id.time);
                        timeTextView.setText("Время которое вы указали " + hour + " час " + minute + " минут");
                    }
                }, hour, minute, true);
                timePickerDialog.show();//показываем TimePickerDialog на активности
            }
        });

        Button buttonChangeDate = findViewById(R.id.buttonDate);
        buttonChangeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработчик "каледарь"
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        TextView dateTextView = findViewById(R.id.date);
                        dateTextView.setText("Дата которую вы указали " + year + " год " + month + " месяц "+ day +" число");
                    }
                };
                //создание и отобрадение календаря
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TimeAndDateActivity.this,
                        dateSetListener,
                        year,
                        month,
                        day);
                datePickerDialog.show();// показываем календарь
            }
        });




//        //создание кастомного диалога
        Button buttonDelete = findViewById(R.id.delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogCustom = new Dialog(TimeAndDateActivity.this);
                dialogCustom.setContentView(R.layout.custom_dialog);
                Button button1 = dialogCustom.findViewById(R.id.deleteAny);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView dateTextView = findViewById(R.id.date);
                        TextView timeTextView = findViewById(R.id.time);
                        dateTextView.setText(DATADELETE);
                        timeTextView.setText(DATADELETE);
                        dialogCustom.dismiss();
                    }
                });
                Button button2 = dialogCustom.findViewById(R.id.cancel);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogCustom.dismiss();
                    }
                });
                dialogCustom.show();
            }
        });


    }

}