package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AcercaDe extends JDialog {

	private JPanel contentPane;

	public AcercaDe() {
		setTitle("Acerca de");

		setBounds(100, 100, 350, 150);
		setModal(true);
		crearComponentes();
		setVisible(true);

	}

	private void crearComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("RGBAcercaDe.jpg"));
		lblNewLabel.setBounds(10, 11, 78, 68);
		contentPane.add(lblNewLabel);

		JLabel lblTextoAcercaDe = new JLabel();
		lblTextoAcercaDe.setVerticalAlignment(SwingConstants.TOP);
		lblTextoAcercaDe.setBounds(153, 11, 173, 148);
		lblTextoAcercaDe.setText(controller.Ctrl.abrirAcercaDe());
		contentPane.add(lblTextoAcercaDe);

	}
}
