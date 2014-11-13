package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogueEtiquette extends JDialog implements ActionListener {
   
	/**
	 * 
	 */
	
	private JTextField champDeTexte;

    DialogueEtiquette(String titre) {
        super((JFrame) null, titre, true);
        setTitle("");

        JButton bouton = new JButton("Creer le le noeud");
        bouton.setFont(new Font("Arial", Font.PLAIN, 12));
        bouton.addActionListener(this);

        champDeTexte = new JTextField(20);
        champDeTexte.addActionListener(this);

        JPanel panneau = new JPanel();
        panneau.add(bouton);

        JLabel label = new JLabel("Le nom du le noeud ?");
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        getContentPane().add(label, BorderLayout.NORTH);
        getContentPane().add(champDeTexte, BorderLayout.CENTER);
        getContentPane().add(panneau, BorderLayout.SOUTH);
        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
		.getScreenSize();
        
        setLocation((screenSize.width-getSize().width)/2,(screenSize.height-getSize().height)/2);
        setVisible(true);
    }

    public String getText() {
        return champDeTexte.getText();
    }

    public void actionPerformed(ActionEvent evt) {
        dispose();
    }
}