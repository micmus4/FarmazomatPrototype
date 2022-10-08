package pl.farmazomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Representation of Farmazomat's customer.
 */
@AllArgsConstructor
@Getter
public class Customer
{
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String pesel;
}
