package com.example.putuguna.retrofit2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.putuguna.retrofit2.apis.ApiClient;
import com.example.putuguna.retrofit2.apis.ApiService;
import com.example.putuguna.retrofit2.models.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button getData;
    private TextView id;
    private TextView name;
    private TextView job;
    private TextView age;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = (Button) findViewById(R.id.getprofile);
        id = (TextView) findViewById(R.id.idprofile);
        name = (TextView) findViewById(R.id.nameprofle);
        job = (TextView) findViewById(R.id.jobprofile);
        age = (TextView) findViewById(R.id.ageprofle);


        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Get My Prole");
                progressDialog.setMessage("Loading ...");
                progressDialog.show();

                getProfile();
            }
        });
    }

    private void getProfile(){
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Profile> call = apiService.getMyProfile("1");
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                progressDialog.dismiss();
                Profile p = response.body();

                id.setText(p.getId());
                name.setText(p.getName());
                job.setText(p.getJob());
                age.setText(p.getAge());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed to load", Toast.LENGTH_LONG).show();
            }
        });
    }
}
