package com.feragusper.buenosairesantesydespues.datasource;

import com.feragusper.buenosairesantesydespues.HistoricalRecordEntity;
import com.feragusper.buenosairesantesydespues.cache.HistoricalRecordCache;

import java.util.List;

import rx.Observable;

/**
 * @author Fernando.Perez
 * @since 0.1
 * <p>
 * {@link HistoricalRecordDataStore} implementation based on file system data store.
 */
public class DiskHistoricalRecordDataStore implements HistoricalRecordDataStore {

    private final HistoricalRecordCache historicalRecordCache;

    /**
     * Construct a {@link HistoricalRecordDataStore} based file system data store.
     *
     * @param historicalRecordCache A {@link HistoricalRecordCache} to cache data retrieved from the api.
     */
    public DiskHistoricalRecordDataStore(HistoricalRecordCache historicalRecordCache) {
        this.historicalRecordCache = historicalRecordCache;
    }

    @Override
    public Observable<List<HistoricalRecordEntity>> getHistoricalRecordEntityList() {
        //TODO: implement simple cache for storing/retrieving collections of historical records.
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override
    public Observable<HistoricalRecordEntity> getHistoricalRecordEntityDetails(final String historicalRecordId) {
        return this.historicalRecordCache.get(historicalRecordId);
    }
}
