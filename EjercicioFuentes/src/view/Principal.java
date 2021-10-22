package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Fuente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().createImage("RGB.jpg"));
		crearComponentes();
		setVisible(true);

	}

	private void crearComponentes() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnuArchivo = new JMenu("Archivo");
		menuBar.add(mnuArchivo);

		JMenuItem mnItmNuevo = new JMenuItem("Nuevo");
		mnuArchivo.add(mnItmNuevo);

		JMenuItem mnuItmAbrir = new JMenuItem("Abrir");

		mnuArchivo.add(mnuItmAbrir);

		JMenuItem mnuItmGuardar = new JMenuItem("Guardar");
		mnuArchivo.add(mnuItmGuardar);

		JMenuItem mntItmGuardarComo = new JMenuItem("Guardar Como");
		mntItmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ctrl.guardarComo();
			}
		});
		mnuArchivo.add(mntItmGuardarComo);

		JMenuItem mnuItmSalir = new JMenuItem("Salir");
		mnuArchivo.addSeparator();
		mnuArchivo.add(mnuItmSalir);

		JMenu mnuAyuda = new JMenu("Ayuda");
		menuBar.add(mnuAyuda);

		JMenuItem mnuItmManual = new JMenuItem("Manual");

		mnuItmManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manual();
			}
		});
		mnuAyuda.add(mnuItmManual);

		JMenuItem mnuItmAcercaDe = new JMenuItem("Acerca de");
		mnuItmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AcercaDe();
			}
		});

		mnItmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ctrl.nuevoFichero();
			}
		});

		mnuItmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ctrl.abrirFichero();
			}
		});

		mnuItmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iOption = JOptionPane.showConfirmDialog(null, "¿Seguro qué quieres cerrar la aplicación?",
						"Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (iOption == 0) {
					System.exit(0);
				}

			}
		});

		mnuItmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ctrl.guardarFichero();
			}
		});
		
		

		mnuAyuda.add(mnuItmAcercaDe);
		getContentPane().setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);

	}
}
