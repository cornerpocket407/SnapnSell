package com.snapnsell;

import com.snapnsell.fragment.BuyFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class BuyActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		loadFragment();
	}

	private void loadFragment() {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction transaction = manager
				.beginTransaction();
		transaction.replace(R.id.frame_container, new BuyFragment());
		transaction.commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}

}
