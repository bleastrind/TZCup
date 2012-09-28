package net.tiaozhanbei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tiaozhanbei.model.User;
import net.tiaozhanbei.dao.ILetterDAO;
import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.Letter;
import net.tiaozhanbei.service.ILetterService;
import net.tiaozhanbei.util.Page;

@Service("letterService")
public class LetterServiceImpl implements ILetterService {
	@Autowired
	private ILetterDAO letterDAO;
	@Autowired
	private IUserDAO userDAO;
	public void del(int id,String action) {
		Letter letter=letterDAO.findById(id);
		if(action.equals("send")){
			letter.setState(letter.getState()+2);
		}
		if(action.equals("send")){
			letter.setState(letter.getState()+1);
		}
		if(letter.getState()==3)
			letterDAO.delete(letter);
	}
	/*id  :�鿴��id  
	 *num :�鿴�ڼ�ҳ
	 */
	public List<Letter> receive(int id,int num){
		Page<Letter> page=new Page<Letter>(String.valueOf(num));
		page.setPageSize(6);
		User user = userDAO.findById(id);
		letterDAO.fillPage(page, "from Letter f where f.receiver=?",new Object[]{user});
		return page.getDataList();		
	}
	
	public List<Letter> receiveNew(int id,int num){
		Page<Letter> page=new Page<Letter>(String.valueOf(num));
		page.setPageSize(6);
		User user = userDAO.findById(id);
		letterDAO.fillPage(page, "from Letter f where f.receiver=? and f.checked=?",new Object[]{user,0});
		return page.getDataList();
	}
	//���������
	public void send(Letter letter) {

		
		User sender=(User)userDAO.findById(letter.getSender().getId());
		
		letter.setSender(sender);
		
		User receiver=(User)userDAO.findById(letter.getReceiver().getId());
		letter.setReceiver(receiver);

		
		letterDAO.save(letter);
	}
	
	public Letter view(Letter letter){
		
		letter=letterDAO.findById(letter.getId());
		letter.setChecked(1);
		return letter;
	}
	/*id  :�鿴��id  
	 *num :�鿴�ڼ�ҳ
	 */
	public List<Letter> send(int id, int num) {
		Page<Letter> page=new Page<Letter>(String.valueOf(num));
		page.setPageSize(6);
		User user = userDAO.findById(id);
		letterDAO.fillPage(page, "from Letter f where f.sender=?",new Object[]{user});

		return page.getDataList();		
	}

}
