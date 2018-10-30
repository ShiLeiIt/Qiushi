package com.samrt.qiushi.icecream.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

/**
 * Created by shilei on 2018/10/30
 * 通过取货码点击制作
 */
public class CodeClickMakingFragment extends Fragment implements View.OnClickListener {

    private View mCodeClickView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        mCodeClickView = inflater.inflate(R.layout.fragment_code_click_making, container, false);
        initView();
        return mCodeClickView;
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        TextView tvFetchCode = (TextView) mCodeClickView.findViewById(R.id.layout_one).findViewById(R.id.tv_select);//输入取货码
        tvFetchCode.setText(R.string.input_fetch_code);
        tvFetchCode.setTextColor(getResources().getColor(R.color.white));

        TextView tvClickMaking = (TextView) mCodeClickView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//点击制作
        tvClickMaking.setText(R.string.click_on_the_create);
        tvClickMaking.setTextColor(getResources().getColor(R.color.white));

        TextView tvStartMaking = (TextView) mCodeClickView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);




        TextView tvPlease = (TextView) mCodeClickView.findViewById(R.id.tv_please_do_not_go_away);
        tvPlease.setText(getResources().getString(R.string.please_do_not_go_away) + "\n" +
                getResources().getString(R.string.take_you_selected_tap) + "\n" +
                getResources().getString(R.string.aligning_outlet) + "\n" +
                getResources().getString(R.string.slowly_rotating)
        );
        TextView tvConfirm = (TextView) mCodeClickView.findViewById(R.id.tv_confirm);

        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.tv_confirm:
                activity.showFragment(11);
                break;
        }
    }
}
