package pl.farmazomat.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.NoArgsConstructor;
import pl.farmazomat.cache.PanelCache;
import pl.farmazomat.model.CustomerAccount;
import pl.farmazomat.util.PanelCreator;

import java.util.Optional;

import static java.lang.Double.parseDouble;
import static javafx.application.Platform.runLater;

@NoArgsConstructor
public class MainPanel
{
    @FXML
    private Button inspectMoneyButton;

    @FXML
    private TextField moneyToPayInField;

    private CustomerAccount customerAccount;

    private PanelCache panelCache;

    private Panel thizPanel;

    public void initialize()
    {
        panelCache = PanelCache.getPanelCache();
        runLater( () -> {
            thizPanel = panelCache.get( getClass() );
            customerAccount = thizPanel.getPanelParameter( "account",
                    CustomerAccount.class );
        } );
    }

    public void onInspectMoneyButtonClicked()
    {
        final Optional< Panel > inspectMoneyPanel =
                PanelCreator.createPanel("/simpleOneLineInformationPanel.fxml", "Your money",
                        false, false );

        inspectMoneyPanel.ifPresent( panel -> {
            panelCache.put( SimpleOneLineInformationPanel.class, panel );
            panel.setPanelParameter( "information", "Your money: " + customerAccount.getMoney() );
            panel.show();
        } );
    }

    public void onPayInButtonClicked()
    {
        double moneyToPayIn;
        try
        {
            moneyToPayIn = parseDouble( moneyToPayInField.getText() );
            customerAccount.transferMoneyToAccount( moneyToPayIn );
        }
        catch ( final Exception aAnyException )
        {
            final Optional< Panel > inspectMoneyPanel =
                    PanelCreator.createPanel("/simpleOneLineInformationPanel.fxml", "Error",
                            false, false );

            inspectMoneyPanel.ifPresent( panel -> {
                panelCache.put( SimpleOneLineInformationPanel.class, panel );
                panel.setPanelParameter( "information", "Error! Wrong value passed!" );
                panel.show();
            } );
            return;
        }

        final Optional< Panel > payInPanel =
                PanelCreator.createPanel("/simpleOneLineInformationPanel.fxml", "Transfer successful",
                        false, false );

        payInPanel.ifPresent( panel -> {
            panelCache.put( SimpleOneLineInformationPanel.class, panel );
            panel.setPanelParameter( "information", moneyToPayIn + " transffered to your account!" );
            panel.show();
        } );
    }
}
