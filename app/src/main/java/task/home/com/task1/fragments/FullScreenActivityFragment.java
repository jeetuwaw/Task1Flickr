package task.home.com.task1.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.jobs.VolleyReqPoolJob;
import task.home.com.task1.models.GridImages;

/**
 * A placeholder fragment containing a simple view.
 */
@SuppressWarnings("ConstantConditions")
public class FullScreenActivityFragment extends Fragment {

   // private ImageView imageView;
    private GridImages gridImages;
    private NetworkImageView imageView;
    private ImageLoader mImageLoader;


    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment when activity is re-initialized
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fc_fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        imageView = getActivity().findViewById(R.id.fcimage);

        gridImages = (GridImages) getActivity().getIntent().getExtras().get(Utils.EXTRA_SPACE_PHOTO);
        // Instantiate the RequestQueue.
        mImageLoader = VolleyReqPoolJob.getInstance(getActivity().getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        mImageLoader.get(gridImages.getUrl(), ImageLoader.getImageListener(imageView,
                R.drawable.ic_launcher_foreground, android.R.drawable
                        .ic_dialog_alert));
        imageView.setImageUrl(gridImages.getUrl(), mImageLoader);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        imageView = null;
        gridImages = null;
        mImageLoader = null;
    }
}
