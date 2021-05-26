package pt.amane.bookstore.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestemp, Integer status, String messeger) {
		super(timestemp, status, messeger);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	/**
	 * no lugar de setErrors, mudamos para addErrorpassando parametro de
	 * fieldMessage e message que sao atributro da classe fielMesage que precisamos
	 * adicionar na lista, e quando adicionarmos apenas istanciamos o FieldMessages e passamos o parametro..
	 * 
	 * @param fieldMessage
	 * @param message
	 */
	public void addErrors(String fieldMessage, String message) {
		this.errors.add(new FieldMessage(fieldMessage, message));
	}

}
