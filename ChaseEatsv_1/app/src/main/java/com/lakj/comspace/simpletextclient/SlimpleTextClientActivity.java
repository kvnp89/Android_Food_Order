package com.lakj.comspace.simpletextclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;





public class SlimpleTextClientActivity extends Activity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slimple_text_client);
        Name = (EditText)findViewById(R.id.EtId);
        Password = (EditText)findViewById(R.id.editText2);
        Info = (TextView)findViewById(R.id.TvInfo);
        Login = (Button)findViewById(R.id.btnlgn);

        Info.setText("No of Attempts Remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void validate(String username , String password){
        if ((username.equals("admin")) && (password.equals("1234"))){
            Intent intent= new Intent(SlimpleTextClientActivity.this, Order_Type.class);
            startActivity(intent);
        }else {
            counter--;
            Info.setText("No of Attempts remaining: " + String.valueOf(counter));
            if(counter == 0 ){
                Login.setEnabled(false);
            }
        }
    }


}
