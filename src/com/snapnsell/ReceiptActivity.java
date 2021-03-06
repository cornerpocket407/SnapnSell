package com.snapnsell;

import java.util.HashMap;

import org.json.JSONObject;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.activeandroid.query.Select;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.snapnsell.model.Item;

public class ReceiptActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receipt);
		
		final Item item = new Select().from(Item.class).orderBy("id").limit("1")
				.executeSingle();
		
		Button btnTweetPurchase = (Button) findViewById(R.id.btnTweetPurchase);
		btnTweetPurchase.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
		btnTweetPurchase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("status", "Just bought " + item.getTitle() + " for " + item.getPrice());
				TwitterApp.getRestClient().postTweet(new RequestParams(map), new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject jsonObject) {
						super.onSuccess(jsonObject);
						startActivity(new Intent(ReceiptActivity.this, MarketplaceActivity.class));
					}
				});;
			}
		});
	}
}
