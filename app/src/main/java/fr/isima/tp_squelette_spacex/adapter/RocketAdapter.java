package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.core.content.ContextCompat;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Rocket;

public class RocketAdapter extends ArrayAdapter<Rocket> {

    private int layoutResourceId;
    LayoutInflater inflater;

    public RocketAdapter(Activity activity, int layoutResourceId, List<Rocket> data)
    {
        super(activity, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(layoutResourceId, parent, false);
        }

        ViewHolder holder = (ViewHolder)view.getTag();
        if (holder == null)
        {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        Rocket rocket = getItem(position);
        holder.rocketName.setText(rocket.rocket_name);
        holder.rocketName.setTextColor(ContextCompat.getColor(getContext(),R.color.colorPlatinum));

        return view;
    }


    private class ViewHolder
    {
        public TextView rocketName;

        public ViewHolder(View row)
        {
            rocketName = row.findViewById(android.R.id.text1);
        }
    }
}
