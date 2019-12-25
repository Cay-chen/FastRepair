package com.fast.repair.base.task;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.fast.repair.R;
import com.fast.repair.databinding.ViewClearEditextBinding;
import com.scie.motse.base.callback.OnChangeCallback;
import com.scie.motse.base.callback.OnNoDoubleClickListener;


/**
 * @author by chenhong14 on 2019-11-02.
 */
public class ClearEditText extends LinearLayout {

    private static final int PHONE_LENGTH = 11;

    public ViewClearEditextBinding mBinding;
    private boolean mCanNext;
    private OnChangeCallback<Boolean> mOnChangeCallback;

    public ClearEditText(Context context) {
        this(context, null);
    }

    public ClearEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClearEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_clear_editext, this, true);
        mBinding.etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBinding.ivDelete.setVisibility(TextUtils.isEmpty(s) ? GONE : VISIBLE);
                mCanNext = !TextUtils.isEmpty(s) && s.length() == PHONE_LENGTH;
                if (mOnChangeCallback != null) {
                    mOnChangeCallback.onChange(canNext());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBinding.ivDelete.setOnClickListener(new OnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View view) {
                mBinding.etPhone.setText("");
            }
        });
    }

    public boolean canNext() {
        return mCanNext;
    }


    public void setOnChangeCallback(OnChangeCallback<Boolean> onChangeCallback) {
        mOnChangeCallback = onChangeCallback;
    }
}
