package com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

public class ContactsViewHolder extends RecyclerView.ViewHolder {
    TextView fullName;
    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);
        fullName = itemView.findViewById(R.id.contactNameText);
    }
}
