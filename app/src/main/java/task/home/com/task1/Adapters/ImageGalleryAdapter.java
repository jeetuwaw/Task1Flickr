package task.home.com.task1.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.activitys.FullScreenActivity;
import task.home.com.task1.jobs.VolleyReqPoolJob;
import task.home.com.task1.models.GridImages;

@SuppressWarnings("CanBeFinal")
public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

    private ArrayList<GridImages> mListOfPhotos;
    private Activity mActivity;
    private GridImages photo;
    private NetworkImageView imageView;
    private ImageLoader mImageLoader;


    @NonNull
    @Override
    public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(photoView);
    }

    // ...
    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         photo = mListOfPhotos.get(position);
         imageView = holder.mPhotoImageView;

        // Instantiate the RequestQueue.
        mImageLoader = VolleyReqPoolJob.getInstance(mActivity.getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        mImageLoader.get(photo.getUrl(), ImageLoader.getImageListener(imageView,
                R.drawable.ic_launcher_foreground, android.R.drawable
                        .ic_dialog_alert));
        imageView.setImageUrl(photo.getUrl(), mImageLoader);


    }

    @Override
    public int getItemCount() {
        return (mListOfPhotos.size());
    }

    @SuppressWarnings("CanBeFinal")
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        NetworkImageView mPhotoImageView;

        MyViewHolder(View itemView) {

            super(itemView);
            mPhotoImageView = itemView.findViewById(R.id.iv_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                GridImages image = mListOfPhotos.get(position);
                Intent intent = new Intent(mActivity, FullScreenActivity.class);
                intent.putExtra(Utils.EXTRA_SPACE_PHOTO, image);
                mActivity.startActivity(intent);
            }
        }
    }



    public ImageGalleryAdapter(Activity activity, ArrayList<GridImages> listOfPhotos) {
        mActivity = activity;
        mListOfPhotos = listOfPhotos;
    }
}
