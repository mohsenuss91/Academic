package src;

//import java.awt.BorderLayout;

import java.awt.Cursor;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
//import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.BorderLayout;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sun.imageio.plugins.png.PNGImageWriter;

public class Principale extends JFrame implements ActionListener {

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu file = null;

	private JMenu edit = null;

	private JMenuItem jNew = null;

	private JMenuItem jOpen = null;

	private JMenuItem jExit = null;

	File fichier = null;

	JFileChooser fileChooser = new JFileChooser();

	// private JTextField txtSaisie;
	Noeud test;

	static Multilingue MonGraphe;

	static Arete areteSelected;
	static List listNodeSelected=new LinkedList();;
	static Noeud noeudSelected;

	static Noeud noeudToCopy;

	static String clé;

	public static int ETAT = 0;

	static int LANG = 1;

	public static final Cursor curs_Text = new Cursor(Cursor.TEXT_CURSOR);

	public static final Cursor curs_default = new Cursor(Cursor.DEFAULT_CURSOR);

	private JPanel jPanel = null;

	private JScrollPane jScrollPane = null;

	private JToolBar jToolBar2 = null;

	private JToggleButton btnCurseur = null;

	private JToggleButton btnNoeud = null;

	private JToggleButton btnArete = null;

	private JButton btnDel = null;

	private Paneau jPanel12 = null;

	private JMenuItem jSave_as = null;

	private JMenuItem jModify = null;

	private JMenuItem jDelete = null;
 

	private JMenuItem jMenuImg = null;
 

	public Principale() throws HeadlessException {
		super();
		// TODO Raccord de constructeur auto-généré
		initialize();
	}

	public Principale(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Raccord de constructeur auto-généré
		initialize();
	}

	public Principale(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Raccord de constructeur auto-généré
		initialize();
	}

	public Principale(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Raccord de constructeur auto-généré
		initialize();
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setSize(800, 50);
			jJMenuBar.add(getFile());
			jJMenuBar.add(getEdit());
		}
		
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFile() {
		if (file == null) {
			file = new JMenu();
			file.setText("Fichier");
			file.add(getJNew());
			file.add(getJOpen());
			file.add(getJSave_as());
			file.add(getJMenuImg());
			file.addSeparator();
			file.add(getJExit());
		}
		return file;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getEdit() {
		if (edit == null) {
			edit = new JMenu();
			edit.setText("Edition");
			
			edit.add(getJModify());
			edit.add(getJDelete());
			
		}
		return edit;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJNew() {
		if (jNew == null) {
			jNew = new JMenuItem();
			jNew.setText("Nouveau");
			jNew.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (MonGraphe.graphe.modifié) {
						switch (JOptionPane.showConfirmDialog(null,
								"Voulez-vous sauvgarder le Graphe en cours ?",
								"Enregistrement", 1)) {
						case 0:
							save();
							MonGraphe = new Multilingue();

							break;
						case 1:
							MonGraphe = new Multilingue();

						}
						fichier = null;
					} else {
						MonGraphe = new Multilingue();
						fichier = null;
					}

					
				}

			});
		}
		return jNew;
	}

	/**
	 * This method initializes jMenuItem1
	 * 
	 * @return javax.swing.JMenuItem
	 */
	
	private JMenuItem getJOpen() {
		if (jOpen == null) {
			jOpen = new JMenuItem();
			jOpen.setText("Ouvrir");
			jOpen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (MonGraphe.graphe.modifié) {
						switch (JOptionPane.showConfirmDialog(null,
								"Voulez-vous sauvgarder le Graphe en cours ?",
								"Enregistrement", 1)) {
						case 0:
							save();
							open();
						case 1:
							open();
						}
					} else {
						open();
					}
				}
			});
		}
		return jOpen;
	}

	/**
	 * This method initializes jQuitter
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJExit() {
		if (jExit == null) {
			jExit = new JMenuItem();
			jExit.setText("Quitter");
			jExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (MonGraphe.graphe.modifié) {
						switch (JOptionPane.showConfirmDialog(null,
								"Voulez-vous sauvgarder le Graphe en cours ?",
								"Enregistrement", 1)) {
						case 0:
							save();
							System.exit(0);
						case 1:
							System.exit(0);
						}
					}System.exit(0);

				}
			});
		}
		return jExit;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setPreferredSize(new java.awt.Dimension(800,50));
			jPanel.add(getJToolBar2(), null);
			 
			 
			
		}
		return jPanel;
	}

 
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBackground(java.awt.Color.white);
			
			jScrollPane.setViewportView(getJPanel12());
		 

		}
		return jScrollPane;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
 
	/**
	 * This method initializes jToolBar2
	 * 
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar2() {
		if (jToolBar2 == null) {
			jToolBar2 = new JToolBar();
			jToolBar2.setPreferredSize(new java.awt.Dimension(800,50));
			jToolBar2.setName("jToolBar");
			jToolBar2.setOrientation(JToolBar.HORIZONTAL);
			jToolBar2.setLocation(new java.awt.Point(0, 0));
			jToolBar2.setSize(new java.awt.Dimension(700, 50));
			jToolBar2.setFloatable(false);
			jToolBar2.add(getBtnCurseur());
			jToolBar2.add(getBtnNoeud());
			jToolBar2.add(getBtnArete());
			jToolBar2.add(getBtnDel());
		}
		return jToolBar2;
	}

	/**
	 * This method initializes jToggleButton1
	 * 
	 * @return javax.swing.JToggleButton
	 */
	private JToggleButton getBtnCurseur() {
		if (btnCurseur == null) {
			btnCurseur = new JToggleButton();
			btnCurseur.setText("Selectionner");
			btnCurseur.setPreferredSize(new java.awt.Dimension(200,32));
			btnCurseur.setToolTipText("Utilisez ce bouton pour selectionner");
			btnCurseur.setIcon(new ImageIcon(getClass().getResource("/Images/cur.gif")));
			btnCurseur.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ETAT != 0) {
						ETAT = 0;
						btnNoeud.setSelected(false);
						btnArete.setSelected(false);
						setCursor(curs_default);
					}

				}

			});
		}
		return btnCurseur;
	}

	/**
	 * This method initializes jToggleButton2
	 * 
	 * @return javax.swing.JToggleButton
	 */
	private JToggleButton getBtnNoeud() {
		if (btnNoeud == null) {
			btnNoeud = new JToggleButton();
			btnNoeud.setText("Noeud");
			btnNoeud.setPreferredSize(new java.awt.Dimension(200,32));
			btnNoeud.setToolTipText("Utilisez ce bouton pour creer un Noeud");
			btnNoeud.setIcon(new ImageIcon(getClass().getResource("/Images/node.gif")));
			btnNoeud.setSelected(false);
			btnNoeud.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					if (ETAT != 1) {
						ETAT = 1;
						btnCurseur.setSelected(false);
						btnArete.setSelected(false);
						setCursor(curs_Text);
					} else {
						ETAT = 0;
						setCursor(curs_default);
					}

					// test=new Noeud(200,200,"hahahah");

				}
			});
		}
		return btnNoeud;
	}

	/**
	 * This method initializes jToggleButton3
	 * 
	 * @return javax.swing.JToggleButton
	 */
	private JToggleButton getBtnArete() {
		if (btnArete == null) {
			btnArete = new JToggleButton();
			btnArete.setText("Relation");
			btnArete.setIcon(new ImageIcon(getClass().getResource("/Images/rel.gif")));
			btnArete.setPreferredSize(new java.awt.Dimension(200,32));
			btnArete.setToolTipText("Utilisez ce bouton pour creer une relation");
			btnArete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					if (ETAT != 2) {
						ETAT = 2;
						btnCurseur.setSelected(false);
						btnNoeud.setSelected(false);
						setCursor(curs_default);
					} else {
						ETAT = 0;
						setCursor(curs_default);
					}
					btnArete.setSelected(false);
				}
			});
		}
		return btnArete;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton();
			btnDel.setText("Supprimer");
			btnDel.setIcon(new ImageIcon(getClass().getResource("/Images/del.gif")));
			btnDel.setPreferredSize(new java.awt.Dimension(200,32));
			btnDel.setToolTipText("Utilisez ce bouton pour Supprimer");
			btnDel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (noeudSelected != null) {
						MonGraphe.graphe.removeNoeud(noeudSelected.getNom());
						MonGraphe.dico.remove(noeudSelected.getNom());
						noeudSelected = null;
						getJPanel12().repaint();
					}
					if (areteSelected != null) {
						MonGraphe.graphe.removeArrête(areteSelected.origine,
								areteSelected.extrem);
						areteSelected = null;
						getJPanel12().repaint();
					}
					if(!listNodeSelected.isEmpty()){
						for(Iterator itr=listNodeSelected.iterator();itr.hasNext();){
							Noeud node=(Noeud)itr.next();
							MonGraphe.graphe.removeNoeud(node.getNom());
							MonGraphe.dico.remove(node.getNom());
							
						}listNodeSelected.clear();
						getJPanel12().repaint();
							
							}
					
				}
			});

		}
		return btnDel;
	}

	/**
	 * This method initializes jPanel12
	 * 
	 * @return javax.swing.JPanel
	 */
	
	private Paneau getJPanel12() {
		if (jPanel12 == null) {
			jPanel12 = new Paneau();

		}
		return jPanel12;
	}
 
	/**
	 * This method initializes jSave_as
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJSave_as() {
		if (jSave_as == null) {
			jSave_as = new JMenuItem();
			jSave_as.setText("Enregistrer sous...");
			jSave_as.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveAs();
				}
			});
		}
		return jSave_as;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJModify() {
		if (jModify == null) {
			jModify = new JMenuItem();
			jModify.setText("Modifier");
			jModify.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJPanel12().modify_Node(noeudSelected);
					getJPanel12().modify_Arete(areteSelected);
				}
			});
		}
		return jModify;
	}

	/**
	 * This method initializes jDelete
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJDelete() {
		if (jDelete == null) {
			jDelete = new JMenuItem();
			jDelete.setText("Supprimer");
			jDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (noeudSelected != null) {
						MonGraphe.graphe.removeNoeud(noeudSelected.getNom());
						noeudSelected = null;
						getJPanel12().repaint();
					}
					if (areteSelected != null) {
						MonGraphe.graphe.removeArrête(areteSelected.origine,
								areteSelected.extrem);
						areteSelected = null;
						getJPanel12().repaint();
					}
				}
			});
		}
		return jDelete;
	}

	/**
	 * This method initializes jJToolBarBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */


	/**
	 * This method initializes jbtnNew	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	private JMenuItem getJMenuImg() {
		if (jMenuImg == null) {
			jMenuImg = new JMenuItem();
			jMenuImg.setText("Capture d'image");
			jMenuImg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					fileChooser.showSaveDialog(null);
					if (fileChooser.getSelectedFile() != null) {
						String fileName =fileChooser.getSelectedFile().getAbsolutePath();
						
					
	                if (fileName == null)
	                    return;
					try {
	                    File imageFile;
	                    FileImageOutputStream outputStream;
	                    BufferedImage img;
	                    

	                    imageFile = new File(fileName);
	                   

	                    img=(BufferedImage)getJPanel12().getImage();

	                    PNGImageWriter writer = new PNGImageWriter(null);

	                    writer.setOutput(outputStream = new FileImageOutputStream(
	                            imageFile));
	                    writer.write(img);

	                    outputStream.close();

	                    writer.dispose();

	                } catch (IOException err) {
	                    JOptionPane.showMessageDialog(null,"Impossible de sauvegarder le fichier "
	                            + fileName);
				}}}}
			);
		}
		return jMenuImg;
	}

	/**
	 * This method initializes jCapture	
	 * 	
	 * @return javax.swing.JButton	
	 */
	

	/**
	 * @param args
	 */


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 600);
		
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("\t Editeur Graphique des Graphes");
		MonGraphe = new Multilingue();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-getSize().width)/2,(screenSize.height-getSize().height)/2);
		
		this.setVisible(true);
	
	}
 
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);

		}
		return jContentPane;
	}

	public void actionPerformed(ActionEvent evt) {

	}

	void open() {
		fileChooser.showOpenDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			fichier = fileChooser.getSelectedFile();
			try {
				FileInputStream fis = new FileInputStream(fichier);
				ObjectInputStream ois = new ObjectInputStream(fis);
				MonGraphe = (Multilingue) ois.readObject();
				ois.close();

			} catch (Exception err) {
				System.out.println("Erreur" + err);
			}
		}
	}
	
	void save() {
		if (fichier != null) {
			try {
				FileOutputStream fis = new FileOutputStream(fichier);
				ObjectOutputStream ois = new ObjectOutputStream(fis);
				ois.writeObject(MonGraphe);
				ois.close();
			} catch (Exception err) {
				System.out.println("Erreur" + err);
			}
		} else {
			saveAs();
		}
	}

	void saveAs() {
		fileChooser.showSaveDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			fichier = fileChooser.getSelectedFile();
			try {
				FileOutputStream fis = new FileOutputStream(fichier);
				ObjectOutputStream ois = new ObjectOutputStream(fis);
				ois.writeObject(MonGraphe);
				ois.close();
			} catch (Exception err) {
				System.out.println("Erreur" + err);
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Raccord de méthode auto-généré
		Principale pr = new Principale();
	//	pr.setBounds(150, 150, 600, 600);
		pr.setVisible(true);
		
	}	
} // @jve:decl-index=0:visual-constraint="8,56"
