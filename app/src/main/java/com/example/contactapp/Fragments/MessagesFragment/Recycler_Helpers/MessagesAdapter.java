package com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers.ContactsData;
import com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers.ContactsViewHolder;
import com.example.contactapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> {

    private List<MessageData> list = Collections.emptyList();

    public MessagesAdapter(List<MessageData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout
        View messageCard = inflater.inflate(R.layout.message_card, parent, false);

        MessagesViewHolder viewHolder = new MessagesViewHolder(messageCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        MessageData data = list.get(position);
        holder.name.setText(data.getName());
//        String date = getDate(data.getTime());
        holder.time.setText(data.getTime());
        holder.otp.setText(data.getOtp());

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

//    private String getDate(String time) {
////        long unix_seconds = Long.parseLong(time);
////        Date date = new Date(unix_seconds * 1000L);
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Create a SimpleDateFormat object with the desired date format
////        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
////        String formattedDate = sdf.format(date);
////        return formattedDate;
//    }
}
