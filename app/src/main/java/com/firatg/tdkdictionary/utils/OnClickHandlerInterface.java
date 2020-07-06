package com.firatg.tdkdictionary.utils;

import android.view.View;

import com.firatg.tdkdictionary.model.homepage.KuralItem;
import com.firatg.tdkdictionary.model.homepage.Url;

public interface OnClickHandlerInterface {
    void openWebView(KuralItem url);
}