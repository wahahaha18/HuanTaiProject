package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.PopulationDetailAdapter;
import cn.com.egova.egovamobile.databinding.FragmentPopulationDetailBinding;

/**
 * 人口管理详情页
 * Created by yq895943339 on 2017/5/5.
 */

public class PopulationDetailFragment extends BasePageFragment {
    private Bundle bundle;

    public static PopulationDetailFragment newInstance(Bundle bundle) {
        PopulationDetailFragment fragment = new PopulationDetailFragment();
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    private FragmentPopulationDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_population_detail, container, false);
        initData();

        return binding.getRoot();
    }

    private void initData() {

        initAdapter();
    }

    private void initAdapter() {
        binding.pmRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            strings.add(""+i);
        }

        PopulationDetailAdapter adapter = new PopulationDetailAdapter(strings);
        binding.pmRv.setAdapter(adapter);

    }

    @Override
    public void fetchData() {

    }
}
