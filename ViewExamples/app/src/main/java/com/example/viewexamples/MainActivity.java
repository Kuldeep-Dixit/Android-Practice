package com.example.viewexamples;

import static android.app.NotificationManager.IMPORTANCE_HIGH;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID="Testing Channel";
    private static final int NOTIFICATIONL_ID=100;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView crdV = findViewById(R.id.crd_click);

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);

        crdV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                View view = getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_layout));

                toast.setView(view);
                TextView textMsg = view.findViewById(R.id.txt_show);

                textMsg.setText("This is Custom Toast MEssage.");
                toast.setDuration(toast.LENGTH_SHORT);
                toast.show();


                TextView txt_title = dialog.findViewById(R.id.txt_title);
                TextView txt_show = dialog.findViewById(R.id.txt_msg);

                txt_title.setText("Success");
                txt_show.setText("Your Click is Successfully Recognised.");

                dialog.show();
//                dialog.setCancelable(false);

                Button notifyee = dialog.findViewById(R.id.btnNotify);
                Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.icon,null);
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap largeIcon = bitmapDrawable.getBitmap();
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notifcation;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    notifcation = new Notification.Builder(MainActivity.this)
//                            .setLargeIcon(largeIcon)
//                            .setSmallIcon(R.drawable.icon)
//                            .setContentText("New Message")
//                            .setChannelId(CHANNEL_ID)
//                            .setSubText("This is Notifiction")
//                            .build();
//
//                    nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"NEw Channel",IMPORTANCE_HIGH));
//                }
                
                    notifcation = new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.icon)
                            .setContentText("New Message")
                            .setSubText("This is Notifiction")
                            .build();


                notifyee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nm.notify(NOTIFICATIONL_ID, notifcation);
                    }
                });


                Log.e("Error BC","This is Custom Error.");


            }
        });
    }
}