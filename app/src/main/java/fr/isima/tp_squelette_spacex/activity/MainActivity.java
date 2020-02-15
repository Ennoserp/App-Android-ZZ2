package fr.isima.tp_squelette_spacex.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import fr.isima.tp_squelette_spacex.R;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navMissions:
                startActivity(new Intent(this, LaunchesActivity.class));
                break;
            case R.id.navRockets:
                startActivity(new Intent(this,RocketsActivity.class));
                break;
        }
        return true;
    }

    


}
