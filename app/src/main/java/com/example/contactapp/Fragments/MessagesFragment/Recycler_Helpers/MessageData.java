package com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "MessageData")
public class MessageData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "otp")
    private String otp;

    public MessageData(int id, String name, String time, String otp) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.otp = otp;
    }

    @Ignore
    public MessageData(String name, String time, String otp) {
        this.name = name;
        this.time = time;
        this.otp = otp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
