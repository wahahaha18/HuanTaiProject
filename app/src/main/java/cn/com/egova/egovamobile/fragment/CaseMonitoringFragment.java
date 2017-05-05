package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.MyLocationStyle;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentMapCaseBinding;

/**
 * 案件监控
 * Created by y11621546 on 2017/5/3.
 */

public class CaseMonitoringFragment extends BasePageFragment {
    public static CaseMonitoringFragment newInstance() {

        Bundle args = new Bundle();

        CaseMonitoringFragment fragment = new CaseMonitoringFragment();
        fragment.setArguments(args);
        return fragment;
    }

    AMap aMap;
    private FragmentMapCaseBinding binding;

    @Override
    public boolean prepareFetchData(boolean forceUpdate) {
        return super.prepareFetchData(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_case, container, false);
        binding.bmapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
//初始化地图控制器对象

        if (aMap == null) {
            aMap = binding.bmapView.getMap();
        }
        return binding.getRoot();
    }

    @Override
    public void fetchData() {
//        MyLocationStyle myLocationStyle;
//        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类
//        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
////        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
//        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
//        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        binding.bmapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.bmapView.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        binding.bmapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.bmapView.onDestroy();
    }
}
