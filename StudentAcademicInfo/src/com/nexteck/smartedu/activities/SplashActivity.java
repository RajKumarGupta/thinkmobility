package com.nexteck.smartedu.activities;

/*import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Splash_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_, menu);
		return true;
	}

}
 */



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.nextech.smartedu.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;


public class SplashActivity extends Activity {
	private Thread splashThread;
	private static String TAG="SplashActivity";
	private static    String mDebugTag = "SplashActivity";
	private static boolean mDebugLog = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// The thread to wait for splash screen events

		splashThread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {
						// Wait given period of time or exit on touch
						wait(3000);
					}
				} catch (InterruptedException ex) {
				}
				
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();


			/*	SessionManager sessionManager= new SessionManager(SplashActivity.this);

				if(!sessionManager.getLoginstate())
				{
					Log.d(TAG,"prit splash activity if "+ sessionManager.getLoginstate());	
					Intent intent = new Intent();
					intent.setClass(SplashActivity.this, LandingActivity.class);
					startActivity(intent);
					finish();	

				}
				else
				{

					Log.d(TAG,"prit splash activity else "+ sessionManager.getLoginstate());
					Intent intent = new Intent();
					intent.setClass(SplashActivity.this, TabSample.class);
					startActivity(intent);
					finish();
				}


*/

			}
		};




		splashThread.start();



	}

	/**
	 * Processes splash screen touch events
	 */
	@Override
	public boolean onTouchEvent(MotionEvent evt) {
		if (evt.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized (splashThread) {
				splashThread.notifyAll();
			}
		}
		return true;
	}
}
