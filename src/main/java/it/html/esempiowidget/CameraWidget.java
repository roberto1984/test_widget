package it.html.esempiowidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.RemoteViews;

public class CameraWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // (1) carica layout nella RemoteViews
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.camera_widget);

        // (2.1) gestione click su pulsante che attiva video
        Intent videoIntent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        PendingIntent pendingIntent = PendingIntent.getActivity (context, 0,
                videoIntent, 0);
        views.setOnClickPendingIntent (R.id.btn_video, pendingIntent);

        // (2.2) gestione click su pulsante che attiva foto
        Intent photoIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        PendingIntent pendingIntentContact = PendingIntent.getActivity (context, 0,
                photoIntent, 0);
        views.setOnClickPendingIntent (R.id.btn_photo, pendingIntentContact);

        // (3) AppWidgetManager assegna la RemoteViews all'App Widget con id  appWidgetId
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

}

