package task.home.com.task1.activitys;

import android.app.Activity;
import android.os.Bundle;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.models.GridImages;

@SuppressWarnings({"ConstantConditions", "FieldCanBeLocal"})
public class FullScreenActivity extends Activity {

    private GridImages mGridImage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs_activity_main);

        setGridImages((GridImages) getIntent().getExtras().getSerializable(Utils.EXTRA_SPACE_PHOTO));
    }

    private void setGridImages(GridImages gridImages) {
        this.mGridImage = gridImages;
    }

}
