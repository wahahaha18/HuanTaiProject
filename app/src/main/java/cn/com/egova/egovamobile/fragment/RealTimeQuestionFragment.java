package cn.com.egova.egovamobile.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.List;

import cn.com.egova.egovamobile.R;
import cn.com.egova.egovamobile.databinding.FragmentRealtimeQuestionBinding;
import cn.com.egova.egovamobile.model.HurryPiece;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * 实时问题
 * Created by y11621546 on 2017/5/3.
 */

public class RealTimeQuestionFragment extends BasePageFragment {
    public static RealTimeQuestionFragment newInstance() {

        Bundle args = new Bundle();

        RealTimeQuestionFragment fragment = new RealTimeQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentRealtimeQuestionBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_realtime_question, container, false);
        initData();
        initChartData();
        return binding.getRoot();
    }

    private void initChartData() {
        List<String> list = new ArrayList<>();
        list.add("asdfga");
        list.add("asdfga");
        list.add("asdfga");
        list.add("asdfga");
        binding.chartBanner.setPages(new CBViewHolderCreator<ChartHolderView>() {
            @Override
            public ChartHolderView createHolder() {
                return new ChartHolderView();
            }
        }, list)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.icon_un_select1, R.mipmap.icon_select2})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);


    }

    private void initData() {
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        List<HurryPiece> hurryPieces = new ArrayList<>();
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题", "2017.04.16 18:19:23"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题1", "2017.04.16 18:19:23"));
        hurryPieces.add(new HurryPiece(R.mipmap.hp_file_img, "其他市容问题环境问题2", "2017.04.16 18:19:23"));
        binding.convenientBanner.setPages(
                new CBViewHolderCreator<LocalBanner1HolderView>() {
                    @Override
                    public LocalBanner1HolderView createHolder() {
                        return new LocalBanner1HolderView();
                    }
                }, hurryPieces)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.icon_un_select1, R.mipmap.icon_select2})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    private class LocalBanner1HolderView implements Holder<HurryPiece> {
        //        private ImageView imageView;
        @Override
        public View createView(Context context) {
            View viewBanner1 = LayoutInflater.from(context).inflate(R.layout.layout_real_time_item, null);

            return viewBanner1;
        }

        @Override
        public void UpdateUI(Context context, int position, HurryPiece data) {

//            Toast.makeText(context, ""+position+":"+data.getReply(), Toast.LENGTH_SHORT).show();
        }


    }

    private class ChartHolderView implements Holder<String> {
        LineChartView mChartView;
        List<PointValue> values;
        List<Line> lines;

        @Override
        public View createView(Context context) {
            View cartView = LayoutInflater.from(context).inflate(R.layout.layout_item_real_time_chart, null);
            mChartView = (LineChartView) cartView.findViewById(R.id.chart);

            return cartView;
        }

        @Override
        public void UpdateUI(Context context, int position, String s) {
            values = new ArrayList<PointValue>();//折线上的点
            values.add(new PointValue(0, 2));
            values.add(new PointValue(1, 4));
            values.add(new PointValue(2, 3));
            values.add(new PointValue(3, 5));
            Line line = new Line(values).setColor(Color.WHITE).setPointColor(Color.YELLOW);//声明线并设置颜色
            line.setCubic(true);//设置是平滑的还是直的
            line.setShape(ValueShape.CIRCLE);
            lines = new ArrayList<Line>();
            lines.add(line);
            mChartView.setInteractive(true);//设置图表是可以交互的（拖拽，缩放等效果的前提）
            mChartView.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);//设置缩放方向
            LineChartData data = new LineChartData();
            Axis axisX = new Axis();//x轴
            Axis axisY = new Axis();//y轴
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
            data.setLines(lines);
            mChartView.setLineChartData(data);//给图表设置数据

        }


    }

    @Override
    public void fetchData() {

    }
}
