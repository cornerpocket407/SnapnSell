package com.snapnsell;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

public class MarketplaceActivity extends BaseActivity {
	ListView lvMarketplaceItems;
	SearchView svSearchMarketplace;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marketplace);
		
		lvMarketplaceItems = (ListView)findViewById(R.id.lvMarketplaceItems);
		svSearchMarketplace =(SearchView)findViewById(R.id.svSearchMarketplace);
	}
}
