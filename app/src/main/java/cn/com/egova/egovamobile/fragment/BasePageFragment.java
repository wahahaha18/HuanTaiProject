package cn.com.egova.egovamobile.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;

import cn.bingoogolapple.badgeview.BGABadgeLinearLayout;
import cn.bingoogolapple.badgeview.BGABadgeViewHelper;
import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.activity.BaseActivity;
import cn.com.egova.egovamobile.activity.MainActivity;
import cn.com.egova.egovamobile.activity.NextActivity;


/**
 * viewpager+fragment LazyLoad
 * Created by y11621546 on 2017/1/19.
 */

public abstract class BasePageFragment extends Fragment {
     SPUtils spUtils;
    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spUtils = new SPUtils(getString(R.string.sp_name));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public abstract void fetchData();

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    /**
     * 设置 toolbar title
     *
     * @param title
     */
    public void setTitle(String title) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getBinding().title.setText(title);
        } else if (getActivity() instanceof NextActivity) {
//            ((NextActivity) getActivity()).getBinding().toolbar.setTitle(title);
        }

    }

    /**
     * 显示徽章
     *
     * @param index
     * @param badgeText
     */
    public void showTextBadge(int index, @NonNull String badgeText) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showTextBadge(index, badgeText);
        } else if (getActivity() instanceof NextActivity) {

        }

    }

    /**
     * 显示红点徽章
     *
     * @param index
     */
    public void showCirclePointBadge(int index) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showCirclePointBadge(index);
        } else if (getActivity() instanceof NextActivity) {

        }
    }

    /**
     * 隐藏徽章
     *
     * @param index
     */
    public void hiddenBadge(int index) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).hiddenBadge(index);
        } else if (getActivity() instanceof NextActivity) {

        }
    }

}
