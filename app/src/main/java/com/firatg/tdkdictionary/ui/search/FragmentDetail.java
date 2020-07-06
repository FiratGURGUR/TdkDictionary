package com.firatg.tdkdictionary.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.adapter.DetailMeaningAdapter;
import com.firatg.tdkdictionary.adapter.DetailProverbAdapter;
import com.firatg.tdkdictionary.databinding.DetailBinding;
import com.firatg.tdkdictionary.model.detail.AtasozuItem;
import com.firatg.tdkdictionary.model.detail.ResponseDetail;
import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.utils.SimpleDividerItemDecoration;
import com.firatg.tdkdictionary.utils.Statics;
import com.firatg.tdkdictionary.utils.WordClickDetail;
import com.firatg.tdkdictionary.viewmodel.SearchViewModel;
import com.firatg.tdkdictionary.viewmodel.ShareViewModel;

public class FragmentDetail extends Fragment {
    ShareViewModel model;
    SearchViewModel searchViewModel;
    DetailMeaningAdapter detailMeaningAdapter;
    DetailProverbAdapter detailProverbAdapter;
    DetailBinding binding;
    public String word = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detail, container, false);
        View view = binding.getRoot();
        binding.setVsblty(false);
       // model = ViewModelProviders.of(getActivity()).get(ShareViewModel.class);
        model = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        searchViewModel = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
       // searchViewModel = ViewModelProviders.of(getActivity()).get(SearchViewModel.class);

        init();

        Log.i("ffd", "onCreateView");

        return view;
    }


    public void init() {
        binding.setLifecycleOwner(this);
        binding.setVsblty(false);
        binding.recycSearchProverb.setHasFixedSize(true);
        binding.recycSearchMean.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        binding.addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.getFav() == null) {
                    searchViewModel.insert(new Favori(model.getName().getValue(), true));
                    Statics.showAddFavori(getActivity(),binding.getDetail().capitalizeDetail() +" favorilere eklendi",R.color.green);
                } else {
                    binding.getFav().setLike(!binding.getFav().isLike());
                    searchViewModel.update(binding.getFav());

                    if (binding.getFav().isLike()){
                        Statics.showAddFavori(getActivity(),binding.getDetail().capitalizeDetail() +" favorilere eklendi",R.color.green);
                    }else {
                        Statics.showAddFavori(getActivity(),binding.getDetail().capitalizeDetail() +" favorilerden kaldırıldı",R.color.red);
                    }
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i("ffd", "onActivityCreated");
        model.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                word = s;
                observeDetail(word);

                searchViewModel.getFavoriLiveData(word).observe(getViewLifecycleOwner(), new Observer<Favori>() {
                    @Override
                    public void onChanged(Favori favori) {
                        binding.setFav(favori);
                    }
                });

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.setVsblty(false);
        searchViewModel.cleardetail();
        Log.i("ffd", "onDestroy");

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("ffd", "onViewCreated");
    }

    public void observeDetail(String s) {
        searchViewModel.detaill(s).observe(getViewLifecycleOwner(), new Observer<ResponseDetail>() {
            @Override
            public void onChanged(ResponseDetail responseDetail) {
                Log.i("hata",responseDetail.toString());
                binding.setVsblty(true);
                if (responseDetail.getAtasozu() != null) {
                    detailProverbAdapter = new DetailProverbAdapter(responseDetail.getAtasozu(), getActivity());
                    detailProverbAdapter.setOnItemClickListener(new WordClickDetail() {
                        @Override
                        public void openDetail(String word) {
                            binding.setVsblty(false);
                            model.setName(word);
                        }
                    });
                    binding.recycSearchProverb.setAdapter(detailProverbAdapter);
                } else {
                    binding.recycSearchProverb.setAdapter(null);
                }
                detailMeaningAdapter = new DetailMeaningAdapter(responseDetail.getAnlamlarListe(), getActivity());
                binding.recycSearchMean.setAdapter(detailMeaningAdapter);
                binding.setDetail(responseDetail);
            }
        });

    }

}
