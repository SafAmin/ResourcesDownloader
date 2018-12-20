package com.orange.resourcesdownloadlibrary.resourcestasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.orange.resourcesdownloadlibrary.core.ResourcesLoader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class is a loader class that extends AsyncTask. which accomplish download image task asynchronously.
 * without lock up the screen on the user while it is downloading each of the resources.
 *
 * Created by Safa Amin on 12/19/2018.
 */

public class LoadImagesTask extends AsyncTask<String, Void, Bitmap> {

    private ResourcesLoader resourcesLoader;
    private final WeakReference<ImageView> imageViewReference;

    public LoadImagesTask(ImageView imageView) {
        this.imageViewReference = new WeakReference<>(imageView);
        resourcesLoader = new ResourcesLoader();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(params[0]).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

       /*if(resourcesLoader != null) {
            resourcesLoader.initLruCache();
            resourcesLoader.addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
        } */

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }
}
