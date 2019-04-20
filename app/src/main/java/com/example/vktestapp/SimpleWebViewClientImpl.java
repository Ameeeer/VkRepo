package com.example.vktestapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SimpleWebViewClientImpl extends WebViewClient {
    private static String userToken = "";

    private Activity activity = null;

    public SimpleWebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        // все ссылки, в которых содержится 'vk.com'
        // будут открываться внутри приложения
        if (url.contains("vk.com")) {
            return false;
        }
        // все остальные ссылки будут спрашивать какой браузер открывать
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

    public static String getUserToken() {
        return userToken;
    }

    public static String setUserToken(String url) {
        userToken = url.substring(42,127);
        if (userToken.equals("")) {
            throw new IllegalArgumentException("NotFound");
        }
        MainActivity.connected = true;
        return userToken;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        setUserToken(url);
    }
}
