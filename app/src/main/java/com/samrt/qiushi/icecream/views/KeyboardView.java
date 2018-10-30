package com.samrt.qiushi.icecream.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.samrt.qiushi.icecream.R;

/**
 * @创建者 DWL
 * @创建时间 2018/10/29 16:26
 * @描述 描述信息
 */

public class KeyboardView extends LinearLayout {

    private Context mContext;
    private RecyclerView mRy;
    private int mHeight;
    private int mWidth;

    public KeyboardView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public KeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public KeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    private void init() {
        LayoutInflater from = LayoutInflater.from(mContext);
        from.inflate(R.layout.view_keyboard, this);
        mRy = findViewById(R.id.recyclerview);
        mRy.setLayoutManager(new GridLayoutManager(mContext, 3));
        Adapter adapter = new Adapter(mContext);
        mRy.setAdapter(adapter);
    }

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private Context mContext;

        public Adapter(Context context) {
            mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 实例化展示的view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            mHeight = parent.getHeight();
            mWidth = parent.getWidth();

            ViewHolder viewHolder = new ViewHolder(v);
            ViewGroup.LayoutParams layoutParams = viewHolder.mAll.getLayoutParams();

            layoutParams.height = mHeight / 4;
            layoutParams.width = mWidth / 3;
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // 绑定数据
            if (position < 9) {
                holder.mTv.setText(position + 1 + "");
            } else {
                if (position == 9) {

                } else if (position == 10) {
                    holder.mTv.setText("0");
                } else {
                    holder.mIv.setImageResource(R.drawable.delete);
                }
            }
            holder.mAll.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mEditText != null) {
                        String s = mEditText.getText().toString().trim();
                        if (position == 11) {
                            mEditText.setText("");
                        } else {
                            if (s.length() == 6) {
                                return;
                            }
                            if (position == 10) {
                                mEditText.setText(s + "0");
                                mEditText.setSelection(s.length() + 1);
                            } else if (position != 9) {
                                mEditText.setText(s + (position + 1));
                                mEditText.setSelection(s.length() + 1);
                            }
                        }
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return 12;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mTv;
            private ImageView mIv;
            private RelativeLayout mAll;

            public ViewHolder(View itemView) {
                super(itemView);
                mTv = itemView.findViewById(R.id.tv);
                mIv = itemView.findViewById(R.id.iv);
                mAll = itemView.findViewById(R.id.all);
            }
        }

    }

    //    private OnLLViewClickListener mListener;
    private EditText mEditText;

//    public interface OnLLViewClickListener {
//        void onLLViewClick();
//    }

    public void setEditText(EditText editText) {
        mEditText = editText;
    }

//    public void setOnLLViewClickListener(EditText editText) {
////        mListener = listener;
//        mEditText = editText;
//    }
}
