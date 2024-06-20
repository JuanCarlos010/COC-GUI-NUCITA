package com.example.clashofclansgui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloController {
    //Music
    File file = new File("C:\\Users\\jcrom\\Desktop\\ClashOfClansGUI\\src\\main\\resources\\music\\Lore (online-audio-converter.com).wav");
    AudioInputStream aui = AudioSystem.getAudioInputStream(file);
    Clip clip;
    {
        try {
            clip = AudioSystem.getClip();
            clip.open(aui);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    //Labels
    @FXML
    private Label lblBienvenida;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblHistoria1;
    @FXML
    private Label lblHistoria2;
    @FXML
    private Label lblHistoria3;
    @FXML
    private Label lblHistoria4;
    @FXML
    private Label lblHistoria5;
    @FXML
    private Label lblHistoria6;
    @FXML
    private Label lblHistoria7;
    @FXML
    private Label lblHistoria8;

    //HBOX
    @FXML
    private HBox hboxMenuTienda;
    @FXML
    private HBox hboxMenuTropas;
    //PANE
    @FXML
    private Pane MenuPrincipal;
    @FXML
    private Pane Juego;
    @FXML
    private Pane PaneCreditos;
    @FXML
    private Pane paneInicio;
    @FXML
    private Pane opciones;
    @FXML
    private Pane Historia;
    //RADIOBUTTON
    @FXML
    private RadioButton sexoM;
    @FXML
    private RadioButton sexoF;
    //TEXTFIELD
    @FXML
    private TextField txtfieldNombreUsuario;
    //BUTTON
    @FXML
    private Button btnLore1;
    @FXML
    private Button btnLore2;
    @FXML
    private Button btnLore3;
    @FXML
    private Button btnLore4;
    @FXML
    private Button btnLore5;
    @FXML
    private Button btnLore6;
    @FXML
    private Button btnLore7;
    //TabPane
    @FXML
    private TabPane TPTienda;
    @FXML
    private TabPane TPTropas;

    public HelloController() throws UnsupportedAudioFileException, IOException {
    }


    @FXML
    private void cerrarAplicacion() {
        System.exit(0);
    }

    @FXML
    protected void Iniciar() {
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        Alert alert2 = new Alert(Alert.AlertType.ERROR);

        if (Objects.equals(sexoM.isSelected(), false)
                && Objects.equals(sexoF.isSelected(), false)
                && Objects.equals(txtfieldNombreUsuario.getText(), "")) {
            alert2.setTitle("Error");
            alert2.setHeaderText(null);
            alert2.setContentText("Necesita ingresar datos");
            alert2.showAndWait();
        } else if (txtfieldNombreUsuario.getText() == null || Objects.equals(txtfieldNombreUsuario.getText(), "")) {
            alert1.setTitle("Advertencia");
            alert1.setHeaderText(null);
            alert1.setContentText("Necesita ingresar un nombre");
            alert1.showAndWait();
        } else if (Objects.equals(sexoM.isSelected(), false)
                && Objects.equals(sexoF.isSelected(), false)) {
            alert1.setTitle("Advertencia");
            alert1.setHeaderText(null);
            alert1.setContentText("Necesita seleccionar el sexo");
            alert1.showAndWait();
        } else {
            paneInicio.setVisible(false);
            MenuPrincipal.setVisible(true);
            String nombre = txtfieldNombreUsuario.getText();
            if (sexoF.isSelected()) {
                lblBienvenida.setText("BIENVENIDA");
            } else if (sexoM.isSelected()) {
                lblBienvenida.setText("BIENVENIDO");
            }

            lblNombre.setText(nombre);
        }
    }


    @FXML
    protected void IniciarJuego() {
        MenuPrincipal.setVisible(false);
        Juego.setVisible(true);
    }

    @FXML
    protected void AbrirTienda() {
        if (TPTienda.isVisible() || TPTropas.isVisible() || opciones.isVisible()) {
            TPTienda.setVisible(true);
            TPTropas.setVisible(false);
            opciones.setVisible(false);
        } else {
            TPTienda.setVisible(true);
        }
    }

    @FXML
    protected void CerrarTienda() {
        TPTienda.setVisible(false);
    }

    @FXML
    protected void AbrirCuartel() {
        if (TPTienda.isVisible() || TPTropas.isVisible() || opciones.isVisible()) {
            TPTienda.setVisible(false);
            opciones.setVisible(false);
            TPTropas.setVisible(true);
        } else {
            TPTropas.setVisible(true);
        }
    }

    @FXML
    protected void CerrarCuartel() {
        TPTropas.setVisible(false);
    }

    @FXML
    protected void AbrirCreditos() {
        PaneCreditos.setVisible(true);
    }

    @FXML
    protected void CerrarCreditos() {
        PaneCreditos.setVisible(false);
    }

    @FXML
    protected void AbrirOpciones() {
        opciones.setVisible(true);

        if ((TPTienda.isVisible() || TPTropas.isVisible())
                || (TPTienda.isVisible() && TPTropas.isVisible())) {
            TPTienda.setVisible(false);
            TPTropas.setVisible(false);
            opciones.setVisible(true);
        } else {
            opciones.setVisible(true);
        }
    }

    @FXML
    protected void CerrarOpciones() {
        opciones.setVisible(false);
    }

    @FXML
    protected void CerrarJuego() {
        MenuPrincipal.setVisible(true);
        Juego.setVisible(false);
    }

    @FXML
    protected void selectorSexoM() {
        if (sexoM.isSelected() || sexoF.isSelected()) {
            sexoM.setSelected(true);
            sexoF.setSelected(false);
        }
    }

    @FXML
    protected void selectorSexoF() {
        if (sexoM.isSelected() || sexoF.isSelected()) {
            sexoM.setSelected(false);
            sexoF.setSelected(true);
        }
    }

    @FXML
    protected void Historia() {
        MenuPrincipal.setVisible(false);
        Historia.setVisible(true);

        lblHistoria1.setText("Era un día tranquilo, y decidiste crear una aldea en busca de gloria.");
        clip.loop(10);
        clip.setFramePosition(0);
    }

    @FXML
    protected void contarHistoria1() {
        lblHistoria1.setVisible(false);
        lblHistoria2.setVisible(true);
        if (sexoF.isSelected()) {
            lblHistoria2.setText("La joven " + txtfieldNombreUsuario.getText() + ", llena de determinación, " +
                    "se preparó para su travesía: crear la aldea más fuerte y segura de todas.");
        } else if (sexoM.isSelected()) {
            lblHistoria2.setText("El joven " + txtfieldNombreUsuario.getText() + ", lleno de determinación, " +
                    "se preparó para su travesía: crear la aldea más fuerte y segura de todas.");
        }

        btnLore1.setVisible(false);
        btnLore2.setVisible(true);
    }

    @FXML
    protected void contarHistoria2() {
        lblHistoria2.setVisible(false);
        lblHistoria3.setVisible(true);
        lblHistoria3.setText("Para lograrlo, primero necesitaba recursos. Con su capital semilla, decidió construir el ayuntamiento y una mina de oro.");
        btnLore2.setVisible(false);
        btnLore3.setVisible(true);
    }


    @FXML
    protected void contarHistoria3() {
        lblHistoria3.setVisible(false);
        lblHistoria4.setVisible(true);
        if (sexoF.isSelected()) {
            lblHistoria4.setText((txtfieldNombreUsuario.getText() + " tomó una profunda respiración, sabiendo que cada decisión la acercaría más a su destino."));
        } else if (sexoM.isSelected()) {
            lblHistoria4.setText((txtfieldNombreUsuario.getText() + " tomó una profunda respiración, sabiendo que cada decisión lo acercaría más a su destino."));
        }
        btnLore3.setVisible(false);
        btnLore4.setVisible(true);
    }

    @FXML
    protected void contarHistoria4() {
        lblHistoria4.setVisible(false);
        lblHistoria5.setVisible(true);
        lblHistoria5.setText("De repente, un ataque sorpresa de un clan de duendes irrumpió en la aldea, robando todo a su paso...");
        btnLore4.setVisible(false);
        btnLore5.setVisible(true);
    }

    @FXML
    protected void contarHistoria5() {
        lblHistoria5.setVisible(false);
        lblHistoria6.setVisible(true);
        lblHistoria6.setText("Pero tú, " + txtfieldNombreUsuario.getText() + ", no permitirás que esto quede así.");
        btnLore5.setVisible(false);
        btnLore6.setVisible(true);
    }

    @FXML
    protected void contarHistoria6() {
        lblHistoria6.setVisible(false);
        lblHistoria7.setVisible(true);
        lblHistoria7.setText("Afortunadamente, aliados valientes se unen a tu causa, entregándote tu primer ejército para asaltar a los duendes y recuperar lo perdido.");
        btnLore6.setVisible(false);
        btnLore7.setVisible(true);
    }

    @FXML
    protected void contarHistoria7() {
        lblHistoria7.setVisible(false);
        lblHistoria8.setVisible(true);
        lblHistoria8.setText("Y así comienza nuestra épica aventura, la leyenda de los choques de clanes, donde el valor y la estrategia decidirán el destino de tu aldea.");
        btnLore7.setVisible(false);
    }


    @FXML
    protected void volverJuego() {
        //cerramos el pane de historia y abrimos el pane del menu principal
        Historia.setVisible(false);
        MenuPrincipal.setVisible(true);

        //Cerramos todos los labels de historia abiertos y/o cerrados
        lblHistoria1.setVisible(false);
        lblHistoria2.setVisible(false);
        lblHistoria3.setVisible(false);
        lblHistoria4.setVisible(false);
        lblHistoria5.setVisible(false);
        lblHistoria6.setVisible(false);
        lblHistoria7.setVisible(false);
        lblHistoria8.setVisible(false);

        //Abrimos los objetos que se abren con el pane de historia
        lblHistoria1.setVisible(true);
        btnLore1.setVisible(true);
        //Detenemos la musica
        clip.stop();
    }
}