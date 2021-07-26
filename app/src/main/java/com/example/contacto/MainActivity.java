package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText name;
    private EditText phone;
    private EditText mail;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting date selector
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                }
            });
                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month  + "/" + year;
                        mDisplayDate.setText(date);
                    }
                };




        Button btnNext = (Button) findViewById(R.id.btnNext);

        name = (EditText) findViewById(R.id.editTextTextPersonName);
        phone = (EditText) findViewById(R.id.editTextPhone);
        mail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        description = (EditText) findViewById(R.id.editTextTextMultiLine);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,DetalleContacto.class);
                miIntent.putExtra("name",name.getText().toString());
                miIntent.putExtra("date", mDisplayDate.getText().toString());
                miIntent.putExtra("phone",phone.getText().toString());
                miIntent.putExtra("mail",mail.getText().toString());
                miIntent.putExtra("description",description.getText().toString());
                startActivity(miIntent);
            }
        });

        // Catching params from activity_main
        try {
            Bundle params = getIntent().getExtras();
            String pname = params.getString("name");
            String pdate  = params.getString(("date"));
            String pphone = params.getString("phone");
            String pmail = params.getString("mail");
            String pdescription = params.getString("description");

            name.setText(pname);
            mDisplayDate.setText(pdate);
            phone.setText(pphone);
            mail.setText(pmail);
            description.setText(pdescription);
        }
        catch(Exception e){

        }



    }


}