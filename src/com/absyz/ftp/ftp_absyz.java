package com.absyz.ftp;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
public class ftp_absyz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String server = "absyz.com";
        int port = 21;
        String user = "salesforce@absyz.com";
        String pass = "Absyz@2017";
		
//		String server = "ftpservice.acesphere.com";
//        int port = 21;
//        String user = "rupeevest";
//        String pass = "Rup$02F16";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
           ftpClient.connect(server, port);
            System.out.println("FTP Connected");
            ftpClient.login(user, pass);
            System.out.println("Login Success");
           // ftpClient.enterRemotePassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
              // APPROACH #1: using retrieveFile(String, OutputStream)
//            String remoteFile1 = "/salesforce/salesforce_subfolder/123.txt";
//            File downloadFile1 = new File("E:/123.txt");
            /*String remoteFile1 = "/root/mutualfund/01052017/amc_aum.ace";
            File downloadFile1 = new File("E:/amc_aum.ace");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }*/
        	
//        	String remoteFile2 = "/root/mutualfund/18020216/divdetails.ace";
//            File downloadFile2 = new File("D:/divdetails.ace");
//            String remoteFile2 = "/mutualfund/01052017/amc_aum.ace";
//            File downloadFile2 = new File("E:/amc_aum.ace");
            String remoteFile2 = "/home/absyz/public_ftp/salesforce/salesforce_subfolder/123.txt";
            File downloadFile2 = new File("E:/123.txt");
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream2.write(bytesArray, 0, bytesRead);
            }
 
            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File #2 has been downloaded successfully.");
            }
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } 
        finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
                //outputStream2.close();
                //inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
	


