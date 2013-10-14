package com.socrata.datasync;

import java.util.prefs.Preferences;

public class UserPreferences {
	/**
	 * @author Adrian Laurenzi
	 * 
	 * This class manages the saved (global) user preferences.
	 */
	
	private static Preferences userPrefs;
	// Preference keys for saving user data
	private static final String DOMAIN = "domain";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String API_KEY = "api_key";
	
	private static final String ADMIN_EMAIL = "admin_email";
	private static final String EMAIL_UPON_ERROR = "email_upon_error";
	private static final String LOG_DATASET_ID = "log_dataset_id";
	
	private static final String OUTGOING_MAIL_SERVER = "outgoing_mail_server";
	private static final String SMTP_PORT = "smtp_port";
	
	// NOTE: if SSL port is set to the empty string then do not use SSL
	private static final String SSL_PORT = "ssl_port";
	private static final String SMTP_USERNAME = "smtp_username";
	private static final String SMTP_PASSWORD = "smtp_password";
	
	private final String DEFAULT_DOMAIN = "https://";
	private final String DEFAULT_SSL_PORT = "465";
    
	public UserPreferences() {
		userPrefs = Preferences.userRoot().node("SocrataIntegrationPrefs");
	}
	
	public void saveDomain(String domain) {
		userPrefs.put(DOMAIN, domain);
	}
	
	public void saveUsername(String username) {
		userPrefs.put(USERNAME, username);
	}
	
	public void savePassword(String password) {
		userPrefs.put(PASSWORD, password);
	}
	
	public void saveAPIKey(String apiKey) {
		userPrefs.put(API_KEY, apiKey);
	}
	
	public void saveAdminEmail(String adminEmail) {
		userPrefs.put(ADMIN_EMAIL, adminEmail);
	}
	
	public void saveEmailUponError(boolean emailUponError) {
		String prefString = "";
		if(emailUponError) {
			prefString = "YES";
		}
		userPrefs.put(EMAIL_UPON_ERROR, prefString);
	}
	
	public void saveLogDatasetID(String datasetID) {
		userPrefs.put(LOG_DATASET_ID, datasetID);
	}
	
	public void saveOutgoingMailServer(String mailServer) {
		userPrefs.put(OUTGOING_MAIL_SERVER, mailServer);
	}
	
	public void saveSMTPPort(String port) {
		userPrefs.put(SMTP_PORT, port);
	}
	
	public void saveSSLPort(String port) {
		userPrefs.put(SSL_PORT, port);
	}
	
	public void saveSMTPUsername(String username) {
		userPrefs.put(SMTP_USERNAME, username);
	}

	public void saveSMTPPassword(String password) {
		userPrefs.put(SMTP_PASSWORD, password);
	}
	
	public String getDomain() {
		return userPrefs.get(DOMAIN, DEFAULT_DOMAIN);
	}
	
	public String getUsername() {
		return userPrefs.get(USERNAME, "");
	}
	
	public String getPassword() {
		return userPrefs.get(PASSWORD, "");
	}
	
	public String getAPIKey() {
		return userPrefs.get(API_KEY, "");
	}
	
	public String getAdminEmail() {
		return userPrefs.get(ADMIN_EMAIL, "");
	}
	
	public boolean emailUponError() {
		String emailAdminPref = userPrefs.get(EMAIL_UPON_ERROR, "");
		return (!emailAdminPref.equals(""));
	}
	
	public String getLogDatasetID() {
		return userPrefs.get(LOG_DATASET_ID, "");
	}
	
	public String getOutgoingMailServer() {
		return userPrefs.get(OUTGOING_MAIL_SERVER, "");
	}
	
	public String getSMTPPort() {
		return userPrefs.get(SMTP_PORT, "");
	}
	
	public String getSSLPort() {
		return userPrefs.get(SSL_PORT, DEFAULT_SSL_PORT);
	}
	
	public String getSMTPUsername() {
		return userPrefs.get(SMTP_USERNAME, "");
	}

	public String getSMTPPassword() {
		return userPrefs.get(SMTP_PASSWORD, "");
	}
	
	public SocrataConnectionInfo getConnectionInfo()
	{
		String url = getDomain();
		String user = getUsername();
		String password = getPassword();
		String token = getAPIKey();
		return new SocrataConnectionInfo(url, user, password, token);
	}

}