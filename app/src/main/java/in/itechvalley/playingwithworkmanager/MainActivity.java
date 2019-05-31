package in.itechvalley.playingwithworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.itechvalley.playingwithworkmanager.viewmodel.WorkerViewModel;

public class MainActivity extends AppCompatActivity
{
    private Button btnDoWork;

    /*
    * ViewModel
    * */
    private WorkerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(WorkerViewModel.class);

        btnDoWork = findViewById(R.id.buttonDoWork);
        btnDoWork.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewModel.startBackgroundJob();
            }
        });
    }
}
