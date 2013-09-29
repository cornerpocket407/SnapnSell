package com.snapnsell.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.snapnsell.R;
import com.snapnsell.ReceiptActivity;

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
		btnPurchase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getActivity(), ReceiptActivity.class));
			}
		});
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
