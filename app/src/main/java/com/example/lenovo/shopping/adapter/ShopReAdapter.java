package com.example.lenovo.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.shopping.MainActivity;
import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.activity.ShoppingActivity;

import java.sql.RowId;
import java.util.HashMap;
import java.util.List;

public class ShopReAdapter extends BaseAdapter {
    private HashMap<String, Integer> pitchOnMap;
    private Context context;
    private List<HashMap<String, String>> list;
    private CheckBox cb;
    private TextView jian;
    private TextView add;
    private TextView shu;
    private TextView price;
    private TextView color;
    private TextView name;

    public ShopReAdapter(Context context, List<HashMap<String, String>> listmap) {
        this.context = context;
        this.list = listmap;

        pitchOnMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            pitchOnMap.put(list.get(i).get("id"), 0);
        }
    }

    public HashMap<String, Integer> getPitchOnMap() {
        return pitchOnMap;
    }

    public void setPitchOnMap(HashMap<String, Integer> pitchOnMap) {
        this.pitchOnMap = pitchOnMap;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate( R.layout.shoping_item, parent,false);
        cb = convertView.findViewById(R.id.cbcb);
        jian = convertView.findViewById(R.id.subarct);
        add = convertView.findViewById(R.id.add);
        name = convertView.findViewById(R.id.cb_name);
        color = convertView.findViewById(R.id.cb_color);
        price = convertView.findViewById(R.id.cb_price);
        shu = convertView.findViewById(R.id.shu);

        name.setText(list.get(position).get(name));
        price.setText("¥ " + (Integer.valueOf(list.get(position).get("price"))) * (Integer.valueOf(list.get(position).get("count"))));
        color.setText(list.get(position).get("type"));
        shu.setText(list.get(position).get("count"));

        if (pitchOnMap.get(list.get(position).get("id")) == 0) {
            cb.setChecked(false);
        } else {
            cb.setChecked(true);
        }

        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(list.get(position).get("count")) <= 1) {
                    Toast.makeText(context, "数量不能再减了", Toast.LENGTH_SHORT).show();
                } else {
                    list.get(position).put("count", (Integer.valueOf(list.get(position).get("count")) - 1) + "");
                    notifyDataSetChanged();
                }
                mrefreshPriceInterface.refreshPrice(pitchOnMap);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).put("count", (Integer.valueOf(list.get(position).get("shu")) + 1) + "");
                notifyDataSetChanged();
                mrefreshPriceInterface.refreshPrice(pitchOnMap);
            }
        });


        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb.isChecked()) {
                    pitchOnMap.put(list.get(position).get("id"), 1);
                } else {
                    pitchOnMap.put(list.get(position).get("id"), 0);
                }
                mrefreshPriceInterface.refreshPrice(pitchOnMap);
            }
        });

        return convertView;
    }

    public interface RefreshPriceInterface {
        void refreshPrice(HashMap<String, Integer> pitchOnMap);
    }

    public ShoppingActivity mrefreshPriceInterface;
    public void setRefreshPriceInterface(ShoppingActivity refreshPriceInterface) {
        mrefreshPriceInterface = refreshPriceInterface;

    }
}
