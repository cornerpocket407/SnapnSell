package com.snapnsell.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.snapnsell.BaseActivity;
import com.snapnsell.ConfirmActivity;
import com.snapnsell.R;
import com.snapnsell.fragment.ItemDescriptionFragment;
import com.snapnsell.model.Item;
import com.snapnsell.type.ItemDescSection;

public class SellActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		loadFragment();
		Button btnSubmit = (Button) findViewById(R.id.btnSell);
		btnSubmit.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
		btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ItemDescriptionFragment fragment = (ItemDescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.flItemDesc);
				String description = fragment.getEtDescription().getText().toString();
				String location = fragment.getEtLocation().getText().toString();
				Double price = Double.valueOf(fragment.getEtPrice().getText().toString());
				boolean used = fragment.getCbUsed().isChecked();
				String title = fragment.getEtTitle().getText().toString();
				String itemPicPath = fragment.getItemPicUri() == null ? "" : fragment.getItemPicUri().getPath();
				Item item = new Item(description, location, title, itemPicPath, price, used);
				item.save();

				Intent intent = new Intent(SellActivity.this, ConfirmActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable(ItemDescriptionFragment.BUNDLE_SECTION, ItemDescSection.CONFIRM);			
				intent.putExtra("marketplaceItem", item);
				startActivity(intent);
			}
		});
	}

	private void loadFragment() {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction transaction = manager
				.beginTransaction();
		Bundle bundle = new Bundle();
		bundle.putSerializable(ItemDescriptionFragment.BUNDLE_SECTION, ItemDescSection.SELL);
		ItemDescriptionFragment itemFragment = new ItemDescriptionFragment();
		itemFragment.setArguments(bundle);
		transaction.replace(R.id.flItemDesc, itemFragment);
		transaction.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
}