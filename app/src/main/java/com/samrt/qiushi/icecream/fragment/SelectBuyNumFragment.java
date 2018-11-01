package com.samrt.qiushi.icecream.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samrt.qiushi.icecream.Api.ApiService;
import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

import java.math.BigDecimal;

import retrofit2.Retrofit;

/**
 * Created by shilei on 2018/10/12
 * 选择购买数量页面
 */

public class SelectBuyNumFragment extends Fragment implements View.OnClickListener {
    private View mNumView;
    //    private String price;//作为容器的对象
    private ImageView mIvOne;
    private ImageView mIvTwo;
    private ImageView mIvThree;
    private ImageView mIvFour;
    private ImageView mIvFive;
    private TextView mTvOriginalPrice;
    private Double mPrice;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private Double mPrice1;
    private TextView mTvTotalPrice;
    private int mNumber;
    public ApiService mApiService;
    private Retrofit mRetrofit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mNumView = inflater.inflate(R.layout.fragment_select_number, container, false);
        initView();
        return mNumView;
    }

    private void initView() {
        mTvTotalPrice = (TextView) mNumView.findViewById(R.id.tv_total_price);

        //设置字体样式
        Typeface typeFace = Typeface.createFromAsset(getResources().getAssets(), "fonts/impact.ttf");
        mTvTotalPrice.setTypeface(typeFace);

        TextView tvNum = (TextView) mNumView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//选择数量
        tvNum.setText(R.string.choose_number);
        tvNum.setTextColor(getResources().getColor(R.color.white));
        TextView tvPay = (TextView) mNumView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//付款
        tvPay.setText(R.string.payment);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tvPay.getLayoutParams();
        lp.setMargins(10, 0, 0, 0);
        tvPay.setLayoutParams(lp);

        TextView tvMaking = (TextView) mNumView.findViewById(R.id.layout_four).findViewById(R.id.tv_select);//点击制作
        tvMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mNumView.findViewById(R.id.layout_five).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);
        TextView tvMakingFinsh = (TextView) mNumView.findViewById(R.id.layout_six).findViewById(R.id.tv_select);//制作完成
        tvMakingFinsh.setText(R.string.making_finish);


        MainActivity activity = (MainActivity) getActivity();
        mPrice = activity.getPrice();
        if (mPrice == 15.0) {
            System.out.println("pirce===15" + mPrice);
        } else if (mPrice == 18.0) {
            System.out.println("pirce===18" + mPrice);
        } else {
            System.out.println("pirce===20" + mPrice);
        }

        mIvOne = (ImageView) mNumView.findViewById(R.id.iv_one);
        mIvTwo = (ImageView) mNumView.findViewById(R.id.iv_two);
        mIvThree = (ImageView) mNumView.findViewById(R.id.iv_three);
        mIvFour = (ImageView) mNumView.findViewById(R.id.iv_four);
        mIvFive = (ImageView) mNumView.findViewById(R.id.iv_five);

        mTvCancel = (TextView) mNumView.findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) mNumView.findViewById(R.id.tv_confirm);

        mTvOriginalPrice = mNumView.findViewById(R.id.tv_original_price);//原价
        mTvOriginalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线

        mIvOne.setOnClickListener(this);
        mIvTwo.setOnClickListener(this);
        mIvThree.setOnClickListener(this);
        mIvFour.setOnClickListener(this);
        mIvFive.setOnClickListener(this);

        mTvCancel.setOnClickListener(this);//取消
        mTvConfirm.setOnClickListener(this);//确认


        activity.setTotalPrice(String.valueOf(mul(1.0, activity.getPrice())));
        mTvOriginalPrice.setText("原价¥：" + activity.getPrice());
        mTvTotalPrice.setText("¥:" + sub(activity.getPrice(), 10.0));
        activity.setSelectNum(1);
        mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.white_one));
        mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
        mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
        mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
        mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        MainActivity activity = (MainActivity) getActivity();
        mPrice1 = activity.getPrice();
        super.onHiddenChanged(hidden);
        if (!hidden) {
            // 返回之后重新设置值
            activity.setTotalPrice(String.valueOf(mul(1.0, mPrice1)));
            mTvOriginalPrice.setText("原价¥：" + mPrice1);
            mTvTotalPrice.setText("¥:" + sub(mPrice1, 10.0));
            activity.setSelectNum(1);
            mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.white_one));
            mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
            mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
            mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
            mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));
        }


    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        final MainActivity activity = (MainActivity) getActivity();
        Double price = activity.getPrice();
        switch (v.getId()) {
            case R.id.iv_one:
                mNumber = 1;
                mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.white_one));
                mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
                mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
                mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
                mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));
                if (price != 0.0) {
                    mTvOriginalPrice.setText("原价¥：" + String.valueOf(mul(1.0, price)));
                }
                mTvTotalPrice.setText("¥:" + String.valueOf(sub(mul(1.0, price), 10.0)));
                activity.setTotalPrice(String.valueOf(mul(1.0, price)));
                activity.setSelectNum((int) mNumber);

                break;
            case R.id.iv_two:
                mNumber = 2;
                mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.white_two));
                mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.black_one));
                mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
                mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
                mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));
                if (price != 0.0) {
                    mTvOriginalPrice.setText("原价¥：" + String.valueOf(mul(2.0, price)));
                }
                //设置活动价格
                mTvTotalPrice.setText("¥:" + String.valueOf(sub(mul(2.0, price), 20.0)));
                //设置总价格
                activity.setTotalPrice(String.valueOf(mul(2.0, price)));
                activity.setSelectNum((int) mNumber);
                break;
            case R.id.iv_three:
                mNumber = 3;
                mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.white_three));
                mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.black_one));
                mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
                mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
                mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));
                if (price != 0.0) {
                    mTvOriginalPrice.setText("原价¥：" + String.valueOf(mul(3.0, Double.valueOf(price))));
                }
                mTvTotalPrice.setText("¥:" + String.valueOf(sub(mul(3.0, price), 30.0)));
                activity.setTotalPrice(String.valueOf(mul(3.0, Double.valueOf(price))));
                activity.setSelectNum((int) mNumber);
                break;
            case R.id.iv_four:
                mNumber = 4;
                mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.white_four));
                mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.black_one));
                mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
                mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
                mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.black_five));
                if (price != 0.0) {
                    mTvOriginalPrice.setText("原价¥：" + String.valueOf(mul(4.0, price)));
                }
                mTvTotalPrice.setText("¥:" + String.valueOf(sub(mul(4.0, Double.valueOf(price)), 40.0)));
                activity.setTotalPrice(String.valueOf(mul(4.0, Double.valueOf(price))));
                activity.setSelectNum((int) mNumber);
                break;
            case R.id.iv_five:
                mNumber = 5;
                mIvFive.setImageDrawable(getResources().getDrawable(R.drawable.white_five));
                mIvOne.setImageDrawable(getResources().getDrawable(R.drawable.black_one));
                mIvTwo.setImageDrawable(getResources().getDrawable(R.drawable.black_two));
                mIvThree.setImageDrawable(getResources().getDrawable(R.drawable.black_three));
                mIvFour.setImageDrawable(getResources().getDrawable(R.drawable.black_four));
                if (price != 0.0) {
                    mTvOriginalPrice.setText("原价¥：" + String.valueOf(mul(5.0, price)));
                }
                mTvTotalPrice.setText("¥:" + String.valueOf(sub(mul(5.0, Double.valueOf(price)), 50.0)));
                activity.setTotalPrice(String.valueOf(mul(5.0, Double.valueOf(price))));
                activity.setSelectNum((int) mNumber);
                break;
            case R.id.tv_cancel:
                activity.showFragment(1);
                break;
            case R.id.tv_confirm:

                //支付付款页面
//                if (!mTvOriginalPrice.getText().toString().equals("原价:¥ 0.0") || !mTvTotalPrice.getText().toString().equals("¥ 0.0")) {
                activity.showFragment(4);

                break;
        }

    }

    // 乘法
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2).doubleValue();
    }

    //减法
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }
}
