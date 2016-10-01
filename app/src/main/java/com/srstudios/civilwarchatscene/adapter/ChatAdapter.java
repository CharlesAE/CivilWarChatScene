package com.srstudios.civilwarchatscene.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.srstudios.civilwarchatscene.R;
import com.srstudios.civilwarchatscene.model.Chat;

import java.util.List;

/**
 * Created by suparam on 10/1/16.
 */
public class ChatAdapter extends ArrayAdapter<Chat>
{
    Context context;
    List<Chat> objects;

    public ChatAdapter(Context context, List<Chat> objects)
    {
        super(context, 0, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        ChatCell chatCell = new ChatCell();

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.chat_item, parent, false);

        chatCell.heroImageView = (ImageView) view.findViewById(R.id.heroImageView);
        chatCell.heroTextView = (TextView) view.findViewById(R.id.heroTextView);
        chatCell.messageTextView = (TextView) view.findViewById(R.id.messageTextView);
        Chat chat = getItem(position);

        int id = context.getResources().getIdentifier(chat.heroIMG, "drawable", context.getPackageName());

        chatCell.heroImageView.setImageResource(id);
        chatCell.heroTextView.setText(chat.hero);
        chatCell.messageTextView.setText(chat.message);

        return view;
    }

    private static class ChatCell
    {
        //Chat items
        TextView heroTextView;
        TextView messageTextView;
        ImageView heroImageView;
    }
}

