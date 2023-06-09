package com.example.contactapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.contactapp.R;
import com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers.ContactsData;

public class DisplayContact extends Fragment {

    private String mobileNumber;
    private String name;

    public DisplayContact() {
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
        View rootView =  inflater.inflate(R.layout.fragment_display_contact, container, false);
        TextView fullName = rootView.findViewById(R.id.fullName);
        TextView mobileNum = rootView.findViewById(R.id.contactNum);
        Button sendMessage = rootView.findViewById(R.id.sendMessage);
        Bundle args = getArguments();
        if (args != null) {
            ContactsData data = args.getParcelable("data");
            name = data.getFirstName() + " " + data.getLastName();
            mobileNumber = data.getMobNum();

            fullName.setText(name);
            mobileNum.setText(mobileNumber);
        }
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("phNo",mobileNumber);
                args.putString("name",name);
                SendMessage sendMsg = new SendMessage();
                sendMsg.setArguments(args);
                transaction.replace(R.id.layout, sendMsg);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;
    }
}