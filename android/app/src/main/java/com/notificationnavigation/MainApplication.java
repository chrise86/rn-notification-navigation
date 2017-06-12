package com.notificationnavigation;

import android.support.annotation.Nullable;
import android.content.Context;
import android.os.Bundle;

import com.facebook.react.ReactPackage;
import com.reactnativenavigation.NavigationApplication;
import com.wix.reactnativenotifications.RNNotificationsPackage;

import com.wix.reactnativenotifications.core.JsIOHelper;
import com.wix.reactnativenotifications.core.AppLifecycleFacade;
import com.wix.reactnativenotifications.core.AppLaunchHelper;
import com.wix.reactnativenotifications.core.notification.INotificationsApplication;
import com.wix.reactnativenotifications.core.notification.IPushNotification;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends NavigationApplication implements INotificationsApplication {

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    private NotificationsLifecycleFacade notificationsLifecycleFacade;

    @Override
    public void onCreate() {
        super.onCreate();
        //...

        // Create an object of the custom facade impl
        notificationsLifecycleFacade = new NotificationsLifecycleFacade();
        // Attach it to react-native-navigation
        setActivityCallbacks(notificationsLifecycleFacade);
    }

    @Override
    public IPushNotification getPushNotification(Context context, Bundle bundle, AppLifecycleFacade defaultFacade, AppLaunchHelper defaultAppLaunchHelper) {
        return new AppPushNotification(
        	context,
        	bundle,
        	notificationsLifecycleFacade, // Instead of defaultFacade!!!
        	defaultAppLaunchHelper,
        	new JsIOHelper()
  		);
    }

    protected List<ReactPackage> getPackages() {
       // Add additional packages you require here
       // No need to add RnnPackage and MainReactPackage
       return Arrays.<ReactPackage>asList(
           // eg. new VectorIconsPackage()
           new RNNotificationsPackage(MainApplication.this)
       );
     }

    @Nullable
    @Override
    public List<ReactPackage> createAdditionalReactPackages() {
      return getPackages();
    }
}
