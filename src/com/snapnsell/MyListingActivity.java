package com.snapnsell;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MyListingActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_listing);
		getActionBar().show();
	}
}
