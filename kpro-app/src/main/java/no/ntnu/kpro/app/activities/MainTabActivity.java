/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.kpro.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import no.ntnu.kpro.app.ContactsActivity;
import no.ntnu.kpro.app.R;
import no.ntnu.kpro.core.service.ServiceProvider;

/**
 *
 * @author Kristin
 */
public class MainTabActivity extends WrapperTabActivity {
    final static String TAG = "KPRO-GUI-MAINTAB";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab);
        Log.i(TAG, "Starting onCreate in MainTabActivity");
        Log.i(TAG, "Setting content view");
        
        // Finding the tabhost
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        
        tabHost.setup(this.getLocalActivityManager());

        // Tab for Folders
        TabSpec folderSpec = tabHost.newTabSpec("Folders");
        // setting Title and Icon for the Tab
        folderSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_folder));
        Intent folderIntent = new Intent().setClass(this, FoldersActivity.class);
        folderSpec.setContent(folderIntent);
        Log.i(TAG, "Creating tabspec for folders");
        
        // Tab for New Message
        TabSpec newMessageSpec = tabHost.newTabSpec("New message");
        newMessageSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_new));
        Intent  newMessageIntent = new Intent(this, SendMessageActivity.class);
        newMessageSpec.setContent(newMessageIntent);
        Log.i(TAG, "Creating tabspec for new message");

        TabSpec instantSpec = tabHost.newTabSpec("Instant");
        instantSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_instant_message));
        Intent instantIntent = new Intent(this, InstantMessageActivity.class);
        instantSpec.setContent(instantIntent);
        Log.i(TAG, "Creating tabspec for instant message");
        
        // Tab for Contacts
        TabSpec contactsSpec = tabHost.newTabSpec("Contacts");
        contactsSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_contact));
        Intent contactsIntent = new Intent(this, ContactsActivity.class);
        contactsSpec.setContent(contactsIntent);
        Log.i(TAG, "Creating tabspec for contacts");

        // Tab for Settings
        TabSpec settingsSpec = tabHost.newTabSpec("Settings");
        settingsSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_settings));
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        settingsSpec.setContent(settingsIntent);
        Log.i(TAG, "Creating tabspec for settings");

        // Adding all TabSpec to TabHost
        tabHost.addTab(folderSpec); // Adding photos tab
        tabHost.addTab(newMessageSpec); // Adding songs tab
        tabHost.addTab(instantSpec); // Adding videos tab
        tabHost.addTab(contactsSpec);
        tabHost.addTab(settingsSpec);
        Log.i(TAG, "Adding tabspecs to tabhost");
        
        tabHost.setCurrentTab(0);

        Log.i(TAG, "Setting height on the tabs");
        for (int i = 0; i<tabHost.getTabWidget().getChildCount(); i++){
            tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 50;
        }
    }

    // Method for switching the current tab from outside
    public void switchTab(int tab) {
        TabHost th = (TabHost) findViewById(android.R.id.tabhost);
        th.setCurrentTab(tab);
    }

    // Method for when gets connected to service
    @Override
    public void onServiceConnected(ServiceProvider sp) {
        super.onServiceConnected(sp);
    }
}
