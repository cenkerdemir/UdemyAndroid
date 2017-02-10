package com.cenkerdemir.buttonappforudemycourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.userNameTextField);
        EditText passwordTextField = (EditText) findViewById(R.id.passwordTextField);
        Log.i("username", usernameTextField.getText().toString());
        Log.i("password", passwordTextField.getText().toString());

        Toast.makeText(this, "Hi there, " + usernameTextField.getText().toString() + "!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
