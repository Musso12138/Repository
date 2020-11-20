package com.example.homework_chapter_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SearchLayout extends LinearLayout {

    private static final String TAG = "SearchLayout";

    private EditText mEditText;
    private ImageButton mCancel;

    private OnSearchTextChangedListener mListener;

    public SearchLayout(Context context) {
        super(context);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        inflate(getContext(), R.layout.activity_search_layout, this);

        mEditText = findViewById(R.id.edit);
        mCancel = findViewById(R.id.cancel);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged:" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mListener != null) {
                    mListener.afterChanged(s.toString());
                }
            }
        });

        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setOnSearchTextChangedListener(OnSearchTextChangedListener listener){
        mListener = listener;
    };

    public interface OnSearchTextChangedListener{
        void afterChanged(String text);
    }

}