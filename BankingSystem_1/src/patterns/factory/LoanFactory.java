package patterns.factory;

import models.Loan;
import models.HomeLoan;
import models.PersonalLoan;
import models.CarLoan;

public class LoanFactory {
    public static Loan createLoan(String type) {
        switch (type.toLowerCase()) {
            case "home" -> {
                return new HomeLoan();
            }
            case "personal" -> {
                return new PersonalLoan();
            }
            case "car" -> {
                return new CarLoan();
            }
            default -> throw new IllegalArgumentException("Invalid loan type: " + type);
        }
    }
}
