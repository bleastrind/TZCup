/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tiaozhanbei.service;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.dao.IFileInfoDAO;
import net.tiaozhanbei.dao.IProjectDAO;
import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.FileInfo;
import net.tiaozhanbei.util.*;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author buaatw
 */
public interface IFileInfoService {
    @Transactional
    void del(int file_id);

    FileInfo download(int file_id);

    @Transactional
    void Access(int id,int acc);

    IFileInfoDAO getFileInfoDAO();

    IProjectDAO getProjectDAO();

    IUserDAO getUserDAO();

    List<FileInfo> list_author(int author_id);

    List<FileInfo> list_common();

    List<FileInfo> list_project(int pro_id);

    void setFileInfoDAO(IFileInfoDAO fileInfoDAO);

    void setProjectDAO(IProjectDAO projectDAO);

    void setUserDAO(IUserDAO userDAO);
    
    void fillCommonFilePage(Page<FileInfo> page);
    
    @Transactional
    String upload(ServletConfig fig,HttpServletRequest req,HttpServletResponse res, FileInfo fileinfo);

}
