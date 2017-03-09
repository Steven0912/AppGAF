package steven.developer.appgaf.utils;

import android.view.View;

import java.util.List;

/**
 * Created by DESARROLLO HAPPY INC on 3/03/2017.
 */

public class Util {

    public static void showViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

}
