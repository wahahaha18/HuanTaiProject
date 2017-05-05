package cn.com.egova.egovamobile.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import cn.com.egova.egovamobile.adapter.ExpandableItemAdapter;

/**
 * Created by yq895943339 on 2017/5/4.
 */

public class HurryPiece extends AbstractExpandableItem<HurryPiece1> implements MultiItemEntity{
    private int reply;
    private String question_type;
    private String report_time;

    public HurryPiece(int reply, String question_type, String report_time) {
        this.reply = reply;
        this.question_type = question_type;
        this.report_time = report_time;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getReport_time() {
        return report_time;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }
}
