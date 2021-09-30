package com.example.inscription;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);
        stage.setHeight(500);
        stage.setWidth(350);

        TextField user = new TextField();
        user.setPromptText("Nom d'utilisateur");
        user.setTranslateX(100);
        user.setTranslateY(100);
        Label userText = new Label("Nom d'utilisateur");
        userText.setTranslateY(75);
        userText.setTranslateX(100);
        PasswordField password = new PasswordField();
        password.setPromptText("Mot de passe");
        password.setTranslateX(100);
        password.setTranslateY(150);
        Label passwordText = new Label("Mot de passe");
        passwordText.setTranslateX(100);
        passwordText.setTranslateY(125);
        Button boutonConnect = new Button();
        boutonConnect.setText("Se connecter");
        boutonConnect.setTranslateX(100);
        boutonConnect.setTranslateY(200);
        Button boutonInscr = new Button();
        boutonInscr.setText("S'inscrire");
        boutonInscr.setTranslateY(200);
        boutonInscr.setTranslateX(190);
        Label connectionError = new Label("La connexion a échouée");
        connectionError.setTextFill(Color.TRANSPARENT);
        connectionError.setTranslateY(235);
        connectionError.setTranslateX(100);

        TextField prenom = new TextField();
        prenom.setPromptText("Prénom");
        prenom.setTranslateY(25);
        prenom.setTranslateX(100);
        Label prenomText = new Label("Prénom");



        Group connectGroup = new Group(user, userText, password, passwordText, boutonConnect, boutonInscr, connectionError);
        Scene connexion = new Scene(connectGroup);

        Group loadingScreen = new Group();
        Scene chargement = new Scene(loadingScreen);

        Group signIn = new Group(prenom);
        Scene inscription = new Scene(signIn);

        boutonConnect.setOnAction((ae) -> connectionError.textFillProperty().set(Color.RED));

        boutonInscr.setOnAction((ae) -> {
            stage.setScene(inscription);

        });

        stage.setScene(connexion);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}

