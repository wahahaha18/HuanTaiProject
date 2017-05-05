package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.bingoogolapple.badgeview.BGABadgeImageView;
import cn.bingoogolapple.badgeview.BGABadgeLinearLayout;
import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.TabPageAdapter;
import cn.com.egova.egovamobile.databinding.FragmentProblemEportBinding;

/**
 * 问题上报
 * Created by y11621546 on 2017/5/3.
 */

public class ProblemReportFragment extends BasePageFragment {
    public static ProblemReportFragment newInstance() {

        Bundle args = new Bundle();

        ProblemReportFragment fragment = new ProblemReportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentProblemEportBinding binding;
    private String[] titles = new String[]{"事件描述", "多媒体"};

    private int[] icones = new int[]{R.drawable.event_describe_tab, R.drawable.media_tab};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_problem_eport, container, false);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(EventDescribeFragment.newInstance());
        fragments.add(MultimediaFragment.newInstance());
        TabPageAdapter adapter = new TabPageAdapter(getChildFragmentManager(), fragments, titles);
        binding.pager.setAdapter(adapter);
        binding.tab.setupWithViewPager(binding.pager);
        for (int i = 0; i < binding.tab.getTabCount(); i++) {
            TabLayout.Tab tab = binding.tab.getTabAt(i);
            BGABadgeLinearLayout view = (BGABadgeLinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_tab_proboem_report, null);
            TextView tabText = (TextView) view.findViewById(R.id.tab_text);
            BGABadgeImageView tabIcon = (BGABadgeImageView) view.findViewById(R.id.tab_icon);
            tabText.setText(titles[i]);
            tabIcon.setImageResource(icones[i]);
            tab.setCustomView(view);
        }
        return binding.getRoot();
    }

    @Override
    public void fetchData() {

    }
}
