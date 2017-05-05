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
import cn.com.egova.egovamobile.adapter.TaskAdapter;
import cn.com.egova.egovamobile.databinding.FragmentTaskUnFinishedBinding;

/**
 * 未完成任务
 * Created by y11621546 on 2017/5/3.
 */

public class UnFinishedTaskFragment extends BasePageFragment {
    public static UnFinishedTaskFragment newInstance() {

        Bundle args = new Bundle();

        UnFinishedTaskFragment fragment = new UnFinishedTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentTaskUnFinishedBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_un_finished, container, false);
        binding.rvTask.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("asdfasfd");
        }
        TaskAdapter adapter = new TaskAdapter(list);
        binding.rvTask.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("type","tf");
                NextActivity.start(getContext(),bundle);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void fetchData() {

    }
}
