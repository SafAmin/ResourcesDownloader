package com.orange.resourcesdownloadlibrary.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;

import com.orange.resourcesdownloadlibrary.ResourcesUtils;
import com.orange.resourcesdownloadlibrary.resourcestasks.LoadImagesTask;

/**
 * This class responsible for execute download resources task from URL and resources caching using LRUCache
 * <p>
 * Created by Safa Amin on 12/19/2018.
 */

public class ResourcesLoader implements ResourcesLoaderInterface {

    private LruCache<String, Bitmap> mMemoryCache;
    private final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private final int cacheSize = maxMemory / 8;

    public void initLruCache() {
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public void loadResources(Context context, String url, View view) {
        if (view instanceof ImageView) {
            final Bitmap bitmap = getBitmapFromMemCache(url);
            ImageView imageView = (ImageView) view;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageDrawable(ResourcesUtils.getDrawable(context, "ic_launcher"));
                LoadImagesTask task = new LoadImagesTask(imageView);
                task.execute(url);
            }
        }
    }

    @Override
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    @Override
    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }
}
