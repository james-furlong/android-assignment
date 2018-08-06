package au.com.jamesfurlong.assignment_1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import au.com.jamesfurlong.assignment_1.R;

public class AlarmActivity extends AppCompatActivity {

    private Button worldButton;
    private Button clockButton;
    private Button stopwatchButton;
    private Button settingsButton;
    private Button[] buttonArray;
    private TextView setAlarmText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        setupActivity();
    }

    private void setupActivity(){
        worldButton = findViewById(R.id.world_button);
        clockButton = findViewById(R.id.clock_button);
        stopwatchButton = findViewById(R.id.stopwatch_button);
        settingsButton = findViewById(R.id.settings_button);
        buttonArray = new Button[] {worldButton, clockButton, stopwatchButton, settingsButton};
        setAlarmText = findViewById(R.id.alarm_set_text);
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
                        case 1: i = new Intent(AlarmActivity.this, WorldActivity.class);
                            break;
                        case 3: i = new Intent(AlarmActivity.this, MainActivity.class);
                            break;
                        case 4: i = new Intent(AlarmActivity.this, StopwatchActivity.class);
                            break;
                        case 5: i = new Intent(AlarmActivity.this, SettingsActivity.class);
                            break;
                        default: return;
                    }
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    public void setAlarm(View view) {
        String text = setAlarmText.getText().toString();
        if (text.equals("Alarm set")) {
            setAlarmText.setText("Alarm not set");
        } else {
            setAlarmText.setText("Alarm set");
        }
    }
}
