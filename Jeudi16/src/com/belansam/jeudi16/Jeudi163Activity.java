package com.belansam.jeudi16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Jeudi163Activity extends Activity {
	
	
	ListView lv;

	List<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
	String[] from = new String[] {"titre", "categorie"};
	int[] to = new int[] {R.id.textView1, R.id.textView2};

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("titre", "Du nouveau a l'udem");
        map.put("categorie", "campus");
        data.add(map);
        
        for(int i = 0; i < 40; i++){   
	        map = new HashMap<String,String>();
	        map.put("titre", "Encore des nouvelles" +i);
	        data.add(map);
        }
        
        
        
        
        lv = (ListView) findViewById(R.id.listView1);
        
        Adapter adapter = new SimpleAdapter(this, data, R.layout.rangee, from, to);
        		
        		
     //   ListAdapter adapter = new ArrayAdapter<String>(
       // 		this,R.layout.rangee, R.id.textView1 ,tableau);
     
       lv.setAdapter((ListAdapter) adapter);
       lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView parent, View v, int pos,
					long id) {
				Toast.makeText(Jeudi163Activity.this, "Clic! pos = "+pos+" id = "+id,
						Toast.LENGTH_LONG).show();
				
			}
	    	   
       });
    }
	
}