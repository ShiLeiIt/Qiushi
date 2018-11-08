package com.samrt.qiushi.icecream.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.samrt.qiushi.icecream.Api.ApiService;
import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;
import com.samrt.qiushi.icecream.model.LoginBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shilei on 2018/10/12
 */

public class LoginFragment extends Fragment implements View.OnClickListener {
    private FrameLayout mFlBuy;
    private TextView mTvNationality;
    private TextView mTvLogin;
    private EditText mEtLoginAccount;
    private EditText mEtLoginPassword;
    private View mLoginView;
    private Retrofit mRetrofit;
    private ApiService mApiService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        mLoginView = inflater.inflate(R.layout.fragment_login, container, false);
        initView();
        return mLoginView;
    }

    private void initView() {
        mTvNationality = (TextView) mLoginView.findViewById(R.id.tv_nationality);
        mTvLogin = (TextView) mLoginView.findViewById(R.id.tv_login);
        mEtLoginAccount = (EditText) mLoginView.findViewById(R.id.et_login_account);
        mEtLoginPassword = (EditText) mLoginView.findViewById(R.id.et_login_password);
        Drawable nationality = getResources().getDrawable(R.drawable.china);//国籍
        //四个参数分别是设置图片的左、上、右、下的尺寸
        nationality.setBounds(0, 0, 60, 40);
        mTvNationality.setCompoundDrawables(nationality, null, null, null);

        Drawable account = getResources().getDrawable(R.drawable.account);//账号
        account.setBounds(0, 0, 40, 40);
        mEtLoginAccount.setCompoundDrawables(account, null, null, null);

        final Drawable password = getResources().getDrawable(R.drawable.password);//密码
        password.setBounds(0, 0, 40, 40);
        mEtLoginPassword.setCompoundDrawables(password, null, null, null);

        final Drawable passwordClear = getResources().getDrawable(R.drawable.password_clear);//密码清除
        passwordClear.setBounds(0, 0, 40, 40);
//       密码输入监听
        mEtLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    mEtLoginPassword.setCompoundDrawables(password, null, passwordClear, null);
                } else {
                    mEtLoginPassword.setCompoundDrawables(password, null, null, null);
                }
            }
        });
        mTvLogin.setOnClickListener(this);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);

    }

    @Override
    public void onClick(View v) {
        mApiService.getLoginStatus(4, "19837e4d1739579b41f5a76de9b555c8", "1bc", mEtLoginAccount.getText().toString(), mEtLoginPassword.getText().toString()).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    if (response.body().getData().getStatus().equals("SUCCESS")) {
                        MainActivity activity = (MainActivity) getActivity();
                        activity.showFragment(8);
                    } else {
                        Toast.makeText(getActivity(), "登录失败账号或者密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "请求code错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable throwable) {

            }
        });

    }
}
