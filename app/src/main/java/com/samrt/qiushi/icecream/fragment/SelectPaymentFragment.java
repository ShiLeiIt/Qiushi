package com.samrt.qiushi.icecream.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.samrt.qiushi.icecream.Api.ApiService;
import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;
import com.samrt.qiushi.icecream.model.OrderPayBean;
import com.samrt.qiushi.icecream.model.ProductBean;
import com.samrt.qiushi.icecream.model.QrCodeBean;
import com.samrt.qiushi.icecream.utils.LogUtil;
import com.samrt.qiushi.icecream.utils.ZXingUtils;

import java.io.StringReader;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public ApiService mApiService;
    private Retrofit mRetrofit;
    private ImageView mIvPayQrCode;
    private String mOrderNumber;
    private Handler mHandler;
    private Runnable mRunnable;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private static final String TAG = "SelectPaymentFragment";


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
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //请求微信二维码
        getCodeUrl(mActivity.getTotalPrice());


        //二维码点击测试
        mIvPayQrCode = (ImageView) mPaymentView.findViewById(R.id.iv_pay_qr_code);


        mLlAliPay.setOnClickListener(this);
        mLlWechatPay.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);

        mIvPayQrCode.setOnClickListener(this);
        String totalPrice = mActivity.getTotalPrice();
        LogUtil.d("totalprice======", totalPrice);
        //启动定时器
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        };
        mTimer.schedule(mTimerTask, 1000, 2000);
    }

    @Override
    public void onDestroy() {
        mTimer.cancel();
        super.onDestroy();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        MainActivity activity = (MainActivity) getActivity();
        String totalPrice = activity.getTotalPrice();
        super.onHiddenChanged(hidden);
        if (!hidden) {
            LogUtil.d("totalprice1======", totalPrice);
            getCodeUrl(totalPrice);
            //启动定时器
            mTimer = new Timer();
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                }
            };
            mTimer.schedule(mTimerTask, 1000, 2000);
        } else {
            //取消定时器
            mTimer.cancel();
        }

    }


    public void getCodeUrl(String totalPrice) {
        int selectNum = mActivity.getSelectNum();
        LogUtil.d("num===", selectNum + "");
        LogUtil.d("name=====", mActivity.getProductName() + "");
        LogUtil.d("price======", mActivity.getPrice() + "");

        ProductBean productBean = new ProductBean();
        productBean.setPrice(mActivity.getPrice());
        productBean.setName(mActivity.getProductName());
        productBean.setNum(mActivity.getSelectNum());
//        productBean.setAmount(Double.parseDouble(totalPrice));
        productBean.setAmount(0.01);
        String s = new Gson().toJson(productBean);


        LogUtil.d("json======", s);
        mApiService = mRetrofit.create(ApiService.class);
        mApiService.getWeChatCode(2, "19837e4d1739579b41f5a76de9b555c8", "zxc", s).enqueue(new Callback<QrCodeBean>() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onResponse(Call<QrCodeBean> call, final Response<QrCodeBean> response) {
                LogUtil.d("code======", response.body().getCode() + "");
                LogUtil.d("msg======", response.body().getMsg());

                if (response.body().getCode() == 200 && response.body().getData() != null) {
                    //微信二维码地址
                    String code_url = response.body().getData().getCode_url();
                    Bitmap bitmap = ZXingUtils.createQRImage(code_url, 280, 280);
                    mIvPayQrCode.setImageBitmap(bitmap);
                    mOrderNumber = response.body().getData().getOrder_number();
                    LogUtil.d("codeUrl======", code_url);

                    mHandler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            if (msg.what == 1) {
                                mApiService.getOrderPayInfo(3, "19837e4d1739579b41f5a76de9b555c8", "qwe", "query", mOrderNumber).enqueue(new retrofit2.Callback<OrderPayBean>() {
                                    @Override
                                    public void onResponse(Call<OrderPayBean> call, Response<OrderPayBean> response) {
                                        LogUtil.d("定时器=====", "++++++++");
                                        if (response.body().getData() != null) {
                                            if (response.body().getData().getOrder().getStatus().equals("0")) {
                                                //一段时间未支付，会跳转到购买页面
                                                mActivity.showFragment(1);
                                            } else if (response.body().getData().getOrder().getStatus().equals("1")) {
                                                //已创建订单但未支付
                                                LogUtil.d(TAG, "订单创建未支付");
                                            } else {
                                                mActivity.showFragment(5);
                                                mTimer.cancel();
                                            }
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<OrderPayBean> call, Throwable throwable) {
                                        Toast.makeText(mActivity, "2222", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            super.handleMessage(msg);

                        }
                    };


                }
            }

            @Override
            public void onFailure(Call<QrCodeBean> call, Throwable t) {
                LogUtil.d("请求失败信息======", t.getMessage());
            }
        });

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
                mActivity.setTotalPrice(0 + "");
                mActivity.showFragment(3);

                break;
            case R.id.iv_pay_qr_code:
                mActivity.showFragment(5);
                break;
        }

    }
}
