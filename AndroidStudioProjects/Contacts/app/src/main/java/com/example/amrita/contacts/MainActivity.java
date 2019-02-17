package com.example.amrita.contacts;

import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] contactarray = new String[1000];
    ArrayList<String> obj = new ArrayList<String>();




    int arrcount = 0;
    ArrayAdapter this_adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String name, number = "";
        String id;

        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));

            if (Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                Cursor pCur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id},
                        null);
                while (pCur.moveToNext()) {
                    number = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
            }
            String s = name + " " + number;
            contactarray[arrcount] = s;
            obj.add(s);
            arrcount++;


            final ArrayAdapter this_adapter = new ArrayAdapter<String>(this,
                    R.layout.textview, obj);


            ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(this_adapter);
            c.moveToNext();
        }
        }


    }





