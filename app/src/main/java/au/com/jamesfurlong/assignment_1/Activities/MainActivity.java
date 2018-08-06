package au.com.jamesfurlong.assignment_1.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import au.com.jamesfurlong.assignment_1.R;

public class MainActivity extends AppCompatActivity {

    private Button worldButton;
    private Button alarmButton;
    private Button stopwatchButton;
    private Button settingsButton;
    private Button[] buttonArray;
    private BroadcastReceiver broadcastReceiver;
    private String time;
    private TextView hours;
    private TextView minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActivity();
    }

    private void setupActivity() {
        worldButton = findViewById(R.id.world_button);
        alarmButton = findViewById(R.id.alarm_button);
        stopwatchButton = findViewById(R.id.stopwatch_button);
        settingsButton = findViewById(R.id.settings_button);
        hours = findViewById(R.id.time_number_hours);
        minutes = findViewById(R.id.time_number_minutes);
        buttonArray = new Button[] {worldButton, alarmButton, stopwatchButton, settingsButton};
        setListeners();
        setCurrentTime();
    }

    private void setListeners() {
        for (Button button : buttonArray) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i;
                    int tag = Integer.parseInt((String)view.getTag());
                    switch (tag) {
                        case 1: i = new Intent(MainActivity.this, WorldActivity.class);
                            break;
                        case 2: i = new Intent(MainActivity.this, AlarmActivity.class);
                            break;
                        case 4: i = new Intent(MainActivity.this, StopwatchActivity.class);
                            break;
                        case 5: i = new Intent(MainActivity.this, SettingsActivity.class);
                            break;
                        default: return;
                    }
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    private void setCurrentTime() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        time = simpleDateFormat.format(new Date());
        String[] timeArray = time.split("(?!^)");
        hours.setText(String.format("%1$s%2$s", timeArray[0], timeArray[1]));
        minutes.setText(String.format("%1$s%2$s", timeArray[3], timeArray[4]));
    }

    @Override
    public void onStart() {
        super.onStart();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0) {
                    time = simpleDateFormat.format(new Date());
                    String[] timeArray = time.split("(?!^)");
                    hours.setText(String.format("%1$s%2$s", timeArray[0], timeArray[1]));
                    minutes.setText(String.format("%1$s%2$s", timeArray[3], timeArray[4]));
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    public void onStop() {
        super.onStop();
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}
