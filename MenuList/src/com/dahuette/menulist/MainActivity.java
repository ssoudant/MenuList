package com.dahuette.menulist;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TableRow;

public class MainActivity extends Activity implements OnItemSelectedListener {
	private Menus menusOfWeek;
	private static String TAG = "MainActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createMenus();
        createDaysList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void createMenus() {
    	menusOfWeek = Menus.getInstance();
    }
    
    private void createDaysList() {
    	int ids[] = {
    			R.id.day1_spinner, 
    			R.id.day2_spinner,
    			R.id.day3_spinner, 
    			R.id.day4_spinner,
    			R.id.day5_spinner, 
    			R.id.day6_spinner,
    			R.id.day7_spinner
    	};
    	for (int i = 0; i < ids.length; i++) {
    		Spinner spinner = (Spinner) findViewById(ids[i]);
        	createDaysAdapter(spinner, i);
    	}
    }
    
    private void createDaysAdapter(Spinner s, int order) {
    	// Create an ArrayAdapter using the string array and a default spinner layout
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    	        R.array.days_array, android.R.layout.simple_spinner_item);
    	// FIXME : trouve une astuce pour initialiser la tête de liste à la bonne valeur
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	s.setAdapter(adapter);
    	s.setOnItemSelectedListener(this);
    }
    
    public void onItemSelected(AdapterView<?> adapter, View view, int pos,
			long id) {
		String s = (String) adapter.getItemAtPosition(pos);
		menusOfWeek.addDay(((Spinner) view.getParent()).getId(), s);
	}

	public void onNothingSelected(AdapterView<?> adapter) {
		// TODO Auto-generated method stub
	}
	
    public void saveAction(View w) {
    	// TODO : c'est dit !
    	Log.i(TAG, "TODO : faire l'opération de sauvegarde sur un fichier sur la carte");
    	
    	int editTextIds[] = {
    			R.id.dishOfTheDay1, 
    			R.id.dishOfTheDay2,
    			R.id.dishOfTheDay3,
    			R.id.dishOfTheDay4,
    			R.id.dishOfTheDay5,
    			R.id.dishOfTheDay6,
    			R.id.dishOfTheDay7
    	};
    	
    	for (int id : editTextIds) {
    		EditText editText = (EditText) findViewById(id);
    		
    		TableRow t = (TableRow) editText.getParent();
    		Spinner s = (Spinner) t.getChildAt(0);
    		int sId = s.getId();
    		Log.i(TAG, "save quoi: spinnerId " + sId + " " + editText.getText().toString());
    		menusOfWeek.addMenu(sId, editText.getText().toString());
    	}
    	
    	menusOfWeek.log();
    }
    
    // TODO : restauration des données depuis le fichier enregistré
    // TODO : envoi par mail
}