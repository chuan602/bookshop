package cn.itcast.bookstore.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.user.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();
/**
 * 按姓名查找
 * @param username
 * @return
 */
	public User findByUserName(String username) {

		try {
			String sql = "select * from tb_user where username =?";
			return qr.query(sql, new BeanHandler<User>(User.class), username);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
/**
 * 按邮箱查找
 * @param email
 * @return
 */
	public User findByUserEmail(String email) {
		try {
			String sql = "select* from tb_user where email =?";
			return qr.query(sql, new BeanHandler<User>(User.class),email);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
/**
 * 插入用户
 * @param user
 */
	public void add(User user) {
		try {
			String sql = "insert into tb_user value(?,?,?,?,?,?)";
			Object[] params = { user.getUid(), user.getUsername(),
					user.getPassword(), user.getEmail(), user.getCode(),
					user.isState() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
/**
 * 按激活码查找	
 * @param code
 * @return
 */
	public User findByCode(String code){
		
		try{
			String sql ="select * from tb_user where code=?";
			return qr.query(sql, new BeanHandler<User>(User.class),code);
		}catch(SQLException e ){
			throw new RuntimeException(e);
		}
	}
/**
 * 通过查找激活码的到User,进而得到UID,再修改state激活状态
 * @param uid
 * @param state
 */
	public void updateState(String uid,boolean state){
		try{
			String sql = "update tb_user set state =? where uid =?";
			qr.update(sql,state,uid);
		}catch(SQLException e ){
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
