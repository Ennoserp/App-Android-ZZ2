package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.PicturesPager;
import fr.isima.tp_squelette_spacex.ws.Rocket;

public class RocketActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);



        Intent intent = getIntent();
        Rocket rocket = (Rocket) intent.getSerializableExtra("rck");

        if ( rocket == null){
            finish();
        }
        else {
            ViewPager viewPagerRockets = findViewById(R.id.view_pager_rockets);
            viewPagerRockets.setAdapter(new PicturesPager(this,rocket.flickr_images));
        }


    }
}
