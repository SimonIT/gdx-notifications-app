package net.spookygames.gdx.notificationsapp;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import net.spookygames.gdx.notifications.android.AndroidNotificationHandler;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        NotificationsApp app = new NotificationsApp();
        app.handler = new AndroidNotificationHandler(this);
        ((AndroidNotificationHandler) app.handler).setIcon(R.drawable.andi);
        initialize(app, config);
    }
}
