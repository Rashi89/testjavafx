package pl.agatarachanska;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(loadFXML("weatherApp"));
        stage.setScene(scene);
        stage.setMinWidth(1000.00);
        stage.setMinHeight(720.00);
        stage.setTitle("Weather");
        stage.getScene().getStylesheets().addAll(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        fxmlLoader.setResources(bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
