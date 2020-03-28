package enums;

public enum ContinentEnum {
	Asia("Asia"),Europe("Europe"),NorthAmerica("North America");
	
	String value;
	private ContinentEnum(String value) {
		this.value=value;
	}
	String getValue() {
		return this.value;
	}
}
