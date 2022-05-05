package view;

import javax.swing.JPanel;

import controller.ControllerMaster;
import controller.ControllerPrincipal;
import controller.ControllerSelecao;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class ViewSelecao extends JPanel {

	public ControllerPrincipal controllerPrincipal;
	public ControllerSelecao controllerSelecao;
	
	/* 
	public void carregaListaCursadas(DefaultListModel<String> model) {		
		model.addElement("Calculo 1A");
		model.addElement("Analise de Algoritmos");		
	}
	*/
	
	/**
	 * Create the panel.
	 */
	public ViewSelecao(ControllerMaster controllerMaster) {
		this.controllerSelecao = new ControllerSelecao(controllerMaster);
		setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		this.controllerPrincipal = new ControllerPrincipal(controllerMaster);
		setSize(new Dimension(1264, 681));
		setLayout(null);
		

		JButton btnVoltar = new JButton("Voltar\r\n");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerMaster.navegaTelaPrincipal();
			}
		});
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(new Color(243, 215, 245));
		btnVoltar.setBounds(1066, 93, 185, 65);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Informa\u00E7\u00F5es do Aluno: ");
		lblNewLabel.setBounds(25, 25, 272, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		lblNewLabel_1.setBounds(0, 161, 1319, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		add(lblNewLabel_1);
		
		JLabel lblPreBarreira = new JLabel("Mat\u00E9rias Pr\u00E9-Barreira a Cursar");
		lblPreBarreira.setOpaque(true);
		lblPreBarreira.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreBarreira.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblPreBarreira.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblPreBarreira.setBackground(new Color(231, 245, 220));
		lblPreBarreira.setBounds(432, 197, 390, 70);
		add(lblPreBarreira);
		
		JLabel lblCursadas = new JLabel("Mat\u00E9rias J\u00E1 Cursadas");
		lblCursadas.setOpaque(true);
		lblCursadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCursadas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblCursadas.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblCursadas.setBackground(new Color(231, 245, 220));
		lblCursadas.setBounds(10, 197, 400, 70);
		add(lblCursadas);
		
		JLabel lblPosBarreira = new JLabel("Mat\u00E9rias P\u00F3s-Barreira a Cursar");
		lblPosBarreira.setOpaque(true);
		lblPosBarreira.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosBarreira.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblPosBarreira.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblPosBarreira.setBackground(new Color(231, 245, 220));
		lblPosBarreira.setBounds(854, 197, 400, 70);
		add(lblPosBarreira);
		
		ArrayList<String> materiasCursadas = controllerSelecao.carregaHistorico();
		ArrayList<String> materiasPreBarreira = controllerSelecao.carregarPreBarreira();
		ArrayList<String> materiasPosBarreira = controllerSelecao.carregarPosBarreira();
		
		JScrollPane scpCursadas = new JScrollPane();
		scpCursadas.setDoubleBuffered(true);
		scpCursadas.setBounds(10, 278, 400, 392);
		add(scpCursadas);
		
		JList lstCursadas = new JList(materiasCursadas.toArray());
		lstCursadas.setFixedCellHeight(35);
		lstCursadas.setEnabled(false);
		lstCursadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scpCursadas.setViewportView(lstCursadas);
		lstCursadas.setFont(new Font("Arial", Font.ITALIC, 16));
		lstCursadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstCursadas.setBackground(new Color(231, 245, 220));
		
		JScrollPane scpPreBarreira = new JScrollPane();
		scpPreBarreira.setDoubleBuffered(true);
		scpPreBarreira.setBounds(432, 278, 390, 392);
		add(scpPreBarreira);
		
		JList lstPreBarreira = new JList(materiasPreBarreira.toArray());
		lstPreBarreira.setFixedCellHeight(35);
		lstPreBarreira.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lstPreBarreira.setSelectionBackground(new Color(243, 215, 245));
		scpPreBarreira.setViewportView(lstPreBarreira);
		lstPreBarreira.setFont(new Font("Arial", Font.ITALIC, 16));
		lstPreBarreira.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstPreBarreira.setBackground(new Color(231, 245, 220));
		
		JScrollPane scpPosBarreira = new JScrollPane();
		scpPosBarreira.setDoubleBuffered(true);
		scpPosBarreira.setBounds(854, 278, 400, 392);
		add(scpPosBarreira);
		
		JList lstPosBarreira = new JList(materiasPosBarreira.toArray());
		lstPosBarreira.setFixedCellHeight(35);
		lstPosBarreira.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scpPosBarreira.setViewportView(lstPosBarreira);
		lstPosBarreira.setSelectionBackground(new Color(243, 215, 245));
		lstPosBarreira.setFont(new Font("Arial", Font.ITALIC, 16));
		lstPosBarreira.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstPosBarreira.setBackground(new Color(231, 245, 220));
		
		String informacoesAluno = controllerSelecao.pegarInformacoesAluno();
		JLabel lblNewLabel_2 = new JLabel(informacoesAluno);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(25, 113, 728, 25);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Use o Ctrl ou o Shift para selecionar mais de um");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(449, 180, 356, 14);
		add(lblNewLabel_3);
		
		JButton btnGerarcsv = new JButton("Gerar .csv e Solicitar");
		btnGerarcsv.setBounds(1067, 8, 185, 65);
		btnGerarcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] preBarreiraSelected = lstPreBarreira.getSelectedIndices();
				int[] posBarreiraSelected = lstPosBarreira.getSelectedIndices();
				try {
					controllerSelecao.geraCSV(preBarreiraSelected, posBarreiraSelected, materiasPreBarreira, materiasPosBarreira);
					controllerMaster.navegaTelaSolicitacao();
				} catch (Exception ex) { System.out.print(ex); }
			}
		});
		btnGerarcsv.setFont(new Font("Arial", Font.BOLD, 15));
		btnGerarcsv.setBorderPainted(false);
		btnGerarcsv.setBackground(new Color(243, 215, 245));
		add(btnGerarcsv);
		
		// DefaultListModel<String> model = new DefaultListModel<String>();
		// carregaListaCursadas(model);
		}
}
