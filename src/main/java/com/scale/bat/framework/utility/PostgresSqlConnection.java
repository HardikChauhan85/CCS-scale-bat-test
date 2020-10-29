package com.scale.bat.framework.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class PostgresSqlConnection {

	private Logger log = Log.getLogger(PostgresSqlConnection.class);
 
	public void getConnections() {
	int lport=5656;
    String rhost="secure.journaldev.com";
    String host="secure.journaldev.com";
    int rport=3306;
    String user="sshuser";
    String password="sshpassword";
    String dbuserName = "mysql";
    String dbpassword = "mysql123";
    String url = "jdbc:mysql://localhost:"+lport+"/mydb";
    String driverName="com.mysql.jdbc.Driver";
    Connection conn = null;
    Session session= null;
    try{
    	//Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
    	java.util.Properties config = new java.util.Properties(); 
    	config.put("StrictHostKeyChecking", "no");
    	JSch jsch = new JSch();
    	session=jsch.getSession(user, host, 22);
    	session.setPassword(password);
    	session.setConfig(config);
    	session.connect();
    	log.info("Connected");
    	int assinged_port=session.setPortForwardingL(lport, rhost, rport);
        log.info("localhost:"+assinged_port+" -> "+rhost+":"+rport);
    	log.info("Port Forwarded");
    	//mysql database connectivity
        Class.forName(driverName).newInstance();
        conn = DriverManager.getConnection (url, dbuserName, dbpassword);
        log.info ("Database connection established");
        log.info("DONE");
    }catch(Exception e){
    	e.printStackTrace();
    }finally{
    	try {
			if(conn != null && !conn.isClosed()){
				log.info("Closing Database Connection");
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(session !=null && session.isConnected()){
    		log.info("Closing SSH Connection");
    		session.disconnect();
    	}
    }
}
	
	
	
	
}
