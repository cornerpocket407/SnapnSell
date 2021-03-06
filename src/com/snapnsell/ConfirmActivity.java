package com.snapnsell;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.snapnsell.fragment.ItemDescriptionFragment;
import com.snapnsell.type.ItemDescSection;

public class ConfirmActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		loadFragment();
		
		Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
		btnConfirm.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
		btnConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ConfirmActivity.this, MarketplaceActivity.class));
			}
		});
		
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
}
