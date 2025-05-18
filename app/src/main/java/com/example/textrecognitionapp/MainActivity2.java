package com.example.textrecognitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText eName;
    private EditText ePass;
    private Button eLog;
    private TextView eAtt;
    private int counter = 5;

    Credentials credentials = new Credentials("Admin","12345678");
    boolean isValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        eName = findViewById(R.id.etName);
        ePass = findViewById(R.id.etPassword);
        eLog = findViewById(R.id.btLogin);
        eAtt = findViewById(R.id.tvnoAttempts);

        eLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPass = ePass.getText().toString();

                if(inputName.isEmpty() || inputPass.isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "Please enter name and password!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    isValid = validate(inputName,inputPass);

                    if(!isValid) {
                        counter--;
                        eAtt.setText("Attempts Remaining: " + String.valueOf(counter));


                        if (counter == 0) {
                            eLog.setEnabled(false);
                            Toast.makeText(MainActivity2.this, "You have used all your attempts try again later!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity2.this, "Incorrect credentials, please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {

                        /* Allow the user in to your app by going into the next activity */
                        startActivity(new Intent(MainActivity2.this, MainActivity.class));
                    }

                }
            }
        });
    }
    private boolean validate(String userName, String userPassword)
    {
        if(userName.equals(credentials.getName()) && userPassword.equals(credentials.getPassword()))
        {
            return true;
        }
        return false;
    }

}
