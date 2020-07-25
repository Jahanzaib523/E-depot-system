package Depots;

public class Manager extends Driver{
	
    //Instantiating the manager class which has been extending 
	//from the driver class to include all of its attributes 
	public Manager (String userName, String passWord) {
		super(userName, passWord);
		
	}
	
	//Set Methods
	public void setUsernameMan(String userName) {
	    this.userName = userName;	
						
					}
				
	public void setPasswordMan(String passWord) {
	    this.passWord = passWord;	
					
				}
	
	//Get Methods
	public String getUsernameMan() {
	    return userName;	
			
			}
			
	public String getPasswordMan() {
	    return passWord;	
			
			}
	
	}