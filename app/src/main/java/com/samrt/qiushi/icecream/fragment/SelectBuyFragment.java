package com.samrt.qiushi.icecream.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shilei on 2018/10/12
 * 购买产品页面
 */

public class SelectBuyFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.tv_select_like)
    TextView mTvSelectLike;
    @Bind(R.id.iv_fifteen)
    ImageView mIvFifteen;
    @Bind(R.id.iv_eighteen)
    ImageView mIvEighteen;
    @Bind(R.id.iv_twenty)
    ImageView mIvTwenty;
    private View mSelectBuyView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //引用创建好的xml布局
        mSelectBuyView = inflater.inflate(R.layout.fragment_select_buy, container, false);
        ButterKnife.bind(this, mSelectBuyView);
        init();
        return mSelectBuyView;
    }

    private void init() {
        Drawable cow = getResources().getDrawable(R.drawable.cow);//账号
        cow.setBounds(0, 0, 100, 120);
        mTvSelectLike.setCompoundDrawables(null, null, cow, null);
        TextView tvNum = (TextView) mSelectBuyView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//选择数量
        tvNum.setText(R.string.choose_number);
        TextView tvPay = (TextView) mSelectBuyView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//付款
        tvPay.setText(R.string.payment);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tvPay.getLayoutParams();
        lp.setMargins(10, 0, 0, 0);
        tvPay.setLayoutParams(lp);

        TextView tvMaking = (TextView) mSelectBuyView.findViewById(R.id.layout_four).findViewById(R.id.tv_select);//点击制作
        tvMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mSelectBuyView.findViewById(R.id.layout_five).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        TextView tvMakingFinsh = (TextView) mSelectBuyView.findViewById(R.id.layout_six).findViewById(R.id.tv_select);//制作完成
        tvMakingFinsh.setText(R.string.making_finish);

        //点击取货码
        ImageView ivInputFetchCode = (ImageView) mSelectBuyView.findViewById(R.id.iv_input_fetch_code);
        ivInputFetchCode.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_fifteen, R.id.iv_eighteen, R.id.iv_twenty})
    public void onViewClicked(View view) {
        MainActivity activity = (MainActivity) getActivity();
        switch (view.getId()) {
            case R.id.iv_fifteen:
                activity.setPrice(15.0);
                activity.setProductName("郁金香雪吻");
                break;
            case R.id.iv_eighteen:
                activity.setPrice(18.0);
                activity.setProductName("格罗宁根黑松");
                break;
            case R.id.iv_twenty:
                activity.setPrice(20.0);
                activity.setProductName("海牙圣杯");
                break;
        }
        activity.showFragment(3);
    }


    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity) getActivity();
        activity.showFragment(9);
    }
}
