package pl.farmazomat.view;

import com.google.common.collect.Maps;
import javafx.stage.Stage;

import java.util.Map;

/**
 * Panel.
 */
public class Panel extends Stage
{
    private final Map< String, Object > parameters;

    public Panel()
    {
        super();
        parameters = Maps.newHashMap();
    }

    public void setPanelParameter( final String aParamKey, final Object aParamValue )
    {
        parameters.put( aParamKey, aParamValue );
    }

    public Object getPanelParameter( final String aParamKey )
    {
        return parameters.get( aParamKey );
    }

    public < T > T getPanelParameter( final String aParamKey, final Class< T > aClassToCast )
    {
        return aClassToCast.cast( getPanelParameter( aParamKey ) );
    }
 }
