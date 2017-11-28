package com.example.telc2.traderstation.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.github.bassaer.chatmessageview.model.User;
import com.github.bassaer.chatmessageview.models.Message;
import com.github.bassaer.chatmessageview.views.ChatView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by iqbal on 11/21/2017.
 */

public class ChattingActivity extends AppCompatActivity {

    ChatView mChatView;
    private Toolbar toolbar;
    private ImageButton back;
    private TextView profileName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        toolbar = (Toolbar) findViewById(R.id.toolbar_chatting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_chatting);
        profileName = (TextView) toolbar.findViewById(R.id.toolbar_title_chatting);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String pn = getIntent().getStringExtra("profileName");
        profileName.setText(pn);
        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_2);
        //User name
        String myName = "Tes";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_1);
        String yourName = pn;

        final User me = new User(myId, myName, myIcon);
        final User you = new User(yourId, yourName, yourIcon);

        mChatView = (ChatView)findViewById(R.id.chat_view);

        //Set UI parameters if you need
        mChatView.setRightBubbleColor(ContextCompat.getColor(this, R.color.green500));
        mChatView.setLeftBubbleColor(ContextCompat.getColor(this, R.color.green500));
        mChatView.setBackgroundColor(ContextCompat.getColor(this, R.color.blueGray50));
        mChatView.setSendButtonColor(ContextCompat.getColor(this, R.color.green500));
        mChatView.setSendIcon(R.drawable.ic_action_send);
        mChatView.setRightMessageTextColor(Color.BLACK);
        mChatView.setLeftMessageTextColor(Color.BLACK);
        mChatView.setUsernameTextColor(Color.BLACK);
        mChatView.setSendTimeTextColor(Color.BLACK);
        mChatView.setDateSeparatorColor(Color.BLACK);
        mChatView.setInputTextHint("chat");
        mChatView.setMessageMarginTop(0);
        mChatView.setMessageMarginBottom(0);
        mChatView.setDividerPadding(0);

        //Click Send Button
        mChatView.setOnClickSendButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new message
                Message message = new Message.Builder()
                        .setUser(me)
                        .setRightMessage(true)
                        .setMessageText(mChatView.getInputText())
                        .hideIcon(true)
                        .build();
                //Set to chat view
                mChatView.send(message);
                //Reset edit text
                mChatView.setInputText("");

                //Receive message
                final Message receivedMessage = new Message.Builder()
                        .setUser(you)
                        .setRightMessage(false)
                        .setMessageText("tes")
                        .build();

                // This is a demo bot
                // Return within 3 seconds
                int sendDelay = (new Random().nextInt(4) + 1) * 1000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mChatView.receive(receivedMessage);
                    }
                }, sendDelay);
            }

        });

        mChatView.setOnClickOptionButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChattingActivity.this, "Option clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

}
