package cn.edu.uestc.acm.cdoj_android.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.edu.uestc.acm.cdoj_android.R;
import cn.edu.uestc.acm.cdoj_android.net.NetData;
import cn.edu.uestc.acm.cdoj_android.net.ViewHandler;
import cn.edu.uestc.acm.cdoj_android.net.data.InfoList;
import cn.edu.uestc.acm.cdoj_android.net.data.ProblemInfo;

public class ProblemListFragment extends Fragment implements ViewHandler{
    
    final String TAG = "ProblemListFragmentTag";
    
    ViewGroup view;
    ListView listView;
    ArrayList<Map<String, String>> data = new ArrayList(20);
    SimpleAdapter simpleAdapter;
    TwoFragment container;
    ProblemDetailFragment rightFragment;
    boolean isFirstCreateView = true;
    public ProblemListFragment() {
        // Required empty public constructor
    }
    public ProblemListFragment(TwoFragment container){
        this.container = container;
        rightFragment = new ProblemDetailFragment();
        container.setFragment(this, rightFragment);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TAG", "problist_onCreateView: ");
        if (isFirstCreateView){
            getList(pagenow, keyword);
            isFirstCreateView =false;
        }
        if (view == null){
//            getList();
            view = (ViewGroup) inflater.inflate(R.layout.fragment_problem_list, container, false);
            listView = (ListView) view.findViewById(R.id.list);
//            new SimpleAdapter()
            listView.setAdapter(
                    simpleAdapter  = new SimpleAdapter(getContext(), data, R.layout.pro_list_item,
                            new String[]{"title", "src"}, new int[]{R.id.title, R.id.src}));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d(TAG, "onItemClick: " + i);
                    ProblemListFragment.this.container.showRight();
                    rightFragment.showDetail(Integer.parseInt(data.get(i).get("id")));
                    Log.d(TAG, "onCreateView: plistf view的父亲" + ProblemListFragment.this.view.getParent());
                }
            });
            listView.addFooterView(inflater.inflate(R.layout.loading, null));
            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    Log.d(TAG, "onScrollStateChanged: ");
                }

                @Override
                public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                    Log.d(TAG, "onScroll: i:" + i + "|| i1: " + i1 + "||i2:" + i2 );
                    if(!flag_sent && !flag_load_all && i + i1 >= i2){
                        flag_sent = true;
                        getList(pagenow, keyword);
                    }
                }
            });
        }
        // Inflate the layout for this fragment
        return view;
    }
    String keyword = "";
    int pagenow = 1;
    boolean flag_re = false, flag_load_all = false, flag_sent = false;

    public void getList(int page, String keyword){
        //new NetData(MainActivity.activity).getProblemList(1, (ViewHandler) MainActivity.activity);
        NetData.getProblemList(page, keyword, this);
    }
    public void updateList(InfoList problemInfoList){
        if (flag_re){
            data.clear();
        }
        if (problemInfoList.result){
            pagenow = problemInfoList.pageInfo.currentPage;
            if(problemInfoList.pageInfo.currentPage == problemInfoList.pageInfo.totalPages){
                flag_load_all =true;
            }
            ArrayList<ProblemInfo> list = problemInfoList.getInfoList();
            Log.d("TAG", "updateList: " + this + "分割" + list.size());
            for (ProblemInfo temp:list) {
                Map map = new HashMap<String, String>();
                map.put("title", temp.title);
                map.put("src", temp.source);
                map.put("id", "" + temp.problemId);
                data.add(map);
            }
            simpleAdapter.notifyDataSetChanged();
//            listView.invalidate();
        }
        else{
            Log.e("TAG", "updateList: 网络错误，获取list失败");
        }
    }

    @Override
    public void show(int which, Object data) {
        flag_sent = false;
        updateList((InfoList) data);
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
