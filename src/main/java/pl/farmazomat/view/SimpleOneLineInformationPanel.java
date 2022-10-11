package pl.farmazomat.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.NoArgsConstructor;
import pl.farmazomat.cache.PanelCache;

@NoArgsConstructor
public class SimpleOneLineInformationPanel
{
    @FXML
    private Label moneyInformationLabel;

    public void initialize()
    {
        PanelCache panelCache = PanelCache.getPanelCache();

        Platform.runLater( () -> {
            final Panel thizPanel = panelCache.get( getClass() );
            final String info = thizPanel.getPanelParameter( "information", String.class );
            moneyInformationLabel.setText( info );
        });
    }
}
