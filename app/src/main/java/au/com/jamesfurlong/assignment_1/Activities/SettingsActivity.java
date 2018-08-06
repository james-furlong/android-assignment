package au.com.jamesfurlong.assignment_1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import au.com.jamesfurlong.assignment_1.R;

public class SettingsActivity extends AppCompatActivity {

    private Button worldButton;
    private Button alarmButton;
    private Button clockButton;
    private Button stopwatchButton;
    private Button[] buttonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupActivity();
    }

    private void setupActivity() {
        worldButton = findViewById(R.id.world_button);
        alarmButton = findViewById(R.id.alarm_button);
        clockButton = findViewById(R.id.clock_button);
        stopwatchButton = findViewById(R.id.stopwatch_button);
        buttonArray = new Button[] {worldButton, alarmButton, clockButton, stopwatchButton};
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
                        case 1: i = new Intent(SettingsActivity.this, WorldActivity.class);
                            break;
                        case 2: i = new Intent(SettingsActivity.this, AlarmActivity.class);
                            break;
                        case 4: i = new Intent(SettingsActivity.this, StopwatchActivity.class);
                            break;
                        case 3: i = new Intent(SettingsActivity.this, MainActivity.class);
                            break;
                        default: return;
                    }
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }
}
