package com.samrt.qiushi.icecream.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.fragment.BusinessManagementFragment;
import com.samrt.qiushi.icecream.fragment.CodeClickMakingFragment;
import com.samrt.qiushi.icecream.fragment.CodeStartMakingFragment;
import com.samrt.qiushi.icecream.fragment.InputFetchCodeFragment;
import com.samrt.qiushi.icecream.fragment.LoginFragment;
import com.samrt.qiushi.icecream.fragment.SelectBuyFragment;
import com.samrt.qiushi.icecream.fragment.SelectBuyNumFragment;
import com.samrt.qiushi.icecream.fragment.SelectClickMakingFragment;
import com.samrt.qiushi.icecream.fragment.SelectPaymentFragment;
import com.samrt.qiushi.icecream.fragment.SelectStartMakingFragment;
import com.samrt.qiushi.icecream.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnBannerListener {
    @Bind(R.id.banner_advertising)
    Banner bannerAdvertising;
    @Bind(R.id.iv_logo)
    ImageView mIvLogo;
    private List<?> imags = new ArrayList<>();
    private FrameLayout mFlBuy;
    private TextView mTvNationality;
    private TextView mTvLogin;
    private EditText mEtLoginAccount;
    private EditText mEtLoginPassword;
    private View mBuyView;
    private View mLoginView;
    private SelectBuyFragment mSelectBuyFragment;
    private FragmentTransaction mTransaction;
    private LoginFragment mLoginFragment;
    private SelectBuyNumFragment mSelectBuyNumFragment;
    private double price;
    private SelectPaymentFragment mPaymentFragment;
    private SelectClickMakingFragment mClickMakingFragment;
    private SelectStartMakingFragment mStartMakingFragment;
    private String totalPrice;
    private BusinessManagementFragment mBusinessManagementFragment;
    private InputFetchCodeFragment mInputFetchCodeFragment;
    private CodeClickMakingFragment mCodeClickMakingFragment;
    private CodeStartMakingFragment mCodeStartMakingFragment;

    private int selectNum;//选择冰淇淋个数

    private String productName;//冰淇淋名称


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    //初始化
    private void initView() {
        String[] urls = getResources().getStringArray(R.array.url1);
        List list = Arrays.asList(urls);
        imags = new ArrayList(list);

        //默认选择
        showFragment(1);

    }

    private void initData() {
        bannerAdvertising.setImages(imags).setDelayTime(10000).setImageLoader(new GlideImageLoader()).start();
        bannerAdvertising.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerAdvertising.setOnBannerListener(this);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(this, "第" + position + "页", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    //点击进入商户登录入口
    @OnClick(R.id.iv_logo)
    public void onViewClicked() {
        //进入商户登录页面
        showFragment(2);
    }


    //显示Fragment
    public void showFragment(int id) {
        mTransaction = getFragmentManager().beginTransaction();
        hideFragment(mTransaction);
        switch (id) {
            case 1://选择产品页面
                if (mSelectBuyFragment != null) {
                    mTransaction.show(mSelectBuyFragment);
                } else {
                    mSelectBuyFragment = new SelectBuyFragment();
                    mTransaction.add(R.id.fragment_buy, mSelectBuyFragment);
                }
                break;
            case 2://商户登录页面
                if (mLoginFragment != null) {
                    mTransaction.show(mLoginFragment);
                } else {
                    mLoginFragment = new LoginFragment();
                    mTransaction.add(R.id.fragment_buy, mLoginFragment);
                }
                break;
            case 3://选择购买数量
                if (mSelectBuyNumFragment != null) {
                    mTransaction.show(mSelectBuyNumFragment);
                } else {
                    mSelectBuyNumFragment = new SelectBuyNumFragment();
                    mTransaction.add(R.id.fragment_buy, mSelectBuyNumFragment);
                }
                break;
            case 4://选择支付方式页面
                if (mPaymentFragment != null) {
                    mTransaction.show(mPaymentFragment);
                } else {
                    mPaymentFragment = new SelectPaymentFragment();
                    mTransaction.add(R.id.fragment_buy, mPaymentFragment);
                }
                break;
            case 5://点击制作冰淇淋
                if (mClickMakingFragment != null) {
                    mTransaction.show(mClickMakingFragment);
                } else {
                    mClickMakingFragment = new SelectClickMakingFragment();
                    mTransaction.add(R.id.fragment_buy, mClickMakingFragment);
                }
                break;
            case 6://开始制作
                if (mStartMakingFragment != null) {
                    mTransaction.show(mStartMakingFragment);
                } else {
                    mStartMakingFragment = new SelectStartMakingFragment();
                    mTransaction.add(R.id.fragment_buy, mStartMakingFragment);
                }
                break;
            case 7://制作完成
                break;
            case 8://登录商家管理页面
                if (mBusinessManagementFragment != null) {
                    mTransaction.show(mBusinessManagementFragment);
                } else {
                    mBusinessManagementFragment = new BusinessManagementFragment();
                    mTransaction.add(R.id.fragment_buy, mBusinessManagementFragment);
                }
                break;
            case 9://取货码
                if (mInputFetchCodeFragment != null) {
                    mTransaction.show(mInputFetchCodeFragment);
                } else {
                    mInputFetchCodeFragment = new InputFetchCodeFragment();
                    mTransaction.add(R.id.fragment_buy, mInputFetchCodeFragment);
                }
                break;
            case 10://通过取货码点击制作
                if (mCodeClickMakingFragment != null) {
                    mTransaction.show(mCodeClickMakingFragment);
                } else {
                    mCodeClickMakingFragment = new CodeClickMakingFragment();
                    mTransaction.add(R.id.fragment_buy, mCodeClickMakingFragment);
                }

                break;
            case 11://通过取货码开始制作
                if (mCodeStartMakingFragment != null) {
                    mTransaction.show(mCodeStartMakingFragment);
                } else {
                    mCodeStartMakingFragment = new CodeStartMakingFragment();
                    mTransaction.add(R.id.fragment_buy, mCodeStartMakingFragment);
                }
                break;
        }
        mTransaction.commit();

    }


    private void hideFragment(FragmentTransaction transaction) {
        if (mSelectBuyFragment != null) {
            transaction.hide(mSelectBuyFragment);
        }
        if (mLoginFragment != null) {
            transaction.hide(mLoginFragment);
        }
        if (mSelectBuyNumFragment != null) {
            transaction.hide(mSelectBuyNumFragment);
        }
        if (mPaymentFragment != null) {
            transaction.hide(mPaymentFragment);
        }
        if (mClickMakingFragment != null) {
            transaction.hide(mClickMakingFragment);
        }
        if (mStartMakingFragment != null) {
            transaction.hide(mStartMakingFragment);
        }
        if (mBusinessManagementFragment != null) {
            transaction.hide(mBusinessManagementFragment);
        }
        if (mInputFetchCodeFragment != null) {
            transaction.hide(mInputFetchCodeFragment);
        }
        if (mCodeClickMakingFragment != null) {
            transaction.hide(mCodeClickMakingFragment);
        }
        if (mCodeStartMakingFragment != null) {
            transaction.hide(mCodeStartMakingFragment);
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
