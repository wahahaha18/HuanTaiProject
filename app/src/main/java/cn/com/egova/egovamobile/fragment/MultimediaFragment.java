package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentPrMultimediaBinding;

/**
 * Created by yq895943339 on 2017/5/4.
 */

public class MultimediaFragment extends BasePageFragment {
    public static MultimediaFragment newInstance() {

        Bundle args = new Bundle();

        MultimediaFragment fragment = new MultimediaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentPrMultimediaBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pr_multimedia, container, false);

        return binding.getRoot();
    }


    @Override
    public void fetchData() {

    }
}
