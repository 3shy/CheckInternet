package com.nocv.newapp.checker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NetworkUtil {


    private NetworkUtil() {
    }


    public static NetworkInfo getNetworkInfo(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo();
        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
            return null;
        }
    }


    public static boolean isConnected(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnectedOrConnecting());
    }

    public static boolean isConnected(Context context, int connectionType) {
        switch (connectionType) {
            case ConnectivityManager.TYPE_WIFI:
                return isConnectedToWifi(context);
            case ConnectivityManager.TYPE_MOBILE:
                return isConnectedToMobile(context);
            default:
                return isConnected(context);
        }
    }


    @Deprecated
    public static boolean isOnline(Context context) {
        return isConnected(context);
    }


    public static boolean isConnectedToWifi(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }


    public static boolean isConnectedToMobile(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }


    public static boolean isConnectionFast(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected())
                && isConnectionFast(info.getType(), info.getSubtype());
    }


    public static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return false;
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return false;
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return false;
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return true;
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return false;
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    return true;
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return false;
                case TelephonyManager.NETWORK_TYPE_LTE:
                    return true;
                // Unknown
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                default:
                    return false;
            }
        } else {
            return false;
        }
    }
}