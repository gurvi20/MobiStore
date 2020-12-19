package com.example.mobistorefinal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<AuthUI.IdpConfig> provider;
    private  static final int request_code=1234;
    //Button sign_out;
    Button click_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click_me=(Button)findViewById(R.id.clickHere);

        click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signout = new Intent(MainActivity.this, Try.class);
                startActivity(signout);
                /**/

            }
        });
        provider= Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());

        showSignInOptions();
    }
    public void showSignInOptions(){

        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(provider).setTheme(R.style.MyTheme)
                        .build(),request_code
        );
    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == request_code) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, "OK" + user.getEmail(), Toast.LENGTH_SHORT).show();
                click_me.setEnabled(true);
            } else {
                Toast.makeText(this, "Error" + response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }


        }
    }

}
