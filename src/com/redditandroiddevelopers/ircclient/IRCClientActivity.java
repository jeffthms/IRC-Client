package com.redditandroiddevelopers.ircclient;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class IRCClientActivity extends TabActivity {
    /** Called when the activity is first created. */
	TextView chatText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        chatText = (TextView) findViewById(R.id.chattext); // Text from chat
        EditText userInput = (EditText) findViewById(R.id.userinput); // Text box where user inputs text
        TabHost tabHost = getTabHost(); // Tab host
        TabHost.TabSpec spec; // tab to added (reused)
        chatText.setMovementMethod(new ScrollingMovementMethod()); // Allow chat scrolling

        //Tab #1  
        spec= tabHost.newTabSpec("status").setIndicator("freenode Raionic");
        
        spec.setContent(new TabHost.TabContentFactory() { // To be replaced.
			
			@Override
			public View createTabContent(String tag) {
				// TODO Remove
				TextView text = new TextView(IRCClientActivity.this);
				return text;
			}
		});
        tabHost.addTab(spec);
        
        //Tab #2       
        spec= tabHost.newTabSpec("channel1").setIndicator("##reddit-android-developers");
        
        spec.setContent(new TabHost.TabContentFactory() { // To be replaced.
			
			@Override
			public View createTabContent(String tag) {
				// TODO Remove
				TextView text = new TextView(IRCClientActivity.this);
				return text;
			}
		});
        tabHost.addTab(spec);
        
        // Mock chat text
        chatText.setText(Html.fromHtml("(10:32:50) <font color=red>@member68</font>: that's because they don't have a local copy for redmine. I don't really see why we should keep the repository tab anyway since we have github for browsing the code" +
					"<br>(10:33:04) <font color=red>@veeti</font>: it's so that issues can be closed by commits automatically" +
					"<br>(10:33:09) <font color=red>Hogofwar</font>: make make a link in the project to the github" +
					"<br>(10:33:14) <font color=red>Hogofwar</font>: and that" +
					"<br>(10:33:53) <font color=red>@member68</font>: can redmine do that? haven't tried it" +
					"<br>(10:34:37) <font color=red>@member68</font>: how does it detect which commit belongs wo which issue?" +
					"<br>(10:34:48) <font color=red>@veeti</font>: you put something like" +
					"<br>(10:34:53) <font color=red>@veeti</font>: \"fixes #23142345\" in the commit message" +
					"<br>(10:34:57) <font color=red>@veeti</font>: and it closes the issue automatically" +
					"<br>(10:35:12) <font color=red>@member68</font>: that's useful." +
					"<br>(10:35:33) <font color=red>@member68</font>: guess that's a good reason to add the repos to redmine" +
					"<br>(10:35:58) <font color=red>Hogofwar</font>: woo" +
					"<br>(10:36:11) <font color=red>@member68</font>: wjoe would be the one to add them though. he's the only one who can do that" +
					"<br>(10:40:46) <font color=red>Hiver</font>: So, what's the difference between an idea and a suggestion?" +
					"<br>(10:41:37) <font color=red>@member68</font>: I removed Ideas as an issue tracker a few minutes ago because hogofwar pointed out here wasn't one" +
					"<br>(10:44:08) <font color=red>Hiver</font>: Ahh"));
        chatText.append(Html.fromHtml("<br>(10:44:08) <font color=red>Raionic</font>: Hi"));
        
    }
}