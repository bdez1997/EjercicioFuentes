package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Manual extends JDialog {

	private JPanel contentPane;

	public Manual() {

		setTitle("Manual");
		setBounds(100, 100, 672, 226);
		setModal(true);

		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {
		JLabel todoElTexto = new JLabel();
		todoElTexto.setVerticalAlignment(SwingConstants.TOP);

		todoElTexto.setBounds(100, 100, 450, 300);
		todoElTexto.setText(controller.Ctrl.abrirManual());
		getContentPane().add(todoElTexto);

		JScrollPane scrollPane = new JScrollPane(todoElTexto);

		getContentPane().add(scrollPane, BorderLayout.CENTER);

	}

}
