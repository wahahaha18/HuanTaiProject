package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentLogQueryBinding;

/**
 * 日志查询
 * Created by y11621546 on 2017/5/4.
 */

public class JournalQueryFragment extends BasePageFragment {
    public static JournalQueryFragment newInstance() {

        Bundle args = new Bundle();

        JournalQueryFragment fragment = new JournalQueryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentLogQueryBinding binding;

    @Override
    public void fetchData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_query, container, false);
//        binding.calendarView.setTopbarColor(Color.BLUE);
//        binding.calendarView.addDecorators(
//                new HighlightWeekendsDecorator()
//                , new OneDayDecorator()
//        );
        return binding.getRoot();
    }


}
