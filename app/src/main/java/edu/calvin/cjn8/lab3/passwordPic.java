package edu.calvin.cjn8.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;

/* Lab 3 for CS 262
 *
 * @author: Corey Noble
 * @version: 1.0 (Fall 2016)
 */

public class passwordPic extends AppCompatActivity{

    // Variables
    private EditText passwordField;
    private ImageView imageArea;
    private TextView invalidPass;
    private SharedPreferences savedValues;
    private String passwordString = "";
    private String actualPassword = "cs262";

    // Main function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_pic);
        passwordField = (EditText) findViewById(R.id.passField);
        imageArea = (ImageView) findViewById(R.id.imageArena);
        imageArea.setVisibility(View.GONE);
        invalidPass = (TextView) findViewById(R.id.invalidLabel);
        invalidPass.setVisibility(View.GONE);

        // Create listener for change in password entry field
        passwordField.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                passwordString = passwordField.getText().toString();
                if (passwordString.equals(actualPassword)) {
                    imageArea.setVisibility(View.VISIBLE);
                    invalidPass.setVisibility(View.GONE);
                }
                else {
                    imageArea.setVisibility(View.GONE);
                    invalidPass.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }
}
