package com.example.juzza.mygamifieddegree;


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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    Button testBtn;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MyDegree");

        //actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFEE58")));
        //actionBar.setTitle(Html.fromHtml("<font color='#000000'> MyDegree </font>"));



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
        testBtn = findViewById(R.id.btntest);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUsers(user, pwd);
                if (res == true) {
                    Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(LoginScreen);
                } else {
                    Toast.makeText(MainActivity.this, "Error: Unable to log-in - could not find an existing user with that name and password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


//Hello This is Jade Soo
//Justin Test
//Hi, Eric here
//  GARRY HEREE