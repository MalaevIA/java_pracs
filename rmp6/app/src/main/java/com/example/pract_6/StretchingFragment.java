package com.example.pract_6;
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

public class StretchingFragment extends Fragment {

    private TextView stretchingTimerText;
    private Button startStretchingTimerButton;
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private long timeLeftInMillis = 300000; // 5 минут в миллисекундах

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stretching, container, false);

        stretchingTimerText = view.findViewById(R.id.stretchingTimerText);
        startStretchingTimerButton = view.findViewById(R.id.startStretchingTimerButton);

        startStretchingTimerButton.setOnClickListener(v -> {
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
                startStretchingTimerButton.setText("Начать растяжку");
            }
        }.start();

        timerRunning = true;
        startStretchingTimerButton.setText("Пауза");
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        startStretchingTimerButton.setText("Продолжить");
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        stretchingTimerText.setText(timeFormatted);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
