package calculator;

import javax.swing.*;
import java.awt.event.*;


public class Main extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	//Seta matanho das JTextField na tela
	final static int HEIGHT = 30;
	
	//Definir Objetos da Tela
	JTextField tela_da_conta = new JTextField("1 + 1");
	JTextField resultado = new JTextField("RESULTADO");
	JButton calcular = new JButton("OK");
	
	
	String oper_string;
	
	public Main() {
		
		//Dar parâmetro dos objetos da tela posição,tamanho,etc
		tela_da_conta.setBounds(10, 0, 330, HEIGHT);

		resultado.setBounds(10, (HEIGHT*3)+(3*10), 330, HEIGHT);
		resultado.setEditable(false);
		
		calcular.setBounds(10, (HEIGHT*4)+(4*10), 80, 50);
		calcular.setActionCommand("calculate");
		calcular.addActionListener(this);
		
		//Cria uma Janela
		JFrame window = new JFrame("Calculator");
		
		window.setLayout(null);
		
		//Definir algumas opções da janela
		window.setSize(350, 250);
		window.setResizable(false);
		window.setVisible(true);		

		//Adicionar objetos a janela
		window.add(tela_da_conta);
		window.add(resultado);
		window.add(calcular);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			String com[]=tela_da_conta.getText().split(" ");
			float stack=Float.parseFloat(com[0]);
			
			for(int i=0;i<com.length-1;i++){
				switch(com[i]) {
					case "+":
						stack+=Float.parseFloat(com[i+1]);
						break;
					case "-":
						stack-=Float.parseFloat(com[i+1]);
						break;
					case "x":case "*":
						stack*=Float.parseFloat(com[i+1]);
						break;
					case "%":case "/":
						stack/=Float.parseFloat(com[i+1]);
						break;
				}
			}
			resultado.setText(Float.toString(stack));
		}catch(Exception n){
			resultado.setText("ERRO!");
		}
	}

}