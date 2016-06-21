/** AMIT GUPTA
 *  21/06/2016
 *  This App Saves the values of the Variables when the screen
 */
package com.example.amitgupta.orientationtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    TextView textViewName;
    Button buttonOrientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);  // Links Java and XML Button , so that you can make chage
        textViewName = (TextView) findViewById(R.id.textViewName);  // by java code.
        buttonOrientation = (Button) findViewById(R.id.buttonOrientation);

//        textViewName.setText(editTextName.getText().toString());    //Runs only once

        // Listens to the Text Type in EditText
        // OnClickListener is an INTERFACE, so what we do is create its object by defining the unimplemented method
        // This is called use of Anonymous Class , as you cannot refer to its object
        //This is Like Knocking on the door.
        editTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //To know the view that was clicked
                textViewName.setText("Name:"+editTextName.getText().toString()); // Now this runs everytime you PRESS the EditText
                                                                        // NOT when the text is changed.
            }
        });

        // You can Notice that when you change the Orientation The Text in the TextView is set to what is was in the begining.
        // So lets go in Another Activity and solve this problem and see the differences.

        // Listen when the button(View) is Press and you can change the Activity using this concept.
        buttonOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,OrientationAffect.class);
                startActivity(i);
            }
        });

    }


}
