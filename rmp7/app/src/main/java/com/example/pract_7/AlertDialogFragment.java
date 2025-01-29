package com.example.pract_7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class AlertDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Получить данные из аргументов
        String message = "";
        if (getArguments() != null) {
            message = getArguments().getString("input_text", "");
        }
        //создание строител диалоговых окон AlertDialog для отбражения предупреждений
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Подтверждение");
        builder.setMessage("Вы уверены, что вас зовут "+message+" ?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        String finalMessage = message;
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), TimeAndDateActivity.class);
                intent.putExtra("name", finalMessage);
                startActivity(intent);
                // обработка подтверждения
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // обработка отмены
                dialogInterface.dismiss();
            }
        });
        return builder.create();
    }
}