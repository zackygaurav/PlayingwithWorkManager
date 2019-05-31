package in.itechvalley.playingwithworkmanager.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import in.itechvalley.playingwithworkmanager.BackgroundWorker;

public class WorkerViewModel extends AndroidViewModel
{
    /*
    * Constructor
    * */
    public WorkerViewModel(@NonNull Application application)
    {
        super(application);
    }

    public void startBackgroundJob()
    {
        OneTimeWorkRequest.Builder oneTimWorkRequestBuilder =
                new OneTimeWorkRequest.Builder(BackgroundWorker.class);

        /*
        * Data class object to carry data to Worker class
        * */
        Data inputData = new Data.Builder()
                .putString("key_title", "This is coming from Activity")
                .build();
        oneTimWorkRequestBuilder.setInputData(inputData);

        Constraints workConstraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .build();

        oneTimWorkRequestBuilder.setConstraints(workConstraints);

        OneTimeWorkRequest oneTimeWorkRequest = oneTimWorkRequestBuilder.build();

        /*
        * Start the Work
        * */
        WorkManager.getInstance().enqueue(oneTimeWorkRequest);
    }
}
