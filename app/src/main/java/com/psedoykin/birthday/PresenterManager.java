package com.psedoykin.birthday;

import android.os.Bundle;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.psedoykin.birthday.ui.base.BasePresenter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class PresenterManager {

    private static final String SIS_KEY_PRESENTER_ID = "presenter_id";

    private final AtomicLong currentId;

    private final Cache<Long, BasePresenter<?, ?>> presenters;

    PresenterManager(long maxSize, long expirationValue, TimeUnit expirationUnit) {
        currentId = new AtomicLong();

        presenters = CacheBuilder.newBuilder()
                .maximumSize(maxSize)
                .expireAfterWrite(expirationValue, expirationUnit)
                .build();
    }

    public <P extends BasePresenter<?, ?>> P restorePresenter(Bundle savedInstanceState) {
        Long presenterId = savedInstanceState.getLong(SIS_KEY_PRESENTER_ID);
        P presenter = (P) presenters.getIfPresent(presenterId);
        presenters.invalidate(presenterId);
        return presenter;
    }

    public void savePresenter(BasePresenter<?, ?> presenter, Bundle outState) {
        long presenterId = currentId.incrementAndGet();
        presenters.put(presenterId, presenter);
        outState.putLong(SIS_KEY_PRESENTER_ID, presenterId);
    }
}