package com.example.runningmantest;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 总结起来。实现自定义的进度条分别按以下几步来:
 * CustomProgressDialog---->XXXdialog.xml---->frame.xml---->图片资源
 * @author Administrator
 *
 */
public class CustomProgressDialog extends ProgressDialog {

	private AnimationDrawable animationDrawable;
	private ImageView loading_iv;
	private TextView loading_tv;
	private int resId;
	private String tips;
	
	
	public CustomProgressDialog(Context context,String tips,int id) {
		super(context);
		this.tips = tips;
		this.resId = id;
		
		setCanceledOnTouchOutside(true);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		initViews();//初始化控件
		initDatas();//给空间设置内容
	}
	
	public void initDatas(){
		loading_iv.setBackgroundResource(resId);//设置需要显示的图片
		//获取AnimationDrawable对象用于显示序列帧动画
		animationDrawable = (AnimationDrawable) loading_iv.getBackground();
		/**
		 * 启动序列帧动画.
		 * 让程序启动时自动启动序列帧动画.
		 * 
		 * 不能直接在Oncreate方法里面直接调用animationDrawable.start().
		 * 否则可能永远只是显示第一张图片
		 */
		loading_iv.post(new Runnable() {
			
			@Override
			public void run() {
				animationDrawable.start();
			}
		});
		
		loading_tv.setText(tips);//给TextView设置文本信息
	}
	
	public void initViews(){
		//为我们自定义的控件设置我们的布局文件
		setContentView(R.layout.progress_dialog);
		
		loading_iv = (ImageView) findViewById(R.id.loadingIv);
		loading_tv = (TextView) findViewById(R.id.loadingTv);
	}
}
