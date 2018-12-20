package com.orange.resourcesdownloader.pinboard;

import com.orange.resourcesdownloader.base.BaseView;
import com.orange.resourcesdownloader.models.Urls;

import java.util.List;

/**
 * Created by Safa Amin on 12/20/2018.
 */

public interface PinBoardView extends BaseView {

    void invalidateView(List<Urls> urlsList);

    void handleError();
}
