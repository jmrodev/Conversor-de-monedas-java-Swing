package wall;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class conversor extends JFrame {

	private JPanel contentPane;
	private JTextField value;
	private JComboBox options;
	private JButton convert;
	private JLabel result;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversor frame = new conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public conversor() {
		setTitle("Conversor One");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor moneda");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 13));
		lblNewLabel.setBounds(194, 12, 136, 25);
		contentPane.add(lblNewLabel);
		
		options = new JComboBox();
		options.setModel(new DefaultComboBoxModel(new String[] {"Pesos a dolares", "Dolares a pesos"}));
		options.setBounds(34, 117, 120, 25);
		contentPane.add(options);
		
		JLabel lblNewLabel_1 = new JLabel("   Ingrese monto");
		lblNewLabel_1.setBounds(34, 80, 105, 25);
		contentPane.add(lblNewLabel_1);
		
		value = new JTextField();
		value.setBounds(164, 82, 105, 21);
		contentPane.add(value);
		value.setColumns(10);
		
		convert = new JButton("Convertir");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String currencyIn = value.getText();
				double currency = Double.parseDouble(currencyIn);
				double exchange = 600;
				double finalResult = 0;
				DecimalFormat DecimalFormat = new DecimalFormat("0.00");				
				if (options.getSelectedIndex()==0) {
					finalResult =(currency/exchange);
					result.setText("Resultado: "+ DecimalFormat.format(finalResult));
				}else {
					finalResult =(currency*exchange);
					result.setText("Resultado: "+ DecimalFormat.format(finalResult));
				}
			}
		});
		convert.setBounds(164, 116, 105, 27);
		contentPane.add(convert);
		
		JButton Exit = new JButton("Salir");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setBounds(401, 262, 105, 25);
		contentPane.add(Exit);
		
		result = new JLabel("0");
		result.setBounds(62, 155, 136, 25);
		contentPane.add(result);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/jmro/workspace/wall/chart-6716410_1920.jpg"));
		lblNewLabel_2.setBounds(287, 59, 208, 127);
		contentPane.add(lblNewLabel_2);
	}
}
