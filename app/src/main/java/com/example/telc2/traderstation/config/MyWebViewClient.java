package com.example.telc2.traderstation.config;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by iqbal on 12/5/2017.
 */

public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
