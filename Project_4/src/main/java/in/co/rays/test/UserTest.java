package in.co.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.UserModel;

public class UserTest {
	public static void main(String[] args) throws Exception {
	//	testAdd();
	//	testUpdate();
	//	testFindByPk();
	//	testdelete();
	//	testAuth();
		testSearch();
	}
	
	private static void testAdd() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		UserBean bean = new UserBean();
		
		bean.setFirstName("abc");
		bean.setLastName("xyz");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("4/1/2025"));
		bean.setAddress("indore");
		
		UserModel model = new UserModel();
		
		try {
			model.add(bean);
		}catch (DuplicateRecordException e) {
			// TODO: handle exception
			System.out.println("exception:" +e.getMessage());
		}
				
		
		
	}
	
	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		UserModel model = new UserModel();
		
		UserBean bean=model.findByPk(1);
		
		bean.setFirstName("Mohit");
		bean.setLastName("Gayke");
		bean.setLoginId("mohit@gmail.com");
		bean.setDob(new Date());
		
		model.update(bean);
		
	}
	
	private static void testFindByPk() {
		try {
			UserBean bean = new UserBean();
			UserModel model = new UserModel();
			
					bean = model.findByPk(1);
			
			if(bean == null) {
				System.out.println("test find by pk fail");
			}
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private static void testdelete() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean existBean = model.findByPk(2);
		
		if(existBean != null) {
			model.delete(existBean.getId());
			
		}else {
			System.out.println("Id not found...!!");
		}
	}
	
	private static void testAuth()throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean bean = model.authenticate("mohit@gmail.com", "123");
		
		if(bean != null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}else {
			System.out.println("login id & password is invalid..!!");
		}
		
	}
	
	private static void testSearch() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		UserBean bean = new UserBean();
		
	//	bean.setFirstName("m");
	//	bean.setDob(sdf.parse("5/1/2025"));
		
		UserModel model = new UserModel();
		
		List list = model.search(bean, 1, 5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (UserBean)it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}
	}

}
