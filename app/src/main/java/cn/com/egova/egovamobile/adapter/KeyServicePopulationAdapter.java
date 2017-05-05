package cn.com.egova.egovamobile.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.egova.egovamobile.R;

/**
 * Created by y11621546 on 2017/5/5.
 */

public class KeyServicePopulationAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public KeyServicePopulationAdapter(@Nullable List<String> data) {
        super(R.layout.item_cate, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getLayoutPosition() == 0) {
            // TODO: 2017/5/5 动态设置左边距
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SizeUtils.dp2px(70), ViewGroup.LayoutParams.MATCH_PARENT);
            params.setMargins(SizeUtils.dp2px(10), SizeUtils.dp2px(10), SizeUtils.dp2px(10), SizeUtils.dp2px(10));
            helper.getView(R.id.item).setLayoutParams(params);
        }
    }
}
