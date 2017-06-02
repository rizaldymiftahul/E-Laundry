package com.e_laundry.user.e_laundry;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.e_laundry.user.e_laundry.app.Controller;
import com.e_laundry.user.e_laundry.server.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

import static java.security.AccessController.getContext;

public class detail_pesanan extends AppCompatActivity {

    private String url = Server.URL + "simpan.php";

    private JSONArray orders = null;
    //private ArrayList<HashMap<String, String>> listItem;
    private ArrayList listItem;

    private Inflater inflat;

    private ListView listBaru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        listBaru = (ListView) findViewById(R.id.list_tempat);
        listItem = new ArrayList<HashMap<String,String>>();
        //sqlite = new SQLiteHelper(getActivity());
        getDataOrderOnline();
    }

    private void getDataOrderOnline(){
        //final String email = SharedPrefManager.getInstance(getContext()).getEmail();
        //progressBar.setVisibility(View.VISIBLE);
        //invisible();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject("data");
                            if (jsonObject.getBoolean("error") == false) {
                            //    progressBar.setVisibility(View.INVISIBLE);
                                if (jsonObject.getInt("jlh_data") == 0){
                              //      txtJlhData.setVisibility(View.VISIBLE);
                                }else {
                                //    invisible();
                                    ///show list
                                    try {
                                        orders = jsonObject.getJSONArray("data");
                                        ListBaruGetSet varGetSet = null;
                                        listItem = new ArrayList<>();
                                        for (int i = 0; i < orders.length(); i++) {
                                            JSONObject c = orders.getJSONObject(i);

                                            varGetSet = new ListBaruGetSet();
                                            /**varGetSet.setNo_pemesanan(c.getString("no_pemesanan"));
                                            varGetSet.setKeahlian(c.getString("keahlian"));
                                            varGetSet.setTanggal(c.getString("tgl_pemesanan"));
                                            varGetSet.setJam(c.getString("jam_pemesanan"));
                                            varGetSet.setDeskripsi(c.getString("deskripsi"));
                                            varGetSet.setNamaCust(c.getString("nama_cust"));
                                            varGetSet.setNoTelp(c.getString("telp_cust"));
                                            varGetSet.setTempat(c.getString("tempat")); */
                                            listItem.add(varGetSet);

                                        }

                                        ListAdapter adapter = new OrderAdapter(detail_pesanan.this, listItem);
                                        listBaru.setAdapter(adapter);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"),
                                        Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Koneksi bermasalah", Toast.LENGTH_SHORT).show();
                        //progressBar.setVisibility(View.INVISIBLE);
                        //btnCobaLagi.setVisibility(View.VISIBLE);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("email", email);
                return params;
            }
        };
        Controller.getInstance().addToRequestQueue(stringRequest);



    }

    private void invisible(){
        //btnCobaLagi.setVisibility(View.INVISIBLE);
        //txtJlhData.setVisibility(View.INVISIBLE);
    }

    private void visible(){
      //  btnCobaLagi.setVisibility(View.VISIBLE);
        //txtJlhData.setVisibility(View.VISIBLE);
    }
}

