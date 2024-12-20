package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class BankingSystemGUI {

    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(230, 230, 230));
        sidebar.setPreferredSize(new Dimension(200, 700));

        JButton accountButton = new JButton("Manage Accounts");
        JButton loanButton = new JButton("Manage Loans");
        JButton transactionButton = new JButton("Transactions");
        JButton notificationButton = new JButton("Notifications");

        // Set ActionCommands for buttons
        accountButton.setActionCommand("Accounts");
        loanButton.setActionCommand("Loans");
        transactionButton.setActionCommand("Transactions");
        notificationButton.setActionCommand("Notifications");

        // Style buttons
        for (JButton button : new JButton[]{accountButton, loanButton, transactionButton, notificationButton}) {
            button.setPreferredSize(new Dimension(180, 40));
            button.setMaximumSize(new Dimension(180, 40));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        
        // Add buttons to sidebar
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(accountButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(loanButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(transactionButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(notificationButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(Box.createVerticalStrut(20));

        // Main Panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Account Section
        JPanel accountsPanel = new JPanel(new BorderLayout());
        accountsPanel.add(new JLabel("Manage Accounts", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel accountForm = new JPanel(new GridLayout(4, 2, 10, 10));
        accountForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        accountForm.add(new JLabel("Account Type:"));
        JComboBox<String> accountTypeComboBox = new JComboBox<>(new String[]{"Savings", "Checking"});
        accountForm.add(accountTypeComboBox);

        accountForm.add(new JLabel("Account Holder Name:"));
        JTextField accountHolderField = new JTextField();
        accountForm.add(accountHolderField);

        accountForm.add(new JLabel("Initial Deposit:"));
        JTextField initialDepositField = new JTextField();
        accountForm.add(initialDepositField);

        JButton createAccountButton = new JButton("Create Account");
        accountForm.add(createAccountButton);

        accountsPanel.add(accountForm, BorderLayout.WEST);

        String[] accountColumns = {"Account Number", "Account Type", "Account Holder", "Initial Deposit"};
        DefaultTableModel accountTableModel = new DefaultTableModel(accountColumns, 0);
        JTable accountTable = new JTable(accountTableModel);
        accountsPanel.add(new JScrollPane(accountTable), BorderLayout.CENTER);

        Map<Integer, Double> accountBalances = new HashMap<>();

        createAccountButton.addActionListener(e -> {
            String accountType = (String) accountTypeComboBox.getSelectedItem();
            String accountHolder = accountHolderField.getText();
            String initialDeposit = initialDepositField.getText();

            if (accountHolder.isEmpty() || initialDeposit.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!accountHolder.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(frame, "Account Holder Name must only contain letters!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    double depositAmount = Double.parseDouble(initialDeposit);
                    int accountNumber = accountTableModel.getRowCount() + 1;

                    accountTableModel.addRow(new Object[]{accountNumber, accountType, accountHolder, depositAmount});

                    accountBalances.put(accountNumber, depositAmount);

                    JOptionPane.showMessageDialog(frame, "Account Created Successfully!");
                    accountHolderField.setText("");
                    initialDepositField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Initial Deposit must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Loan Section
        JPanel loansPanel = new JPanel(new BorderLayout());
        loansPanel.add(new JLabel("Manage Loans", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel loanForm = new JPanel(new GridLayout(4, 2, 10, 10));
        loanForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        loanForm.add(new JLabel("Loan Type:"));
        JComboBox<String> loanTypeComboBox = new JComboBox<>(new String[]{"Home", "Car", "Personal"});
        loanForm.add(loanTypeComboBox);

        loanForm.add(new JLabel("Loan Amount:"));
        JTextField loanAmountField = new JTextField();
        loanForm.add(loanAmountField);

        loanForm.add(new JLabel("Repayment Period (Years):"));
        JTextField repaymentPeriodField = new JTextField();
        loanForm.add(repaymentPeriodField);

        JButton applyLoanButton = new JButton("Apply for Loan");
        loanForm.add(applyLoanButton);

        loansPanel.add(loanForm, BorderLayout.WEST);

        String[] loanColumns = {"Loan ID", "Loan Type", "Amount", "Repayment Period"};
        DefaultTableModel loanTableModel = new DefaultTableModel(loanColumns, 0);
        JTable loanTable = new JTable(loanTableModel);
        loansPanel.add(new JScrollPane(loanTable), BorderLayout.CENTER);

        applyLoanButton.addActionListener(e -> {
        String loanType = (String) loanTypeComboBox.getSelectedItem();
        String loanAmount = loanAmountField.getText();
        String repaymentPeriod = repaymentPeriodField.getText();

        if (loanAmount.isEmpty() || repaymentPeriod.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!loanAmount.matches("\\d+")) {
            JOptionPane.showMessageDialog(frame, "Loan Amount must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!repaymentPeriod.matches("\\d+")) {
            JOptionPane.showMessageDialog(frame, "Repayment Period must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loanID = loanTableModel.getRowCount() + 1;
        loanTableModel.addRow(new Object[]{loanID, loanType, loanAmount, repaymentPeriod});
        JOptionPane.showMessageDialog(frame, "Loan Applied Successfully!");

        loanAmountField.setText("");
        repaymentPeriodField.setText("");
    });
        
        // Notification Section
        JPanel notificationsPanel = new JPanel(new BorderLayout());  // Initialize notificationsPanel
        JTextArea notificationArea = new JTextArea();
        notificationArea.setEditable(false);
        JScrollPane notificationScrollPane = new JScrollPane(notificationArea);
        notificationsPanel.add(notificationScrollPane, BorderLayout.CENTER);
        
        
        // Transaction Section
        JPanel transactionsPanel = new JPanel(new BorderLayout());
        transactionsPanel.add(new JLabel("Transactions", SwingConstants.CENTER), BorderLayout.NORTH);

        // Form to process transactions
        JPanel transactionForm = new JPanel(new GridLayout(4, 2, 10, 10));
        transactionForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        transactionForm.add(new JLabel("Account Number:"));
        JTextField accountNumberField = new JTextField();
        transactionForm.add(accountNumberField);
        transactionForm.add(new JLabel("Transaction Type:"));
        JComboBox<String> transactionTypeComboBox = new JComboBox<>(new String[]{"Deposit", "Withdraw"});
        transactionForm.add(transactionTypeComboBox);
        transactionForm.add(new JLabel("Amount:"));
        JTextField transactionAmountField = new JTextField();
        transactionForm.add(transactionAmountField);
        JButton processTransactionButton = new JButton("Process Transaction");
        transactionForm.add(processTransactionButton);
        transactionsPanel.add(transactionForm, BorderLayout.WEST);

        // Table to show transaction history
        String[] transactionColumns = {"Transaction ID", "Account Number", "Transaction Type", "Amount"};
        DefaultTableModel transactionTableModel = new DefaultTableModel(transactionColumns, 0);
        JTable transactionTable = new JTable(transactionTableModel);
        transactionsPanel.add(new JScrollPane(transactionTable), BorderLayout.CENTER);
        
        // Handling transaction processing
        processTransactionButton.addActionListener(e -> {
            String accountNumberStr = accountNumberField.getText();
            String transactionType = (String) transactionTypeComboBox.getSelectedItem();
            String transactionAmountStr = transactionAmountField.getText();

            if (accountNumberStr.isEmpty() || transactionAmountStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int accountNumber = Integer.parseInt(accountNumberStr);
                    double transactionAmount = Double.parseDouble(transactionAmountStr);

                    if (!accountBalances.containsKey(accountNumber)) {
                        JOptionPane.showMessageDialog(frame, "Account not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double currentBalance = accountBalances.get(accountNumber);
                    String transactionMessage = "";
                    if (transactionType.equals("Deposit")) {
                        currentBalance += transactionAmount;
                        transactionMessage = "Deposit of " + transactionAmount + " processed for Account " + accountNumber;
                        JOptionPane.showMessageDialog(frame, "Deposit Successful!");
                    } else if (transactionType.equals("Withdraw")) {
                        if (currentBalance < transactionAmount) {
                            JOptionPane.showMessageDialog(frame, "Insufficient Balance!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        currentBalance -= transactionAmount;
                         transactionMessage = "Withdrawal of " + transactionAmount + " processed for Account " + accountNumber;
                        JOptionPane.showMessageDialog(frame, "Withdrawal Successful!");
                    }

                    // تحديث الرصيد في الخريطة
                    accountBalances.put(accountNumber, currentBalance);

                    // تحديث الجدول
                    for (int i = 0; i < accountTableModel.getRowCount(); i++) {
                        if ((int) accountTableModel.getValueAt(i, 0) == accountNumber) {
                            accountTableModel.setValueAt(String.valueOf(currentBalance), i, 3);  // تحديث العمود 3 (الرصيد)
                            break;
                        }
                    }

                    int transactionID = transactionTableModel.getRowCount() + 1;
                    transactionTableModel.addRow(new Object[]{transactionID, accountNumber, transactionType, transactionAmountStr});
                    // Add the transaction notification message
                    notificationArea.append(transactionMessage + "\n");

                    accountNumberField.setText("");
                    transactionAmountField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for Account Number and Amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Add panels to main panel
        mainPanel.add(accountsPanel, "Accounts");
        mainPanel.add(loansPanel, "Loans");
        mainPanel.add(transactionsPanel, "Transactions");
        mainPanel.add(notificationsPanel, "Notifications");

        // Sidebar Button Actions
        ActionListener showPanelAction = e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, ((JButton) e.getSource()).getActionCommand());
        };

        accountButton.addActionListener(showPanelAction);
        loanButton.addActionListener(showPanelAction);
        transactionButton.addActionListener(showPanelAction);
        notificationButton.addActionListener(showPanelAction);

        // Add sidebar and main panel to frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}


//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import models.Account;
//import models.Loan;
//import patterns.singleton.TransactionManager;
//
//public class BankingSystemGUI {
//    private JFrame frame;
//    private JTextField accountTypeField;
//    private JTextField loanTypeField;
//    private JTextField transactionAmountField;
//    private JTextArea outputTextArea;
//
//    public BankingSystemGUI() {
//        createGUI();
//    }
//
//    private void createGUI() {
//        frame = new JFrame("Banking System");
//        frame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
//
//        accountTypeField = new JTextField(10);
//        loanTypeField = new JTextField(10);
//        transactionAmountField = new JTextField(10);
//
//        inputPanel.add(new JLabel("Account Type:"));
//        inputPanel.add(accountTypeField);
//        inputPanel.add(new JLabel("Loan Type:"));
//        inputPanel.add(loanTypeField);
//        inputPanel.add(new JLabel("Transaction Amount:"));
//        inputPanel.add(transactionAmountField);
//
//        JButton createAccountButton = new JButton("Create Account");
//        createAccountButton.addActionListener(new CreateAccountListener());
//
//        JButton createLoanButton = new JButton("Create Loan");
//        createLoanButton.addActionListener(new CreateLoanListener());
//
//        JButton processTransactionButton = new JButton("Process Transaction");
//        processTransactionButton.addActionListener(new ProcessTransactionListener());
//
//        inputPanel.add(createAccountButton);
//        inputPanel.add(createLoanButton);
//        inputPanel.add(processTransactionButton);
//
//        frame.add(inputPanel, BorderLayout.NORTH);
//
//        outputTextArea = new JTextArea(10, 20);
//        frame.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
//
//        frame.setVisible(true);
//    }
//
//    private class CreateAccountListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String accountType = accountTypeField.getText();
//            Account account = TransactionManager.getInstance().createAccount(accountType);
//            outputTextArea.setText("Account created: " + accountType + "\n");
//            account.accountDetails();
//        }
//    }
//
//    private class CreateLoanListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String loanType = loanTypeField.getText();
//            Loan loan = TransactionManager.getInstance().createLoan(loanType);
//            outputTextArea.setText("Loan created: " + loanType + "\n");
//            loan.loanDetails();
//        }
//    }
//
//    private class ProcessTransactionListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String accountNumber = "12345";
//            double amount = Double.parseDouble(transactionAmountField.getText());
//            String type = "Deposit";
//            TransactionManager.getInstance().processTransaction(accountNumber, amount, type);
//            outputTextArea.setText("Transaction processed: " + type + " of $" + amount + "\n");
//        }
//    }
//
//    public static void main(String[] args) {
//        new BankingSystemGUI();
//    }
//}
