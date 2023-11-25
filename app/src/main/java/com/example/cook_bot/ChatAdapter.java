package com.example.cook_bot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private Context context;
    private List<Message> messageList;
    private LayoutInflater inflater;

    public ChatAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.chat_message, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewMessage = convertView.findViewById(R.id.textViewMessage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message message = messageList.get(position);

        // Set the message text
        viewHolder.textViewMessage.setText(message.getText());

        // Additional styling based on whether the message is from the user or the bot
        if (message.isUser()) {
            // Style for user messages
            // You can customize this based on your design
        } else {
            // Style for bot messages
            // You can customize this based on your design
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewMessage;
    }
}
