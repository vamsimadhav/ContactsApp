package com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.MessageData;

import java.util.List;

@Dao
public interface MessageDataDao {

    @Query("select * from MessageData")
    List<MessageData> getAllMessages();

    @Insert
    void addMessageData(MessageData messageData);

    @Update
    void updateMessageData(MessageData messageData);

    @Delete
    void deleteMessage(MessageData messageData);
}
