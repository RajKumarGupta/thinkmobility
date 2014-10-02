package com.nexteck.smartedu.activities;



import java.util.Date;

import com.nextech.smartedu.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

	TextView studentName;
	TextView clasz;
	TextView rollNumbar;
	TextView gender;
	TextView dateOfBirth;
	TextView address;
	TextView studentPhone;
	TextView studentMobile;
	TextView studentEmail;
	TextView achivement1;
	TextView achivement1Date;
	TextView achivement1Descrition;
	TextView achivement2;
	TextView achivement2Date;
	TextView achivement2Description;
	TextView achivement3;
	TextView achivement3Date;
	TextView achivement3Description;
	TextView fatherName;
	TextView fatherDateOfBirth;
	TextView fatherQualification;
	TextView fatherPhone;
	TextView fatherMobile;
	TextView fatherEmail;
	TextView motherName;
	TextView motherDateOfBirth;
	TextView motherQualification;
	TextView motherPhone;
	TextView motherMobile;
	TextView motherEmail;
	TextView achivements;

	public ProfileFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		View rootView = inflater.inflate(R.layout.fragment_profile, container,
				false);
		/*
		 * Bundle args = getArguments(); Profile profile =
		 * (Profile)args.getSerializable("profile");
		 * 
		 * //Log.i(ProfileFragment.class.getName(),"Profile Eail--++-->> "
		 * +profile.getEmail());
		 * 
		 * 
		 * studentName = (TextView) rootView.findViewById(R.id.textView1_value);
		 * clasz = (TextView) rootView.findViewById(R.id.textView2_value);
		 * rollNumbar = (TextView) rootView.findViewById(R.id.textView3_value);
		 * gender = (TextView) rootView.findViewById(R.id.textView4_value);
		 * dateOfBirth = (TextView) rootView.findViewById(R.id.textView5_value);
		 * address = (TextView) rootView.findViewById(R.id.textView6_value);
		 * studentPhone = (TextView)
		 * rootView.findViewById(R.id.textView7_value); studentMobile =
		 * (TextView) rootView.findViewById(R.id.textView8_value); studentEmail
		 * = (TextView) rootView.findViewById(R.id.textView9_value); achivement1
		 * = (TextView) rootView.findViewById(R.id.textView10_value);
		 * achivement2 = (TextView)
		 * rootView.findViewById(R.id.textView12_value); achivement3 =
		 * (TextView) rootView.findViewById(R.id.textView15_value); fatherName =
		 * (TextView) rootView.findViewById(R.id.textView18_value);
		 * fatherDateOfBirth = (TextView)
		 * rootView.findViewById(R.id.textView19_value); fatherQualification =
		 * (TextView) rootView.findViewById(R.id.textView20_value); fatherPhone
		 * = (TextView) rootView.findViewById(R.id.textView21_value);
		 * fatherMobile = (TextView)
		 * rootView.findViewById(R.id.textView22_value); fatherEmail =
		 * (TextView) rootView.findViewById(R.id.textView23_value); motherName =
		 * (TextView) rootView.findViewById(R.id.textView24_value);
		 * motherDateOfBirth = (TextView)
		 * rootView.findViewById(R.id.textView25_value); motherQualification =
		 * (TextView) rootView.findViewById(R.id.textView26_value); motherPhone
		 * = (TextView) rootView.findViewById(R.id.textView27_value);
		 * motherMobile = (TextView)
		 * rootView.findViewById(R.id.textView28_value); motherEmail =
		 * (TextView) rootView.findViewById(R.id.textView29_value); achivements
		 * = (TextView) rootView.findViewById(R.id.textView_achivements);
		 * 
		 * 
		 * 
		 * 
		 * studentName.setText(": "+profile.getName());
		 * clasz.setText(": "+profile.getClasz());
		 * rollNumbar.setText(": "+profile.getRollNumber());
		 * gender.setText(": "+profile.getSex());
		 * dateOfBirth.setText(String.valueOf(": "+profile.getDateOfBirth()));
		 * address.setText(String.valueOf(": "+profile.getAddress()));
		 * studentPhone.setText(": "+profile.getPhone());
		 * studentMobile.setText(": "+profile.getMobile());
		 * studentEmail.setText(": "+profile.getEmail());
		 * fatherName.setText(": "+profile.getFather().getName());
		 * fatherDateOfBirth
		 * .setText(": "+String.valueOf(profile.getFather().getDateOfBirth()));
		 * /
		 * /fatherQualification.setText(profile.getFather().getQualification());
		 * fatherPhone.setText(": "+profile.getFather().getPhone());
		 * fatherMobile.setText(": "+profile.getFather().getMobile());
		 * fatherEmail.setText(": "+profile.getFather().getEmail());
		 * motherName.setText(": "+profile.getMother().getName());
		 * motherDateOfBirth
		 * .setText(": "+String.valueOf(profile.getMother().getDateOfBirth()));
		 * /
		 * /motherQualification.setText(profile.getMother().getQualification());
		 * motherPhone.setText(": "+profile.getMother().getPhone());
		 * motherMobile.setText(": "+profile.getMother().getMobile());
		 * motherEmail.setText(": "+profile.getMother().getEmail());
		 * 
		 * 
		 * 
		 * 
		 * for(Achivements achivement : profile.getAchivements()){ if
		 * (profile.getAchivements().size()>0){
		 * 
		 * achivements.setVisibility(1);
		 * 
		 * achivement1.setText(achivement.getAchivement());
		 * 
		 * } }
		 */

		return rootView;

	}
}