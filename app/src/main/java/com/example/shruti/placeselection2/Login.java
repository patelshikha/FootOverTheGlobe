package com.example.shruti.placeselection2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static com.example.shruti.placeselection2.R.id.login_emailid;
import static com.example.shruti.placeselection2.R.id.login_password;

public class Login extends AppCompatActivity {
    Button btnLogin, b2;
    RequestQueue queue;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.d("Shikha", "in onCreate");
        queue = Volley.newRequestQueue(getApplicationContext());
        setContentView(R.layout.login);
        email = (EditText) findViewById(login_emailid);
        password = (EditText) findViewById(login_password);
        addListenerOnButton();

    }

    public void addListenerOnButton() {
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkValidation()) {
                    JSONObject jsonParam = new JSONObject();
                    try {
                        jsonParam.put("email", email.getText().toString().trim());
                        jsonParam.put("password", password.getText().toString().trim());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.d("fog", "email: " + email.getText().toString().trim());
                    Log.d("fog", "password: " + password.getText().toString().trim());
                    Log.d("fog", "url: " + Constant.URL_LOGIN);

                    String urlString = "https://androidtutorialpoint.com/api/volleyString";
                    String urlJSONObject = "https://androidtutorialpoint.com/api/volleyJsonObject";
                    String urlJSONArray = "https://androidtutorialpoint.com/api/volleyJsonArray";
                    String urlImage = "https://androidtutorialpoint.com/api/lg_nexus_5x";
                    String urlJSON = "https://api.androidhive.info/volley/person_object.json";

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                            Constant.URL_LOGIN,
                            jsonParam,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        Log.d("fog", "on success: " + response.toString());

                                       /* String name = (String) response.get("name");
                                        int age = Integer.parseInt((String) response.get("age"));

                                        JSONArray jsonObjectHotel = response.getJSONArray("hotel");

                                        for (int i = 0; i < jsonObjectHotel.length(); i++) {
                                            JSONObject myObj = (JSONObject) jsonObjectHotel.get(i);


                                        }
    */
                                    } catch (Exception e) {
                                        Log.d("fog", "Response Exception " + e.getMessage());
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("fog", "Response Error Stack " + Arrays.toString(error.getStackTrace()));
                                    Log.d("fog", "Response Error Message " + error.getMessage());
                                    Log.d("fog", "Response Error Cause " + error.getCause());
                                    Log.d("fog", "Response Error String " + error.toString());

                                }
                            });

                    queue.add(jsonObjectRequest);
                }
            }
        });
    }

    boolean checkValidation() {
        boolean isValid = true;

        if (email.getText().toString().trim().isEmpty()) {
            isValid = false;

            email.setError("Email is required.");
        }

        if (password.getText().toString().trim().isEmpty()) {
            isValid = false;

            password.setError("Password is required.");
        }

        return isValid;
    }
}