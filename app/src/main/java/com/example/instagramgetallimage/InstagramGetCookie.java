package com.example.instagramgetallimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class InstagramGetCookie extends AppCompatActivity {

    public static String NEW_T = "NEW_T";
    private Button btnGetCookie;
    private WebView wvGetCookie;
    String cookie = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_get_cookie);
        init();
        onClick();
    }

    private void init() {
        btnGetCookie = (Button) findViewById(R.id.btnGetCookie);
        wvGetCookie = (WebView) findViewById(R.id.wvCookie);
    }

    private void onClick() {
        wvGetCookie.getSettings().setLoadsImagesAutomatically(true);
        wvGetCookie.getSettings().setJavaScriptEnabled(true);
        wvGetCookie.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wvGetCookie.loadUrl("https://www.instagram.com/");
        wvGetCookie.setWebViewClient(new WebViewContent());
        btnGetCookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cookie.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Chưa lấy được cookie hãy đăng nhập lại nhé", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(NEW_T, cookie);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    class WebViewContent extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String cookieManager = CookieManager.getInstance().getCookie(url);
            if (cookieManager.contains("ds_user_id")) {
                cookie = cookieManager;
            }
        }
    }
}
