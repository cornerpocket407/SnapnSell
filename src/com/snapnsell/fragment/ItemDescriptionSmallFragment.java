package com.snapnsell.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.snapnsell.R;
import com.snapnsell.model.Item;

public class ItemDescriptionSmallFragment extends Fragment {

	private TextView tvPrice;
	private TextView tvLocation;
	private ImageView ivItemPic;
	private TextView tvTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_item_description_small,
				container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		init();
		Item item = new Select().from(Item.class).orderBy("id desc").limit("1")
				.executeSingle();
		tvTitle.setText(item.getTitle());
		tvLocation.setText(item.getLocation());
		tvPrice.setText(String.valueOf(item.getPrice()));
		String itemPicPath = item.getItemPicPath();
		if (item.getItemPicPath() != null) {
			setImage(itemPicPath);
		}
	}

	private void init() {
		tvPrice = (TextView) getActivity().findViewById(R.id.tvPrice);
		tvLocation = (TextView) getActivity().findViewById(R.id.tvLocation);
		tvTitle = (TextView) getActivity().findViewById(R.id.tvTitle);
		ivItemPic = (ImageView) getActivity().findViewById(R.id.ivItemPic);
	}
	
	private void setImage(String photoPath) {
		Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
		ivItemPic.setImageBitmap(bitmap);
	}
}
