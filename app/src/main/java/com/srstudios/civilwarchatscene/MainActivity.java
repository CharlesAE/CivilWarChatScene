package com.srstudios.civilwarchatscene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.srstudios.civilwarchatscene.adapter.ChatAdapter;
import com.srstudios.civilwarchatscene.model.Chat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public List<Chat> chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);


        //Initialize arraylist
        chat = new ArrayList<Chat>();

        //surround in try-catch block incase json file not present
        try {
            //load json file
            JSONObject obj = new JSONObject(loadJSON());

            //save contents of json file as json array
            JSONArray jsonArray = obj.getJSONArray("data");


            for (int i = 0; i < jsonArray.length(); i++) {

                //populate arraylist with json array data
                JSONObject objc = jsonArray.getJSONObject(i);
                chat.add(new Chat(objc));
            }
            //populate listview with arraylist
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(new ChatAdapter(this, chat));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSON() {
        String json = null;
        try {
            InputStream stream = getAssets().open("chat.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
