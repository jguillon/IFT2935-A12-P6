package com.belansam.jeudi16;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Jeudi162Activity extends Activity {
	
	String[] tableau = new String[] {"aaa", "bbb", "ccc", "ddd","bonjour","toto",
			"aaa", "bbb", "ccc", "ddd","bonjour","toto",
			"aaa", "bbb", "ccc", "ddd","bonjour","toto"};
	
	ListView lv;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lv = (ListView) findViewById(R.id.listView1);
       // ListAdapter adapter = new ArrayAdapter<String>(
        //		this,android.R.layout.simple_list_item_1, tableau);
        
        ListAdapter adapter = new ArrayAdapter<String>(
        		this,R.layout.rangee, R.id.textView1 ,tableau);
     
        lv.setAdapter(adapter);
    }
	
}