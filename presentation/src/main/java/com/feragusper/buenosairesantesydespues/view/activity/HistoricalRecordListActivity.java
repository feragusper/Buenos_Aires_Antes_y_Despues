package com.feragusper.buenosairesantesydespues.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.feragusper.buenosairesantesydespues.R;
import com.feragusper.buenosairesantesydespues.di.HasComponent;
import com.feragusper.buenosairesantesydespues.di.components.DaggerHistoricalRecordComponent;
import com.feragusper.buenosairesantesydespues.di.components.HistoricalRecordComponent;
import com.feragusper.buenosairesantesydespues.model.HistoricalRecordModel;
import com.feragusper.buenosairesantesydespues.view.fragment.HistoricalRecordListFragment;

/**
 * @author Fernando.Perez
 * @since 0.1
 *
 * Activity that shows a list of HistoricalRecords.
 */
public class HistoricalRecordListActivity extends ToolbarActivity implements HasComponent<HistoricalRecordComponent>,
        HistoricalRecordListFragment.HistoricalRecordListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, HistoricalRecordListActivity.class);
    }

    private HistoricalRecordComponent historicalRecordComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeInjector();
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_historical_record_list;
    }

    private void initializeInjector() {
        this.historicalRecordComponent = DaggerHistoricalRecordComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public HistoricalRecordComponent getComponent() {
        return historicalRecordComponent;
    }

    @Override
    public void onHistoricalRecordClicked(HistoricalRecordModel historicalRecordModel) {
        this.navigator.navigateToHistoricalRecordDetails(this, historicalRecordModel.getHistoricalRecordId());
    }
}
