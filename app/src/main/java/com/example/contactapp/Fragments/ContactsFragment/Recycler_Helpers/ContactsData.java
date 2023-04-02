package com.example.contactapp.Fragments.ContactsFragment.Recycler_Helpers;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ContactsData implements Parcelable {
    String firstName;
    String lastName;
    String mobNum;

    public ContactsData(String firstName, String lastName, String mobNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobNum = mobNum;
    }

    protected ContactsData(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        mobNum = in.readString();
    }

    public static final Creator<ContactsData> CREATOR = new Creator<ContactsData>() {
        @Override
        public ContactsData createFromParcel(Parcel in) {
            return new ContactsData(in);
        }

        @Override
        public ContactsData[] newArray(int size) {
            return new ContactsData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(mobNum);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobNum() {
        return mobNum;
    }
}
