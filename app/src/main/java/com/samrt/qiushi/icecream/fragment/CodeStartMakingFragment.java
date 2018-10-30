package com.samrt.qiushi.icecream.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samrt.qiushi.icecream.R;

/**
 * Created by shilei on 2018/10/30
 */
public class CodeStartMakingFragment extends Fragment {
    private View mCodeStartMakingView;
    private ImageView mIvGif;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mCodeStartMakingView = inflater.inflate(R.layout.fragment_code_start_making, container, false);
        initView();
        return mCodeStartMakingView;
    }

    private void initView() {
        TextView tvFetchCode = (TextView) mCodeStartMakingView.findViewById(R.id.layout_one).findViewById(R.id.tv_select);//输入取货码
        tvFetchCode.setText(R.string.input_fetch_code);
        tvFetchCode.setTextColor(getResources().getColor(R.color.white));

        TextView tvClickMaking = (TextView) mCodeStartMakingView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//点击制作
        tvClickMaking.setText(R.string.click_on_the_create);
        tvClickMaking.setTextColor(getResources().getColor(R.color.white));

        TextView tvStartMaking = (TextView) mCodeStartMakingView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        tvStartMaking.setTextColor(getResources().getColor(R.color.white));


        mIvGif = (ImageView) mCodeStartMakingView.findViewById(R.id.iv_start_making);
        String url = "https://s1.ax1x.com/2018/10/17/idRhIU.gif";
        Glide.with(getActivity()).load(url).asGif().centerCrop().into(mIvGif);
    }

}
