package com.nexteck.smartedu.activities;

import com.nextech.smartedu.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClassworkFragment extends Fragment {
	
	public ClassworkFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_class_work, container, false);
         
        return rootView;
    }
}
