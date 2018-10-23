package com.samrt.qiushi.icecream.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.samrt.qiushi.icecream.R;

/**
 * Created by shilei on 2018/10/17
 * 开始制作
 */

public class SelectStartMakingFragment extends Fragment {

    private View mStartMakingView;
    private ImageView mIvGif;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mStartMakingView = inflater.inflate(R.layout.fragment_start_making, container, false);
        initView();
        return mStartMakingView;

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        TextView tvNum = (TextView) mStartMakingView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//选择数量
        tvNum.setText(R.string.choose_number);
        tvNum.setTextColor(getResources().getColor(R.color.white));
        TextView tvPay = (TextView) mStartMakingView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//付款
        tvPay.setText(R.string.payment);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tvPay.getLayoutParams();
        lp.setMargins(20, 0, 0, 0);
        tvPay.setLayoutParams(lp);

        TextView tvMaking = (TextView) mStartMakingView.findViewById(R.id.layout_four).findViewById(R.id.tv_select);//点击制作
        tvMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mStartMakingView.findViewById(R.id.layout_five).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        TextView tvMakingFinsh = (TextView) mStartMakingView.findViewById(R.id.layout_six).findViewById(R.id.tv_select);//制作完成
        tvMakingFinsh.setText(R.string.making_finish);

        mIvGif = (ImageView) mStartMakingView.findViewById(R.id.iv_start_making);
        String url = "https://s1.ax1x.com/2018/10/17/idRhIU.gif";
        Glide.with(getActivity()).load(url).asGif().centerCrop().into(mIvGif);


    }


}
