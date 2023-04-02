package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.contactapp.Fragments.ContactsFragment.ContactsFragment;
import com.example.contactapp.Fragments.MessagesFragment.MessagesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout,new ContactsFragment()).commit();
    }

    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (v.getId() == R.id.messageTab) {
            transaction.replace(R.id.layout, new MessagesFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (v.getId() == R.id.contactTab) {
                    transaction.replace(R.id.layout, new ContactsFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}