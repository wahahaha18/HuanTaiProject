package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentMapBinding;

/**
 * 地图浏览
 * Created by y11621546 on 2017/5/3.
 */

public class MapBrowsingFragment extends BasePageFragment {
    public static MapBrowsingFragment newInstance() {

        Bundle args = new Bundle();

        MapBrowsingFragment fragment = new MapBrowsingFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentMapBinding binding;


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.bmapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        binding.bmapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.bmapView.onPause();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false);
       binding.bmapView.onCreate(savedInstanceState);
        return binding.getRoot();
    }



    @Override
    public void fetchData() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        binding.bmapView.onSaveInstanceState(outState);
    }
}
