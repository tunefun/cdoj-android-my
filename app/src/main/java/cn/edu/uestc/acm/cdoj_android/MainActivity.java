package cn.edu.uestc.acm.cdoj_android;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import cn.edu.uestc.acm.cdoj_android.layout.ProblemListFragment;
import cn.edu.uestc.acm.cdoj_android.layout.TwoFragment;
import cn.edu.uestc.acm.cdoj_android.layout.UserFragment;
import cn.edu.uestc.acm.cdoj_android.tools.MyViewPager;

//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;


public class MainActivity extends AppCompatActivity{


    TabLayout mTabLayout;
    ViewPager mViewPager;
    Fragment pagerFragment[] = new Fragment[4];
    String TAG = "tag_cdoj";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputMethodManager im= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        setContentView(R.layout.activity_main);
        im.showSoftInput(getLayoutInflater().inflate(R.layout.activity_main, null), InputMethodManager.SHOW_FORCED);
        initView(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        for (int i = 0; i < 4; i++) {
            outState.putString("fragment" + i, pagerFragment[i].getTag());
        }
        super.onSaveInstanceState(outState);
    }


    private void initView(Bundle saved) {

//        getSupportFragmentManager().s;
//        new BlankFragment()
//        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        FragmentManager fm = getSupportFragmentManager();
//        blankf = (BlankFragment) fm.findFragmentByTag("blankf");
///*        List<Fragment> list = fm.getFragments();
//        if (list != null)
//            Log.d(TAG, "initView: 个数：" + list.size());
//        else Log.d(TAG, "initView: list为空");*/
//        if (blankf == null){
//            Log.d(TAG, "initView: blankf为空");
//            blankf = new BlankFragment();
//            fm.beginTransaction().add(blankf, "blankf").commit();
//        }
////        problemFragement = (ProblemFragement) fm.findFragmentByTag(ProblemFragement.class.getName());
////        contestFragment = (ContestFragment) fm.findFragmentByTag("hahahha");//ProblemFragement.class.getName());
//
//        Log.d(TAG, "initView: blankf:" + blankf);

        if (saved == null){
            for (int i = 0; i < 3; i++) {
                pagerFragment[i + 1] = new TwoFragment();
//                ((TwoFragment)pagerFragment[i])
                new ProblemListFragment((TwoFragment) pagerFragment[i + 1]);
//                sonFragments[i][1] = new ProblemDetailFragment();
            }

            pagerFragment[0] = new UserFragment();
        }
        else{
            for (int i = 0; i < 4; i++) {
                pagerFragment[i] = fm.findFragmentByTag(saved.getString("fragment" + i, "ffff"));
                Log.d(TAG, "initView: " + (pagerFragment[i] == null));
            }
        }
/*        for (int i = 1; i < 4; i++) {
            ((TwoFragment)pagerFragment[i]).setActivityRestart();
        }*/
/*        contestFragment = blankf.contestFragment;
        problemFragement = blankf.problemFragement;
        if (problemFragement == null ){
            Log.d(TAG, "initView: PFragment为空" );
            problemFragement = new ProblemFragement();
            blankf.problemFragement = problemFragement;
        }
        if (contestFragment == null){
            Log.d(TAG, "initView: CFragment为空" );
            contestFragment = new ContestFragment();
            blankf.contestFragment = contestFragment;
        }
        problemFragement.setActivityRestart();
        problemFragement.setFragmentManager(fm);*/
        mViewPager = (MyViewPager) findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(4);
//        mViewPager.setScrollble(false);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position > 3) {
                    return null;
                }
                return pagerFragment[position];
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_action_search);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_action_achievement);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_action_user);


    }

/*    long lastLogTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(System.currentTimeMillis() - lastLogTime > 1000){
            Log.i(TAG, "----------------------------------------------------------------");
        }
        Log.d(TAG, "onKeyDown: " + keyCode + "  ||||||  " + event);
        lastLogTime = System.currentTimeMillis();
        return super.onKeyDown(keyCode, event);
    }*/
}
