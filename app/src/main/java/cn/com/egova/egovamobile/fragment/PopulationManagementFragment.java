package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.KeyServicePopulationAdapter;
import cn.com.egova.egovamobile.adapter.PeopleCateAdapter;
import cn.com.egova.egovamobile.databinding.FragmentPopulationManagerBinding;

/**
 * 人口管理
 * Created by y11621546 on 2017/5/3.
 */

public class PopulationManagementFragment extends BasePageFragment {
    public static PopulationManagementFragment newInstance() {

        Bundle args = new Bundle();

        PopulationManagementFragment fragment = new PopulationManagementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentPopulationManagerBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_population_manager, container, false);
        binding.rvCate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvPeople.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("asdfgas");
        }
        PeopleCateAdapter adapter = new PeopleCateAdapter(list);
        binding.rvCate.setAdapter(adapter);
        KeyServicePopulationAdapter adapter1 = new KeyServicePopulationAdapter(list);
        binding.rvPeople.setAdapter(adapter1);
        return binding.getRoot();
    }

    @Override
    public void fetchData() {

    }
}
