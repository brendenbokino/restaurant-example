package edu.loyola.cs485.gfbb.gui;

import edu.loyola.cs485.gfbb.controller.ReservationManage;

import javax.swing.*;
import java.awt.event.*;

public class ResInfoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtID;
    private JTextField txtDateAndTime;
    private JTextField txtNumGuests;
    private JTextField txtStatus;

    public ResInfoDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        ReservationManage manage = new ReservationManage();
        String id = txtID.getText();
        String dateTime= txtDateAndTime.getText();
        String numGuests = txtNumGuests.getText();
        String status = txtStatus.getText();
        try {
            manage.createReservation(id, dateTime, numGuests, status);
            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ResInfoDialog dialog = new ResInfoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
