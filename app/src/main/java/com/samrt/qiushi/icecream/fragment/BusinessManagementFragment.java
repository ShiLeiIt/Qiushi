package com.samrt.qiushi.icecream.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.samrt.qiushi.icecream.R;
import com.samrt.qiushi.icecream.activity.MainActivity;

/**
 * Created by shilei on 2018/10/24
 */

public class BusinessManagementFragment extends Fragment implements View.OnClickListener {

    private View mManagementView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mManagementView = inflater.inflate(R.layout.fragment_business_management, container, false);
        initView();
        return mManagementView;
    }

    private void initView() {
        ImageView ivBack = (ImageView) mManagementView.findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);
        //制冷
        View refrigeration = mManagementView.findViewById(R.id.refrigeration);

        TextView tvRefrigeration = (TextView) refrigeration.findViewById(R.id.tv_management);
        tvRefrigeration.setText(R.string.management_refrigeration);
        ImageView ivRefrigeration = (ImageView) refrigeration.findViewById(R.id.iv_management);
        ivRefrigeration.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.management_refrigeration));

        refrigeration.setOnClickListener(this);
        //保鲜
        View fresh = mManagementView.findViewById(R.id.fresh);

        TextView tv = (TextView) fresh.findViewById(R.id.tv_management);
        tv.setText(R.string.management_fresh);
        ImageView iv = (ImageView) fresh.findViewById(R.id.iv_management);
        iv.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.fresh));
        fresh.setOnClickListener(this);

        //清洗
        View cleaning = mManagementView.findViewById(R.id.cleaning);

        TextView tvCleaning = (TextView) cleaning.findViewById(R.id.tv_management);
        tvCleaning.setText(R.string.management_cleaning);
        ImageView ivCleaning = (ImageView) cleaning.findViewById(R.id.iv_management);
        ivCleaning.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.cleaning));
        cleaning.setOnClickListener(this);
        //待机
        View standby = mManagementView.findViewById(R.id.standby);

        TextView tvStandby = (TextView) standby.findViewById(R.id.tv_management);
        tvStandby.setText(R.string.management_standby);
        ImageView ivStandby = (ImageView) standby.findViewById(R.id.iv_management);
        ivStandby.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.standby));
        standby.setOnClickListener(this);

        //解冻
        View thaw = mManagementView.findViewById(R.id.thaw);

        TextView tvThaw = (TextView) thaw.findViewById(R.id.tv_management);
        tvThaw.setText(R.string.management_thaw);
        ImageView ivThaw = (ImageView) thaw.findViewById(R.id.iv_management);
        ivThaw.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.thaw));
        thaw.setOnClickListener(this);

        //巴氏杀菌
        View pasteurization = mManagementView.findViewById(R.id.pasteurization);

        TextView tvPasteurization = (TextView) pasteurization.findViewById(R.id.tv_management);
        tvPasteurization.setText(R.string.management_pasteurization);
        ImageView ivPasteurization = (ImageView) pasteurization.findViewById(R.id.iv_management);
        ivPasteurization.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.pasteurization));
        pasteurization.setOnClickListener(this);

        //再生
        View regeneration = mManagementView.findViewById(R.id.regeneration);

        TextView tvRegeneration = (TextView) regeneration.findViewById(R.id.tv_management);
        tvRegeneration.setText(R.string.management_regeneration);
        ImageView ivRegeneration = (ImageView) regeneration.findViewById(R.id.iv_management);
        ivRegeneration.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.regeneration));
        regeneration.setOnClickListener(this);

        //重操作
        View operation = mManagementView.findViewById(R.id.operation);

        TextView tvOperation = (TextView) operation.findViewById(R.id.tv_management);
        tvOperation.setText(R.string.management_heavy_operation);
        ImageView ivOperation = (ImageView) operation.findViewById(R.id.iv_management);
        ivOperation.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.heavy_operation));
        operation.setOnClickListener(this);

        //自动出料
        View discharging = mManagementView.findViewById(R.id.discharging);

        TextView tvDischarging = (TextView) discharging.findViewById(R.id.tv_management);
        tvDischarging.setText(R.string.management_automatic_discharging);
        ImageView ivDischarging = (ImageView) discharging.findViewById(R.id.iv_management);
        ivDischarging.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.automatic_discharging));
        discharging.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.iv_back:
                activity.showFragment(2);
                break;
            case R.id.refrigeration:
                Toast.makeText(getActivity(), "制冷", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fresh:
                Toast.makeText(activity, "保鲜", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cleaning:
                Toast.makeText(activity, "清洗", Toast.LENGTH_SHORT).show();
                break;
            case R.id.standby:
                Toast.makeText(activity, "待机", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thaw:
                Toast.makeText(activity, "解冻", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pasteurization:
                Toast.makeText(activity, "巴氏杀菌", Toast.LENGTH_SHORT).show();
                break;
            case R.id.regeneration:
                Toast.makeText(activity, "再生", Toast.LENGTH_SHORT).show();
                break;
            case R.id.operation:
                Toast.makeText(activity, "重操作", Toast.LENGTH_SHORT).show();
                break;
            case R.id.discharging:
                Toast.makeText(activity, "自动出料", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
