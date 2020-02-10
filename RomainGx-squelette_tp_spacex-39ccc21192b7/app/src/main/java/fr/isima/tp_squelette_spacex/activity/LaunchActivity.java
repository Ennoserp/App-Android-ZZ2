package fr.isima.tp_squelette_spacex.activity;

import androidx.appcompat.app.AppCompatActivity;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Launch;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.Serializable;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Intent intent = getIntent();
        Launch launch = (Launch) intent.getSerializableExtra("str");

        WebView launchWebView = findViewById(R.id.webViewLaunch);
        launchWebView.setWebViewClient(new WebViewClient());
        launchWebView.loadUrl(launch.links.article_link);
    }
}
