/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personprofile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.function.Consumer;
import javax.swing.*;

/**
 * Creates the Person Profile Application and manages its forms.
 */
public class PersonProfileApp extends JFrame {

    /**
     * Stores the current person's information.
     */
    private Person person;

    /**
     * Separates the navigation menu from the forms.
     */
    private JSplitPane splitPane;

    /**
     * Defines the colors used throughout the application.
     */
    private final Color DARK_RED = new Color(153, 0, 0);
    private final Color BUTTON_RED = new Color(204, 0, 0);
    private final Color LIGHT_RED = new Color(255, 235, 235);

    /**
     * Sets up the main application window.
     */
    public PersonProfileApp() {

        setTitle("Person Profile Application");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel navigationPanel = createNavigationPanel();

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(LIGHT_RED);

        JLabel welcomeLabel = new JLabel(
            "Welcome to the Person Profile Application",
            SwingConstants.CENTER
        );

        welcomeLabel.setForeground(DARK_RED);
        welcomeLabel.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        contentPanel.add(welcomeLabel, BorderLayout.CENTER);

        splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            navigationPanel,
            contentPanel
        );

        splitPane.setDividerLocation(240);
        splitPane.setResizeWeight(0.0);

        add(splitPane);
    }

    /**
     * Creates the navigation menu and connects its buttons.
     */
    private JPanel createNavigationPanel() {

        JPanel panel = new JPanel(
            new GridLayout(8, 1, 5, 5)
        );

        panel.setBackground(DARK_RED);

        JButton createPerson = new JButton("Create Person");
        JButton viewPerson = new JButton("View Person");

        JButton createHome = new JButton("Create Home Address");
        JButton viewHome = new JButton("View Home Address");

        JButton createLocal = new JButton("Create Local Address");
        JButton viewLocal = new JButton("View Local Address");

        JButton createBank = new JButton("Create Bank Account");
        JButton viewBank = new JButton("View Bank Account");

        JButton[] buttons = {
            createPerson,
            viewPerson,
            createHome,
            viewHome,
            createLocal,
            viewLocal,
            createBank,
            viewBank
        };

        // Apply the same red theme to every button.
        for (JButton button : buttons) {

            button.setBackground(BUTTON_RED);
            button.setForeground(Color.WHITE);
            button.setFont(
                new Font("Arial", Font.BOLD, 13)
            );

            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBorderPainted(false);

            panel.add(button);
        }

        // Connect each button to its corresponding form.
        createPerson.addActionListener(
            e -> showCreatePersonForm()
        );

        viewPerson.addActionListener(
            e -> showViewPersonForm()
        );

        createHome.addActionListener(
            e -> showCreateAddressForm("Home")
        );

        viewHome.addActionListener(
            e -> showViewAddressForm("Home")
        );

        createLocal.addActionListener(
            e -> showCreateAddressForm("Local")
        );

        viewLocal.addActionListener(
            e -> showViewAddressForm("Local")
        );

        createBank.addActionListener(
            e -> showCreateBankForm()
        );

        viewBank.addActionListener(
            e -> showViewBankForm()
        );

        return panel;
    }

    /**
     * Creates a reusable form with labels and text fields.
     */
    private void showForm(
            String title,
            String[] labels,
            String[] values,
            boolean editable,
            Consumer<String[]> saveAction) {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(LIGHT_RED);

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        // Display the form title.
        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setForeground(DARK_RED);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a label and text field for every attribute.
        JPanel fieldsPanel = new JPanel(
            new GridLayout(labels.length, 2, 10, 12)
        );

        fieldsPanel.setBackground(LIGHT_RED);

        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {

            JLabel label = new JLabel(labels[i] + ":");

            label.setFont(
                new Font("Arial", Font.PLAIN, 14)
            );

            fields[i] = new JTextField();

            // Fill the fields when viewing saved information.
            if (values != null) {
                fields[i].setText(values[i]);
            }

            fields[i].setEditable(editable);

            fieldsPanel.add(label);
            fieldsPanel.add(fields[i]);
        }

        mainPanel.add(fieldsPanel, BorderLayout.CENTER);

        // Only creation forms need a Save button.
        if (editable) {

            JButton saveButton = new JButton("Save Information");

            saveButton.setBackground(DARK_RED);
            saveButton.setForeground(Color.WHITE);
            saveButton.setFont(
                new Font("Arial", Font.BOLD, 14)
            );

            saveButton.setOpaque(true);
            saveButton.setBorderPainted(false);
            saveButton.setFocusPainted(false);

            mainPanel.add(saveButton, BorderLayout.SOUTH);

            saveButton.addActionListener(e -> {

                String[] input = new String[fields.length];

                // Check every required field before saving.
                for (int i = 0; i < fields.length; i++) {

                    String text = fields[i].getText();

                    if (text == null || text.trim().isEmpty()) {

                        showError(
                            "Please enter " + labels[i] + "."
                        );

                        fields[i].requestFocusInWindow();
                        return;

                    } else {

                        input[i] = text.trim();
                    }
                }

                // Validate and save the completed form.
                try {

                    saveAction.accept(input);

                } catch (IllegalArgumentException ex) {

                    showError(ex.getMessage());
                }
            });
        }

        // Display the selected form inside the split pane.
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        splitPane.setRightComponent(scrollPane);
        splitPane.setDividerLocation(240);
    }

    /**
     * Displays an error message when input is invalid.
     */
    private void showError(String message) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "Input Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Checks whether a person profile exists.
     */
    private boolean checkPerson() {

        if (person == null) {

            showError("Please create a person profile first.");
            return false;

        } else {

            return true;
        }
    }

    /**
     * Reads and validates an integer.
     */
    private int readInteger(String text, String fieldName) {

        try {

            int value = Integer.parseInt(text);

            if (value < 0) {

                throw new IllegalArgumentException(
                    fieldName + " cannot be negative."
                );

            } else {

                return value;
            }

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                fieldName + " must be a valid whole number."
            );
        }
    }

    /**
     * Reads and validates a decimal number.
     */
    private double readDouble(String text, String fieldName) {

        try {

            double value = Double.parseDouble(text);

            if (!Double.isFinite(value)) {

                throw new IllegalArgumentException(
                    fieldName + " must be a finite number."
                );

            } else {

                return value;
            }

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                fieldName + " must be a valid number."
            );
        }
    }

    /**
     * Reads and validates a float value.
     */
    private float readFloat(String text, String fieldName) {

        try {

            float value = Float.parseFloat(text);

            if (!Float.isFinite(value)) {

                throw new IllegalArgumentException(
                    fieldName + " must be a finite number."
                );

            } else {

                return value;
            }

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                fieldName + " must be a valid number."
            );
        }
    }

    /**
     * Converts a yes or no answer into a boolean.
     */
    private boolean readYesNo(String text, String fieldName) {

        if (text.equalsIgnoreCase("yes")) {

            return true;

        } else if (text.equalsIgnoreCase("no")) {

            return false;

        } else {

            throw new IllegalArgumentException(
                fieldName + " must be yes or no."
            );
        }
    }

    /**
     * Displays the form for creating a person.
     */
    private void showCreatePersonForm() {

        String[] labels = {
            "First Name",
            "Last Name",
            "Age",
            "Married (yes/no)"
        };

        showForm(
            "Create Person",
            labels,
            null,
            true,
            input -> savePerson(input)
        );
    }

    /**
     * Validates and saves the person's information.
     */
    private void savePerson(String[] input) {

        int age = readInteger(input[2], "Age");

        boolean married = readYesNo(
            input[3],
            "Marital status"
        );

        if (person == null) {

            // Create a new Person using the constructor.
            person = new Person(
                input[0],
                input[1],
                age,
                married
            );

        } else {

            // Update the existing person without losing linked objects.
            person.setFirstName(input[0]);
            person.setLastName(input[1]);
            person.setAge(age);
            person.setMarried(married);
        }

        JOptionPane.showMessageDialog(
            this,
            "Person profile saved successfully!"
        );

        showViewPersonForm();
    }

    /**
     * Displays the person's saved information.
     */
    private void showViewPersonForm() {

        if (!checkPerson()) {
            return;
        }

        String[] labels = {
            "First Name",
            "Last Name",
            "Age",
            "Married"
        };

        String[] values = {
            person.getFirstName(),
            person.getLastName(),
            String.valueOf(person.getAge()),
            person.isMarried() ? "Yes" : "No"
        };

        showForm(
            "View Person",
            labels,
            values,
            false,
            null
        );
    }

    /**
     * Displays the form for creating an address.
     */
    private void showCreateAddressForm(String type) {

        if (!checkPerson()) {
            return;
        }

        String[] labels = {
            "Person Name",
            "Street",
            "City",
            "State",
            "ZIP Code",
            "Address Type"
        };

        // Start with the person's name and selected address type.
        String[] values = {
            person.getFullName(),
            "",
            "",
            "",
            "",
            type
        };

        showForm(
            "Create " + type + " Address",
            labels,
            values,
            true,
            input -> saveAddress(input, type)
        );
    }

    /**
     * Validates and saves a home or local address.
     */
    private void saveAddress(String[] input, String type) {

        // Verify that the address belongs to the current person.
        if (!input[0].equalsIgnoreCase(person.getFullName())) {

            throw new IllegalArgumentException(
                "Person Name must match the current profile."
            );
        }

        // Make sure the entered address type matches the selected form.
        if (!input[5].equalsIgnoreCase(type)) {

            throw new IllegalArgumentException(
                "Address Type must be " + type + "."
            );
        }

        // ZIP codes are stored as Strings to keep leading zeros.
        if (!input[4].matches("[0-9]{5}(-[0-9]{4})?")) {

            throw new IllegalArgumentException(
                "ZIP Code must contain five digits or ZIP+4."
            );
        }

        // Create an Address object.
        Address address = new Address(
            input[0],
            input[1],
            input[2],
            input[3],
            input[4],
            type
        );

        // Connect the correct address to the Person object.
        if (type.equals("Home")) {

            person.setHomeAddress(address);

        } else {

            person.setLocalAddress(address);
        }

        JOptionPane.showMessageDialog(
            this,
            type + " address saved successfully!"
        );

        showViewAddressForm(type);
    }

    /**
     * Displays a saved home or local address.
     */
    private void showViewAddressForm(String type) {

        if (!checkPerson()) {
            return;
        }

        Address address;

        if (type.equals("Home")) {

            address = person.getHomeAddress();

        } else {

            address = person.getLocalAddress();
        }

        if (address == null) {

            showError(
                "Please create a " + type.toLowerCase()
                + " address first."
            );

            return;
        }

        String[] labels = {
            "Person Name",
            "Street",
            "City",
            "State",
            "ZIP Code",
            "Address Type"
        };

        String[] values = {
            address.getPersonName(),
            address.getStreet(),
            address.getCity(),
            address.getState(),
            address.getZipCode(),
            address.getAddressType()
        };

        showForm(
            "View " + type + " Address",
            labels,
            values,
            false,
            null
        );
    }

    /**
     * Displays the form for creating a bank account.
     */
    private void showCreateBankForm() {

        if (!checkPerson()) {
            return;
        }

        String[] labels = {
            "Person Name",
            "Bank Name",
            "Account Number",
            "Account Type",
            "Balance",
            "Interest Rate",
            "Active (yes/no)"
        };

        String[] values = {
            person.getFullName(),
            "",
            "",
            "",
            "",
            "",
            ""
        };

        showForm(
            "Create Bank Account",
            labels,
            values,
            true,
            input -> saveBankAccount(input)
        );
    }

    /**
     * Validates and saves the bank account information.
     */
    private void saveBankAccount(String[] input) {

        // Make sure the account holder matches the person.
        if (!input[0].equalsIgnoreCase(person.getFullName())) {

            throw new IllegalArgumentException(
                "Person Name must match the current profile."
            );
        }

        // Check that the account number contains only digits.
        if (!input[2].matches("[0-9]+")) {

            throw new IllegalArgumentException(
                "Account Number must contain only digits."
            );
        }

        // Validate the numeric and boolean values.
        double balance = readDouble(input[4], "Balance");

        float interestRate = readFloat(
            input[5],
            "Interest Rate"
        );

        boolean active = readYesNo(
            input[6],
            "Account status"
        );

        if (interestRate < 0) {

            throw new IllegalArgumentException(
                "Interest Rate cannot be negative."
            );
        }

        // Create the BankAccount object.
        BankAccount bank = new BankAccount(
            input[0],
            input[1],
            input[2],
            input[3],
            balance,
            interestRate,
            active
        );

        // Connect the account to the current person.
        person.setBankAccount(bank);

        JOptionPane.showMessageDialog(
            this,
            "Bank account saved successfully!"
        );

        showViewBankForm();
    }

    /**
     * Displays the saved bank account information.
     */
    private void showViewBankForm() {

        if (!checkPerson()) {
            return;
        }

        BankAccount bank = person.getBankAccount();

        if (bank == null) {

            showError("Please create a bank account first.");
            return;
        }

        String[] labels = {
            "Person Name",
            "Bank Name",
            "Account Number",
            "Account Type",
            "Balance",
            "Interest Rate",
            "Active"
        };

        String[] values = {
            bank.getPersonName(),
            bank.getBankName(),
            bank.getAccountNumber(),
            bank.getAccountType(),
            String.valueOf(bank.getBalance()),
            String.valueOf(bank.getInterestRate()),
            bank.isActive() ? "Yes" : "No"
        };

        showForm(
            "View Bank Account",
            labels,
            values,
            false,
            null
        );
    }

    /**
     * Starts the Person Profile Application.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            PersonProfileApp app = new PersonProfileApp();

            app.setVisible(true);
        });
    }
}