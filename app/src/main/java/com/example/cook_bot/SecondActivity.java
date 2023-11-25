package com.example.cook_bot;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cook_bot.Message;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private List<Message> messageList;
    private ChatAdapter chatAdapter;
    private ListView listViewChat;
    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // UI 요소 초기화
        listViewChat = findViewById(R.id.listViewChat);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        // 채팅 어댑터 초기화
        messageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(this, messageList);
        listViewChat.setAdapter(chatAdapter);

        // EditText에서 엔터 키와 전송 버튼에 대한 이벤트 설정
        editTextMessage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    sendMessage();
                    return true;
                }
                return false;
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ButtonClick1", "Button clicked");
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        Log.d("ButtonClick", "Message: " + messageText);

        if (!messageText.isEmpty()) {
            // 새로운 메시지 추가
            Message message = new Message(messageText, true);
            messageList.add(message);

            // 어댑터에 변경 알리기
            chatAdapter.notifyDataSetChanged();

            listViewChat.post(new Runnable() {
                @Override
                public void run() {
                    listViewChat.setSelection(chatAdapter.getCount() - 1);
                }
            });

            // 메시지 입력란 초기화
            editTextMessage.setText("");
        }
    }
}
