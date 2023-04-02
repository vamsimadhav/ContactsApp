package com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

public class MessagesViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView time;
    TextView otp;
    public MessagesViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameText);
        time = itemView.findViewById(R.id.timeText);
        otp = itemView.findViewById(R.id.otpText);
    }
}
