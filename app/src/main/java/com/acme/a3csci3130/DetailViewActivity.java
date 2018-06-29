package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, businessnumberField, primarybusinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    //protected method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        //get the shared variables
        appState=((MyApplicationData) getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        primarybusinessField = (EditText) findViewById(R.id.primarybusiness);
        businessnumberField = (EditText) findViewById(R.id.businessnumber);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            businessnumberField.setText(receivedPersonInfo.businessnumber);
            primarybusinessField.setText(receivedPersonInfo.primarybusiness);

            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);


        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        String uid= receivedPersonInfo.uid;
        String name= nameField.getText().toString();
        String businessnumber = businessnumberField.getText().toString();
        String primarybusiness = primarybusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Contact person =new Contact(receivedPersonInfo.uid,name,businessnumber,primarybusiness,address,province);
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(person);
        finish();
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }
}
