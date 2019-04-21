package com.example.juzza.mygamifieddegree;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    Dialog dialog;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DatabaseHelper(this);


        mTextUsername = findViewById(R.id.editText);
        mTextPassword = findViewById(R.id.editText2);
        mButtonLogin = findViewById(R.id.button);
        mTextViewRegister = findViewById(R.id.textView2);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUsers(user, pwd);
                if (res == true) {

                    dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.avatar_intro);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(LoginScreen);
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Error: Unable to log-in - could not find an existing user with that name and password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
