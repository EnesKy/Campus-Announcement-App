package nskmlylm.campusannouncement;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;
import java.util.List;

public class AnnouncementAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "AnnouncementAct";
    private String m_Text = "";
    private List<Announcement> aList;
    private Context mContext;

    //Timer
    private Handler mHandler = new Handler();
    private Runnable checkNewAnnouncements = new Runnable() {
        public void run() {
             if(checkConnection(getApplicationContext())) {
                    //Do your thing here
                    Log.i("Bilgi","Internet bağlantısı mevcuttur.");
                }else{
                    Toast.makeText(getApplicationContext(),"İnternet bağlantınızı kontrol ediniz.", Toast.LENGTH_LONG).show();
                    Log.i("Bilgi","Internet bağlantısı bulunamadı.");
                }
            mHandler.postDelayed(this, 5000);
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
                        Snackbar.make(view, m_Text, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
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

    public void fillTheLists(){
        Log.d(TAG, "fillTheLists method worked.");

        Announcement a = new Announcement("Mert Dönmez", "Başlık 1", "Fenerbahçe ŞAMPİYON", "06.05.2018");
        aList.add(a);

        a = new Announcement("Salim Şahin", "Başlık 2", "3 Boyutlu yazıcı falan", "06.05.2018");
        aList.add(a);

        a = new Announcement("Bilal Ekrem Harmanşa", "Başlık 3", "Amaç öğrenmek", "06.05.2018");
        aList.add(a);

        a = new Announcement("Furkan Sarıhan", "Başlık 4", "VR ulan", "06.05.2018");
        aList.add(a);

        a = new Announcement("Bedirhan Yıldırım", "Başlık 5", "Hooded Guy", "06.05.2018");
        aList.add(a);

        createRW();

    }

    public void createRW(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView rv = findViewById(R.id.recyclerView);
        rvAdapter adapter = new rvAdapter(this, aList);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean checkConnection(@NonNull Context context) {
        return  ((ConnectivityManager) context.getSystemService (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

}
