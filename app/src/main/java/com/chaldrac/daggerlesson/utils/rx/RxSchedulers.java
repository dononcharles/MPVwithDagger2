package com.chaldrac.daggerlesson.utils.rx;

import io.reactivex.Scheduler;

public interface RxSchedulers {
    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
