package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentMapPersonBinding;

/**
 * 人员监控
 * Created by y11621546 on 2017/5/3.
 */

public class PersonnelMonitoringFragment extends BasePageFragment {
    public static PersonnelMonitoringFragment newInstance() {

        Bundle args = new Bundle();

        PersonnelMonitoringFragment fragment = new PersonnelMonitoringFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentMapPersonBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_person, container, false);
        binding.bmapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = binding.bmapView.getMap();

//        aMap.setTrafficEnabled(true);// 显示实时交通状况
//        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
//        aMap.setMapType(AMap.MAP_TYPE_NORMAL);// 卫星地图模式
        return binding.getRoot();
    }

    @Override
    public boolean prepareFetchData(boolean forceUpdate) {
        return super.prepareFetchData(true);
    }

    @Override
    public void fetchData() {


    }

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        binding.bmapView.onSaveInstanceState(outState);
    }
}
