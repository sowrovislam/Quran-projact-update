package com.example.quran_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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


public class BlankFragment2 extends Fragment {


  RecyclerView recyclerView;
  ProgressBar progressBar;

  ArrayList<HashMap<String,String>>arrayList;
  HashMap<String,String>hashMap;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview=inflater.inflate(R.layout.fragment_blank2, container, false);


        recyclerView=myview.findViewById(R.id.recyclerView);

        progressBar=myview.findViewById(R.id.prog);

            arrayList=new ArrayList<>();



        Fragment();
















        return myview;
    }


    public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder>{

        public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tvnumbar,tvBangla,tvRb,tvEnglish;

            LinearLayout cardButton;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);


                tvnumbar=itemView.findViewById(R.id.tvnumbar);

                tvBangla=itemView.findViewById(R.id.tvBangla);

                tvRb=itemView.findViewById(R.id.tvRb);

                tvEnglish=itemView.findViewById(R.id.tvEnglish);


                cardButton=itemView.findViewById(R.id.cardButton);





            }
        }



        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater=getLayoutInflater();
            View myview=layoutInflater.inflate(R.layout.layout2,parent,false);


            return new MyViewHolder(myview);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


           hashMap=arrayList.get(position);

            String id= hashMap.get("id");
           String name= hashMap.get("name");
           String transliteration= hashMap.get("transliteration");
           String type= hashMap.get("type");

            String text= hashMap.get("text");
            String translation1= hashMap.get("translation1");
            String id1= hashMap.get("id1");








            holder.tvnumbar.setText(""+id);
            holder.tvRb.setText(""+name);
            holder.tvEnglish.setText(""+transliteration);
            holder.tvBangla.setText(""+type);










            holder.cardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    BlankFragment3.ARABIC=text;



                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fremlayout,new BlankFragment3());
                    fragmentTransaction.addToBackStack("hh");
                    fragmentTransaction.commit();






                }
            });






        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }





    public  void Fragment(){


        String url ="https://cdn.jsdelivr.net/npm/quran-json@3.1.2/dist/quran_bn.json";



        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                progressBar.setVisibility(View.GONE);

                for (int x=0;x<response.length();x++){

                    try {

                        JSONObject jsonObjec=response.getJSONObject(x);

                        JSONArray jsonArray=jsonObjec.getJSONArray("verses");

                        for (int t=0;t<jsonArray.length();t++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(t);


                            String text = jsonObject1.getString("text");
                            String translation1 = jsonObject1.getString("translation");
                            String id1 = jsonObject1.getString("id");



                            hashMap=new HashMap<>();

                            hashMap.put("text",text);
                            hashMap.put("translation1",translation1);
                            hashMap.put("id1",id1);

                            arrayList.add(hashMap);








                        }










                    } catch (JSONException e) {

                        throw new RuntimeException(e);
                    }


                }










                for (int i=0;i<response.length();i++){

                    try {
                        JSONObject jsonObject=response.getJSONObject(i);


                        String  id=jsonObject.getString("id");

                        String   name=jsonObject.getString("name");

                        String transliteration=jsonObject.getString("transliteration");

                        String translation=jsonObject.getString("translation");

                        String  type=jsonObject.getString("type");

                        String total_verses=jsonObject.getString("total_verses");



                        arrayList=new ArrayList<>();

                        hashMap=new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("name",name);
                        hashMap.put("transliteration",transliteration);
                        hashMap.put("translation",translation);
                        hashMap.put("type",type);
                        hashMap.put("total_verses",total_verses);

                        arrayList.add(hashMap);








                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                }




















                Myadapter myadapter = new Myadapter();
                recyclerView.setAdapter(myadapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);


            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);










    }


}