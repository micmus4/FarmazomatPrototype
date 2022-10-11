package pl.farmazomat.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.farmazomat.Launcher;
import pl.farmazomat.view.Panel;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Utility class to create panels.
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE ) // util class.
public class PanelCreator
{
    private static final Logger LOGGER = LogManager.getLogger( PanelCreator.class );

    public static Optional< Panel > createPanel( final Panel aPanel, final String aFXMLFilePath, final String aPanelName,
                                                final boolean aResizable, final boolean aExitOnException )
    {
        LOGGER.info( "Creating new panel..." );
        Parent root;
        try
        {
            final URL urlToFXML = Launcher.class.getResource( aFXMLFilePath );
            requireNonNull( urlToFXML );
            root = FXMLLoader.load(  urlToFXML );
            requireNonNull( root );
            LOGGER.info( aFXMLFilePath + " loaded to Panel." );
        }
        catch (IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Panel from " + aFXMLFilePath + "." );
            if( aExitOnException )
            {
                System.exit( 1 );
            }
            return Optional.empty();
        }

        aPanel.setTitle( aPanelName );
        aPanel.setResizable( aResizable );

        Scene loginScene = new Scene( root );
        aPanel.setScene( loginScene );

        return Optional.of( aPanel );
    }

    public static Optional<Panel> createPanel(final String aFXMLFilePath, final String aPanelName,
                                              final boolean aResizable, final boolean aExitOnException )
    {
        return createPanel( new Panel(), aFXMLFilePath, aPanelName, aResizable, aExitOnException );
    }
}
