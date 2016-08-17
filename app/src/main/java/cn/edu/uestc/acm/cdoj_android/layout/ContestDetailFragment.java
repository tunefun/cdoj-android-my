package cn.edu.uestc.acm.cdoj_android.layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import cn.edu.uestc.acm.cdoj_android.BlankFragment;
import cn.edu.uestc.acm.cdoj_android.R;


public class ContestDetailFragment extends Fragment {

    ViewGroup view;
    ViewPager viewPager;
    final int COL_COUNT = 5;
    public ContestDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = (ViewGroup) inflater.inflate(R.layout.fragment_contest_detail, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.contest_viewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.contest_tablaout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new BlankFragment("fragment" + position);
            }

            @Override
            public int getCount() {
                return COL_COUNT;
            }
        });
//        ViewPager viewPager = view.findViewById()
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
