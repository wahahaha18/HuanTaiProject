package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentTaskDetailBinding;

/**
 * 我的任务的详情页
 * Created by yq895943339 on 2017/5/5.
 */

public class TaskDetailFragment extends BasePageFragment {
    private Bundle bundle;

    public static TaskDetailFragment newInstance(Bundle bundle) {
        TaskDetailFragment fragment = new TaskDetailFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    private FragmentTaskDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_detail, container, false);
        initData();

        return binding.getRoot();
    }

    private void initData() {
        binding.tvTd1Value.setText(" : "+"1700001232");
        binding.tvTd2Value.setText(" : "+"街面秩序");
        binding.tvTd3Value.setText(" : "+"占道经营");
        binding.tvTd4Value.setText(" : "+"占道冲洗机动车");
        binding.tvTd5Value.setText(" : "+"测试321测试321");
        binding.tvTd6Value.setText(" : "+"无");
        binding.tvTd7Value.setText(" : "+"双环电器（正西）");
        binding.tvTd8Value.setText(" : "+"2017.04.16 12:46:59");
//        initAdapter();
    }

    @Override
    public void fetchData() {

    }
}
