package be.kdg.mypaint.view.main;

import be.kdg.mypaint.model.PaintModel;
import be.kdg.mypaint.model.Point;
import be.kdg.mypaint.view.about.AboutPresenter;
import be.kdg.mypaint.view.about.AboutView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.List;
import java.util.Optional;

public class MainPresenter {
    private PaintModel model;
    private MainView view;

    public MainPresenter(PaintModel model, MainView view) {
        this.model = model;
        this.view = view;
        addEventhandlers();
        updateView();
    }

    private void updateView() {
        List<Point> points = model.getPoints();  //je haalt al je points op je steekt die in de tiijdelijke lijst
        GraphicsContext gc = view.getCanvas().getGraphicsContext2D();
        gc.setFill(Color.WHITE); // hier maak je terug een blanco canvas
        gc.fillRect(0, 0, view.getCanvas().getWidth(), view.getCanvas().getHeight());
        for (Point point : points) {  // hier zeg je pak alle punten in de point lijst en begin maar te tekenenn
            gc.setFill(point.getCOLOR());
            gc.fillOval(point.getX(), point.getY(), point.getPENSIZE(), point.getPENSIZE());
        }
    }

    private void addEventhandlers() {
        view.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>() {  // IN DE vieuw heb je een getcanvas  geeft de canvas terug als je met de muis beweegt op de canvas dan gaat hem een mouse event moeten doen
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getLblStatus().setText(String.format("x:%6.0f     y:%6.0f",  // op die moment gaan we een lblstatus nemen door die labelstatus kan je de tekst instellen
                        mouseEvent.getX(), mouseEvent.getY())); // dit zegt gewoon waar je positie van de mouse is
            }
        });
        view.getCanvas().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.addPoint(new Point((int) mouseEvent.getX(), (int) mouseEvent.getY(), (int) view.getSlPensize().getValue(),
                        view.getColorPicker().getValue()));
                //model.setSaved(false);
                updateView();
            }
        });


        view.getBtnClear().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.clear();  // model staat voor paint model in die methode clear maken we de arraylist leeg
                updateView();
            }
        });

        view.getBtnUndo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.undoLast();   // uit je model neem je de methode undo last en haal je de laaste point dat je hebt getekent der uit te halen
                // model.setSaved(false);
                updateView();
            }
        });

        view.getMiAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutView aboutView = new AboutView();
                AboutPresenter aboutPresenter = new AboutPresenter(aboutView, model);
                Stage aboutStage = new Stage();
                aboutStage.initOwner(view.getScene().getWindow());
                aboutStage.initModality(Modality.APPLICATION_MODAL);
                aboutStage.setScene(new Scene(aboutView));
                aboutStage.setResizable(false);
                aboutStage.initStyle(StageStyle.UNDECORATED);
                aboutStage.showAndWait();
            }
        });
    }


    // ik moest die methode niet in de eventhandeler methode doen

    public void addWindowEvents() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                //if(!model.isSaved()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Einde programma");
                alert.setHeaderText("Je eindigt zonder je tekening te bewaren");
                alert.setContentText("Ben je wel zeker?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                } else {
                    windowEvent.consume();
                }
                // }
            }
        });

    }}






