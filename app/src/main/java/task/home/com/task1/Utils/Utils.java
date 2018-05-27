package task.home.com.task1.Utils;


import android.app.Activity;
import android.net.ConnectivityManager;

@SuppressWarnings("AccessStaticViaInstance")
public class Utils {


    public static final String URL = "https://api.flickr.com/services/feeds/photos_public.gne";
    public static final String FEED = "feed";
    public static final String ENTRY = "entry";
    public static final String CONTENTS = "content";
    public static final String AUTHORS = "author";
    public static final String LINK = "link";
    public static final String CATEGORYS = "category";

    public static final String TITLE = "title";
    public static final String ID = "id";
    public static final String ICON = "icon";
    public static final String SUBTITLE = "subtitle";
    public static final String UPDATED = "updated";
    public static final String GENERATOR = "generator";
    public static final String PUBLISHED = "published";
    public static final String FLICKER_DATE_TAKEN = "flickr:date_taken";
    public static final String DC_DATE_TAKEN = "dc:date.Taken";
    public static final String NAME = "name";
    public static final String URI = "uri";
    public static final String NSID = "flickr:nsid";
    public static final String BUDDYICON = "flickr:buddyicon";

    public static final String HREF = "href";
    public static final String REL = "rel";
    public static final String TYPE = "type";

    public static final String DISPLAYCATEGORIES = "displaycategories";
    public static final String EXTRA_SPACE_PHOTO = "images";


    public static boolean checkInternetConenction(Activity activity) {
        // get Connectivity Manager object to check connection
        ConnectivityManager connectivityManager
                =(ConnectivityManager)activity.getSystemService(activity.getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        assert connectivityManager != null;
        if ( connectivityManager.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
            return true;
        }else if (
                connectivityManager.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connectivityManager.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  ) {
            return false;
        }
        return false;
    }


}