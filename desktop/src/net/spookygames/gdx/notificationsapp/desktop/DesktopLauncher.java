package net.spookygames.gdx.notificationsapp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.spookygames.gdx.notifications.desktop.DesktopNotificationHandler;
import net.spookygames.gdx.notificationsapp.NotificationsApp;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        NotificationsApp app = new NotificationsApp();
        app.handler = new DesktopNotificationHandler();
        new LwjglApplication(app, config);
    }
}
