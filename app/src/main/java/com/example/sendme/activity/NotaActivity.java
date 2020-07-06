package com.example.sendme.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.sendme.R;
import com.example.sendme.database.DatabaseHelper;
import com.example.sendme.session.SessionManager;

import java.util.HashMap;

public class NotaActivity extends AppCompatActivity {
    protected Cursor cursor;
    protected Cursor cursor1;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    SessionManager session;
    String name, email, tgl, asal, tujuan, id_book = "", hrgsub;
    TextView Ntid, Nttot, Ntasal, Nttujuan, Nttgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        dbHelper = new DatabaseHelper(this);

        session = new SessionManager(getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();
        email = user.get(SessionManager.KEY_EMAIL);

        db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM TB_USER WHERE username = '" + email + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            name = cursor.getString(2);
        }

        TextView Ntnama = findViewById(R.id.Ntnama);
        TextView Ntemail = findViewById(R.id.Ntemail);

        Ntnama.setText(name);
        Ntemail.setText(email);
        detailBooking();
        setupToolbar();

    }

    private void detailBooking() {
        cursor = db.rawQuery("SELECT * FROM TB_BOOK, TB_HARGA WHERE TB_BOOK.id_book = TB_HARGA.id_book AND username='" + email + "'", null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            id_book = cursor.getString(0);
            asal = cursor.getString(1);
            tujuan = cursor.getString(2);
            tgl = cursor.getString(3);
            hrgsub = cursor.getString(10);
        }

        Ntid = findViewById(R.id.Ntid);
        Nttgl = findViewById(R.id.Nttgl);
        Ntasal = findViewById(R.id.Ntasal);
        Nttujuan = findViewById(R.id.Nttujuan);
        Nttot = findViewById(R.id.hrgSub);

        Ntid.setText(id_book);
        Nttot.setText(hrgsub);
        Nttgl.setText(tgl);
        Ntasal.setText(asal);
        Nttujuan.setText(tujuan);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tb);
        toolbar.setTitle("Nota Booking");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}