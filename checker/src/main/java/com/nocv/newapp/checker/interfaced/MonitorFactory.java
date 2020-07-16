package com.nocv.newapp.checker.interfaced;

import android.content.Context;

import androidx.annotation.NonNull;

public interface MonitorFactory {

    @NonNull
    Monitor create(
            @NonNull Context context,
            int connectionType,
            @NonNull Monitor.ConnectivityListener listener);
}