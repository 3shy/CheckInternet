package com.nocv.newapp.checker;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Checker {




    public static void onNetworkStateChange(final Activity activity) {
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                if (hasActiveInternetConnection(activity)) {
                   
                          //  HelloEnternet(activity,message);
                                    Toast.makeText(activity, "have Internet", Toast.LENGTH_SHORT).show();


                      
                    

                } else {
                   
                          //  NoEnternet(activity,"No Internet");
                                 Toast.makeText(activity, "Don't have Internet", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onLost(Network network) {
                
                        Toast.makeText(activity, "I lost contact", Toast.LENGTH_SHORT).show();

                   


            }
        };

        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } else {
            NetworkRequest request = new NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build();
            connectivityManager.registerNetworkCallback(request, networkCallback);
        }


    }


    private static boolean hasActiveInternetConnection(final Activity context) {
        if (hasInternet(context)) {
            try {
                URL url = new URL("https://www.google.com");
                HttpURLConnection connection = (HttpURLConnection) (url).openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();
                return (connection.getResponseCode() == 200 );
            } catch (IOException e) {
                Log.e("TAG", "Error checking internet connection", e);
            }
        } else {
           
                    Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();

            
        }
        return false;
    }

    private static boolean hasInternet(Activity context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null;
    }

   public static int ashry(int a , int b ){
           return a+b ;
   }
    
    public static void ashry2(int a , int b ){
           int c = a+b ;
       Toast.makeText(context, ""+c, Toast.LENGTH_SHORT).show();

   }
 

}
