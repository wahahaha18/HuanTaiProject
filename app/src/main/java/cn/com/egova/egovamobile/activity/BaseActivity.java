package cn.com.egova.egovamobile.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.ActivityBaseBinding;
import cn.com.egova.egovamobile.view.ProhibitScrollViewPager;

/**
 * 封装Activity
 * Created by y11621546 on 2017/5/3.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void init(Toolbar toolbar, ProhibitScrollViewPager viewPager, TabLayout tabLayout);


    ActivityBaseBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.
                setContentView(this, R.layout.activity_base);
        init(binding.toolbar, binding.pager, binding.slidingTabs);


    }


    public ActivityBaseBinding getBinding() {
        return binding;
    }


}
