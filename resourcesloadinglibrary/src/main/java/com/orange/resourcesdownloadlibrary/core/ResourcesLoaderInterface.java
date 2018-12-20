package com.orange.resourcesdownloadlibrary.core;

import android.graphics.Bitmap;

/**
 * Created by Safa Amin on 12/19/2018.
 */

public interface ResourcesLoaderInterface {

    void addBitmapToMemoryCache(String key, Bitmap bitmap);

    Bitmap getBitmapFromMemCache(String key);
}
