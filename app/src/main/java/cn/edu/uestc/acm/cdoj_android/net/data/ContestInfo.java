package cn.edu.uestc.acm.cdoj_android.net.data;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by lenovo on 2016/8/7.
 */
public class ContestInfo {
    public int contestId, length, type;
    public long time;
    public boolean isVisible;
    public String status, title, typeName, timeString;
    public ContestInfo(JSONObject jsonObject){
        if (jsonObject == null) {
            return;
        }
        try {
            length = jsonObject.getInt("length");
            time = jsonObject.getLong("time");
            timeString = new Date(time).toString();
            Log.d("TAG", "ContestInfo: " + timeString);
            type = jsonObject.getInt("type");
            contestId = jsonObject.getInt("contestId");

            isVisible = jsonObject.getBoolean("isVisible");

            status = jsonObject.getString("status");
            title = jsonObject.getString("title");
            typeName = jsonObject.getString("typeName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
