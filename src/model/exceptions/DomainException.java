package model.exceptions;

public class DomainException extends RuntimeException{ // Runtime não é obrigado a tratar as exceções

	private static final long serialVersionUID = 1L; // RunTime não obriga a tratar a exceção com apenas o extends sim

	public DomainException(String msg) { // permite instanciar construtor passando uma msg para ela
		super(msg);
	}
	
}
