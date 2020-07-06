package com.firatg.tdkdictionary.ui.favorite;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.adapter.FavoritiesAdapter;
import com.firatg.tdkdictionary.databinding.FavoritiesBinding;
import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.ui.search.FragmentDetail;
import com.firatg.tdkdictionary.ui.MainActivity;
import com.firatg.tdkdictionary.utils.SimpleDividerItemDecoration;
import com.firatg.tdkdictionary.utils.WordClickDetail;
import com.firatg.tdkdictionary.viewmodel.SearchViewModel;
import com.firatg.tdkdictionary.viewmodel.ShareViewModel;

import java.util.List;

import static com.firatg.tdkdictionary.utils.Statics.passOtherFragment;

public class FragmentFavorities extends Fragment {
    FavoritiesAdapter favoritiesAdapter;
    SearchViewModel searchViewModel;
    private ShareViewModel model;
    FavoritiesBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(
                inflater, R.layout.fragment_favorities, container, false);
        View view = binding.getRoot();
        binding.recyclerFavorities.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        model = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        searchViewModel =  new ViewModelProvider(requireActivity()).get(SearchViewModel.class);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setListebos(false);
        observeFavoriList();

    }



    public void controlListEmpty(List<Favori> favoris){
        if (favoris.size()>=1){
            binding.setListebos(true);
        }else {
            binding.setListebos(false);
        }
    }



    public void observeFavoriList(){
        searchViewModel.getfavlis().observe(requireActivity(), new Observer<List<Favori>>() {
            @Override
            public void onChanged(List<Favori> favoris) {

                controlListEmpty(favoris);

                favoritiesAdapter = new FavoritiesAdapter(favoris,requireActivity());
                binding.recyclerFavorities.setAdapter(favoritiesAdapter);

                favoritiesAdapter.setOnItemClickListener(new WordClickDetail() {
                    @Override
                    public void openDetail(String word) {
                        model.setName(word);
                        passOtherFragment(((MainActivity) requireActivity()), new FragmentDetail(), "detail",R.id.homeFrameLayout);
                    }
                });
            }
        });
    }

}
