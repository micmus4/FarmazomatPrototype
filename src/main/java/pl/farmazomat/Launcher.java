package pl.farmazomat;

import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.farmazomat.cache.PanelCache;
import pl.farmazomat.util.PanelCreator;
import pl.farmazomat.view.LoginPanel;

import java.util.Optional;

/**
 * Application initializer.
 */
public class Launcher extends Application
{
    private static final Logger LOGGER = LogManager.getLogger( Launcher.class );

    private static final PanelCache panelCache = PanelCache.getPanelCache();

    public static void main( final String[] aArgs )
    {
        LOGGER.info( "Initializing application." );
        launch( aArgs );
    }

    @Override
    public void start( final Stage aStage )
    {
        showLoginPanel( aStage );
    }

    private void showLoginPanel( final Stage aStage )
    {
        final Optional< Stage > loginPanel = PanelCreator.createPanel( aStage, "/loginPanel.fxml",
                "Enter PIN", false, true );

        loginPanel.ifPresent( panel ->
        {
            panel.show();
            panelCache.put( LoginPanel.class, panel );
        });
    }
}