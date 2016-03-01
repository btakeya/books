package books.model;

public class Title {
	private String korean;
	private String english;
	
	public Title(String korean, String english) {
		this.korean = korean;
		this.english = english;
	}
	
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	
	public String toString() {
		return  "Title: {\n" +
				  "Korean: " + korean + "\n" + 
				  "English: " + english + "\n" +
				"}";
	}
}
