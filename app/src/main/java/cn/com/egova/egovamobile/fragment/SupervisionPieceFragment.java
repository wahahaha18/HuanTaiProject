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
import cn.com.egova.egovamobile.databinding.FragmentSupervisionPieceBinding;
import cn.com.egova.egovamobile.model.HurryPiece;
import cn.com.egova.egovamobile.model.HurryPiece1;
import cn.com.egova.egovamobile.view.SimpleDividerItemDecoration;

/**
 * 督办件
 * Created by y11621546 on 2017/5/3.
 */

public class SupervisionPieceFragment extends BasePageFragment {
    private List<HurryPiece> hurryPieces;
    private List<HurryPiece1> hurryPiece1s;

    public static SupervisionPieceFragment newInstance() {

        Bundle args = new Bundle();

        SupervisionPieceFragment fragment = new SupervisionPieceFragment();
        fragment.setArguments(args);
        return fragment;

    }

    private FragmentSupervisionPieceBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_supervision_piece, container, false);
        initData();

        return binding.getRoot();
    }
    private void initData() {

        initSpinner();
//        initAdapter();
    }

    private void initAdapter() {
        binding.spRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.spRv.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        hurryPieces = new ArrayList<>();
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "交通标志牌", "超时435天2小时22分钟"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容环境问题", "超时235天3小时22分钟"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "道路垃圾", "超时335天2小时52分钟"));

        hurryPiece1s = new ArrayList<>();
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "超时435天2小时22分钟","1002224554","承办阶段（问题处理）","执法大队"));
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "超时435天2小时22分钟","1002224554","承办阶段（问题处理）","执法大队"));
        hurryPiece1s.add(new HurryPiece1("市容环境", "其他市容问题环境问题1", "超时435天2小时22分钟","1002224554","承办阶段（问题处理）","执法大队"));

        ArrayList<MultiItemEntity> multiItemEntities = generateData();
        ExpandableItemAdapter adapter = new ExpandableItemAdapter(multiItemEntities,1);
//        HurryPieceAdapter adapter = new HurryPieceAdapter(hurryPieces);
        binding.spRv.setAdapter(adapter);
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
        binding.spSpinner1.setAdapter(adapter);
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
        binding.spSpinner2.setAdapter(adapter1);

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
        binding.spSpinner3.setAdapter(adapter2);

    }


    @Override
    public void fetchData() {

    }
}
