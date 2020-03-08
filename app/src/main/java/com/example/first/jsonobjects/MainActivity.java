package com.example.first.jsonobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject object = new JSONObject();
        try {
            object.put("title", "randomTitle");
            object.put("numPages", 32);
            object.put("id", 123);
            object.put("fgdg", 5465);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Book b = gson.fromJson(object.toString(), Book.class);

        Toast.makeText(this, ""+b.title, Toast.LENGTH_SHORT).show();
    }
}
