package com.firatg.tdkdictionary.utils;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindingUtil {

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("visibleInvisible")
    public static void visibleInvisible(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
    }

}
