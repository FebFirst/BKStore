package action;

import java.io.*;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;  
import com.mongodb.gridfs.GridFSDBFile;  
import com.mongodb.gridfs.GridFSInputFile; 
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;  

import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.GenericXmlApplicationContext;

import model.User;
import model.Mongo;
import util.MongodbUtil;
public class FileUploadAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private Map<String ,Object> userSession;
	private String username;
	private File photo;
	private String fileFileName;
	private String fileContentType;
	private InputStream image;
	public String execute() throws Exception
	  {
		
//		System.out.println(username+ "mongo");
//        System.out.println(username+ "mongo");
//        System.out.println(username+ "mongo");
//        System.out.println(photo.getName()+ "---name");
//        System.out.println(photo.getPath()+ "---path");
        try{ 
            GridFS gridFS=null;
            if(username == null || username.length()<1){
           	 username= "feb";
            }
            ApplicationContext context = new GenericXmlApplicationContext(   
                    "applicationContext.xml");
            MongodbUtil util = (MongodbUtil)context.getBean("client");
            Mongo mg =(Mongo)context.getBean("db");
            gridFS=new GridFS(util.getMongodb(),mg.getTable()); 
            GridFSDBFile dbfile = gridFS.findOne(username.trim());
            if(dbfile!=null){
            	 System.out.println(dbfile.getFilename()+ "---removefilename");
            	gridFS.remove(dbfile);
            }
            dbfile = gridFS.findOne(username.trim()+".jpg");
            if(dbfile!=null){
            	System.out.println(dbfile.getFilename()+ "---removefilename");
            	gridFS.remove(dbfile);
            }
            GridFSInputFile  mongofile=gridFS.createFile(photo); 
            mongofile.setFilename(username.trim());
           // System.out.println(mongofile.getFilename()+ "---getname");
            
            mongofile.save(); 
           }catch (Exception e) {
               e.printStackTrace();
               System.out.println("error save image！！！");
           }
	       return SUCCESS;
	  }
	public String getFile() throws Exception
    {
		username = ((User)userSession.get("username")).getUsername();
	   if(username == null || username.length()<1){
		   System.out.println(username+ "---getusername");
		   return null;
	   }
	   try{
		   username = username.trim();
           DB db =MongodbUtil.getMongodb();
           GridFS gridFS = new GridFS(db,"img");
           GridFSDBFile dbfile = gridFS.findOne(username);
           //System.out.println(dbfile.getFilename()+ "---getfilename");
           if(dbfile == null)
        	   return null;
         // System.out.println(dbfile.getFilename()+ "---getfilename");
	   image = dbfile.getInputStream();
	  

       return SUCCESS;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
    }
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	
	
}
