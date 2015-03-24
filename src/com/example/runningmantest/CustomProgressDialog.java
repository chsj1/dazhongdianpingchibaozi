package com.example.runningmantest;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * �ܽ�������ʵ���Զ���Ľ������ֱ����¼�����:
 * CustomProgressDialog---->XXXdialog.xml---->frame.xml---->ͼƬ��Դ
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
		
		
		initViews();//��ʼ���ؼ�
		initDatas();//���ռ���������
	}
	
	public void initDatas(){
		loading_iv.setBackgroundResource(resId);//������Ҫ��ʾ��ͼƬ
		//��ȡAnimationDrawable����������ʾ����֡����
		animationDrawable = (AnimationDrawable) loading_iv.getBackground();
		/**
		 * ��������֡����.
		 * �ó�������ʱ�Զ���������֡����.
		 * 
		 * ����ֱ����Oncreate��������ֱ�ӵ���animationDrawable.start().
		 * ���������Զֻ����ʾ��һ��ͼƬ
		 */
		loading_iv.post(new Runnable() {
			
			@Override
			public void run() {
				animationDrawable.start();
			}
		});
		
		loading_tv.setText(tips);//��TextView�����ı���Ϣ
	}
	
	public void initViews(){
		//Ϊ�����Զ���Ŀؼ��������ǵĲ����ļ�
		setContentView(R.layout.progress_dialog);
		
		loading_iv = (ImageView) findViewById(R.id.loadingIv);
		loading_tv = (TextView) findViewById(R.id.loadingTv);
	}
}
