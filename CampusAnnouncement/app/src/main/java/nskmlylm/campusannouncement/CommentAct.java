package nskmlylm.campusannouncement;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommentAct extends AppCompatActivity {

    private static final String TAG = "CommentAct";

    private List<Comment> cList;
    private Comment c;
    private TextView userT, headerT, descT, dateT;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Intent j = getIntent();

        userT = (TextView)findViewById(R.id.userNameY);
        headerT = (TextView)findViewById(R.id.headerY);
        descT = (TextView)findViewById(R.id.descriptionY);
        dateT = (TextView)findViewById(R.id.dateY);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String user = extras.getString("user");
            userT.setText(user);
            String header = extras.getString("header");
            headerT.setText(header);
            String desc = extras.getString("desc");
            descT.setText(desc);
            String date = extras.getString("date");
            dateT.setText(date);
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); // This prevents the keyboard opening at the beginning.

        //TO DO: Button onclick - paylaş dedikten sonra bir snackbar aç Yorum başlaşıyorum bak? diye bi sor. PAYLAŞ-UNDO SEÇENEKLERİ ÇIKAR ÖYLE PAYLAŞ

        cList = new ArrayList<>();
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

        c = new Comment("Arif Burak Dikmen", "Paylaştığınız için teşekkürler", "06.05.2018");
        cList.add(c);

        c = new Comment("Selin Daldaban", "Teşekkürler", "06.05.2018");
        cList.add(c);

        c = new Comment("Mert Dönmez", " Sağolun. ", "06.05.2018");
        cList.add(c);

        createRV();
    }

    public void createRV() {
        Log.d(TAG, "createRV method worked.");

        RecyclerView rv = findViewById(R.id.commRecyclerView);
        commRvAdapter adapter = new commRvAdapter(this, cList);
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }

    public boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
