package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.TabPageAdapter;
import cn.com.egova.egovamobile.databinding.FragmentMainBinding;

/**
 * 领导通首页
 * Created by y11621546 on 2017/5/3.
 */

public class LeaderMainFragment extends BasePageFragment {
    public static LeaderMainFragment newInstance() {
        Bundle args = new Bundle();
        LeaderMainFragment fragment = new LeaderMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    String[] titles = new String[]{"实时问题", "急要件", "督办件", "超时件", "评价考核", "案件监控", "人员监控"};
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
        fragmentList.add(RealTimeQuestionFragment.newInstance());
        fragmentList.add(HurryPieceFragment.newInstance());
        fragmentList.add(SupervisionPieceFragment.newInstance());
        fragmentList.add(TimeOutPieceFragment.newInstance());
        fragmentList.add(EvaluationFragment.newInstance());
        fragmentList.add(CaseMonitoringFragment.newInstance());
        fragmentList.add(PersonnelMonitoringFragment.newInstance());
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
