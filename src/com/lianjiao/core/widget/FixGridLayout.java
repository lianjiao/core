package com.lianjiao.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.lianjiao.core.app.CoreApplication;
import com.lianjiao.core.utils.LsViewUtil;

public class FixGridLayout extends ViewGroup {

	 	/*private int mCellWidth;  
	    private int mCellHeight; */ 
	    private int lineSpace = 0;
	    private int rawSpace = 10;
	    private boolean isShowBounds = false;
	  
	    public FixGridLayout(Context context) {  
	        super(context);  
	    }  
	  
	    public FixGridLayout(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	    }  
	  
	    public FixGridLayout(Context context, AttributeSet attrs, int defStyle) {  
	        super(context, attrs, defStyle);  
	    }  
	  
	    public void setmCellWidth(int w) {  
	        //mCellWidth = w;  
	        requestLayout();  
	    }  
	  
	    public void setmCellHeight(int h) {  
	        //mCellHeight = h;  
	        requestLayout();  
	    }  
	  
	    /** 
	     * 控制子控件的换行 
	     */  
	    @Override  
	    protected void onLayout(boolean changed, int l, int t, int r, int b) {  
	    	if(isInEditMode()){
	    		return;
	    	}
	 
	    	int rawWidth = r- l;
	    	
	        int x = 0;  
	        int y = 0;  
	        int i = 0;  
	        
	        int count = getChildCount();
	        
	        for (int j = 0; j < count; j++) {  
	        	
	            final View childView = getChildAt(j);  
	            
	            // 获取子控件Child的宽高  
	            int w = childView.getMeasuredWidth();  
	            int h = childView.getMeasuredHeight();      
	          
	            if(( x + w) > rawWidth){
	            	y = y + h + lineSpace;
	            	x = 0;
	            }           
	            
	         
	            // 布局子控件  
	            childView.layout(x, y, x + w, y + h);  
	            
	            x = x + w + rawSpace;
	  
	        
	        }  
	    }  
	  
	    /** 
	     * 计算控件及子控件所占区域 
	     */  
	    @Override  
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  	     
	    	 
	    	//LsViewUtil.measureView(this);
	    	
	    	int pwidth = LsViewUtil.ScreenWidth - LsViewUtil.dip2px(getContext(), 20);
	        // 记录ViewGroup中Child的总个数  
	        int count = getChildCount(); 
	        int mheight = 0;
	        int x = 0;
	        // 设置子空间Child的宽高  
	        for (int i = 0; i < count; i++) {  
	            View childView = getChildAt(i);  
	            LsViewUtil.measureView(childView);
	            //childView.measure(cellWidthSpec, cellHeightSpec);  
	            int w = childView.getMeasuredWidth();
	            int h = childView.getMeasuredHeight();	            
	            
	            if(( x + w) > pwidth){
	            	mheight = mheight + h + lineSpace;
	            	x = 0;
	            } 
	            
	            if(mheight <= 0){
		        	mheight = h + lineSpace * 3;
		        }
	            
	            x = x + w + rawSpace;
	        } 
	        
	        if(mheight <= 0){
	        	mheight = 80;
	        }
	        //LogUtils.i("计算出的控件高度"+mheight);
	        // 设置容器控件所占区域大小  
	        // 注意setMeasuredDimension和resolveSize的用法  
	        setMeasuredDimension( widthMeasureSpec, resolveSize(mheight, heightMeasureSpec));  
	         //setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);  
	  
	        // 不需要调用父类的方法  
	        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
	    }  
	  
	    /** 
	     * 为控件添加边框 
	     */  
	    @Override  
	    protected void dispatchDraw(Canvas canvas) {  
	        // 获取布局控件宽高  
	        int width = getWidth();  
	        int height = getHeight();
	        
	        if(isShowBounds){
	        	// 创建画笔  
		        Paint mPaint = new Paint();  
		        // 设置画笔的各个属性  
		        mPaint.setColor(Color.BLUE);  
		        mPaint.setStyle(Paint.Style.STROKE);  
		        mPaint.setStrokeWidth(10);  
		        mPaint.setAntiAlias(true);  
		        // 创建矩形框  
		        Rect mRect = new Rect(0, 0, width, height);  
		        // 绘制边框  
		        canvas.drawRect(mRect, mPaint);  
	        }
	        
	        // 最后必须调用父类的方法  
	        super.dispatchDraw(canvas);  
	    }  
	  
	
	    
	    
}
