package pl.farmazomat.cache;

import com.google.common.collect.Maps;
import javafx.stage.Stage;
import pl.farmazomat.view.Panel;

import java.util.Map;

public final class PanelCache
{
    private static final PanelCache INSTANCE = new PanelCache();

    private final Map< Class< ? >, Panel > cache;

    private PanelCache()
    {
        cache = Maps.newHashMap();
    }

    public static PanelCache getPanelCache()
    {
        return INSTANCE;
    }

    public void put( final Class< ? > aControllerClass, final Panel aPanel )
    {
        cache.put( aControllerClass, aPanel );
    }

    public Panel get( final Class< ? > aControllerClass )
    {
        return cache.get( aControllerClass );
    }
}
