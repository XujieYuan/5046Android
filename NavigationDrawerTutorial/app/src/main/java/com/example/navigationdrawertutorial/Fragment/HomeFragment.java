package com.example.navigationdrawertutorial.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.navigationdrawertutorial.R;

public class HomeFragment extends Fragment {
    private TextView textView;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the View for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        textView=view.findViewById(R.id.tv);
        textView.setText("This is HOME");
        return view;
    }
}