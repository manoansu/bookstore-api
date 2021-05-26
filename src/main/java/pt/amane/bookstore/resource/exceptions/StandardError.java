package pt.amane.bookstore.resource.exceptions;

public class StandardError {

	private Long timestemp;

	private Integer status;

	private String error;

	public StandardError() {
	}

	public StandardError(Long timestemp, Integer status, String messeger) {
		super();
		this.timestemp = timestemp;
		this.status = status;
		this.error = messeger;
	}

	public Long getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Long timestemp) {
		this.timestemp = timestemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMesseger() {
		return error;
	}

	public void setMesseger(String messeger) {
		this.error = messeger;
	}

}
