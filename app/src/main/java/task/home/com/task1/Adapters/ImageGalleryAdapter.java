package task.home.com.task1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import task.home.com.task1.R;
import task.home.com.task1.Utils.Utils;
import task.home.com.task1.activitys.FullScreenActivity;
import task.home.com.task1.models.GridImages;

@SuppressWarnings("CanBeFinal")
public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

    @NonNull
    @Override
    public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(photoView);
    }

    // ...
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final GridImages photo = mListOfPhotos.get(position);
        final ImageView imageView = holder.mPhotoImageView;

        Glide.with(mContext)
                .load(photo.getUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);

    }
// ...

    @Override
    public int getItemCount() {
        return (mListOfPhotos.size());
    }

    @SuppressWarnings("CanBeFinal")
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mPhotoImageView;

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
                Intent intent = new Intent(mContext, FullScreenActivity.class);
                intent.putExtra(Utils.EXTRA_SPACE_PHOTO, image);
                mContext.startActivity(intent);
            }
        }
    }

    private ArrayList<GridImages> mListOfPhotos;
    private Context mContext;

    public ImageGalleryAdapter(Context context, ArrayList<GridImages> listOfPhotos) {
        mContext = context;
        mListOfPhotos = listOfPhotos;
    }
}
