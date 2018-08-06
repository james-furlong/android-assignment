package au.com.jamesfurlong.assignment_1.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import au.com.jamesfurlong.assignment_1.Activities.Classes.WorldTime;
import au.com.jamesfurlong.assignment_1.R;


public class WorldTimeAdapter extends BaseAdapter {

    ArrayList<WorldTime> worldTimeList;
    Context mContext;

    public WorldTimeAdapter(Context context, ArrayList<WorldTime> worldTimeList) {
        this.mContext = context;
        this.worldTimeList = worldTimeList;
    }

    @Override
    public int getCount() {
        return worldTimeList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WorldTime worldTime = worldTimeList.get(position);
        convertView = LayoutInflater.from(mContext).inflate(R.layout.world_time_row, null);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView time = (TextView) convertView.findViewById(R.id.time);
        TextView difference = (TextView) convertView.findViewById(R.id.time_difference);
        location.setText(worldTime.getLocation());
        time.setText(worldTime.getTime());
        difference.setText(worldTime.getTimeDifference());
        return convertView;
    }

}
