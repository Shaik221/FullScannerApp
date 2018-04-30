package dagger.jani.com.filescanner;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewUtils {


    public static void toggleVisibility(ArrayList<TextView> viewList, boolean visibility) {
        int visiblilityVal = View.INVISIBLE;
        if(visibility)
        {
            visiblilityVal = View.VISIBLE;
        }
        for (TextView textView : viewList) {

            textView.setVisibility(visiblilityVal);
        }
    }
}
