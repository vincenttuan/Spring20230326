package spring.core.session03.bean;

public class DBConn {
	public void init() {
		System.out.println("開啟資料庫連線...");
	}
	
	public void create() {
		System.out.println("新增...");
	}
	
	public void update() {
		System.out.println("修改...");
	}
	
	public void delete() {
		System.out.println("刪除...");
	}
	
	public void query() {
		System.out.println("查詢...");
	}
	
	public void destroy() {
		System.out.println("關閉資料庫連線...");
	}
}
