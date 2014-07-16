package cl.zonamovil.nativedroid;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	  WebView mwebview;
	  /*
		 * array of div's ids to disable/hide
		 */
		 String[] idsToHide = { "section1", "section3", "section5" };
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		mwebview = (WebView)findViewById(R.id.webview);
		WebSettings webSettings = mwebview.getSettings();                           
		webSettings.setJavaScriptEnabled(true);
		
		String url = "file:///android_asset/index.html";       
		mwebview.loadUrl(url);
		
		mwebview.setWebViewClient(new WebViewClient() {
			 @Override
			 public void onPageFinished(WebView view, String url) {
			 // TODO Auto-generated method stub
			 super.onPageFinished(view, url);

			 
			 view.loadUrl("javascript:disableSection('section5');");
			
			 }
			 });
		
		if(savedInstanceState!=null){
			
			Log.i("HolaMundoActivity", "Bundle iniciado..");
			
		}else{
			
			Log.i("HolaMundoActivity", "Bundle null..");
			
		}
		
		
		
		
	}
	
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && mwebview.canGoBack()) {
	        	
	        
	        	
	        	
	            mwebview.goBack();
	            return true;
	        }
	        return super.onKeyDown(keyCode, event);
	    }
	
	

}
