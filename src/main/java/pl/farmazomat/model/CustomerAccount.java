package pl.farmazomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representation of Farmazomat's customer account.
 */
@AllArgsConstructor
@Getter
public class CustomerAccount
{
    private final String cardNumber;
    private final String pin;
    private double money;
    private final Customer customer;

    public void transferMoneyToAccount( final double aMoneyToTransfer )
    {
        if( aMoneyToTransfer <= 0 )
        {
            throw new IllegalArgumentException( "Money to pass can not be zero or negative." );
        }
        money += aMoneyToTransfer;
    }
}
