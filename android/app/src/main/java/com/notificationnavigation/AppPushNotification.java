package com.notificationnavigation;

import android.content.Context;
import android.os.Bundle;

import com.wix.reactnativenotifications.core.JsIOHelper;
// import com.wix.reactnativenotifications.core.AppLifecycleFacade;
import com.wix.reactnativenotifications.core.AppLaunchHelper;
import com.wix.reactnativenotifications.core.notification.PushNotification;

public class AppPushNotification extends PushNotification {

    public AppPushNotification(Context context, Bundle bundle, NotificationsLifecycleFacade appLifecycleFacade, AppLaunchHelper appLaunchHelper, JsIOHelper jsIoHelper) {
        super(context, bundle, appLifecycleFacade, appLaunchHelper, jsIoHelper);
    }
}
