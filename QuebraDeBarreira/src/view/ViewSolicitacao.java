package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.ControllerMaster;
import controller.ControllerPrincipal;
import controller.ControllerSolicitacao;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ViewSolicitacao extends JPanel {

	public ControllerSolicitacao controllerSolicitacao;
	
	/**
	 * Create the panel.
	 */
	public ViewSolicitacao(ControllerMaster controllerMaster) {
		setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		this.controllerSolicitacao = new ControllerSolicitacao();
		setSize(new Dimension(1264, 681));
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar ao Início");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerMaster.navegaTelaPrincipal();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 22));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(new Color(243, 215, 245));
		btnVoltar.setBounds(10, 570, 420, 100);
		add(btnVoltar);
		

		
		JLabel lblNewLabel_1 = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(0, 525, 1319, 25);
		add(lblNewLabel_1);
		
		JLabel lblAprovadas = new JLabel("Mat\u00E9rias Aprovadas\r\n");
		lblAprovadas.setVisible(false);
		lblAprovadas.setOpaque(true);
		lblAprovadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAprovadas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		lblAprovadas.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblAprovadas.setBackground(new Color(231, 245, 220));
		lblAprovadas.setBounds(110, 11, 400, 70);
		add(lblAprovadas);
		
		JLabel lblRejeitadas = new JLabel("Mat\u00E9rias Rejeitadas");
		lblRejeitadas.setVisible(false);
		lblRejeitadas.setOpaque(true);
		lblRejeitadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRejeitadas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		lblRejeitadas.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblRejeitadas.setBackground(new Color(231, 245, 220));
		lblRejeitadas.setBounds(754, 11, 400, 70);
		add(lblRejeitadas);
		
		JScrollPane scpAprovadas = new JScrollPane();
		scpAprovadas.setVisible(false);
		scpAprovadas.setDoubleBuffered(true);
		scpAprovadas.setBounds(10, 92, 610, 422);
		add(scpAprovadas);
		
		String[] materiasAprovadas = {"Calculo 1A / CMA211 / Disponível / 1, Obrigatória", "Algoritmos e Estrutura de Dados 1 / CI100 / Disponível / 1, Obrigatória"};
		String[] materiasRejeitadas = {"Calculo 1A / CMA211 / Disponível / 1, Obrigatória", "Algoritmos e Estrutura de Dados 1 / CI100 / Disponível / 1, Obrigatória"};
		
		JList lstAprovadas = new JList(materiasAprovadas);
		lstAprovadas.setVisible(false);
		lstAprovadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scpAprovadas.setViewportView(lstAprovadas);
		lstAprovadas.setSelectionBackground(new Color(243, 215, 245));
		lstAprovadas.setFont(new Font("Arial", Font.ITALIC, 18));
		lstAprovadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstAprovadas.setBackground(new Color(231, 245, 220));
		
		JScrollPane scpRejeitadas = new JScrollPane();
		scpRejeitadas.setVisible(false);
		scpRejeitadas.setDoubleBuffered(true);
		scpRejeitadas.setBounds(644, 92, 610, 422);
		add(scpRejeitadas);
		
		JList lstRejeitadas = new JList(materiasRejeitadas);
		lstRejeitadas.setVisible(false);
		lstRejeitadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scpRejeitadas.setViewportView(lstRejeitadas);
		lstRejeitadas.setSelectionBackground(new Color(243, 215, 245));
		lstRejeitadas.setFont(new Font("Arial", Font.ITALIC, 18));
		lstRejeitadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstRejeitadas.setBackground(new Color(231, 245, 220));
		
		JButton btnImportar = new JButton("Importar e Solicitar\r\n");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controllerSolicitacao.O CARA QUE CALCULA TUDO
				lblAprovadas.setVisible(true);
				lblRejeitadas.setVisible(true);
				scpAprovadas.setVisible(true);
				lstAprovadas.setVisible(true);	
				scpRejeitadas.setVisible(true);
				lstRejeitadas.setVisible(true);
				revalidate();
				repaint();
			}
		});
		btnImportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImportar.setFont(new Font("Arial", Font.BOLD, 22));
		btnImportar.setBorderPainted(false);
		btnImportar.setBackground(new Color(243, 215, 245));
		btnImportar.setBounds(834, 570, 420, 100);
		add(btnImportar);
	}
}
