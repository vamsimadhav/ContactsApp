package com.example.contactapp.Fragments.ContactsFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactapp.Interface.ClickListener;
import com.example.contactapp.Fragments.DisplayContact;
import com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers.ContactsAdapter;
import com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers.ContactsData;
import com.example.contactapp.R;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ClickListener clickListener;
    private ContactsAdapter adapter;

    public ContactsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        recyclerView = rootView.findViewById(R.id.contactList);
        List<ContactsData> data = getData();
        clickListener = index -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            Bundle args = new Bundle();
            args.putParcelable("data", data.get(index));
            DisplayContact displayContact = new DisplayContact();
            displayContact.setArguments(args);
            transaction.replace(R.id.layout, displayContact);
            transaction.addToBackStack(null);
            transaction.commit();
        };
        adapter = new ContactsAdapter(data,clickListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }



    private List<ContactsData> getData() {
        List<ContactsData> data = new ArrayList<>();
        data.add(new ContactsData("Vamsi","Madhav H","9480319265"));
        data.add(new ContactsData("Vamsi","Mad","9880074474"));
        data.add(new ContactsData("Vamsi","JIO","8310749424"));

        return data;
    }


}