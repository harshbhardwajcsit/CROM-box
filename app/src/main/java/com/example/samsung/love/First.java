package com.example.samsung.love;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.samsung.love.Model.Person;
import com.firebase.client.Firebase;

public class First extends Activity implements View.OnClickListener {

    EditText username, email;
    Button enter;
    String userName,useremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac1);
        Firebase.setAndroidContext(this);



        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);


    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter:
                userName = username.getText().toString();
                useremail = email.getText().toString();


                Firebase ref = new Firebase("https://crombox-bd22b.firebaseio.com/");

                Firebase fb_to_read = ref.child("users");
                Firebase fb_put_child = fb_to_read.push(); // REMEMBER THIS FOR PUSH METHOD


                // Creating Person object
                Person person = new Person();

                //Adding values
                person.setName(userName);
                person.setemail(useremail);

                //Storing values to firebase

                // ref.setValue(person);
                fb_put_child.setValue(person);
                Toast.makeText(getBaseContext(), "Welcome" + username, Toast.LENGTH_LONG).show();
                Intent i=new Intent(First.this,MainActivity.class);
                startActivity(i);






        }

    }
}