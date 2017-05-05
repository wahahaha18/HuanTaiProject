package cn.com.egova.egovamobile.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.egova.egovamobile.R;

/**
 * Created by yq895943339 on 2017/5/5.
 */

public class PopulationDetailAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PopulationDetailAdapter(@Nullable List<String> data) {
        super(R.layout.item_pm_detail,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_pm_index,item);
    }
}
