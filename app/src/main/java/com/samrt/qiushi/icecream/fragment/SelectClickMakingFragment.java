package com.samrt.qiushi.icecream.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

/**
 * Created by shilei on 2018/10/17
 * 点击制作
 */

public class SelectClickMakingFragment extends Fragment implements View.OnClickListener {

    private View mMakingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMakingView = inflater.inflate(R.layout.fragment_click_making, container, false);
        initView();
        return mMakingView;

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        TextView tvNum = (TextView) mMakingView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//选择数量
        tvNum.setText(R.string.choose_number);
        tvNum.setTextColor(getResources().getColor(R.color.white));
        TextView tvPay = (TextView) mMakingView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//付款
        tvPay.setText(R.string.payment);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tvPay.getLayoutParams();
        lp.setMargins(20, 0, 0, 0);
        tvPay.setLayoutParams(lp);

        TextView tvMaking = (TextView) mMakingView.findViewById(R.id.layout_four).findViewById(R.id.tv_select);//点击制作
        tvMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mMakingView.findViewById(R.id.layout_five).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        TextView tvMakingFinsh = (TextView) mMakingView.findViewById(R.id.layout_six).findViewById(R.id.tv_select);//制作完成
        tvMakingFinsh.setText(R.string.making_finish);


        TextView tvPlease = (TextView) mMakingView.findViewById(R.id.tv_please_do_not_go_away);
        tvPlease.setText(getResources().getString(R.string.please_do_not_go_away) + "\n" +
                getResources().getString(R.string.take_you_selected_tap) + "\n" +
                getResources().getString(R.string.aligning_outlet) + "\n" +
                getResources().getString(R.string.slowly_rotating)
        );
        TextView tvConfirm = (TextView) mMakingView.findViewById(R.id.tv_confirm);

        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.tv_confirm:
                activity.showFragment(6);
                break;
        }
    }
}
