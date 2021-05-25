package pt.amane.bookstore.exception;

public class StandardError {

	private Long timestemp;

	private Integer status;

	private String messeger;

	public StandardError() {
	}

	public StandardError(Long timestemp, Integer status, String messeger) {
		super();
		this.timestemp = timestemp;
		this.status = status;
		this.messeger = messeger;
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
		return messeger;
	}

	public void setMesseger(String messeger) {
		this.messeger = messeger;
	}

}
