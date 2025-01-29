package com.example.pract_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CardioFragment extends Fragment {

    private TextView timerText;
    private Button startTimerButton;
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private long timeLeftInMillis = 600000; // Время в миллисекундах (10 минут)

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardio, container, false);

        timerText = view.findViewById(R.id.timerText);
        startTimerButton = view.findViewById(R.id.startTimerButton);

        startTimerButton.setOnClickListener(v -> {
            if (timerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        updateTimerText();
        return view;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                startTimerButton.setText("Начать тренировку");
            }
        }.start();

        timerRunning = true;
        startTimerButton.setText("Пауза");
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        startTimerButton.setText("Продолжить");
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        timerText.setText(timeFormatted);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
