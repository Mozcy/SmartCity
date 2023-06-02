package com.example.smartcity.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.R;

import java.util.Locale;

public class TTS extends UtteranceProgressListener {
    private Context context;
    private View view;
    private PopupWindow window;
    private TextToSpeech textToSpeech;

    public TTS(Context context, View view) {
        this.context = context;
        this.view = view;
        textToSpeech = new TextToSpeech(context, status -> {
            if (status == textToSpeech.SUCCESS) {
                textToSpeech.setPitch(1.f);
                textToSpeech.setSpeechRate(1.f);
                textToSpeech.setLanguage(Locale.CHINESE);
            } else {
                Toast.makeText(context, "系统不支持语音播报", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void speak(String t, String c) {
        if (window != null) {
            window.dismiss();
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_window, null);
        TextView tv = inflate.findViewById(R.id.tv);
        ImageView iv = inflate.findViewById(R.id.iv);
        window = new PopupWindow(inflate, getWidth(context) / 2, 110);
        window.setOutsideTouchable(false);
        window.showAtLocation(view, Gravity.CENTER, -getWidth(context) / 5, 0);
        textToSpeech.speak(c, TextToSpeech.QUEUE_ADD, null, "this");
        tv.setText("播报中: " + t);
        tv.setSelected(true);
        iv.setOnClickListener(v -> stop());
        textToSpeech.setOnUtteranceProgressListener(this);
    }

    public void stop() {
        if (window != null) {
            window.dismiss();
        }
        if (textToSpeech.isSpeaking()) {
            textToSpeech.stop();
        }
    }

    @Override
    public void onStart(String utteranceId) {
    }

    @Override
    public void onDone(String utteranceId) {
        new Handler(Looper.getMainLooper()).post(() -> stop());
    }

    @Override
    public void onError(String utteranceId) {

    }

    public static int getWidth(Context c) {
        WindowManager wm = (WindowManager) c.getSystemService(c.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return display.getWidth();
    }
}
