package com.snapnsell.fragment;

import java.io.File;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.snapnsell.R;
import com.snapnsell.type.ItemDescSection;

public class ItemDescriptionFragment extends Fragment {

	public static final String BUNDLE_SECTION = "SECTION";
	protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 999;
	private Uri fileUri;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_item_description, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		final ItemDescSection itemDescSection = (ItemDescSection) getArguments().get(
				BUNDLE_SECTION);

		boolean enabled = itemDescSection == ItemDescSection.SELL;

		EditText etDescription = (EditText) getActivity().findViewById(
				R.id.etDescription);
		etDescription.setEnabled(enabled);
		EditText etPrice = (EditText) getActivity().findViewById(R.id.etPrice);
		etPrice.setEnabled(enabled);
		EditText etLocation = (EditText) getActivity().findViewById(
				R.id.etLoc);
		etLocation.setEnabled(enabled);

		ImageView ivItemPic = (ImageView) getActivity().findViewById(
				R.id.ivItemPic);
		ivItemPic.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {
				File mediaStorageDir = new File(
						Environment
								.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
						"MyCameraApp");
				// Create the storage directory if it does not exist
				if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
					Log.d("MyCameraApp", "failed to create directory");
				}
				fileUri = Uri.fromFile(new File(mediaStorageDir.getPath()
						+ File.separator + "photo.jpg"));
				// create Intent to take a picture and return control to the
				// calling application
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the
																	// image
																	// file name
				// start the image capture Intent
				startActivityForResult(intent,
						CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		});
		
	}

	// Used to retrieve the actual filesystem URI based on the media store
	// result
	private String getFileUri(Uri mediaStoreUri) {
		String[] filePathColumn = { MediaStore.Images.Media.DATA };
		Cursor cursor = getActivity().getContentResolver().query(mediaStoreUri,
				filePathColumn, null, null, null);
		cursor.moveToFirst();
		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		String fileUri = cursor.getString(columnIndex);
		cursor.close();

		return fileUri;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
//			String photoUri = getFileUri(data.getData());
			ImageView ivItemPic = (ImageView) getActivity().findViewById(
					R.id.ivItemPic);
			// ivItemPic.setImageBitmap(BitmapFactory.decodeFile(photoUri));

			if (data != null) {
				if (data.hasExtra("data")) {
					Bitmap thumbnail = data.getParcelableExtra("data");
					ivItemPic.setImageBitmap(thumbnail);
				}
			} else {
				// If there is no thumbnail image data, the image
				// will have been stored in the target output URI.
				// Resize the full image to fit in out image view.
				int width = ivItemPic.getWidth();
				int height = ivItemPic.getHeight();
				BitmapFactory.Options factoryOptions = new BitmapFactory.Options();
				factoryOptions.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(fileUri.getPath(), factoryOptions);
				int imageWidth = factoryOptions.outWidth;
				int imageHeight = factoryOptions.outHeight;
				// Determine how much to scale down the image
				int scaleFactor = Math.min(imageWidth / width, imageHeight
						/ height);
				// Decode the image file into a Bitmap sized to fill the View
				factoryOptions.inJustDecodeBounds = false;
				factoryOptions.inSampleSize = scaleFactor;
				factoryOptions.inPurgeable = true;
				Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
						factoryOptions);
				ivItemPic.setImageBitmap(bitmap);
			}
		}
	}

}
