package au.com.jamesfurlong.assignment_1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import au.com.jamesfurlong.assignment_1.Activities.Adapter.WorldTimeAdapter;
import au.com.jamesfurlong.assignment_1.Activities.Classes.WorldTime;
import au.com.jamesfurlong.assignment_1.R;

public class WorldActivity extends AppCompatActivity {

    private Button alarmButton;
    private Button clockButton;
    private Button stopwatchButton;
    private Button settingsButton;
    private Button[] buttonArray;
    private ListView listView;
    private ArrayList<WorldTime> worldTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        setupActivity();
    }

    private void setupActivity() {
        alarmButton = findViewById(R.id.alarm_button);
        clockButton = findViewById(R.id.clock_button);
        stopwatchButton = findViewById(R.id.stopwatch_button);
        settingsButton = findViewById(R.id.settings_button);
        buttonArray = new Button[] {alarmButton, clockButton, stopwatchButton, settingsButton};
        listView = findViewById(R.id.list_view);
        worldTimes = new ArrayList<WorldTime>();
        setListeners();
        setDummyData();
        WorldTimeAdapter adapter = new WorldTimeAdapter(this, worldTimes);
//        ArrayAdapter<WorldTime> adapter = new ArrayAdapter<WorldTime>(this, android.R.layout.simple_list_item_1, android.R.id.text1, worldTimes);
        listView.setAdapter(adapter);
    }

    private void setListeners() {
        for (Button button : buttonArray) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i;
                    int tag = Integer.parseInt((String)view.getTag());
                    switch (tag) {
                        case 3: i = new Intent(WorldActivity.this, MainActivity.class);
                            break;
                        case 2: i = new Intent(WorldActivity.this, AlarmActivity.class);
                            break;
                        case 4: i = new Intent(WorldActivity.this, StopwatchActivity.class);
                            break;
                        case 5: i = new Intent(WorldActivity.this, SettingsActivity.class);
                            break;
                        default: return;
                    }
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    private void setDummyData() {
        WorldTime time1 = new WorldTime("New York", "20:34", "-17 Hours");
        WorldTime time2 = new WorldTime("London", "01:34", "-9 Hours");
        WorldTime time3 = new WorldTime("Perth", "08:34", "-2 Hours");
        WorldTime time4 = new WorldTime("Colombo", "05:04", "-4.5 Hours");
        worldTimes.add(time1);
        worldTimes.add(time2);
        worldTimes.add(time3);
        worldTimes.add(time4);
    }
}
