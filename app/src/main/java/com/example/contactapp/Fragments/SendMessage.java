package com.example.contactapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.DatabaseHelper;
import com.example.contactapp.Fragments.MessagesFragment.Recycler_Helpers.MessageData;
import com.example.contactapp.R;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class SendMessage extends Fragment {

    private DatabaseHelper databaseHelper;
    private String name;
    private String otp;
    private String phNoWithCode;

    public SendMessage() {
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
        View rootView = inflater.inflate(R.layout.fragment_send_message, container, false);
        databaseHelper = DatabaseHelper.getDB(getContext());
        Button sendMessage = rootView.findViewById(R.id.sendMessage);
        TextView testMessage = rootView.findViewById(R.id.textMessage);
        Bundle args = getArguments();
        String ph = args.getString("phNo");
        name = args.getString("name");
        phNoWithCode = "+91" + ph;
        otp =  getRandomNumberString();
        String tmessage = "Hi. Your OTP is: " + otp;
        testMessage.setText(tmessage);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS(phNoWithCode,tmessage);
            }
        });
        return rootView;
    }

    private void sendSMS(final String toPhoneNumber, final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(" https://2f55-2406-7400-73-8114-2515-bbc4-11f5-f2f4.in.ngrok.io/sms"); // Replace <your_backend_url> with your Node.js backend URL
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);

                    JSONObject requestBody = new JSONObject();
                    requestBody.put("toPhoneNumber", toPhoneNumber);
                    requestBody.put("message", message);

                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(requestBody.toString().getBytes());

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        // Message sent successfully
                        Looper.prepare();
                        databaseHelper.messageDataDao().addMessageData(new MessageData(name,String.valueOf(System.currentTimeMillis()),otp));
                        Toast.makeText(getContext(), "Message Sent", Toast.LENGTH_SHORT).show();
                        // Handle the response if needed
                    } else {
                        // Error sending message
                        Looper.prepare();
                        Toast.makeText(getContext(), "Error Sending Message", Toast.LENGTH_SHORT).show();
                        // Handle the error if needed
                    }

                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle the exception if needed
                }
            }
        }).start();
    }

    public static String getRandomNumberString() {
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

}