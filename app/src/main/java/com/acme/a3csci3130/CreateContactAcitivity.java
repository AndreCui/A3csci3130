package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, businessnumberField, primarybusinessField, addressField,provinceField;
    private MyApplicationData appState;

    @Override
    /**protected method onCreate initialize all the fields
     * @param savadInstanceState is the current state
     * */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        businessnumberField = (EditText) findViewById(R.id.businessnumber);

        primarybusinessField = (EditText) findViewById(R.id.primarybusiness);
        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


    }
/** this method store all the information*/
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String businessnumber=businessnumberField.getText().toString();
        String primarybusiness=primarybusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province =provinceField.getText().toString();
        Contact person= new Contact(personID, name,businessnumber,primarybusiness,address,province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }
}
