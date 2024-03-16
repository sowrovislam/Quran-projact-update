package com.example.quran_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BlankFragment3 extends Fragment {


    TextView textView;

    ProgressBar progressBar;


    public static String BANGLA="";

    public static String ARABIC="";
    public static String NEXTDIS="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview=inflater.inflate(R.layout.fragment_blank3, container, false);


               textView =myview.findViewById(R.id.textnext);


               textView.append("\n\n"+ARABIC+"\n\n"+BANGLA+"\n\n"+NEXTDIS);



























        return myview;
    }
}