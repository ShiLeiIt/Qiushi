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

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

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
    }

    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity) getActivity();
        activity.showFragment(8);

    }
}
