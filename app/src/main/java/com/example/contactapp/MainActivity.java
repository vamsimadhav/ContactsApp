package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.contactapp.Fragments.ContactsFragment;
import com.example.contactapp.Fragments.MessagesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout,new ContactsFragment()).commit();
    }

    public void onClick(View v) {

        if (v.getId() == R.id.messageTab) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new MessagesFragment()).commit();
        } else if (v.getId() == R.id.contactTab) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new ContactsFragment()).commit();
        } else {
            //Do Nothing
        }
    }
}