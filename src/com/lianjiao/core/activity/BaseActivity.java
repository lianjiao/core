package com.lianjiao.core.activity;

import roboguice.activity.RoboActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.android.http.LoadControler;
import com.lianjiao.core.app.CoreAppManager;
import com.lianjiao.core.app.CoreApplication;
import com.lianjiao.core.dialog.LsProgressDialog;
import com.lianjiao.core.utils.LsViewUtil;

/**
 * 类名称：BaseActivity   
 * 类描述：所有Activity的基类，必须调用super.onCreate()方法
 * @创建者：韩创    
 * @创建时间：2015年12月16日   
 * @变更记录：2015年12月16日上午10:43:11 by 记录变更人
 */
public abstract  class BaseActivity extends RoboActivity{

	public LoadControler mLoadControler = null;
	
	public Context mContext;
	
	public LsProgressDialog progressDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        CoreAppManager.addActivity(this);
        //初始化设备屏幕信息
        if(CoreApplication.dm == null){
        	CoreApplication.dm=new DisplayMetrics();		 
    	    getWindowManager().getDefaultDisplay().getMetrics(CoreApplication.dm);  
    	    LsViewUtil.ScreenWidth = CoreApplication.dm.widthPixels;
    	    LsViewUtil.ScreenHidth = CoreApplication.dm.heightPixels;
        }
        
        if(getActionBar() != null){
            getActionBar().hide();
        }
    }

    @Override
    protected void onDestroy() {
    	if (mLoadControler != null) {
			mLoadControler.cancel();
		}
        super.onDestroy();
        CoreAppManager.finishActivity(this);
    }
    
	/**
	 * 方法名：showProgressDialog
	 * 描述：打开加载中对话框
	 * @参数：   参数名  参数类型   参数描述
	 * @返回值类型： void   
	 * @创建时间：  2014年6月30日 
	 * @创建者：zhangyao
	 * @变更记录：2014年6月30日上午11:31:19 by
	 */
	public void showProgressDialog(){
		
		if(progressDialog == null){			
			progressDialog = new LsProgressDialog(this);
			progressDialog.setCancelable(false);
		}
		
		progressDialog.show();
	}
	
	/**
	 * 方法名：closeProgressDialog
	 * 描述：关闭加载中对话框
	 * @参数：   参数名  参数类型   参数描述
	 * @返回值类型： void   
	 * @创建时间：  2014年6月30日 
	 * @创建者：zhangyao
	 * @变更记录：2014年6月30日上午11:31:23 by
	 */
	public void closeProgressDialog(){
		if(progressDialog != null && progressDialog.isShowing()){
			progressDialog.dismiss();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
    

}
