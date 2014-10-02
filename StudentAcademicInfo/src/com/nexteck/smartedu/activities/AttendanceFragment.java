package com.nexteck.smartedu.activities;

import com.nextech.smartedu.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AttendanceFragment extends Fragment {
	
	public AttendanceFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_attendance, container, false);
         
        return rootView;
    }
}
