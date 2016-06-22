package com.example.amitgupta.orientationtestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OrientationAffect extends Activity{

    EditText editTextName;
    TextView textViewName;
    String saveOrientationName;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_affect);
        editTextName = (EditText) findViewById(R.id.editTextName);
        textViewName = (TextView) findViewById(R.id.textViewName);

        // Used to get data from Main Class.
      /*  MainActivity m = new MainActivity();
        m.test();*/

        String nameFromMainActivity= this.getIntent().getStringExtra("editTextName");
        textViewName.setText(nameFromMainActivity);
        editTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //To know the view that was clicked
                name = editTextName.getText().toString();
                textViewName.setText(name); // Now this runs everytime you PRESS the EditText
                // NOT when the text is changed.
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveOrientationName = editTextName.getText().toString();    // Showed Error when used textViewName.toString();
        outState.putString("saveOrientationName",saveOrientationName); // Use the Method putString() to save Value
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //Same Bundle is Passed to OnRestoreInstaceState() and onCreate()
        //We can use onCreate instead of onRestoreInsatnceState()
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString("saveOrientationName");
        textViewName.setText(name);
        Log.d("DataSaved: ",name);  //to Check
    }
}
