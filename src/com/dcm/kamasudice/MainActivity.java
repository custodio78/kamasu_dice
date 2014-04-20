package com.dcm.kamasudice;

import android.app.Activity;
import android.graphics.Point;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.dcm.kamasudice.R;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	   LinearLayout rootLayout = new LinearLayout(this);
	   rootLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
	   rootLayout.setGravity(Gravity.CENTER);
	   
	  
	   
	   WebView webView = new WebView(this);
	   
	   webView.getSettings().setJavaScriptEnabled(true);
	   
	   // Settings to get the webview scale its content to its own bounds and let us change the scale using setInitialScale.
       // setLoadWithOverviewMode(true) loads the WebView completely zoomed out
	   webView.getSettings().setLoadWithOverviewMode(true);
       //setUseWideViewPort(true) makes the Webview have a normal viewport (such as a normal desktop browser),
       //while when false the webview will have a viewport constrained to it's own dimensions (so if the webview is 50px*50px the viewport will be the same size)
	   webView.getSettings().setUseWideViewPort(false);
	   
	   webView.setWebViewClient(new WebViewClient()
	   {
		   @Override
		   public boolean shouldOverrideUrlLoading(WebView view, String url)
		   {
			   view.loadUrl(url);
			   return true;
		   }
		
		   @Override
		   public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
		   {
			   handler.proceed();
		   }
		});
	   webView.setWebChromeClient(new WebChromeClient());
	   
	   rootLayout.addView(webView);
	   setContentView(rootLayout);
	   
	   //http://freebsd.csie.nctu.edu.tw/~freedom/html5/
	   //http://www.youtube.com/watch?v=cNBzYDIQrjw
	   //http://player.vimeo.com/video/47875656
	   
		   webView.loadUrl("file:///android_asset/www/index.html");
	   //webView.loadUrl("file:///android_asset/www/index.html");
	}
}
