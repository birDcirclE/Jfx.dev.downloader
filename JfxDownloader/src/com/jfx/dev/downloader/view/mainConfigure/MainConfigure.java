package com.jfx.dev.downloader.view.mainConfigure;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainConfigure extends Application {
	
	private Stage stage;
	private String fxmlName = "../../fxml/mainConfigure/" + MainConfigure.class.getSimpleName() + ".fxml";
	private final String title = "JavaFX Downloader"; 
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		this.initLayout();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void initLayout() {
		try {
			Parent MainConfigureRoot = FXMLLoader.load(getClass().getResource(fxmlName));
			Scene scene = new Scene(MainConfigureRoot);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle(title);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
