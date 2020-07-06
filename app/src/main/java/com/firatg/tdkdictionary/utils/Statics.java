package com.firatg.tdkdictionary.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.ui.MainActivity;

import org.aviran.cookiebar2.CookieBar;

public class Statics {
    public static Fragment ControlFragment = null;
    public static String ControlFragment_TagName = "";
    public static Fragment f;
    public static int connectivityStatus=0;


    //FRAGMENT İŞLEMLERİ
    public static void passOtherFragment(AppCompatActivity activity, Fragment fragment, String tag, int container) {
        MainActivity.fragmentManager = activity.getSupportFragmentManager();
        FragmentManager manager = activity.getSupportFragmentManager();
        if (isFragmentInBackstack(manager, Statics.ControlFragment_TagName)) {
            manager.beginTransaction().remove(Statics.ControlFragment).commit();
        }
        open_fragment(activity, fragment, tag,container);
    }
    public static boolean isFragmentInBackstack(final FragmentManager fragmentManager, final String fragmentTagName) {
        for (int entry = 0; entry < fragmentManager.getBackStackEntryCount(); entry++) {
            if (fragmentTagName.equals(fragmentManager.getBackStackEntryAt(entry).getName())) {
                return true;
            }
        }
        return false;
    }
    public static void open_fragment(AppCompatActivity activity, Fragment fragment, String tag,int container) {
        if (f != null)
            f.onDestroy();
        f = fragment;
        FragmentManager manager = activity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(container, fragment, tag)
                .addToBackStack(fragment.getTag())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
        Statics.ControlFragment = fragment;
        Statics.ControlFragment_TagName = tag;
    }

    public static void showError(Activity context,String message){
        CookieBar.build(context)
                .setTitle("UYARI")
                .setMessage(message)
                .setBackgroundColor(R.color.splash)
                .setDuration(2500)
                .setIcon(R.drawable.ic_wifi)
                .setCookiePosition(CookieBar.TOP)
                .show();
    }

    public static void showAddFavori(Activity context,String message,int color){
        CookieBar.build(context)
                .setMessage(message)
                .setBackgroundColor(color)
                .setDuration(1500)
                .setCookiePosition(CookieBar.TOP)
                .show();
    }


    public static boolean getConnectionStatus(Context context) {
        ConnectivityManager mConnectivityManager;
        NetworkInfo mNetworkInfoMobile, mNetworkInfoWifi;

        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        mNetworkInfoMobile = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        mNetworkInfoWifi = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        try {
            if (mNetworkInfoMobile.isConnected()) {
                connectivityStatus = 1;

                return true;
            }
        } catch (Exception exception) {
            // exception.printStackTrace();
        }

        if (mNetworkInfoWifi.isConnected()) {
            connectivityStatus = 1;

            return true;
        } else {
            connectivityStatus = 0;
            return false;
        }
    }

}
