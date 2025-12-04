package edu.loyola.cs485.gfbb.gui;

import javax.swing.*;


public class MainFrame extends JFrame{

    public MainFrame(){
        super("Fischer and Bokino - Restaurant");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        createMenuBar();

    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");

        JMenuItem mniReservation = new JMenuItem("Reservation CRUD");
        mniReservation.addActionListener(e -> {
        createResCrudDialog();
        });
        mnuFile.add(mniReservation);
        mnuFile.addSeparator();

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e ->{
            System.exit(0);
        });
        mnuFile.add(mniExit);

        menuBar.add(mnuFile);
        this.setJMenuBar(menuBar);
    }
    public void createResCrudDialog() {
        ResCrudDialog dialog = new ResCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
    }

}