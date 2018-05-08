package nskmlylm.campusannouncement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnnouncementAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "AnnouncementAct";
    private String m_Text = "";
    private List<Announcements> aList;
    private Announcements a;

    //Timer
    private Handler mHandler = new Handler();
    private Runnable checkNewAnnouncements = new Runnable() {
        public void run() {
            if (checkConnection(getApplicationContext())) {
                //Do your thing here
                Log.i("Bilgi", "Internet bağlantısı mevcuttur.");
            } else {
                Toast.makeText(getApplicationContext(), "İnternet bağlantınızı kontrol ediniz.", Toast.LENGTH_LONG).show();
                Log.i("Bilgi", "Internet bağlantısı bulunamadı.");
            }
            mHandler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent j = getIntent();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); // This prevents the keyboard opening at the beginning.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AnnouncementAct.this);
                builder.setTitle("Duyuru Ekle");
                View viewInflated = LayoutInflater.from(AnnouncementAct.this).inflate(R.layout.add_announcement_dialog, (ViewGroup) findViewById(android.R.id.content), false);

                final EditText header = (EditText) viewInflated.findViewById(R.id.header);
                final EditText desc = (EditText) viewInflated.findViewById(R.id.description);
                builder.setView(viewInflated);

                builder.setPositiveButton("Paylaş", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        m_Text = header.getText().toString() + " \n " + desc.getText().toString();
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                        String date = dateformat.format(c.getTime());

                        a = new Announcements("Deneme", header.getText().toString(), desc.getText().toString(), date);
                        aList.add(a);

                        createRV();

                        //Snackbar.make(view, m_Text, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                    }
                });
                builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        aList = new ArrayList<>();
        fillTheLists();
        checkNewAnnouncements.run();
    }

    public void fillTheLists() {
        Log.d(TAG, "fillTheLists method worked.");

        /*
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String date = dateformat.format(c.getTime());
        */

        a = new Announcements("Mert Dönmez", "Bilgisayar Mimarisi Dersi Telafi Quizleri", "15 Mayıs tarihli derste telafi ve mazeret quizleri yapılacaktır. Duyurulur...", "06.05.2018");
        aList.add(a);

        a = new Announcements("Derya Malkoç", "Fizik 1 Ders İptali", "25.04.2018 perşembe günü saat 9.00’daki Fizik dersi yapılmayacaktır.\n Sadullah Hoca’nın duyurusudur. Bilgilerinize sunulur.", "06.05.2018");
        aList.add(a);

        a = new Announcements("Salim Şahin", "Etkinlik", "20 Nisan 2018 Cuma günü Saat 14.00'da D-115 'te Samet Karadağ'ın katılımı ile \"Büyük veri,AI,IOT,Chatbot ve Blockchain\" konulu programımız olacaktır.IEEEFSMVU Student Branch olarak sizleri de programımızda görmekten mutluluk duyarız.", "06.05.2018");
        aList.add(a);

        a = new Announcements("Ali Nizam", "Siber Terör CTF Yarışması", "Gazi Üniversitesi, gençlerimizin ilgisini Siber Güvenlk alanına çekmek ve siber saldırılarla mücadele edebilecek insan kaynağı geliştirmek amacıyla \"Gazi Siber Güç CTF Yarışması\" düzenlenmektedir. \n" +
                "Bu konuda yeteneği olan herkese açık olan bu yarışmada, dereceye giren yarışmacılara toplamda 20.000 TL ödül verilecektir.\n" +
                "\n" +
                "Yarışmaya son başvuru tarihi 5 Nisan 2018'dir.", "06.05.2018");
        aList.add(a);

        a = new Announcements("Ali Nizam", "BLM104 Dersi dönem ödev kontrolleri", "BLM104 Dersi dönem ödev kontrolleri \n" +
                "--Numarası sonu tek olan öğrencilerimiz için Kadir Aram\n" +
                "--Çift olan öğrencilerimiz için Okan Kara tarafından yapılacaktır.\n" +
                "Son tarih vize sınavından bir gün öncesidir.\n" +
                "Saygılarımla.", "06.05.2018");
        aList.add(a);

        createRV();

    }

    public void createRV() {
        Log.d(TAG, "createRV method worked.");

        RecyclerView rv = findViewById(R.id.recyclerView);
        annRvAdapter adapter = new annRvAdapter(this, aList);
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.announcement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_muhF) {
            Toast.makeText(getApplicationContext(), "Mühendislik", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_mimarF) {
            Toast.makeText(getApplicationContext(), "Mimarlık", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_hukukF) {
            Toast.makeText(getApplicationContext(), "Hukuk", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_edebiyatF) {
            Toast.makeText(getApplicationContext(), "Edebiyat", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.genel) {
            Toast.makeText(getApplicationContext(), "Genel", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

}
