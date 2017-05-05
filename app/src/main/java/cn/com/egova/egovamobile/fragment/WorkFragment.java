package cn.com.egova.egovamobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by y11621546 on 2017/5/3.
 */

public class WorkFragment extends BasePageFragment {
    public static WorkFragment newInstance() {

        Bundle args = new Bundle();

        WorkFragment fragment = new WorkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean prepareFetchData(boolean forceUpdate) {
        return super.prepareFetchData(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("cccccc");
        return textView;
    }

    @Override
    public void fetchData() {
        setTitle("工作");
    }
}
