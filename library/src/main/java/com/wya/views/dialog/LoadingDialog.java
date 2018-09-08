package com.wya.views.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.wya.views.R;

 /**
  * 创建日期：2018/8/8 16:24
  * 作者： Mao Chunjiang
  * 文件名称：LoadingDialog
  * 类说明：加载动画
  */

public class LoadingDialog extends Dialog {
	private View view;
	private final AnimationDrawable animationDrawable;
	private ColorDrawable colorDrawable;

	@SuppressLint("ResourceType")
	public LoadingDialog(Context activity, boolean canceledOnTouch, boolean cancelable) {
		super(activity);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    	view = View.inflate(activity, R.layout.dialog_loading, null);
    	setContentView(view);
		colorDrawable = new ColorDrawable(0x00000000);
    	getWindow().setBackgroundDrawable(colorDrawable);
		ImageView img_load = (ImageView) view.findViewById(R.id.img_load);
		animationDrawable = (AnimationDrawable) img_load.getBackground();

    	//取消dialog空白处点击消失事件
		this.setCanceledOnTouchOutside(canceledOnTouch);
		setCancelable(cancelable);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		animationDrawable.start();
	}

	public void setText(String text){
		TextView hintText = (TextView) view.findViewById(R.id.hintTv);
		hintText.setText(text);
	}
}
