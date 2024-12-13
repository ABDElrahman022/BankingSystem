package gui;

import models.ActionLogger;
import models.Account;
import models.Loan;
import patterns.singleton.TransactionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BankGUI extends JFrame {
    private JTable logTable;
    private DefaultTableModel tableModel;
    private TransactionManager transactionManager;

    public BankGUI() {
        transactionManager = TransactionManager.getInstance();

        setTitle("Banking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table to display actions
        tableModel = new DefaultTableModel(new String[]{"Action Log"}, 0);
        logTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(logTable);

        // Panels for buttons and inputs
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        JPanel formPanel = new JPanel(new GridLayout(2, 2));

        // Buttons for simulating actions
        JButton createAccountButton = new JButton("Create Account");
        JButton createLoanButton = new JButton("Create Loan");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        buttonPanel.add(createAccountButton);
        buttonPanel.add(createLoanButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        // Input fields for forms
        JTextField accountTypeField = new JTextField();
        JTextField loanTypeField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField accountNumberField = new JTextField();

        formPanel.add(new JLabel("Account Type (Savings/Checking):"));
        formPanel.add(accountTypeField);
        formPanel.add(new JLabel("Loan Type (Home/Personal/Car):"));
        formPanel.add(loanTypeField);
        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel("Account Number:"));
        formPanel.add(accountNumberField);

        inputPanel.add(formPanel);
        inputPanel.add(buttonPanel);

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Button actions
        createAccountButton.addActionListener(e -> {
            String accountType = accountTypeField.getText();
            if (!accountType.isEmpty()) {
                simulateCreateAccount(accountType);
            } else {
                showError("Please enter an account type.");
            }
        });

        createLoanButton.addActionListener(e -> {
            String loanType = loanTypeField.getText();
            if (!loanType.isEmpty()) {
                simulateCreateLoan(loanType);
            } else {
                showError("Please enter a loan type.");
            }
        });

        depositButton.addActionListener(e -> {
            String accountNumber = accountNumberField.getText();
            String amountText = amountField.getText();
            if (!accountNumber.isEmpty() && !amountText.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    simulateDeposit(accountNumber, amount);
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid amount.");
                }
            } else {
                showError("Please enter account number and amount.");
            }
        });

        withdrawButton.addActionListener(e -> {
            String accountNumber = accountNumberField.getText();
            String amountText = amountField.getText();
            if (!accountNumber.isEmpty() && !amountText.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    simulateWithdraw(accountNumber, amount);
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid amount.");
                }
            } else {
                showError("Please enter account number and amount.");
            }
        });

        loadLogs();
    }

    private void loadLogs() {
        tableModel.setRowCount(0); // Clear existing rows
        ActionLogger logger = ActionLogger.getInstance();
        for (String action : logger.getActions()) {
            tableModel.addRow(new Object[]{action});
        }
    }

    private void simulateCreateAccount(String accountType) {
        try {
            Account account = transactionManager.createAccount(accountType);
            account.accountDetails();
            loadLogs();
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void simulateCreateLoan(String loanType) {
        try {
            Loan loan = transactionManager.createLoan(loanType);
            loan.loanDetails();
            loadLogs();
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void simulateDeposit(String accountNumber, double amount) {
        transactionManager.processTransaction(accountNumber, amount, "Deposit");
        loadLogs();
    }

    private void simulateWithdraw(String accountNumber, double amount) {
        transactionManager.processTransaction(accountNumber, amount, "Withdraw");
        loadLogs();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankGUI gui = new BankGUI();
            gui.setVisible(true);
        });
    }
}
