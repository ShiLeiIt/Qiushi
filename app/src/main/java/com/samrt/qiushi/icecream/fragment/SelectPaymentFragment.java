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

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

/**
 * Created by shilei on 2018/10/16
 * 选择付款方式页面
 */

public class SelectPaymentFragment extends Fragment implements View.OnClickListener {
    private View mPaymentView;
    private LinearLayout mLlAliPay;
    private LinearLayout mLlWechatPay;
    private ImageView mIvAlipay;
    private ImageView mIvWechatPay;
    private ImageView mIvIsSelected;
    private ImageView mIvIsNormal;
    private TextView mTvCancel;
    private MainActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mPaymentView = inflater.inflate(R.layout.fragment_select_method_of_payment, container, false);
        initView();
        return mPaymentView;
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        TextView tvNum = (TextView) mPaymentView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//选择数量
        tvNum.setText(R.string.choose_number);
        tvNum.setTextColor(getResources().getColor(R.color.white));
        TextView tvPay = (TextView) mPaymentView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//付款
        tvPay.setText(R.string.payment);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tvPay.getLayoutParams();
        lp.setMargins(25, 0, 0, 0);
        tvPay.setLayoutParams(lp);
        tvPay.setTextColor(getResources().getColor(R.color.white));

        TextView tvMaking = (TextView) mPaymentView.findViewById(R.id.layout_four).findViewById(R.id.tv_select);//点击制作
        tvMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mPaymentView.findViewById(R.id.layout_five).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        TextView tvMakingFinsh = (TextView) mPaymentView.findViewById(R.id.layout_six).findViewById(R.id.tv_select);//制作完成
        tvMakingFinsh.setText(R.string.making_finish);


        mLlAliPay = (LinearLayout) mPaymentView.findViewById(R.id.ll_ali_pay);//支付宝
        mLlWechatPay = (LinearLayout) mPaymentView.findViewById(R.id.ll_wechat_pay);//微信支付

        TextView tvOpenCamera = (TextView) mPaymentView.findViewById(R.id.tv_open_camera);//文字换行
        tvOpenCamera.setText(getResources().getString(R.string.please_select_payment_software_one) + "\n" + getResources().getString(R.string.please_select_payment_software_two) + "\n" + getResources().getString(R.string.please_select_payment_software_three));

        mIvAlipay = (ImageView) mPaymentView.findViewById(R.id.iv_ali_pay);
        mIvWechatPay = (ImageView) mPaymentView.findViewById(R.id.iv_wechat_pay);
        mIvIsSelected = (ImageView) mPaymentView.findViewById(R.id.iv_is_selected);
        mIvIsNormal = (ImageView) mPaymentView.findViewById(R.id.iv_is_normal);

        mTvCancel = (TextView) mPaymentView.findViewById(R.id.tv_cancel);
        mActivity = (MainActivity) getActivity();
        ImageView ivPayQrCode = (ImageView) mPaymentView.findViewById(R.id.iv_pay_qr_code);//二维码点击测试

        mLlAliPay.setOnClickListener(this);
        mLlWechatPay.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);

        ivPayQrCode.setOnClickListener(this);
        String totalPrice = mActivity.getTotalPrice();
        Toast.makeText(mActivity, "值：==" + totalPrice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        MainActivity activity = (MainActivity) getActivity();
        String totalPrice = activity.getTotalPrice();
        super.onHiddenChanged(hidden);
        if (!hidden) {
            Toast.makeText(mActivity, "值：==" + totalPrice, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_ali_pay:
                mIvAlipay.setImageDrawable(getResources().getDrawable(R.drawable.ali_pay_selected));
                mIvIsSelected.setImageDrawable(getResources().getDrawable(R.drawable.isselected));
                mIvWechatPay.setImageDrawable(getResources().getDrawable(R.drawable.wechat_pay_normal));
                mIvIsNormal.setImageDrawable(getResources().getDrawable(R.drawable.isnormal));
                break;
            case R.id.ll_wechat_pay:
                mIvWechatPay.setImageDrawable(getResources().getDrawable(R.drawable.wechat_pay_selected));
                mIvIsSelected.setImageDrawable(getResources().getDrawable(R.drawable.isnormal));
                mIvAlipay.setImageDrawable(getResources().getDrawable(R.drawable.ali_pay_normal));
                mIvIsNormal.setImageDrawable(getResources().getDrawable(R.drawable.isselected));
                break;
            case R.id.tv_cancel:
                mActivity.showFragment(3);
                break;
            case R.id.iv_pay_qr_code:
                mActivity.showFragment(5);
                break;
        }

    }
}
