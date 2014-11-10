package com.indalware.wearnotificationexample;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NotificateWear extends ActionBarActivity {

    private static Integer NOTIFID= 001;
    NotificationCompat.Builder notifBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificate_wear);





        Button btnnotif = (Button)findViewById(R.id.btnnotification);

        Button btnweb = (Button)findViewById(R.id.btnnotificacionaction);

        Button btnTextoGrande = (Button)findViewById(R.id.btntextogrande);

        Button btnfondo = (Button)findViewById(R.id.btnfondo);

        Button btnpaginas = (Button)findViewById(R.id.btnpaginas);

        Button btnstack = (Button) findViewById(R.id.btnstack);
    //NOtificación Simple
        btnnotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);

                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setContentTitle("Hola Wear")
                        .setContentText("Hola a todos!!!")
                        .setContentIntent(pintent);
                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);


                nManagerCompat.notify(NOTIFID,notifBuilder.build());

            }
        });
        //Notificacion con boton
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("http://booleanbite.com"));

                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);
                PendingIntent webpintent = PendingIntent.getActivity(NotificateWear.this, 0, webIntent, 0);
                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setContentTitle("Hola Wear")
                        .setContentText("Hola a todos!!! ahora con Web")
                        .setContentIntent(pintent)
                        .addAction(R.drawable.glyphicons_050_link,"Ver Web",webpintent);
                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);


                nManagerCompat.notify(NOTIFID,notifBuilder.build());

            }
        });
        //Notificacion con gran texto
        btnTextoGrande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);

                NotificationCompat.BigTextStyle bstyle= new NotificationCompat.BigTextStyle()
                                                            .bigText(getString(R.string.chiquitofistrum));
                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.glyphicons_130_inbox))
                        .setContentTitle("Hola Wear")
                        .setContentText("Comor???")
                        .setContentIntent(pintent)
                        .setStyle(bstyle);

                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);

                nManagerCompat.notify(NOTIFID,notifBuilder.build());

            }
        });
        //Notificacion con fondo
        btnfondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);
                NotificationCompat.WearableExtender extender = new NotificationCompat.WearableExtender()
                        .setBackground(BitmapFactory.decodeResource(getResources(),R.drawable.logounia));
                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setContentTitle("Hola Wear")
                        .setContentText("Hola a todos!!!")
                        .setContentIntent(pintent)
                        .extend(extender);
                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);

                nManagerCompat.notify(NOTIFID,notifBuilder.build());

            }
        });
        //Notificacion con 2 paginas
        btnpaginas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);

                NotificationCompat.BigTextStyle secondPageStyle= new NotificationCompat.BigTextStyle();
                        secondPageStyle.setBigContentTitle("Pagina 2")
                        .bigText(getString(R.string.chiquitofistrum));

                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setContentTitle("Hola Wear")
                        .setContentText("Hola a todos!!! Tengo otra página más")
                        .setContentIntent(pintent);
                Notification secondnotif = new NotificationCompat.Builder(NotificateWear.this)
                        .setStyle(secondPageStyle).build();

                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);

                Notification notification = notifBuilder.extend(new NotificationCompat.WearableExtender().addPage(secondnotif)).build();

                nManagerCompat.notify(NOTIFID,notification);
            }
        });
        //Notificacion con stacks
        btnstack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificateWear.this, notificacionclick.class);
                PendingIntent pintent = PendingIntent.getActivity(NotificateWear.this,NOTIFID,intent,0);

                notifBuilder = new NotificationCompat.Builder(NotificateWear.this)
                        .setSmallIcon(R.drawable.glyphicons_130_inbox)
                        .setContentTitle("Hola Wear. Stack 1")
                        .setContentText("Hola a todos!!!")
                        .setContentIntent(pintent)
                        .setGroup("GRUPO1");

                NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(NotificateWear.this);


                nManagerCompat.notify(NOTIFID,notifBuilder.build());
                notifBuilder.setContentTitle("Hola Wear. Stack 2");
                nManagerCompat.notify(2,notifBuilder.build());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notificate_wear, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
