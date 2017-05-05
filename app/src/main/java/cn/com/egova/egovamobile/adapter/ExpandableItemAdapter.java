package cn.com.egova.egovamobile.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.model.HurryPiece;
import cn.com.egova.egovamobile.model.HurryPiece1;

/**
 * Created by yq895943339 on 2017/5/5.
 */

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    private int type;

    public ExpandableItemAdapter(List<MultiItemEntity> data, int typeTest) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.layout_hp_item);
        addItemType(TYPE_LEVEL_1, R.layout.layout_hp_item1);
        type = typeTest;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                //set view content
                final HurryPiece hurryPiece = (HurryPiece) item;
                holder.setImageResource(R.id.iv_hp_item_reply, hurryPiece.getReply());
                holder.setText(R.id.tv_hp_item_question_type, hurryPiece.getQuestion_type());
                holder.setText(R.id.tv_hp_item_report_time, hurryPiece.getReport_time());
                Log.e(TAG, "convert: " + hurryPiece.getQuestion_type());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (hurryPiece.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                // similar with level 0
                HurryPiece1 hurryPiece1 = (HurryPiece1) item;
                if (type == 0) {
                    holder.setText(R.id.tv_report_time, R.string.s_hp_report_time);
                }else {
                    holder.setText(R.id.tv_report_time, R.string.s_sp_overtime);
                }
                holder.setText(R.id.tv_problem_big_type_value, " ：" + hurryPiece1.getProblem_big_type());
                holder.setText(R.id.tv_problem_small_type_value, " ：" + hurryPiece1.getProblem_small_type());
                holder.setText(R.id.tv_task_number_value, " ：" + hurryPiece1.getTask_number());
                holder.setText(R.id.tv_handle_stage_value, " ：" + hurryPiece1.getHandle_stage());
                holder.setText(R.id.tv_handle_man_value, " ：" + hurryPiece1.getHandle_man());
                holder.setText(R.id.tv_report_time_value, " ：" + hurryPiece1.getReport_time());
                break;

        }
    }
}
