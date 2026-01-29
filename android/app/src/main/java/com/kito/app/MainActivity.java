package com.tamilzo.app;

import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WebView webView = getBridge().getWebView();

    webView.setWebViewClient(new WebViewClient() {
  @Override
  public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    return false;
  }

  @Override
  public void onReceivedError(
    WebView view,
    WebResourceRequest request,
    WebResourceError error
  ) {
    if (request.isForMainFrame()) {
      view.loadUrl("file:///android_asset/offline.html");
    }
  }
});

  }
}
