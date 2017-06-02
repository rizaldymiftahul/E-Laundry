package com.e_laundry.user.e_laundry;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.e_laundry.user.e_laundry.app.Controller;
import com.e_laundry.user.e_laundry.server.Server;
import com.e_laundry.user.e_laundry.sharedpref.SharedPref;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class alamat extends AppCompatActivity {
    String tag_json_obj = "json_obj_req";

    private static final String TAG_MESSAGE = "message";


    ProgressDialog pDialog;

    private String url = Server.URL + "simpan.php";

    private static final String TAG = alamat.class.getSimpleName();

    private EditText tglambil, tglantar, Alamat, catatan;

  //  private Button Simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alamat);
        final Button btnSave = (Button) findViewById(R.id.btnSave);
        tglambil = (EditText) findViewById(R.id.edtWaktu);
        tglantar = (EditText) findViewById(R.id.edtTanggal);
        Alamat = (EditText) findViewById(R.id.edtAlamatLengkap);
        catatan = (EditText) findViewById(R.id.edtCatatan);
        // Simpan = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent iList = new Intent(getApplicationContext(), proses.class);
//                startActivity(iList);

                simpanData(tglambil.getText().toString(),
                        tglantar.getText().toString(),
                        Alamat.getText().toString(),
                        catatan.getText().toString());

            }

        });
    }

    private void simpanData(final String tglambil, final String tglantar, final String Alamat, final String catatan) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("simpan.....");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Simpan Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        //String email = jObj.getString("email");
                        //String id = jObj.getString("id");

                        //menyimpan variabel sharedpref
                        //SharedPref.getInstance(getApplicationContext()).Login(email);

                        Log.e("Successfully Simpan!", jObj.toString());

                        Toast.makeText(getApplicationContext(),
                                "data telah tersimpan", Toast.LENGTH_LONG).show();

                        // Memanggil main activity
                        //Intent intent = new Intent(login.this,
                          //      navigation.class);
                        //intent.putExtra(TAG_ID, id);
                        //intent.putExtra(TAG_USERNAME, email);
                        //inish();
                        //startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Simpan Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("tgl_ambil", tglambil);
                params.put("tgl_antar", tglantar);
                params.put("alamat", Alamat);
                params.put("catatan", catatan);

                return params;
            }

        };

        // Adding request to request queue
        Controller.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
