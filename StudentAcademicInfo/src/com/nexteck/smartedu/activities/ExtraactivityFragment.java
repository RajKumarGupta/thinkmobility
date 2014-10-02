

package com.nexteck.smartedu.activities;

import com.nextech.smartedu.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExtraactivityFragment extends Fragment {
	
	public ExtraactivityFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_extra_activity, container, false);
         
        return rootView;
    }
}
