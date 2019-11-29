package com.example.book;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Mine extends Fragment implements View.OnClickListener {
    private LinearLayout personalinformationLayout;
    private PersonalInformation personalinformation_fg;
    private androidx.fragment.app.FragmentManager fragmentManager;
    private View view;
    private int gray = 0xFF7597B3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine, container, false);
        fragmentManager = getFragmentManager();
        initView();
        return view;
    }

    private void initView() {
        // 初始化底部导航栏的控件
        personalinformationLayout = (LinearLayout) view.findViewById(R.id.personalinformationLayout);
        System.out.println(personalinformationLayout);
        personalinformationLayout.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personalinformationLayout:
                Intent intent = new Intent(getActivity().getApplicationContext(), Setting.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent);
                break;
            default:
                break;
        }
    }
}
