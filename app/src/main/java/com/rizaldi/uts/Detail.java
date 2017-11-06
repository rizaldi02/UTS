package com.rizaldi.uts;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView nama, email, nomor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama = (TextView) findViewById(R.id.nama);
        email = (TextView) findViewById(R.id.email);
        nomor = (TextView) findViewById(R.id.telp);

        intent = getIntent();
        nama.setText(intent.getStringExtra("nama.kontak"));
        email.setText(intent.getStringExtra("email.kontak"));
        nomor.setText(intent.getStringExtra("telp.kontak"));
    }

    public void send_sms(View view) {
        int tlp = Integer.parseInt(intent.getStringExtra("telp.kontak"));
        Intent sendSMS = new Intent(Intent.ACTION_VIEW);
        sendSMS.setData(Uri.parse("sms:" + tlp));
        startActivity(sendSMS);
    }

    public void send_email(View view) {
        String emails = intent.getStringExtra("email.kontak");
        Intent sendEmail = new Intent(Intent.ACTION_VIEW);
        sendEmail.setData(Uri.parse("mailto:" + emails));
        startActivity(sendEmail);
    }

    @SuppressLint("MissingPermission")
    public void call(View view) {
        int tlp = Integer.parseInt(intent.getStringExtra("telp.kontak"));
        Intent sendCall = new Intent(Intent.ACTION_CALL);
        sendCall.setData(Uri.parse("tel:" + tlp));
        startActivity(sendCall);
    }
}
