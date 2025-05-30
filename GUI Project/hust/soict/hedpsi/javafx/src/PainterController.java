import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ToggleGroup;
public class PainterController 
{
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penButton;
    @FXML
    private RadioButton eraserButton;
    private ToggleGroup toolGroup;
    private static final double BRUSH_RADIUS = 5;
    @FXML
    private void initialize()
     {
        toolGroup = new ToggleGroup();
        penButton.setToggleGroup(toolGroup);
        eraserButton.setToggleGroup(toolGroup);
    }
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) 
    {
        RadioButton selectedTool = (RadioButton) toolGroup.getSelectedToggle();
        if (selectedTool == null) return;
        String tool = selectedTool.getText().toLowerCase();

        if (tool.equals("pen")) 
        {
            Circle circle = new Circle(event.getX(), event.getY(), 3, Color.BLACK);
            drawingAreaPane.getChildren().add(circle);
        }
        else if (tool.equals("eraser")) 
        {
            drawingAreaPane.getChildren().removeIf(node -> {
                if (node instanceof Circle) 
                {
                    Circle c = (Circle) node;
                    double dx = c.getCenterX() - event.getX();
                    double dy = c.getCenterY() - event.getY();
                    return Math.sqrt(dx * dx + dy * dy) < BRUSH_RADIUS;
                }
                return false;
            });
        }
    }
    @FXML
    private void clearButtonPressed() 
    {
        drawingAreaPane.getChildren().clear();
    }
}
