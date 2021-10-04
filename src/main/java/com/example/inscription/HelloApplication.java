package com.example.inscription;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        List<String> data2 = Files.readAllLines(Paths.get("User.csv"));


        stage.setResizable(false);
        stage.setHeight(700);
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
        prenomText.setTranslateX(100);
        prenomText.setTranslateY(10);
        TextField nomFamille = new TextField();
        nomFamille.setPromptText("Nom de famille");
        nomFamille.setTranslateX(100);
        nomFamille.setTranslateY(70);
        Label nomFamilleText = new Label("Nom de famille");
        nomFamilleText.setTranslateY(55);
        nomFamilleText.setTranslateX(100);
        TextField user2 = new TextField();
        user2.setPromptText("Nom d'utilisateur");
        user2.setTranslateX(100);
        user2.setTranslateY(115);
        Label userText2 = new Label("Nom d'utilisateur");
        userText2.setTranslateY(100);
        userText2.setTranslateX(100);
        PasswordField password2 = new PasswordField();
        password2.setPromptText("Mot de passe");
        password2.setTranslateX(100);
        password2.setTranslateY(165);
        Label passwordText2 = new Label("Mot de passe");
        passwordText2.setTranslateX(100);
        passwordText2.setTranslateY(150);
        Label passConfText = new Label("Confirmer le mot de passe");
        passConfText.setTranslateX(100);
        passConfText.setTranslateY(195);
        PasswordField passConf = new PasswordField();
        passConf.setPromptText("Mot de passe");
        passConf.setTranslateX(100);
        passConf.setTranslateY(210);
        RadioButton homme = new RadioButton("Sigma male");
        RadioButton femme = new RadioButton("Wiman");
        RadioButton based = new RadioButton("Based");
        RadioButton milf = new RadioButton("MILF");
        RadioButton epstein = new RadioButton("Epstein");
        ToggleGroup genre = new ToggleGroup();
        homme.setToggleGroup(genre);
        femme.setToggleGroup(genre);
        based.setToggleGroup(genre);
        milf.setToggleGroup(genre);
        epstein.setToggleGroup(genre);
        homme.setTranslateX(80);
        homme.setTranslateY(255);
        femme.setTranslateX(170);
        femme.setTranslateY(255);
        based.setTranslateY(255);
        based.setTranslateX(240);
        milf.setTranslateX(80);
        milf.setTranslateY(270);
        epstein.setTranslateY(270);
        epstein.setTranslateX(170);
        Label gender = new Label("Genre");
        gender.setTranslateY(240);
        gender.setTranslateX(100);
        Spinner spinner = new Spinner(0, 5000, 18);
        spinner.setEditable(true);
        spinner.setTranslateX(100);
        spinner.setTranslateY(300);
        Label spinnerText = new Label("Âge");
        spinnerText.setTranslateX(100);
        spinnerText.setTranslateY(285);
        CheckBox conditions = new CheckBox("J'accepte les conditions d'utilisations");
        conditions.setTranslateX(100);
        conditions.setTranslateY(345);
        Button insc = new Button("S'inscrire");
        insc.setTranslateX(100);
        insc.setTranslateY(390);
        Button effacer = new Button("Effacer");
        effacer.setTranslateY(390);
        effacer.setTranslateX(170);
        Button retour = new Button("Retour");
        retour.setTranslateX(240);
        retour.setTranslateY(390);

        Group connectGroup = new Group(user, userText, password, passwordText, boutonConnect,
                boutonInscr, connectionError);
        Scene connexion = new Scene(connectGroup);

        Group loadingScreen = new Group();
        Scene chargement = new Scene(loadingScreen);

        Group signIn = new Group(prenom, prenomText, nomFamille, nomFamilleText,
                user2, userText2, password2, passwordText2, passConf,
                passConfText, homme, femme, based, milf, epstein,
                gender, spinner, spinnerText, conditions, insc,
                effacer, retour);
        Scene inscription = new Scene(signIn);


        boutonConnect.setOnAction((ae) -> {

            connectionError.textFillProperty().set(Color.RED);

        });

        boutonInscr.setOnAction((ae) -> {
            stage.setScene(inscription);
        });

        insc.setOnAction((ae) -> {
            Label misPrenom = new Label("Prénom manquant");
            Label misPassword = new Label("Mot de passe manquant");
            data2.add(prenom.getText() + ", " + nomFamille.getText() + ", " + user2.getText() + ", " + passConf.getText() +
                    ", " + genre.getSelectedToggle().toString() + ", " + spinner.getValue());
            try {
                Files.write(Paths.get("User.csv"), data2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (prenom.getText().equals("")) {
                misPrenom.setTextFill(Color.RED);
                misPrenom.setTranslateX(100);
                misPrenom.setTranslateY(435);
                signIn.getChildren().add(misPrenom);
            }
            //else if ()
            if (password2.getText().equals("") || passConf.getText().equals("")) {
                misPassword.setTextFill(Color.RED);
                misPassword.setTranslateY(450);
                misPassword.setTranslateX(100);
                signIn.getChildren().add(misPassword);
            }

        });

        effacer.setOnAction((ae) -> {
            prenom.clear();
            nomFamille.clear();
            user2.clear();
            password2.clear();
            passConf.clear();
            genre.selectToggle(milf);
            spinner.getValueFactory().setValue(18);
            conditions.setSelected(false);
        });

        retour.setOnAction((ae) -> stage.setScene(connexion));


        //Idée : Fichier de conditions d'utilisations avec du texte random d'écrit dedans

        stage.setScene(connexion);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}

