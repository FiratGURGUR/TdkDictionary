package com.firatg.tdkdictionary.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.ui.favorite.FragmentFavorities;
import com.firatg.tdkdictionary.ui.main.FragmentMain;
import com.firatg.tdkdictionary.ui.search.FragmentSearch;
import com.firatg.tdkdictionary.utils.Statics;

import static com.firatg.tdkdictionary.utils.Statics.passOtherFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    View[] array;
    LinearLayout menu_home, menu_search, menu_about;
    ImageView m_home_img, m_search_img, m_about_img;
    public static FragmentManager fragmentManager;
    Fragment f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMenu();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_custom);

    }


    public void loadMenu() {
        //views
        menu_home = findViewById(R.id.menu_home_item);
        menu_search = findViewById(R.id.menu_search_item);
        menu_about = findViewById(R.id.menu_about_item);
        array = new View[]{menu_home, menu_search, menu_about};
        menu_home.setOnClickListener(this);
        menu_search.setOnClickListener(this);
        menu_about.setOnClickListener(this);
        //home
        m_home_img = menu_home.findViewById(R.id.imageView);
        m_home_img.setImageDrawable(getDrawable(R.drawable.ic_home));
        m_home_img.setColorFilter(m_home_img.getContext().getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
        //search
        m_search_img = menu_search.findViewById(R.id.imageView);
        m_search_img.setImageDrawable(getDrawable(R.drawable.ic_search));
        //about
        m_about_img = menu_about.findViewById(R.id.imageView);
        m_about_img.setImageDrawable(getDrawable(R.drawable.ic_favorite));

        passOtherFragment(MainActivity.this, new FragmentMain(), "homepage",R.id.homeFrameLayout);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        deactive_button(v.getId());
        switch (v.getId()) {
            case R.id.menu_home_item:
                if(!Statics.ControlFragment_TagName.equals("homepage")){
                    passOtherFragment(MainActivity.this, new FragmentMain(), "homepage",R.id.homeFrameLayout);
                }
                break;
            case R.id.menu_search_item:

                if(!Statics.ControlFragment_TagName.equals("searchpage")){
                    passOtherFragment(MainActivity.this, new FragmentSearch(), "searchpage",R.id.homeFrameLayout);
                }


                break;
            case R.id.menu_about_item:
                if(!Statics.ControlFragment_TagName.equals("favoritiespage")){
                    passOtherFragment(MainActivity.this, new FragmentFavorities(), "favoritiespage",R.id.homeFrameLayout);
                }
                break;
        }
    }


    public void deactive_button(int id) {
        for (View v : array) {
            if (v.getId() == id) {
                ImageView imageView = v.findViewById(R.id.imageView);
                imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
            } else {
                ImageView imageView = v.findViewById(R.id.imageView);
                imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }




}
