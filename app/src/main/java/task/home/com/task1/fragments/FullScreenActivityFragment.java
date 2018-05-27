package task.home.com.task1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.models.GridImages;

/**
 * A placeholder fragment containing a simple view.
 */
@SuppressWarnings("ConstantConditions")
public class FullScreenActivityFragment extends Fragment {

    private ImageView imageView;
    private GridImages gridImages;


    public FullScreenActivityFragment() {
    }

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
        Glide.with(getActivity())
                .load(gridImages.getUrl())
                .asBitmap()
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        imageView = null;
        gridImages = null;
    }
}
