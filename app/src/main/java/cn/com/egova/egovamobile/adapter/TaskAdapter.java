package cn.com.egova.egovamobile.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.egova.egovamobile.R;

/**
 * 任务adapter
 * Created by y11621546 on 2017/5/4.
 */

public class TaskAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TaskAdapter(@Nullable List<String> data) {
        super(R.layout.item_task, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_task_index, String.valueOf(helper.getLayoutPosition() + 1));
    }
}
