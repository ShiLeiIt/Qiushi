package com.samrt.qiushi.icecream.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;
import com.samrt.qiushi.icecream.views.KeyboardView;

/**
 * Created by shilei on 2018/10/30
 * 取货码页面
 */
public class InputFetchCodeFragment extends Fragment implements View.OnClickListener {

    private View mInputFetchView;
    private EditText mInputFetchCode;
    private KeyboardView mKeyboardView;
    private TextView mTvToReceive;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        mInputFetchView = inflater.inflate(R.layout.fragment_input_fetch_code, container, false);
        initView();
        return mInputFetchView;
    }

    private void initView() {
        TextView tvFetchCode = (TextView) mInputFetchView.findViewById(R.id.layout_one).findViewById(R.id.tv_select);//输入取货码
        tvFetchCode.setText(R.string.input_fetch_code);
        tvFetchCode.setTextColor(getResources().getColor(R.color.white));
        TextView tvClickMaking = (TextView) mInputFetchView.findViewById(R.id.layout_two).findViewById(R.id.tv_select);//点击制作
        tvClickMaking.setText(R.string.click_on_the_create);
        TextView tvStartMaking = (TextView) mInputFetchView.findViewById(R.id.layout_three).findViewById(R.id.tv_select);//开始制作
        tvStartMaking.setText(R.string.start_making);


        mInputFetchCode = (EditText) mInputFetchView.findViewById(R.id.et_input_fetch_code);
        mKeyboardView = (KeyboardView) mInputFetchView.findViewById(R.id.keyboard_view);
        mTvToReceive = (TextView) mInputFetchView.findViewById(R.id.tv_to_receive);

        mTvToReceive.setOnClickListener(this);
        mKeyboardView.setEditText(mInputFetchCode);
        mInputFetchCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (String.valueOf(s.length()).equals("6")) {
                    mTvToReceive.setVisibility(View.VISIBLE);
                } else {
                    mTvToReceive.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        //取货码输入完成之后
        MainActivity activity = (MainActivity) getActivity();
        activity.showFragment(10);
    }
}
