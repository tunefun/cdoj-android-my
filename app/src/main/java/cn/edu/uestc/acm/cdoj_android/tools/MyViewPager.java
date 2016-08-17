package cn.edu.uestc.acm.cdoj_android.tools;

import android.content.Context;
//import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by fitzz on 16-8-8.
 */
public class MyViewPager extends ViewPager {
    private boolean scrollble = true;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!scrollble){
            return true;
        }
        return super.onTouchEvent(ev);
    }

    public boolean isScrollble(){
        return scrollble;
    }

    public void setScrollble(boolean scrollble){
        this.scrollble = scrollble;
    }
}
