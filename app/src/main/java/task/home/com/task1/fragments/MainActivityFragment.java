package task.home.com.task1.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import task.home.com.task1.Adapters.ImageGalleryAdapter;
import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.jobs.FeedConsumerJob;
import task.home.com.task1.models.FlickrModel;
import task.home.com.task1.models.GridImages;

/**
 * A placeholder fragment containing a simple view.
 */
@SuppressWarnings("ConstantConditions")
public class MainActivityFragment extends Fragment {

    private FlickrModel flickrModel;
    private ArrayList<String> urls;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageGalleryAdapter recyclerViewAdapter;
    private ArrayList<GridImages> gridList;
    private ProgressBar spinner;

    public MainActivityFragment() {
    }


    public ProgressBar getSpinner() {
        return spinner;
    }

    private void setSpinner(ProgressBar spinner) {
        this.spinner = spinner;
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
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        handleUiAndData();
    }

    public void handleUiAndData() {
        recyclerView = (getActivity()).findViewById(R.id.rv_images);
        setSpinner((ProgressBar) (getActivity().findViewById(R.id.progressBar)));
        try {
            if (Utils.checkInternetConenction(getActivity())) {
                prepareData();
                updateViews();
            } else {
                displayDialog();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayDialog() {
        getSpinner().setVisibility(View.GONE);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = alertDialogBuilder.create();
        dialog.setTitle("Please check your internet connection and try again...");
        dialog.setCancelable(true);
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void updateViews() {
        recyclerViewAdapter = new ImageGalleryAdapter(this.getContext(), gridList);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void prepareData() throws ExecutionException, InterruptedException {
        flickrModel = new FeedConsumerJob((task.home.com.task1.activitys.MainActivity) getActivity()).execute(Utils.URL).get();
        urls = new ArrayList<>();
        gridList = new ArrayList<>();
        for (int i = 0; i < flickrModel.getFeed().getEntry().size(); i++) {
            urls.add(flickrModel.getFeed().getEntry().get(i).getLink().get(i).getHref());
            GridImages gridImage = new GridImages(urls.get(i), "");
            gridList.add(gridImage);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recyclerView = null;
        flickrModel = null;
        layoutManager = null;
        recyclerViewAdapter = null;
        urls = null;
        setSpinner(null);
    }
}
