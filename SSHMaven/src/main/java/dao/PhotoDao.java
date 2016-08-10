package dao;

import java.io.File;  
import java.util.List; 

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;  
import com.mongodb.gridfs.GridFSDBFile;  
import com.mongodb.gridfs.GridFSInputFile;  

import util.MongodbUtil;
public class PhotoDao {
	 public static void savePhoto(String user, File photo) throws Exception{  
         
        try{ 
         GridFS gridFS=null;
         if(user == null || user.length()<1){
        	 user = "feb";
         }
         System.out.println(user+ "mongo");
         System.out.println(user+ "mongo");
         System.out.println(user+ "mongo");
         gridFS=new GridFS(MongodbUtil.getMongodb(),"img");  
         GridFSInputFile  mongofile=gridFS.createFile(photo); 
         mongofile.setFilename(user);
         mongofile.save(); 
         System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error save image！！！");
        }
    }  
	 public static GridFSDBFile getPhoto(String user) {
	        try {
	        	System.out.println(user);
	        	user+=".jpg";
	            DB db =MongodbUtil.getMongodb();
	            GridFS gridFS = new GridFS(db,"img");
	            GridFSDBFile dbfile = gridFS.findOne(user);
	            if (dbfile != null) {
	                return dbfile;
	            }
	        } catch (Exception e) {
	        	 System.out.println("error get image！！！");
	        }
	        return null;
	    }
}
