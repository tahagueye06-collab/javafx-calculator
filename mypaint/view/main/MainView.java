package be.kdg.mypaint.view.main;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import static be.kdg.mypaint.view.Constants.*;

public class MainView extends BorderPane {

    private Label lblStatus;
    private Canvas canvas;

    private MenuItem miAbout;
    private Slider slPensize;
    private ColorPicker colorPicker;
    private Button btnUndo;
    private Button btnClear;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }


    private void initialiseNodes() {
        lblStatus = new Label("x:  ...        y:  ...");
        canvas = new Canvas(500, 500);
        miAbout = new MenuItem("About");

        slPensize = new Slider(0, 20, 5);
        slPensize.setSnapToTicks(true);
        slPensize.setMajorTickUnit(5);
        slPensize.setShowTickLabels(true);
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);
        btnClear = new Button("Clear");
        btnUndo = new Button("Undo");
    }


    private void layoutNodes() {
        super.setCenter(canvas);
        super.setBottom(lblStatus);  //OP de center moet je canvas komnen
        //Menu opbouwen:

        Menu mnHelp = new Menu("Help");
        mnHelp.getItems().addAll(miAbout);
        MenuBar menuBar = new MenuBar(mnHelp);
        super.setTop(menuBar);

        //Linker toolbox opbouwen:
        Label lblPensize = new Label("Pendikte");
        lblPensize.setPrefWidth(LABEL_WIDTH);
        slPensize.setPrefWidth(CONTROLS_WIDTH);
        HBox hb1 = new HBox(lblPensize, slPensize);  // in hier ziet d elabel en de slider in

        Label lblColor = new Label("Kleur");
        lblColor.setPrefWidth(LABEL_WIDTH);
        HBox hb2 = new HBox(lblColor, colorPicker); // hier zit weer een label een een color picker

        btnUndo.setPrefWidth(LABEL_WIDTH);
        btnClear.setPrefWidth(LABEL_WIDTH);
        HBox hb3 = new HBox(btnUndo, btnClear);  // 2 knopjes en wat spatie ertussen
        hb3.setSpacing(45);

        VBox toolBox = new VBox(hb1, hb2, hb3);  // je zet al die hb verticaal onder elkaar vbox  vraagt dus wat je verticaal onder elkaar moet plaatsen
        toolBox.setSpacing(DEFAULT_MARGIN);
        super.setLeft(toolBox);    // hier zeg je dat al die hb's aan de linker kant moeten zetten van je borderpane

        BorderPane.setMargin(toolBox, new Insets(DEFAULT_MARGIN));
        BorderPane.setMargin(lblStatus, new Insets(DEFAULT_MARGIN));
    }

    public Label getLblStatus() {
        return lblStatus;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public MenuItem getMiAbout() {
        return miAbout;
    }

    public Slider getSlPensize() {
        return slPensize;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public Button getBtnUndo() {
        return btnUndo;
    }

    public Button getBtnClear() {
        return btnClear;
    }
}
