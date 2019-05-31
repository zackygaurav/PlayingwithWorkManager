package in.itechvalley.playingwithworkmanager.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import in.itechvalley.playingwithworkmanager.R;

public class WorkerUtils
{
    /**
     * Create a Notification that is shown as a heads-up notification if possible.
     * <p>
     * For this codelab, this is used to show a notification so that you know when different steps
     * of the background work chain are starting
     *
     * @param message Message shown on the notification
     * @param context Context needed to create Toast
     */
    public static boolean makeStatusNotification(String message, Context context)
    {

        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            CharSequence name = "default_channel";
            // String description = Constants.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION;
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel =
                    new NotificationChannel("default_id", name, importance);
            // channel.setDescription(description);

            // Add the channel
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (notificationManager != null)
            {
                notificationManager.createNotificationChannel(channel);
            }
            else
            {
                return false;
            }
        }

        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default_id")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Testing Work Manager")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[0]);

        // Show the notification
        NotificationManagerCompat.from(context).notify(3131, builder.build());

        return true;
    }
}
