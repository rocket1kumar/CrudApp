package com.example.android.crudapp;

/**
 * Created by Vipul Kumar Maurya on 23-07-2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteEmployee extends AppCompatActivity {
    EditText Ename, Eid;
    Button Btndelete;
    DbHelperClass dbHelperClass = new DbHelperClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);


        Ename = (EditText) findViewById(R.id.name);
        Eid = (EditText) findViewById(R.id.id);
        Btndelete = (Button) findViewById(R.id.delete);

        // on click listener for delete button
        Btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // calling method int delete(...) from DbHelperClass
                    int d = dbHelperClass.delete(Eid.getText().toString(), Ename.getText().toString());
                    if (d > 0)
                        Toast.makeText(DeleteEmployee.this, d + " row deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DeleteEmployee.this, " rows can not be deleted", Toast.LENGTH_SHORT).show();

                } finally {
                    // this will close the activity
                    finish();
                }
            }

        });

    }
}
