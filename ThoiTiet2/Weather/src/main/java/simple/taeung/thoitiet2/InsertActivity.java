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
import android.widget.Toast;


public class InsertActivity extends AppCompatActivity {
    Button btluu,bthuy;
    RadioButton rbtmay,rbtmua,rbtsam;
    EditText editngay,editdocao,editdothap;
    String may;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.insert_layout);         // Tạo các layout
        super.onCreate(savedInstanceState);
        btluu = (Button) findViewById(R.id.btluu);
        bthuy = (Button) findViewById(R.id.bthuy);
        rbtmay = (RadioButton) findViewById(R.id.rbtmay);
        rbtmua = (RadioButton) findViewById(R.id.rbtmuagiong);
        rbtsam = (RadioButton) findViewById(R.id.rbtmuasam);
        editngay = (EditText) findViewById(R.id.editngay);
        editdocao = (EditText) findViewById(R.id.editdocao);
        editdothap = (EditText) findViewById(R.id.editdothap);
        rbtmay.setChecked(true);
        may = "may";
        rbtmay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {        // Tạo sự kiện khi click
                if(rbtmay.isChecked()){
                    rbtmua.setChecked(false);
                    rbtsam.setChecked(false);
                    may = "may";
                }
            }
        });
        rbtmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtmua.isChecked()){
                    rbtmay.setChecked(false);
                    rbtsam.setChecked(false);
                    may = "mua";
                }
            }
        });
        rbtsam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtsam.isChecked()){
                    rbtmay.setChecked(false);
                    rbtmua.setChecked(false);
                    may = "sam";
                }
            }
        });
        btluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("ngay", editngay.getText().toString());
                    intent.putExtra("may", may);
                    intent.putExtra("docao", editdocao.getText().toString());
                    intent.putExtra("dothap", editdothap.getText().toString());
                    setResult(RESULT_OK, intent);
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
