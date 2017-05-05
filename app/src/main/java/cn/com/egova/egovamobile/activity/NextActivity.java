package cn.com.egova.egovamobile.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.ActivityNextBinding;
import cn.com.egova.egovamobile.fragment.PopulationDetailFragment;
import cn.com.egova.egovamobile.fragment.TaskDetailFragment;

public class NextActivity extends AppCompatActivity {
    private static final String TAG = NextActivity.class.getName();
    private static final String BUNDLE = "bundle";
    private static final String TITLE = "title";
    private Bundle bundle;
    private Fragment fragment;

    public static void start(Context context, Bundle bundle) {
        Intent starter = new Intent(context, NextActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        starter.putExtra(BUNDLE, bundle);
        context.startActivity(starter);
    }

    ActivityNextBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getIntent().getBundleExtra(BUNDLE);
        if (bundle == null) return;

        binding = DataBindingUtil.
                setContentView(this, R.layout.activity_next);
        binding.toolbar.setTitle("详情");

        setSupportActionBar(binding.toolbar);

        binding.toolbar.setNavigationIcon(R.mipmap.arrow_left);
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getFragments().size() < 2) {
                    finish();
                } else {
                    onBackPressed();
                }
            }
        });
        initdata();
    }

    private void initdata() {
        switch (bundle.getString("type", "")) {
            case "tf"://我的任务详情页
                fragment = TaskDetailFragment.newInstance(bundle);
                break;
            case "hm"://房屋管理详情页
                fragment = PopulationDetailFragment.newInstance(bundle);
                break;
        }
        if (fragment == null) return;
        addFragment(fragment, false);
    }

    //添加fragment
    public void addFragment(Fragment fragment, boolean isAddToBackStack) {
        if (fragment == null) return;
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_next, fragment).commit();
    }
}

