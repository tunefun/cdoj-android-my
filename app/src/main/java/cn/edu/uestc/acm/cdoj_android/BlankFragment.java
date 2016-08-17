package cn.edu.uestc.acm.cdoj_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.uestc.acm.cdoj_android.layout.ContestFragment;
import cn.edu.uestc.acm.cdoj_android.layout.ProblemFragement;



public class BlankFragment extends Fragment {

    String s;
    public BlankFragment() {

        // Required empty public constructor
    }
    public BlankFragment(String s){
        this.s = s;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_blank, container, false);
        ((TextView)viewGroup.findViewById(R.id.testtv)).setText(s);
        return viewGroup;
    }

}
