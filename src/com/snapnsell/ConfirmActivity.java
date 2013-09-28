package com.snapnsell;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

import com.snapnsell.fragment.ItemDescriptionFragment;
import com.snapnsell.type.ItemDescSection;

public class ConfirmActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		loadFragment();
	}

	private void loadFragment() {
	    FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction transaction = manager
				.beginTransaction();
		Bundle bundle = new Bundle();
		bundle.putSerializable(ItemDescriptionFragment.BUNDLE_SECTION, ItemDescSection.CONFIRM);
		ItemDescriptionFragment itemFragment = new ItemDescriptionFragment();
		itemFragment.setArguments(bundle);
		transaction.replace(R.id.frame_container, itemFragment);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}
}
