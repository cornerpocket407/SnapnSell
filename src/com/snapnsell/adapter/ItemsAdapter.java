package com.snapnsell.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.snapnsell.R;
import com.snapnsell.model.Item;

public class ItemsAdapter extends ArrayAdapter<Item> {

	private Context context;

	public ItemsAdapter(Context context, List<Item> items) {
		super(context, 0, items);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item
		Item item = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.fragment_item_description_small,
					null);

		}

		TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
		TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
		TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		ImageView ivItemPic = (ImageView) view.findViewById(R.id.ivItemPic);
		tvTitle.setText(item.getTitle());
		tvLocation.setText(item.getLocation());
		tvPrice.setText(String.valueOf(item.getPrice()));
		String itemPicPath = item.getItemPicPath();
		if (item.getItemPicPath() != null) {
			Bitmap bitmap = BitmapFactory.decodeFile(item.getItemPicPath());
			ivItemPic.setImageBitmap(bitmap);
		}
		return view;
	}
}
