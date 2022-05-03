package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Cursor;

import controller.ControllerMaster;

import java.awt.Color;

public class ViewMaster {

	private JFrame frmCrudQuebra;
	public ControllerMaster controllerMaster;
	private ViewPrincipal viewPrincipal;
	private ViewSelecao viewSelecao;
	private ViewSolicitacao viewSolicitacao;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMaster window = new ViewMaster();					
					window.frmCrudQuebra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMaster() {
		this.controllerMaster = new ControllerMaster(this);
		initializeWindow();
		carregaViewPrincipal();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeWindow() {
		frmCrudQuebra = new JFrame();
		frmCrudQuebra.setResizable(false);
		frmCrudQuebra.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmCrudQuebra.getContentPane().setBackground(new Color(238, 242, 244));
		frmCrudQuebra.setBackground(Color.BLACK);
		frmCrudQuebra.getContentPane().setForeground(Color.BLACK);
		frmCrudQuebra.setTitle("CRUD - Quebra de Barreira\r\n");
		frmCrudQuebra.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmCrudQuebra.setSize(new Dimension(1280, 720));
		frmCrudQuebra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudQuebra.getContentPane().setLayout(null);
	}
	
	public void carregaViewPrincipal() {
		try {
			frmCrudQuebra.remove(viewSelecao);
		} catch(Exception e) { }
		try {
			frmCrudQuebra.remove(viewSolicitacao);
		} catch(Exception e) { }
		this.viewPrincipal = new ViewPrincipal(controllerMaster);
		viewPrincipal.setBounds(0, 0, 1264, 681);
		viewPrincipal.setVisible(true);
		frmCrudQuebra.getContentPane().add(viewPrincipal);
		frmCrudQuebra.revalidate();
		frmCrudQuebra.repaint();
	}
	
	public void carregaViewSelecao() {	
		try {
			frmCrudQuebra.remove(viewPrincipal);
		} catch(Exception e) { }
		try {
			frmCrudQuebra.remove(viewSolicitacao);
		} catch(Exception e) { }
		this.viewSelecao = new ViewSelecao(controllerMaster);
		viewSelecao.setVisible(true);
		frmCrudQuebra.getContentPane().add(viewSelecao);
		frmCrudQuebra.revalidate();
		frmCrudQuebra.repaint();
	}
	
	public void carregaViewSolicitacao() {
		try {
			frmCrudQuebra.remove(viewPrincipal);			
		} catch(Exception e) { }
		try {
			frmCrudQuebra.remove(viewSelecao);
		} catch(Exception e) { }
		this.viewSolicitacao = new ViewSolicitacao(controllerMaster);
		viewSolicitacao.setVisible(true);
		frmCrudQuebra.getContentPane().add(viewSolicitacao);
		frmCrudQuebra.revalidate();
		frmCrudQuebra.repaint();		
	}
}
