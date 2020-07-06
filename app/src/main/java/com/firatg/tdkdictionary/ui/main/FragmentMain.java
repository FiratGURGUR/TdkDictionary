package com.firatg.tdkdictionary.ui.main;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.adapter.shuffleAdapter;
import com.firatg.tdkdictionary.databinding.FragmentMainBinding;
import com.firatg.tdkdictionary.model.homepage.KaristirmaItem;
import com.firatg.tdkdictionary.model.homepage.KuralItem;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;
import com.firatg.tdkdictionary.model.homepage.Url;
import com.firatg.tdkdictionary.ui.MainActivity;
import com.firatg.tdkdictionary.ui.WebActivity;
import com.firatg.tdkdictionary.ui.search.FragmentDetail;
import com.firatg.tdkdictionary.utils.OnClickHandlerInterface;
import com.firatg.tdkdictionary.utils.StartSnapHelper;
import com.firatg.tdkdictionary.utils.WordClickDetail;
import com.firatg.tdkdictionary.viewmodel.HomeViewModel;
import com.firatg.tdkdictionary.viewmodel.ShareViewModel;

import java.util.List;

import static com.firatg.tdkdictionary.utils.Statics.passOtherFragment;

public class FragmentMain extends Fragment {
    HomeViewModel homeViewModel;
    SwipeRefreshLayout swipeRefreshLayout;
    //karıştırma
    RecyclerView shuffleRecyclerView;
    shuffleAdapter _shuffleAdapter;
    private ShareViewModel model;
    FragmentMainBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();

        //binding.setLifecycleOwner(getActivity());

        model = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);


        swipeRefreshLayout = binding.swiperefresh;
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        homeViewModel.getAnasayifa().observe(requireActivity(), new Observer<ResponseHome>() {
                            @Override
                            public void onChanged(ResponseHome responseHome) {
                                binding.setContent(responseHome);
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }
        );
        OnClickHandlerInterface call = new OnClickHandlerInterface() {
            @Override
            public void openWebView(KuralItem kural) {
                Intent i = new Intent(getActivity(), WebActivity.class);
                Url url = new Url(kural.getAdi(),kural.getUrl());
                i.putExtra("kural", url);
                startActivity(i);
            }
        };
        binding.setCallback(call);

        return view;
    }

    public void loadShuffleList(){
        shuffleRecyclerView= binding.karistirmaRecycler;
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        shuffleRecyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelper = new StartSnapHelper();
        snapHelper.attachToRecyclerView(shuffleRecyclerView);
        shuffleRecyclerView.setHasFixedSize(true);
        homeViewModel.getKarsilastirmaList().observe(requireActivity(), new Observer<List<KaristirmaItem>>() {
            @Override
            public void onChanged(List<KaristirmaItem> karistirmaItems) {
                _shuffleAdapter = new shuffleAdapter(karistirmaItems,getContext());
                shuffleRecyclerView.setAdapter(_shuffleAdapter);
                _shuffleAdapter.setOnItemClickListener(new WordClickDetail() {
                    @Override
                    public void openDetail(String word) {
                        model.setName(word);
                        passOtherFragment(((MainActivity) requireActivity()), new FragmentDetail(), "detail",R.id.homeFrameLayout);
                    }
                });
            }
        });
    }


    public void observeIcerik(){
        homeViewModel.getAnasayifa().observe(requireActivity(), new Observer<ResponseHome>() {
            @Override
            public void onChanged(ResponseHome responseHome) {
                binding.setContent(responseHome);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        observeIcerik();
        loadShuffleList();

    }
}
