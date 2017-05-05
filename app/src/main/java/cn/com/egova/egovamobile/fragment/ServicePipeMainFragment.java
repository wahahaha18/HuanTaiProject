package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.TabPageAdapter;
import cn.com.egova.egovamobile.databinding.FragmentMainBinding;

/**
 * 社管通首页
 * Created by y11621546 on 2017/5/3.
 */

public class ServicePipeMainFragment extends BasePageFragment {
    public static ServicePipeMainFragment newInstance() {
        Bundle args = new Bundle();
        ServicePipeMainFragment fragment = new ServicePipeMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    String[] titles = new String[]{"问题上报", "我的任务", "民情日志", "人口管理", "房屋管理", "地图浏览"};
    private FragmentMainBinding binding;

    @Override
    public boolean prepareFetchData(boolean forceUpdate) {
        return super.prepareFetchData(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ProblemReportFragment.newInstance());
        fragmentList.add(TaskFragment.newInstance());
        fragmentList.add(PeopleJournalFragment.newInstance());
        fragmentList.add(PopulationManagementFragment.newInstance());
        fragmentList.add(HousingManagementFragment.newInstance());
        fragmentList.add(MapBrowsingFragment.newInstance());
        TabPageAdapter adapter = new TabPageAdapter(getChildFragmentManager(), fragmentList, titles);
        binding.pager.setAdapter(adapter);
        binding.slidingTabs.setupWithViewPager(binding.pager);
        return binding.getRoot();
    }

    @Override
    public void fetchData() {
        setTitle(getString(R.string.main_title));

    }
}
