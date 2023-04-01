package com.example.contactapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contactapp.R;
import com.example.contactapp.Recycler_Helpers.ContactsData;

public class SendMessage extends Fragment {

    public SendMessage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_send_message, container, false);
        TextView fullName = rootView.findViewById(R.id.fullName);
        TextView mobileNum = rootView.findViewById(R.id.contactNum);
        Bundle args = getArguments();
        if (args != null) {
            ContactsData data = args.getParcelable("data");
            String full_name = data.getFirstName() + " " + data.getLastName();
            String mobileNumber = data.getMobNum();

            fullName.setText(full_name);
            mobileNum.setText(mobileNumber);
        }
        return rootView;
    }
}