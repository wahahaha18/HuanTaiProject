package cn.com.egova.egovamobile.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;

import java.util.ArrayList;

import cn.bingoogolapple.badgeview.BGABadgeImageView;
import cn.bingoogolapple.badgeview.BGABadgeLinearLayout;
import cn.bingoogolapple.badgeview.BGABadgeViewHelper;
import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.TabPageAdapter;
import cn.com.egova.egovamobile.fragment.LeaderMainFragment;
import cn.com.egova.egovamobile.fragment.MessageFragment;
import cn.com.egova.egovamobile.fragment.MineFragment;
import cn.com.egova.egovamobile.fragment.ServicePipeMainFragment;
import cn.com.egova.egovamobile.fragment.WorkFragment;
import cn.com.egova.egovamobile.view.ProhibitScrollViewPager;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getName();
    private String[] titles = new String[]{"首页", "消息", "工作", "我的"};
    private int[] icones = new int[]{R.drawable.tab_main_icon, R.drawable.tab_message_icon, R.drawable.tab_work_icon, R.drawable.tab_mine_icon};
    private TabLayout tableLayout;

    public void setTitle(String title) {
        binding.toolbar.setTitle(title);
        setSupportActionBar(binding.toolbar);
    }

    public void showTextBadge(int index, @NonNull String badgeText) {
        TabLayout.Tab tab = tableLayout.getTabAt(index);
        BGABadgeLinearLayout bgaBadgeLinearLayout = (BGABadgeLinearLayout) tab.getCustomView();
        bgaBadgeLinearLayout.showTextBadge(badgeText);
        bgaBadgeLinearLayout.getBadgeViewHelper().setBadgeGravity(BGABadgeViewHelper.BadgeGravity.RightTop);
        bgaBadgeLinearLayout.getBadgeViewHelper().setBadgeVerticalMarginDp(1);
    }

    public void showCirclePointBadge(int index) {
        TabLayout.Tab tab = tableLayout.getTabAt(index);
        BGABadgeLinearLayout bgaBadgeLinearLayout = (BGABadgeLinearLayout) tab.getCustomView();
        bgaBadgeLinearLayout.showCirclePointBadge();
        bgaBadgeLinearLayout.getBadgeViewHelper().setBadgeGravity(BGABadgeViewHelper.BadgeGravity.RightTop);
        bgaBadgeLinearLayout.getBadgeViewHelper().setBadgeVerticalMarginDp(1);

    }

    public void hiddenBadge(int index) {
        TabLayout.Tab tab = tableLayout.getTabAt(index);
        BGABadgeLinearLayout bgaBadgeLinearLayout = (BGABadgeLinearLayout) tab.getCustomView();
        bgaBadgeLinearLayout.hiddenBadge();

    }


    @Override
    protected void init(Toolbar toolbar, ProhibitScrollViewPager viewPager, TabLayout tabLayout) {
        this.tableLayout = tabLayout;
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SPUtils(getString(R.string.sp_name)).getBoolean("role") ? LeaderMainFragment.newInstance() : ServicePipeMainFragment.newInstance());
//        fragments.add(ServicePipeMainFragment.newInstance());
        fragments.add(MessageFragment.newInstance());
        fragments.add(WorkFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        TabPageAdapter adapter = new TabPageAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            BGABadgeLinearLayout view = (BGABadgeLinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_tab, null);
            TextView tabText = (TextView) view.findViewById(R.id.tab_text);
            BGABadgeImageView tabIcon = (BGABadgeImageView) view.findViewById(R.id.tab_icon);
            tabText.setText(titles[i]);
            tabIcon.setImageResource(icones[i]);
            tab.setCustomView(view);
        }
    }
}
