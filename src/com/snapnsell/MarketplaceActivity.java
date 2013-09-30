package com.snapnsell;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;

import com.activeandroid.query.Select;
import com.snapnsell.adapter.ItemsAdapter;
import com.snapnsell.fragment.ItemDescriptionFragment;
import com.snapnsell.model.Item;
import com.snapnsell.type.ItemDescSection;

public class MarketplaceActivity extends BaseActivity {
	ListView lvMarketplaceItems;
	SearchView svSearchMarketplace;
	ArrayList<Item> marketplaceItems = new ArrayList<Item>();
	ItemsAdapter itemAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marketplace);
		lvMarketplaceItems = (ListView)findViewById(R.id.lvMarketplaceItems);
		svSearchMarketplace =(SearchView)findViewById(R.id.svSearchMarketplace);
		marketplaceItems = new Select().from(Item.class).orderBy("id DESC").limit("20").execute();		
		itemAdapter = new ItemsAdapter(this, marketplaceItems);
		lvMarketplaceItems.setAdapter(itemAdapter);
		
		// Create a listener when the user clicks on an image and it will start a new activity to display the full-sized image
		lvMarketplaceItems.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View parent, int position, long rowId) {
				Intent i = new Intent(getApplicationContext(), BuyActivity.class);
				Item item = marketplaceItems.get(position);			
								
//				Intent i = new Intent(getApplicationContext(), DisplayFullImage.class);
//				ImageResult imgResult = imageResults.get(position);
//				i.putExtra("imgResult", imgResult);
								
				FragmentManager manager = getSupportFragmentManager();
				android.support.v4.app.FragmentTransaction transaction = manager
						.beginTransaction();
				Bundle bundle = new Bundle();
				bundle.putSerializable(ItemDescriptionFragment.BUNDLE_SECTION, ItemDescSection.BUY);
				ItemDescriptionFragment itemFragment = new ItemDescriptionFragment();
				itemFragment.setArguments(bundle);				
				i.putExtra("marketplaceItem", item);
				startActivity(i);
				
			}
		});
		
	}
}
