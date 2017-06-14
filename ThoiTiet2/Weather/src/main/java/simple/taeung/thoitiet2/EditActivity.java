package simple.taeung.thoitiet2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EditActivity extends AppCompatActivity {
    TextView tvsua,tvxoa;
    Button btsua,btxoa;
    int so;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.sua_xoa_layout);        // Sửa xóa các layout
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        so = bundle.getInt("id");
        final String day = bundle.getString("day");
        final String may = bundle.getString("may");
        final String high = bundle.getString("high");
        final String shot = bundle.getString("shot");
        btsua = (Button) findViewById(R.id.btsua);
        btxoa = (Button) findViewById(R.id.btxoa);
        btsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("sua",so);
                intent.putExtra("day",day);
                intent.putExtra("may",may);
                intent.putExtra("high",high);
                intent.putExtra("shot",shot);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("xoa",so);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
