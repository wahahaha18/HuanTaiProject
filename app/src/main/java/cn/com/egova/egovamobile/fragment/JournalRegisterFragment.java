package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentJournalQueryBinding;
import cn.com.egova.egovamobile.databinding.FragmentLogQueryBinding;

/**
 * 日志查询
 * Created by y11621546 on 2017/5/4.
 */

public class JournalRegisterFragment extends BasePageFragment {
    public static JournalRegisterFragment newInstance() {

        Bundle args = new Bundle();

        JournalRegisterFragment fragment = new JournalRegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentJournalQueryBinding binding;

    @Override
    public void fetchData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_journal_query, container, false);

        return binding.getRoot();
    }


}
