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

    public static Optional< Stage > createPanel(final Stage aStage, final String aFXMLFilePath, final String aPanelName,
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

        aStage.setTitle( aPanelName );
        aStage.setResizable( aResizable );

        Scene loginScene = new Scene( root );
        aStage.setScene( loginScene );

        return Optional.of( aStage );
    }

    public static Optional< Stage > createPanel( final String aFXMLFilePath, final String aPanelName,
                                                 final boolean aResizable, final boolean aExitOnException )
    {
        return createPanel( new Stage(), aFXMLFilePath, aPanelName, aResizable, aExitOnException );
    }
}
