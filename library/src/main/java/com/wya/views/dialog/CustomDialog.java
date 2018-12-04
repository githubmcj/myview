package com.wya.views.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wya.views.R;

/**
 * Created by Administrator on 2018/4/14 0014.
 * 自定义的弹出框
 */

public class CustomDialog extends Dialog {
    private Context context;
    private android.app.AlertDialog ad;
    private TextView titleView;
    private TextView messageView;
    private TextView cancel;
    private TextView confirm;
    private View view;

    public CustomDialog(Context context) {
        super(context, R.style.MyDialog);
        this.context = context;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(context, R.layout.custom_dialog, null);
        titleView = (TextView) view.findViewById(R.id.title);
        messageView = (TextView) view.findViewById(R.id.message);
        confirm = (TextView) view.findViewById(R.id.confirm);
        cancel = (TextView) view.findViewById(R.id.cancel);
        setContentView(view);
        setClick();
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setTitleGone() {
        titleView.setVisibility(View.GONE);
    }

    public void setTitleColor(int color, int text_color) {
        titleView.setBackgroundColor(context.getResources().getColor(color));
        titleView.setTextColor(context.getResources().getColor(text_color));
    }

    public void setMessage(String message) {
        messageView.setText(Html.fromHtml(message));
    }

    public void setCancleText(String cancleText) {
        cancel.setText(cancleText);
    }

    public void setConfirmText(String confirmText) {
        confirm.setText(confirmText);
    }

    @SuppressLint("ResourceType")
    public void setConfirmColor(int text_color) {
        confirm.setTextColor(context.getResources().getColorStateList(text_color));
    }

    @SuppressLint("ResourceType")
    public void setCancleColor(int text_color) {
        cancel.setTextColor(context.getResources().getColorStateList(text_color));
    }

    /**
     * 设置按钮
     */
    public void setClick() {

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });

    }


    public String getMessage() {
        return messageView.getText().toString();
    }


    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        void onYesClick();
    }

    public interface onNoOnclickListener {
        void onNoClick();
    }

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(onYesOnclickListener onYesOnclickListener) {
        this.yesOnclickListener = onYesOnclickListener;
    }

}
