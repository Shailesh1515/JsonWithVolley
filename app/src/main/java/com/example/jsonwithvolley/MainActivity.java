package com.example.jsonwithvolley;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url="https://api.androidhive.info/contacts/";
    List<DataModel>list=new ArrayList<>();
    ListView listView;
    String mo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray array=object.getJSONArray("contacts");

                    for (int i=0;i<=array.length();i++){
                        JSONObject object1=array.getJSONObject(i);

                        String name=object1.getString("name");
                        String email=object1.getString("email");
                        String id=object1.getString("id");
                        String gender=object1.getString("gender");

                        for (int j=0;j<=array.length();j++){

                            JSONObject phone=object1.getJSONObject("phone");
                            mo=phone.getString("mobile");
                        }

                        DataModel model=new DataModel();
                        model.setEmail(email);
                        model.setGender(gender);
                        model.setId(id);
                        model.setMo(mo);
                        model.setName(name);

                        list.add(model);

                        Base_Adapter adapter=new Base_Adapter(MainActivity.this,list);
                        listView.setAdapter(adapter);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        queue.add(request);
    }
}
