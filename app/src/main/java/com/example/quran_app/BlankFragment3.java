package com.example.quran_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class BlankFragment3 extends Fragment {


    TextView textView;


    public static String BANGLA="";

    public static String ARABIC="";
    public static String NEXTDIS="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview=inflater.inflate(R.layout.fragment_blank3, container, false);


textView =myview.findViewById(R.id.textnext);


textView.setText(""+ARABIC);




//
//
//
//        String  id=jsonObject.getString("id");
//
//        String   name=jsonObject.getString("name");
//
//        String transliteration=jsonObject.getString("transliteration");
//
//        String translation=jsonObject.getString("translation");
//
//        String  type=jsonObject.getString("type");
//
//        String total_verses=jsonObject.getString("total_verses");
//
//
//
//        String text = jsonObject1.getString("text");
//        String translation1 = jsonObject1.getString("translation");
//        String id1 = jsonObject1.getString("id");
//
//
//
//
//
//
//        hashMap=new HashMap<>();
//        hashMap.put("id",id);
//        hashMap.put("name",name);
//        hashMap.put("transliteration",transliteration);
//        hashMap.put("translation",translation);
//        hashMap.put("type",type);
//        hashMap.put("total_verses",total_verses);
//
////
////                        hashMap.put("text",text);
////                        hashMap.put("translation1",translation1);
////                        hashMap.put("id1",id1);
//
//        arrayList.add(hashMap);

















        return myview;
    }
}