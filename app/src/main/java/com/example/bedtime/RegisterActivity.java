package com.example.bedtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText mEmailField,mPasswordField;
    Button mNextButton;
    TextView mEmailError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailField = findViewById(R.id.reg_email);
        mPasswordField = findViewById(R.id.reg_password);
        mNextButton = findViewById(R.id.reg_next);
        mEmailError = findViewById(R.id.email_error);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailField.getText().toString().trim();
                String password = mPasswordField.getText().toString().trim();

                //validate form input
                if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mEmailError.setVisibility(View.VISIBLE);
                    return;
                }
                if(password.isEmpty()){
                    mPasswordField.setError("Password cannot be empty!");
                    return;
                }
                //start next activity for more detail and pass the email and password.
                Intent intent = new Intent(RegisterActivity.this,ProfileRegisterActivity.class);
                intent.putExtra(ProfileRegisterActivity.REGISTER_EMAIL,email);
                intent.putExtra(ProfileRegisterActivity.REGISTER_PASSWORD,password);
                startActivity(intent);
            }
        });
    }

    public void goToLogin(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}
