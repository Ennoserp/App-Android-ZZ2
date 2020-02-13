package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.activity.LaunchesActivity;
import fr.isima.tp_squelette_spacex.ws.Launch;
import retrofit2.Call;

public class LaunchAdapter extends ArrayAdapter<Launch> {

    private LayoutInflater inflater;
    private int layoutId;

    public LaunchAdapter(Activity activity, int layoutResourceId, List<Launch> objects){
        super(activity, layoutResourceId, (List<Launch>) objects);
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

        TextView missionName = view.findViewById(R.id.launchLayout1);
        TextView rocketName = view.findViewById(R.id.launchLayout2);
        TextView launchDate = view.findViewById(R.id.launchLayout3);

        Launch launch = getItem(position);


        missionName.setText(launch.mission_name);
        rocketName.setText(launch.rocket.rocket_name);
        launchDate.setText(""+launch.launch_date_unix);

        return view;
    }
}
