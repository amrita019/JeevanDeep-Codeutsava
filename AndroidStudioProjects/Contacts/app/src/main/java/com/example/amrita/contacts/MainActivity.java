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
    ArrayList<String> obj2 = new ArrayList<String>();

    int arrcount = 0;
    ArrayAdapter this_adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleIntent(getIntent());

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }


        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.textview2,obj2);

        final EditText ET= (EditText) findViewById(R.id.etext);
        Button b1= (Button) findViewById(R.id.button2);

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

//            ET.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ET.addTextChangedListener(new TextWatcher() {
//
//                        @Override
//                        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                            MainActivity.this.this_adapter.getFilter().filter(cs);
//                        }
//
//                        @Override
//                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                                      int arg3) {
//                            // TODO Auto-generated method stub
//
//                        }
//
//                        @Override
//                        public void afterTextChanged(Editable arg0) {
//                            // TODO Auto-generated method stub
//                        }
//                    });
//                }
//            });


//            b1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Editable ein=ET.getText();
//                    String sin=ein.toString();
//                    int lengthofarray=obj.size();
//                    int lengthofstring=sin.length();
//
//
//
//                    for(int i=0;i<lengthofarray;i++){
//                        String arraykivalue=contactarray[i];
//                        String arraywalivalue=arraykivalue.substring(0,lengthofstring);
//                        if(sin.equals(arraykivalue)){
//
//
//
//                            ListView listView = (ListView) findViewById(R.id.list);
//                            listView.setAdapter(adapter);
//
//
//                        }
//
//
//                    }
//
//
//        }
//            });





        }
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch.(query);

        }

        protected void onNewIntent(Intent intent) {
            setIntent(intent);
            handleIntent(intent);
        }


        private void doMySearch(String query) {

        }
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the options menu from XML
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.options_menu, menu);

            // Get the SearchView and set the searchable configuration
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
            // Assumes current activity is the searchable activity
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

            return true;
        }
    }
}