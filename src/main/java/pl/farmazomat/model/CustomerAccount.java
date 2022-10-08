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
    private final Double money;
    private final Customer customer;
}
