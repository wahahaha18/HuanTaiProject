package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragementMineBinding;

/**
 * 我的
 * <p>
 * Created by y11621546 on 2017/5/3.
 */

public class MineFragment extends BasePageFragment {


    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragementMineBinding binding;

    @Override
    public boolean prepareFetchData(boolean forceUpdate) {
        return super.prepareFetchData(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragement_mine, container, false);

        binding.btnWitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spUtils.put("role", !spUtils.getBoolean("role"));
            }
        });
        return binding.getRoot();
    }

    @Override
    public void fetchData() {
        setTitle("我的");
    }
}
