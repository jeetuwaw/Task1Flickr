package task.home.com.task1.jobs;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import task.home.com.task1.Parser.FlickrXmlParser;
import task.home.com.task1.R;
import task.home.com.task1.activitys.MainActivity;
import task.home.com.task1.fragments.MainActivityFragment;
import task.home.com.task1.models.FlickrModel;

@SuppressLint("StaticFieldLeak")
public class FeedConsumerJob extends AsyncTask<String, Integer, FlickrModel> {

    private final MainActivity mActivity;

    public FeedConsumerJob(MainActivity activity) {
        this.mActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ((MainActivityFragment) mActivity.getSupportFragmentManager().
                findFragmentById(R.id.fragment)).getSpinner().setVisibility(View.VISIBLE);

    }

    @Override
    protected FlickrModel doInBackground(String... str) {
        try {
            URL url = new URL(str[0]);
            InputStream inputStream = url.openConnection().getInputStream();
            FlickrXmlParser flickrXmlParser = new FlickrXmlParser(inputStream);
            return flickrXmlParser.getListOfModels();
        } catch (IOException e) {
            Log.e("", "Error", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(FlickrModel model) {
        super.onPostExecute(model);
        ((MainActivityFragment) mActivity.getSupportFragmentManager().
                findFragmentById(R.id.fragment)).getSpinner().setVisibility(View.GONE);
    }
}
