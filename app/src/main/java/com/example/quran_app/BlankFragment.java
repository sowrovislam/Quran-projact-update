package com.example.quran_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class BlankFragment extends Fragment {


    LinearLayout qurannext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View myView=  inflater.inflate(R.layout.fragment_blank, container, false);

        qurannext=myView.findViewById(R.id.qurannext);

        qurannext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fremlayout,new BlankFragment2());
                fragmentTransaction.addToBackStack("hh");
                fragmentTransaction.commit();







            }
        });








        return myView;


    }
}