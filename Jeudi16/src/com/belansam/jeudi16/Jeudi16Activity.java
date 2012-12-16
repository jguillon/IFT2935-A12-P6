package com.belansam.jeudi16;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class Jeudi16Activity extends ListActivity {
	
	String[] tableau = new String[] {"aaa", "bbb", "ccc", "ddd"};

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);
        
       // ListAdapter adapter = new ArrayAdapter<String>(
        //		this,android.R.layout.simple_list_item_1, tableau);
        
        ListAdapter adapter = new ArrayAdapter<String>(
        		this,R.layout.rangee, R.id.textView1 ,tableau);
     
        setListAdapter(adapter);
    }
	
}