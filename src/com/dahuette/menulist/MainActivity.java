package com.dahuette.menulist;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
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
    	
    	Spinner spinner2 = (Spinner) findViewById(R.id.day2_spinner);
    	createDaysAdapter(spinner2, 2);
    	
    	Spinner spinner3 = (Spinner) findViewById(R.id.day3_spinner);
    	createDaysAdapter(spinner3, 3);
    	
    	Spinner spinner4 = (Spinner) findViewById(R.id.day4_spinner);
    	createDaysAdapter(spinner4, 4);

    	Spinner spinner5 = (Spinner) findViewById(R.id.day5_spinner);
    	createDaysAdapter(spinner5, 5);
    	
    	Spinner spinner6 = (Spinner) findViewById(R.id.day6_spinner);
    	createDaysAdapter(spinner6, 6);
    	
    	Spinner spinner7 = (Spinner) findViewById(R.id.day7_spinner);
    	createDaysAdapter(spinner7, 7);
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
	
    public void saveAction(View w) {
    	// TODO : c'est dit !
    	Log.i(this.getComponentName().toString(), "TODO : faire l'opération de sauvegarde sur un fichier sur la carte");
    	Spinner s = (Spinner) findViewById(R.id.day1_spinner);
    	EditText editText = (EditText) findViewById(R.id.dishOfTheDay1);
    	//menusOfWeek.put(s.)
    	Log.i(this.toString(), "save quoi ? : " + R.id.dishOfTheDay1 + editText.getText().toString());
    	
    }
    
    // TODO : restauration des données depuis le fichier enregistré
    // TODO : envoi par mail
}
