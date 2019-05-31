package in.itechvalley.playingwithworkmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import in.itechvalley.playingwithworkmanager.utils.WorkerUtils;

public class BackgroundWorker extends Worker
{
    /*
    * Default Constructor
    * */
    public BackgroundWorker(@NonNull Context context, @NonNull WorkerParameters workerParams)
    {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork()
    {
        /*
        * Get data from Activity
        * */
        Data inputData = getInputData();
        String notificationText = inputData.getString("key_title");

        boolean success = WorkerUtils.makeStatusNotification(notificationText, getApplicationContext());

        if (success)
        {
            return Result.success();
        }
        else
        {
            return Result.failure();
        }
    }
}
