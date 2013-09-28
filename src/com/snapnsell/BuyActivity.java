package com.snapnsell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.snapnsell.fragment.ItemDescriptionFragment;
import com.snapnsell.model.Item;
import com.snapnsell.type.ItemDescSection;


public class BuyActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		loadFragment();
		Button btnSubmit = (Button) findViewById(R.id.btnBuy);
		btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				ItemDescriptionFragment fragment = (ItemDescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.flItemDesc);
				String description = fragment.getEtDescription().getText().toString();
				String location = fragment.getEtLocation().getText().toString();
//				String price = fragment.getEtPrice().g
				String title = fragment.getEtTitle().getText().toString();
				String itemPicPath = fragment.getItemPicUri() == null ? "" : fragment.getItemPicUri().getPath();
				Item item = new Item(description, location, title, itemPicPath);
				item.save();

				Intent intent = new Intent(BuyActivity.this, ConfirmActivity.class);
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
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}
}
