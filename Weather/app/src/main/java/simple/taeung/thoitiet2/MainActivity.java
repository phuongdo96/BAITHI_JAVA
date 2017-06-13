package simple.taeung.thoitiet2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<ItemInfo> ite;
    TtAdapter adapter;
    final static int RE = 1;
    final static int RE1 = 2;
    final static int RE2 = 3;
    int anh;
    String tt;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int i = ite.size();
        ItemInfo info = ite.get(i-1);
        if(requestCode==RE && resultCode==RESULT_OK){
            if(data.hasExtra("ngay")){
                Log.d("ngay",data.getExtras().getString("ngay"));
                Log.d("may",data.getExtras().getString("may"));
                Log.d("docao",data.getExtras().getString("docao"));
                Log.d("dothap",data.getExtras().getString("dothap"));

                String may = data.getExtras().getString("may");

                switch (may){
                    case "may":
                        anh = R.drawable.partly_cloudy;
                        tt = "Mây rải rác";
                        break;
                    case "mua":
                        anh = R.drawable.rain_s_cloudy;
                        tt = "Mưa giông";
                        break;
                    case "sam":
                        anh = R.drawable.thunderstorms;
                        tt = "Sấm chớp";
                        break;
                }

                ite.add(new ItemInfo(i,anh,data.getExtras().getString("ngay"),tt,data.getExtras().getString("docao")+"°C",data.getExtras().getString("dothap")+"°C"));
               adapter.notifyDataSetChanged();

            }
        }
        else if(requestCode==RE1 && resultCode==RESULT_OK){
            if(data.hasExtra("xoa")){
                int so = data.getExtras().getInt("xoa");
                ite.remove(so);
                adapter.notifyDataSetChanged();
            }
            else if(data.hasExtra("sua")){
                int so = data.getExtras().getInt("sua");
                String day = data.getExtras().getString("day");
                String may = data.getExtras().getString("may");
                String high = data.getExtras().getString("high");
                String shot = data.getExtras().getString("shot");
                Log.d("id_m",""+so);
                Intent intent = new Intent(MainActivity.this,SuaActivity.class);
                intent.putExtra("s",so);
                intent.putExtra("ngay",day);
                intent.putExtra("may",may);
                intent.putExtra("docao",high);
                intent.putExtra("dothap",shot);
                startActivityForResult(intent,RE2);
            }
        }
        if(requestCode==RE2 && resultCode==RESULT_OK){
            if(data.hasExtra("ngay")){
                int may = data.getExtras().getInt("may");

                switch (may){
                    case 1:
                        anh = R.drawable.partly_cloudy;
                        tt = "Mây rải rác";
                        break;
                    case 2:
                        anh = R.drawable.rain_s_cloudy;
                        tt = "Mưa giông";
                        break;
                    case 3:
                        anh = R.drawable.thunderstorms;
                        tt = "Sấm chớp";
                        break;
                }
                Log.d("id",""+data.getExtras().getInt("id"));
                ite.remove(data.getExtras().getInt("id"));
                ite.add(data.getExtras().getInt("id"),new ItemInfo(data.getExtras().getInt("id"),anh,data.getExtras().getString("ngay"),tt,data.getExtras().getString("docao"),data.getExtras().getString("dothap")));
                adapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.itthem){
                Intent intent =new Intent(MainActivity.this,InsertActivity.class);
                startActivityForResult(intent,RE);


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lvtt);
        ite = new ArrayList<>();
        ite.add(new ItemInfo(0, R.drawable.partly_cloudy, "01/06", "Mây rải rác", "32°C", "25°C"));
        ite.add(new ItemInfo(1, R.drawable.rain_s_cloudy, "02/06", "Mưa giông", "27°C", "23°C"));
        ite.add(new ItemInfo(2, R.drawable.thunderstorms, "03/06", "Sấm chớp", "25°C", "20°C"));
        adapter = new TtAdapter(this, ite);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemInfo info = ite.get(i);
                Log.d("View", "" + info.getId());
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemInfo info = ite.get(i);
                Intent intent =new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("id",i);
                intent.putExtra("day",info.getNgay());
                intent.putExtra("may",info.getMay());
                intent.putExtra("high",info.getDocao());
                intent.putExtra("shot",info.getDothap());
                startActivityForResult(intent,RE1);

                return false;
            }
        });


    }
}