package gramatica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraJanela extends JFrame {

	private JPanel contentPane;
	private JTextField txtSimboloProducao;
	private JTextField txtSProd;
	private JLabel lblProd;
	private JLabel lblChave;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblSentenaVazia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraJanela frame = new PrimeiraJanela();
					frame.setVisible(true);
					frame.setTitle("Trabalho I Linguagens Formais");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeiraJanela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 415);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtSProd != null) {
					String a = txtSProd.getText();
					a = a.toUpperCase();
					textField.setText(a);
				}
				if (txtSimboloProducao != null) {
					String a = txtSimboloProducao.getText();
					a = a.toUpperCase();
					lblProd.setText(a + "{");
					lblChave.setText("}");
				}

			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite a gram\u00E1tica de entrada nos devidos campos.");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(82, 11, 248, 23);
		contentPane.add(lblNewLabel);

		JLabel lblSimbolosNoTerminais = new JLabel(
				"S\u00EDmbolos n\u00E3o em min\u00FAsculas e s\u00EDmbolos n\u00E3o terminais em letras min\u00FAsculas");
		lblSimbolosNoTerminais.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSimbolosNoTerminais.setBounds(32, 33, 380, 14);
		contentPane.add(lblSimbolosNoTerminais);

		JLabel lblSmboloDeProduo = new JLabel("S\u00EDmbolo do conjunto de Produ\u00E7\u00E3o:");
		lblSmboloDeProduo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSmboloDeProduo.setBounds(32, 58, 170, 14);
		contentPane.add(lblSmboloDeProduo);

		txtSimboloProducao = new JTextField();
		txtSimboloProducao.setBounds(212, 55, 35, 20);
		contentPane.add(txtSimboloProducao);
		txtSimboloProducao.setColumns(10);

		JLabel lblInicioDeProduo = new JLabel("Simbolo de Inicio de Produ\u00E7\u00E3o :");
		lblInicioDeProduo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblInicioDeProduo.setBounds(32, 83, 163, 23);
		contentPane.add(lblInicioDeProduo);

		txtSProd = new JTextField();
		txtSProd.setBounds(212, 84, 35, 20);
		contentPane.add(txtSProd);
		txtSProd.setColumns(10);

		JLabel lblConjuntoDeProdues = new JLabel("Conjunto de Produ\u00E7\u00F5es da Gram\u00E1tica:");
		lblConjuntoDeProdues.setFont(new Font("Arial", Font.PLAIN, 11));
		lblConjuntoDeProdues.setBounds(32, 113, 199, 14);
		contentPane.add(lblConjuntoDeProdues);

		lblProd = new JLabel("");
		lblProd.setBounds(31, 141, 46, 14);
		contentPane.add(lblProd);

		lblChave = new JLabel("");
		lblChave.setBounds(32, 290, 46, 14);
		contentPane.add(lblChave);

		JButton btnGeraTipoFormalismo = new JButton("Gerar o tipo de Gram\u00E1tica e o formalismo ");
		btnGeraTipoFormalismo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtSimboloProducao.getText().equals("") || txtSProd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Verifique campos vazios");
				} else {
					
					Integer tipos[] = new Integer[4];
					if (!textField.getText().equals("")) {
						Producao p = new Producao(textField.getText());
					
						tipos[0] = p.getTipo();
					} else {
						JOptionPane.showMessageDialog(null, "O campo de produções");
					}
					if (!textField_1.getText().equals("")) {
						Producao p1 = new Producao(textField_1.getText());
						tipos[1] = p1.getTipo();
					}
					if (!textField_2.getText().equals("")) {
						Producao p2 = new Producao(textField_2.getText());
						tipos[2] = p2.getTipo();
					}
					if (!textField_3.getText().equals("")) {
						Producao p3 = new Producao(textField_3.getText());
						tipos[3] = p3.getTipo();
					}
					int min = 3;
					if (!textField_1.getText().equals("")) {

						for (int x = 1; x < tipos.length; x++) {
							if (tipos[x] != null) {
								if (tipos[x] < min) {
									min = tipos[x];
								}
							}
						}
					} else {
						for (int x = 0; x < tipos.length; x++) {
							if (tipos[x] != null) {
								if (tipos[x] < min) {
									min = tipos[x];
								}
							}
						}
					}

					if (min == 3) {
						JOptionPane.showMessageDialog(null, "Gramática Regular");
					} else if (min == 2) {
						JOptionPane.showMessageDialog(null, "Gramática Livre de Contexto");
					} else if (min == 1) {
						JOptionPane.showMessageDialog(null, "Gramática Sensível ao contexto");
					} else if (min == 0) {
						JOptionPane.showMessageDialog(null, "Gramática Irrestrita");
					}
					
					String simbConjProd = txtSimboloProducao.getText().toUpperCase(); //P
					String simbInicioProd = txtSProd.getText().toUpperCase();//S
					
					Character u = simbInicioProd.charAt(0);
					
					//Transforma todas as os txtFields em uma String unica
					String todos= textField.getText()+"."+textField_1.getText()+"."+textField_2.getText()+"."+textField_3.getText();
					//System.out.println("todos dos textos: "+ todos);
					
					ArrayList<Character> mai = new ArrayList<>();
					mai.add(u);
					ArrayList<Character> minu = new ArrayList<>();
					for (int x = 0; x < todos.length(); x++) { //passa pela String gerada
						if ((todos.charAt(x) > 64) && (todos.charAt(x) < 91)) { //Separa para os arraylists se minuscula ou maiuscula
								mai.add(todos.charAt(x));
						}
						if ((todos.charAt(x) > 96) && (todos.charAt(x) < 123)) {
							minu.add(todos.charAt(x));
						}
					}
					
					//set é uma coleção de objetos unicos, que quando se adiciona repetidos estes sao descartados
					Set<Character> maiusculos = new HashSet<>();
					for(Character a : mai){
						maiusculos.add(a);
					}
					Set<Character> minusculos = new HashSet<>();
					for(Character a : minu){
						minusculos.add(a);
					}
					
					//System.out.println("G:{"+maiusculos+","+minusculos+","+simbConjProd+","+simbInicioProd+"}");
					JOptionPane.showMessageDialog(null, "G:{"+maiusculos+","+minusculos+","+simbConjProd+","+simbInicioProd+"}");
					
				}
				
				
				
				
			}

		});
		btnGeraTipoFormalismo.setBounds(261, 227, 240, 52);
		contentPane.add(btnGeraTipoFormalismo);

		textField = new JTextField();
		textField.setBounds(32, 166, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 199, 219, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 228, 219, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(32, 259, 218, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblSabsa = new JLabel("S>aB;Sa;...");
		lblSabsa.setBounds(261, 202, 70, 14);
		contentPane.add(lblSabsa);
		
		lblSentenaVazia = new JLabel("Senten\u00E7a Vazia : &");
		lblSentenaVazia.setBounds(261, 187, 111, 14);
		contentPane.add(lblSentenaVazia);

	}
}
