package edu.loyola.cs485.gfbb.gui;

import edu.loyola.cs485.gfbb.controller.ReservationManage;
import edu.loyola.cs485.gfbb.model.entity.Reservation;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ResCrudDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton deleteButton;
    private JButton updateButton;
    private JList listResUI;

    public ResCrudDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        populateUI();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                newClick();
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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClick();
            }
        });
        /**
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClick();
            }
        });
         **/
    }

    private void newClick() {
        ResInfoDialog dialog = new ResInfoDialog();
        dialog.pack();
        dialog.setVisible(true);

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void deleteClick() {
        try {
            ReservationManage manage = new ReservationManage();
            Reservation r = (Reservation) listResUI.getSelectedValue();
            if (r != null) {
                manage.deleteRes(r.getId());
                listResUI.clearSelection();
                populateUI();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    public void populateUI() {
        try {
            ReservationManage manage = new ReservationManage();
            List<Reservation> listdata = manage.getAllReservations();

            listResUI.setListData(listdata.toArray());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
    public void updateClick() {
        try {
            ReservationManage manage = new ReservationManage();
            Reservation r = (Reservation) listResUI.getSelectedValue();
            if (r != null) {
                manage.updateRes(r.getId());
                listResUI
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
**/

    public static void main(String[] args) {
        ResCrudDialog dialog = new ResCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
