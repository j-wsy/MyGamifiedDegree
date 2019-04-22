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
    Button nextButton;
    TextView mTextViewRegister;
    DatabaseHelper db;
    Dialog dialog;
    Dialog dialog2;
    Dialog dialog3;
    Dialog dialog4;
    Dialog dialog5;
    Dialog dialog6;


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
                    nextButton = (Button) dialog.findViewById(R.id.nextButton);
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(LoginScreen);
                        }
                    });

                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog2 = new Dialog(MainActivity.this);
                            dialog2.setContentView(R.layout.onboarding_1);
                            ImageView closeButton = (ImageView) dialog2.findViewById(R.id.closeButton);
                            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog2.show();
                            Button nextButton = (Button) dialog2.findViewById(R.id.nextButton);
                            closeButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog2.dismiss();
                                    Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(LoginScreen);
                                }
                            });

                            nextButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog3 = new Dialog(MainActivity.this);
                                    dialog3.setContentView(R.layout.onboarding_2);
                                    ImageView closeButton = (ImageView) dialog3.findViewById(R.id.closeButton);
                                    dialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog3.show();
                                    Button nextButton = (Button) dialog3.findViewById(R.id.nextButton);
                                    closeButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog3.dismiss();
                                            Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                            startActivity(LoginScreen);
                                        }
                                    });

                                    nextButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog4 = new Dialog(MainActivity.this);
                                            dialog4.setContentView(R.layout.onboarding_3);
                                            ImageView closeButton = (ImageView) dialog4.findViewById(R.id.closeButton);
                                            dialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                            dialog4.show();
                                            Button nextButton = (Button) dialog4.findViewById(R.id.nextButton);
                                            closeButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    dialog4.dismiss();
                                                    Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                                    startActivity(LoginScreen);
                                                }
                                            });

                                            nextButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    dialog5 = new Dialog(MainActivity.this);
                                                    dialog5.setContentView(R.layout.onboarding_4);
                                                    ImageView closeButton = (ImageView) dialog5.findViewById(R.id.closeButton);
                                                    dialog5.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                                    dialog5.show();
                                                    Button nextButton = (Button) dialog5.findViewById(R.id.nextButton);
                                                    closeButton.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            dialog5.dismiss();
                                                            Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                                            startActivity(LoginScreen);
                                                        }
                                                    });
                                                    nextButton.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            dialog6 = new Dialog(MainActivity.this);
                                                            dialog6.setContentView(R.layout.onboarding_5);
                                                            ImageView closeButton = (ImageView) dialog6.findViewById(R.id.closeButton);
                                                            dialog6.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                                            dialog6.show();
                                                            Button nextButton = (Button) dialog6.findViewById(R.id.nextButton);
                                                            closeButton.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View v) {
                                                                    dialog6.dismiss();

                                                                    Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                                                    startActivity(LoginScreen);
                                                                }
                                                            });
                                                            nextButton.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View v) {
                                                                    dialog6.dismiss();

                                                                    Intent LoginScreen = new Intent(MainActivity.this, HomeActivity.class);
                                                                    startActivity(LoginScreen);
                                                                }
                                                            });


                                                        }
                                                    });
                                                }
                                            });
                                        }

                                    });
                                }
                            });
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error: Unable to log-in - could not find an existing user with that name and password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
