package view;

import javax.swing.JPanel;

import controller.ControllerMaster;
import controller.ControllerPrincipal;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
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
		setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		this.controllerPrincipal = new ControllerPrincipal();
		setSize(new Dimension(1264, 681));
		setLayout(null);
		
		JButton btnGerarcsv = new JButton("Gerar .csv e Solicitar");
		btnGerarcsv.setBounds(1067, 8, 185, 65);
		btnGerarcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerMaster.navegaTelaSolicitacao();
			}
		});
		btnGerarcsv.setFont(new Font("Arial", Font.BOLD, 15));
		btnGerarcsv.setBorderPainted(false);
		btnGerarcsv.setBackground(new Color(243, 215, 245));
		add(btnGerarcsv);
		
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
		lblNewLabel.setBounds(10, 24, 272, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		add(lblNewLabel);
		
		JLabel lblInformaesDoSemestre = new JLabel("Informa\u00E7\u00F5es do Semestre Passado: ");
		lblInformaesDoSemestre.setBounds(10, 75, 390, 25);
		lblInformaesDoSemestre.setFont(new Font("Arial", Font.BOLD, 22));
		add(lblInformaesDoSemestre);
		
		JLabel lblMatriasRecomendadas = new JLabel("Mat\u00E9rias Recomendadas: ");
		lblMatriasRecomendadas.setBounds(10, 125, 287, 25);
		lblMatriasRecomendadas.setFont(new Font("Arial", Font.BOLD, 22));
		add(lblMatriasRecomendadas);
		
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
		
		String[] materiasCursadas = {"Calculo 1A / CMA211 / Disponvel / 1, Obrigatria", "Algoritmos e Estrutura de Dados 1 / CI100 / Disponvel / 1, Obrigatria", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1", "Algoritmos e Estrutura de Dados 1"};
		String[] materiasPreBarreira = {"Calculo 1A / CMA211 / Disponvel / 1, Obrigatria", "Algoritmos e Estrutura de Dados 1 / CI100 / Disponvel / 1, Obrigatria"};
		String[] materiasPosBarreira = {"Calculo 1A / CMA211 / Disponvel / 1, Obrigatria", "Algoritmos e Estrutura de Dados 1 / CI100 / Disponvel / 1, Obrigatria"};
		
		JScrollPane scpCursadas = new JScrollPane();
		scpCursadas.setDoubleBuffered(true);
		scpCursadas.setBounds(10, 278, 400, 392);
		add(scpCursadas);
		
		JList lstCursadas = new JList(materiasCursadas);
		lstCursadas.setEnabled(false);
		lstCursadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scpCursadas.setViewportView(lstCursadas);
		lstCursadas.setFont(new Font("Arial", Font.ITALIC, 18));
		lstCursadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstCursadas.setBackground(new Color(231, 245, 220));
		
		JScrollPane scpPreBarreira = new JScrollPane();
		scpPreBarreira.setDoubleBuffered(true);
		scpPreBarreira.setBounds(432, 278, 390, 392);
		add(scpPreBarreira);
		
		JList lstPreBarreira = new JList(materiasPreBarreira);
		lstPreBarreira.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lstPreBarreira.setSelectionBackground(new Color(243, 215, 245));
		scpPreBarreira.setViewportView(lstPreBarreira);
		lstPreBarreira.setFont(new Font("Arial", Font.ITALIC, 18));
		lstPreBarreira.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstPreBarreira.setBackground(new Color(231, 245, 220));
		
		JScrollPane scpPosBarreira = new JScrollPane();
		scpPosBarreira.setDoubleBuffered(true);
		scpPosBarreira.setBounds(854, 278, 400, 392);
		add(scpPosBarreira);
		
		JList lstPosBarreira = new JList(materiasPosBarreira);
		lstPosBarreira.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scpPosBarreira.setViewportView(lstPosBarreira);
		lstPosBarreira.setSelectionBackground(new Color(243, 215, 245));
		lstPosBarreira.setFont(new Font("Arial", Font.ITALIC, 18));
		lstPosBarreira.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		lstPosBarreira.setBackground(new Color(231, 245, 220));
		
		JLabel lblNewLabel_2 = new JLabel("Podemos escrever aqui tamb\u00E9m");
		lblNewLabel_2.setBounds(10, 53, 223, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Podemos escrever aqui tamb\u00E9m");
		lblNewLabel_2_1.setBounds(248, 32, 223, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Use o Ctrl ou o Shift para selecionar mais de um");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(449, 180, 356, 14);
		add(lblNewLabel_3);

		
		// DefaultListModel<String> model = new DefaultListModel<String>();
		// carregaListaCursadas(model);
		}
}
