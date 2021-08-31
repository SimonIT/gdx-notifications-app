package games.spooky.gdx.notificationsapp;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import games.spooky.gdx.notifications.desktop.DesktopNotificationHandler;
import games.spooky.gdx.notificationsapp.NotificationsApp;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        NotificationsApp app = new NotificationsApp();
        app.handler = new DesktopNotificationHandler();
        new LwjglApplication(app, config);
    }
}
