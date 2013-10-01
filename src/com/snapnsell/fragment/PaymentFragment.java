package com.snapnsell.fragment;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.snapnsell.BuyActivity;
import com.snapnsell.R;
import com.snapnsell.ReceiptActivity;
import com.snapnsell.activity.PaymentActivity;
import com.snapnsell.model.Item;

public class PaymentFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_payment,
				container, false);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Button btnPurchase = (Button) getActivity().findViewById(R.id.btnPurchase);
		btnPurchase.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
		btnPurchase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Item item = (Item) getActivity().getIntent().getSerializableExtra("marketplaceItem");
				Bundle bundle = new Bundle();
				Intent intent = new Intent(getActivity(), ReceiptActivity.class);
				intent.putExtra("marketplaceItem", item);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
