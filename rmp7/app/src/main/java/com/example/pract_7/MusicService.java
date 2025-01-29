package com.example.pract_7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        //инициализация медиаплеера
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //начинается воспроизведение
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Log.d(TAG,"Музыка началась");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d(TAG,"Музыка остановилась");
        }
    }

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;//Для сервисов бе привязки возвращаем нал
    }
}