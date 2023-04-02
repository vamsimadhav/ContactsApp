package com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Interface.ClickListener;
import com.example.contactapp.R;

import java.util.Collections;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private List<ContactsData> list = Collections.emptyList();
    private ClickListener clickListener;

    public ContactsAdapter(List<ContactsData> list, ClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View contactCard = inflater.inflate(R.layout.contact_card, parent, false);

        ContactsViewHolder viewHolder = new ContactsViewHolder(contactCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder viewHolder, int position) {
        final int index = viewHolder.getAdapterPosition();
        ContactsData data = list.get(position);
        viewHolder.fullName.setText(data.firstName + " " + data.lastName);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                clickListener.onClick(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
