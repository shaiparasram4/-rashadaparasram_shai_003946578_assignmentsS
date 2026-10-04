/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import model.Owner;
import model.Service;
import model.ServiceCatalog;
import model.Vehicle;
import model.VehicleDirectory;

/**
 *
 * @author shai8
 */
public class MainJFrame extends javax.swing.JFrame {

    // Objects used throughout the backend of the application
    private ServiceCatalog serviceCatalog;
    private VehicleDirectory vehicleDirectory;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {

        initComponents();

        // Create the backend directories
        serviceCatalog = new ServiceCatalog();
        vehicleDirectory = new VehicleDirectory();

        // Add the required starter data
        populateInitialData();

        // =============================================
        // CREATE AND DISPLAY HOME PANEL
        // =============================================

        HomeJPanel homePanel =
                new HomeJPanel(
                        mainWorkArea,
                        serviceCatalog,
                        vehicleDirectory
                );

        // Add HomeJPanel to the CardLayout
        mainWorkArea.add(homePanel, "Home");

        // Show HomeJPanel when the application starts
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.show(mainWorkArea, "Home");

        // Opens the JFrame in the center of the screen
        setLocationRelativeTo(null);
    }

    /**
     * Creates the initial services, owners, and vehicles
     * when the application starts.
     */
    private void populateInitialData() {

        // =============================================
        // INITIAL SERVICES
        // =============================================

        Service service1 = new Service(
                101,
                "Oil Change",
                79.99,
                "Michael",
                (short) 45
        );

        Service service2 = new Service(
                102,
                "Car Wash",
                35.00,
                "James",
                (short) 30
        );

        Service service3 = new Service(
                103,
                "Brake Inspection",
                120.00,
                "David",
                (short) 60
        );

        Service service4 = new Service(
                104,
                "Tire Rotation",
                65.00,
                "Anthony",
                (short) 40
        );

        Service service5 = new Service(
                105,
                "Engine Diagnostic",
                150.00,
                "Robert",
                (short) 90
        );

        // Add services to the ServiceCatalog
        serviceCatalog.addService(service1);
        serviceCatalog.addService(service2);
        serviceCatalog.addService(service3);
        serviceCatalog.addService(service4);
        serviceCatalog.addService(service5);

        // =============================================
        // INITIAL OWNERS
        // =============================================

        Owner owner1 = new Owner(
                1001L,
                "John",
                "Smith"
        );

        Owner owner2 = new Owner(
                1002L,
                "Sarah",
                "Johnson"
        );

        Owner owner3 = new Owner(
                1003L,
                "Michael",
                "Brown"
        );

        Owner owner4 = new Owner(
                1004L,
                "Ashley",
                "Davis"
        );

        Owner owner5 = new Owner(
                1005L,
                "Daniel",
                "Wilson"
        );

        // =============================================
        // INITIAL VEHICLES
        // =============================================

        Vehicle vehicle1 = new Vehicle(
                201,
                "Toyota",
                "Camry",
                2022,
                "ABC123",
                "10/05/2026",
                owner1,
                service1
        );

        Vehicle vehicle2 = new Vehicle(
                202,
                "Honda",
                "Accord",
                2021,
                "DEF456",
                "10/06/2026",
                owner2,
                service2
        );

        Vehicle vehicle3 = new Vehicle(
                203,
                "Toyota",
                "Camry",
                2020,
                "GHI789",
                "10/07/2026",
                owner3,
                service3
        );

        Vehicle vehicle4 = new Vehicle(
                204,
                "Nissan",
                "Altima",
                2023,
                "JKL321",
                "10/08/2026",
                owner4,
                service4
        );

        Vehicle vehicle5 = new Vehicle(
                205,
                "BMW",
                "X5",
                2022,
                "MNO654",
                "10/09/2026",
                owner5,
                service5
        );

        // =============================================
        // ADD VEHICLES TO VEHICLE DIRECTORY
        // =============================================

        vehicleDirectory.addVehicle(vehicle1);
        vehicleDirectory.addVehicle(vehicle2);
        vehicleDirectory.addVehicle(vehicle3);
        vehicleDirectory.addVehicle(vehicle4);
        vehicleDirectory.addVehicle(vehicle5);
    }
    // ==== WARNING: Please DO NOT Change The Code Below =======

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shai Vehicle Service Center");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        mainWorkArea.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainWorkArea, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainWorkArea;
    // End of variables declaration//GEN-END:variables
}
