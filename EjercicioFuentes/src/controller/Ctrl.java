package controller;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ctrl {
	private static File fch;

	public static String abrirManual() {
		String sRuta = "Manual.txt";
		String sResultado = "";
		try {
			RandomAccessFile raFch = new RandomAccessFile(sRuta, "r");
			byte[] bFichero = new byte[(int) raFch.length()];
			raFch.readFully(bFichero);

			sResultado = new String(bFichero);
			raFch.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sResultado;
	}

	public static void guardarComo() {

		String sRuta = "";
		File fileName = null;
		JFileChooser guardarFch = new JFileChooser();
		guardarFch.setDialogTitle("Elija el fichero");
		int iOption = guardarFch.showSaveDialog(null);
		if (iOption != JFileChooser.CANCEL_OPTION) {
			fileName = guardarFch.getSelectedFile();
			if (fileName != null && !fileName.getName().equals("")) {
				sRuta = fileName.getAbsolutePath();
			}
		}

		try {
			RandomAccessFile fichero = new RandomAccessFile(fileName.getAbsolutePath(), "rw");

			String sTexto = view.Principal.textArea.getText();
			fichero.writeBytes(sTexto);
			fichero.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	public static void guardarFichero() {

		try {
			RandomAccessFile fichero = new RandomAccessFile(fch.getAbsolutePath(), "rw");

			String sTexto = view.Principal.textArea.getText();
			fichero.writeBytes(sTexto);
			fichero.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	public static void nuevoFichero() {
		view.Principal.textArea.setText("");
	}

	public static void abrirFichero() {
		JFileChooser buscar = new JFileChooser();
		String sResultado = "";

		buscar.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int iBtnFchr = buscar.showOpenDialog(null);
		fch = buscar.getSelectedFile();

		try {
			RandomAccessFile raFch = new RandomAccessFile(fch, "rw");
			byte[] bFichero = new byte[(int) raFch.length()];
			raFch.readFully(bFichero);

			sResultado = new String(bFichero);
			raFch.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.Principal.textArea.setText(sResultado);
	}

	public static String abrirAcercaDe() {
		String sRuta = "AcercaDe.txt";
		String sResultado = "";
		try {
			RandomAccessFile raFch = new RandomAccessFile(sRuta, "r");
			byte[] bFichero = new byte[(int) raFch.length()];
			raFch.readFully(bFichero);

			sResultado = new String(bFichero);
			raFch.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sResultado;
	}
}
