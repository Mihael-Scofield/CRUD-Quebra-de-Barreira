package view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.ControllerMaster;
import controller.ControllerPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewPrincipal extends JPanel {

	public ControllerPrincipal controllerPrincipal;
	/**
	 * Create the panel.
	 */
	public ViewPrincipal(ControllerMaster controllerMaster) {
		this.controllerPrincipal = new ControllerPrincipal(controllerMaster);
		setSize(new Dimension(1264, 681));
		setLayout(null);

		JButton btnHistorico = new JButton("Importar Hist\u00F3rico");
		btnHistorico.setBounds(50, 400, 250, 90);
		btnHistorico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHistorico.setFont(new Font("Arial", Font.BOLD, 18));
		btnHistorico.setBorderPainted(false);
		btnHistorico.setBackground(new Color(243, 215, 245));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean navegar = controllerPrincipal.importarHistorico();
				if (navegar == true) {
					controllerMaster.navegaTelaSelecao();
				}
			}
		});
		add(btnHistorico);
		
		JButton btnGrade = new JButton("Importar Grade\r\n");
		btnGrade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGrade.setFont(new Font("Arial", Font.BOLD, 18));
		btnGrade.setBorderPainted(false);
		btnGrade.setBackground(new Color(243, 215, 245));
		btnGrade.setBounds(490, 400, 250, 90);
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean navegar = controllerPrincipal.importarGrade();
				if (navegar == true) {
					controllerMaster.navegaTelaSelecao();
				}
			}
		});
		add(btnGrade);
		
		JButton btnNvgSolicitacao = new JButton("Tela de Solicita\u00E7\u00E3o");
		btnNvgSolicitacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerMaster.navegaTelaSolicitacao();
			}
		});
		btnNvgSolicitacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNvgSolicitacao.setFont(new Font("Arial", Font.BOLD, 18));
		btnNvgSolicitacao.setBorderPainted(false);
		btnNvgSolicitacao.setBackground(new Color(243, 215, 245));
		btnNvgSolicitacao.setBounds(935, 400, 250, 90);
		add(btnNvgSolicitacao);
		
		JLabel lblTitulo = new JLabel(
				"Importe os dois arquivos .csv ou v\u00E1 direto para a tela de solicita\u00E7\u00E3o");
		lblTitulo.setOpaque(true);
		lblTitulo.setBounds(235, 85, 809, 70);
		lblTitulo.setBackground(new Color(231, 245, 220));
		add(lblTitulo);
		lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
