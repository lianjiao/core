package com.lianjiao.core.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

public class LsTextView extends TextView {
	private int typeFace;

	public LsTextView(Context context) {
		this(context,null);
	}
	
	public LsTextView(Context context, AttributeSet attrs) {    	
		this(context, attrs,0);
	} 
	    
	public LsTextView(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
//	    if(attrs!=null){
//	    	TypedArray a = getContext().obtainStyledAttributes( attrs , R.styleable.LsTypeFace , 0 , 0);
//	    	typeFace = a.getInt(R.styleable.LsTypeFace_textType,0);
//	    	a.recycle();
//	    }
	    init();    
	}

	private void init(){
//		if(getContext() != null && !isInEditMode()){
//        	this.setTypeface(LsViewUtil.getTypeface(getContext(),typeFace));	
//        }
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		String str = text.toString();
		super.setText(Html.fromHtml(str), type);
	}
	
	
	
	
	
}
