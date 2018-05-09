package com.jfx.dev.downloader.controller.mainConfigure;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfx.dev.downloader.view.mainConfigure.MainConfigure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;

public class MainConfigureControl implements Initializable {

	private String fxmlName = "../../fxml/mainConfigure/" + MainConfigure.class.getSimpleName() + ".fxml";

	@FXML
	Button operateBtn;

	@FXML
	ComboBox<displaySize> cbBox;

	private int mainViewWidth = 0;

	private int mainViewHeight = 0;

	public Button getBtn() {
		return operateBtn;
	}

	public void setBtn(Button btn) {
		this.operateBtn = btn;
	}

	public ComboBox<displaySize> getCbBox() {
		return cbBox;
	}

	public void setCbBox(ComboBox<displaySize> cbBox) {
		this.cbBox = cbBox;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<displaySize> list = FXCollections.observableArrayList(displaySize.values());
		this.cbBox.getItems().addAll(list);
	}

	public void onClickOperateBtn(ActionEvent event) {
		if (this.mainViewHeight == 0 || this.mainViewHeight == 0) {
			Alert alr = new Alert(AlertType.ERROR);
			alr.setHeaderText("warning!!!");
			alr.setContentText("select display size first!");
			alr.show();
		} else {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onChangeDisplaySize(ActionEvent event) {
		String size = this.cbBox.getValue().name();
		if (size.equals(displaySize.SMALL.name())) {
			this.mainViewWidth = 640;
			this.mainViewHeight = 480;
		} else if (size.equals(displaySize.MEDIUM.name())) {
			this.mainViewWidth = 800;
			this.mainViewHeight = 600;
		} else if (size.equals(displaySize.LARGE.name())) {
			this.mainViewWidth = 1280;
			this.mainViewHeight = 720;
		} else if (size.equals(displaySize.FULL.name())) {
			this.mainViewWidth = 1920;
			this.mainViewHeight = 1080;
		}
	}

	private void showMainMenu() {
		try {
			Parent mainMenuRoot = FXMLLoader.load(getClass().getResource(fxmlName));
			AnchorPane mainConfigureRoot = (AnchorPane) operateBtn.getScene().getRoot();
			mainConfigureRoot.getChildren().add(mainMenuRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public enum displaySize {
		SMALL, MEDIUM, LARGE, FULL;
	}

}
