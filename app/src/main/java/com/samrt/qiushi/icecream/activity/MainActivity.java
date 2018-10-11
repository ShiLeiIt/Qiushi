package com.samrt.qiushi.icecream.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnBannerListener, View.OnClickListener {
    @Bind(R.id.banner_advertising)
    Banner bannerAdvertising;
    private List<?> imags = new ArrayList<>();
    private FrameLayout mFlLogin;
    private TextView tvNationality;
    private TextView tvLogin;
    private EditText etLoginAccount;
    private EditText etLoginPassword;
    private View mLoginView;

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
        mFlLogin = (FrameLayout) findViewById(R.id.fl_login);
        mLoginView = LayoutInflater.from(this).inflate(R.layout.layout_login, null);
        mFlLogin.addView(mLoginView);
        tvNationality = (TextView) mLoginView.findViewById(R.id.tv_nationality);
        tvLogin = (TextView) mLoginView.findViewById(R.id.tv_login);
        etLoginAccount = (EditText) mLoginView.findViewById(R.id.et_login_account);
        etLoginPassword = (EditText) mLoginView.findViewById(R.id.et_login_password);


        Drawable nationality = getResources().getDrawable(R.drawable.china);//国籍
        //四个参数分别是设置图片的左、上、右、下的尺寸
        nationality.setBounds(0, 0, 60, 40);
        tvNationality.setCompoundDrawables(nationality, null, null, null);

        Drawable account = getResources().getDrawable(R.drawable.account);//账号
        account.setBounds(0, 0, 40, 40);
        etLoginAccount.setCompoundDrawables(account, null, null, null);

        final Drawable password = getResources().getDrawable(R.drawable.password);//密码
        password.setBounds(0, 0, 40, 40);
        etLoginPassword.setCompoundDrawables(password, null, null, null);

        final Drawable passwordClear = getResources().getDrawable(R.drawable.password_clear);//密码清除
        passwordClear.setBounds(0, 0, 40, 40);
//        //密码输入监听
        etLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    etLoginPassword.setCompoundDrawables(password, null, passwordClear, null);
                } else {
                    etLoginPassword.setCompoundDrawables(password, null, null, null);
                }
            }
        });

        tvLogin.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        View specificationsView = LayoutInflater.from(this).inflate(R.layout.layout_buy, null);
//        Drawable specifications = getResources().getDrawable(R.drawable.select_specifications);//账号
//        specifications.setBounds(0, 0, 160, 100);
//
//       TextView tvSelect=  (TextView)specificationsView.findViewById(R.id.tv_select_specifications);
//        tvSelect.setCompoundDrawables(null, null, null, specifications);
        mLoginView.setVisibility(View.GONE);
        mFlLogin.addView(specificationsView);
    }
}
