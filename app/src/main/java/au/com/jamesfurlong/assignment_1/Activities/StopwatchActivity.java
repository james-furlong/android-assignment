package au.com.jamesfurlong.assignment_1.Activities;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import au.com.jamesfurlong.assignment_1.R;

public class StopwatchActivity extends AppCompatActivity {

    private Button worldButton;
    private Button alarmButton;
    private Button clockButton;
    private Button settingsButton;
    private Button[] buttonArray;
    private Chronometer chronometer;
    private boolean isStarted;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        setupActivity();
    }

    private void setupActivity() {
        worldButton = findViewById(R.id.world_button);
        alarmButton = findViewById(R.id.alarm_button);
        clockButton = findViewById(R.id.clock_button);
        settingsButton = findViewById(R.id.settings_button);
        stopButton = findViewById(R.id.stopwatch_stop_button);
        chronometer = findViewById(R.id.stopwatch_chronometer);
        buttonArray = new Button[] {worldButton, alarmButton, clockButton, settingsButton};
        isStarted = false;
        setListeners();
    }

    private void setListeners() {
        for (Button button : buttonArray) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i;
                    int tag = Integer.parseInt((String)view.getTag());
                    switch (tag) {
                        case 1: i = new Intent(StopwatchActivity.this, WorldActivity.class);
                            break;
                        case 2: i = new Intent(StopwatchActivity.this, AlarmActivity.class);
                            break;
                        case 3: i = new Intent(StopwatchActivity.this, MainActivity.class);
                            break;
                        case 5: i = new Intent(StopwatchActivity.this, SettingsActivity.class);
                            break;
                        default: return;
                    }
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });
    }

    public void startStopwatch(View view) {
        if (isStarted) {
            return;
        } else {
            chronometer.start();
            isStarted = true;
            stopButton.setText("Stop");
        }
    }

    public void stopClearStopwatch(View view) {
        if (isStarted) {
            chronometer.stop();
            stopButton.setText("Clear");
            isStarted = false;
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime());
            stopButton.setText("Stop");
        }
    }
}
