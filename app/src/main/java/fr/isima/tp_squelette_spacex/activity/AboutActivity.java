package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.R;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        WebView about = findViewById(R.id.web_view_about);
        about.setBackgroundColor(0x00000000);
        about.loadUrl("file:///android_asset/fr/about.html");
    }
}
