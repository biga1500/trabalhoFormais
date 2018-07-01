package gramatica;

import javax.swing.JOptionPane;

/**************************************************************************************************************************************************
 * GI 0 ->Gramática Irrestrita ->Lado esquerdo: sequência de quaisquer
 * símbolos,desde que tenha um não-terminal Lado direito: qualquer sequência de
 * símbolos, inclusive a setença vazia 
 * GSC 1 -> Gramáticas Sensíveis ao
 * Contexto->Lado esquerdo: comprimento menor ou igual a sentença do lado
 * direito. Lado direito: comprimento maior ou igual a sentença do lado esquerdo
 * e não é aceita a setença vazia. 
 * GLC 2 -> Gramáticas Livres de Contexto ->
 * Lado esquerdo: sempre ocorrer um e apenas 1 nãoterminal. Lado direito: não é
 * aceita a setença vazia. 
 * GR 3 -> Gramáticas Regulares -> Lado esquerdo: deve
 * ocorrer sempre um e apenas um não-terminal. Lado direito:pode ocorrer ou
 * somente um terminal ou um terminal seguido de um não-terminal.
 **************************************************************************************************************************************************/
public class Producao {
	private String simbolos; // terminais ou não
	private int tipo; // 0,1,2,3
	private int compDir; // comprimento max ld
	private int compEsc; // comprimento max le

	public Producao(String simbolos) {
		this.simbolos = simbolos;
		String[] producaoSeparada = simbolos.split(">|;"); // separa o a string
															// pelos simbolos
		//LADO ESQUERDO
		this.compEsc = retornaComEsquerdo(producaoSeparada); //comprimento do lado esquerdo
		//System.out.println("Comprimento da Esquerda"+this.compEsc);
		int qtdNTerminalEsquerdo = getQtdNTerminaisEsquerdo(producaoSeparada); //retorna a qtd de NT do lado esquerdo
		//System.out.println("Tem só um não terminal no lado esquerdo?"+qtdNTerminalEsquerdo);
		boolean maiusculaMaiusculaEsquerdo = getMaiusculaMaiuscula(producaoSeparada);//verifica se tem 2 letras maiusculas do lado esquerdo
		
		//LADO DIREITO
		
		this.compDir = retornaComDireito(producaoSeparada);
		//System.out.println("Comprimento da direita"+this.compDir); //comprimento do lado direito
		boolean sentencaVaziaDireito = sentençaVaziaDir(producaoSeparada); //verifica se tem sent. vazia do lado direito
		//System.out.println("Tem Sentença Vazia"+sentencaVaziaDireito);
		boolean terminalTerminalNTerminalDireito= getTerminalNTerminalDireito(producaoSeparada);//lado direito  GR
		//System.out.println("Tem um n ou n seguido de NT do lado direito"+ terminalTerminalNTerminalDireito);
		
		if(sentencaVaziaDireito==true){ // se tem sentença vazia
			if((qtdNTerminalEsquerdo ==1)&&(terminalTerminalNTerminalDireito == true)){ //apenas 1 não terminal do lado esquerdo E 
																						//ou t ou tNT lado direito
				this.tipo =3;
			}else{
				this.tipo =0;
			}
		}else{ //não tem sentença vazia
			if((qtdNTerminalEsquerdo==1)){ // se tem apenas um não terminal do lado esquerdo
				if(terminalTerminalNTerminalDireito== true){//se tiver t ou tNT lado direito
					this.tipo = 3;
				}else{ //se tem apenas 1 NT do lado esquerdo e tem outra coisa do lado direito
					this.tipo =2;
				}
			}
			if(qtdNTerminalEsquerdo >1){ // se tiver mais de um não terminal do lado esquerdo
				if(compDir>=compEsc){
					this.tipo =1;
				}else{
					this.tipo=0;
				}
				
			}
		}
		
		
		//System.out.println("TIPO "+this.tipo);
	}

	private boolean getMaiusculaMaiuscula(String[] producaoSeparada) {
		boolean bol = false;

		if (producaoSeparada[0].length() > 1) { // verifica se tem 2 letras do lado esquerdo
			if (((producaoSeparada[0].charAt(0) > 64) && (producaoSeparada[0].charAt(0) < 91)//verifica se as letras são maiusculas
					&& ((producaoSeparada[0].charAt(1) > 64) && (producaoSeparada[0].charAt(1) < 91)))) {
				bol = true;
			}

		}
		return bol;
	}

	private boolean getTerminalNTerminalDireito(String[] producaoSeparada) { //verifica se do lado direito tem um terminal ou terminal seguido de não terminal
		boolean bol = true;
		for (int x = 1; x < producaoSeparada.length; x++) {
			if ((producaoSeparada[x].charAt(0) > 64) && (producaoSeparada[x].charAt(0) < 91)) { // se o primeiro de cada for maiusculo
				bol = false;	//não tem mais apenas um terminal ou um terminal seguido de um não terminal
			}

		}
		return bol;
	}
	

	private int getQtdNTerminaisEsquerdo(String[] producaoSeparada) { //conta a qtd de não terminais se 1 = true se >1 =->false
		
		int nTerminal = 0; // conta não terminais
		for (int x = 0; x < producaoSeparada[0].length(); x++) {
			if ((producaoSeparada[0].charAt(x) > 64) && (producaoSeparada[0].charAt(x) < 91)) {
				nTerminal++;
			}
		}
		
		return nTerminal;
	}

	// pega o tamanho do simbolo a direita
	public int retornaComDireito(String[] producaoSeparada) {
		int tamanho = producaoSeparada[1].length();
		for (int y = 1; y < producaoSeparada.length; y++) {
			if (producaoSeparada[y].length() > tamanho) {
				tamanho = producaoSeparada[y].length();
			}
		}

		return tamanho;
	}

	// pega tamanho do simbolo da esquerda
	public int retornaComEsquerdo(String[] producaoSeparada) {
		int tamanho = 0;

		tamanho = producaoSeparada[0].length();
		return tamanho;
	}

	// VERIFICA SE HÁ SENTENÇA VAZIA DO LADO DIREITO
	public boolean sentençaVaziaDir(String[] producaoSeparada) {
		boolean sentencaVaziaDireito = false;
		for (int x = 1; x < producaoSeparada.length; x++) {
			if (producaoSeparada[x].equals("&")) {
				sentencaVaziaDireito = true;
			}
		}
		return sentencaVaziaDireito;
	}

	public String getSimbolos() {
		return simbolos;
	}

	public void setSimbolos(String simbolos) {
		this.simbolos = simbolos;
	}

	public int getTipo() {
		return tipo;
	}

	public int getCompDir() {
		return compDir;
	}

	public int getCompEsc() {
		return compEsc;
	}
	
	public void setTipo(){
		
	}

}
