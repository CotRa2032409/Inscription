package com.example.inscription;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("User.csv"));


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
        ToggleGroup gender = new ToggleGroup();
        homme.setToggleGroup(gender);
        femme.setToggleGroup(gender);
        based.setToggleGroup(gender);
        milf.setToggleGroup(gender);
        epstein.setToggleGroup(gender);
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
        Label genderText = new Label("Genre");
        genderText.setTranslateY(240);
        genderText.setTranslateX(100);
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
                genderText, spinner, spinnerText, conditions, insc,
                effacer, retour);
        Scene inscription = new Scene(signIn);


        boutonConnect.setOnAction((ae) -> {
            String test = user.getText();
            if (!user.getText().isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] list = data.get(i).split(",");

                    if (list[i].equals(test)) {
                        break;

                    }
                }

            } else if (!password.getText().isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] list = data.get(i).split(",");
                    if (!list[i].equals(password.getText().hashCode())) {
                        connectionError.setTextFill(Color.RED);
                    }
                }
            }


        });

        boutonInscr.setOnAction((ae) -> {
            stage.setScene(inscription);
        });

        insc.setOnAction((ae) -> {
            Label misPrenom = new Label("Prénom manquant");
            Label misFamille = new Label("Nom de famille manquant");
            Label misUser = new Label("Nom d'utilisateur manquant");
            Label misPassword = new Label("Mot de passe manquant");
            Label samePassword = new Label("La confirmation et le mot de passe ne sont pas pareil");
            Label misGender = new Label("Choisissez un genre");
            Label misCond = new Label("Veuillez accepter les conditions d'utilisations");
            String genderDet = null;
            if (homme.isSelected())
                genderDet = "Homme";
            if (femme.isSelected())
                genderDet = "Femme";
            if (based.isSelected())
                genderDet = "Based";
            if (milf.isSelected())
                genderDet = "MILF";
            if (epstein.isSelected())
                genderDet = "Epstein";

            if (prenom.getText().equals("")) {
                misPrenom.setTextFill(Color.RED);
                misPrenom.setTranslateX(100);
                misPrenom.setTranslateY(435);
                signIn.getChildren().add(misPrenom);
            } else if (nomFamille.getText().isEmpty()) {
                misFamille.setTextFill(Color.RED);
                misFamille.setTranslateX(100);
                misFamille.setTranslateY(450);
                signIn.getChildren().add(misFamille);
            } else if (user2.getText().isEmpty()) {
                misUser.setTextFill(Color.RED);
                misUser.setTranslateY(465);
                misUser.setTranslateX(100);
                signIn.getChildren().add(misUser);
            } else if (password2.getText().isEmpty() || passConf.getText().isEmpty()) {
                misPassword.setTextFill(Color.RED);
                misPassword.setTranslateY(480);
                misPassword.setTranslateX(100);
                signIn.getChildren().add(misPassword);
            } else if (!password2.getText().equals(passConf.getText())) {
                samePassword.setTextFill(Color.RED);
                samePassword.setTranslateY(495);
                samePassword.setTranslateX(50);
                signIn.getChildren().add(samePassword);
            } else if (gender.getSelectedToggle() == null) {
                misGender.setTextFill(Color.RED);
                misGender.setTranslateX(100);
                misGender.setTranslateY(510);
                signIn.getChildren().add(misGender);
            } else if (!conditions.isSelected()) {
                misCond.setTextFill(Color.RED);
                misCond.setTranslateX(50);
                misCond.setTranslateY(525);
                signIn.getChildren().add(misCond);
            } else {
                data.add(prenom.getText() + "," + nomFamille.getText() + "," + user2.getText() + "," + passConf.getText().hashCode() +
                        "," + genderDet + "," + spinner.getValue());
                try {
                    Files.write(Paths.get("User.csv"), data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(connexion);
            }
        });

        effacer.setOnAction((ae) -> {
            prenom.clear();
            nomFamille.clear();
            user2.clear();
            password2.clear();
            passConf.clear();
            gender.selectToggle(milf);
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

