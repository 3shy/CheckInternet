package com.nocv.newapp.checker;

import android.content.Context;
import android.util.Log;

import com.nocv.newapp.checker.interfaced.Monitor;
import com.nocv.newapp.checker.monitor.DefaultMonitorFactory;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class Checker {
    private static final String TAG = "Tovuti";
    private static final Object lock = new Object();

    private static volatile Checker checker;
    private WeakReference<Context> contextRef;
    private Set<Monitor> monitors;

    private Checker(Context context) {
        monitors = new HashSet<>();
        this.contextRef = new WeakReference<>(context);
    }

    public static Checker from(Context context) {
        if (checker == null) {
            synchronized (lock) {
                if (checker == null) {
                    checker = new Checker(context);
                }
            }
        }
        return checker;
    }

    public Checker monitor(int connectionType, Monitor.ConnectivityListener listener) {
        Context context = contextRef.get();
        if (context != null)
            monitors.add(new DefaultMonitorFactory().create(context, connectionType, listener));

        start();
        return checker;
    }

    public Checker monitor(Monitor.ConnectivityListener listener) {
        return monitor(-1, listener);
    }

    public void start() {
        for (Monitor monitor : monitors) {
            monitor.onStart();
        }

        if (monitors.size() > 0)
            Log.i(TAG, "started tovuti");
    }

    public void stop() {
        for (Monitor monitor : monitors) {
            monitor.onStop();
        }
    }

}
