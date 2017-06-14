package simple.taeung.thoitiet2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class SuaActivity extends AppCompatActivity {
    EditText edngay,eddocao,eddothap;
    RadioButton rbtmay,rbtmua,rbtsam;
    Button btluu,bthuy;
    int ac,so;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.sua_layout);
        super.onCreate(savedInstanceState);
        btluu = (Button) findViewById(R.id.btluus);
        bthuy = (Button) findViewById(R.id.bthuys);
        rbtmay = (RadioButton) findViewById(R.id.rbtmays);
        rbtmua = (RadioButton) findViewById(R.id.rbtmuas);
        rbtsam = (RadioButton) findViewById(R.id.rbtmuasams);
        edngay = (EditText) findViewById(R.id.edngay);
        eddocao = (EditText) findViewById(R.id.eddocao);
        eddothap = (EditText) findViewById(R.id.eddothap);
        Bundle bundle =getIntent().getExtras();
        so = bundle.getInt("s");
        String ngay = bundle.getString("ngay");
        String may = bundle.getString("may");
        String docao = bundle.getString("docao");
        String dothap = bundle.getString("dothap");
        edngay.setText(ngay);
        eddocao.setText(docao);
        eddothap.setText(dothap);
        if(may.equals("Mây rải rác") ){
            rbtmay.setChecked(true);
            rbtmay.isChecked();
        }else if(may.equals("Mưa giông")){
            rbtmua.setChecked(true);
            rbtmua.isChecked();
        }
        else if(may.equals("Mưa có sấm chớp")){
            rbtsam.setChecked(true);
            rbtsam.isChecked();
        }
        Log.d("may_sua",may);
        Log.d("id_sua",""+so);
        rbtmay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtmay.isChecked()) {
                    rbtmua.setChecked(false);
                    rbtsam.setChecked(false);
                    ac = 1;
                }

            }
        });
        rbtmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtmua.isChecked()) {
                    rbtmay.setChecked(false);
                    rbtsam.setChecked(false);
                    ac=2;
                }
            }
        });
        rbtsam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtsam.isChecked()) {
                    rbtmay.setChecked(false);
                    rbtmua.setChecked(false);
                    ac = 3;
                }
            }
        });
        btluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",so);
                intent.putExtra("ngay",edngay.getText().toString());
                intent.putExtra("may",ac);
                intent.putExtra("docao",eddocao.getText().toString());
                intent.putExtra("dothap",eddothap.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
