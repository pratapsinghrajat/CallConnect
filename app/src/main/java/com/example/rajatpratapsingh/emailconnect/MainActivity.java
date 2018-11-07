package com.example.rajatpratapsingh.emailconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonsend = findViewById(R.id.button_send);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            sendEmail();
            }
        });
    }

    private void sendEmail()
    {
        String recipientList = mEditTextTo.getText().toString();
        String[] recipents = recipientList.split(",");

        //example1@gmail.com and example2@gmail.com

        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipents);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client !"));
    }
}
