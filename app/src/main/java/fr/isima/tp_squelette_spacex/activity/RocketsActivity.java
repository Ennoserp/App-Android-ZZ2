package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.RocketAdapter;
import fr.isima.tp_squelette_spacex.ws.Rocket;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RocketsActivity extends Activity implements AdapterView.OnItemClickListener, Callback<List<Rocket>>{

    private ProgressBar progBarRockets;
    private ListView listViewRockets;
    private RocketAdapter adapterRocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockets);

        progBarRockets = findViewById(R.id.progress_bar_rockets);
        listViewRockets = findViewById(R.id.list_rockets);

        listViewRockets.setOnItemClickListener(this);

        loadRockets();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Rocket rocket = adapterRocket.getItem(position);

        if (rocket.flickr_images == null){

            Toast t = Toast.makeText(view.getContext(), "Aucune image trouvée",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER_VERTICAL,0,0);
            t.show();
        }
        else {
            Intent intentRocketImplicite = new Intent(this,RocketActivity.class).putExtra("rck",rocket);
            startActivity(intentRocketImplicite);
        }
    }

    public void loadRockets(){
        progBarRockets.setVisibility(View.VISIBLE);

        WsManager.getSpaceXService().listRockets().enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Rocket>> call, Response<List<Rocket>> response) {
        progBarRockets.setVisibility(View.INVISIBLE);
        adapterRocket = new RocketAdapter(this, android.R.layout.simple_list_item_1, response.body());
        listViewRockets.setAdapter(adapterRocket);


    }

    @Override
    public void onFailure(Call<List<Rocket>> call, Throwable t) {
        progBarRockets.setVisibility(View.INVISIBLE);

        Context context = getApplicationContext();
        CharSequence text = "ERREUR !";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
