package pageUIs.vnexpress;

public class Login_Page_UI {

	public static final String LOGIN_LINK = "xpath=//a[@title='Đăng nhập']";
	public static final String LOGIN_EMAIL_TITLE = "xpath=//p";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@name='myvne_email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@type='password']";
	
	public static final String EMAIL_ERR_TEXT = "xpath=//span[@id='error_myvne_email']";
	
	public static final String PASSWORD_ERR_TEXT = "xpath=//span[@id='error_myvne_password']";
	public static final String LOGIN_BUTTON = "xpath=//button[text()='Đăng nhập']";
	public static final String LOGIN_POPUP = "xpath=//div[contains(@class,'content_log')]";
	
	
	public static final String IFRAME_POPUP = "xpath=//iframe[contains(@class,'mfp-iframe')]";
	public static final String USER_AVATAR = "xpath=//span[@class='avatar_inner']/following-sibling::span[contains(text(),'%s')]";
	
}
