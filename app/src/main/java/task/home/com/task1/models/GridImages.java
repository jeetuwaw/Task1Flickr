package task.home.com.task1.models;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("CanBeFinal")
public class GridImages implements Parcelable {
    @SuppressWarnings("CanBeFinal")
    private String mUrl;
    @SuppressWarnings("CanBeFinal")
    private String mTitle;


    public GridImages(String url, String name) {
        mUrl = url;
        mTitle = name;
    }

    private GridImages(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<GridImages> CREATOR = new Creator<GridImages>() {
        @Override
        public GridImages createFromParcel(Parcel in) {
            return new GridImages(in);
        }

        @Override
        public GridImages[] newArray(int size) {
            return new GridImages[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return mUrl;
    }


    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}
