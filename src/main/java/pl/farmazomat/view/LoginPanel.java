package pl.farmazomat.view;

import com.google.common.collect.Maps;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import pl.farmazomat.cache.PanelCache;
import pl.farmazomat.model.CustomerAccount;
import pl.farmazomat.util.PanelCreator;

import java.util.Map;
import java.util.Optional;

/**
 * Controller for Login Panel.
 */
@NoArgsConstructor
public class LoginPanel
{
    @FXML
    private TextField cardNumberField;

    @FXML
    private PasswordField pinField;

    @FXML
    private Label errorLabel;

    private Map< String, CustomerAccount > accounts;

    private final PanelCache panelCache = PanelCache.getPanelCache();

    public void initialize()
    {
        // for prototype purpose, we create one account to test login.
        accounts = Maps.newHashMap();
        accounts.put( "123456789", new CustomerAccount("123456789", "1234", 500D, null) );
    }

    public void onLogin()
    {
        final String cardNumberFromInput = cardNumberField.getText();
        final String pinFromInput = pinField.getText();

        if( accounts.containsKey( cardNumberFromInput ) &&
                accounts.get( cardNumberFromInput ).getPin().equals( pinFromInput ) )
        {
            final Optional< Stage > mainPanel = PanelCreator.createPanel( "/mainPanel.fxml",
                    "Bank", false, false );

            mainPanel.ifPresent( panel ->
            {
                panel.show();
                panelCache.put( MainPanel.class, panel );
                panelCache.get( LoginPanel.class ).hide();
            });
        }
        else
        {
            errorLabel.setText( "Login failed." );
            errorLabel.setVisible( true );
        }
    }
}
