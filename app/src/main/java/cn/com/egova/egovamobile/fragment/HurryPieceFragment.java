package cn.com.egova.egovamobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.adapter.ExpandableItemAdapter;
import cn.com.egova.egovamobile.databinding.FragmentHurryPieceBinding;
import cn.com.egova.egovamobile.model.HurryPiece;
import cn.com.egova.egovamobile.model.HurryPiece1;
import cn.com.egova.egovamobile.view.SimpleDividerItemDecoration;

/**
 * 急要件
 * Created by y11621546 on 2017/5/3.
 */

public class HurryPieceFragment extends BasePageFragment {

    private List<HurryPiece> hurryPieces;
    private List<HurryPiece1> hurryPiece1s;

    public static HurryPieceFragment newInstance() {

        Bundle args = new Bundle();

        HurryPieceFragment fragment = new HurryPieceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentHurryPieceBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hurry_piece, container, false);
        initData();

        return binding.getRoot();
    }

    private void initData() {

        initSpinner();
//        initAdapter();
    }

    private void initAdapter() {
        binding.hpRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.hpRv.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
//        binding.hpRv.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL, R.drawable.color_pr_line));
        hurryPieces = new ArrayList<>();
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题", "2017.04.16 18:19:23"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题1", "2017.04.16 18:19:23"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题2", "2017.04.16 18:19:23"));

        hurryPiece1s = new ArrayList<>();
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "2017.04.16 18:19:23","1002224554","承办阶段（问题处理）","执法大队"));
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "2017.04.16 18:19:23","1002224554","承办阶段（问题处理）","执法大队"));
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "2017.04.16 18:19:23","1002224554","承办阶段（问题处理）","执法大队"));

        ArrayList<MultiItemEntity> multiItemEntities = generateData();
        ExpandableItemAdapter adapter = new ExpandableItemAdapter(multiItemEntities,0);
//        HurryPieceAdapter adapter = new HurryPieceAdapter(hurryPieces);
        binding.hpRv.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        initAdapter();
    }

    private ArrayList<MultiItemEntity> generateData() {
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < hurryPieces.size(); i++) {
            for (int j = 0; j < 1; j++) {

                hurryPieces.get(i).addSubItem(hurryPiece1s.get(i));
            }
            res.add(hurryPieces.get(i));
        }
        return res;
    }

    private void initSpinner() {
        final List<String> strings = new ArrayList<>();
        strings.add("筛选范围");
        strings.add("筛选范围2");
        strings.add("筛选范围3");
        strings.add("筛选范围4");
        strings.add("筛选范围5");
        strings.add("筛选范围6");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.layout_hp_spinner_show, strings) {
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
        binding.hpSpinner1.setAdapter(adapter);
        final List<String> strings1 = new ArrayList<>();
        strings1.add("分类范围1");
        strings1.add("分类范围2");
        strings1.add("分类范围3");
        strings1.add("分类范围");
        strings1.add("分类范围5");
        strings1.add("分类范围6");


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), R.layout.layout_hp_spinner_show, strings1) {
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
        binding.hpSpinner2.setAdapter(adapter1);

        final List<String> strings2 = new ArrayList<>();
        strings2.add("选择排序");
        strings2.add("选择排序1");
        strings2.add("选择排序2");
        strings2.add("选择排序4");
        strings2.add("选择排序5");
        strings2.add("选择排序6");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), R.layout.layout_hp_spinner_show, strings2) {
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
        binding.hpSpinner3.setAdapter(adapter2);

    }

    @Override
    public void fetchData() {

    }
}
