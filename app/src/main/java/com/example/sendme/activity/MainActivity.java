package com.example.sendme.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sendme.adapter.AlertDialogManager;
import com.example.sendme.R;
import com.example.sendme.session.SessionManager;

/**
 * Main class
 */
public class MainActivity extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;

    /**
     * fungsi/method untuk menjalankan program pada main activity
     * @param savedInstanceState parameter untuk menyimpan state sebelum program dijalankan
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            /**
             * fungsi/method untuk log out dari aplikasi
             */
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });
    }

    /**
     * fungsi/method untuk pindah halaman ke profile pengguna
     * @param v menyimpan state sebelum dijalankan
     */
    public void profileMenu(View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
    /**
     * fungsi/method untuk pindah halaman ke riwayat pemesanan
     * @param v menyimpan state sebelum dijalankan
     */
    public void historyMenu(View v) {
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }
    /**
     * fungsi/method untuk pindah halaman ke form pemesanan tiket
     * @param v menyimpan state sebelum dijalankan
     */
    public void bookBus(View v) {
        Intent i = new Intent(this, BusActivity.class);
        startActivity(i);
    }
    /**
     * fungsi/method untuk memberikan notifikasi pada pengguna bahwa fitur belum ada
     * @param v menyimpan state sebelum dijalankan
     */
    public void bookKereta(View v) {
        Toast.makeText(getApplicationContext(), "Mohon maaf, sistem sedang dalam pengembangan.", Toast.LENGTH_LONG).show();
    }
}