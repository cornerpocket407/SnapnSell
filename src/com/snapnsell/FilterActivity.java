package com.snapnsell;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class FilterActivity extends Activity {
	Spinner spCategoryFilter;
	EditText etLocationInput;
	EditText etMinPriceInput;
	EditText etMaxPriceInput;
	CheckBox cbUsedFilter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		
		spCategoryFilter = (Spinner)findViewById(R.id.spCategoryFilter);
		etLocationInput = (EditText)findViewById(R.id.etLocationInput);
		etMinPriceInput = (EditText)findViewById(R.id.etMinPriceInput);
		etMaxPriceInput = (EditText)findViewById(R.id.etMaxPriceInput);
		cbUsedFilter = (CheckBox)findViewById(R.id.cbUsedFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filter, menu);
		return true;
	}

}
