package cn.edu.uestc.acm.cdoj_android.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.uestc.acm.cdoj_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProblemFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProblemFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment {

    String TAG = "TwoFragmentTAG";
    public Fragment leftFragment, rightFragment;
    public ViewGroup view = null;
    boolean isRight = false;

    public TwoFragment() {

        // Required empty public constructor
    }
    public void setFragment(Fragment left, Fragment right){
        leftFragment = left;
        rightFragment = right;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: 被调用" + this);
        try {
            // Inflate the layout for this fragment
//        if (view == null) {
            view = (ViewGroup) inflater.inflate(R.layout.fragment_tow, container, false);
/*            if (leftFragment == null) {
                leftFragment = new ProblemListFragment();
            }
            if (rightFragment == null) {
                rightFragment = new ProblemDetailFragment();


            }*/
//            Log.d(TAG, "onCreateView: container：" + view.findViewById(R.id.container));
            if (rightFragment.isAdded()) {
                Log.d(TAG, "onCreateView: 已经被add");
//                getChildFragmentManager().beginTransaction().remove(leftFragment).commit();
            } else {
                Log.d(TAG, "onCreateView: 还未被add");
            }
            if (isLand()) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.left_container, leftFragment)
                        .replace(R.id.right_container, rightFragment)
                        .commit();
            } else {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.left_container, leftFragment)
                        .replace(R.id.right_container, rightFragment)
                        .commit();
                if (isRight){
                    showRight();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "onCreateView: catch:" + this);
        }
//        }
//            Log.d(TAG, "onCreateView: " + view.findViewById(R.id.prob_list));
        return view;
    }

    public void showRight(){
//        if(leftFragment.isAdded()){
//            getFragmentManager().beginTransaction().remove(leftFragment).commit();
//        }
//
//        if(rightFragment.isAdded()){
//            getChildFragmentManager().beginTransaction().remove(rightFragment).commit();
//        }
        if (!isLand()){
//            view.findViewById(R.id.right_container).setId(R.id.left_container);
/*            if (rightFragment.isAdded()){
                getChildFragmentManager().beginTransaction().remove(rightFragment).commit();
            }*/
            view.findViewById(R.id.left_container).setVisibility(View.GONE);
            view.findViewById(R.id.right_container).setVisibility(View.VISIBLE);
            isRight = true;
        }
//        rightFragment.showDetail(probId);
    }
    public void backToleft(){
        if (!isLand()){
            view.findViewById(R.id.left_container).setVisibility(View.VISIBLE);
            view.findViewById(R.id.right_container).setVisibility(View.GONE);
            isRight = false;
        }
    }
    public boolean isLand(){
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(TAG, "onAttachFragment: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }



}
