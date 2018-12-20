package com.orange.resourcesdownloadlibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;


/**
 * Resources utilities class
 * <p>
 * Created by Safa Amin on 12/19/2018.
 */

public class ResourcesUtils {

    /**
     * This method responsible for using resource from the library res
     */
    public static Drawable getDrawable(Context context, String resource_name) {
        try {
            int resId = context.getResources().getIdentifier(resource_name, "drawable",
                    context.getPackageName());
            if (resId != 0) {
                return context.getResources().getDrawable(resId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
