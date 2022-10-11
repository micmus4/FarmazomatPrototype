package pl.farmazomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Representation of Farmazomat's customer.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer
{
    private  String firstName;
    private  String lastName;
    private  Date dateOfBirth;
    private  String pesel;
}
