package gramatica;

/**************************************************************************************************************************************************
 * GI  ->Gramática Irrestrita ->Lado esquerdo: sequência de quaisquer símbolos, desde que tenha um não-terminal 								  *
 *                             Lado direito: qualquer sequência de símbolos, inclusive a setença vazia                                            *
 *GSC -> Gramáticas Sensíveis ao Contexto->Lado esquerdo: comprimento menor ou igual a sentença do lado direito.                                  *
 * 							               Lado direito: comprimento maior ou igual a sentença do lado esquerdo e não é aceita a setença vazia.   *
 *GLC -> Gramáticas Livres de Contexto -> Lado esquerdo: sempre ocorrer um e apenas 1 nãoterminal                                                 *
 *										  Lado direito: não é aceita a setença vazia                                                              *
 *GR  -> Gramáticas Regulares -> Lado esquerdo: deve ocorrer sempre um e apenas um não-terminal.                                                  *
 *								 Lado direito: pode ocorrer ou somente um terminal ou um terminal seguido de um não-terminal.                     *
 **************************************************************************************************************************************************/
public class Gramatica {
	Producao[] sentencas;
	private String tipo;
	private String formalismo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFormalismo() {
		return formalismo;
	}

	public void setFormalismo(String formalismo) {
		this.formalismo = formalismo;
	}
}
