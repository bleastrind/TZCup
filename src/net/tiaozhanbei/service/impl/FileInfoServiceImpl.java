/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tiaozhanbei.service.impl;

import net.tiaozhanbei.service.IFileInfoService;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.UserConst;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import common.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import net.tiaozhanbei.dao.IFileInfoDAO;
import net.tiaozhanbei.dao.IProjectDAO;
import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.FileInfo;
import net.tiaozhanbei.model.User;


/**
 *
 * @author Administrator
 */
public class FileInfoServiceImpl implements IFileInfoService{


	private static Logger logger = Logger.getLogger(FileInfoServiceImpl.class);

	private IFileInfoDAO fileInfoDAO;
    private IProjectDAO projectDAO;
    @Autowired
    private IUserDAO userDAO;

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public List<FileInfo> list_common(){ //admin涓婁紶鐨勪负鍏叡鏂囦欢
    	return fileInfoDAO.findByFileOwner(userDAO.findByUserName("admin"));
    }
    public List<FileInfo> list_project(int pro_id){//,int access){ //涓庨」鐩叧鑱旂殑鏂囦欢
    	List<FileInfo> list=fileInfoDAO.findByFileProject(projectDAO.findById(pro_id));
    	/*for(FileInfo file :list){
    		int acc=file.getAccess();
    		if((acc|access)==0){
    			list.remove(file);
    		}
    	}
    	*/
    	return list;
    }
    public List<FileInfo> list_author(int author_id){ //鐢辫浣滆�呬笂浼犵殑鏂囦欢鍒楄�?
        
        User user=userDAO.findById(author_id);
        
    	
        List<FileInfo> list=fileInfoDAO.findByFileOwner(user);
        return list;
    }
    public FileInfo download(int file_id){//灏嗘枃浠朵俊鎭繑鍥炵粰jsp椤甸潰杩涜涓嬭�?
    	return fileInfoDAO.findById(file_id); 
    }
    public void del(int file_id){//浠庣‖鐩樺垹闄ゆ枃浠讹紝骞朵粠鏁版嵁搴撳垹闄ゆ枃浠�
        FileInfo fileInfo= fileInfoDAO.findById(file_id);
    	File file=new File(fileInfo.getPath()+fileInfo.getName());
    	if(file.exists()){
    		file.delete();
    	}
        fileInfoDAO.delete(fileInfo); 
    }
    
    /*涓婁紶闇�瑕佸弬鏁�
     * fig=servelet.getServeletConfig
     * request
     * response
     * fileinfo 鍖呭惈浣滆�呭強鏉冮檺淇℃伅
     */
    public String upload(ServletConfig fig,HttpServletRequest req,HttpServletResponse res, FileInfo fileinfo) {
        try {
            SmartUpload fup = new SmartUpload();
            
            

            fup.initialize(fig,req,res);
            fup.setMaxFileSize(1024 * 1024 * 1024);
            fup.setTotalMaxFileSize(1024 * 1024 * 10);
            
            
            String uploadPath ="public\\";
            User user=fileinfo.getOwner();
            if(user!=null){
            if (user.getType() == 1) {
                
            	uploadPath ="public\\";
            	//fup.setAllowedFilesList("pdf,doc,docx,xls,xlsx,txt,rar,zip");
            }
            if (user.getType() == 3) {
                uploadPath = "user\\" + user.getName() + "\\";
            }
            }
       
            fup.upload();
            
            fileinfo.setName(fup.getFiles().getFile(0).getFileName());
            logger.info("fileName"+fileinfo.getName());      
            
           
            if(fileInfoDAO.findByFileName(fileinfo.getName()).size()>0){
                return "filename_exist";
            }
            
            //root:fig.getServletContext().getRealPath("/")
            File file=new File(fig.getServletContext().getRealPath("/")+"uploadFiles\\"+uploadPath);
            
            if(!file.exists()){
                logger.info("mkdir:"+file.mkdir());
            	logger.info("mkdir:"+fig.getServletContext().getRealPath("/")+"uploadFiles\\"+uploadPath);
            }
            fup.save(fig.getServletContext().getRealPath("/")+"uploadFiles\\"+uploadPath,SmartUpload.SAVE_PHYSICAL);
            fileinfo.setPath(uploadPath);
            logger.debug("fileinfo_path:"+fileinfo.getPath());
            
            if(user.getType()==1){
                fileinfo.setProject(null);
            }else{
            fileinfo.setProject(projectDAO.findById(Integer.parseInt(req.getParameter("proid"))));
            }
            

            
            //鎻掑叆鏁版嵁搴撲�?
            fileInfoDAO.save(fileinfo);
            return "success";
          }catch(SmartUploadException ex){
              ex.printStackTrace();
              return "smartupload_fail";
        }catch(ServletException ex){
             ex.printStackTrace();
             return "smartupload_fail";
        }catch(IOException ex){
             ex.printStackTrace();
             return "smartupload_fail";
        }catch(Exception ex){
        	ex.printStackTrace();
        	return "exception";
        }
    }

    public void Access(int id,int acc) {
      FileInfo  file=fileInfoDAO.findById(id);
      file.setAccess(acc);
      fileInfoDAO.attachDirty(file);
    }


	public IFileInfoDAO getFileInfoDAO() {
		return fileInfoDAO;
	}

	public void setFileInfoDAO(IFileInfoDAO fileInfoDAO) {
		this.fileInfoDAO = fileInfoDAO;
	}

	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void fillCommonFilePage(Page<FileInfo> page) {
		fileInfoDAO.fillPage(page, "select f from FileInfo f left join f.owner o where o.type=?",new Object[]{UserConst.Type.MANAGER});
		
	}


}