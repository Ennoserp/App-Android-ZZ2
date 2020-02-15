package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Launch;

public class LaunchAdapter extends ArrayAdapter<Launch> {

    private LayoutInflater inflater;
    private int layoutId;

    public LaunchAdapter(Activity activity, int layoutResourceId, List<Launch> objects){
        super(activity, layoutResourceId, objects);
        inflater = activity.getLayoutInflater();
        layoutId = layoutResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(convertView == null){
           view = inflater.inflate(layoutId, parent, false);
        }

        TextView missionName = view.findViewById(R.id.mission_name);
        TextView rocketName = view.findViewById(R.id.mission_rocket_name);
        TextView launchDate = view.findViewById(R.id.mission_date_launch);

        Launch launch = getItem(position);

        //conversion unixTime en date:
        Date date = new java.util.Date(launch.launch_date_unix*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMMM yyyy HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+1"));
        String formattedDate = sdf.format(date);

        //on set les affichages
        missionName.setText(launch.mission_name);
        rocketName.setText(launch.rocket.rocket_name);
        launchDate.setText(formattedDate);

        return view;
    }
}
