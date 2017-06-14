package simple.taeung.thoitiet2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class TtAdapter extends BaseAdapter {

    ArrayList <ItemInfo> arr ;
    LayoutInflater inflater;
public TtAdapter(Context context,ArrayList<ItemInfo> arr){
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.arr = arr;

}


    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemInfo item =arr.get(i);
        ImageView imv;
        TextView may,docao,dothap,ngay;
        if(view == null){
            view=inflater.inflate(R.layout.item_layout,viewGroup,false);
        }
        imv=(ImageView)view.findViewById(R.id.img);
        may=(TextView) view.findViewById(R.id.tvmay);
        docao=(TextView) view.findViewById(R.id.tvdocao);
        dothap=(TextView) view.findViewById(R.id.tvdothap);
        ngay=(TextView) view.findViewById(R.id.tvtime);
        imv.setImageResource(item.getAnh());
        may.setText(item.getMay());
        docao.setText(item.getDocao());
        dothap.setText(item.getDothap());
        ngay.setText(item.getNgay());
        return view;
    }
}
