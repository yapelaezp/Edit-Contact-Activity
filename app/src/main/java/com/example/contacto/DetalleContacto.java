package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        // Catching params from activity_main
        Bundle params = getIntent().getExtras();
        String name = params.getString("name");
        String date  = params.getString(("date"));
        String phone = params.getString("phone");
        String mail = params.getString("mail");
        String description = params.getString("description");

        //Catching TextViews
        TextView txName = (TextView) findViewById(R.id.textName);
        TextView txDate = (TextView) findViewById(R.id.tvDate);
        TextView txPhone = (TextView) findViewById(R.id.tvPhone);
        TextView txMail = (TextView) findViewById(R.id.tvMail);
        TextView txDescription = (TextView) findViewById(R.id.tvDescription);
        txName.setText(name);
        txDate.setText(date);
        txPhone.setText(phone);
        txMail.setText(mail);
        txDescription.setText(description);

        //Button Edit settings
        Button editButton = (Button) findViewById(R.id.btnEdit);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(DetalleContacto.this,MainActivity.class);
                miIntent.putExtra("name",txName.getText().toString());
                miIntent.putExtra("date", txDate.getText().toString());
                miIntent.putExtra("phone",txPhone.getText().toString());
                miIntent.putExtra("mail",txMail.getText().toString());
                miIntent.putExtra("description",txDescription.getText().toString());
                startActivity(miIntent);
            }
        });
    }
}