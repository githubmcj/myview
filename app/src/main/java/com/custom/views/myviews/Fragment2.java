package com.custom.views.myviews;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wya.views.dialog.LoadingDialog;

public class Fragment2 extends Fragment {

    private View view;
    private LoadingDialog loadingDialog;
    private Button btn_loading;

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_two, null);
        btn_loading = (Button)view.findViewById(R.id.btn_loading);
        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog = new LoadingDialog(Fragment2.this.getActivity());
                loadingDialog.show();
            }
        });
        return view;
    }

}
