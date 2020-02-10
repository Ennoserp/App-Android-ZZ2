package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import fr.isima.tp_squelette_spacex.adapter.LaunchAdapter;
import fr.isima.tp_squelette_spacex.ws.Launch;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchesActivity extends Activity implements AdapterView.OnItemClickListener, Callback<List<Launch>> {

    private ProgressBar barreP = findViewById(R.id.progression);
    private ListView liste = findViewById(R.id.list_launches);
    private Launch launch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launches);

        liste.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        launch = ((Launch) parent.getAdapter());
        if (launch.links.article_link==null){
            Toast t = Toast.makeText(view.getContext(), "aucun d'article trouvé",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER_VERTICAL,0,0);
            t.show();
        }
        else {
            if (launch.links.article_link.startsWith("https")){
                Intent intentExplicite = new Intent(this, LaunchActivity.class).putExtra("url", launch);
                startActivity(intentExplicite);
            }
            else {
                //http
                Intent intentImplicite = new Intent(Intent.ACTION_VIEW,Uri.parse(launch.links.article_link));
                startActivity(intentImplicite);
            }
        }
    }


    public void loadLaunches(){
        barreP.setVisibility(View.VISIBLE);

        WsManager.getSpaceXService().listLaunches().enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
        barreP.setVisibility(View.INVISIBLE);
        
    }

    @Override
    public void onFailure(Call<List<Launch>> call, Throwable t) {
        barreP.setVisibility(View.INVISIBLE);

        Context context = getApplicationContext();
        CharSequence text = "ERREUR !";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
