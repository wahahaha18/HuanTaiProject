package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentEvaluationBinding;

/**
 * 评价考核
 * Created by y11621546 on 2017/5/3.
 */

public class EvaluationFragment extends BasePageFragment {
    public static EvaluationFragment newInstance() {

        Bundle args = new Bundle();

        EvaluationFragment fragment = new EvaluationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentEvaluationBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_evaluation, container, false);
//        initData();

        return binding.getRoot();
    }

    @Override
    public void fetchData() {

    }
}
