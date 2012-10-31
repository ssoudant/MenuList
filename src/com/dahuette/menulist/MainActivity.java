package com.dahuette.menulist;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.GetChars;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnItemSelectedListener {
	private Menus menusOfWeek;
	
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
    
    // FIXME : pas très joli :-(
    private void createDaysList() {
    	Spinner spinner1 = (Spinner) findViewById(R.id.day1_spinner);
    	createDaysAdapter(spinner1, 1);
    	setTextListener(R.id.dishOfTheDay1);
    	
    	Spinner spinner2 = (Spinner) findViewById(R.id.day2_spinner);
    	createDaysAdapter(spinner2, 2);
    	setTextListener(R.id.dishOfTheDay2);
    	
    	Spinner spinner3 = (Spinner) findViewById(R.id.day3_spinner);
    	createDaysAdapter(spinner3, 3);
    	setTextListener(R.id.dishOfTheDay3);
    	
    	Spinner spinner4 = (Spinner) findViewById(R.id.day4_spinner);
    	createDaysAdapter(spinner4, 4);
    	setTextListener(R.id.dishOfTheDay4);

    	Spinner spinner5 = (Spinner) findViewById(R.id.day5_spinner);
    	createDaysAdapter(spinner5, 5);
    	setTextListener(R.id.dishOfTheDay5);
    	
    	Spinner spinner6 = (Spinner) findViewById(R.id.day6_spinner);
    	createDaysAdapter(spinner6, 6);
    	setTextListener(R.id.dishOfTheDay6);
    	
    	Spinner spinner7 = (Spinner) findViewById(R.id.day7_spinner);
    	createDaysAdapter(spinner7, 7);
    	setTextListener(R.id.dishOfTheDay7);
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
		menusOfWeek.addMenu(s);
		Log.i(this.toString(), "Ajout du jour:" + s);
	}

	public void onNothingSelected(AdapterView<?> adapter) {
		// TODO Auto-generated method stub
	}

	// FIXME : code en cours de debug, événements utilisateurs pas captés
	public void setTextListener(int id) {
		EditText editText = (EditText) findViewById(id);
    	Log.i(this.toString(), "quelle zone ? : " + id + editText.toString());
    	
    	editText.setOnEditorActionListener(new OnEditorActionListener() {
	    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	    	Log.i(this.toString(), "quoi ? : " + actionId);
	        boolean handled = false;
	        //if (actionId == EditorInfo.IME_ACTION_SEND) {
	        if (actionId == EditorInfo.IME_ACTION_DONE) {
	      	   	// Send the user message
	            handled = true;
	    		Log.i(this.toString(), "OnEditorActionListener: " + v.getText().toString());
	    		
	        }
	        return handled;
	    }
		});
	}
	
    public void saveAction(View w) {
    	// TODO : c'est dit !
    	Log.i(this.getComponentName().toString(), "TODO : faire l'opération de sauvegarde sur un fichier sur la carte");
    	EditText editText = (EditText) findViewById(R.id.dishOfTheDay1); 
    	Log.i(this.toString(), "save quoi ? : " + R.id.dishOfTheDay1 + editText.getText().toString());
    }
    
    // TODO : restauration des données depuis le fichier enregistré
    // TODO : envoi par mail
}
