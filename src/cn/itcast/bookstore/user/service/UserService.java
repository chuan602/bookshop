package cn.itcast.bookstore.user.service;

import cn.itcast.bookstore.user.dao.UserDao;
import cn.itcast.bookstore.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	/**
	 * 注册功能
	 * @param form
	 * @throws UserException 
	 */
	public void regist(User form) throws UserException{
		User user = userDao.findByUserName(form.getUsername());
		if(user!=null)throw new UserException("用户名以被注册");
		user = userDao.findByUserEmail(form.getEmail());
		if(user!=null)throw new UserException("该邮箱已被注册");
		userDao.add(form);
	}
	/**
	 * 激活功能
	 * @param code
	 * @throws UserException
	 */
	public void active(String code) throws UserException{
		User user = userDao.findByCode(code);
		if(user==null)throw new UserException("激活码无效");
		
		if(user.isState())throw new UserException("你已经激活过了,请不要重复激活!");
		userDao.updateState(user.getUid(), true);
		
	}
	
	public User login(User form) throws UserException{
		User user  = userDao.findByUserName(form.getUsername());
		if(user==null) throw new UserException("用户不存在");
		if(!user.getPassword().equals(form.getPassword()))throw new UserException("密码错误");
		if(!user.isState())throw new UserException("未激活状态,请先激活");
		
		return user;
	}
	
	
	
	
	
	
	
	
	
	
}
