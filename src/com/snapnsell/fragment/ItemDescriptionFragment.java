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
import android.widget.EditText;
import android.widget.ImageView;

import com.activeandroid.query.Select;
import com.snapnsell.R;
import com.snapnsell.model.Item;
import com.snapnsell.type.ItemDescSection;

public class ItemDescriptionFragment extends Fragment {

	public static final String BUNDLE_SECTION = "SECTION";
	protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 999;
	private Uri itemPicUri;
	private EditText etDescription;
	private EditText etPrice;
	private EditText etLocation;
	private ImageView ivItemPic;
	private EditText etTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
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
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		final ItemDescSection section = (ItemDescSection) getArguments().get(
				BUNDLE_SECTION);
		init(section == ItemDescSection.SELL);
		if (section == ItemDescSection.CONFIRM) {
			Item item = new Select().from(Item.class).orderBy("id").limit("1")
					.executeSingle();
			etDescription.setText(item.getDescription());
			etTitle.setText(item.getTitle());
			etLocation.setText(item.getLocation());
			String itemPicPath = item.getItemPicPath();
			if (!item.getItemPicPath().isEmpty()) {
				setImage(itemPicPath);
			}
		}
	}

	private void init(boolean enabled) {
		setEtDescription((EditText) getActivity().findViewById(
				R.id.etDescription));
		getEtDescription().setEnabled(enabled);

		setEtPrice((EditText) getActivity().findViewById(R.id.etPrice));
		getEtPrice().setEnabled(enabled);

		setEtLocation((EditText) getActivity().findViewById(R.id.etLoc));
		getEtLocation().setEnabled(enabled);

		setEtTitle((EditText) getActivity().findViewById(R.id.etTitle));
		getEtTitle().setEnabled(enabled);

		setIvItemPic((ImageView) getActivity().findViewById(R.id.ivItemPic));
		getIvItemPic().setOnClickListener(new OnClickListener() {

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
				itemPicUri = (Uri.fromFile(new File(mediaStorageDir.getPath()
						+ File.separator + "photo.jpg")));
				// create Intent to take a picture and return control to the
				// calling application
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, itemPicUri); // set the
																		// image
																		// file
																		// name
				// start the image capture Intent
				startActivityForResult(intent,
						CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		});
	}

	public Uri getPhotoFileUri(String fileName) {
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"MyCameraApp");

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
			Log.d("MyCameraApp", "failed to create directory");
		}
		// Specify the file target for the photo
		return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator
				+ fileName));
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			Uri takenPhotoUri = getPhotoFileUri("photo.jpg");
			// by this point we have the camera photo on disk
			setImage(takenPhotoUri.getPath());
		}
	}

	private void setImage(String photoPath) {
		Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
		ivItemPic.setImageBitmap(bitmap);
	}

	public EditText getEtDescription() {
		return etDescription;
	}

	public void setEtDescription(EditText etDescription) {
		this.etDescription = etDescription;
	}

	public EditText getEtPrice() {
		return etPrice;
	}

	public void setEtPrice(EditText etPrice) {
		this.etPrice = etPrice;
	}

	public EditText getEtLocation() {
		return etLocation;
	}

	public void setEtLocation(EditText etLocation) {
		this.etLocation = etLocation;
	}

	public ImageView getIvItemPic() {
		return ivItemPic;
	}

	public void setIvItemPic(ImageView ivItemPic) {
		this.ivItemPic = ivItemPic;
	}

	public EditText getEtTitle() {
		return etTitle;
	}

	public void setEtTitle(EditText etTitle) {
		this.etTitle = etTitle;
	}

	public Uri getItemPicUri() {
		return itemPicUri;
	}

	public void setItemPicUri(Uri itemPicUri) {
		this.itemPicUri = itemPicUri;
	}

}
