package task.home.com.task1.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.models.GridImages;

@SuppressWarnings({"ConstantConditions", "FieldCanBeLocal"})
public class FullScreenActivity extends AppCompatActivity {

    private GridImages mGridImage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs_activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setGridImages((GridImages) getIntent().getExtras().getSerializable(Utils.EXTRA_SPACE_PHOTO));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setGridImages(GridImages gridImages) {
        this.mGridImage = gridImages;
    }

}
