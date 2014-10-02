/**
 * ============================================================================
 *
 * Copyright (C) 2011 Android Museum Systems.  All rights reserved. The content
 * presented herein may not, under any circumstances, be reproduced, in
 * whole or in any part or form, without written permission from
 * Museum Systems.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are NOT permitted. Neither the name of Judo Systems,
 * nor the names of contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * ============================================================================
 *
 * Author: Admin
 *
 *
 * Revision History
 * ----------------------------------------------------------------------------
 * Date                Author              Comment, bug number, fix description
 *
 * Jan 2, 2012      tuan@edge-works.net           version 1.0
 *
 * ----------------------------------------------------------------------------
 */

package com.nextech.smartedu.common;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.nextech.smartedu.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Chronometer;




// TODO: Auto-generated Javadoc
/**
 * Jan 2, 2012.
 * 
 * @author Admin
 * @version 1.0
 * @copyright Copyright (c) Android Museum Systems, all rights reserved
 */

public class Utilities 
{
	private static Bitmap bgimage;
	private static Bitmap CallImage;
	private static Uri uri;
	private static int time;
   private static final String TAG="Ultilities";

	public static int getTime() 
	{
		return time;
	}

	public static void setTime(int time)
	{
		Utilities.time = time;
	}

	public static Uri getUri() 
	{
		return uri;
	}

	public static void setUri(Uri uri)
	{
		Utilities.uri = uri;
	}

	public static Bitmap getCallImage() 
	{
		return CallImage;
	}

	public static void setCallImage(Bitmap callImage)
	{
		CallImage = callImage;
	}

	public static Bitmap getBgimage() 
	{
		return bgimage;

	}

	public static void setBgimage(Bitmap bgimage)
	{
		Utilities.bgimage = bgimage;
	}
	public static Bitmap getBitmapFromFile(File filePath)
	{  
		Bitmap myBitmap;
		myBitmap = BitmapFactory.decodeFile(filePath.getAbsolutePath());
		return myBitmap;
	}
	public static List<Activity> getCleanuplist() {
		return cleanupList;
	}

	public Utilities() {

	}

	public static final List<Activity> cleanupList = new ArrayList<Activity>();

	/**
	 * Gets the process dialog.
	 * 
	 * @param activity
	 *            the activity
	 * @return the progress dialog
	 */
	public ProgressDialog GetProcessDialog(Activity activity) {
		// prepare the dialog box
		ProgressDialog dialog = new ProgressDialog(activity);
		// make the progress bar cancelable
		dialog.setCancelable(false);
		// set a message text
		dialog.setMessage("Please wait...");

		// show it
		return dialog;
	}

	/**
	 * Gets the bitmap from string.
	 * 
	 * @param image_URL
	 *            the image_ url
	 * @return the bitmap from string
	 */
	public Bitmap getBitmapFromString(String image_URL)
	{
		Bitmap srcBitmap;
		if (image_URL == null)
			return null;
		BitmapFactory.Options bmOptions;
		bmOptions = new BitmapFactory.Options();
		bmOptions.inSampleSize = 1;
		return srcBitmap = LoadImage(image_URL, bmOptions);
	}

	/**
	 * Gets the resized bitmap.
	 * 
	 * @param bm
	 *            the bm
	 * @param newHeight
	 *            the new height
	 * @param newWidth
	 *            the new width
	 * @return the resized bitmap
	 */

	public AlertDialog showDialogConfirm(final Activity activity, String title,
			String message, final boolean flag) 
	{
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		// activity.getWindow().setBackgroundDrawableResource(R.color.orange);
		//alertDialog.setIcon(R.drawable.dialog_icon);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.dismiss();
				/*if (flag) 
			    {
			     //activity.finish();
			    } 
			    else 
			    {
			     return;
			    }*/

			}
		});
		alertDialog.setCancelable(false);
		return alertDialog;
	}

//	public void displayMessageAndExit(Activity activity,String tiltleMassage,String message)
//	{
//		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//		builder.setTitle(tiltleMassage);
//		builder.setMessage(message);
//		builder.setPositiveButton("Ok", new FinishListener(activity));
//		builder.setOnCancelListener(new FinishListener(activity));
//		builder.setCancelable(false);
//		builder.show();
//	}



	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) 
	{

		if (bm == null)
			return null;
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// CREATE A MATRIX FOR THE MANIPULATION
		Matrix matrix = new Matrix();
		// RESIZE THE BIT MAP
		matrix.postScale(scaleWidth, scaleHeight);
		// RECREATE THE NEW BITMAP
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);
		return resizedBitmap;
	}

	/**
	 * Load image.
	 * 
	 * @param URL
	 *            the uRL
	 * @param options
	 *            the options
	 * @return the bitmap
	 */
	private Bitmap LoadImage(String URL, BitmapFactory.Options options) {
		Bitmap bitmap = null;
		InputStream in = null;
		try {
			in = OpenHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in, null, options);
			if (in!=null)
			{
				in.close();	
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return bitmap;
	}

	/**
	 * M lock screen rotation.
	 * 
	 * @param activity
	 *            the activity
	 */
	public void mLockScreenRotation(Activity activity) {
		// Stop the screen orientation changing during an event
		switch (activity.getResources().getConfiguration().orientation) {
		case Configuration.ORIENTATION_PORTRAIT:
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			break;
		case Configuration.ORIENTATION_LANDSCAPE:
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			break;
		}
	}

	/**
	 * Open http connection.
	 * 
	 * @param strURL
	 *            the str url
	 * @return the input stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private InputStream OpenHttpConnection(String strURL) throws IOException {
		InputStream inputStream = null;
		URL url = new URL(strURL);
		URLConnection conn = url.openConnection();

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				inputStream = httpConn.getInputStream();
			}
		} catch (Exception ex) {
		}

		return inputStream;
	}

	/**
	 * Show progress dialog.
	 * 
	 * @param mContext
	 *            the m context
	 * @return the dialog
	 */
	public Dialog showProgressDialog(Activity mContext)
	{
		Dialog mDialog = new Dialog(mContext,
				android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		LayoutInflater mInflater = LayoutInflater.from(mContext);
		View layout = mInflater.inflate(R.layout.popup_example, null);
		mDialog.setContentView(layout);

		mDialog.setCancelable(false);
		// aiImage.post(new Starter(activityIndicator));
		return mDialog;
	}
	public static boolean isNetworkAvailable(Context context) 
	{  

		ConnectivityManager connectivity  = null;  
		boolean isNetworkAvail = false;

		try
		{
			connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

			if (connectivity != null) 
			{       
				NetworkInfo[] info = connectivity.getAllNetworkInfo();

				if (info != null)
				{   
					for (int i = 0; i < info.length; i++) 
					{
						if (info[i].getState() == NetworkInfo.State.CONNECTED) 
						{  

							return true;
						}
					}
				}
			}
			return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connectivity !=null)
			{
				connectivity = null;
			}
		}
		return isNetworkAvail;
	}
	public boolean isSdcardAvailable()
	{
		boolean flag=android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		return flag;
	}
	/**
	 * Show progress dialog.
	 * 
	 * @param mContext
	 *            the m context
	 * @return the dialog
	 */
	/*public Dialog showDialogShareFacebook(final Activity mContext,
			final String subject, final String body, final String image,
			final String appLink) {
		final Dialog mDialog = new Dialog(mContext,
				android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		LayoutInflater mInflater = LayoutInflater.from(mContext);
		View layout = mInflater.inflate(R.layout.dialog_transparent, null);
		mDialog.setContentView(layout);
		mDialog.setCancelable(true);
		Button btn_share_email = (Button) layout
				.findViewById(R.id.btn_share_email);
		Button btn_share_facebook = (Button) layout
				.findViewById(R.id.btn_share_facebook);
		Button btn_share_ok = (Button) layout.findViewById(R.id.btn_ok);

		btn_share_email.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent sharingIntent = new Intent(Intent.ACTION_SEND);
				sharingIntent.setType("plain/text");
				sharingIntent.putExtra(Intent.EXTRA_CC,
						"tuanedgeworks@gmail.com");
				sharingIntent.putExtra(Intent.EXTRA_SUBJECT,
						"Art item not present");
				sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						appLink);
				sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);

				mContext.startActivity(Intent.createChooser(sharingIntent,
						"Share using"));

				mDialog.cancel();
			}
		});

		btn_share_facebook.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		btn_share_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDialog.cancel();
			}
		});

		return mDialog;
	}*/

	/**
	 * Gets the data source.
	 * 
	 * @param path
	 *            the path
	 * @return the data source
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String getDataSource(String path) throws IOException {
		if (!URLUtil.isNetworkUrl(path)) {
			return path;
		} else {
			URL url = new URL(path);
			URLConnection cn = url.openConnection();
			cn.connect();
			InputStream stream = cn.getInputStream();
			if (stream == null)
				throw new RuntimeException("stream is null");
			File temp = File.createTempFile("mediaplayertmp", "mp3");
			temp.deleteOnExit();
			String tempPath = temp.getAbsolutePath();
			FileOutputStream out = new FileOutputStream(temp);
			byte buf[] = new byte[128];
			do {
				int numread = stream.read(buf);
				if (numread <= 0)
					break;
				out.write(buf, 0, numread);
			} while (true);
			try {
				stream.close();
			} catch (IOException ex) {
				Log.e("Error", "error: " + ex.getMessage(), ex);
			}
			return tempPath;
		}
	}

	/**
	 * Show dialog confirm.
	 * 
	 * @param activity
	 *            the activity
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param flag
	 *            the flag
	 * @return the alert dialog
	 */
	/*public AlertDialog showDialogConfirm(final Activity activity, String title,
			String message, final boolean flag) {
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		// activity.getWindow().setBackgroundDrawableResource(R.color.orange);
		alertDialog.setIcon(R.drawable.dialog_icon);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (flag) {
					activity.finish();
				} else {
					return;
				}

			}
		});
		return alertDialog;
	}*/

	/*public AlertDialog showDialogConfirmScavenger(final Activity activity,
			String title, String message, final boolean flag) {
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		// activity.getWindow().setBackgroundDrawableResource(R.color.orange);
		alertDialog.setIcon(R.drawable.dialog_icon);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Application apps = (Application) activity.getApplication();
				Chronometer time = new Chronometer(activity);
				int stoppedMilliseconds = 0;
				String chronoText = apps.getChronoText();

				if (flag) {
					// =====================================================================
					// counting timer
					String array[] = chronoText.split(":");
					if (array.length == 2) {
						stoppedMilliseconds = Integer.parseInt(array[0]) * 60
	 * 1000 + (Integer.parseInt(array[1]) + 1)
	 * 1000;
					} else if (array.length == 3) {
						stoppedMilliseconds = Integer.parseInt(array[0]) * 60
	 * 60 * 1000 + Integer.parseInt(array[1]) * 60
	 * 1000 + (Integer.parseInt(array[2]) + 1)
	 * 1000;
					}

					time.setBase(SystemClock.elapsedRealtime()
							- stoppedMilliseconds);

					time.start();
					// =======================================================================

					Intent intent = new Intent(activity,
							FinalScoreScavengerActivity.class);
					activity.startActivity(intent);
					activity.overridePendingTransition(R.anim.slide_left, 0);

					apps.setChronoText(time.getText().toString());

				} else {
					// =====================================================================
					// counting timer
					String array[] = chronoText.split(":");
					if (array.length == 2) {
						stoppedMilliseconds = Integer.parseInt(array[0]) * 60
	 * 1000 + (Integer.parseInt(array[1]) + 1)
	 * 1000;
					} else if (array.length == 3) {
						stoppedMilliseconds = Integer.parseInt(array[0]) * 60
	 * 60 * 1000 + Integer.parseInt(array[1]) * 60
	 * 1000 + (Integer.parseInt(array[2]) + 1)
	 * 1000;
					}

					time.setBase(SystemClock.elapsedRealtime()
							- stoppedMilliseconds);

					time.start();
					// =======================================================================
					Intent intentDescriptions = new Intent(activity,
							GameDescriptionActivity.class);
					activity.startActivity(intentDescriptions);
					activity.overridePendingTransition(R.anim.slide_left, 0);
					apps.setChronoText(time.getText().toString());
				}

			}
		});
		return alertDialog;
	}
	 */
	/**
	 * Show dialog final clue.
	 * 
	 * @param activity
	 *            the activity
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @return the alert dialog
	 */
	/*public AlertDialog showDialogFinalClue(final Activity activity,
			String title, String message) {
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		activity.getWindow().setBackgroundDrawableResource(R.color.orange);
		alertDialog.setIcon(R.drawable.dialog_icon);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Intent it=new Intent(activity,FinalScoreActivity.class);
				// it.putExtra("gameId", gameId);
				// activity.startActivity(it);
				dialog.dismiss();

			}
		});
		return alertDialog;
	}
	 */
	/**
	 * Show dialog search.
	 * 
	 * @param activity
	 *            the activity
	 * @return the dialog
	 */
	/*public Dialog showDialogShare(Activity activity) {
		// set up dialog
		final Dialog dialog = new Dialog(activity);
		dialog.setContentView(R.layout.dialog_share_option);
		dialog.setCancelable(true);

		final WheelView share = (WheelView) dialog.findViewById(R.id.shares);
		String arrShare[] = new String[] { "Share Facebook", "Share Email" };
		share.setViewAdapter(new DateArrayAdapter(activity, arrShare, 0));

		// set up image view
		// Button button = (Button) dialog.findViewById(R.id.button1);
		Button btn_done = (Button) dialog.findViewById(R.id.btn_done);
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				dialog.cancel();
			}
		});
		// now that the dialog is set up, it's time to show it
		return dialog;
	}*/

	/**
	 * Adapter for string based wheel. Highlights the current value.
	 */
	/*private class DateArrayAdapter extends ArrayWheelAdapter<String> implements
			WheelViewAdapter {
		// Index of current item
	 *//** The current item. *//*
		int currentItem;
		// Index of item to be highlighted
	  *//** The current value. *//*
		int currentValue;

	   *//**
	   * Constructor.
	   * 
	   * @param context
	   *            the context
	   * @param items
	   *            the items
	   * @param current
	   *            the current
	   *//*
		public DateArrayAdapter(Context context, String[] items, int current) {
			super(context, items);
			this.currentValue = current;
			setTextSize(16);
		}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.museum.wheel.widget.adapters.AbstractWheelTextAdapter#
	 * configureTextView(android.widget.TextView)
	 */
	/*protected void configureTextView(TextView view) {
			super.configureTextView(view);
			// if (currentItem == currentValue) {
			// view.setTextColor(0xFF0000F0);
			// }
			view.setTypeface(Typeface.SANS_SERIF);
			view.setLineSpacing(6, 1);
			view.setTextSize(25);
		}*/

	public String capitalize(String s) 
	{
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	// Function to get the time out
	/**
	 * Give me time.
	 * 
	 * @param crono
	 *            the crono
	 * @return the long
	 */
	public long giveMeTime(Chronometer crono) 
	{
		long allMilli = SystemClock.elapsedRealtime() - crono.getBase();
		return allMilli;
	}

	/*public Dialog showConfirmDialog(Activity activity, String title,
			String message) {
		Dialog dialog = null;
		CustomDialog.Builder customBuilder = new CustomDialog.Builder(activity);
		customBuilder.setTitle(title).setMessage(message)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dialog = customBuilder.create();
		return dialog;
	}*/

	public static boolean isInternetAvalible(Context context) {
		final ConnectivityManager conMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
		if (activeNetwork != null
				&& activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
			System.out.println("Connected...");
			return true;
		}
		return false;
	}

	public static void cleanUpActivity() {
		for (Activity activity : cleanupList) {
			activity.finish();
		}
		cleanupList.clear();
	}
	
	//.......................loupon......................................................
	public static String convertURL(String str) {

	    String url = null;
	    try{
	    url = new String(str.trim().replace(" ", "%20").replace("&", "%26")
	            .replace(",", "%2c").replace("(", "%28").replace(")", "%29")
	            .replace("!", "%21").replace("=", "%3D").replace("<", "%3C")
	            .replace(">", "%3E").replace("#", "%23").replace("$", "%24")
	            .replace("'", "%27").replace("*", "%2A").replace("-", "%2D")
	            .replace(".", "%2E").replace("/", "%2F").replace(":", "%3A")
	            .replace(";", "%3B").replace("?", "%3F").replace("@", "%40")
	            .replace("[", "%5B").replace("\\", "%5C").replace("]", "%5D")
	            .replace("_", "%5F").replace("`", "%60").replace("{", "%7B")
	            .replace("|", "%7C").replace("}", "%7D"));
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return url;
	}
	
	public static String callhttpRequest(String url) {
		System.out.println("utility url..."+url);
		String resp = null;
	        	HttpGet httpRequest;
				try {
					httpRequest = new HttpGet(url);
					HttpParams httpParameters = new BasicHttpParams();
		        	int timeoutConnection = 60000;
		        	HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);		  	
		        	int timeoutSocket = 60000;
		        	HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);		        			        			        	
	        	HttpClient httpClient = new DefaultHttpClient(httpParameters);	        	
	        	HttpResponse response = httpClient.execute(httpRequest);
	        	HttpEntity entity = response.getEntity();
	        	BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
	        	final long contentLength = bufHttpEntity.getContentLength();
	        	if ((contentLength >= 0)) 
	        	{
	        		InputStream is = bufHttpEntity.getContent();
	        		int tobeRead = is.available();
	        		System.out.println("Utility callhttpRequest tobeRead.."+tobeRead);
	        		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
	        		int ch;
	        			
	        			while ((ch = is.read()) != -1)
	        			{ 
	        				bytestream.write(ch);
	        			}

	        			resp = new String(bytestream.toByteArray());
	        			System.out.println("Utility callhttpRequest resp.."+resp);
	        	}
				} catch (MalformedURLException e) {
					System.out.println("Utility callhttpRequest.."+e);
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					System.out.println("Utility callhttpRequest.."+e);
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Utility callhttpRequest.."+e);
					e.printStackTrace();
				}catch (Exception e) {
					System.out.println("Utility Exception.."+e);
				}
		return resp;
	}
	
 /**
		  * Do post.
		  *
		  * @param url the url
		  * @param kvPairs the kv pairs
		  * @return the http response
		  * @throws ClientProtocolException the client protocol exception
		  * @throws IOException Signals that an I/O exception has occurred.
		  */
		 public static HttpResponse doPost(String url, Map<String, String> kvPairs)
		   throws ClientProtocolException, IOException 
		   {
		  // HttpClient httpclient = new DefaultHttpClient();
			 Log.d(TAG, "doPost  url "+url);
			 Log.d(TAG, "doPost  kvPairs "+kvPairs);

		  DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		  HttpClient httpclient = defaultHttpClient;
		  Log.d(TAG, "doPost  httpclient "+httpclient);
		  HttpPost httppost = new HttpPost(url);
		  Log.d(TAG, "doPost  httppost "+httppost);

		  if (kvPairs != null || kvPairs.isEmpty() == false) 
		  {
		   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(kvPairs.size());
		   String k, v;
		   Iterator<String> itKeys = kvPairs.keySet().iterator();

		   while (itKeys.hasNext()) 
		   {
		    k = itKeys.next();
		    v = kvPairs.get(k);
		    
		    Log.d(TAG, "doPost  key  "+k);
		    Log.d(TAG, "doPost  value  "+v);
		    nameValuePairs.add(new BasicNameValuePair(k, v));
		   }
		   
		   httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		   Log.d(TAG, "doPost  httppost  "+httppost);
		  }

		  HttpResponse response;
		  response = httpclient.execute(httppost);
		  Log.i("TAG", "doPost response........."+response);
		  return response;
		 }
		
	/**
	  * Do post.
	  *
	  * @param url the url
	  * @param kvPairs the kv pairs
	  * @return the http response
	  * @throws ClientProtocolException the client protocol exception
	  * @throws IOException Signals that an I/O exception has occurred.
	  */
	/* public static HttpResponse doPost(String url, Map<String, String> kvPairs)
	   throws ClientProtocolException, IOException 
	   {
	  // HttpClient httpclient = new DefaultHttpClient();
		 Log.d(TAG, "doPost  url "+url);
		 Log.d(TAG, "doPost  kvPairs "+kvPairs);

	  DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
	  HttpClient httpclient = defaultHttpClient;
	  Log.d(TAG, "doPost  httpclient "+httpclient);
	  HttpPost httppost = new HttpPost(url);
	  Log.d(TAG, "doPost  httppost "+httppost);
	 
		
		 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

	 
	   List<NameValuePair> nameValuePairs1 = new ArrayList<NameValuePair>();
	   nameValuePairs1.add(new BasicNameValuePair("firstName", "sdhfs"));
	   nameValuePairs1.add(new BasicNameValuePair("lastName", "jhasdg"));
	   nameValuePairs1.add(new BasicNameValuePair("dob", "10/09/1989"));
	   nameValuePairs1.add(new BasicNameValuePair("email", "fhdfj"));
	   nameValuePairs1.add(new BasicNameValuePair("newsletter", 1));
	   nameValuePairs1.add(new BasicNameValuePair("passwords", "123"));
	   nameValuePairs1.add(new BasicNameValuePair("postCode", "134634"));
	   nameValuePairs1.add(new BasicNameValuePair("country", ""));
	   nameValuePairs1.add(new BasicNameValuePair("city", ""));
	   nameValuePairs1.add(new BasicNameValuePair("devicetype","2"));
	   nameValuePairs1.add(new BasicNameValuePair("deviceid", "4534"));
	   nameValuePairs1.add(new BasicNameValuePair("uuid",  "32423"));
	   httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
	   
	   String k, v;
	   Iterator<String> itKeys = kvPairs.keySet().iterator();

	   while (itKeys.hasNext()) 
	   {
	    k = itKeys.next();
	    v = kvPairs.get(k);
	    
	    Log.d(TAG, "doPost  key  "+k);
	    Log.d(TAG, "doPost  value  "+v);
	    nameValuePairs.add(new BasicNameValuePair(k, v));
	   }
	   
	   httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	   Log.d(TAG, "doPost  httppost  "+httppost);
	  }

	  HttpResponse response;
	  response = httpclient.execute(httppost);
	  Log.i("TAG", "doPost response........."+response);
	  return response;
	 }*/
	
		 
			@SuppressLint("NewApi")
			public static int getWidth(Context mContext){
				  int width=0;
				  WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
				  Display display = wm.getDefaultDisplay();
				  if(Build.VERSION.SDK_INT >=13){                   
				   Point size = new Point();
				   display.getSize(size);
				   width = size.x;
				  }
				  else{
				   width = display.getWidth();  // deprecated
				  }
				  return width;
				 }
				 
				
				@SuppressLint("NewApi")
				public static int getHeight(Context mContext)
				 {
				  int height=0;
				  WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
				  Display display = wm.getDefaultDisplay();
				  if(Build.VERSION.SDK_INT >=13){               
				   Point size = new Point();
				   display.getSize(size);
				   height = size.y;
				  }else
				  {          
				   height = display.getHeight();  // deprecated
				  }
				  return height;      
				 }
				

}
