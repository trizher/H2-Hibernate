package aed;

import aed.hibernate.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HibernateApp extends Application {

	private static Stage primaryStage;
	
	private MainController mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainController = new MainController();
		HibernateApp.primaryStage = primaryStage;

		primaryStage.setTitle("Hibernate");
		primaryStage.setScene(new Scene(mainController.getView()));
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);

	}
}
