package com.snapnsell;

import com.snapnsell.activity.SellActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends FragmentActivity {
//	public class BaseItemActivity extends FragmentActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
	
	public void onMarketplace(MenuItem item) {
		Intent intent = new Intent(this, MarketplaceActivity.class);
		startActivity(intent);
	}
	
	public void onSell(MenuItem item) {
		Intent intent = new Intent(this, SellActivity.class);
		startActivity(intent);
	}

//	private void setupNavigation() {
//		ActionBar actionBar = getActionBar();
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//		actionBar.setDisplayShowTitleEnabled(true);
//		Tab tabMarketplace = actionBar.newTab().setText("Marketpace")
//				.setTag(TwitterApp.FRAGMENT_TAG_MARKETPLACE).setIcon(R.drawable.ic_action_marketplace)
//				.setTabListener(this);
//		Tab tabMyListing = actionBar.newTab().setText("My Listing")
//				.setTag(TwitterApp.FRAGMENT_TAG_MY_LISTING)
//				.setIcon(R.drawable.ic_action_my_listing).setTabListener(this);
//		actionBar.addTab(tabMarketplace);
//		actionBar.addTab(tabMyListing);
//		actionBar.selectTab(tabMarketplace);
//	}
//	
//	@Override
//	public void onTabReselected(Tab tab, FragmentTransaction ft) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onTabSelected(Tab tab, FragmentTransaction ft) {
//		FragmentManager manager = getSupportFragmentManager();
//		android.support.v4.app.FragmentTransaction transaction = manager
//				.beginTransaction();
//		try {
//			if (tab.getTag().equals(TwitterApp.FRAGMENT_TAG_MARKETPLACE)) {
//				transaction.replace(R.id.frame_container,
//						new MyListingFragment());
//			} else if (tab.getTag().equals(TwitterApp.FRAGMENT_TAG_MY_LISTING)) {
//				 transaction.replace(R.id.frame_container, new MyListingFragment());
//			} else {
//				throw new IllegalArgumentException("unknown tag");
//			}
//		} finally {
//			transaction.commit();
//		}
//	}
//
//	@Override
//	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//		// TODO Auto-generated method stub
//
//	}
}
