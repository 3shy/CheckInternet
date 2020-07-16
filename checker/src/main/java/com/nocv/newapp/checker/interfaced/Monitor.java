package com.nocv.newapp.checker.interfaced;

public interface Monitor extends LifecycleListener {

    interface ConnectivityListener {
        void onConnectivityChanged(int connectionType, boolean isConnected, boolean isFast);
    }
}