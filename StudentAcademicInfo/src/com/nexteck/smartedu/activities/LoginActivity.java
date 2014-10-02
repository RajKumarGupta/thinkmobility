package com.nexteck.smartedu.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;
import com.nextech.smartedu.R;
import com.nextech.smartedu.common.Constants;
import com.nextech.smartedu.common.Utilities;
import com.nextech.smartedu.service.RestAPITask;
import com.nextech.smartedu.service.HttpUtil;
import com.nexteck.smartedu.model.StudentInfo;

public class LoginActivity extends Activity implements OnClickListener {

	private static String mDebugTag = "LoginActivity";
	private static boolean mDebugEnabled = true;
	private Button mLoginButton;
	private EditText mUserNameEditText;
	private EditText mPasswordEditText;
	private ProgressDialog mProgressDialog;
	private Utilities mUtility;
	private String mUserName;
	private String mPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mUtility = new Utilities();
		mProgressDialog = mUtility.GetProcessDialog(this);
		mLoginButton = (Button) findViewById(R.id.login_button);
		mUserNameEditText = (EditText) findViewById(R.id.username);
		mPasswordEditText = (EditText) findViewById(R.id.password);

		try {

			mLoginButton.setOnClickListener(this);

		} catch (Exception e) {
			if(mDebugEnabled == true){
				Log.e(mDebugTag, "Exception   " + e);
			}

		}
	}

	private class GetStudentDetailsTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog.setMessage("Please Wait......");
			mProgressDialog.show();
			if(mDebugEnabled == true){
				Log.d(mDebugTag, "pre execute  message...........");
			}
		}

		@Override
		protected String doInBackground(String... params) {

			List<NameValuePair> apiParams = new ArrayList<NameValuePair>(1);
			apiParams.add(new BasicNameValuePair("id", mUserName)); 
			apiParams.add(new BasicNameValuePair("password", mPassword));
			apiParams.add(new BasicNameValuePair("Isnew", "1")); 

			HttpUtil restAPIUtil = new HttpUtil(
					Constants.REST_URL_GET_STUDENT_DETAILS, "GET", apiParams);

			String studentJson = restAPIUtil.makeRESTCall();
			// Change field "Class" to "Clas" as this was creating issue
			// with java class named "Class"
			studentJson = studentJson.replaceFirst("Class", "Clas"); 
			// Trim extra spaces
			studentJson = studentJson.trim().replaceAll(" +", " "); 
			if(mDebugEnabled == true){
				Log.d(mDebugTag, "studentJson : " + studentJson);
			}
			Gson gson = new Gson();
			StudentInfo studentInfo = gson.fromJson(studentJson,
					StudentInfo.class);
			if(mDebugEnabled == true){
				Log.d(mDebugTag,
						"studentName : "
								+ studentInfo.getCandidate()[0].getName());
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {

			if (mProgressDialog != null) {
				mProgressDialog.cancel();
			}

			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
			Log.i("", "setOnClickListener onPostExecute......");

			/* for sending object through intent */
			/*
			 * Intent intent = new Intent();
			 * intent.setClass(LoginActivity.this,MainActivity.class);
			 * intent.putExtra("profileObject", profile); startActivity(intent);
			 * finish(); Log.i("", "setOnClickListener onPostExecute......");
			 * //text.setText(response); Log.d(TAG, "responce is "+response);
			 */
		}
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.login_button) {

			InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

			mUserName = mUserNameEditText.getText().toString().trim();
			mPassword = mPasswordEditText.getText().toString().trim();

			mUserName = "nasar"; // TODO Temp Hack while development
			mPassword = "nasar";

			if (isUserNameNotEmpty(mUserName) && isPasswordNotEmpty(mPassword)) {
				if (Utilities.isNetworkAvailable(this)) {
					new GetStudentDetailsTask().execute();
				} else {
					Utilities mUltilities = new Utilities();
					mUltilities.showDialogConfirm(LoginActivity.this,
							"Message", "Please check network connection", true)
							.show();
				}
			}
		}
	}

	private boolean isUserNameNotEmpty(String name) {
		boolean nameisvalid = false;
		if (name != null && name.length() > 0) {
			nameisvalid = true;
		} else {
			nameisvalid = false;
			Utilities mUltilities = new Utilities();
			mUltilities.showDialogConfirm(LoginActivity.this, "Message",
					"Please enter User Name", true).show();

		}
		return nameisvalid;
	}

	private boolean isPasswordNotEmpty(String name) {
		if(mDebugEnabled == true){
			Log.d(mDebugTag, "control is Password is Required");
		}
		boolean nameisvalid = false;
		if (name != null && name.length() > 0) {
			nameisvalid = true;
		} else {
			nameisvalid = false;
			Utilities mUltilities = new Utilities();
			mUltilities.showDialogConfirm(LoginActivity.this, "Message",
					"Please enter Password", true).show();
		}
		return nameisvalid;
	}

}
