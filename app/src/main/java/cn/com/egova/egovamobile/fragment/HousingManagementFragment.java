package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.activity.NextActivity;
import cn.com.egova.egovamobile.adapter.PeopleCateAdapter;
import cn.com.egova.egovamobile.databinding.FragmentHousingManagerBinding;

/**
 * 房屋管理
 * Created by y11621546 on 2017/5/3.
 */

public class HousingManagementFragment extends BasePageFragment {
    public static HousingManagementFragment newInstance() {

        Bundle args = new Bundle();

        HousingManagementFragment fragment = new HousingManagementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentHousingManagerBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_housing_manager, container, false);
        binding.rvCate.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("asdfgas");
        }
        PeopleCateAdapter adapter = new PeopleCateAdapter(list);
        binding.rvCate.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("type","hm");
                NextActivity.start(getContext(),bundle);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void fetchData() {

    }
}
