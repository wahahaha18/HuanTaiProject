package cn.com.egova.egovamobile.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import cn.com.egova.egovamobile.adapter.ExpandableItemAdapter;

/**
 * Created by yq895943339 on 2017/5/4.
 */

public class HurryPiece1 implements MultiItemEntity{
    private String problem_big_type;
    private String problem_small_type;
    private String report_time;
    private String task_number;
    private String handle_stage;
    private String handle_man;

    public HurryPiece1() {
    }

    public HurryPiece1(String problem_big_type, String problem_small_type, String report_time, String task_number, String handle_stage, String handle_man) {
        this.problem_big_type = problem_big_type;
        this.problem_small_type = problem_small_type;
        this.report_time = report_time;
        this.task_number = task_number;
        this.handle_stage = handle_stage;
        this.handle_man = handle_man;
    }

    public String getProblem_big_type() {
        return problem_big_type;
    }

    public void setProblem_big_type(String problem_big_type) {
        this.problem_big_type = problem_big_type;
    }

    public String getProblem_small_type() {
        return problem_small_type;
    }

    public void setProblem_small_type(String problem_small_type) {
        this.problem_small_type = problem_small_type;
    }

    public String getReport_time() {
        return report_time;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
    }

    public String getTask_number() {
        return task_number;
    }

    public void setTask_number(String task_number) {
        this.task_number = task_number;
    }

    public String getHandle_stage() {
        return handle_stage;
    }

    public void setHandle_stage(String handle_stage) {
        this.handle_stage = handle_stage;
    }

    public String getHandle_man() {
        return handle_man;
    }

    public void setHandle_man(String handle_man) {
        this.handle_man = handle_man;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

//    @Override
//    public int getLevel() {
//        return 1;
//    }
//
//    @Override
//    public int getItemType() {
//        return ExpandableItemAdapter.TYPE_LEVEL_1;
//    }
}
