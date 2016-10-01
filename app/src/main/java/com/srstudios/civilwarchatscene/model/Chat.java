package com.srstudios.civilwarchatscene.model;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by suparam on 10/1/16.
 */
public class Chat {
    public int heroID;
    public String hero;
    public String heroIMG;
    public String message;

    public Chat(JSONObject jsonObject)
    {
        if (jsonObject != null)
        {
            try
            {
                heroID = jsonObject.getInt("hero_id");
                hero = jsonObject.getString("hero");
                heroIMG = jsonObject.getString("hero_img");
                message = jsonObject.getString("message");
            }
            catch (JSONException e)
            {
                Log.w("ERRROR", e);
            }
        }
    }
}

