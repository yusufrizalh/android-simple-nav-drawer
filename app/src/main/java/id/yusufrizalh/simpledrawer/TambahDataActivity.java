package id.yusufrizalh.simpledrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahDataActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_add_nama, edit_add_jabatan, edit_add_gaji;
    Button btn_simpan_data, btn_lihat_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        edit_add_nama = findViewById(R.id.edit_add_nama);
        edit_add_jabatan = findViewById(R.id.edit_add_jabatan);
        edit_add_gaji = findViewById(R.id.edit_add_gaji);
        btn_simpan_data = findViewById(R.id.btn_simpan_data);
        btn_lihat_data = findViewById(R.id.btn_lihat_data);

        btn_simpan_data.setOnClickListener(this);
        btn_lihat_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simpan_data:
                simpanDataPegawai();
                break;
            case R.id.btn_lihat_data:
                onBackPressed();
                break;
        }
    }

    private void simpanDataPegawai() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        onBackPressed();
        return super.onCreateOptionsMenu(menu);
    }
}