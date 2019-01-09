package net.spookygames.gdx.notificationsapp;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import net.spookygames.gdx.notifications.NotificationHandler;
import net.spookygames.gdx.notifications.NotificationParameters;

public class NotificationsApp extends ApplicationAdapter {
    public NotificationHandler handler;

    private Array<NotificationParameters> notificationParameters = new Array<NotificationParameters>();

    private Stage stage;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        final TextField titleTextField = new TextField("Notification", skin);
        titleTextField.setX(Gdx.graphics.getWidth() / 2f - titleTextField.getWidth() / 2f);
        titleTextField.setY(3 * Gdx.graphics.getHeight() / 4f - titleTextField.getHeight() / 2f);
        stage.addActor(titleTextField);

        final TextArea textTextArea = new TextArea("Lorem ipsum", skin);
        textTextArea.setX(Gdx.graphics.getWidth() / 2f - textTextArea.getWidth() / 2f);
        textTextArea.setY(2 * Gdx.graphics.getHeight() / 4f - textTextArea.getHeight() / 2f);
        stage.addActor(textTextArea);

        TextButton showNotificationButton = new TextButton("Show Notification", skin);
        showNotificationButton.setX(2 * Gdx.graphics.getWidth() / 3f - showNotificationButton.getWidth() / 2f);
        showNotificationButton.setY(Gdx.graphics.getHeight() / 4f - showNotificationButton.getHeight() / 2f);
        showNotificationButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                NotificationParameters parameters = new NotificationParameters(titleTextField.getText(), textTextArea.getText(), MathUtils.random(1000000));
                handler.showNotification(parameters);
                notificationParameters.add(parameters);
            }
        });
        stage.addActor(showNotificationButton);

        TextButton hideNotificationButton = new TextButton("Hide Notification", skin);
        hideNotificationButton.setX(Gdx.graphics.getWidth() / 3f - hideNotificationButton.getWidth() / 2f);
        hideNotificationButton.setY(Gdx.graphics.getHeight() / 4f - hideNotificationButton.getHeight() / 2f);
        hideNotificationButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (notificationParameters.size > 0) {
                    handler.hideNotification(notificationParameters.pop());
                }
            }
        });
        stage.addActor(hideNotificationButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
