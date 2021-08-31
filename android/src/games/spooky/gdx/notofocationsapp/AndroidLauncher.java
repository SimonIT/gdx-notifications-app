package games.spooky.gdx.notofocationsapp;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import games.spooky.gdx.notifications.android.AndroidNotificationHandler;
import games.spooky.gdx.notificationsapp.NotificationsApp;
import games.spooky.gdx.notificationsapp.R;

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
