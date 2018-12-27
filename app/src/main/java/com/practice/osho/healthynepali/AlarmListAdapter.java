package com.practice.osho.healthynepali;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by osho on 11/1/15.
 */
public class AlarmListAdapter extends BaseAdapter {
    private Context mContext;
    private List<AlarmModel> mAlarms;

    public AlarmListAdapter(Context context, List<AlarmModel> alarms) {
        mContext = context;
        mAlarms = alarms;
    }

    public void setAlarms(List<AlarmModel> alarms) {
        mAlarms = alarms;
    }

    @Override
    public int getCount() {
        if (mAlarms != null) {
            return mAlarms.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mAlarms != null) {
            return mAlarms.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (mAlarms != null) {
            return mAlarms.get(position).id;
        }
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater.from(mContext));
            view=layoutInflater.inflate(R.layout.alarm_list_item,viewGroup,false);
        }
        AlarmModel model = (AlarmModel)getItem(i);

        int hourOfDay=model.timeHour;
        String AM_PM="AM";
        if (hourOfDay >= 12) {
            AM_PM = "PM";
            if (hourOfDay >=13 && hourOfDay < 24) {
                hourOfDay -= 12;
            }
            else {
                hourOfDay = 12;
            }
        } else if (hourOfDay == 0) {
            hourOfDay = 12;
        }

        TextView tv_time =(TextView)view.findViewById(R.id.tv_time);
        tv_time.setText(String.format("%02d:%02d", hourOfDay, model.timeMinute));
        TextView tv_am_pm=(TextView)view.findViewById(R.id.tv_am_pm);
        tv_am_pm.setText(AM_PM);

        TextView tv_msg=(TextView)view.findViewById(R.id.tv_alarm_msg);
        tv_msg.setText(model.name);

        ImageView img_repeat=(ImageView)view.findViewById(R.id.image_repeat);
        if(!model.repeatWeekly){
            img_repeat.setVisibility(View.INVISIBLE);
        }

        updateTextColor((TextView) view.findViewById(R.id.tv_sun), model.getRepeatingDay(AlarmModel.SUNDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_mon), model.getRepeatingDay(AlarmModel.MONDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_tue), model.getRepeatingDay(AlarmModel.TUESDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_wed), model.getRepeatingDay(AlarmModel.WEDNESDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_thu), model.getRepeatingDay(AlarmModel.THURSDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_fri), model.getRepeatingDay(AlarmModel.FRIDAY));
        updateTextColor((TextView) view.findViewById(R.id.tv_sat), model.getRepeatingDay(AlarmModel.SATURDAY));

        ToggleButton btnToggle = (ToggleButton) view.findViewById(R.id.image_alarm_on_off);
        btnToggle.setChecked(model.isEnabled);
        btnToggle.setTag(Long.valueOf(model.id));
        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((AlarmListActivity) mContext).setAlarmEnabled(((Long) buttonView.getTag()).longValue(), isChecked);
            }
        });

        view.setTag(Long.valueOf(model.id));
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ((AlarmListActivity) mContext).startAlarmDetailsActivity(((Long) view.getTag()).longValue());
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                ((AlarmListActivity) mContext).deleteAlarm(((Long) view.getTag()).longValue());
                return true;
            }
        });


        return view;
    }
    private void updateTextColor(TextView view, boolean isOn) {
        if (isOn) {
            view.setTextColor(Color.GREEN);
        } else {
            view.setTextColor(Color.WHITE);
        }
    }
}
