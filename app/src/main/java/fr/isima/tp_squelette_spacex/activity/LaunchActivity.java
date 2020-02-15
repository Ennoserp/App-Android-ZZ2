package fr.isima.tp_squelette_spacex.activity;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Intent intent = getIntent();
        Launch launch = (Launch) intent.getSerializableExtra("lch");

        WebView launchWebView = findViewById(R.id.webViewLaunch);
        launchWebView.setWebViewClient(new WebViewClient());
        launchWebView.loadUrl(launch.links.article_link);
    }
}
