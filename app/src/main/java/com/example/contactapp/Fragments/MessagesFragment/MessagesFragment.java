package com.example.contactapp.Fragments.MessagesFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.DatabaseHelper;
import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.MessageData;
import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.MessagesAdapter;
import com.example.contactapp.R;

import java.util.ArrayList;

public class MessagesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MessagesAdapter adapter;
    public MessagesFragment() {
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
        View rootView =  inflater.inflate(R.layout.fragment_messages, container, false);
        recyclerView = rootView.findViewById(R.id.messageList);
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(getContext());
        ArrayList<MessageData> messageData = (ArrayList<MessageData>) databaseHelper.messageDataDao().getAllMessages();
        adapter = new MessagesAdapter(messageData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }
}