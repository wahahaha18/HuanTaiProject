package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentEventDescribeBinding;

/**
 * 事件描述
 * Created by y11621546 on 2017/5/3.
 */

public class EventDescribeFragment extends BasePageFragment {
    public static EventDescribeFragment newInstance() {

        Bundle args = new Bundle();

        EventDescribeFragment fragment = new EventDescribeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentEventDescribeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_describe, container, false);
        initSpinner();
        return binding.getRoot();
    }

    private void initSpinner() {
        final List<String> strings = new ArrayList<>();
        strings.add("综合治理1");
        strings.add("综合治理2");
        strings.add("综合治理3");
        strings.add("综合治理4");
        strings.add("综合治理5");
        strings.add("综合治理6");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.layout_pr_spinner_text_show, strings) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pr_spinner_text_down, null);
                TextView label = (TextView) view
                        .findViewById(R.id.tv_sp_line);

                View v_sp_line = view.findViewById(R.id.v_sp_line);
                if (position == strings.size() - 1) {
                    v_sp_line.setVisibility(View.GONE);
                }
                label.setText(strings.get(position));

                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.layout_pr_spinner_text_down);
        binding.spProblemType.setAdapter(adapter);
        final List<String> strings1 = new ArrayList<>();
        strings1.add("综合治理1");
        strings1.add("综合治理2");
        strings1.add("综合治理3");
        strings1.add("综合治理4");
        strings1.add("综合治理5");
        strings1.add("综合治理6");


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), R.layout.layout_pr_spinner_text_show, strings1) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pr_spinner_text_down, null);
                TextView label = (TextView) view
                        .findViewById(R.id.tv_sp_line);

                View v_sp_line = view.findViewById(R.id.v_sp_line);
                if (position == strings1.size() - 1) {
                    v_sp_line.setVisibility(View.GONE);
                }
                label.setText(strings1.get(position));

                return view;
            }
        };
        adapter1.setDropDownViewResource(R.layout.layout_pr_spinner_text_down);
        binding.spBigType.setAdapter(adapter1);

        final List<String> strings2 = new ArrayList<>();
        strings2.add("垃圾乱扔");
        strings2.add("垃圾乱扔1");
        strings2.add("垃圾乱扔2");
        strings2.add("综合治理4");
        strings2.add("综合治理5");
        strings2.add("综合治理6");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), R.layout.layout_pr_spinner_text_show, strings2) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pr_spinner_text_down, null);
                TextView label = (TextView) view
                        .findViewById(R.id.tv_sp_line);

                View v_sp_line = view.findViewById(R.id.v_sp_line);
                if (position == strings2.size() - 1) {
                    v_sp_line.setVisibility(View.GONE);
                }
                label.setText(strings2.get(position));

                return view;
            }
        };
        adapter2.setDropDownViewResource(R.layout.layout_pr_spinner_text_down);
        binding.spSmallType.setAdapter(adapter2);

        final List<String> strings3 = new ArrayList<>();
        strings3.add("一般");
        strings3.add("一般1");
        strings3.add("一般2");
        strings3.add("综合治理4");
        strings3.add("综合治理5");
        strings3.add("综合治理6");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(), R.layout.layout_pr_spinner_text_show, strings3) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pr_spinner_text_down, null);
                TextView label = (TextView) view
                        .findViewById(R.id.tv_sp_line);

                View v_sp_line = view.findViewById(R.id.v_sp_line);
                if (position == strings3.size() - 1) {
                    v_sp_line.setVisibility(View.GONE);
                }
                label.setText(strings3.get(position));

                return view;
            }
        };
        adapter3.setDropDownViewResource(R.layout.layout_pr_spinner_text_down);
        binding.spProblemLevel.setAdapter(adapter3);

        final List<String> strings4 = new ArrayList<>();
        strings4.add("选择人");
        strings4.add("选择人1");
        strings4.add("选择人2");
        strings4.add("综合治理4");
        strings4.add("综合治理5");
        strings4.add("综合治理6");
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getContext(), R.layout.layout_pr_spinner_text_show, strings4) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pr_spinner_text_down, null);
                TextView label = (TextView) view
                        .findViewById(R.id.tv_sp_line);

                View v_sp_line = view.findViewById(R.id.v_sp_line);
                if (position == strings4.size() - 1) {
                    v_sp_line.setVisibility(View.GONE);
                }
                label.setText(strings4.get(position));

                return view;
            }
        };
        adapter4.setDropDownViewResource(R.layout.layout_pr_spinner_text_down);
        binding.spPartyMan.setAdapter(adapter4);

    }

    @Override
    public void fetchData() {

    }
}
