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

    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    HashMap<String,String>hashMap;


    ArrayList<HashMap<String,String>>arrayList1=new ArrayList<>();

    HashMap<String,String>hashMap1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        View myview=inflater.inflate(R.layout.fragment_blank2, container, false);





        recyclerView=myview.findViewById(R.id.recyclerView);

        progressBar=myview.findViewById(R.id.prog);




        String url ="https://cdn.jsdelivr.net/npm/quran-json@3.1.2/dist/quran_bn.json";

        progressBar.setVisibility(View.VISIBLE);


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                progressBar.setVisibility(View.GONE);


                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String transliteration = jsonObject.getString("transliteration");

                        hashMap = new HashMap<>();
                        hashMap.put("id", id);
                        hashMap.put("transliteration", transliteration);
                        arrayList.add(hashMap);





                        JSONArray versesArray=jsonObject.getJSONArray("verses");

                        for (int x = 0; x < versesArray.length(); x++) {


                            JSONObject verseObject = versesArray.getJSONObject(x);




                            String name = verseObject.getString("translation");
                            String verseId = verseObject.getString("id");
                            String text = verseObject.getString("text");




                            hashMap1 = new HashMap<>();
                            hashMap1.put("name", name);
                            hashMap1.put("id", verseId);
                            hashMap1.put("text", text);
                            arrayList1.add(hashMap1);






                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace(); // or handle the exception appropriately
                }




                Myadapter myadapter = new Myadapter();
                recyclerView.setAdapter(myadapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);

        















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

           String transliteration= hashMap.get("transliteration");
           String type= hashMap.get("type");


//
//
//            String text= hashMap.get("text");
//            String translation1= hashMap.get("translation1");
//            String id1= hashMap.get("id1");
//
//



//
//
//            holder.tvBangla.setText(""+type);
            holder.tvnumbar.setText(""+id);

//            holder.tvRb.setText(""+name);


            holder.tvEnglish.setText(""+transliteration);





            hashMap1=arrayList1.get(position);

            String text= hashMap1.get("text");
            String name= hashMap1.get("name");
            String id1= hashMap1.get("id");















            holder.cardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    BlankFragment3.ARABIC=name;

                    BlankFragment3.BANGLA=text;
                    BlankFragment3.NEXTDIS=id1;





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









    }


