package com.snapnsell.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.snapnsell.R;
import com.snapnsell.adapter.ItemsAdapter;
import com.snapnsell.model.Item;

public class MyListingFragment extends Fragment {

	private ItemsAdapter adapter;
	private ListView lvItems;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_my_listing, container,
				false);
		lvItems = (ListView) v.findViewById(R.id.lvItems);
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("desc", "japan", "title1", "/mnt/sdcard/Pictures/MyCameraApp/photo.jpg", 11.11, false));
		items.add(new Item("desc 2", "hong kong", "title2", "/mnt/sdcard/Pictures/MyCameraApp/photo.jpg", 22.22, false));
		
		adapter = new ItemsAdapter(getActivity(), items);
		lvItems.setAdapter(adapter);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
