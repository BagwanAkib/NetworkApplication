# Check internet state in android

There is two way what i mentioned in this git repository, are as follows:

> **Broadcast**



With broadcast you can get realtime state of your device network.


```java

private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            /* previous way of doing it*/
            NetworkInfo ni = null;
            if (manager != null) {
                ni = manager.getActiveNetworkInfo();
            }
            if (ni != null && ni.isConnected()) {
                networkAvailable();
            } else {
                networkUnavailable();
            }
        }
    };
```

whenever you required to use it you can register this receiver
```java
registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
```

* You also can create an singleton boolean object that can access throw out all application.

```java

public class App extends Application {

    public static boolean isConnected;

    private NetworkBroadcastReceiver networkStateReceiver = new NetworkBroadcastReceiver();

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterReceiver(networkStateReceiver);
    }
}
```
while checking is connected or not just use as follows:
This will be accessible from entire app module.
```java

    if(App.isConnected){
        //Internet is on    
    } else {
        //Internet is off
    }
```


> **Manually check is internet is connect**

bellow function will return `true` if internet is connected `false` if internet is not connected.
```java
    public boolean checkInternet() {
        ConnectivityManager manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        /* previous way of doing it*/
        NetworkInfo ni = null;
        if (manager != null) {
            ni = manager.getActiveNetworkInfo();
        }
        return (ni != null && ni.isConnected());
    }
```



