package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.ControllerMaster;
import controller.ControllerSolicitacao;
import dao.SolicitacaoDAO;
import model.Disciplina;
import model.PedidoQuebra;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import control.Quebra;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ViewSolicitacao extends JPanel {

	public ControllerSolicitacao controllerSolicitacao;
	ArrayList<String> materiasAprovadas;
	ArrayList<String> materiasReprovadas;

	/**
	 * Create the panel.
	 */
	public ViewSolicitacao(ControllerMaster controllerMaster) {
		materiasAprovadas = new ArrayList<>();
		materiasReprovadas = new ArrayList<>();
		setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		this.controllerSolicitacao = new ControllerSolicitacao();
		setSize(new Dimension(1264, 681));
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar ao Incio");
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
		

		
		JScrollPane scpRejeitadas = new JScrollPane();
		scpRejeitadas.setVisible(false);
		scpRejeitadas.setDoubleBuffered(true);
		scpRejeitadas.setBounds(644, 92, 610, 422);
		add(scpRejeitadas);
			
		JButton btnImportar = new JButton("Importar e Solicitar\r\n");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controllerSolicitacao.O CARA QUE CALCULA TUDO
				try {
					SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
					Quebra quebra = new Quebra();
					PedidoQuebra pedidoQuebra = new PedidoQuebra();
					pedidoQuebra.setDisciplinas(solicitacaoDAO.recuperarDisciplinas());
					List<List<Disciplina>> resultado = quebra.analisarPedido(pedidoQuebra);
					List<Disciplina> disciplinasAprovadas = resultado.get(0);
					List<Disciplina> disciplinasReprovadas = resultado.get(1);


					try {
						for (int i = 0; i < disciplinasAprovadas.size(); i++) {
							materiasAprovadas.add( 
								disciplinasAprovadas.get(i).getNomeDisciplina() + " / " +
								disciplinasAprovadas.get(i).getCodigoDisciplina() + " / " +
								disciplinasAprovadas.get(i).getPeriodoIdeal() + " / " +
								disciplinasAprovadas.get(i).getSituacao() + " / " +
								disciplinasAprovadas.get(i).getPeriodoIdeal()
							);
						}
					} catch (Exception error1) { }
					try {
						for (int i = 0; i < disciplinasReprovadas.size(); i++) {
							materiasReprovadas.add( 
								disciplinasReprovadas.get(i).getNomeDisciplina() + " / " +
								disciplinasReprovadas.get(i).getCodigoDisciplina() + " / " +
								disciplinasReprovadas.get(i).getPeriodoIdeal() + " / " +
								disciplinasReprovadas.get(i).getSituacao() + " / " +
								disciplinasReprovadas.get(i).getPeriodoIdeal()
							);
						}						
					} catch (Exception Error2) { }
					lblAprovadas.setVisible(true);
					lblRejeitadas.setVisible(true);
					scpAprovadas.setVisible(true);

					JList lstAprovadas = new JList(materiasAprovadas.toArray());
					lstAprovadas.setVisible(true);
					lstAprovadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scpAprovadas.setViewportView(lstAprovadas);
					lstAprovadas.setSelectionBackground(new Color(243, 215, 245));
					lstAprovadas.setFont(new Font("Arial", Font.ITALIC, 18));
					lstAprovadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
					lstAprovadas.setBackground(new Color(231, 245, 220));

					scpRejeitadas.setVisible(true);
					
					JList lstRejeitadas = new JList(materiasReprovadas.toArray());
					lstRejeitadas.setVisible(true);
					lstRejeitadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scpRejeitadas.setViewportView(lstRejeitadas);
					lstRejeitadas.setSelectionBackground(new Color(243, 215, 245));
					lstRejeitadas.setFont(new Font("Arial", Font.ITALIC, 18));
					lstRejeitadas.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
					lstRejeitadas.setBackground(new Color(231, 245, 220));

					lstAprovadas.revalidate();
					lstRejeitadas.revalidate();
					lstAprovadas.repaint();
					lstRejeitadas.repaint();

					revalidate();
					repaint();
				} catch (Exception error) {System.out.println(error.getMessage());}
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
