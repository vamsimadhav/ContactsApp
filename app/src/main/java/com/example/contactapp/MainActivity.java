package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.contactapp.Fragments.ContactsFragment.ContactsFragment;
import com.example.contactapp.Fragments.MessagesFragment.MessagesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout,new ContactsFragment()).commit();

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
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