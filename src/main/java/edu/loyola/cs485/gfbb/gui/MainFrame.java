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

      //  JMenuItem mniClient = new JMenuItem("Client CRUD");
     //   mniClient.addActionListener(e -> {
     //   createClientCrudDialog();
     //       );
    //    });
    //    mnuFile.add(mniClient);
      //  mnuFile.addSeparator();

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e ->{
            System.exit(0);
        });
        mnuFile.add(mniExit);

        menuBar.add(mnuFile);
        this.setJMenuBar(menuBar);
    }
   /** public void createResCrudDialog(){
        ClientCrudDialog dialog = new ClientCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
**/

}