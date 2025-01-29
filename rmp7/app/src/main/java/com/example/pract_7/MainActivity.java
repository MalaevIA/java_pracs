package com.example.pract_7;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.Name);
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        Button buttonOnDialog = findViewById(R.id.onDialog);
        buttonOnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //вызов диалогового окна через фрагмент
                String inputText = editText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("input_text", inputText);
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
                alertDialogFragment.setArguments(bundle);
                alertDialogFragment.show(getSupportFragmentManager(),"Проверка");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //останавливаем сервис при уничтажении активности
        Intent stopIntent = new Intent(this, MusicService.class);
        stopService(stopIntent);
    }
}