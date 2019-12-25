package com.fast.repair.base.container;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import com.fast.repaira.databinding.ActivityBaseTitleBinding;

public abstract class BaseActivity <T extends ViewDataBinding> extends AppCompatActivity {
    protected T mBinding;
    protected ActivityBaseTitleBinding mBaseBinding;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
